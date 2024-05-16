
package com.mycompany.caca;


import java.io.FileWriter;
import java.io.IOException;

public class ResetFile {
    // Méthode pour effacer le contenu d'un fichier
    public static void clearFile(String filePath) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath);
            // Écrire une chaîne vide dans le fichier pour effacer son contenu
            fileWriter.write("");
        } catch (IOException e) {
            System.err.println("Une erreur est survenue lors de l'effacement du fichier : " + e.getMessage());
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    System.err.println("Échec de la fermeture du FileWriter : " + e.getMessage());
                }
            }
        }
    }
}
