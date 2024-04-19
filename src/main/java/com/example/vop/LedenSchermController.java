package com.example.vop;

import com.example.ext.Speler;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.ext.*;

public class LedenSchermController implements Initializable {
    private final PageHandler m_pagehandler = new PageHandler();
    private ObservableList<Speler> m_spelers;

    public Button Startknop, Ploegenknop, Coachesknop, VoegLidToeKnop, VerwijderLidKnop;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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

    public static Stage maakLidDetailScherm(Speler speler) {
        Stage spelerDetailStage = new Stage();
        VBox spelerDetailContainer = new VBox(5);
        spelerDetailContainer.setPadding(new Insets(10));

        Label voornaamLabel = new Label("Voornaam: " + speler.getPersoon().getNaam());
        Label achternaamLabel = new Label("Achternaam: " + speler.getPersoon().getAchternaam());
        Label leeftijdLabel = new Label("Leeftijd: " + speler.getPersoon().getLeeftijd());
        Label geslachtLabel = new Label("Geslacht: " + speler.getGeslacht());
        Label adresLabel = new Label("Adres: " + speler.getPersoon().getAdres());

        Button sluitenKnop = new Button("Sluiten");
        sluitenKnop.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                spelerDetailStage.close();
            };
        });
        spelerDetailContainer.getChildren().addAll(voornaamLabel, achternaamLabel,
                leeftijdLabel, geslachtLabel, adresLabel, sluitenKnop);
        spelerDetailStage.setTitle("Detail van lid '" + speler.getPersoon().getNaam() + "'");
        spelerDetailStage.setScene(new Scene(spelerDetailContainer, 250, 150));
        return(spelerDetailStage);
    };
}
