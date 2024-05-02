package com.example.vop;

//JavaFX
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;

//Standard IO
import java.io.*;
import java.util.Objects;

public class PageHandler {
    @FXML
    private Stage m_stage;
    @FXML
    private Scene m_scene;
    @FXML
    private Parent m_root;
    private double m_width = 0.0d, m_height = 0.0d;
    private String m_title, m_css;

    public PageHandler() {
        m_stage = null; m_title = "De Mol - tennisclub, gelegen in Duffel";
        m_width = 960; m_height = 650;
    };

    public PageHandler(Stage stage, String title, double screen_width, double screen_height) {
        m_stage = stage; m_title = title;
        m_width = screen_width; m_height = screen_height;
        m_stage.setTitle(title); m_stage.centerOnScreen();
    };

    public void veranderPagina(String pagina) {
        try {
            switch (pagina) {
                case "Ledenscherm":
                    m_root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/ledenscherm.fxml")));
                    m_scene = new Scene(m_root);
                    m_css = getClass().getResource("/css/ledenscherm.css").toExternalForm();
                    m_scene.getStylesheets().add(m_css);
                    m_stage.setScene(m_scene);
                    break;
                case "Coachesscherm":
                    m_root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/coachesscherm.fxml")));
                    m_scene = new Scene(m_root);
                    m_css = getClass().getResource("/css/coachesscherm.css").toExternalForm();
                    m_scene.getStylesheets().add(m_css);
                    m_stage.setScene(m_scene);
                    break;
                case "Ploegenscherm":
                    m_root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/ploegenscherm.fxml")));
                    m_scene = new Scene(m_root);
                    m_css = getClass().getResource("/css/ploegenscherm.css").toExternalForm();
                    m_scene.getStylesheets().add(m_css);
                    m_stage.setScene(m_scene);
                    break;
                case "Wedstrijdenscherm":
                    m_root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/wedstrijdenscherm.fxml")));
                    m_scene = new Scene(m_root);
                    m_css = getClass().getResource("/css/wedstrijdenscherm.css").toExternalForm();
                    m_scene.getStylesheets().add(m_css);
                    m_stage.setScene(m_scene);
                    break;
                default:
                    m_root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/interface.fxml")));
                    m_scene = new Scene(m_root);
                    m_css = Objects.requireNonNull(getClass().getResource("/css/interface.css")).toExternalForm();
                    m_scene.getStylesheets().add(m_css);
                    m_stage.setScene(m_scene);
                    break;
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    @FXML
    public void getPageFromEventSource(ActionEvent event) throws IOException {
        m_stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        m_stage.setTitle(m_title); m_stage.centerOnScreen();
    };

    public void toonPagina() {
        if (m_stage != null) {
            m_stage.show();
        }
    }
}
