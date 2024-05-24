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
    public TextField ToevoegClubFoto;
    public Trainer gekozenCoach = null;

    public TableView<Speler> spelersTabel;
    public TableView<Tennisclub> tennisclubTabel;
    public TableView<Trainer> trainerTabel;

    private void setZoekBestandViaFolder() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecteer een bestand");

        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            String bestandInFolder = file.getPath();
            ToevoegFoto.setText(bestandInFolder);
        } else {
            System.out.println("Geen bestand geselecteerd.");
        };
    };

    @FXML
    public void initialize() {
        folderKnop.setOnAction(event -> setZoekBestandViaFolder());

        ToevoegKnop.setOnAction(event -> {
            if (spelersTabel != null) {
                Persoon nieuwPersoon = new Persoon(ToevoegLidNaam.getText(), ToevoegLidAchternaam.getText(), Integer.valueOf(ToevoegLidLeeftijd.getText()), ToevoegLidAdres.getText(), ToevoegLidGeboorteDatum.getValue());
                Ervaring nieuwErvaring = Ervaring.GEEN;

                switch (ToevoegLidErvaring.getText()) {
                    case "Amateur" -> nieuwErvaring = Ervaring.AMATEUR;
                    case "Ervaren" -> nieuwErvaring = Ervaring.ERVAREN;
                    case "Expert" -> nieuwErvaring = Ervaring.EXPERT;
                    default -> nieuwErvaring = Ervaring.GEEN;
                };

                Speler nieuwSpeler = new Speler(nieuwPersoon, ToevoegLidGeslacht.getText(), ToevoegLidLidSinds.getValue(), nieuwErvaring, ToevoegFoto.getText());
                Variables.getInstance().voegSpelerToAanLijst(nieuwSpeler);
                spelersTabel.getItems().add(nieuwSpeler);
                spelersTabel.refresh();
            } else if (tennisclubTabel != null) {
                ArrayList<Speler> lokaleSpelerList = new ArrayList<>();

                Tennisclub nieuweClub = new Tennisclub(
                        gekozenCoach != null ? gekozenCoach.getPersoon().getNaam() + " " + gekozenCoach.getPersoon().getAchternaam() : "Geen coach gekozen",
                        ToevoegClubNaam.getText(),
                        ToevoegClubLocatie.getText(),
                        ToevoegClubTelefoonnummer.getText(),
                        LocalTime.parse(ToevoegClubOpeningsuur.getText()),
                        LocalTime.parse(ToevoegClubSluitingsuur.getText()),
                        ToevoegClubFoto.getText()
                );

                // Insert everything into the tennisclub object
                for (Speler speler : lokaleSpelerList) {
                    if (speler != null) {
                        nieuweClub.voegSpelerToeAanLijst(speler);
                    };
                };

                if (gekozenCoach != null) {
                    nieuweClub.voegTrainerToeAanLijst(gekozenCoach);
                };

                Variables.getInstance().voegTennisclubToAanLijst(nieuweClub);
                tennisclubTabel.getItems().add(nieuweClub);
                tennisclubTabel.refresh();
            } else if (trainerTabel != null) {

            };

            Stage stage = (Stage) ToevoegKnop.getScene().getWindow();
            stage.close();
        });
    };

    //Spelers
    public void startVoorSpeler(TableView<Speler> spelerTabel) {
        this.spelersTabel = spelerTabel;
    };

    //Ploegen
    public void startVoorTennisClub(TableView<Tennisclub> tennisclubTabel) {
        this.tennisclubTabel = tennisclubTabel;

        ObservableList<String> lokaleSpelerListNamen = FXCollections.observableArrayList();
        ObservableList<String> lokaleCoachListNamen = FXCollections.observableArrayList();
        ArrayList<Speler> lokaleSpelerList = new ArrayList<>();

        // Fill the coaches choicebox with the names of the coaches.
        if (!Variables.getInstance().getLijstMetTrainers().isEmpty()) {
            for (int i = 0; i < Variables.getInstance().getLijstMetTrainers().size(); i++) {
                lokaleCoachListNamen.add(Variables.getInstance().getTrainerOpIndexInLijst(i).getPersoon().getNaam());
            };
        };

        // Fill the player choicebox with the names of the players.
        if (!Variables.getInstance().getLijstMetSpelers().isEmpty()) {
            for (int i = 0; i < Variables.getInstance().getLijstMetSpelers().size(); i++) {
                lokaleSpelerListNamen.add(Variables.getInstance().getSpelerOpIndexInLijst(i).getPersoon().getNaam());
            };
        };

        // Choicebox for coaches.
        ToevoegClubManager.setItems(lokaleCoachListNamen);
        ToevoegClubManager.setOnAction(manager_event -> {
            String manager_naam = ToevoegClubManager.getValue();
            if (manager_naam != null) {
                for (int i = 0; i < Variables.getInstance().getLijstMetTrainers().size(); i++) {
                    Trainer trainer = Variables.getInstance().getTrainerOpIndexInLijst(i);
                    if (trainer.getPersoon().getNaam().equals(manager_naam)) {
                        gekozenCoach = trainer;
                        break;
                    };
                };
            };
        });

        // Choicebox for players.
        ToevoegClubLeden.setItems(lokaleSpelerListNamen);
        ToevoegClubLeden.setOnAction(lid_event -> {
            String lid_naam = ToevoegClubLeden.getValue();
            if (lid_naam != null) {
                for (int i = 0; i < Variables.getInstance().getLijstMetSpelers().size(); i++) {
                    Speler speler = Variables.getInstance().getSpelerOpIndexInLijst(i);
                    if (speler.getPersoon().getNaam().equals(lid_naam)) {
                        lokaleSpelerList.add(speler);
                        break;
                    };
                };
            };
        });
    };

    //Coaches
    public void startVoorTrainer(TableView<Trainer> coachesTabel) {
        this.trainerTabel = coachesTabel;
    };
};