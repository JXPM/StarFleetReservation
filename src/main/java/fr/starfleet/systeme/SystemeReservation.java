package fr.starfleet.systeme;

import fr.starfleet.modele.mission.*;
import fr.starfleet.modele.personne.*;
import fr.starfleet.modele.reservation.*;
import fr.starfleet.modele.vaisseau.*;
import java.io.*;
import java.util.*;

public class SystemeReservation {
    private List<Vaisseau> vaisseaux;
    private List<Personne> personnes;
    private List<Mission> missions;
    private List<Reservation> reservations;
    
    // Constructeur, getters, setters
    public SystemeReservation() {
        vaisseaux = new ArrayList<>();
        personnes = new ArrayList<>();
        missions = new ArrayList<>();
        reservations = new ArrayList<>();
    }
    
    public List<Vaisseau> getVaisseaux() {
        return vaisseaux;
    }
    
    public List<Personne> getPersonnes() {
        return personnes;
    }
    
    public List<Mission> getMissions() {
        return missions;
    }
    
    public List<Reservation> getReservations() {
        return reservations;
    }
    
    public void setVaisseaux(List<Vaisseau> vaisseaux) {
        this.vaisseaux = vaisseaux;
    }
    
    public void setPersonnes(List<Personne> personnes) {
        this.personnes = personnes;
    }
    
    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }
    
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    
    // Méthodes de gestion des vaisseaux
    public void ajouterVaisseau(Vaisseau vaisseau) {
        if (vaisseau != null && !vaisseaux.contains(vaisseau)) {
            vaisseaux.add(vaisseau);
        }
    }
    
    public boolean supprimerVaisseau(String immatriculation) {
        for (int i = 0; i < vaisseaux.size(); i++) {
            if (vaisseaux.get(i).getImmatriculation().equals(immatriculation)) {
                vaisseaux.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public Vaisseau rechercherVaisseau(String immatriculation) {
        for (Vaisseau vaisseau : vaisseaux) {
            if (vaisseau.getImmatriculation().equals(immatriculation)) {
                return vaisseau;
            }
        }
        return null;
    }
    
    // Méthodes de gestion des personnes
    public boolean ajouterPersonne(Personne personne) {
        if (personne != null && !personnes.contains(personne)) {
            personnes.add(personne);
        }
                return false;
    }
    
    public boolean supprimerPersonne(String id) {
        for (int i = 0; i < personnes.size(); i++) {
            if (personnes.get(i).getNom().equals(id)) {
                personnes.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public Personne rechercherPersonne(String id) {
        for (Personne personne : personnes) {
            if (personne.getNom().equals(id)) {
                return personne;
            }
        }
        return null;
    }
    
    // Méthodes de gestion des missions
    public void creerMission(String code, String description, Date dateDepart,
                             Date dateRetour, String destination,
                             String immatriculationVaisseau, int capaciteMaximale) {
        
        Vaisseau vaisseau = rechercherVaisseau(immatriculationVaisseau);
        if (vaisseau != null) {
            Mission mission = new Mission(code, description, dateDepart, dateRetour,
                                         destination, vaisseau, capaciteMaximale);
            missions.add(mission);
            // Initialiser la relation bidirectionnelle
            mission.initialiserRelationVaisseau();
        }
    }
    
    public boolean annulerMission(String code) {
        for (int i = 0; i < missions.size(); i++) {
            if (missions.get(i).getCode().equals(code)) {
                // Annuler toutes les réservations associées
                List<Reservation> aAnnuler = new ArrayList<>();
                for (Reservation r : reservations) {
                    if (r.getMission() != null && r.getMission().getCode().equals(code)) {
                        aAnnuler.add(r);
                    }
                }
                
                for (Reservation r : aAnnuler) {
                    annulerReservation(r.getIdReservation());
                }
                
                // Retirer la mission du vaisseau
                Mission mission = missions.get(i);
                if (mission.getVaisseau() != null) {
                    mission.getVaisseau().supprimerMission(mission);
                }
                
                missions.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public List<Mission> rechercherMissions(String destination) {
        List<Mission> resultats = new ArrayList<>();
        for (Mission mission : missions) {
            if (mission.getDestination().toLowerCase().contains(destination.toLowerCase())) {
                resultats.add(mission);
            }
        }
        return resultats;
    }
    
    public Mission rechercherMission(String code) {
        for (Mission mission : missions) {
            if (mission.getCode().equals(code)) {
                return mission;
            }
        }
        return null;
    }
    
    // Méthodes de gestion des réservations
    public Reservation effectuerReservation(String idPersonne, String codeMission, int nombrePassagers) {
        Personne personne = rechercherPersonne(idPersonne);
        Mission mission = rechercherMission(codeMission);
        
        if (personne != null && mission != null) {
            // Vérifier la disponibilité
            if (mission.getNombrePlacesDisponibles() >= nombrePassagers) {
                // Générer un ID de réservation unique (ici simplement basé sur la taille actuelle)
                String idReservation = "R" + (reservations.size() + 1);
                
                Reservation reservation = new Reservation(idReservation, personne, mission,
                                                        new Date(), nombrePassagers);
                reservations.add(reservation);
                
                // Initialiser la relation bidirectionnelle
                reservation.initialiserRelationMission();
                
                return reservation;
            }
        }
        return null;
    }
    
    public boolean annulerReservation(String idReservation) {
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getIdReservation().equals(idReservation)) {
                Reservation reservation = reservations.get(i);
                reservation.annuler();
                reservations.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public boolean confirmerReservation(String idReservation) {
        for (Reservation reservation : reservations) {
            if (reservation.getIdReservation().equals(idReservation)) {
                reservation.confirmer();
                return true;
            }
        }
        return false;
    }
    
    // Méthodes de persistance
    public void sauvegarderDonnees(String fichier) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier))) {
            oos.writeObject(vaisseaux);
            oos.writeObject(personnes);
            oos.writeObject(missions);
            oos.writeObject(reservations);
            System.out.println("Données sauvegardées avec succès dans " + fichier);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde des données: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    public static SystemeReservation chargerDonnees(String fichier) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))) {
            SystemeReservation systeme = new SystemeReservation();
            systeme.setVaisseaux((List<Vaisseau>) ois.readObject());
            systeme.setPersonnes((List<Personne>) ois.readObject());
            systeme.setMissions((List<Mission>) ois.readObject());
            systeme.setReservations((List<Reservation>) ois.readObject());
            System.out.println("Données chargées avec succès depuis " + fichier);
            return systeme;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erreur lors du chargement des données: " + e.getMessage());
            return null;
        }
    }
    
    // Statistiques et rapports
    public void afficherStatistiques() {
        System.out.println("=== STATISTIQUES DU SYSTÈME ===");
        System.out.println("Nombre de vaisseaux: " + vaisseaux.size());
        System.out.println("Nombre de personnes: " + personnes.size());
        System.out.println("Nombre de missions: " + missions.size());
        System.out.println("Nombre de réservations: " + reservations.size());
        
        // Missions les plus populaires
        Map<String, Integer> missionPopularite = new HashMap<>();
        for (Reservation r : reservations) {
            if (r.getMission() != null) {
                String codeMission = r.getMission().getCode();
                missionPopularite.put(codeMission,
                    missionPopularite.getOrDefault(codeMission, 0) + r.getNombrePassagers());
            }
        }
        
        System.out.println("\nTop 3 des missions les plus populaires:");
        missionPopularite.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .limit(3)
            .forEach(entry -> {
                String codeMission = entry.getKey();
                Mission mission = rechercherMission(codeMission);
                if (mission != null) {
                    System.out.println("- " + mission.getCode() + " " + mission.getDestination() + 
                                     ": " + entry.getValue() + " passagers");
                }
            });
    }
}