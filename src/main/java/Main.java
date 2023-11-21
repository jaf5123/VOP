import ext.window.Window;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main {
    public static Window m_window;

    public static void main(String[] args) {
        m_window = new Window("VOP", 960, 760);

        m_window.createWindow("../resources/");
    }
}
