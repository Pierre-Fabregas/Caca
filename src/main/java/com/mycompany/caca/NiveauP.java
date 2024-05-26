/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caca;

import java.util.List;

/**
 *
 * @author fabre
 */
public class NiveauP {
    private int idNiveau;
    private double hauteurSousPlafond;
    private List<Integer> listeAppartements;

    public NiveauP(int idNiveau, double hauteurSousPlafond, List<Integer> listeAppartements) {
        this.idNiveau = idNiveau;
        this.hauteurSousPlafond = hauteurSousPlafond;
        this.listeAppartements = listeAppartements;
    }

    public int getIdNiveau() {
        return idNiveau;
    }

    public double getHauteurSousPlafond() {
        return hauteurSousPlafond;
    }

    public List<Integer> getListeAppartements() {
        return listeAppartements;
    }
}