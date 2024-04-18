package com.example.vop;

//JavaFX
import javafx.application.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.*;
import javafx.geometry.*;

//Standard IO
import java.io.*;

public class PageHandler {
    @FXML
    private Stage stage;
    private Scene scene;
    private double m_width = 0.0d, m_height = 0.0d;

    public PageHandler(Stage stage, Scene scene, double screen_width, double screen_height) {
        this.stage = stage; this.scene = scene;
        m_width = screen_width; m_height = screen_height;
    }
}
