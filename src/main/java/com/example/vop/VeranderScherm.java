package com.example.vop;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class VeranderScherm {
    public Button folderKnop;
    public Button VeranderKnop;

    public TextField VeranderLidAdres;
    public TextField VeranderLidAchternaam;
    public TextField VeranderLidNaam;
    public TextField VeranderLidLeeftijd;
    public TextField VeranderLidErvaring;
    public TextField VeranderLidGeslacht;
    public DatePicker VeranderLidGeboorteDatum;
    public DatePicker VeranderLidLidSinds;
    public TextField VeranderFoto;

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

    }

    public void start(Speler speler, TableView<Speler> tabel) {
        folderKnop.setOnAction(event -> {
            setZoekBestandViaFolder();
        });

        int indexInLijst = Variables.getInstance().getIndexVanSpelerInLijst(speler);

        String ervaringInTekst = new String();

        switch(speler.getErvaring()) {
            case AMATEUR -> {
                ervaringInTekst = "Amateur";
            }
            case ERVAREN -> {
                ervaringInTekst = "Ervaren";
            }
            case EXPERT -> {
                ervaringInTekst = "Expert";
            }
            case null, default -> {
                ervaringInTekst = "Geen Ervaring";
            }
        }

        VeranderLidNaam.setText(speler.getPersoon().getNaam()); VeranderLidAchternaam.setText(speler.getPersoon().getAchternaam());
        VeranderLidAdres.setText(speler.getPersoon().getAdres()); VeranderLidGeslacht.setText(speler.getGeslacht());
        VeranderLidGeboorteDatum.setValue(speler.getPersoon().getGeboortedatum()); VeranderLidErvaring.setText(ervaringInTekst);
        VeranderLidLeeftijd.setText(String.valueOf(speler.getPersoon().getLeeftijd())); VeranderLidLidSinds.setValue(speler.getLid_sinds());

        VeranderKnop.setOnAction(event -> {
            Speler old = Variables.getInstance().getSpelerOpIndexInLijst(indexInLijst);
            Persoon nieuwPersoon = new Persoon(VeranderLidNaam.getText(), VeranderLidAchternaam.getText(), Integer.valueOf(VeranderLidLeeftijd.getText()), VeranderLidAdres.getText(), VeranderLidGeboorteDatum.getValue());
            Ervaring nieuwErvaring = Ervaring.GEEN;

            switch(VeranderLidErvaring.getText()) {
                case "Amateur" -> {
                    nieuwErvaring = Ervaring.AMATEUR;
                    break;
                }
                case "Ervaren" -> {
                    nieuwErvaring = Ervaring.ERVAREN;
                    break;
                }
                case "Expert" -> {
                    nieuwErvaring = Ervaring.EXPERT;
                    break;
                }
                case null, default -> {
                    nieuwErvaring = Ervaring.GEEN;
                    break;
                }
            }

            old.setPersoon(nieuwPersoon); old.setFoto(VeranderFoto.getText());
            old.setErvaring(nieuwErvaring); old.setGeslacht(VeranderLidGeslacht.getText());
            old.setLid_sinds(VeranderLidLidSinds.getValue());

            tabel.refresh();

            Stage stage = (Stage) VeranderKnop.getScene().getWindow();
            stage.close();
        });
    };

    public void start(Tennisclub tennisclub, TableView<Tennisclub> tabel) {

    }
}
