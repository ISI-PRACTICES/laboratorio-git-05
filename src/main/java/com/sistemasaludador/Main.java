package com.sistemasaludador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * Punto de entrada de la aplicación de escritorio Sistema Saludador.
 */
public class Main extends Application {

    private static final String TITULO = "Sistema Saludador";
    private static final double ANCHO = 560;
    private static final double ALTO = 640;

    @Override
    public void start(Stage escenarioPrincipal) throws IOException {
        Parent raiz = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource("/com/sistemasaludador/vista-saludo.fxml"),
                        "No se encontró el archivo FXML de la vista."
                )
        );

        escenarioPrincipal.setTitle(TITULO);
        escenarioPrincipal.setScene(new Scene(raiz, ANCHO, ALTO));
        escenarioPrincipal.setMinWidth(480);
        escenarioPrincipal.setMinHeight(560);
        escenarioPrincipal.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
