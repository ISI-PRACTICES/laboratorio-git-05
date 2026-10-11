# Sistema Saludador

Aplicación de escritorio en JavaFX para el caso de uso **Solicitar saludo**, que incluye de forma obligatoria **Pedir datos**.

## Qué hace

1. El estudiante hace clic en **Solicitar saludo**.
2. El sistema pide **Nombre**, **Edad** y **Hora** en formato AM/PM.
3. El estudiante ingresa los datos y confirma.
4. El sistema muestra un saludo personalizado con el nombre, la edad y el momento del día (mañana, tarde o noche).

## Requisitos

- JDK 17 o superior
- Maven 3.8 o superior

## Cómo ejecutar

Desde la raíz del repositorio:

```bash
mvn clean javafx:run
```

## Estructura

```text
laboratorio-git-05/
├── README.md
├── pom.xml
├── docs/
│   └── reflexion.md
├── prompts/
│   └── 01-inicial.txt
└── src/
    └── main/
        ├── java/
        │   ├── module-info.java
        │   └── com/sistemasaludador/
        │       ├── Main.java
        │       ├── MainController.java
        │       └── SaludoModel.java
        └── resources/
            └── com/sistemasaludador/
                ├── vista-saludo.fxml
                └── estilos.css
```
