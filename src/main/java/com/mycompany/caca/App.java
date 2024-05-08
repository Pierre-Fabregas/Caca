/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caca;


import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class App extends Application {
  
   
    
    private Stage primaryStage;
    private int NombreRectangle;
     List<Mur> listeMurs;
     List<Plafond> listePlafonds;
     List<Sol> listeSols;
    
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        Ajout addPieceWindow = new Ajout(this);
        addPieceWindow.start(primaryStage);
       
    }
    
    int idNiveau;
    double hauteurSousPlafond;

    public void openMainWindow(int idNiveau, double hauteurSousPlafond) {
        this.idNiveau = idNiveau;
        this.hauteurSousPlafond = hauteurSousPlafond;


        listeMurs = new ArrayList<>();
        listePlafonds = new ArrayList<>();
        listeSols = new ArrayList<>();
        primaryStage.setTitle("Rectangles");
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        // Place nodes in the pane at positions column,row
        pane.add(new Label("Longueur:"), 0, 0);
        TextField lon = new TextField();
        pane.add(lon, 1, 0);
        pane.add(new Label("Largeur:"), 0, 1);
        TextField lar = new TextField();
        pane.add(lar, 1, 1);
        pane.add(new Label("Cx:"), 0, 2);
        TextField cx = new TextField();
        pane.add(cx, 1, 2);
        pane.add(new Label("Cy:"), 0, 3);
        TextField cy = new TextField();
        pane.add(cy, 1, 3);
       

        // Initialisation de la liste de rectangles
        ArrayList<Rec> liste_recs = new ArrayList<Rec>();
        ArrayList<Rectangle> liste_rectangles = new ArrayList<Rectangle>();
        ArrayList<Coin> liste_coins = new ArrayList<Coin>();
        ArrayList<Mur> liste_murs = new ArrayList<Mur>();
        ArrayList<Plafond> liste_plafonds = new ArrayList<Plafond>();
        ArrayList<Sol> liste_sols = new ArrayList<Sol>();
        
        Button btAdd = new Button("Ajouter rectangle");
        pane.add(btAdd, 0, 5);
        // Expression lambda pour construire un EventHandler<ActionEvent>
        btAdd.setOnAction(evt -> {
            Rec rec = new Rec(Double.parseDouble(lon.getText()),
                      Double.parseDouble(lar.getText()),
                      Double.parseDouble(cx.getText()),
                      Double.parseDouble(cy.getText()));
   
   int rectangleId = liste_recs.size() + 1;
    Coin coin1 = new Coin(liste_murs.size() + 1, rectangleId, 1, Double.parseDouble(cx.getText()), Double.parseDouble(cy.getText()));
    Coin coin2 = new Coin(liste_murs.size() + 2, rectangleId, 2, Double.parseDouble(cx.getText()) + Double.parseDouble(lon.getText()), Double.parseDouble(cy.getText()));
    Coin coin3 = new Coin(liste_murs.size() + 3, rectangleId, 3, Double.parseDouble(cx.getText()) + Double.parseDouble(lon.getText()), Double.parseDouble(cy.getText()) + Double.parseDouble(lar.getText()));
    Coin coin4 = new Coin(liste_murs.size() + 4, rectangleId, 4, Double.parseDouble(cx.getText()), Double.parseDouble(cy.getText()) + Double.parseDouble(lar.getText()));

    liste_coins.add(coin1);
    liste_coins.add(coin2);
    liste_coins.add(coin3);
    liste_coins.add(coin4);
    
Plafond plafond1 = new Plafond(rectangleId,coin1,coin2,coin3,coin4, 0,0,idNiveau);
liste_plafonds.add(plafond1);
listePlafonds.add(plafond1);

Sol sol1 = new Sol(rectangleId,coin1,coin2,coin3,coin4, 0,0,idNiveau);
liste_sols.add(sol1);
listeSols.add(sol1);
    
Mur mur1 = new Mur(liste_murs.size() + 1, rectangleId, 1, 0, 0, coin1, coin2, 0, 0,idNiveau);
Mur mur2 = new Mur(liste_murs.size() + 2, rectangleId, 2, 0, 0, coin2, coin3, 0, 0,idNiveau);
Mur mur3 = new Mur(liste_murs.size() + 3, rectangleId, 3, 0, 0, coin3, coin4, 0, 0,idNiveau);
Mur mur4 = new Mur(liste_murs.size() + 4, rectangleId, 4, 0, 0, coin4, coin1, 0, 0,idNiveau);

liste_murs.add(mur1);
liste_murs.add(mur2);
liste_murs.add(mur3);
liste_murs.add(mur4);
listeMurs.add(mur1);
listeMurs.add(mur2);
listeMurs.add(mur3);
listeMurs.add(mur4);

    // Ajout du rectangle à la liste
    liste_recs.add(rec);
    

    

        });

        Button btSave = new Button("Sauvegarder rectangles");
        pane.add(btSave, 1, 5);
        btSave.setOnAction(evt -> {
        PrintWriter pw;
    try {
        pw = new PrintWriter(new FileOutputStream("rectangles.txt"));
        for (Rec rec : liste_recs) {
            pw.println("Rectangle;" + rec.getLon() + ";" + rec.getLar() + ";" + rec.getOri_x() + ";" + rec.getOri_y() + ";" + rec.surface());
        }
       
        pw.close();
        System.out.println("Rectangles et coins sauvegardés dans le fichier rectangles.txt");
        } catch (FileNotFoundException e) {
        e.printStackTrace();
    }  
    PrintWriter pwcoin;
    try { 
        pwcoin= new PrintWriter (new FileOutputStream("coin.txt"));
        for (Coin coin : liste_coins) {
            pwcoin.println("Coin;" + coin.idcoin + ";" + coin.rectangleId + ";" + coin.coinNumber + ";" + coin.cx + ";" + coin.cy);
        }
        pwcoin.close();
        } catch (FileNotFoundException e) {
        e.printStackTrace();
    }  
    PrintWriter pwmur;
try { 
    pwmur = new PrintWriter (new FileOutputStream("mur1.txt"));
    for (Mur mur : liste_murs) {
        pwmur.println("Mur;" + mur.idMur + ";" + mur.rectangleId + ";" + mur.numero_mur + ";" + mur.nbrePortes + ";" + mur.nbreFenetres + ";" + mur.coinDebut.idcoin + ";" + mur.coinFin.idcoin + ";" + mur.hauteur);
    }
    pwmur.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
}
    PrintWriter pwplafond;
try { 
    pwplafond = new PrintWriter (new FileOutputStream("plafond1.txt"));
    for (Plafond plafond : liste_plafonds) {
        pwplafond.println("Plafond;" +  plafond.rectangleId + ";" + plafond.coin1.idcoin + ";" + plafond.coin2.idcoin + ";" + plafond.coin3.idcoin + ";" + plafond.coin4.idcoin + ";" + plafond.listeRevetement + ";" + plafond.tremie );
    }
    pwplafond.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
}

PrintWriter pwsol;
try { 
    pwsol = new PrintWriter (new FileOutputStream("sol1.txt"));
    for (Sol sol : liste_sols) {
        pwsol.println("Sol;" +  sol.rectangleId + ";" + sol.coin1.idcoin + ";" + sol.coin2.idcoin + ";" + sol.coin3.idcoin + ";" + sol.coin4.idcoin + ";" + sol.listeRevetement + ";" + sol.tremie );
    }
    pwsol.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
}

            
              
});
        
           




        Button btFin = new Button("Accueil");
        pane.add(btFin, 6, 5);
        btFin.setOnAction(evt -> {
    Stage newStage = new Stage();            // Crée un nouveau stage
    Ajout ajoutWindow = new Ajout(this);     // Crée une nouvelle instance de Ajout
    ajoutWindow.start(newStage);             // Lance Ajout sur le nouveau stage
    primaryStage.close();
           
            
            
            
            
            
        });
        
        Button btRev = new Button("Choisir revêtement");
        pane.add(btRev, 4, 5);
        btRev.setOnAction(evt -> {
            // Ouvrir une nouvelle fenêtre pour choisir le revêtement
            RevetementFenetre revetmentWindow = new RevetementFenetre(liste_recs.size(), listeMurs, listePlafonds, listeSols,idNiveau,hauteurSousPlafond);

            revetmentWindow.start(new Stage());
        });

        Pane paneH = new Pane();

        Button btShow = new Button("Dessiner rectangles");
        pane.add(btShow, 3, 5);
        btShow.setOnAction(evt -> {
            // Dessiner les rectangles ici
            paneH.getChildren().clear(); // Effacer les anciens rectangles
            for (int i = 0; i < liste_recs.size(); i++) {
                Text text = new Text("Rec " + (i + 1)); // Ajout du numéro
                StackPane stack = new StackPane();
                Rectangle rectangle = new Rectangle();
                rectangle.setX(liste_recs.get(i).getOri_x());
                rectangle.setY(liste_recs.get(i).getOri_y());
                rectangle.setWidth(liste_recs.get(i).getLar() *10);
                rectangle.setHeight(liste_recs.get(i).getLon() *10);
                rectangle.setStroke(Color.BLACK);
                rectangle.setFill(Color.WHITE);

                stack.setAlignment(Pos.CENTER);
                stack.getChildren().addAll(rectangle, text);
                stack.setLayoutX(liste_recs.get(i).getOri_x());
                stack.setLayoutY(liste_recs.get(i).getOri_y());

                paneH.getChildren().addAll(stack);
                NombreRectangle=i+1;
            }
        });

        VBox paneV = new VBox();
        paneV.setPadding(new Insets(10, 50, 50, 50));
        paneV.setSpacing(10);

        paneV.getChildren().add(pane);
        paneV.getChildren().add(paneH);

        // Graphe de scène avec des nœuds
        Scene scene = new Scene(paneV, 1000, 600);  // Construire une scène à partir de la racine du graphe de scène
        primaryStage.setScene(scene);               // The stage sets scene
        primaryStage.show();                        // Définir la visibilité (l'afficher)
    }

    public static void main(String[] args) {
        launch(args);
    }
}

