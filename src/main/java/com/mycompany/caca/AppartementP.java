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

public class AppartementP {
    private int idAppartement;
    private int idNiveauAppartement;
    private List<Integer> pieces;

    public AppartementP(int idAppartement, int idNiveauAppartement, List<Integer> pieces) {
        this.idAppartement = idAppartement;
        this.idNiveauAppartement = idNiveauAppartement;
        this.pieces = pieces;
    }

    public int getIdAppartement() {
        return idAppartement;
    }

    public void setIdAppartement(int idAppartement) {
        this.idAppartement = idAppartement;
    }

    public int getIdNiveauAppartement() {
        return idNiveauAppartement;
    }

    public void setIdNiveauAppartement(int idNiveauAppartement) {
        this.idNiveauAppartement = idNiveauAppartement;
    }

    public List<Integer> getPieces() {
        return pieces;
    }

    public void setPieces(List<Integer> pieces) {
        this.pieces = pieces;
    }

}
