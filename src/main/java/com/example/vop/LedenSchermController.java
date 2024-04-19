package com.example.vop;

import com.example.ext.Speler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LedenSchermController implements Initializable {
    private final PageHandler m_pagehandler = new PageHandler();
    private ArrayList<Speler> m_spelers;

    public Button Startknop, Ploegenknop, Coachesknop, VoegLidToeKnop, VerwijderLidKnop;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        m_spelers = new ArrayList<>();
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

        Label gebruikersnaamLabel = new Label("Gebruikersnaam: " + speler.());

        Label voornaamLabel = new Label("Voornaam: " + speler.getVoornaam());

        Label familienaamLabel = new Label("Familienaam: " + speler.getFamilienaam());

        Label emailLabel = new Label("E-mail: " + speler.getEmail());

        Label aantalKinderenLabel = new Label("Aantal kinderen: " + speler.getAantalKinderen());

        Button sluitenKnop = new Button("Sluiten");
        sluitenKnop.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                spelerDetailStage.close();
            }
        });
        spelerDetailContainer.getChildren().addAll(gebruikersnaamLabel, voornaamLabel,
                familienaamLabel, emailLabel, aantalKinderenLabel, sluitenKnop);
        spelerDetailStage.setTitle("Detail van lid");
        spelerDetailStage.setScene(new Scene(spelerDetailContainer, 250, 150));
        return(spelerDetailStage);
    }
}
