package Controllers;
import Entities.ZoneB;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlZoneB {
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlZoneB(Connection cnx) {
        this.cnx = cnx;
    }

    public ArrayList<JSONObject> GetAllJourZoneB() {
        ArrayList<JSONObject> jsonList = new JSONArray();
        try {
            ps = cnx.prepareStatement("SELECT `summary`, `start`, `end`, `description` FROM `vacance` WHERE description = 'Zone B'");
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int numColumns = rsmd.getColumnCount();
            while (rs.next()) {
                ZoneB zoneB = new ZoneB(rs.getNString("summary"), rs.getTimestamp("start"), rs.getTimestamp("end"), rs.getNString("description"));
                JSONObject obj = new JSONObject();
                for (int i = 1; i <= numColumns; i++) {
                    String column_name = rsmd.getColumnName(i);
                    obj.put(column_name, rs.getObject(column_name));
                }
                jsonList.add(obj);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlZoneA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsonList;
    }

}
