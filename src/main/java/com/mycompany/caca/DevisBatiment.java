
package com.mycompany.caca;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DevisBatiment extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Devis Bâtiment");

        // Création d'une VBox pour organiser les éléments verticalement
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);

        // Lecture des données à partir du fichier et ajout dans la VBox
        try (BufferedReader reader = new BufferedReader(new FileReader("prix.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Label label = new Label(line);
                vbox.getChildren().add(label);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}