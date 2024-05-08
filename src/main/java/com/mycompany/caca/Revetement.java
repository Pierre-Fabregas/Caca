
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caca;

/**
 *
 * @author macbookpro
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Revetement {
    private int idRevetement;
    private String designation;
    private boolean pourMur;
    private boolean pourSol;
    private boolean pourPlafond;
    private double prixUnitaire;
    private static File Revetementfichier = new File("listeRevetement.txt");

    @Override
     public String toString() {
        return designation;
    }
     
     
     public double ElementRevetement (int Revetement){
         double prix =0;
         
        if(Revetement == 1) {
             prix = 10.95; }
        if(Revetement == 2){
             prix = 49.75;}
        if(Revetement == 3){
             prix = 50.60;}
        if(Revetement == 4){
             prix =97.85;}
        if(Revetement == 5){
             prix =67.80;}
        if(Revetement == 6){
             prix =32.90;}
        if(Revetement == 7){
             prix =15.20;}
        if(Revetement == 8){
             prix =77.30;}
        if(Revetement == 9){
             prix =29.90;}
        if(Revetement == 10){
             prix =89.45;}
        if(Revetement == 11){
             prix =42.50;}
        if(Revetement == 12){
             prix =25.40;}
        if(Revetement == 13){
             prix =46.36;}
        if(Revetement == 14){
             prix =23.55;}
        if(Revetement == 15){
             prix =48.10;}
        if(Revetement == 16){
             prix =31.99;}
        if(Revetement == 17){
             prix =17.95;}
        if(Revetement == 18){
             prix =33.90;}
        if(Revetement == 19){
             prix =10.35;}
        
        return prix;
     }
             
     
     
     
     
     
     

    public static int comptageRevetements() {
        try (Scanner scanner = new Scanner(Revetementfichier)) {
            int nbRevetements = 0;
            while (scanner.hasNextLine()) { // Comptage du nombre de revetements
                nbRevetements++;
                scanner.nextLine();
            }
            scanner.close();
            return nbRevetements;

        } catch (FileNotFoundException e) {
            System.out.println("Erreur : listeRevetement.txt non trouve.");
            return 0;
        }
    }

    public static Revetement[] stockagRevetements(int nbRevetements) {
        try (Scanner scanner = new Scanner(Revetementfichier)) {
            Revetement[] revetements = new Revetement[nbRevetements]; // creation d'un tableau de nb de revetements
                                                                      // cases qui stockera des objets revetements
            scanner.nextLine();
            while (scanner.hasNextLine()) { // creation des objets revetements et stockage dans le tableau
                String ligneRevetement = scanner.nextLine();
                int idRevetement = Integer.parseInt(ligneRevetement.split(";")[0]);
                String designation = ligneRevetement.split(";")[1];
                Boolean pourMur = (Integer.parseInt(ligneRevetement.split(";")[2]) == 1);
                Boolean pourSol = (Integer.parseInt(ligneRevetement.split(";")[3]) == 1);
                Boolean pourPlafond = (Integer.parseInt(ligneRevetement.split(";")[4]) == 1);
                double prixUnitaire = Double.parseDouble(ligneRevetement.split(";")[5]);
                Revetement revetement = new Revetement(idRevetement, designation, pourMur, pourSol, pourPlafond,
                        prixUnitaire); // utilisation du constructeur de la classe Revetement avec les parametres
                                       // definis precedaments en decoupant la ligne a chaque semicolon
                revetements[idRevetement] = revetement;
                // si on veut acceder a un revetement on accede a la case du tableau
                // correspondant a l'id du revetement (la case 0 est donc vide comme les id
                // commencent a 1)
            }
            scanner.close();
            return revetements;
        } catch (FileNotFoundException e) {
            System.out.println("Erreur : listeRevetement.txt non trouve.");
            return null;
        }
    }

    // --------------------------------------------------------------------------------
    // Constructeur

    public Revetement(int idRevetement, String designation, boolean pourMur, boolean pourSol, boolean pourPlafond,
            double prixUnitaire) {
        this.idRevetement = idRevetement;
        this.designation = designation;
        this.pourMur = pourMur;
        this.pourSol = pourSol;
        this.pourPlafond = pourPlafond;
        this.prixUnitaire = prixUnitaire;
    }

    public int getIdRevetement() {
        return idRevetement;
       
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }
    
}
