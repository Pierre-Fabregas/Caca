/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author fabre
 */
import java.util.List;

public class Mur {

    int idMur;
    int idNiveau;
    int rectangleId; 
    int numero_mur; 
    int nbrePortes;
    int nbreFenetres;
    Coin coinDebut;
    Coin coinFin;
    int listeRevetement;
    double hauteur; // Hauteur du mur

    public Mur(int idMur, int rectangleId, int numero_mur, int nbrePortes, int nbreFenetres, Coin coinDebut, Coin coinFin, int listeRevetement, double hauteur, int idNiveau) {
        this.idMur = idMur;
        this.rectangleId = rectangleId;
        this.numero_mur = numero_mur;
        this.nbrePortes = nbrePortes;
        this.nbreFenetres = nbreFenetres;
        this.coinDebut = coinDebut;
        this.coinFin = coinFin;
        this.listeRevetement = listeRevetement;
        this.hauteur = hauteur;
        this.idNiveau = idNiveau;
    }

    public int getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(int idNiveau) {
        this.idNiveau = idNiveau;
    }
    
  
            

    public void setIdMur(int idMur) {
        this.idMur = idMur;
    }

    public void setRectangleId(int rectangleId) {
        this.rectangleId = rectangleId;
    }

    public void setNumero_mur(int numero_mur) {
        this.numero_mur = numero_mur;
    }

    public void setNbrePortes(int nbrePortes) {
        this.nbrePortes = nbrePortes;
    }

    public void setNbreFenetres(int nbreFenetres) {
        this.nbreFenetres = nbreFenetres;
    }

    public void setCoinDebut(Coin coinDebut) {
        this.coinDebut = coinDebut;
    }

    public void setCoinFin(Coin coinFin) {
        this.coinFin = coinFin;
    }

    public int setListeRevetement(int listeRevetement) {
        this.listeRevetement = listeRevetement;
        return 0;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public int getIdMur() {
        return idMur;
    }

    public int getRectangleId() {
        return rectangleId;
    }

    public int getNumero_mur() {
        return numero_mur;
    }

    public int getNbrePortes() {
        return nbrePortes;
    }

    public int getNbreFenetres() {
        return nbreFenetres;
    }

    public Coin getCoinDebut() {
        return coinDebut;
    }

    public Coin getCoinFin() {
        return coinFin;
    }

    public int getListeRevetement() {
        return listeRevetement;
    }

    public double getHauteur() {
        return hauteur;
    }

    @Override
    public String toString() {
        return "Mur{" + "idMur=" + idMur + ", idNiveau=" + idNiveau + ", rectangleId=" + rectangleId + ", numero_mur=" + numero_mur + ", nbrePortes=" + nbrePortes + ", nbreFenetres=" + nbreFenetres + ", coinDebut=" + coinDebut + ", coinFin=" + coinFin + ", listeRevetement=" + listeRevetement + ", hauteur=" + hauteur + '}';
    }

       
    
  
}

