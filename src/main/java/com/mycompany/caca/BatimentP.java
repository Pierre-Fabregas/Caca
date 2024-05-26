/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caca;

/**
 *
 * @author fabre
 */
import java.util.List;

public class BatimentP {
    private int idBatiment;
    private List<Integer> listeNiveaux;

    public BatimentP(int idBatiment, List<Integer> listeNiveaux) {
        this.idBatiment = idBatiment;
        this.listeNiveaux = listeNiveaux;
    }

    public int getIdBatiment() {
        return idBatiment;
    }

    public List<Integer> getListeNiveaux() {
        return listeNiveaux;
    }
}