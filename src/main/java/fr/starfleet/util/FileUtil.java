package fr.starfleet.util;

import java.io.*;

public class FileUtil {
    
    /**
     * Sauvegarder un objet sérialisable dans un fichier
     * @param objet L'objet à sauvegarder
     * @param chemin Le chemin du fichier de sauvegarde
     * @return true si la sauvegarde réussit, false sinon
     */
    public static boolean sauvegarder(Serializable objet, String chemin) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(chemin))) {
            oos.writeObject(objet);
            return true;
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde : " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Charger un objet sérialisable depuis un fichier
     * @param chemin Le chemin du fichier à charger
     * @return L'objet chargé, ou null si le chargement échoue
     */
    public static Object charger(String chemin) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(chemin))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erreur lors du chargement : " + e.getMessage());
            return null;
        }
    }
}