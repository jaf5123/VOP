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


public class LedenSchermController {
    private final PageHandler m_pagehandler = new PageHandler();
    @FXML
    public Button Startknop;
    @FXML
    public Button Ploegenknop;
    @FXML
    public Button Coachesknop;
    @FXML
    public Button ToevoegenLidKnop;
    @FXML
    public Button VerwijderLidKnop;
    @FXML
    public Button WijzigLidKnop;
    @FXML
    public TableView<Speler> spelersTabel;

    public ToevoegScherm toevoegScherm;
    public VeranderScherm veranderScherm;

    private void openVeranderScherm(Speler speler) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/veranderspeler.fxml"));
        try {
            Parent root = loader.load();

            veranderScherm = loader.getController();
            veranderScherm.start(speler, spelersTabel);

            Stage stage = new Stage();
            stage.setTitle("Tennisclub De Mol: verander lid " + speler.getPersoon().getNaam() + " " + speler.getPersoon().getAchternaam());
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void openToevoegScherm() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/toevoegspeler.fxml"));
        try {
            Parent root = loader.load();

            toevoegScherm = loader.getController();
            toevoegScherm.startVoorSpeler(spelersTabel);

            Stage stage = new Stage();
            stage.setTitle("Tennisclub De Mol: toevoegen lid");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void maakNieuweKolomAanVoorBestaandeSpelerAan(Speler speler, TableView<Speler> tabel, int index) {
        TableColumn<Speler, Image> profielfoto = new TableColumn<>("Foto");
        profielfoto.setPrefWidth(110);
        TableColumn<Speler, String> naam = new TableColumn<>("Naam");
        naam.setPrefWidth(110);
        TableColumn<Speler, String> achternaam = new TableColumn<>("Achternaam");
        achternaam.setPrefWidth(110);
        TableColumn<Speler, String> adres = new TableColumn<>("adres");
        adres.setPrefWidth(110);
        TableColumn<Speler, LocalDate> lid_sinds = new TableColumn<>("Lid sinds");
        lid_sinds.setPrefWidth(110);

        spelersTabel.getColumns().addAll(profielfoto, naam, achternaam, adres, lid_sinds);

        profielfoto.setCellValueFactory(celldata -> {
            Speler lokaleLid = celldata.getValue();
            Image image = new Image(new File(lokaleLid.getFoto()).toURI().toString());
            return new SimpleObjectProperty<>(image);
        });

        profielfoto.setCellFactory(kolom -> new TableCell<>(){
            private final ImageView foto = new ImageView();

            {
                foto.setFitWidth(60);
                foto.setFitHeight(60);
            }

            @Override
            protected void updateItem(Image profielfoto, boolean empty) {
                super.updateItem(profielfoto, empty);
                if (empty || profielfoto == null) {
                    setGraphic(null);
                } else {
                    foto.setImage(profielfoto);
                    setGraphic(foto);
                }
            }
        });

        naam.setCellValueFactory(celldata -> {
            Speler lokaleLid = celldata.getValue();
            String tekst = new String(lokaleLid.getPersoon().getNaam());
            return new SimpleObjectProperty<>(tekst);
        });

        achternaam.setCellValueFactory(celldata -> {
            Speler lokaleLid = celldata.getValue();
            String tekst = new String(lokaleLid.getPersoon().getAchternaam());
            return new SimpleObjectProperty<>(tekst);
        });

        adres.setCellValueFactory(celldata -> {
            Speler lokaleLid = celldata.getValue();
            String tekst = new String(lokaleLid.getPersoon().getAdres());
            return new SimpleObjectProperty<>(tekst);
        });

        lid_sinds.setCellValueFactory(celldata -> {
            Speler lokaleLid = celldata.getValue();
            return new SimpleObjectProperty<>(lokaleLid.getLid_sinds());
        });

        spelersTabel.setItems(Variables.getInstance().getLijstMetSpelers());
    }

    @FXML
    public void initialize() {
        System.out.println(Variables.getInstance().getLijstMetSpelers());

        if (!Variables.getInstance().getLijstMetSpelers().isEmpty()) {
            spelersTabel.getColumns().clear();

            List<Speler> spelers = Variables.getInstance().getLijstMetSpelers();
            for(int i = 0; i < spelers.size(); i++) {
                Speler speler = spelers.get(i);
                maakNieuweKolomAanVoorBestaandeSpelerAan(speler, spelersTabel, i);
            }
        }

        //Toevoegknop
        ToevoegenLidKnop.setOnAction(event -> {
            try {
                openToevoegScherm();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        //Veranderknop
        WijzigLidKnop.setOnAction(event -> {
            Speler speler = spelersTabel.getSelectionModel().getSelectedItem();
            if (speler != null) {
                try {
                    openVeranderScherm(speler);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Je moet eerst een lid kiezen voordat je verder kunt gaan.");
            }
        });

        //Verwijderknop
        VerwijderLidKnop.setOnAction(event -> {
            Speler speler = spelersTabel.getSelectionModel().getSelectedItem();
            if (speler != null) {
                Variables.getInstance().verwijderSpelerVanLijst(speler);
                spelersTabel.getItems().remove(speler);
            } else {
                System.out.println("Je moet eerst een lid kiezen voordat je ze kunt verwijderen.");
            }
        });
    }

    public void LedenschermGaNaarStartscherm(ActionEvent event) throws IOException {
        m_pagehandler.getPageFromEventSource(event);
        m_pagehandler.veranderPagina("Startscherm");
        m_pagehandler.toonPagina();
    }

    public void LedenschermGaNaarPloegenscherm(ActionEvent event) throws IOException {
        m_pagehandler.getPageFromEventSource(event);
        m_pagehandler.veranderPagina("Ploegenscherm");
        m_pagehandler.toonPagina();
    }

    public void LedenschermGaNaarCoachesscherm(ActionEvent event) throws IOException {
        m_pagehandler.getPageFromEventSource(event);
        m_pagehandler.veranderPagina("Coachesscherm");
        m_pagehandler.toonPagina();
    }
}
