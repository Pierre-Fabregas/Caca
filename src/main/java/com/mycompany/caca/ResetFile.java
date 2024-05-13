
package com.mycompany.caca;


import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class ResetFile {
    public static void main(String[] args) {
        PrintWriter pwprix;
        try {
            // Ouverture de 'prix.txt' en mode écrasement (par défaut).
            pwprix = new PrintWriter(new FileOutputStream("prix.txt"));
            // Écriture d'une ligne pour tester, ou bien laisser vide pour seulement vider le fichier
            // pwprix.println("Le fichier est réinitialisé à chaque lancement du programme.");
            pwprix.close(); // Ferme le flux et vide le tampon, écrivant les changements sur le disque.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
