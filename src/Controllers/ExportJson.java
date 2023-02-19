package Controllers;
import Entities.JoursFeries;
import Tools.ConnexionBDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ExportJson {
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public ExportJson() {
        cnx = ConnexionBDD.getCnx();
    }
    public ArrayList<JoursFeries> GetAllJourFeries(){
        ArrayList<JoursFeries> lesJoursFeries = new ArrayList<>();

        try {
            ps = cnx.prepareStatement("SELECT `Description`,`Date de début`,`Date de fin`,`Zones` FROM `vacance`");
            rs = ps.executeQuery();

            JSONArray json = new JSONArray();
            ResultSetMetaData rsmd = rs.getMetaData();
            int numColumns = rsmd.getColumnCount();
            while (rs.next()) {
                JSONObject obj = new JSONObject();
                for (int i = 1; i <= numColumns; i++) {
                    String column_name = rsmd.getColumnName(i);
                    obj.put(column_name, rs.getObject(column_name));
                }
                json.add(obj);
            }
            System.out.println(json.toString());
            ps.close();
            rs.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return lesJoursFeries;
    }
}
