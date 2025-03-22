package fr.starfleet.modele.reservation;

import fr.starfleet.modele.mission.Mission;
import fr.starfleet.modele.personne.Personne;
import java.util.Date;

public class Reservation {
    private String idReservation;
    private Personne passager;
    private Mission mission;
    private Date dateReservation;
    private boolean confirmee;
    private int nombrePassagers;
    
    // Constructeur, getters, setters
    public Reservation(String idReservation, Personne passager, Mission mission, Date dateReservation, int nombrePassagers) {
        this.idReservation = idReservation;
        this.passager = passager;
        this.mission = mission;
        this.dateReservation = dateReservation;
        this.confirmee = false;
        this.nombrePassagers = nombrePassagers;
        
    }
    public void initialiserRelationMission() {
        if (this.mission != null) {
            this.mission.ajouterReservation(this);
        }
    }
    
    public String getIdReservation() {
        return idReservation;
    }
    
    public Personne getPassager() {
        return passager;
    }
    
    public Mission getMission() {
        return mission;
    }
    
    public Date getDateReservation() {
        return dateReservation;
    }
    
    public boolean isConfirmee() {
        return confirmee;
    }
    
    public int getNombrePassagers() {
        return nombrePassagers;
    }
    
    public void setNombrePassagers(int nombrePassagers) {
        this.nombrePassagers = nombrePassagers;
    }
    
    public void setConfirmee(boolean confirmee) {
        this.confirmee = confirmee;
    }
    
    public void setIdReservation(String idReservation) {
        this.idReservation = idReservation;
    }
    
    public void setPassager(Personne passager) {
        this.passager = passager;
    }
    
    public void setMission(Mission mission) {
        // Retirer la réservation de l'ancienne mission si nécessaire
        if (this.mission != null) {
            this.mission.annulerReservation(this);
        }
        
        this.mission = mission;
        
        // Ajouter la réservation à la nouvelle mission
        if (mission != null) {
            mission.ajouterReservation(this);
        }
    }
    
    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }
    
    // Méthodes
    public void confirmer() {
        this.confirmee = true;
        
        // Informer également la mission que cette réservation est confirmée
        if (mission != null) {
            mission.confirmerReservation(this);
        }
    }
    
    public void annuler() {
        // Annuler la réservation au niveau de la mission
        if (mission != null) {
            mission.annulerReservation(this);
        }
        
        // Réinitialiser les valeurs
        this.confirmee = false;
        this.mission = null;
    }
    
    @Override
    public String toString() {
        String statut = confirmee ? "Confirmée" : "En attente";
        return "Réservation " + idReservation + " - Mission: " + mission.getCode() +
               " - Passager: " + passager.getNom() + " - Statut: " + statut +
               " - Nombre de passagers: " + nombrePassagers;
    }
}