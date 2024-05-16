
package com.mycompany.caca;


import java.io.File;

public class FileUtils {

    // Méthode pour supprimer un fichier
    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Le fichier " + filePath + " a été supprimé.");
            } else {
                System.err.println("Impossible de supprimer le fichier " + filePath + ".");
            }
        } else {
            System.err.println("Le fichier " + filePath + " n'existe pas.");
        }
    }

    // Méthode pour supprimer plusieurs fichiers
    public static void deleteFiles(String[] filePaths) {
        for (String filePath : filePaths) {
            deleteFile(filePath);
        }
    }
}

