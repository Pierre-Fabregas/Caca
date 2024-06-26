

package com.mycompany.caca;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;




public class Ajout extends Application {

    private Stage primaryStage;
    private App app;
    private Button addButton;
    static int idNiveau = 0; // Variable statique pour conserver le niveau entre les instances
    private double hauteurSousPlafond; // Attribut pour stocker la hauteur sous plafond
    private static boolean isFirstTime = true;
    private VBox creationLayout;
    private VBox devisLayout;
    private VBox ouvrirLayout;
    
  
    public Ajout(App app) {
        this.app = app;
    }
    
     private static void writeLines(BufferedWriter writer, List<String> lines) throws IOException {
        for (String line : lines) {
            writer.write(line);
            writer.newLine();
        }
    }
 
         private void copyFileContentToBatiment(File sourceFile) throws IOException {
        File destFile = new File("batiment.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
         
         private void ouvrirSauvegarde() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Ouvrir un fichier Sauvegarde");

    // Définir les filtres pour ne montrer que les fichiers texte
    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Fichiers texte (*.txt)", "*.txt");
    fileChooser.getExtensionFilters().add(extFilter);

    // Afficher la boîte de dialogue Ouvrir
    File selectedFile = fileChooser.showOpenDialog(null);

    if (selectedFile != null) {
        try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
            // Vider les fichiers texte existants
            viderFichier("triangle.txt");
            viderFichier("rectangle.txt");
            viderFichier("prix.txt");
            viderFichier("prixTriangle.txt");

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Triangle")) {
                    copierLigneDansFichier(line, "triangle.txt");
                } else if (line.startsWith("Rectangle")) {
                    copierLigneDansFichier(line, "rectangles.txt");
                } else if (line.startsWith("PrixT")) {
                    copierLigneDansFichier(line, "prixTriangle.txt");
                } else if (line.startsWith("Prix")) {
                    copierLigneDansFichier(line, "prix.txt");
                }
            }
            System.out.println("Contenu du fichier " + selectedFile.getName() + " lu et traité avec succès.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erreur lors de la lecture du fichier : " + selectedFile.getName());
        }
    }
    
    DevisBatiment devisBatiment = new DevisBatiment(); // Création de l'instance de DevisBatiment
    Stage devisStage = new Stage(); // Création d'une nouvelle fenêtre
    devisBatiment.start(devisStage);
}

private void viderFichier(String filename) throws IOException {
    try (PrintWriter writer = new PrintWriter(filename)) {
        // Vider le fichier
    } catch (FileNotFoundException e) {
        e.printStackTrace();
        System.err.println("Fichier non trouvé : " + filename);
    }
}


private void copierLigneDansFichier(String line, String filename) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
        writer.write(line + "\n");
    } catch (IOException e) {
        e.printStackTrace();
        System.err.println("Erreur lors de l'écriture dans le fichier : " + filename);
    }
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
        
        
        
        Button batiment = new Button("Lire un fichier");  
        batiment.setOnAction(event -> {
                 // Choisir un fichier et copier son contenu dans batiment.txt
           
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
            try {
            BufferedReader reader = new BufferedReader(new FileReader("batiment.txt"));
            List<String> coins = new ArrayList<>();
            List<String> murs = new ArrayList<>();
            List<String> sols = new ArrayList<>();
            List<String> plafonds = new ArrayList<>();
            List<String> pieces = new ArrayList<>();
            List<String> appartements = new ArrayList<>();
            List<String> niveaux = new ArrayList<>();
            List<String> batiments = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Coin")) {
                    coins.add(line);
                } else if (line.startsWith("Mur")) {
                    murs.add(line);
                } else if (line.startsWith("Sol")) {
                    sols.add(line);
                } else if (line.startsWith("Plafond")) {
                    plafonds.add(line);
                } else if (line.startsWith("Piece")) {
                    pieces.add(line);
                } else if (line.startsWith("Appartement")) {
                    appartements.add(line);
                } else if (line.startsWith("Niveau")) {
                    niveaux.add(line);
                } else if (line.startsWith("Batiment")) {
                    batiments.add(line);
                }
            }
            reader.close();

            // Écrire les lignes triées dans le fichier de sortie
            BufferedWriter writer = new BufferedWriter(new FileWriter("Tri.txt"));
            writeLines(writer, coins);
            writeLines(writer, murs);
            writeLines(writer, sols);
            writeLines(writer, plafonds);
            writeLines(writer, pieces);
            writeLines(writer, appartements);
            writeLines(writer, niveaux);
            writeLines(writer, batiments);
            writer.close();

            System.out.println("Le fichier a été trié avec succès !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    
      // Créez une instance de la classe LectureFichierBatiment
        LectureFichierBatiment lectureFichierBatiment = new LectureFichierBatiment();
        
        // Appel de la méthode startParsing pour lancer le programme
        lectureFichierBatiment.startParsing();
        
        
         try {
        // Lecture du contenu du fichier prix.txt
        BufferedReader prixReader = new BufferedReader(new FileReader("prixLecture.txt"));
        StringBuilder prixContent = new StringBuilder();
        String line;
        while ((line = prixReader.readLine()) != null) {
            prixContent.append(line).append("\n");
        }
        prixReader.close();
        
        // Création d'une nouvelle fenêtre pour afficher le contenu
        Stage prixStage = new Stage();
        VBox prixBox = new VBox();
        Label prixLabel = new Label("Contenu du fichier prix.txt :");
        TextArea prixTextArea = new TextArea();
        prixTextArea.setText(prixContent.toString());
        prixTextArea.setEditable(false); // Pour rendre la zone de texte en lecture seule
        prixTextArea.setPrefWidth(500); // Définir la largeur préférée
        prixTextArea.setPrefHeight(400); // Définir la hauteur préférée
        prixBox.getChildren().addAll(prixLabel, prixTextArea);
        
        Scene prixScene = new Scene(prixBox, 500, 400);
        prixStage.setScene(prixScene);
        prixStage.setTitle("Contenu de prix.txt");
        prixStage.show();
        
    } catch (IOException e) {
        e.printStackTrace();
    }
        
        
        });
        
        Button OuvrirSauvegarde = new Button("Ouvrir sauvegarde");
        OuvrirSauvegarde.setOnAction(e -> ouvrirSauvegarde());
        
        
     Button Delete = new Button("Delete");
        Delete.setOnAction(event -> {
       String[] filesToDelete = {
                "prix.txt",
                "prixTriangle.txt",
                "piece.txt",
                "piece_triangle.txt",
                "coin.txt",
                "coinT.txt",
                "mur1 triangle.txt",
                "mur1.txt",
                "mur2.txt",
                "plafond1.txt",
                "plafond2.txt",
                "plafond_triangle_2.txt",
                "rectangles.txt",
                "sol1.txt",
                "sol2.txt",
                "sol_triangle_2.txt",
                "informations_devis.txt",
                "triangle.txt",
                "infos_objets.txt",
                "triangledessin.txt",
                "Sauvegarde.txt"
                
            };
            FileUtils.deleteFiles(filesToDelete);
            Delete.setVisible(false);
            
            
    
});
        

        
        
        Image image = null;
        try {
            image = new Image("1000014969.jpg");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Image not found or failed to load.");
        }
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(200);
        imageView.setFitHeight(200);
        imageView.setPreserveRatio(true);
        imageView.setOpacity(10);
        
        
        Image image1 = null;
        try {
            image1 = new Image("ali.jpg");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Image not found or failed to load.");
        }
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitWidth(200);
        imageView1.setFitHeight(200);
        imageView1.setPreserveRatio(true);
        imageView1.setOpacity(10);
        
        
        Image image2 = null;
        try {
            image2 = new Image("ali2.jpg");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Image not found or failed to load.");
        }
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitWidth(200);
        imageView2.setFitHeight(200);
        imageView2.setPreserveRatio(true);
        imageView2.setOpacity(10);
        
        
       
        
        
        MenuBar menuBar = new MenuBar();
        Menu menuCreation = new Menu("Création d'un bâtiment");
        Menu menuDevis = new Menu("Devis");
        Menu menuOuvrir = new Menu("Ouvrir fichier");
        menuBar.getMenus().addAll(menuCreation, menuDevis, menuOuvrir);
        
        MenuItem menuCreation1 = new MenuItem("Création d'un bâtiment");
        MenuItem menuDevis1 = new MenuItem("Devis");
        MenuItem menuOuvrir1 = new MenuItem("Ouvrir fichier");
        
        menuCreation.getItems().addAll(menuCreation1);
        menuDevis.getItems().addAll(menuDevis1);
        menuOuvrir.getItems().addAll(menuOuvrir1);

        creationLayout = new VBox(10);
        creationLayout.setAlignment(Pos.CENTER);
        creationLayout.getChildren().addAll(levelInputBox, heightInputBox, validateButton, addButton);

        devisLayout = new VBox(10);
        devisLayout.setAlignment(Pos.CENTER);
        devisLayout.getChildren().add(DevisBatimentButton);

        ouvrirLayout = new VBox(10);
        ouvrirLayout.setAlignment(Pos.CENTER);
        ouvrirLayout.getChildren().addAll(batiment, OuvrirSauvegarde);

        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setCenter(creationLayout);

        menuCreation1.setOnAction(e -> {
       //    root.setBottom(imageView1);
            
            root.setCenter(creationLayout);
            System.out.println("creation");
                });
        
        menuDevis1.setOnAction(e -> {
         //   root.setBottom(imageView2);
            root.setCenter(devisLayout);
            System.out.println("devis");
                });
        
                
        menuOuvrir1.setOnAction(e -> {
          //  root.setBottom(imageView);
            root.setCenter(ouvrirLayout);
            System.out.println("ouvrir");
 
                });
        
        

        Scene scene = new Scene(root, 500, 500); // Ajuster la taille pour accueillir les nouveaux champs
        primaryStage.setTitle("Gestion des niveaux et pièces");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        if (isFirstTime) {
            Delete.fire(); // Simuler un clic sur le bouton Delete
            isFirstTime = false; // Mettre à jour la variable pour indiquer que la première ouverture a eu lieu
        }
      }  
    

 
    
    public static void main(String[] args) {
        
        launch(args);
      
    }
}


/*  menuCreation.setOnAction(e -> {
            creationLayout.setVisible(true);
            devisLayout.setVisible(false);
            ouvrirLayout.setVisible(false);
                });
        menuDevis.setOnAction(e -> {
            devisLayout.setVisible(true);
            ouvrirLayout.setVisible(false);
            creationLayout.setVisible(false);
                });
        menuOuvrir.setOnAction(e -> {
            devisLayout.setVisible(false);
            ouvrirLayout.setVisible(true);
            creationLayout.setVisible(false);
        });*/

/* VBox imageContainer = new VBox(imageView);
        imageContainer.setAlignment(Pos.CENTER);
        
        
        VBox contentBox = new VBox(10);
        contentBox.setAlignment(Pos.CENTER);
        contentBox.getChildren().addAll(levelInputBox, heightInputBox, validateButton, addButton, DevisBatimentButton, Delete, batiment);
        
        StackPane root = new StackPane();
        root.getChildren().addAll(imageView, contentBox);
        // VBox pour aligner tous les éléments verticalement et centrer*/