package com.example.vop;

import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class CoachesschermController {
    private final PageHandler m_pagehandler = new PageHandler();
    @FXML
    public Button Startknop;
    @FXML
    public Button Ploegenknop;
    @FXML
    public Button Wedstrijdknop;
    @FXML
    public Button ToevoegenCoachKnop;
    @FXML
    public Button VerwijderCoachKnop;
    @FXML
    public Button WijzigCoachKnop;
    @FXML
    public TableView<Trainer> coachesTabel;

    public ToevoegScherm toevoegScherm;
    public VeranderScherm veranderScherm;

    private void openVeranderScherm(Trainer trainer) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/fxml/verandercoach.fxml")));
        Parent root = loader.load();

        int index = Variables.getInstance().getIndexVanTrainerInLijst(trainer);

        veranderScherm = loader.getController();
        veranderScherm.startVoorTrainer(coachesTabel, index);

        Stage stage = new Stage();
        stage.setTitle("Tennisclub De Mol: verander coach " + trainer.getPersoon().getNaam() + " " + trainer.getPersoon().getAchternaam());
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    private void openToevoegScherm() throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/fxml/toevoegcoach.fxml")));
        Parent root = loader.load();

        toevoegScherm = loader.getController();
        toevoegScherm.startVoorTrainer(coachesTabel);

        Stage stage = new Stage();
        stage.setTitle("Tennisclub De Mol: toevoegen coach");
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    private void maakNieuweKolomAanVoorBestaandeCoachAan(Trainer trainer, TableView<Trainer> tabel, int index) {
        TableColumn<Trainer, Image> profielfoto = new TableColumn<>("Foto");
        profielfoto.setPrefWidth(110);
        TableColumn<Trainer, String> naam = new TableColumn<>("Naam");
        naam.setPrefWidth(110);
        TableColumn<Trainer, String> achternaam = new TableColumn<>("Achternaam");
        achternaam.setPrefWidth(110);
        TableColumn<Trainer, String> specialiteit = new TableColumn<>("Specialiteit");
        specialiteit.setPrefWidth(110);
        TableColumn<Trainer, LocalDate> werkt_sinds = new TableColumn<>("Werkt sinds");
        werkt_sinds.setPrefWidth(110);

        coachesTabel.getColumns().addAll(profielfoto, naam, achternaam, specialiteit, werkt_sinds);

        profielfoto.setCellValueFactory(celldata -> {
            Trainer lokaleTrainer = celldata.getValue();
            Image image = new Image(new File(lokaleTrainer.getFoto()).toURI().toString());
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
            Trainer lokaleTrainer = celldata.getValue();
            String tekst = new String(lokaleTrainer.getPersoon().getNaam());
            return new SimpleObjectProperty<>(tekst);
        });

        achternaam.setCellValueFactory(celldata -> {
            Trainer lokaleTrainer = celldata.getValue();
            String tekst = new String(lokaleTrainer.getPersoon().getAchternaam());
            return new SimpleObjectProperty<>(tekst);
        });

        specialiteit.setCellValueFactory(celldata -> {
            Trainer lokaleTrainer = celldata.getValue();
            String tekst = new String(lokaleTrainer.getSpecialiteit());
            return new SimpleObjectProperty<>(tekst);
        });

        werkt_sinds.setCellValueFactory(celldata -> {
            Trainer lokaleTrainer = celldata.getValue();
            return new SimpleObjectProperty<>(lokaleTrainer.getWerkt_sinds());
        });

        coachesTabel.setItems(Variables.getInstance().getLijstMetTrainers());
    }

    @FXML
    public void initialize() {
        System.out.println(Variables.getInstance().getLijstMetTrainers());

        if (!Variables.getInstance().getLijstMetTrainers().isEmpty()) {
            coachesTabel.getColumns().clear();

            List<Trainer> trainers = Variables.getInstance().getLijstMetTrainers();
            for (int i = 0; i < trainers.size(); i++) {
                Trainer trainer = trainers.get(i);
                maakNieuweKolomAanVoorBestaandeCoachAan(trainer, coachesTabel, i);
            }
        }

        //Toevoegknop
        ToevoegenCoachKnop.setOnAction(event -> {
            try {
                openToevoegScherm();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        //Veranderknop
        WijzigCoachKnop.setOnAction(event -> {
            Trainer trainer = coachesTabel.getSelectionModel().getSelectedItem();
            if (trainer != null) {
                try {
                    openVeranderScherm(trainer);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Je moet eerst een coach kiezen voordat je verder kunt gaan.");
            }
        });

        //Verwijderknop
        VerwijderCoachKnop.setOnAction(event -> {
            Trainer trainer = coachesTabel.getSelectionModel().getSelectedItem();
            if (trainer != null) {
                Variables.getInstance().verwijderTrainerVanLijst(trainer);
                coachesTabel.getItems().remove(trainer);
            } else {
                System.out.println("Je moet eerst een coach kiezen voordat je ze kunt verwijderen.");
            }
        });
    }

    public void CoachesschermGaNaarStartscherm(ActionEvent event) throws IOException {
        m_pagehandler.getPageFromEventSource(event);
        m_pagehandler.veranderPagina("Startscherm");
        m_pagehandler.toonPagina();
    }

    public void CoachesschermGaNaarPloegenscherm(ActionEvent event) throws IOException {
        m_pagehandler.getPageFromEventSource(event);
        m_pagehandler.veranderPagina("Ploegenscherm");
        m_pagehandler.toonPagina();
    }

    public void CoachesschermGaNaarWedstrijdenscherm(ActionEvent event) throws IOException {
        m_pagehandler.getPageFromEventSource(event);
        m_pagehandler.veranderPagina("Wedstrijdenscherm");
        m_pagehandler.toonPagina();
    }
}