    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caca;

/**
 *
 * @author fabre
 */




import static com.mycompany.caca.RevetementFenetreTriangle.distancePoints;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    int idNiveau;
    double hauteurSousPlafond;    
    
    
    // Ajout du constructeur pour initialiser le nombre de rectangles
    public RevetementFenetre(int nombreRectangles, List<Mur> listeMurs,List<Plafond> listePlafonds, List<Sol> listeSols, int idNiveau, double hauteurSousPlafond) {
        this.nombreRectangles = nombreRectangles;
        this.idNiveau=idNiveau;
        this.hauteurSousPlafond = hauteurSousPlafond;
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
    
  
      public double Prix_mur(int nbrePortes, int nbreFenetres, double longueur, double hauteur, double prix_revetement) {
     double prix;      
     prix=(longueur * hauteur - 0.6 * nbrePortes - 0.6 * nbreFenetres) * prix_revetement + 200 * nbrePortes + 200 * nbreFenetres;
     System.out.println (prix);
        return prix;
     }
      
      public Mur RetrouverMur( int rectangleId, int numero_mur, int idNiveau){
        for (Mur mur: listeMurs) {
            if (rectangleId == mur.getRectangleId() && numero_mur == mur.getNumero_mur() && mur.getIdNiveau() == idNiveau){
                return mur;}
        }
    return null;
    
      }
      
      public Plafond RetrouverPlafond( int rectangleId, int idNiveau){
        for (Plafond plafond: listePlafonds) {
            if (rectangleId == plafond.getRectangleId() && plafond.getIdNiveau() == idNiveau ){
                return plafond;}
        }
    return null;
    
      }
      
      public Sol RetrouverSol( int rectangleId, int idNiveau){
        for (Sol sol: listeSols) {
            if (rectangleId == sol.getRectangleId() && sol.getIdNiveau() == idNiveau ){
                return sol;}
        }
    return null;
    
      }
      
      
      private Mur MajMur (int rectangleId, int numero_mur, int nbrePortes, int nbreFenetres, int listeRevetement, double hauteur,int idNiveau){
          Mur mur = RetrouverMur( rectangleId, numero_mur,idNiveau);
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
              
      private Plafond MajPlafond (int rectangleId, int listeRevetement, int tremie, int idNiveau){
          Plafond plafond = RetrouverPlafond( rectangleId,idNiveau);
         // if ( mur=! null){    à remettre si on ajoute le null
              plafond.setListeRevetement(listeRevetement);
              plafond.setTremie(tremie);
              
              System.out.println(plafond.toString());
              return plafond;
          }
        //  else {
        //      System.out.println("Aucun mur trouve");}
    //  }
      
      
      private Sol MajSol (int rectangleId, int listeRevetement, int tremie, int idNiveau){
          Sol sol = RetrouverSol(rectangleId, idNiveau);
         // if ( mur=! null){    à remettre si on ajoute le null
              sol.setListeRevetement(listeRevetement);
              sol.setTremie(tremie);
              
              System.out.println(sol.toString());
              return sol;
          }
        //  else {
        //      System.out.println("Aucun mur trouve");}
    //  }
      
      
      
   public double calculerPrixPiece(Piece piece) {
        double prixTotal = 0;

        // Calcul du prix de chaque mur
        for (Mur mur : new Mur[]{piece.getMur1(), piece.getMur2(), piece.getMur3(), piece.getMur4()}) {
        double surfaceMur = calculerSurfaceMur(mur);
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

public double calculerPrixMur4(Mur mur) {
    double longueur = distancePoints(mur.getCoinDebut().getX(),mur.getCoinDebut().getY(),mur.getCoinFin().getX(),mur.getCoinFin().getY());
    double hauteur = mur.getHauteur();
    double surfaceMur4 = longueur * hauteur;
    int nbrePortes = mur.getNbrePortes();
    int nbreFenetres = mur.getNbreFenetres();
    double prixRevetement = ElementRevetement(mur.getListeRevetement());
    double prixMur4 = (surfaceMur4 - (1.2 * 1.2 * nbreFenetres) - (0.9 * 2.10 * nbrePortes)) * prixRevetement;
    System.out.println("Prix mur4: " + prixMur4);
    return prixMur4;
}

public double calculerPrixSol(Sol sol) {
    double surfaceSol = calculerSurfaceSol(sol);
    int nbreTremiesSol = sol.getTremie();
    double prixRevetementSol = ElementRevetement(sol.getListeRevetement());
    double prixSol = (surfaceSol - (2 * 1 * nbreTremiesSol)) * prixRevetementSol;
    System.out.println("Prix sol: " + prixSol);
    return prixSol;
}

public double calculerPrixPlafond(Plafond plafond) {
    double surfacePlafond = calculerSurfacePlafond(plafond);
    int nbreTremiesPlafond = plafond.getTremie();
    double prixRevetementPlafond = ElementRevetement(plafond.getListeRevetement());
    double prixPlafond = (surfacePlafond - (2 * 1 * nbreTremiesPlafond)) * prixRevetementPlafond;
    System.out.println("Prix plafond: " + prixPlafond);
    return prixPlafond;
}


private double calculerSurfaceMur(Mur mur) {
    double longueur=0;
    if (mur.getNumero_mur() == 1) {
        longueur = Math.abs(((mur.getCoinDebut().getX() - mur.getCoinFin().getX()) ));
        longueurmur1 = longueur;
    }
    if ( mur.getNumero_mur() == 3) {
        longueur = Math.abs(((mur.getCoinDebut().getX() - mur.getCoinFin().getX()) ));
        longueurmur2 = longueur;
    }
    if (mur.getNumero_mur() == 2 ) {
        longueur = Math.abs((mur.getCoinDebut().getY() - mur.getCoinFin().getY()) );
        longueurmur3 = longueur;
    }
    if ( mur.getNumero_mur() == 4) {
        longueur = Math.abs((mur.getCoinDebut().getY() - mur.getCoinFin().getY()) );
        longueurmur4 = longueur;
    }
    double hauteur = mur.getHauteur();
    hauteurmur = hauteur;
     System.out.println("surface mur" +longueur * hauteur);
    return longueur * hauteur;
}   
   double longueurmur1;
   double longueurmur2;
   double longueurmur3;
   double longueurmur4;
   double hauteurmur;
   double surfacesol;
   double surfaceplafond;
   
   
   
// Fonction pour calculer la surface d'un mur




// Fonction pour calculer la surface du sol
private double calculerSurfaceSol(Sol sol) {
    double longueur = (sol.getCoin1().getX() - sol.getCoin2().getX() );
    double largeur = (sol.getCoin1().getY() - sol.getCoin3().getY() );
    System.out.println("surface sol " +longueur * largeur);
    surfacesol =longueur * largeur;
    return longueur * largeur;
}

// Fonction pour calculer la surface du plafond
private double calculerSurfacePlafond(Plafond plafond) {
    double longueur = (plafond.getCoin1().getX() - plafond.getCoin2().getX() );
    double largeur = (plafond.getCoin1().getY() - plafond.getCoin3().getY() );
     System.out.println("surface plafond" + longueur * largeur);
     surfaceplafond = longueur * largeur;
    return longueur * largeur;
}

    // Fonction pour calculer le prix unitaire du revêtement
    public double ElementRevetement(int Revetement) {
        double prix = 0;

        switch (Revetement) {
            case 0:
                prix = 0;
                break;
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
          
    private List<Revetement> liste_revetements = new ArrayList<>();
    private List<Revetement> revetementsMurs = new ArrayList<>();
    private List<Revetement> revetementsSol = new ArrayList<>();
    private List<Revetement> revetementsPlafond = new ArrayList<>();
    
    
    private void lireRevetementsDepuisFichier() {
        String path = "listeRevetement.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 6) {
                    int idRevetement = Integer.parseInt(parts[0].trim());
                    String designation = parts[1].trim();
                    boolean pourMur = Integer.parseInt(parts[2].trim()) == 1;
                    boolean pourSol = Integer.parseInt(parts[3].trim()) == 1;
                    boolean pourPlafond = Integer.parseInt(parts[4].trim()) == 1;
                    double prixUnitaire = Double.parseDouble(parts[5].trim().replace("€", "").replace(",", "."));

                    Revetement revetement = new Revetement(idRevetement, designation, pourMur, pourSol, pourPlafond, prixUnitaire);
                    liste_revetements.add(revetement);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void trierRevetementsParSurface() {
        for (Revetement revetement : liste_revetements) {
            if (revetement.isPourMur()) {
                revetementsMurs.add(revetement);
            }
            if (revetement.isPourSol()) {
                revetementsSol.add(revetement);
            }
            if (revetement.isPourPlafond()) {
                revetementsPlafond.add(revetement);
            }
        }
    }

    private ComboBox<String> creeComboBoxMurS() {
        ComboBox<String> comboBox = new ComboBox<>();
        for (Revetement revetement : revetementsMurs) {
            comboBox.getItems().add(revetement.getDesignation() + " : " + revetement.getPrixUnitaire() + " €");
        }
        comboBox.getItems().add("0");
        if (!revetementsMurs.isEmpty()) {
            comboBox.setValue(revetementsMurs.get(0).getDesignation() + " : " + revetementsMurs.get(0).getPrixUnitaire() + " €");
        }
        return comboBox;
    }

    private ComboBox<String> creeComboBoxSolS() {
        ComboBox<String> comboBox = new ComboBox<>();
        for (Revetement revetement : revetementsSol) {
            comboBox.getItems().add(revetement.getDesignation() + " : " + revetement.getPrixUnitaire() + " €");
        }
        comboBox.getItems().add("0");
        
        
        if (!revetementsSol.isEmpty()) {
            comboBox.setValue(revetementsSol.get(0).getDesignation() + " : " + revetementsSol.get(0).getPrixUnitaire() + " €");
        }
        return comboBox;
    }

    private ComboBox<String> creeComboBoxPlafondS() {
        ComboBox<String> comboBox = new ComboBox<>();
        for (Revetement revetement : revetementsPlafond) {
            comboBox.getItems().add(revetement.getDesignation() + " : " + revetement.getPrixUnitaire() + " €");
        }
        comboBox.getItems().add("0");
        if (!revetementsPlafond.isEmpty()) {
            comboBox.setValue(revetementsPlafond.get(0).getDesignation() + " : " + revetementsPlafond.get(0).getPrixUnitaire() + " €");
        }
        return comboBox;
    }
    
    private int PrixRevetement(ComboBox<String> comboBox) {
    String selectedValue = comboBox.getValue();
    
    // Parcours de la liste de revêtements pour trouver le revêtement correspondant à la valeur sélectionnée
    for (int i = 0; i < liste_revetements.size(); i++) {
        Revetement revetement = liste_revetements.get(i);
        String designationPrix = revetement.getDesignation() + " : " + revetement.getPrixUnitaire() + " €";
        if (Objects.equals(selectedValue, designationPrix)) {
            // Retourne l'index du revêtement dans la liste (+1 pour obtenir le numéro de la ligne)
            return i + 1;
        }
    }
    
    // Si aucun revêtement correspondant n'est trouvé, retourne 0
    return 0;
}
     
    private void sauvegarderTextField(Button saveButton, TextField textField, String label) {
    
        
        System.out.println(label + " : " + textField.getText());
        
    }
    
    
    
    
    @Override
    public void start(Stage primaryStage) {
        appStage = primaryStage;
        
        // Lecture des revêtements depuis un fichier et tri par surface
        lireRevetementsDepuisFichier();
        trierRevetementsParSurface();
        
        // Création de listes pour stocker les murs, plafonds, sols, pièces et prix
        ArrayList<Mur> liste_murs2 = new ArrayList<Mur>();
        ArrayList<Plafond> liste_plafonds2 = new ArrayList<Plafond>();
        ArrayList<Sol> liste_sols2 = new ArrayList<Sol>();
        ArrayList<Piece> liste_pieces = new ArrayList<Piece>();
        ArrayList<Prix> liste_prix = new ArrayList<Prix>();
        int rectangleId;

        // Création du menu déroulant
        ComboBox<Integer> rectangleComboBox = createRectangleComboBox();
        ComboBox<String> AComboBox = creeComboBoxMurS();
        ComboBox<String> BComboBox = creeComboBoxMurS();
        ComboBox<String> CComboBox = creeComboBoxMurS();
        ComboBox<String> DComboBox = creeComboBoxMurS();
        ComboBox<String> EComboBox = creeComboBoxSolS();
        ComboBox<String> FComboBox = creeComboBoxPlafondS();
        
        // Création des zones de texte
        TextField A1Text = creeTextField();
        TextField A2Text = creeTextField();
        TextField B1Text = creeTextField();
        TextField B2Text = creeTextField();
        TextField C1Text = creeTextField();
        TextField C2Text = creeTextField();
        TextField D1Text = creeTextField();
        TextField D2Text = creeTextField();
        TextField FText = creeTextField();
        TextField GText = creeTextField();
        TextField HText = creeTextField();
        
        
      
        rectangleId= rectangleComboBox.getValue();
       
     
        
   
        Button enregistrerBouton6 = new Button("Enregistrer");
        enregistrerBouton6.setOnAction(event -> {
        sauvegarderTextField(enregistrerBouton6, A2Text, "Nombre de fenetres");
        liste_murs2.add(MajMur (rectangleComboBox.getValue(), 2, Integer.parseInt(A1Text.getText()),Integer.parseInt(A2Text.getText()) , PrixRevetement(AComboBox), Double.parseDouble(FText.getText()),idNiveau));
        });


        Button enregistrerBouton7 = new Button("Enregistrer");
        enregistrerBouton7.setOnAction(event -> {
        sauvegarderTextField(enregistrerBouton7, B2Text, "Nombre de fenetres");
        liste_murs2.add(MajMur (rectangleComboBox.getValue(), 4, Integer.parseInt(B1Text.getText()),Integer.parseInt(B2Text.getText()) , PrixRevetement(BComboBox), Double.parseDouble(FText.getText()),idNiveau));
        });

        Button enregistrerBouton8 = new Button("Enregistrer");
        enregistrerBouton8.setOnAction(event -> {
        sauvegarderTextField(enregistrerBouton8, C2Text, "Nombre de fenetres");
        liste_murs2.add(MajMur (rectangleComboBox.getValue(), 1, Integer.parseInt(C1Text.getText()),Integer.parseInt(C2Text.getText()) , PrixRevetement(CComboBox), Double.parseDouble(FText.getText()), idNiveau));
        });

        Button enregistrerBouton9 = new Button("Enregistrer");
        enregistrerBouton9.setOnAction(event -> {
        sauvegarderTextField(enregistrerBouton9, D2Text, "Nombre de fenetres");
        liste_murs2.add(MajMur (rectangleComboBox.getValue(), 3, Integer.parseInt(D1Text.getText()),Integer.parseInt(D2Text.getText()) , PrixRevetement(DComboBox), Double.parseDouble(FText.getText()), idNiveau));
            
        PrintWriter pwmur;
            try { 
            pwmur = new PrintWriter (new FileOutputStream("mur2.txt", true));
            for (Mur mur : liste_murs2) {
            pwmur.println("Mur;" + mur.idMur + ";" + mur.rectangleId + ";" + mur.numero_mur + ";" + mur.nbrePortes + ";" + mur.nbreFenetres + ";" + mur.coinDebut.idcoin + ";" + mur.coinFin.idcoin + ";" + mur.listeRevetement +";" + mur.hauteur + ";" + mur.idNiveau);
               }
            pwmur.close();
            } catch (FileNotFoundException e) {
            e.printStackTrace();
            }

        });
        
        

        Button enregistrerBouton10 = new Button("Enregistrer");
        enregistrerBouton10.setOnAction(event -> {
             liste_sols2.add(MajSol (rectangleComboBox.getValue(), PrixRevetement(EComboBox), Integer.parseInt(GText.getText()), idNiveau));
             
             PrintWriter pwsol;
            try { 
                pwsol = new PrintWriter (new FileOutputStream("sol2.txt", true));
                for (Sol sol : liste_sols2) {
                    pwsol.println("Sol;" +  sol.rectangleId + ";" + sol.coin1.idcoin + ";" + sol.coin2.idcoin + ";" + sol.coin3.idcoin + ";" + sol.coin4.idcoin + ";" + sol.listeRevetement + ";" + sol.tremie + ";" + sol.idNiveau);
                }
            pwsol.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
         
              
             
            try (PrintWriter pwmur = new PrintWriter(new FileOutputStream("infos_objets.txt", true))) {
                for (Sol sol : liste_sols2) {
                    pwmur.println("Sol;" +  sol.rectangleId + ";" + sol.coin1.idcoin + ";" + sol.coin2.idcoin + ";" + sol.coin3.idcoin + ";" + sol.coin4.idcoin + ";" + sol.listeRevetement + ";" + sol.tremie + ";" + sol.idNiveau);
                }
            pwmur.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        
        Button enregistrerBouton11 = new Button("Enregistrer");
        enregistrerBouton11.setOnAction(event -> {
        liste_plafonds2.add(MajPlafond (rectangleComboBox.getValue(), PrixRevetement(FComboBox), Integer.parseInt(HText.getText()), idNiveau));
             
        PrintWriter pwplafond;
        try { 
            pwplafond = new PrintWriter (new FileOutputStream("plafond2.txt", true));
            for (Plafond plafond : liste_plafonds2) {
                pwplafond.println("Plafond;" +  plafond.rectangleId + ";" + plafond.coin1.idcoin + ";" + plafond.coin2.idcoin + ";" + plafond.coin3.idcoin + ";" + plafond.coin4.idcoin + ";" + plafond.listeRevetement + ";" + plafond.tremie + ";" + plafond.idNiveau);
            }
            pwplafond.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
         
        try (PrintWriter pwmur = new PrintWriter(new FileOutputStream("infos_objets.txt", true))) {
            for (Plafond plafond : liste_plafonds2) {
                pwmur.println("Plafond;" +  plafond.rectangleId + ";" + plafond.coin1.idcoin + ";" + plafond.coin2.idcoin + ";" + plafond.coin3.idcoin + ";" + plafond.coin4.idcoin + ";" + plafond.listeRevetement + ";" + plafond.tremie + ";" + plafond.idNiveau);
            }
            pwmur.close();
            } catch (FileNotFoundException e) {
            e.printStackTrace();
            }
        });
       
        
        
       Button FinButton = new Button("Fin");
        FinButton.setOnAction(event -> {
            primaryStage.close();    
    
    for (Plafond plafond : liste_plafonds2) {
    for (Sol sol : liste_sols2) {
        // Initialiser les murs
        Mur mur1 = null;
        Mur mur2 = null;
        Mur mur3 = null;
        Mur mur4 = null;
        int murnuméro = 0;

        // Parcourir les murs pour le rectangle courant
        for (Mur mur : liste_murs2) {
            if (mur.getRectangleId() == plafond.getRectangleId() && plafond.getRectangleId() == sol.getRectangleId() && mur.getRectangleId() == sol.getRectangleId()) {
               
                murnuméro++;
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
        if (murnuméro == 4) {
            // Créer la pièce
            Piece piece = new Piece(plafond.getRectangleId(), mur1, mur2, mur3, mur4, sol, plafond,idNiveau);
            liste_pieces.add(piece);
        }
    }
}

    
    PrintWriter pwpiece;
        try { 
    // Crée un nouveau fichier ou écrase un fichier existant sans append
        pwpiece = new PrintWriter (new FileOutputStream("piece.txt", true));
            for (Piece piece : liste_pieces) {
                pwpiece.println("Piece;" +  piece.rectangleId + ";" + piece.mur1 + ";" + piece.mur2 + ";" + piece.mur3 + ";" + piece.mur4 + ";" + piece.sol + ";" + piece.plafond );
            }
        pwpiece.close();
        } catch (FileNotFoundException e) {
        e.printStackTrace();
        }
 
    try (PrintWriter pwmur = new PrintWriter(new FileOutputStream("infos_objets.txt", true))) {
        int IDniveau;
        for (Piece piece : liste_pieces) {

        pwmur.println("Piece;" +  piece.rectangleId + ";" + piece.mur1.idMur + ";" + piece.mur2.idMur + ";" + piece.mur3.idMur + ";" + piece.mur4.idMur + ";" + piece.sol.rectangleId + ";" + piece.plafond.rectangleId + ";" + piece.idNiveau  );
    }
        pwmur.println("Niveau;" + idNiveau);
        pwmur.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

     for (Piece piece : liste_pieces) {
        double prixPiece = calculerPrixPiece(piece);
        double prixMur1 = calculerPrixMur1(piece.getMur1());
        double prixMur2 = calculerPrixMur2(piece.getMur2());
        double prixMur3 = calculerPrixMur3(piece.getMur3());
        double prixMur4 = calculerPrixMur4(piece.getMur4());
        double prixSol = calculerPrixSol(piece.getSol());
        double prixPlafond = calculerPrixPlafond(piece.getPlafond());
        
        Prix prix = new Prix(idNiveau, piece.getRectangleId(), prixMur1, prixMur2, prixMur3, prixMur4, prixSol, prixPlafond, prixPiece);
        liste_prix.add(prix);
        System.out.println("Le prix de la pièce est : " + prixPiece + " €");
     }
    
        PrintWriter pwprix;
    try {
    
        pwprix = new PrintWriter(new FileOutputStream("prix.txt", true)); 
            for (Prix prix : liste_prix) {
                pwprix.println("Prix;" +  prix.idNiveau + ";" + prix.rectangleId + ";" + prix.prixmur1 + ";" + prix.prixmur2 + ";" + prix.prixmur3 + ";" + prix.prixmur4 + ";" + prix.prixsol + ";" + prix.prixplafond + ";" + prix.prixpiece);
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
        Text label1 = new Text("Revêtements mur intérieur droit:");
        Text label2 = new Text("Revêtements mur intérieur gauche:");
        Text label3 = new Text("Revêtements mur intérieur haut:");
        Text label4 = new Text("Revêtements mur intérieur bas:");
        Text label5 = new Text("Revêtements sol:");
        Text label6 = new Text("Hauteur plafond:");
        Text label7 = new Text("Revêtements plafond");
        

               GridPane root = new GridPane();
        root.addRow(0, new Label("Pièce:"), rectangleComboBox);
        root.addRow(1, label1, AComboBox, new Label("Nombre de portes:"), A1Text , new Label("Nombre de fenêtres:"), A2Text , enregistrerBouton6);
        root.addRow(2, label2, BComboBox, new Label("Nombre de portes:"), B1Text , new Label("Nombre de fenêtres:"), B2Text , enregistrerBouton7);
        root.addRow(3, label3, CComboBox, new Label("Nombre de portes:"), C1Text , new Label("Nombre de fenêtres:"), C2Text , enregistrerBouton8);
        root.addRow(4, label4, DComboBox, new Label("Nombre de portes:"), D1Text , new Label("Nombre de fenêtres:"), D2Text , enregistrerBouton9);
        root.addRow(5, label5, EComboBox, new Label("Nombre de trémie") , GText  , enregistrerBouton10);
        root.addRow(6, label7, FComboBox, new Label("Nombre de trémie") , HText  , enregistrerBouton11);
        root.addRow(8,new Label(" "), new Label(" "),new Label(" "), label6, hauteurPlafondField );
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

    
    private TextField creeTextField() {
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
