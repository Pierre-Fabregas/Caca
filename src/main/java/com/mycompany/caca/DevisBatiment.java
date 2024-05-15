
    package com.mycompany.caca;



    import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import static javafx.application.Application.launch;

public class DevisBatiment extends Application {
    VBox vbox = new VBox();  // VBox pour contenir tous les éléments de l'interface
    double idpiece;
    double prixmur1;
    double prixmur2;
    double prixmur3;
    double prixmur4;
    double idNiveau; 
    double prixPlafond;
    double prixSol;
    double prixPiece;
    double idpieceTR;
    double prixmur1TR;
    double prixmur2TR;
    double prixmur3TR;
    double idNiveauTR; 
    double prixPlafondTR;
    double prixSolTR;
    double prixPieceTR;

    Map<Double, Double> prixParNiveau = new HashMap<>();  // Map pour stocker les prix par niveau
    Map<Double, List<Piece>> detailsParNiveau = new HashMap<>(); // Map pour stocker les détails des pièces par niveau
    double prixTotal = 0;  // Prix total de tous les niveaux

    // Classe interne pour représenter une pièce
    class Piece {
        String nom;
        double prix;
        double mur1, mur2, mur3, mur4, sol, plafond;

        Piece(String nom, double prix, double mur1, double mur2, double mur3, double mur4, double sol, double plafond) {
            this.nom = nom;
            this.prix = prix;
            this.mur1 = mur1;
            this.mur2 = mur2;
            this.mur3 = mur3;
            this.mur4 = mur4;
            this.sol = sol;
            this.plafond = plafond;
        }
    }

    @Override
    public void start(Stage primaryStage) {
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        lireFichierDevisTriangle();
        lireFichierDevis();
        
        prixParNiveau.forEach((niveau, prix) -> {
            int niveauInt = (int) Math.round(niveau);
            Label label = new Label("Le Prix du Niveau " + niveauInt + " : " + prix + " €");
            Button detailButton = new Button("Détails");
            detailButton.setOnAction(e -> afficherDetails(niveau));
            
            HBox hbox = new HBox(10, label, detailButton);  // Utilisation de HBox pour aligner le label et le bouton
            vbox.getChildren().add(hbox);
        });

        Label totalLabel = new Label("Le Prix Total est : " + prixTotal + " €");
        totalLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        vbox.getChildren().add(totalLabel);

        Scene scene = new Scene(vbox, 800, 800);
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
                if (parts.length >= 10) {
                    idNiveau = Double.parseDouble(parts[1]);
                    idpiece = Double.parseDouble(parts[2]);
                    prixmur1 = Double.parseDouble(parts[3]);
                    prixmur2 = Double.parseDouble(parts[4]);
                    prixmur3 = Double.parseDouble(parts[5]);
                    prixmur4 = Double.parseDouble(parts[6]);
                    prixSol = Double.parseDouble(parts[7]);
                    prixPlafond = Double.parseDouble(parts[8]);
                    prixPiece = Double.parseDouble(parts[9]);

                    prixParNiveau.merge(idNiveau, prixPiece, Double::sum);

                    // Stocker les détails des pièces
                    detailsParNiveau.computeIfAbsent(idNiveau, k -> new ArrayList<>())
                                    .add(new Piece("Pièce " + idpiece, prixPiece, prixmur1, prixmur2, prixmur3, prixmur4, prixSol, prixPlafond));
                }
            }
            prixTotal = prixParNiveau.values().stream().mapToDouble(Double::doubleValue).sum();
        } catch (IOException e) {
            e.printStackTrace();
            vbox.getChildren().add(new Label("Erreur lors de la lecture du fichier."));
        }
    }

    private void lireFichierDevisTriangle() {
        String path = "prixTriangle.txt"; // Chemin relatif du fichier pour les pièces triangulaires
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 8) {
                    idNiveauTR = Double.parseDouble(parts[1]);
                    idpieceTR = Double.parseDouble(parts[2]);
                    prixmur1TR = Double.parseDouble(parts[3]);
                    prixmur2TR = Double.parseDouble(parts[4]);
                    prixmur3TR = Double.parseDouble(parts[5]);
                    prixSolTR = Double.parseDouble(parts[6]);
                    prixPlafondTR = Double.parseDouble(parts[7]);
                    prixPieceTR = Double.parseDouble(parts[8]);

                    prixParNiveau.merge(idNiveauTR, prixPieceTR, Double::sum);

                    // Stocker les détails des pièces
                    detailsParNiveau.computeIfAbsent(idNiveauTR, k -> new ArrayList<>())
                                    .add(new Piece("Pièce " + idpieceTR, prixPieceTR, prixmur1TR, prixmur2TR, prixmur3TR, 0, prixSolTR, prixPlafondTR));
                }
            }
            prixTotal = prixParNiveau.values().stream().mapToDouble(Double::doubleValue).sum();
        } catch (IOException e) {
            e.printStackTrace();
            vbox.getChildren().add(new Label("Erreur lors de la lecture du fichier."));
        }
    }

    private void afficherDetails(Double niveau) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Détails du Niveau " + niveau.intValue());
        alert.setHeaderText(null);

        VBox dialogVbox = new VBox(10);
        List<Piece> detailsPieces = detailsParNiveau.get(niveau);
        if (detailsPieces != null) {
            for (Piece piece : detailsPieces) {
                Label pieceLabel = new Label(piece.nom + " : " + piece.prix + " €");
                Button detailButton = new Button("Détails");
                detailButton.setOnAction(e -> afficherDetailsPiece(piece));

                HBox hbox = new HBox(10, pieceLabel, detailButton);
                dialogVbox.getChildren().add(hbox);
            }
        }

        alert.getDialogPane().setContent(dialogVbox);
        alert.showAndWait();
    }

    private void afficherDetailsPiece(Piece piece) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Détails de la " + piece.nom);
        alert.setHeaderText(null);

        String details = "Prix du mur 1: " + piece.mur1 + " €\n" +
                         "Prix du mur 2: " + piece.mur2 + " €\n" +
                         "Prix du mur 3: " + piece.mur3 + " €\n" +
                         "Prix du mur 4: " + piece.mur4 + " €\n" +
                         "Prix du sol: " + piece.sol + " €\n" +
                         "Prix du plafond: " + piece.plafond + " €\n";

        alert.setContentText(details);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}







