package com.example.vop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartSchermController /*implements Initializable*/ {
    private final PageHandler m_handler = new PageHandler();
    public Button LedenschermKnop, PloegenschermKnop, CoachesschermKnop, WedstrijdenschermKnop;
    @FXML
    private VBox LangstKomendeLedenLijst;
    /*private

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for () {

        }
    };*/

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
