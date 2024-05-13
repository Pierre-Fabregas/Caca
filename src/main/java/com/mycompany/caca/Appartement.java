/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author macbookpro
 */public class Appartement {
    private int idAppartement;
    private int idNiveauAppartement;
    private Piece[] listePieces;

    public void afficher() {
    }

  

   

    // --------------------------------------------------------------------------------
    // Constructeur

    public Appartement(int idAppartement, int idNiveauAppartement, Piece[] listePieces) {
        this.idAppartement = idAppartement;
        this.idNiveauAppartement = idNiveauAppartement;
        this.listePieces = listePieces;
    }



    public int getIdAppartement() {
        return idAppartement;
    }

    public int getIdNiveauAppartement() {
        return idNiveauAppartement;
    }

    public Piece[] getListePieces() {
        return listePieces;
    }

    public void setIdAppartement(int idAppartement) {
        this.idAppartement = idAppartement;
    }

    public void setIdNiveauAppartement(int idNiveauAppartement) {
        this.idNiveauAppartement = idNiveauAppartement;
    }

    public void setListePieces(Piece[] listePieces) {
        this.listePieces = listePieces;
    }

    
    
    
    
}
