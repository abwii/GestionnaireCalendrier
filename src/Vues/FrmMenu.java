package Vues;

import com.toedter.calendar.JCalendar;
import Entities.*;
import Controllers.*;
import Tools.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.python.util.PythonInterpreter;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;


public class FrmMenu extends JFrame {
    private JPanel rootPane;
    private JButton btnExporter;
    private JCheckBox boxZoneA;
    private JCheckBox boxZoneB;
    private JCheckBox boxZoneC;
    private JCheckBox boxJourFerie;
    private JCheckBox boxApi5;
    private JSpinner spnDuree;
    private JPanel pnlCalendar;
    private JPanel pnlTopics;

    JCalendar jcal = new JCalendar();

    public FrmMenu() throws SQLException, ClassNotFoundException {
        this.setTitle("Gestionnaire de Calendriers");
        this.setContentPane(rootPane);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        setSize(500, 300);


        //Calendrier
        pnlCalendar.add((jcal));

        btnExporter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Tout le code rigolo : récup infos checkbox, écriture dans .json, requête Google API

                JOptionPane.showMessageDialog(null, "tu as cliqué sur le bouton bravo !");

                //Récup des infos, création du .json

                //Requête Google Calendar API en Python

                //Fini

                JOptionPane.showMessageDialog(null, "owo");

            }
        });

        boxZoneA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (boxZoneA.isSelected()) {
                    CtrlZoneA ctrlZoneA = null;
                    try {
                        ctrlZoneA = new CtrlZoneA(DriverManager.getConnection("jdbc:mysql://localhost/calendrier", "root", ""));
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    JSONArray zoneAListe = (JSONArray) ctrlZoneA.GetAllJourZoneA();
                    JOptionPane.showMessageDialog(null, zoneAListe.toJSONString());
                }
            }
        });
        boxZoneB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (boxZoneB.isSelected()) {
                    CtrlZoneB ctrlZoneB = null;
                    try {
                        ctrlZoneB = new CtrlZoneB(DriverManager.getConnection("jdbc:mysql://localhost/calendrier", "root", ""));
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    JSONArray zoneBListe = (JSONArray) ctrlZoneB.GetAllJourZoneB();
                    JOptionPane.showMessageDialog(null, zoneBListe.toJSONString());
                }
            }
        });
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new FrmMenu().setVisible(true);
    }

    //Getters

    public JButton getBtnExporter() {
        return btnExporter;
    }

    public JCheckBox getBoxApi1(Icon icon, boolean s) {
        return boxZoneA;
    }

    public JCheckBox getBoxApi2() {
        return boxZoneB;
    }

    public JCheckBox getBoxApi3() {
        return boxZoneC;
    }

    public JCheckBox getBoxApi4() {
        return boxJourFerie;
    }

    public JCheckBox getBoxApi5() {
        return boxApi5;
    }

    public JSpinner getSpnDuree() {
        return spnDuree;
    }

    //Setter

    public void setJcal(JCalendar jcal) {
        this.jcal = jcal;
    }
}


