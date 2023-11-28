module com.example.vop {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens com.example.vop to javafx.fxml;
    exports com.example.vop;
}