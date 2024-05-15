

package com.mycompany.caca;


import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import static javafx.application.Application.launch;
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
 static int idNiveau = 0; // Variable statique pour conserver le niveau entre les instances
    private double hauteurSousPlafond; // Attribut pour stocker la hauteur sous plafond
   
    
  
    public Ajout(App app) {
        this.app = app;
    }
 
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
     
        

            

        // HBox pour l'identifiant de niveau
        HBox levelInputBox = new HBox(5);
        levelInputBox.setAlignment(Pos.CENTER);
        Label levelLabel = new Label("Niveau:");
         TextField levelField = new TextField(String.valueOf(idNiveau)); // Initialise avec la valeur actuelle de idNiveau
        levelField.setPromptText("Entrez un niveau");
        levelField.setPrefWidth(100);
        levelInputBox.getChildren().addAll(levelLabel, levelField);

        // HBox pour la hauteur sous plafond
        HBox heightInputBox = new HBox(5);
        heightInputBox.setAlignment(Pos.CENTER);
        Label heightLabel = new Label("Hauteur sous plafond:");
        TextField heightField = new TextField();
        heightField.setPromptText("Entrez la hauteur");
        heightField.setPrefWidth(100);
        heightInputBox.getChildren().addAll(heightLabel, heightField);

        // Bouton pour valider les entrées
        Button validateButton = new Button("Valider");
        validateButton.setOnAction(event -> {
            try {
                idNiveau = Integer.parseInt(levelField.getText());
                hauteurSousPlafond = Double.parseDouble(heightField.getText());
                addButton.setVisible(true); // Affiche le bouton Ajouter Pièce si les entrées sont valides
            } catch (NumberFormatException e) {
                addButton.setVisible(false); // Cache le bouton si une entrée n'est pas valide
                System.out.println("Veuillez entrer des valeurs valides.");
            }
        });

        // Bouton pour ajouter une pièce, initialement non visible
        addButton = new Button("Ajouter Pièce");
        addButton.setVisible(false);
        addButton.setOnAction(event -> {
            primaryStage.close();
            app.openMainWindow(idNiveau,hauteurSousPlafond);
        });

        Button DevisBatimentButton = new Button("Devis Batiment");
        DevisBatimentButton.setOnAction(event -> {
    DevisBatiment devisBatiment = new DevisBatiment(); // Création de l'instance de DevisBatiment
    Stage devisStage = new Stage(); // Création d'une nouvelle fenêtre
    devisBatiment.start(devisStage); // Affichage de la fenêtre du devis
});
        
        // VBox pour aligner tous les éléments verticalement et centrer
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(levelInputBox, heightInputBox, validateButton, addButton, DevisBatimentButton );

        Scene scene = new Scene(root, 400, 400); // Ajuster la taille pour accueillir les nouveaux champs
        primaryStage.setTitle("Gestion des niveaux et pièces");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

  
    private static void resetFiles() {
        String[] filesToClear = {
            "prix.txt",
            "prixTriangle.txt",
            "piece.txt"
            // "piece_triangle.txt"
        };

        // Réinitialisation des fichiers
        for (String filePath : filesToClear) {
            FileUtils.clearFile(filePath);
            System.out.println("Le fichier " + filePath + " a été effacé.");
        }

        System.out.println("Tous les fichiers spécifiés ont été réinitialisés.");
    }
    
    
    public static void main(String[] args) {
        resetFiles();
        launch(args);
      
    }
}