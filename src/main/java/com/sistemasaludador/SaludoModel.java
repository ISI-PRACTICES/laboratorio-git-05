package com.sistemasaludador;

import java.util.Objects;

/**
 * Modelo del caso de uso "Solicitar saludo".
 * Encapsula los datos pedidos al estudiante y la lógica para construir el mensaje.
 */
public final class SaludoModel {

    public enum Periodo {
        AM, PM
    }

    private final String nombre;
    private final int edad;
    private final int hora;
    private final Periodo periodo;

    public SaludoModel(String nombre, int edad, int hora, Periodo periodo) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre es obligatorio.");
        this.edad = edad;
        this.hora = hora;
        this.periodo = Objects.requireNonNull(periodo, "El periodo AM/PM es obligatorio.");
    }

    /**
     * Crea un modelo validando los datos capturados en la interfaz.
     *
     * @throws IllegalArgumentException si algún dato es inválido
     */
    public static SaludoModel desdeFormulario(String nombre, String edadTexto, Integer hora, String periodoTexto) {
        String nombreLimpio = nombre == null ? "" : nombre.trim();
        if (nombreLimpio.isEmpty()) {
            throw new IllegalArgumentException("Ingresa tu nombre.");
        }

        int edad;
        try {
            edad = Integer.parseInt(edadTexto == null ? "" : edadTexto.trim());
        } catch (NumberFormatException excepcion) {
            throw new IllegalArgumentException("La edad debe ser un número entero.");
        }
        if (edad < 1 || edad > 120) {
            throw new IllegalArgumentException("La edad debe estar entre 1 y 120.");
        }

        if (hora == null || hora < 1 || hora > 12) {
            throw new IllegalArgumentException("Selecciona una hora válida entre 1 y 12.");
        }

        Periodo periodo;
        try {
            periodo = Periodo.valueOf(periodoTexto == null ? "" : periodoTexto.trim().toUpperCase());
        } catch (IllegalArgumentException excepcion) {
            throw new IllegalArgumentException("Selecciona si la hora es AM o PM.");
        }

        return new SaludoModel(nombreLimpio, edad, hora, periodo);
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getHora() {
        return hora;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    /**
     * Construye un saludo personalizado con el nombre, la edad y el momento del día.
     */
    public String construirSaludo() {
        return String.format(
                "%s, %s. Tienes %d años. Son las %d:00 %s.",
                obtenerSaludoSegunHora(),
                nombre,
                edad,
                hora,
                periodo.name()
        );
    }

    String obtenerSaludoSegunHora() {
        int hora24 = convertirAHora24();
        if (hora24 >= 0 && hora24 < 12) {
            return "Buenos días";
        }
        if (hora24 >= 12 && hora24 < 19) {
            return "Buenas tardes";
        }
        return "Buenas noches";
    }

    private int convertirAHora24() {
        if (periodo == Periodo.AM) {
            return hora == 12 ? 0 : hora;
        }
        return hora == 12 ? 12 : hora + 12;
    }
}
