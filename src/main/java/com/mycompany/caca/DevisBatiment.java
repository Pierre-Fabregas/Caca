
    package com.mycompany.caca;



import static com.mycompany.caca.App.distancePoints;
   import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;

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
    private int NombreQuadrilatere;
    private static final Color[] COLORS = {
    Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.BLUE, Color.PURPLE, Color.CYAN,
    Color.MAGENTA, Color.YELLOW, Color.GRAY, Color.PINK, Color.LIME, Color.BROWN
             
            
};
     private int currentColorIndex = 0;

    
  //  private Map<Double, List<Mur>> mursParNiveau = new HashMap<>();
  //  private Map<Double, List<Coin>> coinsParNiveau = new HashMap<>();
  //  private Map<Double, List<Coin>> coinsTParNiveau = new HashMap<>();
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
         
    lireFichierDevisTriangle();
    lireFichierDevis();
 /*   lireFichierMur();
    lireFichierCoin();
    lireFichierCoinT();*/
        
        
        prixParNiveau.forEach((niveau, prix) -> {
            int niveauInt = (int) Math.round(niveau);
            Label label = new Label("Le Prix du Niveau " + niveauInt + " : " + prix + " €");
            Button detailButton = new Button("Détails");
            detailButton.setOnAction(e -> afficherDetails(niveau));
            Button imageButton = new Button("Image");
            imageButton.setOnAction(e -> dessinerNiveau(primaryStage, niveau) );
            
        
            HBox hbox = new HBox(10, label, detailButton,imageButton); 
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
    
    
    private void dessinerNiveau(Stage primaryStage, double niveau) {
  
        List<Rec> quadrilateres = lireRectangles("rectangles.txt", niveau);
        List<Triangle> triangles = lireTriangles("triangle.txt", niveau);

        
    
        Stage stage = new Stage();
        Pane paneA = new Pane(); 
        Scene scene = new Scene(paneA, 800, 600);
    
    
        for (Rec quadrilatere : quadrilateres) {
            dessinerQuadrilateres(quadrilateres,paneA);
        }

        for (Triangle triangle : triangles) {
            dessinerTriangles(triangles,paneA);
        }
        
        Button closeButton = new Button("Fermer");
        closeButton.setOnAction(e -> stage.close());
        closeButton.setLayoutX(700);
        closeButton.setLayoutY(550);
        paneA.getChildren().add(closeButton);


        
        stage.setScene(scene);
    stage.show();
    }
    
    private List<Rec> lireRectangles(String filename, double niveau) {
        List<Rec> quadrilateres = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 9) {
                    int idNiveau = Integer.parseInt(parts[9]);
                    if (idNiveau == niveau) {
                        double cx1 = Double.parseDouble(parts[1]);
                        double cy1 = Double.parseDouble(parts[2]);
                        double cx2 = Double.parseDouble(parts[3]);
                        double cy2 = Double.parseDouble(parts[4]);
                        double cx3 = Double.parseDouble(parts[5]);
                        double cy3 = Double.parseDouble(parts[6]);
                        double cx4 = Double.parseDouble(parts[7]);
                        double cy4 = Double.parseDouble(parts[8]);

                        Rec quadrilatere = new Rec(cx1, cy1, cx2, cy2, cx3, cy3, cx4, cy4, idNiveau);
                        quadrilateres.add(quadrilatere);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return quadrilateres;
    }
   
        
    private List<Triangle> lireTriangles(String filename, double niveau) {
        List<Triangle> triangles = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 10) {
                    int idNiveau = Integer.parseInt(parts[10]);
                    if (idNiveau == niveau) {
                        double Acx = Double.parseDouble(parts[1]);
                        double Acy = Double.parseDouble(parts[2]);
                        double Bcx = Double.parseDouble(parts[3]);
                        double Bcy = Double.parseDouble(parts[4]);
                        double Ccx = Double.parseDouble(parts[5]);
                        double Ccy = Double.parseDouble(parts[6]);
                        double longAB = Double.parseDouble(parts[7]);
                        double longBC = Double.parseDouble(parts[8]);
                        double longCA = Double.parseDouble(parts[9]);

                        Triangle triangle = new Triangle(Acx, Acy, Bcx, Bcy, Ccx, Ccy, longAB, longBC, longCA, idNiveau);
                        triangles.add(triangle);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }PrintWriter pwT;
    try {
        pwT = new PrintWriter(new FileOutputStream("triangledessin.txt", true));
        for (Triangle triangle : triangles) {   
            pwT.println("Triangle;" + triangle.getAcx() + ";" + triangle.getAcy() + ";" + triangle.getBcx() + ";" + triangle.getBcy() + ";" + triangle.getCcx() + ";" + triangle.getCcy()+ ";" +triangle.getIdNiveau());
        }
       
        pwT.close();
        System.out.println("Triangles et coins sauvegardés dans le fichier triangles.txt");
        } catch (FileNotFoundException e) {
        e.printStackTrace();
    }  
        return triangles;
        
    }
    
    
    private void dessinerQuadrilateres(List<Rec> quadrilateres,Pane pane) {
        for (int i = 0; i < quadrilateres.size(); i++) {
            Rec quadrilatere = quadrilateres.get(i);

            Text text = new Text("Quadrilatère " + (i +1)); 
            StackPane stack = new StackPane();
            Polygon polygon = new Polygon();
            
            // Ajout des points du quadrilatère
            polygon.getPoints().addAll(
                quadrilatere.getCx1() * 10, quadrilatere.getCy1() * 10,
                quadrilatere.getCx2() * 10, quadrilatere.getCy2() * 10,
                quadrilatere.getCx3() * 10, quadrilatere.getCy3() * 10,
                quadrilatere.getCx4() * 10, quadrilatere.getCy4() * 10
            );
            
            polygon.setStroke(COLORS[currentColorIndex]);
            polygon.setFill(Color.WHITE);

            stack.setAlignment(Pos.CENTER);
            stack.getChildren().addAll(polygon, text);
            stack.setLayoutX(Math.min(quadrilatere.getCx1(), 
                                       Math.min(quadrilatere.getCx2(), 
                                                Math.min(quadrilatere.getCx3(), 
                                                         quadrilatere.getCx4()))) * 10);
            stack.setLayoutY(Math.min(quadrilatere.getCy1(), 
                                       Math.min(quadrilatere.getCy2(), 
                                                Math.min(quadrilatere.getCy3(), 
                                                         quadrilatere.getCy4()))) * 10);
            
           

            pane.getChildren().addAll(stack);
            NombreQuadrilatere = i + 1;
            currentColorIndex = (currentColorIndex + 1) % COLORS.length;
        }
    }
    
    
   private void dessinerTriangles(List<Triangle> triangles,Pane pane) {

    for (int i = 0; i < triangles.size(); i++) {
            Triangle triangle = triangles.get(i);

            double Ax = triangle.getAcx() * 10;
            double Ay = triangle.getAcy() * 10;
            double Bx = triangle.getBcx() * 10;
            double By = triangle.getBcy() * 10;
            double Cx = triangle.getCcx() * 10;
            double Cy = triangle.getCcy() * 10;

            Polygon polygon = new Polygon(Ax, Ay, Bx, By, Cx, Cy);
            polygon.setStroke(COLORS[currentColorIndex]);
            polygon.setFill(Color.WHITE);

            Text text = new Text("Tri " + (i + 1)); // Ajout du numéro
            StackPane stackPane = new StackPane();
            stackPane.setAlignment(Pos.CENTER);
            stackPane.getChildren().addAll(polygon, text);
            stackPane.setLayoutX(Math.min(Ax, Math.min(Bx, Cx)));
            stackPane.setLayoutY(Math.min(Ay, Math.min(By, Cy)));

            pane.getChildren().add(stackPane);

            // Mettre à jour l'indice de couleur pour le prochain triangle
            currentColorIndex = (currentColorIndex + 1) % COLORS.length;
        }
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
  /*  private void afficherImage(Double niveau) {
    Stage stage = new Stage();
    VBox vbox = new VBox();
    vbox.setPadding(new Insets(10));
    vbox.setSpacing(8);

    List<Mur> murs = mursParNiveau.get(niveau);
    List<Coin> coins = coinsParNiveau.get(niveau);
    List<Coin> coinsT = coinsTParNiveau.get(niveau);

    if (murs != null && coins != null) {
        Pane paneH = new Pane();
        paneH.setPrefSize(800, 800);

        // Affichage des quadrilatères et triangles
        afficherQuadrilateres(paneH, murs, coins);
        afficherTriangles(paneH, murs, coinsT);

        vbox.getChildren().add(paneH);
    } else {
        vbox.getChildren().add(new Label("Aucune donnée disponible pour ce niveau."));
    }

    Scene scene = new Scene(vbox, 800, 800);
    stage.setTitle("Image du Niveau " + niveau.intValue());
    stage.setScene(scene);
    stage.show();
}*/

  /*  private void afficherTriangles(Pane paneH, List<Mur> murs, List<Coin> coinsT) {
    paneH.getChildren().clear(); // Effacer les anciens triangles
    Map<Double, Coin> coinTMap = coinsT.stream().collect(Collectors.toMap(Coin::getIdcoin, coin -> coin));

    for (Mur mur : murs) {
        if (mur.isTriangle()) {
            Coin coinA = coinTMap.get(mur.getCoinDebut());
            Coin coinB = coinTMap.get(mur.getCoinFin());
            Coin coinC = coinTMap.get(coinA.getCoinNumber() == 1 ? coinB.getCoinNumber() + 1 : coinB.getCoinNumber() - 1);

            Polygon triangle = new Polygon();
            triangle.getPoints().addAll(
                coinA.getCx() * 10, coinA.getCy() * 10,
                coinB.getCx() * 10, coinB.getCy() * 10,
                coinC.getCx() * 10, coinC.getCy() * 10
            );
            triangle.setStroke(Color.BLACK);
            triangle.setFill(Color.WHITE);

            Text text = new Text("Triangle " + mur.getRectangleId());
            StackPane stack = new StackPane(triangle, text);
            stack.setAlignment(Pos.CENTER);
            stack.setLayoutX(Math.min(coinA.getCx(), Math.min(coinB.getCx(), coinC.getCx())) * 10);
            stack.setLayoutY(Math.min(coinA.getCy(), Math.min(coinB.getCy(), coinC.getCy())) * 10);

            paneH.getChildren().add(stack);
        }
    }
}

    
    
private void afficherQuadrilateres(Pane paneH, List<Mur> murs, List<Coin> coins) {
    paneH.getChildren().clear(); // Effacer les anciens quadrilatères
    Map<Double, Coin> coinMap = coins.stream().collect(Collectors.toMap(Coin::getIdcoin, coin -> coin));

    for (Mur mur : murs) {
        if (!mur.isTriangle()) {
            List<Double> points = Arrays.asList(
                coinMap.get(mur.getCoinDebut()).getCx() * 10, coinMap.get(mur.getCoinDebut()).getCy() * 10,
                coinMap.get(mur.getCoinFin()).getCx() * 10, coinMap.get(mur.getCoinFin()).getCy() * 10
            );

            Polygon quadrilatere = new Polygon();
            quadrilatere.getPoints().addAll(points);
            quadrilatere.setStroke(Color.BLACK);
            quadrilatere.setFill(Color.WHITE);

            Text text = new Text("Quadrilatère " + mur.getRectangleId());
            StackPane stack = new StackPane(quadrilatere, text);
            stack.setAlignment(Pos.CENTER);
            stack.setLayoutX(points.get(0));
            stack.setLayoutY(points.get(1));

            paneH.getChildren().add(stack);
        }
    }
}

*/


   
    
   /* private void lireFichierMur() {
    String path = "mur2.txt";
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(";");
            if (parts.length >= 11) {
                boolean isTriangle = parts[0].equals("MurT");
                int idMur = Integer.parseInt(parts[1]);
                int rectangleId = Integer.parseInt(parts[2]);
                int numero_mur = Integer.parseInt(parts[3]);
                int nbrePortes = Integer.parseInt(parts[4]);
                int nbreFenetres = Integer.parseInt(parts[5]);
                int coinDebut = Integer.parseInt(parts[6]);
                int coinFin = Integer.parseInt(parts[7]);
                String listeRevetement = parts[8];
                double hauteur = Double.parseDouble(parts[9]);
                int idNiveau = Integer.parseInt(parts[10]);

                Mur mur = new Mur(idMur, rectangleId, numero_mur, nbrePortes, nbreFenetres, coinDebut, coinFin, listeRevetement, hauteur, idNiveau);
                if (isTriangle) {
                    mursParNiveau.computeIfAbsent(idNiveau, k -> new ArrayList<>()).add(mur);
                } else {
                    mursParNiveau.computeIfAbsent(idNiveau, k -> new ArrayList<>()).add(mur);
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
        vbox.getChildren().add(new Label("Erreur lors de la lecture du fichier mur2.txt."));
    }
}

private void lireFichierCoin() {
    String path = "coin.txt";
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(";");
            if (parts.length >= 7) {
                int idcoin = Integer.parseInt(parts[1]);
                int rectangleId = Integer.parseInt(parts[2]);
                int coinNumber = Integer.parseInt(parts[3]);
                double cx = Double.parseDouble(parts[4]);
                double cy = Double.parseDouble(parts[5]);
                int idNiveau = Integer.parseInt(parts[6]);

                Coin coin = new Coin(idcoin, rectangleId, coinNumber, cx, cy, idNiveau);
                coinsParNiveau.computeIfAbsent(idNiveau, k -> new ArrayList<>()).add(coin);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
        vbox.getChildren().add(new Label("Erreur lors de la lecture du fichier coin.txt."));
    }
}

private void lireFichierCoinT() {
    String path = "coinT.txt";
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(";");
            if (parts.length >= 7) {
                int idcoin = Integer.parseInt(parts[1]);
                int rectangleId = Integer.parseInt(parts[2]);
                int coinNumber = Integer.parseInt(parts[3]);
                double cx = Double.parseDouble(parts[4]);
                double cy = Double.parseDouble(parts[5]);
                int idNiveau = Integer.parseInt(parts[6]);

                Coin coin = new Coin(idcoin, rectangleId, coinNumber, cx, cy, idNiveau);
                coinsTParNiveau.computeIfAbsent(idNiveau, k -> new ArrayList<>()).add(coin);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
        vbox.getChildren().add(new Label("Erreur lors de la lecture du fichier coinT.txt."));
    }
}*/




   





