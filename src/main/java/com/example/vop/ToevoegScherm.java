package com.example.vop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.time.LocalTime;
import java.util.ArrayList;

public class ToevoegScherm {
    public Button ToevoegKnop;
    public TextField ToevoegFoto;
    public Button folderKnop;

    // Speler
    public TextField ToevoegLidNaam;
    public TextField ToevoegLidAchternaam;
    public TextField ToevoegLidAdres;
    public TextField ToevoegLidLeeftijd;
    public TextField ToevoegLidGeslacht;
    public TextField ToevoegLidErvaring;
    public DatePicker ToevoegLidLidSinds;
    public DatePicker ToevoegLidGeboorteDatum;

    // Tennisclub
    public TextField ToevoegClubNaam;
    public ChoiceBox<String> ToevoegClubManager;
    public ChoiceBox<String> ToevoegClubLeden;
    public TextField ToevoegClubLocatie;
    public TextField ToevoegClubTelefoonnummer;
    public TextField ToevoegClubOpeningsuur;
    public TextField ToevoegClubSluitingsuur;
    public Trainer gekozenCoach = null;

    // Trainer
    public TextField ToevoegCoachNaam;
    public TextField ToevoegCoachAchternaam;
    public TextField ToevoegCoachSpecialiteit;
    public TextField ToevoegCoachErvaring;
    public DatePicker ToevoegCoachWerktSinds;
    public TextField ToevoegCoachGeslacht;
    public TextField ToevoegCoachLeeftijd;
    public TextField ToevoegCoachAdres;
    public DatePicker ToevoegCoachGeboorteDatum;

    // Wedstrijd
    public DatePicker ToevoegWedstrijdDatum;
    public TextField ToevoegWedstrijdStarttijd;
    public TextField ToevoegWedstrijdEindtijd;
    public ChoiceBox<String> ToevoegWedstrijdTrainer;
    public TextField ToevoegWedstrijdBaan;

    public TableView<Speler> spelersTabel;
    public TableView<Tennisclub> tennisclubTabel;
    public TableView<Trainer> trainerTabel;
    public TableView<Training> wedstrijdTabel;

    private void setZoekBestandViaFolder() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecteer een bestand");

        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            String bestandInFolder = file.getPath();
            ToevoegFoto.setText(bestandInFolder);
        } else {
            System.out.println("Geen bestand geselecteerd.");
        }
    }

    @FXML
    public void initialize() {
        ToevoegKnop.setOnAction(event -> {
            if (spelersTabel != null) {
                Persoon nieuwPersoon = new Persoon(ToevoegLidNaam.getText(), ToevoegLidAchternaam.getText(), Integer.valueOf(ToevoegLidLeeftijd.getText()), ToevoegLidAdres.getText(), ToevoegLidGeboorteDatum.getValue());
                Ervaring nieuwErvaring = Ervaring.GEEN;

                switch (ToevoegLidErvaring.getText()) {
                    case "Amateur" -> nieuwErvaring = Ervaring.AMATEUR;
                    case "Ervaren" -> nieuwErvaring = Ervaring.ERVAREN;
                    case "Expert" -> nieuwErvaring = Ervaring.EXPERT;
                    default -> nieuwErvaring = Ervaring.GEEN;
                }

                Speler nieuwSpeler = new Speler(nieuwPersoon, ToevoegLidGeslacht.getText(), ToevoegLidLidSinds.getValue(), nieuwErvaring, ToevoegFoto.getText());
                Variables.getInstance().voegSpelerToAanLijst(nieuwSpeler);
                spelersTabel.getItems().add(nieuwSpeler);
                spelersTabel.refresh();
            } else if (tennisclubTabel != null) {
                ArrayList<Speler> lokaleSpelerList = new ArrayList<>();

                Tennisclub nieuweClub = new Tennisclub(
                        gekozenCoach != null ? gekozenCoach.getPersoon().getNaam() + " " + gekozenCoach.getPersoon().getAchternaam() : "Geen manager gekozen",
                        ToevoegClubNaam.getText(),
                        ToevoegClubLocatie.getText(),
                        ToevoegClubTelefoonnummer.getText(),
                        LocalTime.parse(ToevoegClubOpeningsuur.getText()),
                        LocalTime.parse(ToevoegClubSluitingsuur.getText()),
                        ToevoegFoto.getText()
                );

                // Insert everything into the tennisclub object
                for (Speler speler : lokaleSpelerList) {
                    if (speler != null) {
                        nieuweClub.voegSpelerToeAanLijst(speler);
                    }
                }

                if (gekozenCoach != null) {
                    nieuweClub.voegTrainerToeAanLijst(gekozenCoach);
                }

                Variables.getInstance().voegTennisclubToAanLijst(nieuweClub);
                tennisclubTabel.getItems().add(nieuweClub);
                tennisclubTabel.refresh();
            } else if (trainerTabel != null) {
                Persoon nieuwPersoon = new Persoon(ToevoegCoachNaam.getText(), ToevoegCoachAchternaam.getText(), Integer.valueOf(ToevoegCoachLeeftijd.getText()), ToevoegCoachAdres.getText(), ToevoegCoachGeboorteDatum.getValue());
                Ervaring nieuwErvaring = Ervaring.GEEN;

                switch (ToevoegCoachErvaring.getText()) {
                    case "Amateur" -> nieuwErvaring = Ervaring.AMATEUR;
                    case "Ervaren" -> nieuwErvaring = Ervaring.ERVAREN;
                    case "Expert" -> nieuwErvaring = Ervaring.EXPERT;
                    default -> nieuwErvaring = Ervaring.GEEN;
                }

                Trainer nieuwTrainer = new Trainer(nieuwPersoon, ToevoegCoachSpecialiteit.getText(), ToevoegCoachGeslacht.getText(), ToevoegCoachWerktSinds.getValue(), nieuwErvaring, ToevoegFoto.getText());
                Variables.getInstance().voegTrainerToAanLijst(nieuwTrainer);
                trainerTabel.getItems().add(nieuwTrainer);
                trainerTabel.refresh();
            } else if (wedstrijdTabel != null) {
                LocalTime starttijd = LocalTime.parse(ToevoegWedstrijdStarttijd.getText());
                LocalTime eindtijd = LocalTime.parse(ToevoegWedstrijdEindtijd.getText());
                Trainer trainer = null;

                String trainerNaam = ToevoegWedstrijdTrainer.getValue();
                for (int i = 0; i < Variables.getInstance().getLijstMetTrainers().size(); i++) {
                    if (Variables.getInstance().getTrainerOpIndexInLijst(i).getPersoon().getNaam().equals(trainerNaam)) {
                        trainer = Variables.getInstance().getTrainerOpIndexInLijst(i);
                        break;
                    }
                }

                Tennisbaan baan = new Tennisbaan(Integer.parseInt(ToevoegWedstrijdBaan.getText()), true);

                Training nieuweWedstrijd = new Training(ToevoegWedstrijdDatum.getValue(), starttijd, eindtijd, trainer, baan);

                Variables.getInstance().voegTrainingToAanLijst(nieuweWedstrijd);
                wedstrijdTabel.getItems().add(nieuweWedstrijd);
                wedstrijdTabel.refresh();
            }

            Stage stage = (Stage) ToevoegKnop.getScene().getWindow();
            stage.close();
        });
    }

    // Spelers
    public void startVoorSpeler(TableView<Speler> spelerTabel) {
        folderKnop.setOnAction(event -> setZoekBestandViaFolder());
        this.spelersTabel = spelerTabel;
    }

    // Ploegen
    public void startVoorTennisClub(TableView<Tennisclub> tennisclubTabel) {
        folderKnop.setOnAction(event -> setZoekBestandViaFolder());
        this.tennisclubTabel = tennisclubTabel;

        ObservableList<String> lokaleSpelerListNamen = FXCollections.observableArrayList();
        ObservableList<String> lokaleCoachListNamen = FXCollections.observableArrayList();
        ArrayList<Speler> lokaleSpelerList = new ArrayList<>();

        // Fill the coaches choicebox with the names of the coaches.
        if (!Variables.getInstance().getLijstMetTrainers().isEmpty()) {
            for (int i = 0; i < Variables.getInstance().getLijstMetTrainers().size(); i++) {
                lokaleCoachListNamen.add(Variables.getInstance().getTrainerOpIndexInLijst(i).getPersoon().getNaam());
            }
        }

        // Fill the player choicebox with the names of the players.
        if (!Variables.getInstance().getLijstMetSpelers().isEmpty()) {
            for (int i = 0; i < Variables.getInstance().getLijstMetSpelers().size(); i++) {
                lokaleSpelerListNamen.add(Variables.getInstance().getSpelerOpIndexInLijst(i).getPersoon().getNaam());
                lokaleSpelerList.add(Variables.getInstance().getSpelerOpIndexInLijst(i));
            }
        }

        ToevoegClubLeden.setItems(lokaleSpelerListNamen);
        ToevoegClubManager.setItems(lokaleCoachListNamen);
    }

    // Trainers
    public void startVoorTrainer(TableView<Trainer> trainerTabel) {
        folderKnop.setOnAction(event -> setZoekBestandViaFolder());
        this.trainerTabel = trainerTabel;
    }

    // Wedstrijden
    public void startVoorWedstrijd(TableView<Training> wedstrijdTabel) {
        this.wedstrijdTabel = wedstrijdTabel;

        ObservableList<String> lokaleCoachListNamen = FXCollections.observableArrayList();

        // Fill the coaches choicebox with the names of the coaches.
        if (!Variables.getInstance().getLijstMetTrainers().isEmpty()) {
            for (int i = 0; i < Variables.getInstance().getLijstMetTrainers().size(); i++) {
                lokaleCoachListNamen.add(Variables.getInstance().getTrainerOpIndexInLijst(i).getPersoon().getNaam());
            }
        }

        ToevoegWedstrijdTrainer.setItems(lokaleCoachListNamen);
    }

    public void setGekozenCoach(Trainer coach) {
        gekozenCoach = coach;
    }
}
