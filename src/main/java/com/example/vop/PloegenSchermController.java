package com.example.vop;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

import java.time.LocalDate;
import java.util.List;


public class PloegenSchermController {
    private final PageHandler m_pagehandler = new PageHandler();
    @FXML
    public Button Startknop;
    @FXML
    public Button Ledenknop;
    @FXML
    public Button Coachesknop;
    @FXML
    public Button ToevoegenPloegKnop;
    @FXML
    public Button VerwijderPloegKnop;
    @FXML
    public Button WijzigPloegKnop;
    @FXML
    public TableView<Tennisclub> ploegenTabel;

    public ToevoegScherm toevoegScherm;
    public VeranderScherm veranderScherm;

    private void openVeranderScherm(Tennisclub tennisclub) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/veranderploeg.fxml"));
        try {
            Parent root = loader.load();

            veranderScherm = loader.getController();
            veranderScherm.start(tennisclub, ploegenTabel);

            Stage stage = new Stage();
            stage.setTitle("Tennisclub De Mol: verander Ploeg " + tennisclub.getClubnaam());
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void openToevoegScherm() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/toevoegploeg.fxml"));
        try {
            Parent root = loader.load();

            toevoegScherm = loader.getController();
            toevoegScherm.startVoorTennisClub(ploegenTabel);

            Stage stage = new Stage();
            stage.setTitle("Tennisclub De Mol: toevoegen Ploeg");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void maakNieuweKolomAanVoorBestaandePloegAan(Tennisclub tennisclub, TableView<Tennisclub> tabel, int index) {
        TableColumn<Tennisclub, Image> clubfoto = new TableColumn<>("Foto");
        clubfoto.setPrefWidth(100);
        TableColumn<Tennisclub, String> naam = new TableColumn<>("Naam");
        naam.setPrefWidth(100);
        TableColumn<Tennisclub, String> manager = new TableColumn<>("Manager");
        manager.setPrefWidth(100);
        TableColumn<Tennisclub, String> locatie = new TableColumn<>("Locatie");
        locatie.setPrefWidth(100);
        TableColumn<Tennisclub, String> telefoonnummer = new TableColumn<>("Telefoonnummer");
        telefoonnummer.setPrefWidth(100);

        tabel.getColumns().addAll(clubfoto, naam, manager, locatie, telefoonnummer);

        clubfoto.setCellValueFactory(celldata -> {
            Tennisclub lokaleclub = celldata.getValue();
            Image image = new Image(new File(lokaleclub.getClubfoto()).toURI().toString());
            return new SimpleObjectProperty<>(image);
        });

        clubfoto.setCellFactory(kolom -> new TableCell<>(){
            private final ImageView foto = new ImageView();

            {
                foto.setFitWidth(60);
                foto.setFitHeight(60);
            }

            @Override
            protected void updateItem(Image clubfoto, boolean empty) {
                super.updateItem(clubfoto, empty);
                if (empty || clubfoto == null) {
                    setGraphic(null);
                } else {
                    foto.setImage(clubfoto);
                    setGraphic(foto);
                }
            }
        });

        naam.setCellValueFactory(celldata -> {
            Tennisclub lokaleclub = celldata.getValue();
            String tekst = new String(lokaleclub.getClubnaam());
            return new SimpleObjectProperty<>(tekst);
        });

        manager.setCellValueFactory(celldata -> {
            Tennisclub lokaleclub = celldata.getValue();
            String tekst = new String(lokaleclub.getClubmanager());
            return new SimpleObjectProperty<>(tekst);
        });

        locatie.setCellValueFactory(celldata -> {
            Tennisclub lokaleclub = celldata.getValue();
            String tekst = new String(lokaleclub.getLocatie());
            return new SimpleObjectProperty<>(tekst);
        });

        telefoonnummer.setCellValueFactory(celldata -> {
            Tennisclub lokaleclub = celldata.getValue();
            return new SimpleObjectProperty<>(lokaleclub.getTelefoonnummer());
        });

        tabel.setItems(Variables.getInstance().getLijstMetTennisclubs());
    }

    @FXML
    public void initialize() {
        System.out.println(Variables.getInstance().getLijstMetSpelers());

        if (!Variables.getInstance().getLijstMetSpelers().isEmpty()) {
            ploegenTabel.getColumns().clear();

            List<Tennisclub> tennisclubs = Variables.getInstance().getLijstMetTennisclubs();
            for(int i = 0; i < tennisclubs.size(); i++) {
                Tennisclub tennisclub = tennisclubs.get(i);
                maakNieuweKolomAanVoorBestaandePloegAan(tennisclub, ploegenTabel, i);
            }
        }

        //Toevoegknop
        ToevoegenPloegKnop.setOnAction(event -> {
            try {
                openToevoegScherm();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        //Veranderknop
        WijzigPloegKnop.setOnAction(event -> {
            Tennisclub tennisclub = ploegenTabel.getSelectionModel().getSelectedItem();
            if (tennisclub != null) {
                try {
                    openVeranderScherm(tennisclub);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Je moet eerst een Ploeg kiezen voordat je verder kunt gaan.");
            }
        });

        //Verwijderknop
        VerwijderPloegKnop.setOnAction(event -> {
            Tennisclub tennisclub = ploegenTabel.getSelectionModel().getSelectedItem();
            if (tennisclub != null) {
                Variables.getInstance().verwijderTennisclubVanLijst(tennisclub);
                ploegenTabel.getItems().remove(tennisclub);
            } else {
                System.out.println("Je moet eerst een ploeg kiezen voordat je ze kunt verwijderen.");
            }
        });
    }

    public void PloegenschermGaNaarStartscherm(ActionEvent event) throws IOException {
        m_pagehandler.getPageFromEventSource(event);
        m_pagehandler.veranderPagina("Startscherm");
        m_pagehandler.toonPagina();
    }

    public void PloegenschermGaNaarPloegenscherm(ActionEvent event) throws IOException {
        m_pagehandler.getPageFromEventSource(event);
        m_pagehandler.veranderPagina("Ledenscherm");
        m_pagehandler.toonPagina();
    }

    public void PloegenschermGaNaarCoachesscherm(ActionEvent event) throws IOException {
        m_pagehandler.getPageFromEventSource(event);
        m_pagehandler.veranderPagina("Coachesscherm");
        m_pagehandler.toonPagina();
    }
}
