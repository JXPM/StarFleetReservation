package fr.starfleet.ui;

import fr.starfleet.systeme.SystemeReservation;
import java.util.Scanner;

public class InterfaceConsole {
    private SystemeReservation systeme;
    private Scanner scanner;
    
    // Constructeur
    public InterfaceConsole(SystemeReservation systeme) {
        this.systeme = systeme;
        this.scanner = new Scanner(System.in);
    }
    
    public void afficherMenu() {
        System.out.println("=== MENU PRINCIPAL ===");
        System.out.println("1. Gestion des vaisseaux");
        System.out.println("2. Gestion des personnes");
        System.out.println("3. Gestion des missions");
        System.out.println("4. Gestion des réservations");
        System.out.println("5. Sauvegarder les données");
        System.out.println("6. Charger les données");
        System.out.println("0. Quitter");
    }
    
    // Méthode principale pour démarrer l'interface
    public void demarrer() {
        boolean continuer = true;
        
        while (continuer) {
            afficherMenu();
            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer le retour à la ligne
            
            switch (choix) {
                case 1:
                    gererVaisseaux();
                    break;
                case 2:
                    gererPersonnes();
                    break;
                case 3:
                    gererMissions();
                    break;
                case 4:
                    gererReservations();
                    break;
                case 5:
                    sauvegarderDonnees();
                    break;
                case 6:
                    chargerDonnees();
                    break;
                case 0:
                    continuer = false;
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
                    break;
            }
        }
        scanner.close();
    }
    
    private void gererVaisseaux() {
        System.out.println("\n=== GESTION DES VAISSEAUX ===");
        System.out.println("1. Ajouter un vaisseau");
        System.out.println("2. Modifier un vaisseau");
        System.out.println("3. Supprimer un vaisseau");
        System.out.println("4. Afficher tous les vaisseaux");
        System.out.println("5. Rechercher un vaisseau");
        System.out.println("0. Retour au menu principal");
        
        System.out.print("Votre choix : ");
        int choix = scanner.nextInt();
        scanner.nextLine(); // Pour consommer le retour à la ligne
        
        switch (choix) {
            case 1:
                ajouterVaisseau();
                break;
            case 2:
                modifierVaisseau();
                break;
            case 3:
                supprimerVaisseau();
                break;
            case 4:
                afficherVaisseaux();
                break;
            case 5:
                rechercherVaisseau();
                break;
            case 0:
                // Retour au menu principal
                break;
            default:
                System.out.println("Choix invalide, veuillez réessayer.");
                break;
        }
    }
    
    private void gererPersonnes() {
        System.out.println("\n=== GESTION DES PERSONNES ===");
        System.out.println("1. Ajouter un officier");
        System.out.println("2. Ajouter un civil");
        System.out.println("3. Modifier une personne");
        System.out.println("4. Supprimer une personne");
        System.out.println("5. Afficher toutes les personnes");
        System.out.println("6. Rechercher une personne");
        System.out.println("0. Retour au menu principal");
        
        System.out.print("Votre choix : ");
        int choix = scanner.nextInt();
        scanner.nextLine(); // Pour consommer le retour à la ligne
        
        switch (choix) {
            case 1:
                ajouterOfficier();
                break;
            case 2:
                ajouterCivil();
                break;
            case 3:
                modifierPersonne();
                break;
            case 4:
                supprimerPersonne();
                break;
            case 5:
                afficherPersonnes();
                break;
            case 6:
                rechercherPersonne();
                break;
            case 0:
                // Retour au menu principal
                break;
            default:
                System.out.println("Choix invalide, veuillez réessayer.");
                break;
        }
    }
    
    private void gererMissions() {
        System.out.println("\n=== GESTION DES MISSIONS ===");
        System.out.println("1. Créer une mission");
        System.out.println("2. Modifier une mission");
        System.out.println("3. Annuler une mission");
        System.out.println("4. Afficher toutes les missions");
        System.out.println("5. Rechercher des missions");
        System.out.println("6. Associer une mission à un vaisseau");
        System.out.println("0. Retour au menu principal");
        
        System.out.print("Votre choix : ");
        int choix = scanner.nextInt();
        scanner.nextLine(); // Pour consommer le retour à la ligne
        
        switch (choix) {
            case 1:
                creerMission();
                break;
            case 2:
                modifierMission();
                break;
            case 3:
                annulerMission();
                break;
            case 4:
                afficherMissions();
                break;
            case 5:
                rechercherMissions();
                break;
            case 6:
                associerMissionVaisseau();
                break;
            case 0:
                // Retour au menu principal
                System.out.println("Retour au menu principal.");
                break;
            default:
                System.out.println("Choix invalide, veuillez réessayer.");
                break;
        }
    }
    
    private void gererReservations() {
        System.out.println("\n=== GESTION DES RÉSERVATIONS ===");
        System.out.println("1. Créer une réservation");
        System.out.println("2. Confirmer une réservation");
        System.out.println("3. Annuler une réservation");
        System.out.println("4. Afficher les réservations d'une personne");
        System.out.println("5. Afficher les réservations pour une mission");
        System.out.println("0. Retour au menu principal");
        
        System.out.print("Votre choix : ");
        int choix = scanner.nextInt();
        scanner.nextLine(); // Pour consommer le retour à la ligne
        
        switch (choix) {
            case 1:
                creerReservation();
                break;
            case 2:
                confirmerReservation();
                break;
            case 3:
                annulerReservation();
                break;
            case 4:
                afficherReservationsPersonne();
                break;
            case 5:
                afficherReservationsMission();
                break;
            case 0:
                // Retour au menu principal
                break;
            default:
                System.out.println("Choix invalide, veuillez réessayer.");
                break;
        }
    }
    
    private void sauvegarderDonnees() {
        System.out.println("\n=== SAUVEGARDE DES DONNÉES ===");
        System.out.print("Entrez le nom du fichier (ou appuyez sur Entrée pour utiliser 'data/sauvegarde.dat') : ");
        String nomFichier = scanner.nextLine();
        
        if (nomFichier.trim().isEmpty()) {
            nomFichier = "data/sauvegarde.dat";
        }
        
        try {
            systeme.sauvegarderDonnees(nomFichier);
            System.out.println("Données sauvegardées avec succès dans " + nomFichier);
        } catch (Exception e) {
            System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }
    
    private void chargerDonnees() {
        System.out.println("\n=== CHARGEMENT DES DONNÉES ===");
        System.out.print("Entrez le nom du fichier (ou appuyez sur Entrée pour utiliser 'data/sauvegarde.dat') : ");
        String nomFichier = scanner.nextLine();
        
        if (nomFichier.trim().isEmpty()) {
            nomFichier = "data/sauvegarde.dat";
        }
        
        try {
            SystemeReservation nouveauSysteme = SystemeReservation.chargerDonnees(nomFichier);
            if (nouveauSysteme != null) {
                this.systeme = nouveauSysteme;
                System.out.println("Données chargées avec succès depuis " + nomFichier);
            } else {
                System.out.println("Erreur lors du chargement des données.");
            }
        } catch (Exception e) {
            System.out.println("Erreur lors du chargement : " + e.getMessage());
        }
    }
    
    // Méthodes pour la gestion des vaisseaux
    private void ajouterVaisseau() {
        System.out.println("\n=== AJOUTER UN VAISSEAU ===");
        // Implémentation à compléter
        System.out.println("Fonctionnalité non implémentée.");
    }
    
    private void modifierVaisseau() {
        System.out.println("\n=== MODIFIER UN VAISSEAU ===");
        // Implémentation à compléter
        System.out.println("Fonctionnalité non implémentée.");
    }
    
    private void supprimerVaisseau() {
        System.out.println("\n=== SUPPRIMER UN VAISSEAU ===");
        // Implémentation à compléter
        System.out.println("Fonctionnalité non implémentée.");
    }
    
    private void afficherVaisseaux() {
        System.out.println("\n=== LISTE DES VAISSEAUX ===");
        // Implémentation à compléter
        System.out.println("Fonctionnalité non implémentée.");
    }
    
    private void rechercherVaisseau() {
        System.out.println("\n=== RECHERCHER UN VAISSEAU ===");
        // Implémentation à compléter
        System.out.println("Fonctionnalité non implémentée.");
    }
    
    // Méthodes pour la gestion des personnes
    private void ajouterOfficier() {
        System.out.println("\n=== AJOUTER UN OFFICIER ===");
        // Implémentation à compléter
        System.out.println("Fonctionnalité non implémentée.");
    }
    
    private void ajouterCivil() {
        System.out.println("\n=== AJOUTER UN CIVIL ===");
        // Implémentation à compléter
        System.out.println("Fonctionnalité non implémentée.");
    }
    
    private void modifierPersonne() {
        System.out.println("\n=== MODIFIER UNE PERSONNE ===");
        // Implémentation à compléter
        System.out.println("Fonctionnalité non implémentée.");
    }
    
    private void supprimerPersonne() {
        System.out.println("\n=== SUPPRIMER UNE PERSONNE ===");
        // Implémentation à compléter
        System.out.println("Fonctionnalité non implémentée.");
    }
    
    private void afficherPersonnes() {
        System.out.println("\n=== LISTE DES PERSONNES ===");
        // Implémentation à compléter
        System.out.println("Fonctionnalité non implémentée.");
    }
    
    private void rechercherPersonne() {
        System.out.println("\n=== RECHERCHER UNE PERSONNE ===");
        // Implémentation à compléter
        System.out.println("Fonctionnalité non implémentée.");
    }
    
    // Méthodes pour la gestion des missions
    private void creerMission() {
        System.out.println("\n=== CRÉER UNE MISSION ===");
        // Implémentation à compléter
        System.out.println("Fonctionnalité non implémentée.");
    }
    
    private void modifierMission() {
        System.out.println("\n=== MODIFIER UNE MISSION ===");
        // Implémentation à compléter
        System.out.println("Fonctionnalité non implémentée.");
    }
    
    private void annulerMission() {
        System.out.println("\n=== ANNULER UNE MISSION ===");
        // Implémentation à compléter
        System.out.println("Fonctionnalité non implémentée.");
    }
    
    private void afficherMissions() {
        System.out.println("\n=== LISTE DES MISSIONS ===");
        // Implémentation à compléter
        System.out.println("Fonctionnalité non implémentée.");
    }
    
    private void rechercherMissions() {
        System.out.println("\n=== RECHERCHER DES MISSIONS ===");
        // Implémentation à compléter
        System.out.println("Fonctionnalité non implémentée.");
    }
    
    private void associerMissionVaisseau() {
        System.out.println("\n=== ASSOCIER UNE MISSION À UN VAISSEAU ===");
        // Implémentation à compléter
        System.out.println("Fonctionnalité non implémentée.");
    }
    
    // Méthodes pour la gestion des réservations
    private void creerReservation() {
        System.out.println("\n=== CRÉER UNE RÉSERVATION ===");
        // Implémentation à compléter
        System.out.println("Fonctionnalité non implémentée.");
    }
    
    private void confirmerReservation() {
        System.out.println("\n=== CONFIRMER UNE RÉSERVATION ===");
        // Implémentation à compléter
        System.out.println("Fonctionnalité non implémentée.");
    }
    
    private void annulerReservation() {
        System.out.println("\n=== ANNULER UNE RÉSERVATION ===");
        // Implémentation à compléter
        System.out.println("Fonctionnalité non implémentée.");
    }
    
    private void afficherReservationsPersonne() {
        System.out.println("\n=== RÉSERVATIONS D'UNE PERSONNE ===");
        // Implémentation à compléter
        System.out.println("Fonctionnalité non implémentée.");
    }
    
    private void afficherReservationsMission() {
        System.out.println("\n=== RÉSERVATIONS POUR UNE MISSION ===");
        // Implémentation à compléter
        System.out.println("Fonctionnalité non implémentée.");
    }
}