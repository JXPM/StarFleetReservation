package fr.starfleet.modele.vaisseau;

import fr.starfleet.modele.mission.Mission;
import java.util.ArrayList;
import java.util.List;

public class Vaisseau {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 1L;
    private String nom;
    private String immatriculation;
    private int capaciteMaximale;
    private List<Mission> missions;
    
    // Constructeur, getters, setters
    public Vaisseau(String nom, String immatriculation, int capaciteMaximale) {
        this.nom = nom;
        this.immatriculation = immatriculation;
        this.capaciteMaximale = capaciteMaximale;
        this.missions = new ArrayList<>();
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }
    
    public String getImmatriculation() {
        return immatriculation;
    }
    
    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }
    
    public int getCapaciteMaximale() {
        return capaciteMaximale;
    }
    
    public void setCapaciteMaximale(int capaciteMaximale) {
        this.capaciteMaximale = capaciteMaximale;
    }
    
    public List<Mission> getMissions() {
        return missions;
    }
    
    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }
    
    // Méthodes pour gérer les missions
    public boolean ajouterMission(Mission mission) {
        if (missions.size() < capaciteMaximale) {
            missions.add(mission);
            return true;
        }
        return false;
    }
    
    public boolean supprimerMission(Mission mission) {
        return missions.remove(mission);
    }
    
    public int getNombreMissions() {
        return missions.size();
    }
    
    public void afficherMissions() {
    System.out.println("Missions du vaisseau " + nom + " (" + immatriculation + "):");
    for (Mission mission : missions) {
        System.out.println("- " + mission.getNom());
        }
    }

}