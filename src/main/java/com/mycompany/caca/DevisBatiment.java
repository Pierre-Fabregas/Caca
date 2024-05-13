
package com.mycompany.caca;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.HashMap;
import java.util.Map;
import static javafx.application.Application.launch;

public class DevisBatiment extends Application {
    VBox vbox = new VBox();
    double prixmur1;
    double prixmur2;
    double prixmur3;
    double prixmur4;
    double prixPlafond;
    double prixSol;
    double prixPiece;
    double prixniveau;
    double prixtotal;

    // Méthode pour lire le fichier prix.txt et stocker les variables appropriées
    private void lirePrixFichier(String nomFichier) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomFichier))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 11) { // Assurez-vous que la ligne contient toutes les informations nécessaires
                    prixmur1 = Double.parseDouble(parts[3]);
                    prixmur2 = Double.parseDouble(parts[4]);
                    // Prixmur3, prixmur4, prixsol et prixplafond suivent un modèle similaire...
                    prixmur3 = Double.parseDouble(parts[5]);
                    prixmur4 = Double.parseDouble(parts[6]);
                    prixSol = Double.parseDouble(parts[8]);
                    prixPlafond = Double.parseDouble(parts[9]);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
    
    private void lirePrixTriangleFichier(String nomFichier) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomFichier))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 11) { // Assurez-vous que la ligne contient toutes les informations nécessaires
                    prixmur1 = Double.parseDouble(parts[3]);
                    prixmur2 = Double.parseDouble(parts[4]);
                    // Prixmur3, prixmur4, prixsol et prixplafond suivent un modèle similaire...
                    prixmur3 = Double.parseDouble(parts[5]);
                    prixSol = Double.parseDouble(parts[6]);
                    prixPlafond = Double.parseDouble(parts[7]);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
public void start(Stage primaryStage) {
    primaryStage.setTitle("Devis Bâtiment");

    // Appel de la méthode pour lire le fichier prix.txt
    lirePrixFichier("prix.txt");

    // Création d'une VBox pour organiser les éléments verticalement
    VBox vbox = new VBox();
    vbox.setPadding(new Insets(10));
    vbox.setSpacing(10);

    // Calcul du prix total
    double prixTotal = 0;

    // Utilisation d'une Map pour stocker les prix par niveau
    Map<Integer, Double> prixParNiveau = new HashMap<>();

    // Lecture des données à partir du fichier et calcul des prix par niveau
    try (BufferedReader reader = new BufferedReader(new FileReader("prix.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(";");
            if (parts.length >= 11) { // Assurez-vous que la ligne contient toutes les informations nécessaires
                int idNiveau = Integer.parseInt(parts[1]);
                double prixPiece = Double.parseDouble(parts[10]);

                // Mise à jour du prix total
                prixTotal += prixPiece;

                // Mise à jour des prix par niveau
                prixParNiveau.put(idNiveau, prixParNiveau.getOrDefault(idNiveau, 0.0) + prixPiece);
            }
        }

        // Affichage des prix par niveau
        for (Map.Entry<Integer, Double> entry : prixParNiveau.entrySet()) {
            Label label = new Label("Prix pour le niveau " + entry.getKey() + ": " + entry.getValue());
            vbox.getChildren().add(label);
        }

        // Affichage du prix total
        Label totalLabel = new Label("Prix total: " + prixTotal);
        vbox.getChildren().add(totalLabel);
    } catch (IOException | NumberFormatException e) {
        e.printStackTrace();
    }

    // Création de la scène et affichage de la fenêtre
    Scene scene = new Scene(vbox, 400, 300);
    primaryStage.setScene(scene);
    primaryStage.show();
}


    public static void main(String[] args) {
        launch(args);
    }
}
