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

public class RevetementFenetre extends Application {
    
    
    private Stage appStage;
    private int nombreRectangles;
    List<Mur> listeMurs;
    List<Plafond> listePlafonds;
    List<Sol> listeSols;
    
    
    
    // Ajout du constructeur pour initialiser le nombre de rectangles
    public RevetementFenetre(int nombreRectangles, List<Mur> listeMurs,List<Plafond> listePlafonds, List<Sol> listeSols) {
        this.nombreRectangles = nombreRectangles;
        this.listeMurs = listeMurs;
        this.listePlafonds = listePlafonds;
        this.listeSols = listeSols;
    }
    
    
    private int getSelectedValue(ComboBox<Integer> comboBox) {
    return comboBox.getValue();
    }


    private void saveButtonAction(Button saveButton, ComboBox<Integer> comboBox, String label) {
           
            System.out.println(label + " sélectionné : " +  comboBox.getValue());
          
        
    }
    
   /* private void ComboboxValue(ComboBox<Integer> comboBox) {
       prix_revetementValue=comboBox.getValue();
           
            return  prix_revetementValue;
          
        
    }*/
      public double Prix_mur(int nbrePortes, int nbreFenetres, double longueur, double hauteur, double prix_revetement) {
     double prix;      
     prix=(longueur * hauteur - 0.6 * nbrePortes - 0.6 * nbreFenetres) * prix_revetement + 200 * nbrePortes + 200 * nbreFenetres;
     System.out.println (prix);
        return prix;
     }
      
      public Mur RetrouverMur( int rectangleId, int numero_mur){
        for (Mur mur: listeMurs) {
            if (rectangleId == mur.getRectangleId() && numero_mur == mur.getNumero_mur()){
                return mur;}
        }
    return null;
    
      }
      
      public Plafond RetrouverPlafond( int rectangleId){
        for (Plafond plafond: listePlafonds) {
            if (rectangleId == plafond.getRectangleId() ){
                return plafond;}
        }
    return null;
    
      }
      
      public Sol RetrouverSol( int rectangleId){
        for (Sol sol: listeSols) {
            if (rectangleId == sol.getRectangleId() ){
                return sol;}
        }
    return null;
    
      }
      
      
      private Mur MajMur (int rectangleId, int numero_mur, int nbrePortes, int nbreFenetres, int listeRevetement, double hauteur){
          Mur mur = RetrouverMur( rectangleId, numero_mur);
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
              
      private Plafond MajPlafond (int rectangleId, int listeRevetement, int tremie){
          Plafond plafond = RetrouverPlafond( rectangleId);
         // if ( mur=! null){    à remettre si on ajoute le null
              plafond.setListeRevetement(listeRevetement);
              plafond.setTremie(tremie);
              
              System.out.println(plafond.toString());
              return plafond;
          }
        //  else {
        //      System.out.println("Aucun mur trouve");}
    //  }
      
      
      private Sol MajSol (int rectangleId, int listeRevetement, int tremie){
          Sol sol = RetrouverSol(rectangleId);
         // if ( mur=! null){    à remettre si on ajoute le null
              sol.setListeRevetement(listeRevetement);
              sol.setTremie(tremie);
              
              System.out.println(sol.toString());
              return sol;
          }
        //  else {
        //      System.out.println("Aucun mur trouve");}
    //  }
          
     
    private void saveTextField(Button saveButton, TextField textField, String label) {
    
        
        System.out.println(label + " : " + textField.getText());
        
    }
    
    
    
    
    @Override
    public void start(Stage primaryStage) {
        appStage = primaryStage;
        ArrayList<Mur> liste_murs2 = new ArrayList<Mur>();
        ArrayList<Plafond> liste_plafonds2 = new ArrayList<Plafond>();
        ArrayList<Sol> liste_sols2 = new ArrayList<Sol>();
        ArrayList<Piece> liste_pieces = new ArrayList<Piece>();
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
        
        
       // Création des boutons "Enregistrer"
      /*  Button saveButtonRectangle = new Button("Enregistrer");
        saveButtonRectangle.setOnAction(event -> {
            saveTextField(saveButtonRectangle, A1Text, "Nombre de portes");
          
        });*/
        rectangleId= rectangleComboBox.getValue();
       
      /*  Button saveButton1 = new Button("Enregistrer");
        saveButton1.setOnAction(event -> {
            saveTextField(saveButton1, A1Text, "Nombre de portes");
        });

        Button saveButton2 = new Button("Enregistrer");
        saveButton2.setOnAction(event -> {
           saveTextField(saveButton2, B1Text, "Nombre de portes");
        });

        Button saveButton3 = new Button("Enregistrer");
        saveButton3.setOnAction(event -> {
            saveTextField(saveButton3, C1Text, "Nombre de portes");
        });

        Button saveButton4 = new Button("Enregistrer");
        saveButton4.setOnAction(event -> {
            saveTextField(saveButton4, D1Text, "Nombre de portes");
        });

        Button saveButton5 = new Button("Enregistrer");
        saveButton5.setOnAction(event -> {
            
        });*/
        
   
        Button saveButton6 = new Button("Enregistrer");
saveButton6.setOnAction(event -> {
    saveTextField(saveButton6, A2Text, "Nombre de fenetres");
    liste_murs2.add(MajMur (rectangleComboBox.getValue(), 2, Integer.parseInt(A1Text.getText()),Integer.parseInt(A2Text.getText()) , AComboBox.getValue(), Integer.parseInt(FText.getText())));
    
     
});


        Button saveButton7 = new Button("Enregistrer");
        saveButton7.setOnAction(event -> {
             saveTextField(saveButton7, B2Text, "Nombre de fenetres");

             liste_murs2.add(MajMur (rectangleComboBox.getValue(), 4, Integer.parseInt(B1Text.getText()),Integer.parseInt(B2Text.getText()) , BComboBox.getValue(), Integer.parseInt(FText.getText())));
        });

        Button saveButton8 = new Button("Enregistrer");
        saveButton8.setOnAction(event -> {
             saveTextField(saveButton8, C2Text, "Nombre de fenetres");
             liste_murs2.add(MajMur (rectangleComboBox.getValue(), 1, Integer.parseInt(C1Text.getText()),Integer.parseInt(C2Text.getText()) , CComboBox.getValue(), Integer.parseInt(FText.getText())));
        });

        Button saveButton9 = new Button("Enregistrer");
        saveButton9.setOnAction(event -> {
            saveTextField(saveButton9, D2Text, "Nombre de fenetres");
            liste_murs2.add(MajMur (rectangleComboBox.getValue(), 3, Integer.parseInt(D1Text.getText()),Integer.parseInt(D2Text.getText()) , DComboBox.getValue(), Integer.parseInt(FText.getText())));
            PrintWriter pwmur;
            try { 
            pwmur = new PrintWriter (new FileOutputStream("mur2.txt"));
            for (Mur mur : liste_murs2) {
            pwmur.println("Mur;" + mur.idMur + ";" + mur.rectangleId + ";" + mur.numero_mur + ";" + mur.nbrePortes + ";" + mur.nbreFenetres + ";" + mur.coinDebut.idcoin + ";" + mur.coinFin.idcoin + ";" + mur.listeRevetement +";" + mur.hauteur);
               }
            pwmur.close();
            } catch (FileNotFoundException e) {
            e.printStackTrace();
            }

        });
        
        

        Button saveButton10 = new Button("Enregistrer");
        saveButton10.setOnAction(event -> {
             liste_sols2.add(MajSol (rectangleComboBox.getValue(), EComboBox.getValue(), Integer.parseInt(GText.getText())));
             PrintWriter pwsol;
try { 
    pwsol = new PrintWriter (new FileOutputStream("sol2.txt"));
    for (Sol sol : liste_sols2) {
        pwsol.println("Sol;" +  sol.rectangleId + ";" + sol.coin1.idcoin + ";" + sol.coin2.idcoin + ";" + sol.coin3.idcoin + ";" + sol.coin4.idcoin + ";" + sol.listeRevetement + ";" + sol.tremie );
    }
    pwsol.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
}
        });
        
        Button saveButton11 = new Button("Enregistrer");
        saveButton11.setOnAction(event -> {
           liste_plafonds2.add(MajPlafond (rectangleComboBox.getValue(), FComboBox.getValue(), Integer.parseInt(HText.getText())));
             PrintWriter pwplafond;
try { 
    pwplafond = new PrintWriter (new FileOutputStream("plafond2.txt"));
    for (Plafond plafond : liste_plafonds2) {
        pwplafond.println("Plafond;" +  plafond.rectangleId + ";" + plafond.coin1.idcoin + ";" + plafond.coin2.idcoin + ";" + plafond.coin3.idcoin + ";" + plafond.coin4.idcoin + ";" + plafond.listeRevetement + ";" + plafond.tremie );
    }
    pwplafond.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
}
            
        });
        
Button saveButtonPiece = new Button("Enregistrer Piece");
       saveButtonPiece.setOnAction(event -> {        
/*Mur mur1 = null;
Mur mur2 = null;
Mur mur3 = null;
Mur mur4 = null;

for (Plafond plafond : liste_plafonds2) {
    for (Sol sol : liste_sols2) {
        for (Mur mur : liste_murs2) {
            if (sol.getRectangleId() == mur.getRectangleId() && mur.getRectangleId() == plafond.getRectangleId() && plafond.getRectangleId()==sol.getRectangleId()) {
                if (mur.getNumero_mur() == 1) {
                    mur1 = mur;
                }
                if (mur.getNumero_mur() == 2) {
                    mur2 = mur;
                }
                if (mur.getNumero_mur() == 3) {
                    mur3 = mur;
                }
                if (mur.getNumero_mur() == 4) {
                    mur4 = mur;
                }
                if (mur1 != null && mur2 != null && mur3 != null && mur4 != null) {
                    Piece piece = new Piece(plafond.getRectangleId(), mur1, mur2, mur3, mur4, sol, plafond);
                    liste_pieces.add(piece);
                }
            }
        }
        
        PrintWriter pwpiece;
try { 
    pwpiece = new PrintWriter (new FileOutputStream("piece.txt"));
    for (Piece piece : liste_pieces) {
        pwpiece.println("Piece;" +  piece.rectangleId + ";" + piece.mur1 + ";" + piece.mur2 + ";" + piece.mur3 + ";" + piece.mur4 + ";" + piece.sol + ";" + piece.plafond );
    }
    pwpiece.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
}
        
        
    }
}*/
for (Plafond plafond : liste_plafonds2) {
    for (Sol sol : liste_sols2) {
        // Initialiser les murs
        Mur mur1 = null;
        Mur mur2 = null;
        Mur mur3 = null;
        Mur mur4 = null;
        int murCount = 0;

        // Parcourir les murs pour le rectangle courant
        for (Mur mur : liste_murs2) {
            if (mur.getRectangleId() == plafond.getRectangleId() && plafond.getRectangleId() == sol.getRectangleId()) {
               
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
                    case 4:
                        mur4 = mur;
                        break;
                }
            }
        }

        // Vérifier si tous les murs ont été trouvés
        if (murCount == 4) {
            // Créer la pièce
            Piece piece = new Piece(plafond.getRectangleId(), mur1, mur2, mur3, mur4, sol, plafond);
            liste_pieces.add(piece);
        }
    }
}
PrintWriter pwpiece;
try { 
    pwpiece = new PrintWriter (new FileOutputStream("piece.txt"));
    for (Piece piece : liste_pieces) {
        pwpiece.println("Piece;" +  piece.rectangleId + ";" + piece.mur1 + ";" + piece.mur2 + ";" + piece.mur3 + ";" + piece.mur4 + ";" + piece.sol + ";" + piece.plafond );
    }
    pwpiece.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
}

});           
        
   /*      Button saveButtonA= new Button("Enregistrer");
         saveButtonA.setOnAction(event -> {
           saveButtonAction(saveButtonA, AComboBox , "Revêtements mur intérieur droit:");
         
           
       });

        Button saveButtonB = new Button("Enregistrer");
        saveButtonB.setOnAction(event -> {
        saveButtonAction(saveButtonB, BComboBox , "Revêtements mur intérieur gauche:");
});
        
        Button saveButtonC = new Button("Enregistrer");
        saveButtonC.setOnAction(event -> {
        saveButtonAction(saveButtonC, CComboBox , "Revêtements mur intérieur haut:");
});
        
        Button saveButtonD = new Button("Enregistrer");
        saveButtonD.setOnAction(event -> {
        saveButtonAction(saveButtonD, DComboBox , "Revêtements mur intérieur bas:");
});
        
        Button saveButtonE = new Button("Enregistrer");
        saveButtonE.setOnAction(event -> {
        saveButtonAction(saveButtonE, EComboBox , "Revêtements sol:");
        });
        
        Button saveButtonF = new Button("Enregistrer");
        saveButtonF.setOnAction(event -> {
            saveTextField(saveButtonF, FText, "Hauteur plafond");
        });*/
        
        Button FinButton = new Button("Fin");
        FinButton.setOnAction(event -> {
            primaryStage.close();    
        });

        // Création des libellés 
        Text label1 = new Text("Revêtements mur intérieur droit:");
        Text label2 = new Text("Revêtements mur intérieur gauche:");
        Text label3 = new Text("Revêtements mur intérieur haut:");
        Text label4 = new Text("Revêtements mur intérieur bas:");
        Text label5 = new Text("Revêtements sol:");
        Text label6 = new Text("Hauteur plafond:");
        Text label7 = new Text("Revêtements plafond");
        // Création de la grille pour organiser les éléments
      /*  GridPane root = new GridPane();
        root.addRow(0, new Label("Rectangle:"), rectangleComboBox, saveButtonRectangle);
        root.addRow(1, label1, AComboBox,saveButtonA, new Label("Nombre de portes:"), A1Text ,saveButton1, new Label("Nombre de fenêtres:"), A2Text , saveButton6);
        root.addRow(2, label2, BComboBox,saveButtonB, new Label("Nombre de portes:"), B1Text ,saveButton2, new Label("Nombre de fenêtres:"), B2Text , saveButton7);
        root.addRow(3, label3, CComboBox,saveButtonC, new Label("Nombre de portes:"), C1Text ,saveButton3, new Label("Nombre de fenêtres:"), C2Text , saveButton8);
        root.addRow(4, label4, DComboBox,saveButtonD, new Label("Nombre de portes:"), D1Text ,saveButton4, new Label("Nombre de fenêtres:"), D2Text , saveButton9);
        root.addRow(5, label5, EComboBox,saveButtonE);
        root.addRow(8,new Label(" "), new Label(" "),new Label(" "), label6, FText ,saveButtonF);
        root.addRow(11,new Label(" "), new Label(" "),new Label(" "),new Label(" "),new Label(" "),new Label(" "), new Label(" "),new Label(" "),FinButton);*/

               GridPane root = new GridPane();
        root.addRow(0, new Label("Rectangle:"), rectangleComboBox, saveButtonPiece);
        root.addRow(1, label1, AComboBox, new Label("Nombre de portes:"), A1Text , new Label("Nombre de fenêtres:"), A2Text , saveButton6);
        root.addRow(2, label2, BComboBox, new Label("Nombre de portes:"), B1Text , new Label("Nombre de fenêtres:"), B2Text , saveButton7);
        root.addRow(3, label3, CComboBox, new Label("Nombre de portes:"), C1Text , new Label("Nombre de fenêtres:"), C2Text , saveButton8);
        root.addRow(4, label4, DComboBox, new Label("Nombre de portes:"), D1Text , new Label("Nombre de fenêtres:"), D2Text , saveButton9);
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
        for (int i = 1; i <= nombreRectangles; i++) {
            comboBox.getItems().add(i);
        }
        comboBox.setValue(nombreRectangles); // Définition de la valeur par défaut
        return comboBox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}


// Surface mur haut bas = hauteur plafond x largeur - nb porte - nb fenetre
// Surface mur droite gauche = hauteur plafond x longueur - nb porte - nb fenetre
// Surface Sol = longueur x largeur - tremis


// prix mur haut bas = (prix m2)x(Surface) + prix porte + prix fenetre
// prix mur droite gauche = (prix m2)x(Surface) + prix porte + prix fenetre
// prix sol = (prix m2)xsurface + prix trémis
