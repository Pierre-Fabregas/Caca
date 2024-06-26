/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caca;

/**
 *
 * @author fabre
 */



public class Coin {
    int idNiveau;
    int idcoin;
    int rectangleId;
    int coinNumber;
    double cx, cy;
   

    public Coin(int idcoin, int rectangleId, int coinNumber, double cx, double cy, int idNiveau) {
        this.rectangleId = rectangleId;
        this.coinNumber = coinNumber;
        this.cx = cx;
        this.cy = cy;
        this.idcoin = idcoin;
        this.idNiveau = idNiveau;
    }

    public double getX() {
        return cx;
    }

    public double getY() {
        return cy;
    }
    public double getIdcoin() {
        return idcoin;
    }

    public double getRectangleId() {
        return rectangleId;
    }

    public double getCoinNumber() {
        return coinNumber;
    }

    public double getCx() {
        return cx;
    }

    public double getCy() {
        return cy;
    }

    public double getIdNiveau() {
        return idNiveau;
    }

    @Override
    public String toString() {
        return "Coin{" + "idcoin" + idcoin + "rectangleId=" + rectangleId + ", coinNumber=" + coinNumber + ", cx=" + cx + ", cy=" + cy + '}';
    }
}