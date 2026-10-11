package com.sistemasaludador;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Controlador de la vista principal.
 * Coordina el flujo: solicitar saludo, pedir datos y mostrar el resultado.
 */
public class MainController {

    @FXML
    private Button botonSolicitarSaludo;

    @FXML
    private VBox panelDatos;

    @FXML
    private TextField campoNombre;

    @FXML
    private TextField campoEdad;

    @FXML
    private ComboBox<Integer> comboHora;

    @FXML
    private ComboBox<String> comboPeriodo;

    @FXML
    private Button botonConfirmarDatos;

    @FXML
    private Label etiquetaSaludo;

    @FXML
    private void initialize() {
        comboHora.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
        comboPeriodo.setItems(FXCollections.observableArrayList("AM", "PM"));
        panelDatos.setVisible(false);
        panelDatos.setManaged(false);
        etiquetaSaludo.setVisible(false);
        etiquetaSaludo.setManaged(false);
    }

    @FXML
    private void solicitarSaludo() {
        panelDatos.setVisible(true);
        panelDatos.setManaged(true);
        botonSolicitarSaludo.setDisable(true);
        etiquetaSaludo.setText("");
        etiquetaSaludo.setVisible(false);
        etiquetaSaludo.setManaged(false);
        campoNombre.requestFocus();
    }

    @FXML
    private void confirmarDatos() {
        try {
            SaludoModel saludo = SaludoModel.desdeFormulario(
                    campoNombre.getText(),
                    campoEdad.getText(),
                    comboHora.getValue(),
                    comboPeriodo.getValue()
            );
            etiquetaSaludo.setText(saludo.construirSaludo());
            etiquetaSaludo.setVisible(true);
            etiquetaSaludo.setManaged(true);
        } catch (IllegalArgumentException excepcion) {
            mostrarAlerta(excepcion.getMessage());
        }
    }

    private void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Datos incompletos");
        alerta.setHeaderText("No se pudo generar el saludo");
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
