package com.example.vop;

//JavaFX
import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.*;
import javafx.geometry.*;

//Standard IO
import java.io.*;

public class HelloApplication extends Application {
    PageHandler m_handler;
    @Override
    public void start(Stage primaryStage) throws IOException {
        m_handler = new PageHandler(primaryStage, "De Mol - tennisclub, gelegen in Duffel", 960, 650);

        m_handler.veranderPagina("Startscherm");

        m_handler.toonPagina();
    };

    public static void main(String[] args) {
        launch();
    };
}