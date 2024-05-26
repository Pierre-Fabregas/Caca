/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caca;

/**
 *
 * @author fabre
 */

public class PieceP {
    
    int idPiece;
    int idmur1;
    int idmur2;
    int idmur3;
    int idmur4;
    int idsol;
    int idplafond;

    public PieceP(int idPiece, int idsol, int idplafond, int idmur1, int idmur2, int idmur3, int idmur4 ) {
        this.idPiece = idPiece;
        this.idmur1 = idmur1;
        this.idmur2 = idmur2;
        this.idmur3 = idmur3;
        this.idmur4 = idmur4;
        this.idsol = idsol;
        this.idplafond = idplafond;
    }
    
    public int[] getIdsMurs() {
        return new int[] {idmur1, idmur2, idmur3, idmur4}; // Retourne les identifiants des murs sous forme de tableau
    }

    public int getIdPiece() {
        return idPiece;
    }

    public int getIdmur1() {
        return idmur1;
    }

    public int getIdmur2() {
        return idmur2;
    }

    public int getIdmur3() {
        return idmur3;
    }

    public int getIdmur4() {
        return idmur4;
    }

    public int getIdsol() {
        return idsol;
    }

    public int getIdplafond() {
        return idplafond;
    }
    

}


    

    