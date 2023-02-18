package Controllers;
import Entities.ZoneA;
import Tools.ConnexionBDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlZoneA {
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlZoneA(){
        cnx = ConnexionBDD.getCnx();
    }
    public ArrayList<ZoneA> GetAllJourZoneA() {
        ArrayList<ZoneA> laZoneA = new ArrayList<>();
        try {
            ps = cnx.prepareStatement("SELECT `Description`, `Date de début`, `Date de fin`, `Zones` FROM `vacance` WHERE Zones = 'Zone A'");
            rs = ps.executeQuery();
            while (rs.next()) {
                ZoneA zoneA = new ZoneA(rs.getNString("description"), rs.getTimestamp("Date de début"), rs.getTimestamp("Date de fin"), rs.getNString("Zones"));
                laZoneA.add(zoneA);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlZoneA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return laZoneA;
    }
}
