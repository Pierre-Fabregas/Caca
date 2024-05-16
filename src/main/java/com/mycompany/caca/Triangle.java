/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caca;

/**
 *
 * @author fabre
 */
public class Triangle {
 
    private double Acx;
    private double Acy;
    private double Bcx;
    private double Bcy;
    private double Ccx;
    private double Ccy;
    private double longAB;
    private double longBC;
    private double longCA;
    private int idNiveau;

    public Triangle(double Acx, double Acy, double Bcx, double Bcy, double Ccx, double Ccy, double longAB, double longBC, double longCA,int idNiveau) {
        this.Acx = Acx;
        this.Acy = Acy;
        this.Bcx = Bcx;
        this.Bcy = Bcy;
        this.Ccx = Ccx;
        this.Ccy = Ccy;
        this.longAB = longAB;
        this.longBC = longBC;
        this.longCA = longCA;
        this.idNiveau = idNiveau;
    }

    public int getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(int idNiveau) {
        this.idNiveau = idNiveau;
    }

    public void setAcx(double Acx) {
        this.Acx = Acx;
    }

    public void setAcy(double Acy) {
        this.Acy = Acy;
    }

    public void setBcx(double Bcx) {
        this.Bcx = Bcx;
    }

    public void setBcy(double Bcy) {
        this.Bcy = Bcy;
    }

    public void setCcx(double Ccx) {
        this.Ccx = Ccx;
    }

    public void setCcy(double Ccy) {
        this.Ccy = Ccy;
    }

    public void setLongAB(double longAB) {
        this.longAB = longAB;
    }

    public void setLongBC(double longBC) {
        this.longBC = longBC;
    }

    public void setLongCA(double longCA) {
        this.longCA = longCA;
    }

    

    
    
    public double getAcx() {
        return Acx;
    }

    public double getAcy() {
        return Acy;
    }

    public double getBcx() {
        return Bcx;
    }

    public double getBcy() {
        return Bcy;
    }

    public double getCcx() {
        return Ccx;
    }

    public double getCcy() {
        return Ccy;
    }

    public double getLongAB() {
        return longAB;
    }

    public double getLongBC() {
        return longBC;
    }

    public double getLongCA() {
        return longCA;
    }

    
    
    
    
    
    
    
    
  
}
