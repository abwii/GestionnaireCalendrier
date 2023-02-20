package Vues;

import Entities.JoursFeries;
import com.toedter.calendar.JCalendar;
import Controllers.*;
import org.json.simple.JSONArray;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

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

    private JCalendar jcal = new JCalendar();

    public FrmMenu() throws SQLException, ClassNotFoundException {
        setTitle("Gestionnaire de Calendriers");
        setContentPane(rootPane);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 300);

        pnlCalendar.add(jcal);

        btnExporter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "tu as cliqué sur le bouton bravo !");

                // Récupération des informations et création du fichier .json

                // Requête Google Calendar API en Python

                JOptionPane.showMessageDialog(null, "owo");

            }
        });

        boxZoneA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (boxZoneA.isSelected()) {
                    try {
                        CtrlZoneA ctrlZoneA = new CtrlZoneA(DriverManager.getConnection("jdbc:mysql://localhost/calendrier", "root", ""));
                        JSONArray zoneAListe = (JSONArray) ctrlZoneA.GetAllJourZoneA();
                        try (FileWriter file = new FileWriter("resultatA.json")) {
                            file.write(zoneAListe.toJSONString());
                            file.flush();
                            JOptionPane.showMessageDialog(null, "Résultat ecrit dans le fichier JSON");
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        boxZoneB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (boxZoneB.isSelected()) {
                    try {
                        CtrlZoneB ctrlZoneB = new CtrlZoneB(DriverManager.getConnection("jdbc:mysql://localhost/calendrier", "root", ""));
                        JSONArray zoneBListe = (JSONArray) ctrlZoneB.GetAllJourZoneB();
                        try (FileWriter file = new FileWriter("resultatB.json")) {
                            file.write(zoneBListe.toJSONString());
                            file.flush();
                            JOptionPane.showMessageDialog(null, "Résultat ecrit dans le fichier JSON");
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        boxZoneC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (boxZoneC.isSelected()) {
                    try {
                        CtrlZoneC ctrlZoneC = new CtrlZoneC(DriverManager.getConnection("jdbc:mysql://localhost/calendrier", "root", ""));
                        JSONArray zoneCListe = (JSONArray) ctrlZoneC.GetAllJourZoneC();
                        try (FileWriter file = new FileWriter("resultatC.json")) {
                            file.write(zoneCListe.toJSONString());
                            file.flush();
                            JOptionPane.showMessageDialog(null, "Résultat ecrit dans le fichier JSON");
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        boxJourFerie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {try {
                ExportJson joursFeries = new ExportJson(DriverManager.getConnection("jdbc:mysql://localhost/calendrier", "root", ""));
                JSONArray jourFerie = (JSONArray) joursFeries.GetAllJourFerie();
                try (FileWriter file = new FileWriter("resultatFeries.json")) {
                    file.write(jourFerie.toJSONString());
                    file.flush();
                    JOptionPane.showMessageDialog(null, "Résultat ecrit dans le fichier JSON");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            }
        });
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new FrmMenu().setVisible(true);
    }

    // Getters

    public JButton getBtnExporter() {
        return btnExporter;
    }

    public JCheckBox getBoxApi1(Icon icon, boolean s) {
        return boxZoneA;
    }
}
