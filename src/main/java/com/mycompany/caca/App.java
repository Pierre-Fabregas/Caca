/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caca;

/*import java.util.List;
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
import javafx.scene.shape.Polygon;

public class App extends Application {
  
   
    
    private Stage primaryStage;
    private int NombreQuadrilatere;
    private int NombreTriangle;
     List<Mur> listeMurs;
     List<Plafond> listePlafonds;
     List<Sol> listeSols;
     private static final Color[] COLORS = {
    Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.BLUE, Color.PURPLE, Color.CYAN,
    Color.MAGENTA, Color.YELLOW, Color.GRAY, Color.PINK, Color.LIME, Color.BROWN
             
            
};
     private int currentColorIndex = 0; // Index pour suivre la couleur actuelle
    
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
     public static double distancePoints(double x1, double y1, double x2, double y2) {
    if(x1>x2 && y1>y2){
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
    if(x1<x2 && y1<y2){
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
    if(x1>x2 && y1<y2){
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y2 - y1, 2));
    }
    if(x1<x2 && y1>y2){
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y1 - y2, 2));
    }
    if(x1==x2 && y1==y2){
        return 0;
    }
    if(x1==x2 && y1>y2){
        return Math.sqrt(Math.pow(y1 - y2, 2));
    }
    if(x1==x2 && y1<y2){
        return Math.sqrt(Math.pow(y2 - y1, 2));
    }
    if(x1<x2 && y1==y2){
        return Math.sqrt(Math.pow(x2 - x1, 2) );
    }
    if(x1>x2 && y1==y2){
        return Math.sqrt(Math.pow(x1 - x2, 2) );
    }
    else {
        return 0;}
}
    
   

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        Ajout addPieceWindow = new Ajout(this);
        addPieceWindow.start(primaryStage);
       
    }
    
    int idNiveau;
    double hauteurSousPlafond;
    int nombreNiveau ;
    
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
        pane.add(new Label("Coordonnées Coin 1 (x,y):"), 0, 0);
        TextField cx1 = new TextField();
        TextField cy1 = new TextField();
        pane.add(cx1, 1, 0);
        pane.add(cy1, 2, 0);

        pane.add(new Label("Coordonnées Coin 2 (x,y):"), 0, 1);
        TextField cx2 = new TextField();
        TextField cy2 = new TextField();
        pane.add(cx2, 1, 1);
        pane.add(cy2, 2, 1);

        pane.add(new Label("Coordonnées Coin 3 (x,y):"), 0, 2);
        TextField cx3 = new TextField();
        TextField cy3 = new TextField();
        pane.add(cx3, 1, 2);
        pane.add(cy3, 2, 2);

        pane.add(new Label("Coordonnées Coin 4 (x,y):"), 0, 3);
        TextField cx4 = new TextField();
        TextField cy4 = new TextField();
        pane.add(cx4, 1, 3);
        pane.add(cy4, 2, 3);

        // Initialisation de la liste de rectangles
        ArrayList<Rec> liste_quadrilateres = new ArrayList<Rec>();
        ArrayList<Rectangle> liste_rectangles = new ArrayList<Rectangle>();
        ArrayList<Coin> liste_coins = new ArrayList<Coin>();
        ArrayList<Mur> liste_murs = new ArrayList<Mur>();
        ArrayList<Mur> liste_murstriangle = new ArrayList<Mur>();
        ArrayList<Plafond> liste_plafonds = new ArrayList<Plafond>();
        ArrayList<Plafond_Triangle> liste_plafondstriangle = new ArrayList<Plafond_Triangle>();
        ArrayList<Sol_Triangle> liste_solstriangle = new ArrayList<Sol_Triangle>();
        ArrayList<Sol> liste_sols = new ArrayList<Sol>();
        ArrayList<Triangle> listeTriangles = new ArrayList<Triangle>();
        
        
        Button btAdd = new Button("Ajouter rectangle");
        pane.add(btAdd, 0, 5);
        // Expression lambda pour construire un EventHandler<ActionEvent>
        btAdd.setOnAction(evt -> {
            Rec rec = new Rec(Double.parseDouble(cx1.getText()),
                      Double.parseDouble(cy1.getText()),
                      Double.parseDouble(cx2.getText()),
                      Double.parseDouble(cy2.getText()),
                      Double.parseDouble(cx3.getText()),
                      Double.parseDouble(cy3.getText()),
                      Double.parseDouble(cx4.getText()),
                      Double.parseDouble(cy4.getText()),
                      idNiveau
            );
            
            
   
   int rectangleId = liste_quadrilateres.size() + 1;
    Coin coin1 = new Coin(liste_murs.size() + 1, rectangleId, 1, Double.parseDouble(cx1.getText()), Double.parseDouble(cy1.getText()),+ idNiveau);
    Coin coin2 = new Coin(liste_murs.size() + 2, rectangleId, 2, Double.parseDouble(cx2.getText()), Double.parseDouble(cy2.getText()), idNiveau);
    Coin coin3 = new Coin(liste_murs.size() + 3, rectangleId, 3, Double.parseDouble(cx3.getText()), Double.parseDouble(cy3.getText()),idNiveau);
    Coin coin4 = new Coin(liste_murs.size() + 4, rectangleId, 4, Double.parseDouble(cx4.getText()), Double.parseDouble(cy4.getText()),idNiveau);

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
    liste_quadrilateres.add(rec);
    

    

        });

        Button btSave = new Button("Sauvegarder rectangles");
        pane.add(btSave, 1, 5);
        btSave.setOnAction(evt -> {
        PrintWriter pw;
    try {
        pw = new PrintWriter(new FileOutputStream("rectangles.txt", true));
        for (Rec rec : liste_quadrilateres) {
            pw.println("Rectangle;" + rec.getCx1() + ";" + rec.getCy1() + ";" + rec.getCx2() + ";" + rec.getCy2() + ";" + rec.getCx3()+ ";" + rec.getCy3() + ";" + rec.getCx4() + ";" + rec.getCy4()+ ";"+rec.getIdNiveau());
        }
       
        pw.close();
        System.out.println("Rectangles et coins sauvegardés dans le fichier rectangles.txt");
        } catch (FileNotFoundException e) {
        e.printStackTrace();
    }  
    PrintWriter pwcoin;
    try { 
        pwcoin= new PrintWriter (new FileOutputStream("coin.txt", true));
        for (Coin coin : liste_coins) {
            pwcoin.println("Coin;" + coin.idcoin + ";" + coin.rectangleId + ";" + coin.coinNumber + ";" + coin.cx + ";" + coin.cy+ ";" + coin.idNiveau);
        }
        pwcoin.close();
        } catch (FileNotFoundException e) {
        e.printStackTrace();
    }  
    PrintWriter pwmur;
try { 
    pwmur = new PrintWriter (new FileOutputStream("mur1.txt", true));
    for (Mur mur : liste_murs) {
        pwmur.println("Mur;" + mur.idMur + ";" + mur.rectangleId + ";" + mur.numero_mur + ";" + mur.nbrePortes + ";" + mur.nbreFenetres + ";" + mur.coinDebut.idcoin + ";" + mur.coinFin.idcoin + ";" + mur.listeRevetement +";" + mur.hauteur + ";" + mur.idNiveau);
    }
    pwmur.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
}
    PrintWriter pwplafond;
try { 
    pwplafond = new PrintWriter (new FileOutputStream("plafond1.txt", true));
    for (Plafond plafond : liste_plafonds) {
        pwplafond.println("Plafond;" +  plafond.rectangleId + ";" + plafond.coin1.idcoin + ";" + plafond.coin2.idcoin + ";" + plafond.coin3.idcoin + ";" + plafond.coin4.idcoin + ";" + plafond.listeRevetement + ";" + plafond.tremie );
    }
    pwplafond.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
}

PrintWriter pwsol;
try { 
    pwsol = new PrintWriter (new FileOutputStream("sol1.txt", true));
    for (Sol sol : liste_sols) {
        pwsol.println("Sol;" +  sol.rectangleId + ";" + sol.coin1.idcoin + ";" + sol.coin2.idcoin + ";" + sol.coin3.idcoin + ";" + sol.coin4.idcoin + ";" + sol.listeRevetement + ";" + sol.tremie );
    }
    pwsol.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
}

            
              
});
        
           




        Button btFin = new Button("Accueil");
        pane.add(btFin, 11, 5);
        btFin.setOnAction(evt -> {
            Ajout.idNiveau++;  // Incrémente le niveau chaque fois que le bouton est cliqué
    Stage newStage = new Stage();            // Crée un nouveau stage
    Ajout ajoutWindow = new Ajout(this );     // Crée une nouvelle instance de Ajout
    ajoutWindow.start(newStage);             // Lance Ajout sur le nouveau stage
    primaryStage.close();
           
            
            
            
            
            
        });
        
        Button btRev = new Button("Choisir revêtement");
        pane.add(btRev, 3, 5);
        btRev.setOnAction(evt -> {
            // Ouvrir une nouvelle fenêtre pour choisir le revêtement
            RevetementFenetre revetmentWindow = new RevetementFenetre(liste_quadrilateres.size(), listeMurs, listePlafonds, listeSols,idNiveau,hauteurSousPlafond);

            revetmentWindow.start(new Stage());
        });

        Pane paneH = new Pane();

        Button btShow = new Button("Dessiner Pièces");
        pane.add(btShow, 10, 5);
        btShow.setOnAction(evt -> {
            // Dessiner les rectangles ici
            paneH.getChildren().clear(); // Effacer les anciens quadrilatères

for (int i = 0; i < liste_quadrilateres.size(); i++) {
    Text text = new Text("Quadrilatère " + (i + 1)); // Ajout du numéro
    StackPane stack = new StackPane();
    Polygon quadrilatere = new Polygon();
    
    // Ajout des points du quadrilatère
    quadrilatere.getPoints().addAll(
        liste_quadrilateres.get(i).getCx1() * 10, liste_quadrilateres.get(i).getCy1() * 10,
        liste_quadrilateres.get(i).getCx2() * 10, liste_quadrilateres.get(i).getCy2() * 10,
        liste_quadrilateres.get(i).getCx3() * 10, liste_quadrilateres.get(i).getCy3() * 10,
        liste_quadrilateres.get(i).getCx4() * 10, liste_quadrilateres.get(i).getCy4() * 10
    );
    
    quadrilatere.setStroke(COLORS[currentColorIndex]);
    quadrilatere.setFill(Color.WHITE);

    stack.setAlignment(Pos.CENTER);
    stack.getChildren().addAll(quadrilatere, text);
    stack.setLayoutX(Math.min(liste_quadrilateres.get(i).getCx1(), 
                               Math.min(liste_quadrilateres.get(i).getCx2(), 
                                        Math.min(liste_quadrilateres.get(i).getCx3(), 
                                                 liste_quadrilateres.get(i).getCx4()))) * 10);
    stack.setLayoutY(Math.min(liste_quadrilateres.get(i).getCy1(), 
                               Math.min(liste_quadrilateres.get(i).getCy2(), 
                                        Math.min(liste_quadrilateres.get(i).getCy3(), 
                                                 liste_quadrilateres.get(i).getCy4()))) * 10);
    
    // Mettez à jour l'indice de couleur pour le prochain quadrilatère
    currentColorIndex = (currentColorIndex + 1) % COLORS.length;

    paneH.getChildren().addAll(stack);
    NombreQuadrilatere = i + 1;


            }
            for (int i = 0; i < listeTriangles.size(); i++) {
            Triangle triangle = listeTriangles.get(i);

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

            paneH.getChildren().add(stackPane);

            // Mettre à jour l'indice de couleur pour le prochain triangle
            currentColorIndex = (currentColorIndex + 1) % COLORS.length;
        }

       
        });
        
        
        

        // Place nodes in the pane at positions column,row
        pane.add(new Label("Coordonnées Sommet A (x,y):"), 5, 0);
        TextField Acx = new TextField();
        TextField Acy = new TextField();
        pane.add(Acx, 6, 0);
        pane.add(Acy, 7, 0);

        pane.add(new Label("Coordonnées Sommet B (x,y):"), 5, 1);
        TextField Bcx = new TextField();
        TextField Bcy = new TextField();
        pane.add(Bcx, 6, 1);
        pane.add(Bcy, 7, 1);

        pane.add(new Label("Coordonnées Sommet C (x,y):"), 5, 2);
        TextField Ccx = new TextField();
        TextField Ccy = new TextField();
        pane.add(Ccx, 6, 2);
        pane.add(Ccy, 7, 2);
        
        

        Button btAddT = new Button("Ajouter triangle");
        pane.add(btAddT, 5, 5);
        btAddT.setOnAction(evt -> {
         Triangle triangle = new Triangle(Double.parseDouble(Acx.getText()),
                    Double.parseDouble(Acy.getText()),
                    Double.parseDouble(Bcx.getText()),
                    Double.parseDouble(Bcy.getText()),
                    Double.parseDouble(Ccx.getText()),
                    Double.parseDouble(Ccy.getText()),
                    distancePoints(Double.parseDouble(Acx.getText()), Double.parseDouble(Acy.getText()), Double.parseDouble(Bcx.getText()), Double.parseDouble(Bcy.getText())),
                    distancePoints(Double.parseDouble(Bcx.getText()), Double.parseDouble(Bcy.getText()), Double.parseDouble(Ccx.getText()), Double.parseDouble(Ccy.getText())),
                    distancePoints(Double.parseDouble(Ccx.getText()), Double.parseDouble(Ccy.getText()), Double.parseDouble(Acx.getText()), Double.parseDouble(Acy.getText())),
                    idNiveau
                 );
         
          int TriangleId = listeTriangles.size() + 1;
    Coin coinA = new Coin(liste_murs.size() + 1, TriangleId, 1, Double.parseDouble(Acx.getText()), Double.parseDouble(Acy.getText()),+ idNiveau);
    Coin coinB = new Coin(liste_murs.size() + 2, TriangleId, 2, Double.parseDouble(Bcx.getText()) , Double.parseDouble(Bcy.getText()), idNiveau);
    Coin coinC = new Coin(liste_murs.size() + 3, TriangleId, 3, Double.parseDouble(Ccx.getText()) , Double.parseDouble(Ccy.getText()), idNiveau);
    

    liste_coins.add(coinA);
    liste_coins.add(coinB);
    liste_coins.add(coinC);
  
Plafond_Triangle plafond = new Plafond_Triangle(TriangleId,coinA, coinB, coinC, 0, 0, idNiveau);
liste_plafondstriangle.add(plafond);

Sol_Triangle sol = new Sol_Triangle(TriangleId,coinA, coinB, coinC, 0, 0, idNiveau);
liste_solstriangle.add(sol);

Mur mur1 = new Mur(liste_murs.size() + 1, TriangleId, 1, 0, 0, coinA, coinB, 0, 0,idNiveau);
Mur mur2 = new Mur(liste_murs.size() + 2, TriangleId, 2, 0, 0, coinB, coinC, 0, 0,idNiveau);
Mur mur3 = new Mur(liste_murs.size() + 3, TriangleId, 3, 0, 0, coinA, coinC, 0, 0,idNiveau);


liste_murstriangle.add(mur1);
liste_murstriangle.add(mur2);
liste_murstriangle.add(mur3);





            listeTriangles.add(triangle);
                
                
                
                });
        
        Button btSaveT = new Button("Sauvegarder triangles");
        pane.add(btSaveT, 6, 5);
        btSaveT.setOnAction(evt -> {
        PrintWriter pwT;
    try {
        pwT = new PrintWriter(new FileOutputStream("triangle.txt", true));
        for (Triangle triangle : listeTriangles) {   
            pwT.println("Triangle;" + triangle.getAcx() + ";" + triangle.getAcy() + ";" + triangle.getBcx() + ";" + triangle.getBcy() + ";" + triangle.getCcx() + ";" + triangle.getCcy()+ ";" + distancePoints(Double.parseDouble(Acx.getText()), Double.parseDouble(Acy.getText()), Double.parseDouble(Bcx.getText()), Double.parseDouble(Bcy.getText())) + ";" + distancePoints(Double.parseDouble(Bcx.getText()), Double.parseDouble(Bcy.getText()), Double.parseDouble(Ccx.getText()), Double.parseDouble(Ccy.getText()))+ ";"+distancePoints(Double.parseDouble(Ccx.getText()), Double.parseDouble(Ccy.getText()), Double.parseDouble(Acx.getText()), Double.parseDouble(Acy.getText()))+ ";"+triangle.getIdNiveau());
        }
       
        pwT.close();
        System.out.println("Triangles et coins sauvegardés dans le fichier triangles.txt");
        } catch (FileNotFoundException e) {
        e.printStackTrace();
    }  
    PrintWriter pwcoinT;
    try { 
        pwcoinT= new PrintWriter (new FileOutputStream("coinT.txt", true));
        for (Coin coin : liste_coins) {
            pwcoinT.println("CoinT;" + coin.idcoin + ";" + coin.rectangleId + ";" + coin.coinNumber + ";" + coin.cx + ";" + coin.cy+ ";" + coin.idNiveau);
        }
        pwcoinT.close();
        } catch (FileNotFoundException e) {
        e.printStackTrace();
    }  
    PrintWriter pwmurT;
try { 
    pwmurT = new PrintWriter (new FileOutputStream("mur1 triangle.txt", true));
    for (Mur mur : liste_murstriangle) {
        pwmurT.println("MurT;" + mur.idMur + ";" + mur.rectangleId + ";" + mur.numero_mur + ";" + mur.nbrePortes + ";" + mur.nbreFenetres + ";" + mur.coinDebut.idcoin + ";" + mur.coinFin.idcoin + ";" + mur.hauteur);
    }
    pwmurT.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
}
});
        
        Button btRevT = new Button("Choisir revêtement triangle");
        pane.add(btRevT, 7, 5);
        btRevT.setOnAction(evt -> {
            // Ouvrir une nouvelle fenêtre pour choisir le revêtement
            RevetementFenetreTriangle revetmentWindow = new RevetementFenetreTriangle(listeTriangles.size(), liste_murstriangle, liste_plafondstriangle, liste_solstriangle,idNiveau,hauteurSousPlafond);
                                                      
            revetmentWindow.start(new Stage());
        });
        
        
        VBox paneV = new VBox();
        paneV.setPadding(new Insets(10, 50, 50, 50));
        paneV.setSpacing(10);

        paneV.getChildren().add(pane);
        paneV.getChildren().add(paneH);

        // Graphe de scène avec des nœuds
        Scene scene = new Scene(paneV, 1500, 600);  // Construire une scène à partir de la racine du graphe de scène
        primaryStage.setScene(scene);               // The stage sets scene
        primaryStage.show();                        // Définir la visibilité (l'afficher)
    
    
                }
    public static void main(String[] args) {
        launch(args);
    }
}*/

import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
import javafx.scene.control.ComboBox;
import javafx.scene.shape.Polygon;

public class App extends Application {
  
   
    
     private Stage primaryStage;
     Pane paneH = new Pane();
     private int NombreQuadrilatere;
     private int NombreTriangle;

     List<Mur> listeMurs;
     List<Plafond> listePlafonds;
     List<Sol> listeSols;
     ArrayList<Rec> liste_quadrilateres = new ArrayList<Rec>();
     ArrayList<Rectangle> liste_rectangles = new ArrayList<Rectangle>();
     ArrayList<Coin> liste_coins = new ArrayList<Coin>();
     ArrayList<Mur> liste_murs = new ArrayList<Mur>();
     ArrayList<Mur> liste_murstriangle = new ArrayList<Mur>();
     ArrayList<Plafond> liste_plafonds = new ArrayList<Plafond>();
     ArrayList<Plafond_Triangle> liste_plafondstriangle = new ArrayList<Plafond_Triangle>();
     ArrayList<Sol_Triangle> liste_solstriangle = new ArrayList<Sol_Triangle>();
     ArrayList<Sol> liste_sols = new ArrayList<Sol>();
     ArrayList<Triangle> listeTriangles = new ArrayList<Triangle>();
     TextField   cx1 = new TextField();
     TextField   cy1 = new TextField();
     TextField   cx2 = new TextField();
     TextField   cy2 = new TextField();
     TextField   cx3 = new TextField();
     TextField   cy3 = new TextField();
     TextField   cx4 = new TextField();
     TextField   cy4 = new TextField();
     TextField   Acx = new TextField();
     TextField   Acy = new TextField();
     TextField   Bcx = new TextField();
     TextField   Bcy = new TextField();
     TextField   Ccx = new TextField();
     TextField   Ccy = new TextField();
     Text label1 = new Text("Coordonnées Coin 1 (x,y):");
     Text label2 = new Text("Coordonnées Coin 2 (x,y):");
     Text label3 = new Text("Coordonnées Coin 3 (x,y):");
     Text label4 = new Text("Coordonnées Coin 4 (x,y):");
     Text labelA = new Text("Coordonnées Sommet A (x,y):");
     Text labelB = new Text("Coordonnées Sommet B (x,y):");
     Text labelC = new Text("Coordonnées Sommet C (x,y):");
     Button btAjouter = new Button("Ajouter rectangle");
     Button btAjouterT = new Button("Ajouter triangle");
     Button btFin = new Button("Accueil");
     Button btRev = new Button("Choisir revêtement");
     Button btRevT = new Button("Choisir revêtement triangle");
     ComboBox<String> forme = ComboboxRecTri();
     
        
     private static final Color[] COLORS = {
     Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.BLUE, Color.PURPLE, Color.CYAN,
     Color.MAGENTA, Color.YELLOW, Color.GRAY, Color.PINK, Color.LIME, Color.BROWN};
     private int currentColorIndex = 0; // Index pour suivre la couleur actuelle
    
    
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
    int nombreNiveau ;
    
    public void openMainWindow(int idNiveau, double hauteurSousPlafond) {
        this.idNiveau = idNiveau;
        this.hauteurSousPlafond = hauteurSousPlafond;
       
        
        paneH.getChildren().clear();
        liste_quadrilateres.clear();
        listeTriangles.clear();
        listeMurs = new ArrayList<>();
        listePlafonds = new ArrayList<>();
        listeSols = new ArrayList<>();
        primaryStage.setTitle("Rectangles");
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        
        
        
        pane.add(forme, 0, 0);
        Forme_choisie();
        forme.setOnAction(evt -> {Forme_choisie();});
        
        // Place nodes in the pane at positions column,row
        
        pane.add(label1, 2, 0);
        pane.add(cx1, 3, 0);
        pane.add(cy1, 4, 0);

        
        pane.add(label2, 2, 1);
        pane.add(cx2, 3, 1);
        pane.add(cy2, 4, 1);

        
        pane.add(label3, 2, 2);
        pane.add(cx3, 3, 2);
        pane.add(cy3, 4, 2);

        
        pane.add(label4, 2, 3);
        pane.add(cx4, 3, 3);
        pane.add(cy4, 4, 3);

        
        pane.add(labelA, 2, 0);
        pane.add(Acx, 3, 0);
        pane.add(Acy, 4, 0);

       
        pane.add(labelB, 2, 1);
        pane.add(Bcx, 3, 1);
        pane.add(Bcy, 4, 1);

       
        pane.add(labelC, 2, 2);
        pane.add(Ccx, 3, 2);
        pane.add(Ccy, 4, 2);

        
        
        
        
        
        pane.add(btAjouter, 3, 5);
        // Expression lambda pour construire un EventHandler<ActionEvent>
        btAjouter.setOnAction(evt -> {
         Creerrectangle(); 
         CreerPieceRectangulaire();
         sauvegarderRectangles(); 
         dessinerPiece();
         
         
    
    
   /* try { 
        pwobjet= new PrintWriter (new FileOutputStream("infos_objets.txt", true));
        for (Coin coin : liste_coins) {
        pwobjet.println("Coin;" + coin.idcoin + ";" + coin.rectangleId + ";" + coin.coinNumber + ";" + coin.cx + ";" + coin.cy+ ";" + coin.idNiveau);
        }
        for (Sol sol : liste_sols) {
        pwobjet.println("Sol;" +  sol.rectangleId + ";" + sol.coin1.idcoin + ";" + sol.coin2.idcoin + ";" + sol.coin3.idcoin + ";" + sol.coin4.idcoin + ";" + sol.listeRevetement + ";" + sol.tremie );
    }
        for (Plafond plafond : liste_plafonds) {
        pwobjet.println("Plafond;" +  plafond.rectangleId + ";" + plafond.coin1.idcoin + ";" + plafond.coin2.idcoin + ";" + plafond.coin3.idcoin + ";" + plafond.coin4.idcoin + ";" + plafond.listeRevetement + ";" + plafond.tremie );
    }
        for (Mur mur : liste_murs) {
        pwobjet.println("Mur;" + mur.idMur + ";" + mur.rectangleId + ";" + mur.numero_mur + ";" + mur.nbrePortes + ";" + mur.nbreFenetres + ";" + mur.coinDebut.idcoin + ";" + mur.coinFin.idcoin + ";" + mur.listeRevetement +";" + mur.hauteur + ";" + mur.idNiveau);
    }
        for (Coin coin : liste_coins) {
        pwobjet.println("Coin;" + coin.idcoin + ";" + coin.rectangleId + ";" + coin.coinNumber + ";" + coin.cx + ";" + coin.cy+ ";" + coin.idNiveau);
        }
        pwobjet.close();
        } catch (FileNotFoundException e) {
        e.printStackTrace();
        
    }  */
        });
        
        
        pane.add(btAjouterT, 3, 5);
        btAjouterT.setOnAction(evt -> {
         Creertriangle();
         CreerPieceTriangulaire();
         sauvegarderTriangles();
         dessinerPiece();         
                });

        
        pane.add(btFin, 11, 5);
        btFin.setOnAction(evt -> {
        Ajout.idNiveau++;  // Incrémente le niveau chaque fois que le bouton est cliqué
        Stage newStage = new Stage();            // Crée un nouveau stage
        Ajout ajoutWindow = new Ajout(this );     // Crée une nouvelle instance de Ajout
        ajoutWindow.start(newStage);             // Lance Ajout sur le nouveau stage
        primaryStage.close();
          }); 
  
        
        
        
        pane.add(btRev, 4, 5);
        btRev.setOnAction(evt -> {
        RevetementFenetre revetmentWindow = new RevetementFenetre(liste_quadrilateres.size(), listeMurs, listePlafonds, listeSols,idNiveau,hauteurSousPlafond);
        revetmentWindow.start(new Stage());
        });

        
        
        
        
        pane.add(btRevT, 4, 5);
        btRevT.setOnAction(evt -> {
            RevetementFenetreTriangle revetmentWindow = new RevetementFenetreTriangle(listeTriangles.size(), liste_murstriangle, liste_plafondstriangle, liste_solstriangle,idNiveau,hauteurSousPlafond);                                     
            revetmentWindow.start(new Stage());
        });
        
        
        
        
        VBox paneV = new VBox();
        paneV.setPadding(new Insets(10, 50, 50, 50));
        paneV.setSpacing(10);

        paneV.getChildren().add(pane);
        paneV.getChildren().add(paneH);

        // Graphe de scène avec des nœuds
        Scene scene = new Scene(paneV, 1500, 600);  // Construire une scène à partir de la racine du graphe de scène
        primaryStage.setScene(scene);               // The stage sets scene
        primaryStage.show();                        // Définir la visibilité (l'afficher)
    
                }
    
    private void Forme_choisie(){
        String forme_choisie = forme.getValue();
        if ("Rectangle".equals(forme_choisie)) {
            cx1.setVisible(true);
            cy1.setVisible(true);
            cx2.setVisible(true);
            cy2.setVisible(true);
            cx3.setVisible(true);
            cy3.setVisible(true);
            cx4.setVisible(true);
            cy4.setVisible(true);
            btAjouter.setVisible(true);
            btRev.setVisible(true);
            btFin.setVisible(true);
            label1.setVisible(true);
            label2.setVisible(true);
            label3.setVisible(true);
            label4.setVisible(true);
            Acx.setVisible(false);
            Acy.setVisible(false);
            Bcx.setVisible(false);
            Bcy.setVisible(false);
            Ccx.setVisible(false);
            Ccy.setVisible(false);
            btAjouterT.setVisible(false);
            btRevT.setVisible(false);
            labelA.setVisible(false);
            labelB.setVisible(false);
            labelC.setVisible(false);
            
        } else if ("Triangle".equals(forme_choisie)) {
            cx1.setVisible(false);
            cy1.setVisible(false);
            cx2.setVisible(false);
            cy2.setVisible(false);
            cx3.setVisible(false);
            cy3.setVisible(false);
            cx4.setVisible(false);
            cy4.setVisible(false);
            btAjouter.setVisible(false);
            btRev.setVisible(false);
            btFin.setVisible(true);
            label1.setVisible(false);
            label2.setVisible(false);
            label3.setVisible(false);
            label4.setVisible(false);
            Acx.setVisible(true);
            Acy.setVisible(true);
            Bcx.setVisible(true);
            Bcy.setVisible(true);
            Ccx.setVisible(true);
            Ccy.setVisible(true);
            btAjouterT.setVisible(true);
            btRevT.setVisible(true);
            labelA.setVisible(true);
            labelB.setVisible(true);
            labelC.setVisible(true);
        }
    }
    
  
    public static double distancePoints(double x1, double y1, double x2, double y2) {
    if(x1>x2 && y1>y2){
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
    if(x1<x2 && y1<y2){
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
    if(x1>x2 && y1<y2){
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y2 - y1, 2));
    }
    if(x1<x2 && y1>y2){
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y1 - y2, 2));
    }
    if(x1==x2 && y1==y2){
        return 0;
    }
    if(x1==x2 && y1>y2){
        return Math.sqrt(Math.pow(y1 - y2, 2));
    }
    if(x1==x2 && y1<y2){
        return Math.sqrt(Math.pow(y2 - y1, 2));
    }
    if(x1<x2 && y1==y2){
        return Math.sqrt(Math.pow(x2 - x1, 2) );
    }
    if(x1>x2 && y1==y2){
        return Math.sqrt(Math.pow(x1 - x2, 2) );
    }
    else {
        return 0;}
}
    
     private void dessinerPiece(){
          // Dessiner les rectangles ici
            paneH.getChildren().clear(); // Effacer les anciens quadrilatères

for (int i = 0; i < liste_quadrilateres.size(); i++) {
    Text text = new Text("Quadrilatère " + (i + 1)); // Ajout du numéro
    StackPane stack = new StackPane();
    Polygon quadrilatere = new Polygon();
    
    // Ajout des points du quadrilatère
    quadrilatere.getPoints().addAll(
        liste_quadrilateres.get(i).getCx1() * 10, liste_quadrilateres.get(i).getCy1() * 10,
        liste_quadrilateres.get(i).getCx2() * 10, liste_quadrilateres.get(i).getCy2() * 10,
        liste_quadrilateres.get(i).getCx3() * 10, liste_quadrilateres.get(i).getCy3() * 10,
        liste_quadrilateres.get(i).getCx4() * 10, liste_quadrilateres.get(i).getCy4() * 10
    );
    
    quadrilatere.setStroke(COLORS[currentColorIndex]);
    quadrilatere.setFill(Color.WHITE);

    stack.setAlignment(Pos.CENTER);
    stack.getChildren().addAll(quadrilatere, text);
    stack.setLayoutX(Math.min(liste_quadrilateres.get(i).getCx1(), 
                               Math.min(liste_quadrilateres.get(i).getCx2(), 
                                        Math.min(liste_quadrilateres.get(i).getCx3(), 
                                                 liste_quadrilateres.get(i).getCx4()))) * 10);
    stack.setLayoutY(Math.min(liste_quadrilateres.get(i).getCy1(), 
                               Math.min(liste_quadrilateres.get(i).getCy2(), 
                                        Math.min(liste_quadrilateres.get(i).getCy3(), 
                                                 liste_quadrilateres.get(i).getCy4()))) * 10);
    
    // Mettez à jour l'indice de couleur pour le prochain quadrilatère
    currentColorIndex = (currentColorIndex + 1) % COLORS.length;

    paneH.getChildren().addAll(stack);
    NombreQuadrilatere = i + 1;


            }
            for (int i = 0; i < listeTriangles.size(); i++) {
            Triangle triangle = listeTriangles.get(i);

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

            paneH.getChildren().add(stackPane);

            // Mettre à jour l'indice de couleur pour le prochain triangle
            currentColorIndex = (currentColorIndex + 1) % COLORS.length;
        }
     }
     
     
     private void Creerrectangle(){
         Rec rec = new Rec(Double.parseDouble(cx1.getText()),
                      Double.parseDouble(cy1.getText()),
                      Double.parseDouble(cx2.getText()),
                      Double.parseDouble(cy2.getText()),
                      Double.parseDouble(cx3.getText()),
                      Double.parseDouble(cy3.getText()),
                      Double.parseDouble(cx4.getText()),
                      Double.parseDouble(cy4.getText()),
                      idNiveau
            );
            liste_quadrilateres.add(rec);}
     
     private void Creertriangle(){
     Triangle triangle = new Triangle(Double.parseDouble(Acx.getText()),
                    Double.parseDouble(Acy.getText()),
                    Double.parseDouble(Bcx.getText()),
                    Double.parseDouble(Bcy.getText()),
                    Double.parseDouble(Ccx.getText()),
                    Double.parseDouble(Ccy.getText()),
                    distancePoints(Double.parseDouble(Acx.getText()), Double.parseDouble(Acy.getText()), Double.parseDouble(Bcx.getText()), Double.parseDouble(Bcy.getText())),
                    distancePoints(Double.parseDouble(Bcx.getText()), Double.parseDouble(Bcy.getText()), Double.parseDouble(Ccx.getText()), Double.parseDouble(Ccy.getText())),
                    distancePoints(Double.parseDouble(Ccx.getText()), Double.parseDouble(Ccy.getText()), Double.parseDouble(Acx.getText()), Double.parseDouble(Acy.getText())),
                    idNiveau
                 );
         listeTriangles.add(triangle);}
     
     private void CreerPieceTriangulaire() {
    
    Coin coinA = creationCoin(Double.parseDouble(Acx.getText()), Double.parseDouble(Acy.getText()), idNiveau);
    Coin coinB = creationCoin(Double.parseDouble(Bcx.getText()), Double.parseDouble(Bcy.getText()), idNiveau);
    Coin coinC = creationCoin(Double.parseDouble(Ccx.getText()), Double.parseDouble(Ccy.getText()), idNiveau);

    // Ajout des coins à la liste des coins
    liste_coins.add(coinA);
    liste_coins.add(coinB);
    liste_coins.add(coinC);

    // Création du plafond et du sol
    creationPlafondTriangle(coinA, coinB, coinC, idNiveau);
    creationSolTriangle(coinA, coinB, coinC, idNiveau);

    // Création des murs
    creationMurTriangle(coinA, coinB, coinC, idNiveau);
}

private void creationPlafondTriangle(Coin coinA, Coin coinB, Coin coinC, int idNiveau) {
    int TriangleId = listeTriangles.size();
    Plafond_Triangle plafond = new Plafond_Triangle(TriangleId, coinA, coinB, coinC, 0, 0, idNiveau);
    liste_plafondstriangle.add(plafond);
}

private void creationSolTriangle(Coin coinA, Coin coinB, Coin coinC, int idNiveau) {
    int TriangleId = listeTriangles.size();
    Sol_Triangle sol = new Sol_Triangle(TriangleId, coinA, coinB, coinC, 0, 0, idNiveau);
    liste_solstriangle.add(sol);
}

private void creationMurTriangle(Coin coinA, Coin coinB, Coin coinC, int idNiveau) {
    int TriangleId = listeTriangles.size();
    Mur mur1 = new Mur(liste_murs.size() + 1, TriangleId, 1, 0, 0, coinA, coinB, 0, 0, idNiveau);
    Mur mur2 = new Mur(liste_murs.size() + 2, TriangleId, 2, 0, 0, coinB, coinC, 0, 0, idNiveau);
    Mur mur3 = new Mur(liste_murs.size() + 3, TriangleId, 3, 0, 0, coinA, coinC, 0, 0, idNiveau);

    liste_murstriangle.add(mur1);
    liste_murstriangle.add(mur2);
    liste_murstriangle.add(mur3);
}

     
     private void CreerPieceRectangulaire() {
    // Création des coins
    Coin coin1 = creationCoin(Double.parseDouble(cx1.getText()), Double.parseDouble(cy1.getText()), idNiveau);
    Coin coin2 = creationCoin(Double.parseDouble(cx2.getText()), Double.parseDouble(cy2.getText()), idNiveau);
    Coin coin3 = creationCoin(Double.parseDouble(cx3.getText()), Double.parseDouble(cy3.getText()), idNiveau);
    Coin coin4 = creationCoin(Double.parseDouble(cx4.getText()), Double.parseDouble(cy4.getText()), idNiveau);

    // Ajout des coins à la liste des coins
    liste_coins.add(coin1);
    liste_coins.add(coin2);
    liste_coins.add(coin3);
    liste_coins.add(coin4);

    // Création du mur, du plafond et du sol
    creationMur(coin1, coin2, 1, idNiveau);
    creationMur(coin2, coin3, 2, idNiveau);
    creationMur(coin3, coin4, 3, idNiveau);
    creationMur(coin4, coin1, 4, idNiveau);

    creationPlafond(coin1, coin2, coin3, coin4, idNiveau);
    creationSol(coin1, coin2, coin3, coin4, idNiveau);
}

private void creationMur(Coin coin1, Coin coin2, int numero, int idNiveau) {
    int rectangleId = liste_quadrilateres.size();
    Mur mur = new Mur(liste_murs.size() + 1, rectangleId, numero, 0, 0, coin1, coin2, 0, 0, idNiveau);
    liste_murs.add(mur);
    listeMurs.add(mur);
}

private void creationPlafond(Coin coin1, Coin coin2, Coin coin3, Coin coin4, int idNiveau) {
    int rectangleId = liste_quadrilateres.size();
    Plafond plafond = new Plafond(rectangleId, coin1, coin2, coin3, coin4, 0, 0, idNiveau);
    liste_plafonds.add(plafond);
    listePlafonds.add(plafond);
}

private void creationSol(Coin coin1, Coin coin2, Coin coin3, Coin coin4, int idNiveau) {
    int rectangleId = liste_quadrilateres.size();
    Sol sol = new Sol(rectangleId, coin1, coin2, coin3, coin4, 0, 0, idNiveau);
    liste_sols.add(sol);
    listeSols.add(sol);
}

private Coin creationCoin(double x, double y, int idNiveau) {
    int rectangleId = liste_quadrilateres.size();
    return new Coin(liste_coins.size() + 1, rectangleId, liste_coins.size() + 1, x, y, idNiveau);
}


private void sauvegarderTriangles(){
    PrintWriter pwT;
    try {
        pwT = new PrintWriter(new FileOutputStream("triangle.txt", true));
        for (Triangle triangle : listeTriangles) {   
            pwT.println("Triangle;" + triangle.getAcx() + ";" + triangle.getAcy() + ";" + triangle.getBcx() + ";" + triangle.getBcy() + ";" + triangle.getCcx() + ";" + triangle.getCcy()+ ";" + distancePoints(Double.parseDouble(Acx.getText()), Double.parseDouble(Acy.getText()), Double.parseDouble(Bcx.getText()), Double.parseDouble(Bcy.getText())) + ";" + distancePoints(Double.parseDouble(Bcx.getText()), Double.parseDouble(Bcy.getText()), Double.parseDouble(Ccx.getText()), Double.parseDouble(Ccy.getText()))+ ";"+distancePoints(Double.parseDouble(Ccx.getText()), Double.parseDouble(Ccy.getText()), Double.parseDouble(Acx.getText()), Double.parseDouble(Acy.getText()))+ ";"+triangle.getIdNiveau());
        }
        pwT.close();
        System.out.println("Triangles et coins sauvegardés dans le fichier triangles.txt");
        } catch (FileNotFoundException e) {
        e.printStackTrace();
    }  
    PrintWriter pwcoinT;
    try { 
        pwcoinT= new PrintWriter (new FileOutputStream("coinT.txt", true));
        for (Coin coin : liste_coins) {
            pwcoinT.println("CoinT;" + coin.idcoin + ";" + coin.rectangleId + ";" + coin.coinNumber + ";" + coin.cx + ";" + coin.cy+ ";" + coin.idNiveau);
        }
        pwcoinT.close();
        } catch (FileNotFoundException e) {
        e.printStackTrace();
    }  
    PrintWriter pwmurT;
try { 
    pwmurT = new PrintWriter (new FileOutputStream("mur1 triangle.txt", true));
    for (Mur mur : liste_murstriangle) {
        pwmurT.println("MurT;" + mur.idMur + ";" + mur.rectangleId + ";" + mur.numero_mur + ";" + mur.nbrePortes + ";" + mur.nbreFenetres + ";" + mur.coinDebut.idcoin + ";" + mur.coinFin.idcoin + ";" + mur.hauteur);
    }
    pwmurT.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
}


}

     private void sauvegarderRectangles() {
         PrintWriter pw;
    try {
        pw = new PrintWriter(new FileOutputStream("rectangles.txt", true));
        for (Rec rec : liste_quadrilateres) {
            pw.println("Rectangle;" + rec.getCx1() + ";" + rec.getCy1() + ";" + rec.getCx2() + ";" + rec.getCy2() + ";" + rec.getCx3()+ ";" + rec.getCy3() + ";" + rec.getCx4() + ";" + rec.getCy4()+ ";"+rec.getIdNiveau());
        }
        pw.close();
        System.out.println("Rectangles et coins sauvegardés dans le fichier rectangles.txt");
        } catch (FileNotFoundException e) {
        e.printStackTrace();
    }  
    
    
    PrintWriter pwcoin;
    try { 
        pwcoin= new PrintWriter (new FileOutputStream("coin.txt", true));
        for (Coin coin : liste_coins) {
            pwcoin.println("Coin;" + coin.idcoin + ";" + coin.rectangleId + ";" + coin.coinNumber + ";" + coin.cx + ";" + coin.cy+ ";" + coin.idNiveau);
        }
        pwcoin.close();
        } catch (FileNotFoundException e) {
        e.printStackTrace();
    }  
    PrintWriter pwmur;
try { 
    pwmur = new PrintWriter (new FileOutputStream("mur1.txt", true));
    for (Mur mur : liste_murs) {
        pwmur.println("Mur;" + mur.idMur + ";" + mur.rectangleId + ";" + mur.numero_mur + ";" + mur.nbrePortes + ";" + mur.nbreFenetres + ";" + mur.coinDebut.idcoin + ";" + mur.coinFin.idcoin + ";" + mur.listeRevetement +";" + mur.hauteur + ";" + mur.idNiveau);
    }
    pwmur.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
}
    PrintWriter pwplafond;
try { 
    pwplafond = new PrintWriter (new FileOutputStream("plafond1.txt", true));
    for (Plafond plafond : liste_plafonds) {
        pwplafond.println("Plafond;" +  plafond.rectangleId + ";" + plafond.coin1.idcoin + ";" + plafond.coin2.idcoin + ";" + plafond.coin3.idcoin + ";" + plafond.coin4.idcoin + ";" + plafond.listeRevetement + ";" + plafond.tremie );
    }
    pwplafond.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
}

PrintWriter pwsol;
try { 
    pwsol = new PrintWriter (new FileOutputStream("sol1.txt", true));
    for (Sol sol : liste_sols) {
        pwsol.println("Sol;" +  sol.rectangleId + ";" + sol.coin1.idcoin + ";" + sol.coin2.idcoin + ";" + sol.coin3.idcoin + ";" + sol.coin4.idcoin + ";" + sol.listeRevetement + ";" + sol.tremie );
    }
    pwsol.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
}
     }
     
     private ComboBox<String> ComboboxRecTri() {
        ComboBox<String> combobox = new ComboBox<>();
         combobox.getItems().addAll("Rectangle", "Triangle");
         combobox.setValue("Rectangle");
        
        return combobox;
    }
     
     
    public static void main(String[] args) {
        launch(args);
    }
}