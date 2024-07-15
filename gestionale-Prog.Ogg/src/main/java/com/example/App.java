package com.example;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws IOException {

        scene = new Scene(loadFXML("initialPage"));
        Image icon = new Image(getClass().getResourceAsStream("sfondoFoglie.jpg"));
        stage.getIcons().add(icon);
        /*
         * stage.getIcons().add(new
         * Image("src/main/resources/com/example/sfondoFoglie.jpg"));
         */

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @SuppressWarnings("exports")
    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
