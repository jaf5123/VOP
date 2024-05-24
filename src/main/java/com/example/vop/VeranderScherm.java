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

public class VeranderScherm {
    public Button VeranderKnop;
    public TextField VeranderFoto;
    public Button folderKnop;

    // Speler
    public TextField VeranderLidNaam;
    public TextField VeranderLidAchternaam;
    public TextField VeranderLidAdres;
    public TextField VeranderLidLeeftijd;
    public TextField VeranderLidGeslacht;
    public TextField VeranderLidErvaring;
    public DatePicker VeranderLidLidSinds;
    public DatePicker VeranderLidGeboorteDatum;

    // Tennisclub
    public TextField VeranderClubNaam;
    public ChoiceBox<String> VeranderClubManager;
    public ChoiceBox<String> VeranderClubLeden;
    public TextField VeranderClubLocatie;
    public TextField VeranderClubTelefoonnummer;
    public TextField VeranderClubOpeningsuur;
    public TextField VeranderClubSluitingsuur;
    public Trainer gekozenCoach = null;

    // Trainer
    public TextField VeranderCoachNaam;
    public TextField VeranderCoachAchternaam;
    public TextField VeranderCoachSpecialiteit;
    public TextField VeranderCoachErvaring;
    public DatePicker VeranderCoachWerktSinds;
    public TextField VeranderCoachGeslacht;
    public TextField VeranderCoachLeeftijd;
    public TextField VeranderCoachAdres;
    public DatePicker VeranderCoachGeboorteDatum;

    // Wedstrijd
    public DatePicker VeranderWedstrijdDatum;
    public TextField VeranderWedstrijdStarttijd;
    public TextField VeranderWedstrijdEindtijd;
    public ChoiceBox<String> VeranderWedstrijdTrainer;
    public TextField VeranderWedstrijdBaan;

    public TableView<Speler> spelersTabel;
    public TableView<Tennisclub> tennisclubTabel;
    public TableView<Trainer> trainerTabel;
    public TableView<Training> wedstrijdTabel;
    private int index;

    private void setZoekBestandViaFolder() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecteer een bestand");

        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            String bestandInFolder = file.getPath();
            VeranderFoto.setText(bestandInFolder);
        } else {
            System.out.println("Geen bestand geselecteerd.");
        }
    }

    @FXML
    public void initialize() {
        folderKnop.setOnAction(event -> setZoekBestandViaFolder());

        VeranderKnop.setOnAction(event -> {
            if (spelersTabel != null) {
                Persoon veranderPersoon = new Persoon(VeranderLidNaam.getText(), VeranderLidAchternaam.getText(), Integer.valueOf(VeranderLidLeeftijd.getText()), VeranderLidAdres.getText(), VeranderLidGeboorteDatum.getValue());
                Ervaring veranderErvaring = Ervaring.GEEN;

                switch (VeranderLidErvaring.getText()) {
                    case "Amateur" -> veranderErvaring = Ervaring.AMATEUR;
                    case "Ervaren" -> veranderErvaring = Ervaring.ERVAREN;
                    case "Expert" -> veranderErvaring = Ervaring.EXPERT;
                    default -> veranderErvaring = Ervaring.GEEN;
                }

                Speler veranderSpeler = new Speler(veranderPersoon, VeranderLidGeslacht.getText(), VeranderLidLidSinds.getValue(), veranderErvaring, VeranderFoto.getText());
                Variables.getInstance().verwijderSpelerVanLijstOpIndex(index);
                Variables.getInstance().voegSpelerToAanLijst(veranderSpeler);

                spelersTabel.getItems().set(index, veranderSpeler);
                spelersTabel.refresh();
            } else if (tennisclubTabel != null) {
                ArrayList<Speler> lokaleSpelerList = new ArrayList<>();

                Tennisclub veranderClub = new Tennisclub(
                        gekozenCoach != null ? gekozenCoach.getPersoon().getNaam() + " " + gekozenCoach.getPersoon().getAchternaam() : "Geen manager gekozen",
                        VeranderClubNaam.getText(),
                        VeranderClubLocatie.getText(),
                        VeranderClubTelefoonnummer.getText(),
                        LocalTime.parse(VeranderClubOpeningsuur.getText()),
                        LocalTime.parse(VeranderClubSluitingsuur.getText()),
                        VeranderFoto.getText()
                );

                // Insert everything into the tennisclub object
                for (Speler speler : lokaleSpelerList) {
                    if (speler != null) {
                        veranderClub.voegSpelerToeAanLijst(speler);
                    }
                }

                if (gekozenCoach != null) {
                    veranderClub.voegTrainerToeAanLijst(gekozenCoach);
                }


                Variables.getInstance().verwijderTennisclubVanLijstOpIndex(index);
                Variables.getInstance().voegTennisclubToAanLijst(veranderClub);

                tennisclubTabel.getItems().set(index, veranderClub);
                tennisclubTabel.refresh();
            } else if (trainerTabel != null) {
                Persoon veranderPersoon = new Persoon(VeranderCoachNaam.getText(), VeranderCoachAchternaam.getText(), Integer.valueOf(VeranderCoachLeeftijd.getText()), VeranderCoachAdres.getText(), VeranderCoachGeboorteDatum.getValue());
                Ervaring veranderErvaring = Ervaring.GEEN;

                switch (VeranderCoachErvaring.getText()) {
                    case "Amateur" -> veranderErvaring = Ervaring.AMATEUR;
                    case "Ervaren" -> veranderErvaring = Ervaring.ERVAREN;
                    case "Expert" -> veranderErvaring = Ervaring.EXPERT;
                    default -> veranderErvaring = Ervaring.GEEN;
                }

                Trainer veranderTrainer = new Trainer(veranderPersoon, VeranderCoachSpecialiteit.getText(), VeranderCoachGeslacht.getText(), VeranderCoachWerktSinds.getValue(), veranderErvaring, VeranderFoto.getText());

                Variables.getInstance().verwijderTrainerVanLijstOpIndex(index);
                Variables.getInstance().voegTrainerToAanLijst(veranderTrainer);

                trainerTabel.getItems().set(index, veranderTrainer);
                trainerTabel.refresh();
            } else if (wedstrijdTabel != null) {
                LocalTime starttijd = LocalTime.parse(VeranderWedstrijdStarttijd.getText());
                LocalTime eindtijd = LocalTime.parse(VeranderWedstrijdEindtijd.getText());
                Trainer trainer = null;

                String trainerNaam = VeranderWedstrijdTrainer.getValue();
                for (int i = 0; i < Variables.getInstance().getLijstMetTrainers().size(); i++) {
                    if (Variables.getInstance().getTrainerOpIndexInLijst(i).getPersoon().getNaam().equals(trainerNaam)) {
                        trainer = Variables.getInstance().getTrainerOpIndexInLijst(i);
                        break;
                    }
                }

                Tennisbaan baan = new Tennisbaan(Integer.parseInt(VeranderWedstrijdBaan.getText()), true);

                Training veranderWedstrijd = new Training(VeranderWedstrijdDatum.getValue(), starttijd, eindtijd, trainer, baan);

                Variables.getInstance().verwijderTrainingVanLijstOpIndex(index);
                Variables.getInstance().voegTrainingToAanLijst(veranderWedstrijd);

                wedstrijdTabel.getItems().set(index, veranderWedstrijd);
                wedstrijdTabel.refresh();
            }

            Stage stage = (Stage) VeranderKnop.getScene().getWindow();
            stage.close();
        });
    }

    // Spelers
    public void startVoorSpeler(TableView<Speler> spelerTabel, int index) {
        this.spelersTabel = spelerTabel;
        this.index = index;

        Speler speler = Variables.getInstance().getSpelerOpIndexInLijst(index);

        VeranderLidNaam.setText(speler.getPersoon().getNaam());
        VeranderLidAchternaam.setText(speler.getPersoon().getAchternaam());
        VeranderLidAdres.setText(speler.getPersoon().getAdres());
        VeranderLidLeeftijd.setText(String.valueOf(speler.getPersoon().getLeeftijd()));
        VeranderLidGeslacht.setText(speler.getGeslacht());
        VeranderLidErvaring.setText(speler.getErvaring().toString());
        VeranderLidLidSinds.setValue(speler.getLid_sinds());
        VeranderLidGeboorteDatum.setValue(speler.getPersoon().getGeboortedatum());
        VeranderFoto.setText(speler.getFoto());
    }

    // Ploegen
    public void startVoorTennisClub(TableView<Tennisclub> tennisclubTabel, int index) {
        this.tennisclubTabel = tennisclubTabel;
        this.index = index;

        Tennisclub tennisclub = Variables.getInstance().getTennisclubOpIndexInLijst(index);

        VeranderClubNaam.setText(tennisclub.getClubnaam());
        VeranderClubLocatie.setText(tennisclub.getLocatie());
        VeranderClubTelefoonnummer.setText(tennisclub.getTelefoonnummer());
        VeranderClubOpeningsuur.setText(tennisclub.getOpeningsuur().toString());
        VeranderClubSluitingsuur.setText(tennisclub.getSluitingsuur().toString());
        VeranderFoto.setText(tennisclub.getClubfoto());

        ObservableList<String> lokaleSpelerListNamen = FXCollections.observableArrayList();
        ObservableList<String> lokaleCoachListNamen = FXCollections.observableArrayList();

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
            }
        }

        VeranderClubLeden.setItems(lokaleSpelerListNamen);
        VeranderClubManager.setItems(lokaleCoachListNamen);

        VeranderClubManager.setValue(tennisclub.getClubmanager());
    }

    // Trainers
    public void startVoorTrainer(TableView<Trainer> trainerTabel, int index) {
        this.trainerTabel = trainerTabel;
        this.index = index;

        Trainer trainer = Variables.getInstance().getTrainerOpIndexInLijst(index);

        VeranderCoachNaam.setText(trainer.getPersoon().getNaam());
        VeranderCoachAchternaam.setText(trainer.getPersoon().getAchternaam());
        VeranderCoachAdres.setText(trainer.getPersoon().getAdres());
        VeranderCoachLeeftijd.setText(String.valueOf(trainer.getPersoon().getLeeftijd()));
        VeranderCoachGeslacht.setText(trainer.getGeslacht());
        VeranderCoachErvaring.setText(trainer.getErvaring().toString());
        VeranderCoachWerktSinds.setValue(trainer.getWerkt_sinds());
        VeranderCoachGeboorteDatum.setValue(trainer.getPersoon().getGeboortedatum());
        VeranderFoto.setText(trainer.getFoto());
    }

    // Wedstrijden
    public void startVoorWedstrijd(TableView<Training> wedstrijdTabel, int index) {
        this.wedstrijdTabel = wedstrijdTabel;
        this.index = index;

        Training training = Variables.getInstance().getTrainingOpIndexInLijst(index);

        VeranderWedstrijdDatum.setValue(training.getDatum());
        VeranderWedstrijdStarttijd.setText(training.getStart_om().toString());
        VeranderWedstrijdEindtijd.setText(training.getEindigt_om().toString());
        VeranderWedstrijdBaan.setText(String.valueOf(training.getTennisbaan().getBaannummer()));

        ObservableList<String> lokaleCoachListNamen = FXCollections.observableArrayList();

        // Fill the coaches choicebox with the names of the coaches.
        if (!Variables.getInstance().getLijstMetTrainers().isEmpty()) {
            for (int i = 0; i < Variables.getInstance().getLijstMetTrainers().size(); i++) {
                lokaleCoachListNamen.add(Variables.getInstance().getTrainerOpIndexInLijst(i).getPersoon().getNaam());
            }
        }

        VeranderWedstrijdTrainer.setItems(lokaleCoachListNamen);
        VeranderWedstrijdTrainer.setValue(training.getAfgesprokenTrainer().getPersoon().getNaam());
    }

    public void setGekozenCoach(Trainer coach) {
        gekozenCoach = coach;
    }
}
