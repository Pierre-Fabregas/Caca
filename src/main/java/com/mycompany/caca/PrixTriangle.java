/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author fabre
 */
public class PrixTriangle {
    int idNiveau;
    int rectangleId;
    double prixmur1;
    double prixmur2;
    double prixmur3;
    double prixsol; 
    double prixplafond;
    double prixpiece;

    public PrixTriangle(int idNiveau, int rectangleId, double prixmur1, double prixmur2, double prixmur3, double prixsol, double prixplafond, double prixpiece) {
        this.idNiveau = idNiveau;
        this.rectangleId = rectangleId;
        this.prixmur1 = prixmur1;
        this.prixmur2 = prixmur2;
        this.prixmur3 = prixmur3;
        this.prixsol = prixsol;
        this.prixplafond = prixplafond;
        this.prixpiece = prixpiece;
    }

    public void setIdNiveau(int idNiveau) {
        this.idNiveau = idNiveau;
    }

    public void setRectangleId(int rectangleId) {
        this.rectangleId = rectangleId;
    }

    public void setPrixmur1(double prixmur1) {
        this.prixmur1 = prixmur1;
    }

    public void setPrixmur2(double prixmur2) {
        this.prixmur2 = prixmur2;
    }

    public void setPrixmur3(double prixmur3) {
        this.prixmur3 = prixmur3;
    }


    public void setPrixsol(double prixsol) {
        this.prixsol = prixsol;
    }

    public void setPrixplafond(double prixplafond) {
        this.prixplafond = prixplafond;
    }

    public void setPrixpiece(double prixpiece) {
        this.prixpiece = prixpiece;
    }

    
    
    public int getIdNiveau() {
        return idNiveau;
    }

    public int getRectangleId() {
        return rectangleId;
    }

    public double getPrixmur1() {
        return prixmur1;
    }

    public double getPrixmur2() {
        return prixmur2;
    }

    public double getPrixmur3() {
        return prixmur3;
    }


    public double getPrixsol() {
        return prixsol;
    }

    public double getPrixplafond() {
        return prixplafond;
    }

    public double getPrixpiece() {
        return prixpiece;
    }

}
