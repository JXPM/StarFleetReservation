// classe derivée de Civil (avec planète d'origine et motif de voyage)
package fr.starfleet.modele.personne;

public class Civil extends Personne {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 1L; 
    private String planeteOrigine;
    private String motifVoyage;

    public Civil(String nom, String prenom, String identifiant, String planeteOrigine, String motifVoyage) {
        super(nom, prenom, identifiant);
        this.planeteOrigine = planeteOrigine;
        this.motifVoyage = motifVoyage;
    }

    public String getPlaneteOrigine() {
        return planeteOrigine;
    }

    public void setPlaneteOrigine(String planeteOrigine) {
        this.planeteOrigine = planeteOrigine;
    }

    public String getMotifVoyage() {
        return motifVoyage;
    }

    public void setMotifVoyage(String motifVoyage) {
        this.motifVoyage = motifVoyage;
    }

    @Override
    public String getDescription() {
        return "Civil de planète d'origine " + planeteOrigine + " et de motif de voyage " + motifVoyage;
    }
}