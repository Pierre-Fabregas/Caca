/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caca;

import java.util.Arrays;

/**
 *
 * @author pfabregas01
 */
public class Plafond {
    
    int rectangleId;
    Coin coin1;
    Coin coin2;
    Coin coin3;
    Coin coin4;
    int listeRevetement;
    int tremie;
    int idNiveau;

    public Plafond(int rectangleId, Coin coin1, Coin coin2, Coin coin3, Coin coin4, int listeRevetement, int tremie, int idNiveau) {
        
        this.rectangleId = rectangleId;
        this.coin1 = coin1;
        this.coin2 = coin2;
        this.coin3 = coin3;
        this.coin4 = coin4;
        this.listeRevetement = listeRevetement;
        this.tremie = tremie;
        this.idNiveau = idNiveau;
    }

    public int getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(int idNiveau) {
        this.idNiveau = idNiveau;
    }

    
    public void setTremie(int tremie) {
        this.tremie = tremie;
    }

    public int getTremie() {
        return tremie;
    }

    public void setRectangleId(int rectangleId) {
        this.rectangleId = rectangleId;
    }

    public void setCoin1(Coin coin1) {
        this.coin1 = coin1;
    }

    public void setCoin2(Coin coin2) {
        this.coin2 = coin2;
    }

    public void setCoin3(Coin coin3) {
        this.coin3 = coin3;
    }

    public void setCoin4(Coin coin4) {
        this.coin4 = coin4;
    }

    public void setListeRevetement(int listeRevetement) {
        this.listeRevetement = listeRevetement;
    }

    
    

    public int getRectangleId() {
        return rectangleId;
    }

    public Coin getCoin1() {
        return coin1;
    }

    public Coin getCoin2() {
        return coin2;
    }

    public Coin getCoin3() {
        return coin3;
    }

    public Coin getCoin4() {
        return coin4;
    }

    public int getListeRevetement() {
        return listeRevetement;
    }

    @Override
    public String toString() {
        return "Plafond{" +  " rectangleId=" + rectangleId + ", coin1=" + coin1 + ", coin2=" + coin2 + ", coin3=" + coin3 + ", coin4=" + coin4 + ", listeRevetements=" + listeRevetement + ", tremie=" + tremie + '}';
    }

    
    
   
   
    
}
