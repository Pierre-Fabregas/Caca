/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caca;

/**
 *
 * @author fabre
 */
public class Rec {
    private double cx1;
    private double cy1;
    private double cx2;
    private double cy2;
    private double cx3;
    private double cy3;
    private double cx4;
    private double cy4;
    private int idNiveau;

    public Rec(double cx1, double cy1, double cx2, double cy2, double cx3, double cy3, double cx4, double cy4,int idNiveau) {
        this.cx1 = cx1;
        this.cy1 = cy1;
        this.cx2 = cx2;
        this.cy2 = cy2;
        this.cx3 = cx3;
        this.cy3 = cy3;
        this.cx4 = cx4;
        this.cy4 = cy4;
        this.idNiveau = idNiveau;
    }

    public int getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(int idNiveau) {
        this.idNiveau = idNiveau;
    }

    public void setCx1(double cx1) {
        this.cx1 = cx1;
    }

    public void setCy1(double cy1) {
        this.cy1 = cy1;
    }

    public void setCx2(double cx2) {
        this.cx2 = cx2;
    }

    public void setCy2(double cy2) {
        this.cy2 = cy2;
    }

    public void setCx3(double cx3) {
        this.cx3 = cx3;
    }

    public void setCy3(double cy3) {
        this.cy3 = cy3;
    }

    public void setCx4(double cx4) {
        this.cx4 = cx4;
    }

    public void setCy4(double cy4) {
        this.cy4 = cy4;
    }

    public double getCx1() {
        return cx1;
    }

    public double getCy1() {
        return cy1;
    }

    public double getCx2() {
        return cx2;
    }

    public double getCy2() {
        return cy2;
    }

    public double getCx3() {
        return cx3;
    }

    public double getCy3() {
        return cy3;
    }

    public double getCx4() {
        return cx4;
    }

    public double getCy4() {
        return cy4;
    }
    
    
    

    
    

    
}
