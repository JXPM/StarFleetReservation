package fr.starfleet.modele.personne;

import java.util.Objects;

public abstract class Personne {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 1L;
    private String nom;
    private String prenom;
    private String identifiant;
    
    // Constructeur, getters, setters
    public Personne(String nom, String prenom, String identifiant) {
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public String getIdentifiant() {
        return identifiant;
    }
    
    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }
    
    // Méthode abstraite
    public abstract String getDescription();
    
    // Equals et hashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Personne personne = (Personne) obj;
        return this.identifiant.equals(personne.identifiant);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(identifiant);
    }
    
    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", identifiant='" + identifiant + '\'' +
                '}';
        }
    }