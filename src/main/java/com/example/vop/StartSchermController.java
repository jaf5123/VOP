package com.example.vop;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class StartSchermController {
    private final PageHandler m_handler = new PageHandler();
    public Button LedenschermKnop, PloegenschermKnop, CoachesschermKnop, WedstrijdenschermKnop;
    @FXML
    private TableView<Speler> ledenTabel;

    private void maakKolomVoorLedenAan(TableView<Speler> ledenTabel, Speler speler) {
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

        ledenTabel.getColumns().addAll(profielfoto, naam, achternaam, adres, lid_sinds);

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

        ledenTabel.setItems(Variables.getInstance().getLijstMetSpelers());
    }

    @FXML
    public void initialize() {
        if (Variables.getInstance().getLijstMetSpelers() == null) {
            ObservableList<Speler> lijstMetSpelers = FXCollections.observableArrayList();
            Variables.getInstance().setLijstMetSpelers(lijstMetSpelers);
        } else {
            ledenTabel.getColumns().clear();

            List<Speler> spelers = Variables.getInstance().getLijstMetSpelers();
            for (int i = 0; i < spelers.size(); i++) {
                Speler speler = spelers.get(i);
                maakKolomVoorLedenAan(ledenTabel, speler);
            }
        }

        if (Variables.getInstance().getLijstMetTrainers() == null) {
            ObservableList<Trainer> lijstMetTrainers = FXCollections.observableArrayList();
            Variables.getInstance().setLijstMetTrainers(lijstMetTrainers);
        };

        if (Variables.getInstance().getLijstMetTennisclubs() == null) {
            ObservableList<Tennisclub> lijstMetTennisclubs = FXCollections.observableArrayList();
            Variables.getInstance().setLijstMetTennisclubs(lijstMetTennisclubs);
        };

        if (Variables.getInstance().getLijstMetWedstrijden() == null) {
            ObservableList<Training> lijstMetWedstrijden = FXCollections.observableArrayList();
            Variables.getInstance().setLijstMetWedstrijden(lijstMetWedstrijden);
        };

        System.out.println(Variables.getInstance().getLijstMetSpelers());
    };

    public void StartSchermGaNaarLedenScherm(ActionEvent event) throws IOException {
        m_handler.getPageFromEventSource(event);
        m_handler.veranderPagina("Ledenscherm");
        m_handler.toonPagina();
    }

    public void StartSchermGaNaarPloegenScherm(ActionEvent event) throws IOException {
        m_handler.getPageFromEventSource(event);
        m_handler.veranderPagina("Ploegenscherm");
        m_handler.toonPagina();
    }

    public void StartSchermGaNaarCoachesScherm(ActionEvent event) throws IOException {
        m_handler.getPageFromEventSource(event);
        m_handler.veranderPagina("Coachesscherm");
        m_handler.toonPagina();
    }

    public void StartSchermGaNaarWedstrijdenScherm(ActionEvent event) throws IOException {
        m_handler.getPageFromEventSource(event);
        m_handler.veranderPagina("Wedstrijdenscherm");
        m_handler.toonPagina();
    }
}
