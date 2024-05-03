module App {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires json.simple;
    requires freetts;

    opens App to javafx.fxml;
    exports App;
}