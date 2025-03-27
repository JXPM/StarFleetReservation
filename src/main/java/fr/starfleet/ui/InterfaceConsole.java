package fr.starfleet.ui;

import fr.starfleet.modele.mission.*;
import fr.starfleet.modele.personne.*;
import  fr.starfleet.modele.reservation.*;
import fr.starfleet.modele.vaisseau.*;
import fr.starfleet.systeme.SystemeReservation;
import java.util.*;

public class InterfaceConsole {
    private SystemeReservation systeme;
    private final Scanner scanner;
    
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
        try (scanner) {
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
        }
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
        String nomFichier = "data/sauvegarde.dat";
        
        try {
            systeme.sauvegarderDonnees(nomFichier);
            System.out.println("Données sauvegardées avec succès dans " + nomFichier);
        } catch (Exception e) {
            System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }
    
    private void chargerDonnees() {
        System.out.println("\n=== CHARGEMENT DES DONNÉES ===");
        String nomFichier = "data/sauvegarde.dat";
        
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
        System.out.print("Nom du vaisseau : ");
        String nomVaisseau = scanner.nextLine();
        System.out.print("Immatriculation : ");
        String immatriculation = scanner.nextLine();
        System.out.print("Capacité maximale de missions : ");
        int capaciteMaximale = scanner.nextInt();
        scanner.nextLine(); // Consommer le retour à la ligne

        Vaisseau vaisseau = new Vaisseau(nomVaisseau, immatriculation, capaciteMaximale);
        systeme.ajouterVaisseau(vaisseau);
        System.out.println("Vaisseau ajouté avec succès !");
    }
    
    private void modifierVaisseau() {
        System.out.println("\n=== MODIFIER UN VAISSEAU ===");
        System.out.print("Entrez l'immatriculation du vaisseau à modifier : ");
        String immatriculation = scanner.nextLine();
        
        Vaisseau vaisseau = systeme.rechercherVaisseau(immatriculation);
        if (vaisseau != null) {
            System.out.print("Nouveau nom (appuyez sur Entrée pour garder l'actuel) : ");
            String nouveauNom = scanner.nextLine();
            if (!nouveauNom.isEmpty()) {
                vaisseau.setNom(nouveauNom);
            }
            
            System.out.print("Nouvelle capacité maximale (-1 pour garder l'actuelle) : ");
            int nouvelleCapacite = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour à la ligne
            
            if (nouvelleCapacite != -1) {
                vaisseau.setCapaciteMaximale(nouvelleCapacite);
            }
            
            System.out.println("Vaisseau modifié avec succès !");
        } else {
            System.out.println("Vaisseau non trouvé.");
        }
    }
    
    private void supprimerVaisseau() {
        System.out.println("\n=== SUPPRIMER UN VAISSEAU ===");
        System.out.print("Entrez l'immatriculation du vaisseau à supprimer : ");
        String immatriculation = scanner.nextLine();
        
        if (systeme.supprimerVaisseau(immatriculation)) {
            System.out.println("Vaisseau supprimé avec succès !");
        } else {
            System.out.println("Aucun vaisseau trouvé avec cette immatriculation.");
        }
    }
    
    private void afficherVaisseaux() {
        System.out.println("\n=== LISTE DES VAISSEAUX ===");
        List<Vaisseau> vaisseaux = systeme.getVaisseaux();
        
        if (vaisseaux.isEmpty()) {
            System.out.println("Aucun vaisseau enregistré.");
        } else {
            for (Vaisseau vaisseau : vaisseaux) {
                System.out.println("Nom : " + vaisseau.getNom() +
                                   " - Immatriculation : " + vaisseau.getImmatriculation() +
                                   " - Capacité max : " + vaisseau.getCapaciteMaximale() +
                                   " - Missions : " + vaisseau.getNombreMissions());
            }
        }
    }
    
    private void rechercherVaisseau() {
        System.out.println("\n=== RECHERCHER UN VAISSEAU ===");
        System.out.print("Entrez l'immatriculation du vaisseau : ");
        String immatriculation = scanner.nextLine();
        
        Vaisseau vaisseau = systeme.rechercherVaisseau(immatriculation);
        if (vaisseau != null) {
            System.out.println("Détails du vaisseau :");
            System.out.println("Nom : " + vaisseau.getNom());
            System.out.println("Immatriculation : " + vaisseau.getImmatriculation());
            System.out.println("Capacité maximale : " + vaisseau.getCapaciteMaximale());
            System.out.println("Nombre de missions : " + vaisseau.getNombreMissions());
            vaisseau.afficherMissions();
        } else {
            System.out.println("Aucun vaisseau trouvé avec cette immatriculation.");
        }
    }
    
    // Les méthodes suivantes nécessiteraient des modifications dans les autres classes
    private void ajouterOfficier() {
    System.out.println("\n=== AJOUTER UN OFFICIER ===");
    System.out.print("Nom de l'officier : ");
    String nom = scanner.nextLine();
    System.out.print("Prénom de l'officier : ");
    String prenom = scanner.nextLine();
    System.out.print("Identifiant de l'officier : ");
    String identifiant = scanner.nextLine();
    System.out.print("Rang de l'officier : ");
    String rang = scanner.nextLine();
    System.out.print("Spécialité de l'officier : ");
    String specialite = scanner.nextLine();

    Officier officier = new Officier(nom, prenom, identifiant, rang, specialite);
    if ((boolean) systeme.ajouterPersonne(officier)) {
        System.out.println("Officier ajouté avec succès !");
    } else {
        System.out.println("Impossible d'ajouter l'officier.");
    }
}

private void ajouterCivil() {
    System.out.println("\n=== AJOUTER UN CIVIL ===");
    System.out.print("Nom du civil : ");
    String nom = scanner.nextLine();
    System.out.print("Prénom du civil : ");
    String prenom = scanner.nextLine();
    System.out.print("Identifiant du civil : ");
    String identifiant = scanner.nextLine();
    System.out.print("Planète d'origine : ");
    String planeteOrigine = scanner.nextLine();
    System.out.print("Motif de voyage : ");
    String motifVoyage = scanner.nextLine();

    Civil civil = new Civil(nom, prenom, identifiant, planeteOrigine, motifVoyage);
    if (systeme.ajouterPersonne(civil)) {
        System.out.println("Civil ajouté avec succès !");
    } else {
        System.out.println("Impossible d'ajouter le civil.");
    }
}
    
    private void modifierPersonne() {
        System.out.println("\n=== MODIFIER UNE PERSONNE ===");
        System.out.print("Entrez l'identifiant de la personne à modifier : ");
        String identifiant = scanner.nextLine();
        
        Personne personne = systeme.rechercherPersonne(identifiant);
        if (personne != null) {
            System.out.print("Nouveau nom (Entrée pour garder l'actuel) : ");
            String nouveauNom = scanner.nextLine();
            if (!nouveauNom.isEmpty()) {
                personne.setNom(nouveauNom);
            }
            
            System.out.print("Nouveau prénom (Entrée pour garder l'actuel) : ");
            String nouveauPrenom = scanner.nextLine();
            if (!nouveauPrenom.isEmpty()) {
                personne.setPrenom(nouveauPrenom);
            }
            systeme.mettreAJourPersonne(personne);
            System.out.println("Personne modifiée avec succès !");
        } else {
            System.out.println("Personne non trouvée.");
        }
    }
    
    private void supprimerPersonne() {
        System.out.println("\n=== SUPPRIMER UNE PERSONNE ===");
        System.out.print("Entrez l'identifiant de la personne à supprimer : ");
        String id = scanner.nextLine();
        
        if (systeme.supprimerPersonne(id)) {
            System.out.println("Personne supprimée avec succès !");
        } else {
            System.out.println("Aucune personne trouvée avec cet identifiant.");
        }
    }
    
    private void afficherPersonnes() {
        System.out.println("\n=== LISTE DES PERSONNES ===");
        List<Personne> personnes = systeme.getPersonnes();
        
        if (personnes.isEmpty()) {
            System.out.println("Aucune personne enregistrée.");
        } else {
            for (Personne personne : personnes) {
                System.out.println(personne.getNom() + " " + personne.getPrenom() +
                                   " (ID: " + personne.getIdentifiant() + ")");
            }
        }
    }
    
    private void rechercherPersonne() {
        System.out.println("\n=== RECHERCHER UNE PERSONNE ===");
        System.out.print("Entrez l'identifiant de la personne : ");
        String id = scanner.nextLine();
        
        Personne personne = systeme.rechercherPersonne(id);
        if (personne != null) {
            System.out.println("Détails de la personne :");
            System.out.println("Nom : " + personne.getNom());
            System.out.println("Prénom : " + personne.getPrenom());
            System.out.println("Identifiant : " + personne.getIdentifiant());
            System.out.println("Description : " + personne.getDescription());
        } else {
            System.out.println("Aucune personne trouvée avec cet identifiant.");
        }
    }
    
    private void creerMission() {
        System.out.println("\n=== CRÉER UNE MISSION ===");
        System.out.print("Code de la mission : ");
        String code = scanner.nextLine();
        System.out.print("Description : ");
        String description = scanner.nextLine();
        System.out.print("Destination : ");
        String destination = scanner.nextLine();
        System.out.print("Capacité maximale : ");
        int capaciteMaximale = scanner.nextInt();
        scanner.nextLine(); // Consommer le retour à la ligne
        
        System.out.print("Date de départ (AAAA-MM-JJ) : ");
        String dateDepart = scanner.nextLine();
        System.out.print("Date de retour (AAAA-MM-JJ) : ");
        String dateRetour = scanner.nextLine();
        System.out.print("Immatriculation du vaisseau : ");
        String immatriculationVaisseau = scanner.nextLine();
        
        try {
            // Conversion des dates (simplifiée ici, vous devriez utiliser un formateur de date plus robuste)
            Date depart = new Date(dateDepart.replace("-", "/"));
            Date retour = new Date(dateRetour.replace("-", "/"));
            
            systeme.creerMission(code, description, depart, retour, destination,
                                  immatriculationVaisseau, capaciteMaximale);
            System.out.println("Mission créée avec succès !");
        } catch (Exception e) {
            System.out.println("Erreur lors de la création de la mission : " + e.getMessage());
        }
    }
    
    private void modifierMission() {
        System.out.println("\n=== MODIFIER UNE MISSION ===");
        System.out.print("Code de la mission à modifier : ");
        String code = scanner.nextLine();
        
        Mission mission = systeme.rechercherMission(code);
        if (mission != null) {
            System.out.print("Nouvelle description (Entrée pour garder l'actuelle) : ");
            String nouvelleDescription = scanner.nextLine();
            if (!nouvelleDescription.isEmpty()) {
                mission.setDescription(nouvelleDescription);
            }
            
            System.out.print("Nouvelle destination (Entrée pour garder l'actuelle) : ");
            String nouvelleDestination = scanner.nextLine();
            if (!nouvelleDestination.isEmpty()) {
                mission.setDestination(nouvelleDestination);
            }
            
            System.out.println("Mission modifiée avec succès !");
        } else {
            System.out.println("Mission non trouvée.");
        }
    }
    
    private void annulerMission() {
        System.out.println("\n=== ANNULER UNE MISSION ===");
        System.out.print("Code de la mission à annuler : ");
        String code = scanner.nextLine();
        
        if (systeme.annulerMission(code)) {
            System.out.println("Mission annulée avec succès !");
        } else {
            System.out.println("Impossible d'annuler la mission.");
        }
    }
    
    private void afficherMissions() {
        System.out.println("\n=== LISTE DES MISSIONS ===");
        List<Mission> missions = systeme.getMissions();
        
        if (missions.isEmpty()) {
            System.out.println("Aucune mission enregistrée.");
        } else {
            for (Mission mission : missions) {
                System.out.println("Code : " + mission.getCode() +
                                   " - Destination : " + mission.getDestination() +
                                   " - Date départ : " + mission.getDateDepart() +
                                   " - Places disponibles : " + mission.getNombrePlacesDisponibles());
            }
        }
    }
    
    private void rechercherMissions() {
        System.out.println("\n=== RECHERCHER DES MISSIONS ===");
        System.out.print("Entrez une destination : ");
        String destination = scanner.nextLine();
        
        List<Mission> missions = systeme.rechercherMissions(destination);
        
        if (missions.isEmpty()) {
            System.out.println("Aucune mission trouvée pour cette destination.");
        } else {
            System.out.println("Missions trouvées :");
            for (Mission mission : missions) {
                System.out.println("Code : " + mission.getCode() + 
                                   " - Description : " + mission.getDescription() +
                                   " - Places disponibles : " + mission.getNombrePlacesDisponibles());
            }
        }
    }
    
    private void associerMissionVaisseau() {
        System.out.println("\n=== ASSOCIER UNE MISSION À UN VAISSEAU ===");
        System.out.print("Code de la mission : ");
        String codeMission = scanner.nextLine();
        System.out.print("Immatriculation du vaisseau : ");
        String immatriculationVaisseau = scanner.nextLine();
        
        Mission mission = systeme.rechercherMission(codeMission);
        Vaisseau vaisseau = systeme.rechercherVaisseau(immatriculationVaisseau);
        
        if (mission != null && vaisseau != null) {
            mission.setVaisseau(vaisseau);
            System.out.println("Mission associée au vaisseau avec succès !");
        } else {
            System.out.println("Mission ou vaisseau non trouvé.");
        }
    }
    
    private void creerReservation() {
        System.out.println("\n=== CRÉER UNE RÉSERVATION ===");
        System.out.print("Identifiant de la personne : ");
        String idPersonne = scanner.nextLine();
        System.out.print("Code de la mission : ");
        String codeMission = scanner.nextLine();
        System.out.print("Nombre de passagers : ");
        int nombrePassagers = scanner.nextInt();
        scanner.nextLine(); // Consommer le retour à la ligne
        
        Reservation reservation = systeme.effectuerReservation(idPersonne, codeMission, nombrePassagers);
        
        if (reservation != null) {
            System.out.println("Réservation créée avec succès !");
            System.out.println("ID Réservation : " + reservation.getIdReservation());
        } else {
            System.out.println("Impossible de créer la réservation.");
        }
    }
    
    private void confirmerReservation() {
        System.out.println("\n=== CONFIRMER UNE RÉSERVATION ===");
        System.out.print("ID de la réservation : ");
        String idReservation = scanner.nextLine();
        
        if (systeme.confirmerReservation(idReservation)) {
            System.out.println("Réservation confirmée avec succès !");
        } else {
            System.out.println("Impossible de confirmer la réservation.");
        }
    }
    
    private void annulerReservation() {
        System.out.println("\n=== ANNULER UNE RÉSERVATION ===");
        System.out.print("ID de la réservation : ");
        String idReservation = scanner.nextLine();
        
        if (systeme.annulerReservation(idReservation)) {
            System.out.println("Réservation annulée avec succès !");
        } else {
            System.out.println("Impossible d'annuler la réservation.");
        }
    }
    
    private void afficherReservationsPersonne() {
        System.out.println("\n=== RÉSERVATIONS D'UNE PERSONNE ===");
        System.out.print("Identifiant de la personne : ");
        String idPersonne = scanner.nextLine();
        
        Personne personne = systeme.rechercherPersonne(idPersonne);
        
        if (personne != null) {
            List<Reservation> reservations = systeme.getReservations();
            boolean reservationTrouvee = false;
            
            for (Reservation reservation : reservations) {
                if (reservation.getPassager().getIdentifiant().equals(idPersonne)) {
                    System.out.println(reservation);
                    reservationTrouvee = true;
                }
            }
            
            if (!reservationTrouvee) {
                System.out.println("Aucune réservation trouvée pour cette personne.");
            }
        } else {
            System.out.println("Personne non trouvée.");
        }
    }
    
    private void afficherReservationsMission() {
        System.out.println("\n=== RÉSERVATIONS POUR UNE MISSION ===");
        System.out.print("Code de la mission : ");
        String codeMission = scanner.nextLine();
        
        Mission mission = systeme.rechercherMission(codeMission);
        
        if (mission != null) {
            List<Reservation> reservations = mission.getReservations();
            
            if (reservations.isEmpty()) {
                System.out.println("Aucune réservation pour cette mission.");
            } else {
                System.out.println("Réservations pour la mission " + codeMission + " :");
                for (Reservation reservation : reservations) {
                    System.out.println(reservation);
                }
            }
        } else {
            System.out.println("Mission non trouvée.");
        }
    }
}