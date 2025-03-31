// CLASSE DERIVÉ DE • Officier (avec rang et spécialité)
package fr.starfleet.modele.personne;


public class Officier extends Personne {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 1L;
    private int rang;
    private String specialite;

    public Officier(String nom, String prenom, String identifiant, int rang, String specialite) {
        super(nom, prenom, identifiant);
        this.rang = rang;
        this.specialite = specialite;
    }

// GETTERS ET SETTERS
    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    @Override
    public String getDescription() {
        return "Officier de rang " + rang + " et de specialite " + specialite;
    }
}
