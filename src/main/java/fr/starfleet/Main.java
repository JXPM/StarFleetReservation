package fr.starfleet;

import fr.starfleet.systeme.SystemeReservation;
import fr.starfleet.ui.InterfaceConsole;

public class Main {
    public static void main(String[] args) {
        // Initialiser le système de réservation
        SystemeReservation systemeReservation = new SystemeReservation();
        
        // Créer l'interface console et démarrer l'application
        InterfaceConsole interfaceConsole = new InterfaceConsole(systemeReservation);
        
        // Démarrer l'interface utilisateur
        interfaceConsole.demarrer();
    }
}