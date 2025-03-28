package fr.starfleet.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    // Format de date standard
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    
    /**
     * Convertit une chaîne en date
     * @param dateString La date au format dd/MM/yyyy
     * @return La date convertie, ou null si la conversion échoue
     */
    public static Date stringToDate(String dateString) {
        try {
            return DATE_FORMAT.parse(dateString);
        } catch (ParseException e) {
            System.err.println("Erreur de conversion de date : " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Convertit une date en chaîne
     * @param date La date à convertir
     * @return La date au format dd/MM/yyyy, ou une chaîne vide en cas d'erreur
     */
    public static String dateToString(Date date) {
        if (date == null) {
            return "";
        }
        return DATE_FORMAT.format(date);
    }
    
    /**
     * Calcule la différence en jours entre deux dates
     * @param dateDebut Date de début
     * @param dateFin Date de fin
     * @return Nombre de jours entre les deux dates
     */
    public static long differenceEnJours(Date dateDebut, Date dateFin) {
        if (dateDebut == null || dateFin == null) {
            return 0;
        }
        long diff = dateFin.getTime() - dateDebut.getTime();
        return diff / (24 * 60 * 60 * 1000);
    }
}