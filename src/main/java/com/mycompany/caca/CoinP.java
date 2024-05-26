/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caca;
/**
 *
 * @author fabre
 */
public class CoinP {
  
    int idcoin;
    double cx, cy;
   

    public CoinP (int idcoin, double cx, double cy) {
 
        this.cx = cx;
        this.cy = cy;
        this.idcoin = idcoin;
    
    }

    public int getIdcoin() {
        return idcoin;
    }

    public double getCx() {
        return cx;
    }

    public double getCy() {
        return cy;
    }
    
}
