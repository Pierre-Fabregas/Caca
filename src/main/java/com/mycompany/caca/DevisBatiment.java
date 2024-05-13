
    package com.mycompany.mavenproject2;



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
    import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

    import static javafx.application.Application.launch;


    public class DevisBatiment extends Application {
        VBox vbox = new VBox();
        double idpiece;
        double prixmur1;
        double prixmur2;
        double prixmur3;
        double prixmur4;
        double idNiveau; 
        double prixPlafond;
        double prixSol;
        double prixPiece;
        
        
         Map<Double, Double> prixParNiveau = new HashMap<>();  // Map pour stocker les prix par niveau
    double prixTotal = 0;  // Prix total de tous les niveaux

         @Override
        public void start(Stage primaryStage) {
            vbox.setPadding(new Insets(10));
            vbox.setSpacing(8);

            // Lecture du fichier et initialisation des attributs
            lireFichierDevis();
             // Affichage des prix par niveau
        prixParNiveau.forEach((niveau, prix) -> {
            Label label = new Label("Niveau " + (Double) niveau + ": " + prix + " €");
            vbox.getChildren().add(label);
        });

        // Affichage du prix total
        Label totalLabel = new Label("Prix Total: " + prixTotal + " €");
       totalLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));  // Style en gras et taille plus grande
        vbox.getChildren().add(totalLabel);

            Scene scene = new Scene(vbox, 400, 400);
            primaryStage.setTitle("Devis du Bâtiment");
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        private void lireFichierDevis() {
            String path = "prix.txt"; // Chemin relatif du fichier, adapté à votre structure de projet
            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(";");
                    // Assurez-vous que toutes les parties nécessaires sont présentes
                    if (parts.length >= 10) {
                        idNiveau = Double.parseDouble(parts[1]); // Id du niveau
                        idpiece = Double.parseDouble(parts[2]); // Id de la pièce (rectangleId)
                        prixmur1 = Double.parseDouble(parts[3]); // Prix du mur 1
                        prixmur2 = Double.parseDouble(parts[4]); // Prix du mur 2
                        prixmur3 = Double.parseDouble(parts[5]); // Prix du mur 3
                        prixmur4 = Double.parseDouble(parts[6]); // Prix du mur 4
                        prixSol = Double.parseDouble(parts[7]); // Prix du sol
                        prixPlafond = Double.parseDouble(parts[8]); // Prix du plafond
                        prixPiece = Double.parseDouble(parts[9]); // Prix de la pièce
                        // Notez que nous lisons les valeurs mais ne faisons rien avec pour l'instant
                    
                    
                  // Agréger les prix par niveau
                prixParNiveau.merge(idNiveau, prixPiece, Double::sum);
            }
        }
        // Calculer le prix total après avoir rempli la map
        prixTotal = prixParNiveau.values().stream().mapToDouble(Double::doubleValue).sum();
            } catch (IOException e) {
                e.printStackTrace();
                // Vous pourriez vouloir ajouter un label d'erreur à votre VBox ici si nécessaire
                vbox.getChildren().add(new Label("Erreur lors de la lecture du fichier."));
            }
        }


    


        public static void main(String[] args) {
            launch(args);
        }
    }






