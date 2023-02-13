package Tools;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.TimeZone;


public class ConnexionBDD
{
    public void runQuery() throws Exception {
        //Initializing the JSON parser
        JSONParser jsonParser = new JSONParser();
        Connection con = null;
        try {

            con = getCnx();
            PreparedStatement pstmt = null;
            try {
                JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("C://Users//Nathan//OneDrive//Dev//Documents//PPE//PPE 3//GestionnaireCalendrier-Json//src//Tools//Json//dataVacance.json")); //le chemin du fichier JSON
                JSONArray jsonArray = (JSONArray) jsonObject.get("dataVacance");
                pstmt = con.prepareStatement("INSERT INTO vacance values (?, ?, ?, ?, ?, ? )");
                for (Object object : jsonArray) {
                    JSONObject record = (JSONObject) object;
                    int id = Integer.parseInt((String) record.get("ID"));
                    String description = (String) record.get("description");
                    String start_date = (String) record.get("start_date");
                    String end_date = (String) record.get("end-date");
                    String location = (String) record.get("location");
                    String zones = (String) record.get("zones");
                    pstmt.setInt(1, id);
                    pstmt.setString(2, description);
                    pstmt.setDate(3, java.sql.Date.valueOf(start_date));
                    pstmt.setDate(4, java.sql.Date.valueOf(end_date));
                    pstmt.setString(5, location);
                    pstmt.setString(6, zones);
                    pstmt.executeUpdate();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        System.out.println("Records inserted.....");
    }
    private static Connection cnx;

    public ConnexionBDD() throws ClassNotFoundException, SQLException {
        //String pilote = "com.mysql.jdbc.Driver";
        String pilote = "com.mysql.jdbc.Driver";
        // chargement du pilote
        Class.forName(pilote);
        // L'objet connexion à la BDD avec le nom de la base, le user et le password
        cnx = DriverManager.getConnection("jdbc:mysql://localhost/calendrier?useSSL=true&serverTimezone="
                + TimeZone.getDefault().getID(), "root", "");
    }
    public static Connection getCnx() {
        return cnx;
    }
}