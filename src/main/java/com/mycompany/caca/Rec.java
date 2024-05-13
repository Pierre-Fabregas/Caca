/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author fabre
 */
public class Rec {
    private double lon;
    private double lar;
    private double ori_x;
    private double ori_y;
    
    Rec(double lon, double lar, double ox, double oy) {
        this.lon = lon;
        this.lar = lar;
        this.ori_x = ox;
        this.ori_y = oy;
    }
    
    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLar() {
        return lar;
    }

    public void setLar(double lar) {
        this.lar = lar;
    }

    public double getOri_x() {
        return ori_x;
    }

    public void setOri_x(double ori_x) {
        this.ori_x = ori_x;
    }

    public double getOri_y() {
        return ori_y;
    }

    public void setOri_y(double ori_y) {
        this.ori_y = ori_y;
    }

    public double surface() {
        return this.lon * this.lar;
    }

    @Override
    public String toString() {
        return "Rectangle [lon=" + lon + ", lar=" + lar + ", ori_x=" + ori_x + ", ori_y=" + ori_y + "]";
    }

    
}
