package Entities;

public class Vacances {
    private int idDate;
    private String DateDebut;
    private String Nom;
    private int Zone;
    private String DateFin;

    public Vacances (int idDate, String DateDebut, String Nom, int Zone, String DateFin){
        this.idDate = idDate;
        this.DateDebut = DateDebut;
        this.Nom = Nom;
        this.Zone = Zone;
        this.DateFin = DateFin;
    }
    public int getIdDate(){return idDate;}
    public String getDateDebut(){return DateDebut;}
    public String getNom(){return DateFin;}
    public int getZone(){return Zone;}
    public String getDateFin(){return DateFin;}


}
