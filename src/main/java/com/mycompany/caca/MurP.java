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

public class MurP {

    int idMur;
    int nbrePortes;
    int nbreFenetres;
    int idcoinDebut;
    int idcoinFin;
    int listeRevetement;

    public MurP(int idMur, int idcoinDebut, int idcoinFin, int nbrePortes, int nbreFenetres,  int listeRevetement) {
        this.idMur = idMur;
        this.nbrePortes = nbrePortes;
        this.nbreFenetres = nbreFenetres;
        this.idcoinDebut = idcoinDebut;
        this.idcoinFin = idcoinFin;
        this.listeRevetement = listeRevetement;
    }

    public int getIdMur() {
        return idMur;
        
    }

    public int getIdcoinDebut() {
        return idcoinDebut;
    }

    public int getIdcoinFin() {
        return idcoinFin;
    }

    public int getNbrePortes() {
        return nbrePortes;
    }

    public int getNbreFenetres() {
        return nbreFenetres;
    }

    public int getListeRevetement() {
        return listeRevetement;
    }
    
    
}

