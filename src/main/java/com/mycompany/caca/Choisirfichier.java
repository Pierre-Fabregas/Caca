
package com.mycompany.caca;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.*;

public class Choisirfichier extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button batiment = new Button("Choisir un fichier et copier dans batiment.txt");

        batiment.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Ouvrir un fichier texte");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Fichiers texte", "*.txt"));
            File selectedFile = fileChooser.showOpenDialog(primaryStage);

            if (selectedFile != null) {
                try {
                    copyFileContentToBatiment(selectedFile);
                    System.out.println("Le contenu du fichier a été copié dans batiment.txt !");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        VBox vbox = new VBox(batiment);
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Choisir un fichier");
        primaryStage.show();
    }

    public void copyFileContentToBatiment(File sourceFile) throws IOException {
        File destFile = new File("files/batiment.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
