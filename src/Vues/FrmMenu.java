package Vues;

import com.toedter.calendar.JCalendar;
import Controllers.*;
import Entities.*;
import Tools.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.sql.SQLException;


public class FrmMenu extends JFrame{
    private JPanel rootPane;
    private JButton btnExporter;
    private JCheckBox boxApi1;
    private JCheckBox boxApi2;
    private JCheckBox boxApi3;
    private JCheckBox boxApi4;
    private JCheckBox boxApi5;
    private JSpinner spnDuree;
    private JPanel pnlCalendar;
    private JPanel pnlTopics;
    private JCheckBox matchsDeNBACheckBox;

    JCalendar jcal = new JCalendar();

    public FrmMenu() throws SQLException, ClassNotFoundException {
        this.setTitle("Gestionnaire de Calendriers");
        this.setContentPane(rootPane);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        setSize(500,300);
        ExportJson exportJson = new ExportJson();


        //Calendrier
        pnlCalendar.add((jcal));


        btnExporter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (exportJson.GetAllJourFeries() != null) {
                    JOptionPane.showMessageDialog(rootPane, "Exportation réussie !");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Erreur lors de l'exportation.");
                }
            }
        });
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new FrmMenu().setVisible(true);
    }
}
