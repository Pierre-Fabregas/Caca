
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
     int idRevetement;
   String designation;
    boolean pourMur;
    boolean pourSol;
     boolean pourPlafond;
     double prixUnitaire;
   static File Revetementfichier = new File("listeRevetement.txt");

    @Override
     public String toString() {
        return designation;
    }
     
     private static Revetement[] stockagRevetements(int nbRevetements) {
    File Revetementfichier = new File("listeRevetement.txt");
    try (Scanner scanner = new Scanner(Revetementfichier)) {
        Revetement[] revetements = new Revetement[nbRevetements + 1]; // +1 car les indices commencent à 1
        scanner.nextLine(); // Si ton fichier a un en-tête, décommente cette ligne
        while (scanner.hasNextLine()) {
            String ligneRevetement = scanner.nextLine();
            String[] parts = ligneRevetement.split(";");
            int idRevetement = Integer.parseInt(parts[0]);
            String designation = parts[1];
            boolean pourMur = Integer.parseInt(parts[2]) == 1;
            boolean pourSol = Integer.parseInt(parts[3]) == 1;
            boolean pourPlafond = Integer.parseInt(parts[4]) == 1;
            double prixUnitaire = Double.parseDouble(parts[5]);

            revetements[idRevetement] = new Revetement(idRevetement, designation, pourMur, pourSol, pourPlafond, prixUnitaire);
            System.out.println("Loaded: " + designation + " - PourSol: " + pourSol);
        }
        return revetements;
    } catch (FileNotFoundException e) {
        System.out.println("Erreur : listeRevetement.txt non trouvé.");
        return null;
    }
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
