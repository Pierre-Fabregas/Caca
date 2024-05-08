/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caca;

/**
 *
 * @author fabre
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ajout extends Application {

    private Stage primaryStage;
    private App app;
    private Button addButton;

    public Ajout(App app) {
        this.app = app;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        // HBox pour contenir le label et le champ de texte pour le niveau
        HBox levelInputBox = new HBox(5);
        levelInputBox.setAlignment(Pos.CENTER);
        Label levelLabel = new Label("Niveau:");
        TextField levelField = new TextField();
        levelField.setPromptText("Entrez un niveau");
        levelField.setPrefWidth(100); // Réduire la taille du champ de texte
        levelInputBox.getChildren().addAll(levelLabel, levelField);

        // Bouton pour valider le niveau
        Button validateButton = new Button("Valider");
        validateButton.setOnAction(event -> {
            try {
                Integer.parseInt(levelField.getText());
                addButton.setVisible(true);
            } catch (NumberFormatException e) {
                addButton.setVisible(false);
                System.out.println("Veuillez entrer un nombre valide.");
            }
        });

        // Bouton pour ajouter une pièce, initialement non visible
        addButton = new Button("Ajouter Pièce");
        addButton.setVisible(false);
        addButton.setOnAction(event -> {
            primaryStage.close();
            app.openMainWindow();
        });

        // VBox pour aligner tous les éléments verticalement et centrer
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(levelInputBox, validateButton, addButton);

        Scene scene = new Scene(root, 300, 150);
        primaryStage.setTitle("Gestion des niveaux et pièces");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}