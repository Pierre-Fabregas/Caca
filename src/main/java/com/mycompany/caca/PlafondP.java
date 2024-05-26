/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caca;

/**
 *
 * @author fabre
 */
public class PlafondP {
    
    int idPlafond;
    int idcoin1;
    int idcoin2;
    int idcoin3;
    int idcoin4;
    int listeRevetement;

    public PlafondP(int idPlafond, int idcoin1, int idcoin2, int idcoin3, int idcoin4, int listeRevetement) {
        this.idPlafond = idPlafond;
        this.idcoin1 = idcoin1;
        this.idcoin2 = idcoin2;
        this.idcoin3 = idcoin3;
        this.idcoin4 = idcoin4;
        this.listeRevetement = listeRevetement;

    }

    public int getIdPlafond() {
        return idPlafond;
    }

    public int getIdcoin1() {
        return idcoin1;
    }

    public int getIdcoin2() {
        return idcoin2;
    }

    public int getIdcoin3() {
        return idcoin3;
    }

    public int getIdcoin4() {
        return idcoin4;
    }

    public int getListeRevetement() {
        return listeRevetement;
    }


}


