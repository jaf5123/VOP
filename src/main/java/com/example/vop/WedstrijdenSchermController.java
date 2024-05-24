package com.example.vop;

import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class WedstrijdenSchermController {
    private final PageHandler m_pagehandler = new PageHandler();
    @FXML
    public Button Startknop;
    @FXML
    public Button Ledenknop;
    @FXML
    public Button Coachesknop;
    @FXML
    public Button ToevoegenWedstrijdKnop;
    @FXML
    public Button VerwijderWedstrijdKnop;
    @FXML
    public Button WijzigWedstrijdKnop;
    @FXML
    public TableView<Training> wedstrijdenTabel;

    public ToevoegScherm toevoegScherm;
    public VeranderScherm veranderScherm;

    private void openVeranderScherm(Training training) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/veranderwedstrijd.fxml"));
        Parent root = loader.load();

        veranderScherm = loader.getController();

        int index = Variables.getInstance().getIndexVanTrainingInLijst(training);

        veranderScherm = loader.getController();
        veranderScherm.startVoorWedstrijd(wedstrijdenTabel, index);

        Stage stage = new Stage();
        stage.setTitle("Tennisclub De Mol: verander wedstrijd");
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    private void openToevoegScherm() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/toevoegwedstrijd.fxml"));
        Parent root = loader.load();

        toevoegScherm = loader.getController();
        toevoegScherm.startVoorWedstrijd(wedstrijdenTabel);

        Stage stage = new Stage();
        stage.setTitle("Tennisclub De Mol: toevoegen wedstrijd");
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    private void maakNieuweKolomAanVoorBestaandeWedstrijd(Training training, TableView<Training> tabel, int index) {
        TableColumn<Training, LocalDate> datum = new TableColumn<>("Datum");
        datum.setPrefWidth(100);
        TableColumn<Training, LocalTime> startOm = new TableColumn<>("Start Om");
        startOm.setPrefWidth(100);
        TableColumn<Training, LocalTime> eindigtOm = new TableColumn<>("Eindigt Om");
        eindigtOm.setPrefWidth(100);
        TableColumn<Training, String> trainer = new TableColumn<>("Trainer");
        trainer.setPrefWidth(100);
        TableColumn<Training, String> baan = new TableColumn<>("Baan");
        baan.setPrefWidth(100);

        tabel.getColumns().addAll(datum, startOm, eindigtOm, trainer, baan);

        datum.setCellValueFactory(celldata -> new SimpleObjectProperty<>(celldata.getValue().getDatum()));
        startOm.setCellValueFactory(celldata -> new SimpleObjectProperty<>(celldata.getValue().getStart_om()));
        eindigtOm.setCellValueFactory(celldata -> new SimpleObjectProperty<>(celldata.getValue().getEindigt_om()));
        trainer.setCellValueFactory(celldata -> new SimpleObjectProperty<>(celldata.getValue().getAfgesprokenTrainer().getPersoon().getNaam()));
        baan.setCellValueFactory(celldata -> new SimpleObjectProperty<>(String.valueOf(celldata.getValue().getTennisbaan().getBaannummer())));

        tabel.setItems(Variables.getInstance().getLijstMetTrainingen());
    }

    @FXML
    public void initialize() {
        System.out.println(Variables.getInstance().getLijstMetTrainingen());

        if (!Variables.getInstance().getLijstMetTrainingen().isEmpty()) {
            wedstrijdenTabel.getColumns().clear();

            List<Training> trainingen = Variables.getInstance().getLijstMetTrainingen();
            for (int i = 0; i < trainingen.size(); i++) {
                Training training = trainingen.get(i);
                maakNieuweKolomAanVoorBestaandeWedstrijd(training, wedstrijdenTabel, i);
            }
        }

        // Toevoegknop
        ToevoegenWedstrijdKnop.setOnAction(event -> {
            try {
                openToevoegScherm();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        // Veranderknop
        WijzigWedstrijdKnop.setOnAction(event -> {
            Training training = wedstrijdenTabel.getSelectionModel().getSelectedItem();
            if (training != null) {
                try {
                    openVeranderScherm(training);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Je moet eerst een wedstrijd kiezen voordat je verder kunt gaan.");
            }
        });

        // Verwijderknop
        VerwijderWedstrijdKnop.setOnAction(event -> {
            Training training = wedstrijdenTabel.getSelectionModel().getSelectedItem();
            if (training != null) {
                Variables.getInstance().verwijderTrainingVanLijst(training);
                wedstrijdenTabel.getItems().remove(training);
            } else {
                System.out.println("Je moet eerst een wedstrijd kiezen voordat je deze kunt verwijderen.");
            }
        });
    }

    public void WedstrijdenschermGaNaarStartscherm(ActionEvent event) throws IOException {
        m_pagehandler.getPageFromEventSource(event);
        m_pagehandler.veranderPagina("Startscherm");
        m_pagehandler.toonPagina();
    }

    public void WedstrijdenschermGaNaarLedenscherm(ActionEvent event) throws IOException {
        m_pagehandler.getPageFromEventSource(event);
        m_pagehandler.veranderPagina("Ledenscherm");
        m_pagehandler.toonPagina();
    }

    public void WedstrijdenschermGaNaarCoachesscherm(ActionEvent event) throws IOException {
        m_pagehandler.getPageFromEventSource(event);
        m_pagehandler.veranderPagina("Coachesscherm");
        m_pagehandler.toonPagina();
    }
}
