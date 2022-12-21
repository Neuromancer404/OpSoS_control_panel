module com.example.opsos_control_panel {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.opsos_control_panel to javafx.fxml;
    exports com.example.opsos_control_panel;
}