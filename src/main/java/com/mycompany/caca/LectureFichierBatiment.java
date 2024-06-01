/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caca;

/**
 *
 * @author fabre
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class LectureFichierBatiment {

    public static void main(String[] args) {
        new LectureFichierBatiment().startParsing();
    }
    
        
    
    public void ecrirePrixBatiment(List<BatimentP> listeBatiments, List<CoinP> listeCoins, List<MurP> listeMurs, List<SolP> listeSols, List<PlafondP> listePlafonds, List<PieceP> listePieces, List<NiveauP> listeNiveaux, List<AppartementP> listeAppartements) {
        PrintWriter pwwriter;
            try {
    // Active le mode "append" en passant true comme second argument à FileOutputStream
        pwwriter = new PrintWriter(new FileOutputStream("prixLecture.txt", false)); 
        double prixTotal = 0;
            for (BatimentP batiment : listeBatiments) {
                double prixTotalBatiment = 0;
                pwwriter.println("Batiment (" + batiment.getIdBatiment() + ") : " + calculerPrixBatiment(batiment, listeCoins, listeMurs,listeSols, listePlafonds,  listePieces, listeNiveaux,  listeAppartements, listeBatiments) + " €");
                

                for (int idniveau : batiment.getListeNiveaux()) {
                    NiveauP niveau = trouverNiveauParId(idniveau, listeNiveaux);
                    if (niveau != null) {
                        double prixTotalNiveau = 0;
                        pwwriter.println("\tNiveau(" + niveau.getIdNiveau() + ") : " + calculerPrixNiveau(niveau, listeCoins, listeMurs, listeSols, listePlafonds, listePieces, listeNiveaux, listeAppartements)+ " €");
                        

                        for (int idAppartement : niveau.getListeAppartements()) {
                            AppartementP appartement = trouverAppartementParId(idAppartement, listeAppartements);
                            if (appartement != null) {
                                double prixTotalAppartement = 0;
                                pwwriter.println("\t\tAppartement (" + appartement.getIdAppartement() + ") : " + calculerPrixAppartement(appartement, listePieces, listeCoins, listeMurs, listeSols, listePlafonds,  listeNiveaux, listeAppartements)+ " €" );
                                

                                for (int idPiece : appartement.getPieces()) {
                                    PieceP piece = trouverPieceParId(idPiece, listePieces);
                                    if (piece != null) {
                                        double prixTotalPiece = 0;
                                        pwwriter.println("\t\t\tPiece (" + piece.getIdPiece() + ") : " + calculerPrixPiece( piece, listeCoins, listeMurs, listeSols, listePlafonds, listePieces, listeNiveaux, listeAppartements)+ " €" );
                                     

                                        for (int idMur : piece.getIdsMurs()) {
                                            MurP mur = trouverMurParId(idMur, listeMurs);
                                            if (mur != null) {
                                                double prixMur = calculerPrixMur(mur, listeCoins, listePieces, listeNiveaux, listeAppartements);
                                                pwwriter.println("\t\t\t\tmur" + mur.getIdMur() + " (" + idMur + ") : " + prixMur + " €");
                                               
                                                
                                            }
                                        }

                                        SolP sol = trouverSolParId(piece.getIdsol(), listeSols);
                                        if (sol != null) {
                                            double prixSol = calculerPrixSol(piece, listeSols, listeCoins);
                                            pwwriter.println("\t\t\t\tsol (" + sol.getIdSol() + ") : " + prixSol + " €");
                                        
                                           
                                        }

                                        PlafondP plafond = trouverPlafondParId(piece.getIdplafond(), listePlafonds);
                                        if (plafond != null) {
                                            double prixPlafond = calculerPrixPlafond(piece, listePlafonds, listeCoins);
                                            pwwriter.println("\t\t\t\tplafond (" + plafond.getIdPlafond() + ") : " + prixPlafond + " €");
                                        
                                           
                                        }                                        
                                    }
                                    pwwriter.println("  ");

                                }  
                            }
                            pwwriter.println("  ");
                        }
                        pwwriter.println("  ");
                    }
                }
                prixTotal= prixTotal +calculerPrixBatiment(batiment, listeCoins, listeMurs,listeSols, listePlafonds,  listePieces, listeNiveaux,  listeAppartements, listeBatiments);
            }
            pwwriter.println("  ");
            pwwriter.println("  ");
            pwwriter.println("PRIX TOTAL : " + prixTotal + " €");
            
        pwwriter.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
}  
    }
    
    
         
    public double PrixRevetement(int Revetement) {
        double prix = 0;

        switch (Revetement) {
            case 125:
                prix = 10.95;
                break;
            case 23:
                prix = 49.75;
                break;
            case 43:
                prix = 50.60;
                break;
            case 48:
                prix = 97.85;
                break;
            case 105:
                prix = 67.80;
                break;
            case 60:
                prix = 32.90;
                break;
            case 75:
                prix = 15.20;
                break;
            case 8:
                prix = 77.30;
                break;
            case 19:
                prix = 29.90;
                break;
            case 15:
                prix = 89.45;
                break;
            case 110:
                prix = 42.50;
                break;
            case 102:
                prix = 25.40;
                break;
            case 132:
                prix = 46.36;
                break;
            case 114:
                prix = 23.55;
                break;
            case 156:
                prix = 48.10;
                break;
            case 1126:
                prix = 31.99;
                break;
            case 174:
                prix = 17.95;
                break;
            case 180:
                prix = 33.90;
                break;
            case 115:
                prix = 10.35;
                break;
        }

        return prix;
    }
    /*
    public double PrixRevetement(int Revetement) {
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
    }*/
/*    private List<Revetement> liste_revetements = new ArrayList<>();
    private List<Revetement> revetementsMurs = new ArrayList<>();
    private List<Revetement> revetementsSol = new ArrayList<>();
    private List<Revetement> revetementsPlafond = new ArrayList<>();
    
    
    private void lireRevetementsDepuisFichier() {
        String path = "listeRevetement.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 6) {
                    int idRevetement = Integer.parseInt(parts[0].trim());
                    String designation = parts[1].trim();
                    boolean pourMur = Integer.parseInt(parts[2].trim()) == 1;
                    boolean pourSol = Integer.parseInt(parts[3].trim()) == 1;
                    boolean pourPlafond = Integer.parseInt(parts[4].trim()) == 1;
                    double prixUnitaire = Double.parseDouble(parts[5].trim().replace("€", "").replace(",", "."));

                    Revetement revetement = new Revetement(idRevetement, designation, pourMur, pourSol, pourPlafond, prixUnitaire);
                    liste_revetements.add(revetement);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    
    private double calculerPrixNiveau(NiveauP niveau, List<CoinP> listeCoins, List<MurP> listeMurs, List<SolP> listeSols, List<PlafondP> listePlafonds, List<PieceP> listePieces, List<NiveauP> listeNiveaux, List<AppartementP> listeAppartements) {
    double prixTotalNiveau = 0;
    for (int idAppartement : niveau.getListeAppartements()) {
        AppartementP appartement = trouverAppartementParId(idAppartement, listeAppartements);
        if (appartement != null) {
            for (int idPiece : appartement.getPieces()) {
                PieceP piece = trouverPieceParId(idPiece, listePieces);
                if (piece != null) {
                    prixTotalNiveau += calculerPrixPiece(piece, listeCoins, listeMurs, listeSols, listePlafonds, listePieces, listeNiveaux, listeAppartements);
                }
            }
        }
    }
    return prixTotalNiveau;
}

    private double calculerPrixBatiment(BatimentP batiment, List<CoinP> listeCoins, List<MurP> listeMurs, List<SolP> listeSols, List<PlafondP> listePlafonds, List<PieceP> listePieces, List<NiveauP> listeNiveaux, List<AppartementP> listeAppartements, List<BatimentP> listeBatiments) {
    double prixTotalBatiment = 0;
    for (int idNiveau : batiment.getListeNiveaux()) {
        NiveauP niveau = trouverNiveauParId( idNiveau, listeNiveaux );
        double prixNiveau = calculerPrixNiveau(niveau, listeCoins, listeMurs, listeSols, listePlafonds, listePieces, listeNiveaux, listeAppartements);
        prixTotalBatiment += prixNiveau;
        System.out.println("Prix du niveau " + niveau.getIdNiveau() + " : " + prixNiveau + " €");
    }
    return prixTotalBatiment;
}

    
    public double calculerPrixAppartement(AppartementP appartement, List<PieceP> listePieces, List<CoinP> listeCoins, List<MurP> listeMurs, List<SolP> listeSols, List<PlafondP> listePlafonds,  List<NiveauP> listeNiveaux, List<AppartementP> listeAppartements) {
        double prixTotalAppartement = 0;

        for (int idPiece : appartement.getPieces()) {
            PieceP piece = trouverPieceParId(idPiece, listePieces);
                if (piece != null) {
                    double prixPiece = calculerPrixPiece(piece, listeCoins, listeMurs, listeSols, listePlafonds, listePieces, listeNiveaux, listeAppartements);
                    prixTotalAppartement += prixPiece;
                }
        }

    return prixTotalAppartement;
    }

            // Méthode pour trouver une pièce par son ID
    private PieceP trouverPieceParId(int idPiece, List<PieceP> listePieces) {
        for (PieceP piece : listePieces) {
            if (piece.getIdPiece() == idPiece) {
                return piece;
            }
        }
    return null;
    }
    
    private AppartementP trouverAppartementParId(int idAppartement, List<AppartementP> listeAppartements) {
    for (AppartementP appartement : listeAppartements) {
        if (appartement.getIdAppartement() == idAppartement) {
            return appartement;
        }
    }
    return null;
}
    private NiveauP trouverNiveauParId(int idNiveau, List<NiveauP> listeNiveaux) {
    for (NiveauP niveau : listeNiveaux) {
        if (niveau.getIdNiveau() == idNiveau) {
            return niveau;
        }
    }
    return null;
}

    // Méthode pour calculer le prix total d'une pièce
    public double calculerPrixPiece(PieceP piece, List<CoinP> listeCoins, List<MurP> listeMurs, List<SolP> listeSols, List<PlafondP> listePlafonds, List<PieceP> listePieces, List<NiveauP> listeNiveaux, List<AppartementP> listeAppartements) {
        double prixTotal = 0;

        prixTotal += calculerPrixMurs(piece, listeMurs, listeCoins, listePieces, listeNiveaux, listeAppartements);
        prixTotal += calculerPrixSol(piece, listeSols, listeCoins);
        prixTotal += calculerPrixPlafond(piece, listePlafonds, listeCoins);

        return prixTotal;
    }

    // Méthode pour calculer le prix des murs d'une pièce
    private double calculerPrixMurs(PieceP piece, List<MurP> listeMurs, List<CoinP> listeCoins, List<PieceP> listePieces, List<NiveauP> listeNiveaux, List<AppartementP> listeAppartements) {
        double prixTotalMurs = 0;
        for (int idMur : piece.getIdsMurs()) {
            MurP mur = trouverMurParId(idMur, listeMurs);
            double prixMur = calculerPrixMur(mur, listeCoins, listePieces, listeNiveaux, listeAppartements);
            prixTotalMurs += prixMur;
        }
        return prixTotalMurs;
    }

    // Méthode pour calculer le prix d'un mur
    private double calculerPrixMur(MurP mur, List<CoinP> listeCoins, List<PieceP> listePieces, List<NiveauP> listeNiveaux, List<AppartementP> listeAppartements) {
    CoinP coinDebut = trouverCoinParId(mur.getIdcoinDebut(), listeCoins);
    CoinP coinFin = trouverCoinParId(mur.getIdcoinFin(), listeCoins);
    double longueurMur = calculerDistance(coinDebut, coinFin);

    // Utiliser la nouvelle méthode pour obtenir la hauteur sous plafond
    double hauteurMur = trouverHauteurSousPlafond(mur, listePieces, listeNiveaux, listeAppartements);

    double surfaceMur = longueurMur * hauteurMur - 1.2 * 1.2 * mur.getNbreFenetres() - 0.9 * 2.1 * mur.getNbrePortes();
    double prixRevetement = PrixRevetement(mur.getListeRevetement());
    System.out.println("Le prix du revetement est" + prixRevetement );
    System.out.println("prix mur:" + mur.getIdMur() + "=" + surfaceMur * prixRevetement);
    return surfaceMur * prixRevetement;
}
    
    private double trouverHauteurSousPlafond(MurP mur, List<PieceP> listePieces, List<NiveauP> listeNiveaux, List<AppartementP> listeAppartements) {
    for (PieceP piece : listePieces) {
        if (piece.getIdmur1()==mur.getIdMur() || piece.getIdmur2()==mur.getIdMur() || piece.getIdmur3()==mur.getIdMur()  || piece.getIdmur4()==mur.getIdMur()) {
            for (AppartementP appartement : listeAppartements) {
                if (appartement.getPieces().contains(piece.getIdPiece())) {
                    for (NiveauP niveau : listeNiveaux) {
                        if (niveau.getListeAppartements().contains(appartement.getIdAppartement())) {
                    return niveau.getHauteurSousPlafond();
                }
            }
        }
    }
    
    }   
    }
    return 2;
    }

    // Méthode pour calculer le prix du sol d'une pièce
    private double calculerPrixSol(PieceP piece, List<SolP> listeSols, List<CoinP> listeCoins) {
        double prixTotalSol = 0;
        SolP sol = trouverSolParId(piece.getIdsol(), listeSols);
        if (sol != null) {
            CoinP coin1 = trouverCoinParId(sol.getIdcoin1(), listeCoins);
            CoinP coin2 = trouverCoinParId(sol.getIdcoin2(), listeCoins);
            CoinP coin3 = trouverCoinParId(sol.getIdcoin3(), listeCoins);
            CoinP coin4 = trouverCoinParId(sol.getIdcoin4(), listeCoins);
            double surfaceSol = calculerSurface(coin1, coin2, coin3, coin4);
            double prixRevetementSol = PrixRevetement(sol.getListeRevetement());
            prixTotalSol = surfaceSol * prixRevetementSol;
        }
        System.out.println("prix sol:" + sol.getIdSol()+ "=" + prixTotalSol);
        return prixTotalSol;
    }

    // Méthode pour calculer le prix du plafond d'une pièce
    private double calculerPrixPlafond(PieceP piece, List<PlafondP> listePlafonds, List<CoinP> listeCoins) {
        double prixTotalPlafond = 0;
    
            
        PlafondP plafond = trouverPlafondParId(piece.getIdplafond(), listePlafonds);
        
        if (plafond != null) {
            CoinP coin1 = trouverCoinParId(plafond.getIdcoin1(), listeCoins);
            CoinP coin2 = trouverCoinParId(plafond.getIdcoin2(), listeCoins);
            CoinP coin3 = trouverCoinParId(plafond.getIdcoin3(), listeCoins);
            CoinP coin4 = trouverCoinParId(plafond.getIdcoin4(), listeCoins);
            double surfacePlafond = calculerSurface(coin1, coin2, coin3, coin4);
            double prixRevetementPlafond = PrixRevetement(plafond.getListeRevetement());
            prixTotalPlafond = surfacePlafond * prixRevetementPlafond;
        }
      
       
        return prixTotalPlafond;
    }

    // Méthode pour trouver un mur par son ID
    private MurP trouverMurParId(int idMur, List<MurP> listeMurs) {
        for (MurP mur : listeMurs) {
            if (mur.getIdMur() == idMur) {
                return mur;
            }
        }
        return null;
    }

    // Méthode pour trouver un sol par son ID
    private SolP trouverSolParId(int idSol, List<SolP> listeSols) {
        for (SolP sol : listeSols) {
            if (sol.getIdSol() == idSol) {
                return sol;
            }
        }
        return null;
    }

    // Méthode pour trouver un plafond par son ID
    private PlafondP trouverPlafondParId(int idPlafond, List<PlafondP> listePlafonds) {
        for (PlafondP plafond : listePlafonds) {
            if (plafond.getIdPlafond() == idPlafond) {
                return plafond;
            }
        }
        return null;
    }

    // Méthode pour trouver un coin par son ID
    private CoinP trouverCoinParId(int idCoin, List<CoinP> listeCoins) {
        for (CoinP coin : listeCoins) {
            if (coin.getIdcoin() == idCoin) {
                return coin;
            }
        }
        return null;
    }

    // Méthode pour calculer la distance entre deux coins
   /* private double calculerDistance(CoinP coin1, CoinP coin2) {
        double deltaX = coin2.getCx() - coin1.getCx();
        double deltaY = coin2.getCy() - coin1.getCy();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }*/
    
    private double calculerDistance(CoinP coin1, CoinP coin2) {
        
        double x1=coin1.getCx();
        double x2=coin2.getCx();
        double y1=coin1.getCy();
        double y2=coin2.getCy();
        
    if(x1>x2 && y1>y2){
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
    if(x1<x2 && y1<y2){
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
    if(x1>x2 && y1<y2){
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y2 - y1, 2));
    }
    if(x1<x2 && y1>y2){
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y1 - y2, 2));
    }
    if(x1==x2 && y1==y2){
        return 0;
    }
    if(x1==x2 && y1>y2){
        return Math.sqrt(Math.pow(y1 - y2, 2));
    }
    if(x1==x2 && y1<y2){
        return Math.sqrt(Math.pow(y2 - y1, 2));
    }
    if(x1<x2 && y1==y2){
        return Math.sqrt(Math.pow(x2 - x1, 2) );
    }
    if(x1>x2 && y1==y2){
        return Math.sqrt(Math.pow(x1 - x2, 2) );
    }
    else {
        return 0;}
}

    // Méthode pour calculer la surface d'un sol défini par quatre coins
    private double calculerSurface(CoinP coin1, CoinP coin2, CoinP coin3, CoinP coin4) {
        double a = calculerDistance(coin1, coin2);
        double b = calculerDistance(coin2, coin3);
        double c = calculerDistance(coin3, coin4);
        double d = calculerDistance(coin4, coin1);
        double s = (a + b + c + d) / 2; // Demi-périmètre
        return Math.sqrt((s - a) * (s - b) * (s - c) * (s - d)); // Formule de Héron pour l'aire
    }

    //

    
    
    

    public void startParsing() {
        

        List<CoinP> listeCoins = new ArrayList<>();
        List<MurP> listeMurs = new ArrayList<>();
        List<SolP> listeSols = new ArrayList<>();
        List<PlafondP> listePlafonds = new ArrayList<>();
        List<PieceP> listePieces = new ArrayList<>();
        List<AppartementP> listeAppartements = new ArrayList<>();
        List<NiveauP> listeNiveaux = new ArrayList<>();
        List<BatimentP> listeBatiments = new ArrayList<>();

                
        String filePath = "Tri.txt";
        File file = new File(filePath);

        if (!file.exists()) {
            System.err.println("Le fichier " + filePath + " n'a pas été trouvé.");
            return;
        }
        
            
      
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            String line;

            // Parcours des lignes du fichier
            while ((line = reader.readLine()) != null) {
                // Parsing des données de chaque ligne et création des objets correspondants
                String[] parts = line.split(";");

                switch (parts[0].trim()) {
                    case "Coin":
                        // Créer un objet Coin et l'ajouter à la liste de coins
                        CoinP coin = parseCoin(line);
                        listeCoins.add(coin);
                        break;
                    case "Mur":
                        // Créer un objet Mur et l'ajouter à la liste de murs
                        MurP mur = parseMur(line);
                        listeMurs.add(mur);
                        break;
                    case "Sol":
                        // Créer un objet Sol et l'ajouter à la liste de sols
                        SolP sol = parseSol(line);
                        listeSols.add(sol);
                        break;
                    case "Plafond":
                        // Créer un objet Plafond et l'ajouter à la liste de plafonds
                        PlafondP plafond = parsePlafond(line);
                        listePlafonds.add(plafond);
                        break;
                    case "Piece":
                        // Créer un objet Piece et l'ajouter à la liste de pieces
                        PieceP piece = parsePiece(line);
                        listePieces.add(piece);
                        break;
                    case "Appartement":
                        AppartementP appartement = parseAppartement(line);
                        listeAppartements.add(appartement);
                    break;
                    case "Niveau":
                        NiveauP niveau = parseNiveau(line);
                        listeNiveaux.add(niveau);
                    break;
                    case "Batiment":
                        BatimentP batiment = parseBatiment(line);
                        listeBatiments.add(batiment);
                    break;
                    default:
                        // Ignorer les lignes avec un format invalide
                        System.err.println("Format de ligne invalide : " + line);
                        break;
                }
            }

            // Fermer le flux de lecture
            reader.close();
        } catch (FileNotFoundException e) {
    System.err.println("Le fichier " + filePath + " n'a pas été trouvé.");
    e.printStackTrace();
} catch (IOException e) {
    System.err.println("Une erreur s'est produite lors de la lecture du fichier " + filePath);
    e.printStackTrace();
}

        
    for (PieceP piece : listePieces) {
        double prixPiece = calculerPrixPiece(piece, listeCoins, listeMurs, listeSols, listePlafonds, listePieces, listeNiveaux, listeAppartements);
        System.out.println("Prix de la pièce " + piece.getIdPiece() + " : " + prixPiece + " €");
    }
    
    
    for (AppartementP appartement : listeAppartements) {
        double prixAppartement = calculerPrixAppartement(appartement, listePieces, listeCoins, listeMurs, listeSols, listePlafonds, listeNiveaux, listeAppartements);
        System.out.println("Prix de l'appartement " + appartement.getIdAppartement() + " : " + prixAppartement + " €");
    }
    
    
    for (NiveauP niveau : listeNiveaux) {
        double prixNiveau = calculerPrixNiveau(niveau, listeCoins, listeMurs, listeSols, listePlafonds, listePieces, listeNiveaux, listeAppartements);
        System.out.println("Prix du niveau " + niveau.getIdNiveau() + " : " + prixNiveau + " €");
    }
    
    for (BatimentP batiment : listeBatiments){
        double prixBatiment = calculerPrixBatiment(batiment, listeCoins, listeMurs, listeSols, listePlafonds, listePieces, listeNiveaux, listeAppartements, listeBatiments);
        System.out.println("Prix du batiment " + batiment.getIdBatiment() + " : " + prixBatiment + " €");
    }
    
    ecrirePrixBatiment( listeBatiments, listeCoins, listeMurs, listeSols, listePlafonds, listePieces, listeNiveaux, listeAppartements);
    
    }
    
    
   
    private CoinP parseCoin(String line) {
        String[] parts = line.split(";");
        int idCoin = Integer.parseInt(parts[1].trim());
        double cx = Double.parseDouble(parts[2].trim());
        double cy = Double.parseDouble(parts[3].trim());
        return new CoinP(idCoin, cx, cy);
    }

    private MurP parseMur(String line) {
        String[] parts = line.split(";");
        int idMur = Integer.parseInt(parts[1].trim());
        int idCoinDebut = Integer.parseInt(parts[2].trim());
        int idCoinFin = Integer.parseInt(parts[3].trim());
        int nbrePortes = Integer.parseInt(parts[4].trim());
        int nbreFenetres = Integer.parseInt(parts[5].trim());
        int idRevetement = Integer.parseInt(parts[6].trim());
        return new MurP(idMur, idCoinDebut, idCoinFin, nbrePortes, nbreFenetres, idRevetement);
    }

    private SolP parseSol(String line) {
        String[] parts = line.split(";");
        int idSol = Integer.parseInt(parts[1].trim());
        int idCoin1 = Integer.parseInt(parts[2].trim());
        int idCoin2 = Integer.parseInt(parts[3].trim());
        int idCoin3 = Integer.parseInt(parts[4].trim());
        int idCoin4 = Integer.parseInt(parts[5].trim());
        int idRevetement = Integer.parseInt(parts[6].trim());
        return new SolP(idSol, idCoin1, idCoin2, idCoin3, idCoin4, idRevetement);
    }

    private PlafondP parsePlafond(String line) {
        String[] parts = line.split(";");
        int idPlafond = Integer.parseInt(parts[1].trim());
        int idCoin1 = Integer.parseInt(parts[2].trim());
        int idCoin2 = Integer.parseInt(parts[3].trim());
        int idCoin3 = Integer.parseInt(parts[4].trim());
        int idCoin4 = Integer.parseInt(parts[5].trim());
        int idRevetement = Integer.parseInt(parts[6].trim());
        return new PlafondP(idPlafond, idCoin1, idCoin2, idCoin3, idCoin4, idRevetement);
    }

    private PieceP parsePiece(String line) {
        String[] parts = line.split(";");
        int idPiece = Integer.parseInt(parts[1].trim());
        int idSol = Integer.parseInt(parts[2].trim());
        int idPlafond = Integer.parseInt(parts[3].trim());
        int idmur1 = Integer.parseInt(parts[4].trim());
        int idmur2 = Integer.parseInt(parts[5].trim());
        int idmur3 = Integer.parseInt(parts[6].trim());
        int idmur4 = Integer.parseInt(parts[7].trim());
        return new PieceP(idPiece, idSol, idPlafond, idmur1, idmur2, idmur3, idmur4);
    }
    
    private AppartementP parseAppartement(String line) {
        String[] parts = line.split(";");
        int idAppartement = Integer.parseInt(parts[1].trim());
        int idNiveauAppartement = Integer.parseInt(parts[2].trim());
        List<Integer> idsPieces = new ArrayList<>();
        for (int i = 3; i < parts.length; i++) {
            idsPieces.add(Integer.parseInt(parts[i].trim()));
    }
    return new AppartementP(idAppartement, idNiveauAppartement, idsPieces);
}
    
    private NiveauP parseNiveau(String line) {
        String[] parts = line.split(";");
        int idNiveau = Integer.parseInt(parts[1].trim());
        double hauteurSousPlafond = Double.parseDouble(parts[2].trim());
        List<Integer> listeAppartements = new ArrayList<>();
        for (int i = 3; i < parts.length; i++) {
        listeAppartements.add(Integer.parseInt(parts[i].trim()));
    }
    return new NiveauP(idNiveau, hauteurSousPlafond, listeAppartements);
}
    
    private BatimentP parseBatiment(String line) {
        String[] parts = line.split(";");
        int idBatiment = Integer.parseInt(parts[1].trim());
        List<Integer> listeniveaux = new ArrayList<>();
        for (int i = 2; i < parts.length; i++) {
        listeniveaux.add(Integer.parseInt(parts[i].trim()));
    }
    
    return new BatimentP(idBatiment, listeniveaux);
}

    
}
