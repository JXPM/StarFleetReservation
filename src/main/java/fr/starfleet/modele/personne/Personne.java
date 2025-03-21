package fr.starfleet.modele.personne;

public abstract class Personne {
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
    
    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", identifiant='" + identifiant + '\'' +
                '}';
        }
    }