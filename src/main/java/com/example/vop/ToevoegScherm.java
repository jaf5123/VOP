package com.example.vop;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.time.LocalDate;

public class ToevoegScherm {
    public Button ToevoegKnop;
    public TextField ToevoegFoto;
    public Button folderKnop;

    //Speler
    public TextField ToevoegLidNaam;
    public TextField ToevoegLidAchternaam;
    public TextField ToevoegLidAdres;
    public TextField ToevoegLidLeeftijd;
    public TextField ToevoegLidGeslacht;
    public TextField ToevoegLidErvaring;
    public DatePicker ToevoegLidLidSinds;
    public DatePicker ToevoegLidGeboorteDatum;

    //Trainer

    //Ploeg

    //Wedstrijd


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

    };

    private void maakNieuweTabelVoorSpelerAan(TableView<Speler> tabel) {
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

        tabel.getColumns().addAll(profielfoto, naam, achternaam, adres, lid_sinds);

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

        tabel.setItems(Variables.getInstance().getLijstMetSpelers());
    }

    public void startVoorSpeler(TableView<Speler> spelerTabel) {
        folderKnop.setOnAction(event -> {
            setZoekBestandViaFolder();
        });

        ToevoegKnop.setOnAction(event -> {
            Persoon nieuwPersoon = new Persoon(ToevoegLidNaam.getText(), ToevoegLidAchternaam.getText(), Integer.valueOf(ToevoegLidLeeftijd.getText()), ToevoegLidAdres.getText(), ToevoegLidGeboorteDatum.getValue());
            Ervaring nieuwErvaring = Ervaring.GEEN;

            switch(ToevoegLidErvaring.getText()) {
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
            };

            Speler nieuwSpeler = new Speler(nieuwPersoon, ToevoegLidGeslacht.getText(), ToevoegLidLidSinds.getValue(), nieuwErvaring, ToevoegFoto.getText());
            Variables.getInstance().voegSpelerToAanLijst(nieuwSpeler);
            spelerTabel.getItems().add(nieuwSpeler);

            Stage stage = (Stage) ToevoegKnop.getScene().getWindow();
            stage.close();
        });
    };

    public void startVoorTennisClub(TableView<Tennisclub> tennisclubTabel) {

    }
}
