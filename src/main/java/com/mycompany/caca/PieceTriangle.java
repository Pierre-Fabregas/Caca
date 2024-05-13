/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caca;
/**
 *
 * @author fabre
 */
public class PieceTriangle {
    
    int rectangleId;
    Mur mur1;
    Mur mur2;
    Mur mur3;
    Sol_Triangle sol;
    Plafond_Triangle plafond;
    int idNiveau;

    public PieceTriangle(int rectangleId, Mur mur1, Mur mur2, Mur mur3, Sol_Triangle sol, Plafond_Triangle plafond, int idNiveau) {
        this.rectangleId = rectangleId;
        this.mur1 = mur1;
        this.mur2 = mur2;
        this.mur3 = mur3;
        this.sol = sol;
        this.plafond = plafond;
        this.idNiveau = idNiveau;
    }

    public void setRectangleId(int rectangleId) {
        this.rectangleId = rectangleId;
    }

    public void setMur1(Mur mur1) {
        this.mur1 = mur1;
    }

    public void setMur2(Mur mur2) {
        this.mur2 = mur2;
    }

    public void setMur3(Mur mur3) {
        this.mur3 = mur3;
    }

  

    public void setSol(Sol_Triangle sol) {
        this.sol = sol;
    }

    public void setPlafond(Plafond_Triangle plafond) {
        this.plafond = plafond;
    }

    
    
    public int getRectangleId() {
        return rectangleId;
    }

    public Mur getMur1() {
        return mur1;
    }

    public Mur getMur2() {
        return mur2;
    }

    public Mur getMur3() {
        return mur3;
    }


    public Sol_Triangle getSol() {
        return sol;
    }

    public Plafond_Triangle getPlafond() {
        return plafond;
    }

    @Override
    public String toString() {
        return "Piece{" + "rectangleId=" + rectangleId + ", mur1=" + mur1 + ", mur2=" + mur2 + ", mur3=" + mur3 +  ", sol=" + sol + ", plafond=" + plafond + '}';
    }


}
