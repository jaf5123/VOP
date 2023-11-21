package ext.window;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Window {
    private FXMLLoader contextloader;
    private Scene context;
    private final Stage window;
    private int width, height;
    private String name;

    public Window() {
        name = "";
        width = 0;
        height = 0;
        window = new Stage();
        contextloader = new FXMLLoader();
    }

    public Window(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
        window = new Stage();
        contextloader = new FXMLLoader();
    }

    public void createWindow(String srcToContext) throws IOException {
        window.setTitle(getName());

        /*We creëren de scene*/
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource(srcToContext)));
        context = new Scene(root, getWidth(), getHeight());

        /*Hier komen de keyboard en mouse event functions in de toekomst*/

        window.setScene(getContext());

        window.show();
    };

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setContextloader(FXMLLoader contextloader) {
        this.contextloader = contextloader;
    }

    public FXMLLoader getContextloader() {
        return contextloader;
    }

    public Scene getContext() {
        return context;
    }

    public Stage getWindow() {
        return window;
    }
}
