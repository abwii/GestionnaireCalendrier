package Entities;

import java.sql.Timestamp;

public class ZoneA {
    private String description;
    private Timestamp date_de_debut;
    private Timestamp date_de_fin;
    private String zone;

    public ZoneA(String description, Timestamp date_de_debut, Timestamp date_de_fin, String zone){
        this.description = description;
        this.date_de_debut = date_de_debut;
        this.date_de_fin = date_de_fin;
        this.zone = zone;
    }

    public String getDescription() {
        return description;
    }

    public Timestamp getDate_de_debut() {
        return date_de_debut;
    }

    public Timestamp getDate_de_fin() {
        return date_de_fin;
    }

    public String getZone() {
        return zone;
    }
}
