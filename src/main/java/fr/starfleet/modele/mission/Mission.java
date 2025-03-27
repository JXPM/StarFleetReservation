package fr.starfleet.modele.mission;

import fr.starfleet.modele.reservation.Reservation;
import fr.starfleet.modele.vaisseau.Vaisseau;
import java.util.*;

public class Mission {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 1L;
    private String code;
    private String description;
    private Date dateDepart;
    private Date dateRetour;
    private String destination;
    
    private Vaisseau vaisseau;
    private List<Reservation> reservations;
    private int capaciteMaximale;
    
    // Constructeur, getters, setters
    public Mission(String code, String description, Date dateDepart, Date dateRetour, String destination, Vaisseau vaisseau, int capaciteMaximale) {
        this.code = code;
        this.description = description;
        this.dateDepart = dateDepart;
        this.dateRetour = dateRetour;
        this.destination = destination;
        this.vaisseau = vaisseau;
        this.reservations = new ArrayList<>();
        this.capaciteMaximale = capaciteMaximale;
    }

    public void initiatiliserReservations() {
                // Ajouter cette mission au vaisseau
                if (vaisseau != null) {
                vaisseau.ajouterMission(this);
                }
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public String getDestination() {
        return destination;
    }

    public Vaisseau getVaisseau() {
        return vaisseau;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public int getCapaciteMaximale() {
        return capaciteMaximale;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setVaisseau(Vaisseau vaisseau) {
        // Retirer cette mission de l'ancien vaisseau si nécessaire
        if (this.vaisseau != null) {
            this.vaisseau.supprimerMission(this);
        }
        
        this.vaisseau = vaisseau;
        
        // Ajouter cette mission au nouveau vaisseau
        if (vaisseau != null) {
            vaisseau.ajouterMission(this);
        }
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void setCapaciteMaximale(int capaciteMaximale) {
        this.capaciteMaximale = capaciteMaximale;
    }
    
    // Méthodes de gestion des réservations
    public boolean ajouterReservation(Reservation reservation) {
        if (reservation == null) {
            return false;
        }
        
        // Vérifier s'il y a suffisamment de places disponibles
        if (getNombrePlacesDisponibles() >= reservation.getNombrePassagers()) {
            reservations.add(reservation);
            return true;
        }
        
        return false;
    }
    
    public boolean annulerReservation(Reservation reservation) {
        if (reservation == null) {
            return false;
        }
        
        return reservations.remove(reservation);
    }
    
    public boolean confirmerReservation(Reservation reservation) {
        if (reservation == null) {
            return false;
        }
        
        // Si la réservation existe dans la liste
        if (reservations.contains(reservation)) {
            reservation.setConfirmee(true);
            return true;
        }
        
        return false;
    }
    
    public int getNombrePlacesDisponibles() {
        int placesOccupees = 0;
        
        for (Reservation reservation : reservations) {
            placesOccupees += reservation.getNombrePassagers();
        }
        
        return capaciteMaximale - placesOccupees;
    }
    
    // Méthode pour obtenir le nom (utilisée dans Vaisseau.afficherMissions())
    public String getNom() {
        return code + " - " + destination;
    }

    public void initialiserRelationVaisseau() {
        throw new UnsupportedOperationException("Unimplemented method 'initialiserRelationVaisseau'");
    }
}