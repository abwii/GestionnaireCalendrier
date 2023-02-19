package Entities;

import java.sql.Timestamp;

public class ZoneB {
    private String Description;
    private Timestamp date_de_debut;
    private Timestamp date_de_fin;
    private String Zones;

    public ZoneB(String description, Timestamp date_de_debut, Timestamp date_de_fin, String zone){
        this.Description = description;
        this.date_de_debut = date_de_debut;
        this.date_de_fin = date_de_fin;
        this.Zones = zone;
    }

    public String getDescription() {
        return Description;
    }

    public Timestamp getDateDeDebut() {
        return date_de_debut;
    }

    public Timestamp getDateDeFin() {
        return date_de_fin;
    }

    public String getZones() {
        return Zones;
    }
}
