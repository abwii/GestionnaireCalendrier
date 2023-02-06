package Controllers;

import Entities.Vacances;
import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CtrlVacances {

    private Connection cnx;
    //Un objet qui va nous permettre d'écrire nos requetes SQL
    private PreparedStatement ps;
    //Un objet pour récupe les données de la requete;
    private ResultSet rs;

    public CtrlVacances() {
        cnx = ConnexionBDD.getCnx();
    }

    public static void changerCouleur() {
        try {
            ps = cnx.prepareStatement("SELECT dateDebut, dateFin FROM vacances");
            rs = ps.executeQuery();
            rs.next();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Vacances> getAllVacances() {
        ArrayList<Vacances> lesVacances = new ArrayList<>();
        try {
            ps = cnx.prepareStatement("SELECT * FROM vacanes");
            rs = ps.executeQuery();
            while (rs.next()){
                Vacances lesVac = new Vacances(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
                lesVacances.add(lesVac);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lesVacances;

    }

}
