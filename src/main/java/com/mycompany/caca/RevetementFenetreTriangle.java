/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caca;

/**
 *
 * @author fabre
 */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class RevetementFenetreTriangle extends Application {
    
    
    private Stage appStage;
    private int nombreTriangles;
    List<Mur> liste_murstriangle;
    List<Plafond_Triangle> liste_plafondstriangle;
    List<Sol_Triangle> liste_solstriangle;
    int idNiveau;
    double hauteurSousPlafond;    
    
    
    
    // Ajout du constructeur pour initialiser le nombre de rectangles

    public RevetementFenetreTriangle(int nombreTriangles, List<Mur> liste_murstriangle, List<Plafond_Triangle> liste_plafondstriangle, List<Sol_Triangle> liste_solstriangle, int idNiveau, double hauteurSousPlafond) {
        this.nombreTriangles = nombreTriangles;
        this.liste_murstriangle = liste_murstriangle;
        this.liste_plafondstriangle = liste_plafondstriangle;
        this.liste_solstriangle = liste_solstriangle;
        this.idNiveau = idNiveau;
        this.hauteurSousPlafond = hauteurSousPlafond;
    }
    
    
    
   

    private int getSelectedValue(ComboBox<Integer> comboBox) {
        return comboBox.getValue();
    }


    private void saveButtonAction(Button saveButton, ComboBox<Integer> comboBox, String label) {
           
            System.out.println(label + " sélectionné : " +  comboBox.getValue());
          
        
    }
    
  
      public double Prix_mur(int nbrePortes, int nbreFenetres, double longueur, double hauteur, double prix_revetement) {
     double prix;      
     prix=(longueur * hauteur - 0.6 * nbrePortes - 0.6 * nbreFenetres) * prix_revetement + 200 * nbrePortes + 200 * nbreFenetres;
     System.out.println (prix);
        return prix;
     }
      
      public Mur RetrouverMur( int TriangleId, int numero_mur, int idNiveau){
        for (Mur mur: liste_murstriangle) {
            if (TriangleId == mur.getRectangleId() && numero_mur == mur.getNumero_mur() && mur.getIdNiveau() == idNiveau){
                return mur;}
        }
    return null;
    
      }
      
      public Plafond_Triangle RetrouverPlafond( int TriangleId, int idNiveau){
        for (Plafond_Triangle plafond: liste_plafondstriangle) {
            if (TriangleId == plafond.getRectangleId() && plafond.getIdNiveau() == idNiveau ){
                return plafond;}
        }
    return null;
    
      }
      
      public Sol_Triangle RetrouverSol( int TriangleId, int idNiveau){
        for (Sol_Triangle sol: liste_solstriangle) {
            if (TriangleId == sol.getRectangleId() && sol.getIdNiveau() == idNiveau ){
                return sol;}
        }
    return null;
    
      }
      
      
      private Mur MajMur (int TriangleId, int numero_mur, int nbrePortes, int nbreFenetres, int listeRevetement, double hauteur,int idNiveau){
          Mur mur = RetrouverMur( TriangleId, numero_mur,idNiveau);
         // if ( mur=! null){    à remettre si on ajoute le null
              mur.setListeRevetement(listeRevetement);
              mur.setNbrePortes(nbrePortes);
              mur.setNbreFenetres(nbreFenetres);
              mur.setHauteur(hauteur);
              System.out.println(mur.toString());
              return mur;
          }
        //  else {
        //      System.out.println("Aucun mur trouve");}
    //  }
              
      private Plafond_Triangle MajPlafond (int TriangleId, int listeRevetement, int tremie, int idNiveau){
          Plafond_Triangle plafond = RetrouverPlafond( TriangleId,idNiveau);
         // if ( mur=! null){    à remettre si on ajoute le null
              plafond.setListeRevetement(listeRevetement);
              plafond.setTremie(tremie);
              
              System.out.println(plafond.toString());
              return plafond;
          }
        //  else {
        //      System.out.println("Aucun mur trouve");}
    //  }
      
      
      private Sol_Triangle MajSol (int TriangleId, int listeRevetement, int tremie, int idNiveau){
          Sol_Triangle sol = RetrouverSol(TriangleId, idNiveau);
         // if ( mur=! null){    à remettre si on ajoute le null
              sol.setListeRevetement(listeRevetement);
              sol.setTremie(tremie);
              
              System.out.println(sol.toString());
              return sol;
          }
        //  else {
        //      System.out.println("Aucun mur trouve");}
    //  }
      
      
      
   public double calculerPrixPiece(PieceTriangle piece) {
        double prixTotal = 0;

        // Calcul du prix de chaque mur
        for (Mur mur : new Mur[]{piece.getMur1(), piece.getMur2(), piece.getMur3()}) {
        double longueur = distancePoints(mur.getCoinDebut().getX(),mur.getCoinDebut().getY(),mur.getCoinFin().getX(),mur.getCoinFin().getY());
        double hauteur = mur.getHauteur();
        double surfaceMur = longueur * hauteur;
        int nbrePortes = mur.getNbrePortes();
        int nbreFenetres = mur.getNbreFenetres();
        double prixRevetement = ElementRevetement(mur.getListeRevetement());
        double prixMur = (surfaceMur - (1.2 * 1.2 * nbreFenetres) - (0.9 * 2.10 * nbrePortes)) * prixRevetement;
        System.out.println("Prix mur" + prixMur);
       
        prixTotal = prixTotal+prixMur;
    }

    
    // Calcul du prix du sol
    double surfaceSol = calculerSurfaceSol(piece.getSol());
    int nbreTremiesSol = piece.getSol().getTremie();
    double prixRevetementSol = ElementRevetement(piece.getSol().getListeRevetement());
    double prixSol = (surfaceSol - (2 * 1 * nbreTremiesSol)) * prixRevetementSol;
    System.out.println("Prix sol" + prixSol);
     prixTotal = prixTotal+prixSol;

    // Calcul du prix du plafond
    double surfacePlafond = calculerSurfacePlafond(piece.getPlafond());
    int nbreTremiesPlafond = piece.getPlafond().getTremie();
    double prixRevetementPlafond = ElementRevetement(piece.getPlafond().getListeRevetement());
    double prixPlafond = (surfacePlafond - (2 * 1 * nbreTremiesPlafond)) * prixRevetementPlafond;
    System.out.println("Prix plafond" + prixPlafond);
     prixTotal = prixTotal+prixPlafond;

    return prixTotal;
}
   
   
    public double calculerPrixMur1(Mur mur) {
    double longueur = distancePoints(mur.getCoinDebut().getX(),mur.getCoinDebut().getY(),mur.getCoinFin().getX(),mur.getCoinFin().getY());
    double hauteur = mur.getHauteur();
    double surfaceMur1 = longueur * hauteur;
    int nbrePortes = mur.getNbrePortes();
    int nbreFenetres = mur.getNbreFenetres();
    double prixRevetement = ElementRevetement(mur.getListeRevetement());
    double prixMur1 = (surfaceMur1 - (1.2 * 1.2 * nbreFenetres) - (0.9 * 2.10 * nbrePortes)) * prixRevetement;
    System.out.println("Prix mur1: " + prixMur1);
    return prixMur1;
}

public double calculerPrixMur2(Mur mur) {
    double longueur = distancePoints(mur.getCoinDebut().getX(),mur.getCoinDebut().getY(),mur.getCoinFin().getX(),mur.getCoinFin().getY());
    double hauteur = mur.getHauteur();
    double surfaceMur2 = longueur * hauteur;
    int nbrePortes = mur.getNbrePortes();
    int nbreFenetres = mur.getNbreFenetres();
    double prixRevetement = ElementRevetement(mur.getListeRevetement());
    double prixMur2 = (surfaceMur2 - (1.2 * 1.2 * nbreFenetres) - (0.9 * 2.10 * nbrePortes)) * prixRevetement;
    System.out.println("Prix mur2: " + prixMur2);
    return prixMur2;
}

public double calculerPrixMur3(Mur mur) {
    double longueur = distancePoints(mur.getCoinDebut().getX(),mur.getCoinDebut().getY(),mur.getCoinFin().getX(),mur.getCoinFin().getY());
    double hauteur = mur.getHauteur();
    double surfaceMur3 = longueur * hauteur;
    int nbrePortes = mur.getNbrePortes();
    int nbreFenetres = mur.getNbreFenetres();
    double prixRevetement = ElementRevetement(mur.getListeRevetement());
    double prixMur3 = (surfaceMur3 - (1.2 * 1.2 * nbreFenetres) - (0.9 * 2.10 * nbrePortes)) * prixRevetement;
    System.out.println("Prix mur3: " + prixMur3);
    return prixMur3;
}



public double calculerPrixSol(Sol_Triangle sol) {
    double surfaceSol = calculerSurfaceSol(sol);
    int nbreTremiesSol = sol.getTremie();
    double prixRevetementSol = ElementRevetement(sol.getListeRevetement());
    double prixSol = (surfaceSol - (2 * 1 * nbreTremiesSol)) * prixRevetementSol;
    System.out.println("Prix sol: " + prixSol);
    return prixSol;
}

public double calculerPrixPlafond(Plafond_Triangle plafond) {
    double surfacePlafond = calculerSurfacePlafond(plafond);
    int nbreTremiesPlafond = plafond.getTremie();
    double prixRevetementPlafond = ElementRevetement(plafond.getListeRevetement());
    double prixPlafond = (surfacePlafond - (2 * 1 * nbreTremiesPlafond)) * prixRevetementPlafond;
    System.out.println("Prix plafond: " + prixPlafond);
    return prixPlafond;
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

private double calculerSurfaceMur(Mur mur) {
    double longueur=0;
    longueur = distancePoints(mur.getCoinDebut().getX(),mur.getCoinDebut().getY(),mur.getCoinFin().getX(),mur.getCoinFin().getY());
    double hauteur = mur.getHauteur();
     System.out.println("surface mur" +longueur * hauteur);
    return longueur * hauteur;
}   
   double longueurmur1;
   double longueurmur2;
   double longueurmur3;
   double longueurmur4;
   double surfacesol;
   double surfaceplafond;
   
   
   
// Fonction pour calculer la surface d'un mur



// Fonction pour calculer la surface du sol
public double calculerSurfaceSol(Sol_Triangle sol) {
    // Calcul des longueurs des côtés
    double sideA = distancePoints(sol.coin2.getX(),sol.coin2.getY(),sol.coin1.getX(),sol.coin1.getY());
    double sideB = distancePoints(sol.coin3.getX(),sol.coin3.getY(),sol.coin2.getX(),sol.coin2.getY());
    double sideC = distancePoints(sol.coin1.getX(),sol.coin1.getY(),sol.coin3.getX(),sol.coin3.getY());
    

    // Calcul du demi-périmètre
    double semiPerimeter = (sideA + sideB + sideC) / 2;

    // Calcul de l'aire en utilisant la formule de Héron
    double area = Math.sqrt(semiPerimeter * (semiPerimeter - sideA) * (semiPerimeter - sideB) * (semiPerimeter - sideC));
    
    return area;
}

// Fonction pour calculer la surface du plafond
public double calculerSurfacePlafond(Plafond_Triangle plafond) {
    // Calcul des longueurs des côtés
     double sideA = distancePoints(plafond.coin2.getX(),plafond.coin2.getY(),plafond.coin1.getX(),plafond.coin1.getY());
    double sideB = distancePoints(plafond.coin3.getX(),plafond.coin3.getY(),plafond.coin2.getX(),plafond.coin2.getY());
    double sideC = distancePoints(plafond.coin1.getX(),plafond.coin1.getY(),plafond.coin3.getX(),plafond.coin3.getY());

    // Calcul du demi-périmètre
    double semiPerimeter = (sideA + sideB + sideC) / 2;

    // Calcul de l'aire en utilisant la formule de Héron
    double area = Math.sqrt(semiPerimeter * (semiPerimeter - sideA) * (semiPerimeter - sideB) * (semiPerimeter - sideC));
    
    return area;
}

    // Fonction pour calculer le prix unitaire du revêtement
    public double ElementRevetement(int Revetement) {
        double prix = 0;

        switch (Revetement) {
            case 1:
                prix = 10.95;
                break;
            case 2:
                prix = 49.75;
                break;
            case 3:
                prix = 50.60;
                break;
            case 4:
                prix = 97.85;
                break;
            case 5:
                prix = 67.80;
                break;
            case 6:
                prix = 32.90;
                break;
            case 7:
                prix = 15.20;
                break;
            case 8:
                prix = 77.30;
                break;
            case 9:
                prix = 29.90;
                break;
            case 10:
                prix = 89.45;
                break;
            case 11:
                prix = 42.50;
                break;
            case 12:
                prix = 25.40;
                break;
            case 13:
                prix = 46.36;
                break;
            case 14:
                prix = 23.55;
                break;
            case 15:
                prix = 48.10;
                break;
            case 16:
                prix = 31.99;
                break;
            case 17:
                prix = 17.95;
                break;
            case 18:
                prix = 33.90;
                break;
            case 19:
                prix = 10.35;
                break;
        }

        return prix;
    }
          
     
    private void saveTextField(Button saveButton, TextField textField, String label) {
    
        
        System.out.println(label + " : " + textField.getText());
        
    }
    
    
    
    
    @Override
    public void start(Stage primaryStage) {
        appStage = primaryStage;
        ArrayList<Mur> liste_murs2 = new ArrayList<Mur>();
        ArrayList<Plafond_Triangle> liste_plafondstriangle2 = new ArrayList<Plafond_Triangle>();
        ArrayList<Sol_Triangle> liste_solstriangle2 = new ArrayList<Sol_Triangle>();
        ArrayList<PieceTriangle> liste_piecestriangle = new ArrayList<PieceTriangle>();
        ArrayList<PrixTriangle> liste_prixtriangle = new ArrayList<PrixTriangle>();
        int rectangleId;

        // Création du menu déroulant
        ComboBox<Integer> rectangleComboBox = createRectangleComboBox();
        ComboBox<Integer> AComboBox = createComboBoxMur();
        ComboBox<Integer> BComboBox = createComboBoxMur();
        ComboBox<Integer> CComboBox = createComboBoxMur();
        ComboBox<Integer> DComboBox = createComboBoxMur();
        ComboBox<Integer> EComboBox = createComboBoxSol();
        ComboBox<Integer> FComboBox = createComboBoxPlafond();
        
        
        TextField A1Text = createTextField();
        TextField A2Text = createTextField();
        TextField B1Text = createTextField();
        TextField B2Text = createTextField();
        TextField C1Text = createTextField();
        TextField C2Text = createTextField();
        TextField D1Text = createTextField();
        TextField D2Text = createTextField();
        TextField FText = createTextField();
        TextField GText = createTextField();
        TextField HText = createTextField();
        
        
      
        rectangleId= rectangleComboBox.getValue();
       
     
        
   
        Button saveButton6 = new Button("Enregistrer");
saveButton6.setOnAction(event -> {
    saveTextField(saveButton6, A2Text, "Nombre de fenetres");
    liste_murs2.add(MajMur (rectangleComboBox.getValue(), 1, Integer.parseInt(A1Text.getText()),Integer.parseInt(A2Text.getText()) , AComboBox.getValue(), Double.parseDouble(FText.getText()),idNiveau));
    
     
});


        Button saveButton7 = new Button("Enregistrer");
        saveButton7.setOnAction(event -> {
             saveTextField(saveButton7, B2Text, "Nombre de fenetres");

             liste_murs2.add(MajMur (rectangleComboBox.getValue(),2 , Integer.parseInt(B1Text.getText()),Integer.parseInt(B2Text.getText()) , BComboBox.getValue(), Double.parseDouble(FText.getText()),idNiveau));
        });

        Button saveButton8 = new Button("Enregistrer");
        saveButton8.setOnAction(event -> {
             saveTextField(saveButton8, C2Text, "Nombre de fenetres");
             liste_murs2.add(MajMur (rectangleComboBox.getValue(), 3, Integer.parseInt(C1Text.getText()),Integer.parseInt(C2Text.getText()) , CComboBox.getValue(), Double.parseDouble(FText.getText()), idNiveau));
        
            PrintWriter pwmur;
            try { 
            pwmur = new PrintWriter (new FileOutputStream("mur2.txt"));
            for (Mur mur : liste_murs2) {
            pwmur.println("Mur;" + mur.idMur + ";" + mur.rectangleId + ";" + mur.numero_mur + ";" + mur.nbrePortes + ";" + mur.nbreFenetres + ";" + mur.coinDebut.idcoin + ";" + mur.coinFin.idcoin + ";" + mur.listeRevetement +";" + mur.hauteur + ";" + mur.idNiveau);
               }
            pwmur.close();
            } catch (FileNotFoundException e) {
            e.printStackTrace();
            }
});

        
        
        Button saveButton11 = new Button("Enregistrer");
        saveButton11.setOnAction(event -> {
           liste_plafondstriangle2.add(MajPlafond (rectangleComboBox.getValue(), FComboBox.getValue(), Integer.parseInt(HText.getText()), idNiveau));
             PrintWriter pwplafond;
try { 
    pwplafond = new PrintWriter (new FileOutputStream("plafond_triangle_2.txt"));
    for (Plafond_Triangle plafond : liste_plafondstriangle2) {
        pwplafond.println("Plafond;" +  plafond.rectangleId + ";" + plafond.coin1.idcoin + ";" + plafond.coin2.idcoin + ";" + plafond.coin3.idcoin + ";" + plafond.listeRevetement + ";" + plafond.tremie + ";" + plafond.idNiveau);
    }
    pwplafond.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
}
            
        });
        
         Button saveButton10 = new Button("Enregistrer");
        saveButton10.setOnAction(event -> {
           liste_solstriangle2.add(MajSol (rectangleComboBox.getValue(), EComboBox.getValue(), Integer.parseInt(GText.getText()), idNiveau));
             PrintWriter pwsol;
try { 
    pwsol = new PrintWriter (new FileOutputStream("sol_triangle_2.txt"));
    for (Sol_Triangle sol : liste_solstriangle2) {
        pwsol.println("Sol;" +  sol.rectangleId + ";" + sol.coin1.idcoin + ";" + sol.coin2.idcoin + ";" + sol.coin3.idcoin + ";" + sol.listeRevetement + ";" + sol.tremie + ";" + sol.idNiveau);
    }
    pwsol.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
}
            
        });
         
        
        
       Button FinButton = new Button("Fin");
FinButton.setOnAction(event -> {
    primaryStage.close();    
    
    for (Plafond_Triangle plafond : liste_plafondstriangle2) {
    for (Sol_Triangle sol : liste_solstriangle2) {
        // Initialiser les murs
        Mur mur1 = null;
        Mur mur2 = null;
        Mur mur3 = null;
        int murCount = 0;

        // Parcourir les murs pour le rectangle courant
        for (Mur mur : liste_murs2) {
            if (mur.getRectangleId() == plafond.getRectangleId() && plafond.getRectangleId() == sol.getRectangleId() && mur.getRectangleId() == sol.getRectangleId()) {
               
                murCount++;
                switch (mur.getNumero_mur()) {
                    case 1:
                        mur1 = mur;
                        break;
                    case 2:
                        mur2 = mur;
                        break;
                    case 3:
                        mur3 = mur;
                        break;
                   
                }
            }
        }

        // Vérifier si tous les murs ont été trouvés
        if (murCount == 3) {
            // Créer la pièce
            PieceTriangle piece = new PieceTriangle(plafond.getRectangleId(), mur1, mur2, mur3, sol, plafond,idNiveau);
            liste_piecestriangle.add(piece);
        }
    }
}
PrintWriter pwpiece;
try { 
    pwpiece = new PrintWriter (new FileOutputStream("piece_triangle.txt"));
    for (PieceTriangle piece : liste_piecestriangle) {
        pwpiece.println("Piece;" +  piece.rectangleId + ";" + piece.mur1 + ";" + piece.mur2 + ";" + piece.mur3 + ";" + piece.sol + ";" + piece.plafond );
    }
    pwpiece.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
}

    for (PieceTriangle piece : liste_piecestriangle) {
        double prixPiece = calculerPrixPiece(piece);
        double prixMur1 = calculerPrixMur1(piece.getMur1());
        double prixMur2 = calculerPrixMur2(piece.getMur2());
        double prixMur3 = calculerPrixMur3(piece.getMur3());
        double prixSol = calculerPrixSol(piece.getSol());
        double prixPlafond = calculerPrixPlafond(piece.getPlafond());
        
        PrixTriangle prix = new PrixTriangle(idNiveau, piece.getRectangleId(), prixMur1, prixMur2, prixMur3, prixSol, prixPlafond, prixPiece);
        liste_prixtriangle.add(prix);
        System.out.println("Le prix de la pièce est : " + prixPiece + " €");
    }
    
    PrintWriter pwprix;
try { 
    pwprix = new PrintWriter (new FileOutputStream("prixTriangle.txt"));
    for (PrixTriangle prix : liste_prixtriangle) {
        pwprix.println("Prix;" +  prix.idNiveau + ";" + prix.rectangleId + ";" + prix.prixmur1 + ";" + prix.prixmur2 + ";" + prix.prixmur3 + ";" + prix.prixsol + ";" + prix.prixplafond +";" + prix.prixpiece );
    }
    pwprix.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
}
    
    
});

        String textePreRempli = String.valueOf(hauteurSousPlafond);

// Préremplir la zone de texte avec la chaîne de caractères
        FText.setText(textePreRempli);
        
        TextField hauteurPlafondField = new TextField(String.valueOf(hauteurSousPlafond));
        hauteurPlafondField.setEditable(false); // Rend le TextField non éditable
        
        // Création des libellés 
        Text label1 = new Text("Revêtements mur AB:");
        Text label2 = new Text("Revêtements mur BC:");
        Text label3 = new Text("Revêtements mur CA:");
       
        Text label5 = new Text("Revêtements sol:");
        Text label6 = new Text("Hauteur plafond:");
        Text label7 = new Text("Revêtements plafond");
        

               GridPane root = new GridPane();
        root.addRow(0, new Label("Triangle:"), rectangleComboBox);
        root.addRow(1, label1, AComboBox, new Label("Nombre de portes:"), A1Text , new Label("Nombre de fenêtres:"), A2Text , saveButton6);
        root.addRow(2, label2, BComboBox, new Label("Nombre de portes:"), B1Text , new Label("Nombre de fenêtres:"), B2Text , saveButton7);
        root.addRow(3, label3, CComboBox, new Label("Nombre de portes:"), C1Text , new Label("Nombre de fenêtres:"), C2Text , saveButton8);
        
        root.addRow(5, label5, EComboBox, new Label("Nombre de trémie") , GText  , saveButton10);
        root.addRow(6, label7, FComboBox, new Label("Nombre de trémie") , HText  , saveButton11);
        root.addRow(8,new Label(" "), new Label(" "),new Label(" "), label6, FText );
        root.addRow(11,new Label(" "), new Label(" "),new Label(" "),new Label(" "),new Label(" "),new Label(" "), new Label(" "),new Label(" "),FinButton);
        
        
        // Espacement et alignement des éléments
        root.setHgap(10);
        root.setVgap(10);
        root.setAlignment(javafx.geometry.Pos.CENTER);

        
        // Création de la scène et affichage de la fenêtre
        Scene scene = new Scene(root, 1100, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Choisir revêtements");
        primaryStage.show();
    }

    
    private TextField createTextField() {
    TextField textField = new TextField();
    textField.setText("0");
    return textField;
}
    private ComboBox<Integer> createComboBox() {
        ComboBox<Integer> comboBox = new ComboBox<>();
        for (int i = 1; i <= 14; i++) {
            comboBox.getItems().add(i);
        }
        comboBox.setValue(1); // Définition de la valeur par défaut
        return comboBox;
    }
    
   
    private ComboBox<Integer> createComboBoxMur() {
    ComboBox<Integer> comboBox = new ComboBox<>();
    for (int i = 1; i <= 12; i++) {
        comboBox.getItems().add(i);
    }
    comboBox.getItems().add(19); // Ajout du chiffre 19
    comboBox.setValue(1); // Définition de la valeur par défaut
    return comboBox;
}
    private ComboBox<Integer> createComboBoxSol() {
    ComboBox<Integer> comboBox = new ComboBox<>();
    int[] chiffres = {2, 3, 4, 10, 11, 13, 14, 15, 16, 17, 18, 19};
    for (int chiffre : chiffres) {
        comboBox.getItems().add(chiffre);
    }
    comboBox.setValue(2); // Définition de la valeur par défaut
    return comboBox;
}
    
     private ComboBox<Integer> createComboBoxPlafond() {
    ComboBox<Integer> comboBox = new ComboBox<>();
    int[] chiffres = {1, 3, 8, 9};
    for (int chiffre : chiffres) {
        comboBox.getItems().add(chiffre);
    }
    comboBox.setValue(2); // Définition de la valeur par défaut
    return comboBox;
}


    
    
    private ComboBox<Integer> createRectangleComboBox() {
        ComboBox<Integer> comboBox = new ComboBox<>();
        for (int i = 1; i <= nombreTriangles; i++) {
            comboBox.getItems().add(i);
        }
        comboBox.setValue(nombreTriangles); // Définition de la valeur par défaut
        return comboBox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

