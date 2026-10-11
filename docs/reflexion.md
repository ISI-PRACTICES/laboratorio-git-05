# Reflexión

Este laboratorio se centró en construir una aplicación JavaFX pequeña con una separación clara entre vista, controlador y modelo.

La vista (`vista-saludo.fxml`) se limita a presentar el flujo de interacción. El controlador (`MainController`) captura eventos y valida la captura de datos antes de crear el modelo. La lógica del saludo queda en `SaludoModel`, de modo que el mensaje no se arma dentro de la interfaz.

El caso de uso **Solicitar saludo** no muestra el formulario desde el inicio: primero se solicita el saludo y después aparece **Pedir datos**. Eso hace explícita la relación entre ambos pasos. La hora en formato AM/PM permite variar el saludo (buenos días, buenas tardes o buenas noches) sin mezclar esa regla con el código de JavaFX.

Trabajar con FXML y Maven deja el proyecto reproducible: otra persona puede clonar el repositorio, ejecutar `mvn clean javafx:run` y obtener la misma aplicación. Esa es la base para versionar el laboratorio con Git de forma ordenada.
