module com.sistemasaludador {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.sistemasaludador to javafx.fxml;
    exports com.sistemasaludador;
}
