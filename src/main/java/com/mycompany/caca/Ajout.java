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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Ajout extends Application {

    private Stage primaryStage;
    private App app;

    public Ajout(App app) {
        this.app = app;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        Button addButton = new Button("Ajouter pièce");
        addButton.setOnAction(event -> {
            // Fermer la fenêtre actuelle
            primaryStage.close();
            // Ouvrir la fenêtre principale de la classe App
            app.openMainWindow();
        });
        
       
        StackPane root = new StackPane();
        root.getChildren().add(addButton);
        Scene scene = new Scene(root, 200, 100);
        primaryStage.setTitle("Ajouter pièce");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

