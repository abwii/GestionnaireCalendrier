package Entities;

import java.util.Date;

public class JoursFeries {
    private Date date;
    private int annee;
    private String zone;
    private String nom;

    public JoursFeries(Date date, int annee, String zone, String nom) {
        this.date = date;
        this.annee = annee;
        this.zone = zone;
        this.nom = nom;
    }


    public Date getDate() {
        return date;
    }

    public int getAnnee() {
        return annee;
    }

    public String getZone() {
        return zone;
    }

    public String getNom() {
        return nom;
    }
}
