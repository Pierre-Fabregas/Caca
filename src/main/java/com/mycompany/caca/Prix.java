/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author fabre
 */
public class Prix {
    int idNiveau;
    int rectangleId;
    double prixmur1;
    double prixmur2;
    double prixmur3;
    double prixmur4;
    double prixsol; 
    double prixplafond;
    double prixpiece;

    public Prix(int idNiveau, int rectangleId, double prixmur1, double prixmur2, double prixmur3, double prixmur4, double prixsol, double prixplafond, double prixpiece) {
        this.idNiveau = idNiveau;
        this.rectangleId = rectangleId;
        this.prixmur1 = prixmur1;
        this.prixmur2 = prixmur2;
        this.prixmur3 = prixmur3;
        this.prixmur4 = prixmur4;
        this.prixsol = prixsol;
        this.prixplafond = prixplafond;
        this.prixpiece = prixpiece;
    }

    public void setIdNiveau(int idNiveau) {
        this.idNiveau = idNiveau;
    }

    public void setRectangleId(int rectangleId) {
        this.rectangleId = rectangleId;
    }

    public void setPrixmur1(double prixmur1) {
        this.prixmur1 = prixmur1;
    }

    public void setPrixmur2(double prixmur2) {
        this.prixmur2 = prixmur2;
    }

    public void setPrixmur3(double prixmur3) {
        this.prixmur3 = prixmur3;
    }

    public void setPrixmur4(double prixmur4) {
        this.prixmur4 = prixmur4;
    }

    public void setPrixsol(double prixsol) {
        this.prixsol = prixsol;
    }

    public void setPrixplafond(double prixplafond) {
        this.prixplafond = prixplafond;
    }

    public void setPrixpiece(double prixpiece) {
        this.prixpiece = prixpiece;
    }

    
    
    public int getIdNiveau() {
        return idNiveau;
    }

    public int getRectangleId() {
        return rectangleId;
    }

    public double getPrixmur1() {
        return prixmur1;
    }

    public double getPrixmur2() {
        return prixmur2;
    }

    public double getPrixmur3() {
        return prixmur3;
    }

    public double getPrixmur4() {
        return prixmur4;
    }

    public double getPrixsol() {
        return prixsol;
    }

    public double getPrixplafond() {
        return prixplafond;
    }

    public double getPrixpiece() {
        return prixpiece;
    }

    
    public double calculerPrixMur1(Mur mur) {
    double longueur = Math.abs((mur.getCoinDebut().getX() - mur.getCoinFin().getX()));
    double hauteur = mur.getHauteur();
    double surfaceMur1 = longueur * hauteur;
    int nbrePortes = mur.getNbrePortes();
    int nbreFenetres = mur.getNbreFenetres();
    double prixRevetement = ElementRevetement(mur.getListeRevetement());
    double prixMur1 = (surfaceMur1 - (1.2 * 1.2 * nbreFenetres) - (0.9 * 2.10 * nbrePortes)) * prixRevetement;
    System.out.println("Prix mur1: " + prixMur1);
    return prixMur1;
}

public double calculerPrixMur2(Mur mur) {
    double longueur = Math.abs((mur.getCoinDebut().getX() - mur.getCoinFin().getX()));
    double hauteur = mur.getHauteur();
    double surfaceMur2 = longueur * hauteur;
    int nbrePortes = mur.getNbrePortes();
    int nbreFenetres = mur.getNbreFenetres();
    double prixRevetement = ElementRevetement(mur.getListeRevetement());
    double prixMur2 = (surfaceMur2 - (1.2 * 1.2 * nbreFenetres) - (0.9 * 2.10 * nbrePortes)) * prixRevetement;
    System.out.println("Prix mur2: " + prixMur2);
    return prixMur2;
}

public double calculerPrixMur3(Mur mur) {
    double longueur = Math.abs((mur.getCoinDebut().getY() - mur.getCoinFin().getY()));
    double hauteur = mur.getHauteur();
    double surfaceMur3 = longueur * hauteur;
    int nbrePortes = mur.getNbrePortes();
    int nbreFenetres = mur.getNbreFenetres();
    double prixRevetement = ElementRevetement(mur.getListeRevetement());
    double prixMur3 = (surfaceMur3 - (1.2 * 1.2 * nbreFenetres) - (0.9 * 2.10 * nbrePortes)) * prixRevetement;
    System.out.println("Prix mur3: " + prixMur3);
    return prixMur3;
}

public double calculerPrixMur4(Mur mur) {
    double longueur = Math.abs((mur.getCoinDebut().getY() - mur.getCoinFin().getY()));
    double hauteur = mur.getHauteur();
    double surfaceMur4 = longueur * hauteur;
    int nbrePortes = mur.getNbrePortes();
    int nbreFenetres = mur.getNbreFenetres();
    double prixRevetement = ElementRevetement(mur.getListeRevetement());
    double prixMur4 = (surfaceMur4 - (1.2 * 1.2 * nbreFenetres) - (0.9 * 2.10 * nbrePortes)) * prixRevetement;
    System.out.println("Prix mur4: " + prixMur4);
    return prixMur4;
}

public double calculerPrixSol(Sol sol) {
    double surfaceSol = calculerSurfaceSol(sol);
    int nbreTremiesSol = sol.getTremie();
    double prixRevetementSol = ElementRevetement(sol.getListeRevetement());
    double prixSol = (surfaceSol - (2 * 1 * nbreTremiesSol)) * prixRevetementSol;
    System.out.println("Prix sol: " + prixSol);
    return prixSol;
}

public double calculerPrixPlafond(Plafond plafond) {
    double surfacePlafond = calculerSurfacePlafond(plafond);
    int nbreTremiesPlafond = plafond.getTremie();
    double prixRevetementPlafond = ElementRevetement(plafond.getListeRevetement());
    double prixPlafond = (surfacePlafond - (2 * 1 * nbreTremiesPlafond)) * prixRevetementPlafond;
    System.out.println("Prix plafond: " + prixPlafond);
    return prixPlafond;
}


public double calculerSurfaceMur(Mur mur) {
    double longueur=0;
    if (mur.getNumero_mur() == 1) {
        longueur = Math.abs(((mur.getCoinDebut().getX() - mur.getCoinFin().getX()) ));
        longueurmur1 = longueur;
    }
    if ( mur.getNumero_mur() == 3) {
        longueur = Math.abs(((mur.getCoinDebut().getX() - mur.getCoinFin().getX()) ));
        longueurmur2 = longueur;
    }
    if (mur.getNumero_mur() == 2 ) {
        longueur = Math.abs((mur.getCoinDebut().getY() - mur.getCoinFin().getY()) );
        longueurmur3 = longueur;
    }
    if ( mur.getNumero_mur() == 4) {
        longueur = Math.abs((mur.getCoinDebut().getY() - mur.getCoinFin().getY()) );
        longueurmur4 = longueur;
    }
    double hauteur = mur.getHauteur();
    hauteurmur = hauteur;
     System.out.println("surface mur" +longueur * hauteur);
    return longueur * hauteur;
}   
   double longueurmur1;
   double longueurmur2;
   double longueurmur3;
   double longueurmur4;
   double hauteurmur;
   double surfacesol;
   double surfaceplafond;
   
   
   
// Fonction pour calculer la surface d'un mur




// Fonction pour calculer la surface du sol
public double calculerSurfaceSol(Sol sol) {
    double longueur = (sol.getCoin1().getX() - sol.getCoin2().getX() );
    double largeur = (sol.getCoin1().getY() - sol.getCoin3().getY() );
    System.out.println("surface sol " +longueur * largeur);
    surfacesol =longueur * largeur;
    return longueur * largeur;
}

// Fonction pour calculer la surface du plafond
public double calculerSurfacePlafond(Plafond plafond) {
    double longueur = (plafond.getCoin1().getX() - plafond.getCoin2().getX() );
    double largeur = (plafond.getCoin1().getY() - plafond.getCoin3().getY() );
     System.out.println("surface plafond" + longueur * largeur);
     surfaceplafond = longueur * largeur;
    return longueur * largeur;
}

    // Fonction pour calculer le prix unitaire du revêtement
    public double ElementRevetement(int Revetement) {
        double prix = 0;

        switch (Revetement) {
            case 1:
                prix = 10.95;
                break;
            case 2:
                prix = 49.75;
                break;
            case 3:
                prix = 50.60;
                break;
            case 4:
                prix = 97.85;
                break;
            case 5:
                prix = 67.80;
                break;
            case 6:
                prix = 32.90;
                break;
            case 7:
                prix = 15.20;
                break;
            case 8:
                prix = 77.30;
                break;
            case 9:
                prix = 29.90;
                break;
            case 10:
                prix = 89.45;
                break;
            case 11:
                prix = 42.50;
                break;
            case 12:
                prix = 25.40;
                break;
            case 13:
                prix = 46.36;
                break;
            case 14:
                prix = 23.55;
                break;
            case 15:
                prix = 48.10;
                break;
            case 16:
                prix = 31.99;
                break;
            case 17:
                prix = 17.95;
                break;
            case 18:
                prix = 33.90;
                break;
            case 19:
                prix = 10.35;
                break;
        }

        return prix;
    }
    
    
    
    
    
    @Override
    public String toString() {
        return "Prix{" + "idNiveau=" + idNiveau + ", rectangleId=" + rectangleId + ", prixmur1=" + prixmur1 + ", prixmur2=" + prixmur2 + ", prixmur3=" + prixmur3 + ", prixmur4=" + prixmur4 + ", prixsol=" + prixsol + ", prixplafond=" + prixplafond + ", prixpiece=" + prixpiece + '}';
    }
    

}

