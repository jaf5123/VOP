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
    @Override
    public void start(Stage primaryStage) throws IOException {
        Scene m_scene = null;
        VBox m_root = new VBox(0);
        m_scene = new Scene(m_root, 960, 650);

        //Get the width and height of the window.
        Rectangle2D m_renderableBox = Screen.getPrimary().getBounds();
        final double m_width = m_renderableBox.getWidth();
        final double m_height = m_renderableBox.getHeight();

        primaryStage.setScene(m_scene);
        primaryStage.setTitle("De Mol - tennisclub, gelegen in Duffel");
        primaryStage.show();
    };

    public static void main(String[] args) {
        launch();
    };
}