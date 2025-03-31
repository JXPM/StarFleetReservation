package fr.starfleet;

import fr.starfleet.systeme.SystemeReservation;
import fr.starfleet.ui.InterfaceConsole;

public class Main {
    public static void main(String[] args) {
        // Tenter de charger les données existantes
        SystemeReservation systemeReservation = SystemeReservation.chargerDonnees("data/sauvegarde.dat");
        
        // Si aucune donnée n'est chargée, créer un nouveau système
        if (systemeReservation == null) {
            systemeReservation = new SystemeReservation();
            System.out.println("Création d'un nouveau système de réservation.");
        } else {
            System.out.println("Données chargées avec succès.");
        }

        // Créer l'interface console
        InterfaceConsole interfaceConsole = new InterfaceConsole(systemeReservation);

        try {
            // Démarrer l'interface utilisateur
            interfaceConsole.demarrer();
        } finally {
            // Sauvegarder les données à la fin de l'exécution
            systemeReservation.sauvegarderDonnees("data/sauvegarde.dat");
        }
    }
}