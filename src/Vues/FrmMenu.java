package Vues;

import Controllers.CtrlVacances;
import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;


public class FrmMenu extends JFrame{
    private JPanel rootPane;
    private JButton btnExporter;
    private JCheckBox boxJesus;
    private JCheckBox boxIslam;
    private JCheckBox boxVacances;
    private JCheckBox boxLigue1;
    private JCheckBox boxEsport;
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


        //Calendrier
        boxVacances.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                    CtrlVacances.changerCouleur();
                    boxVacances = new JCheckBox();
                    boxVacances.addPropertyChangeListener(setBackground(Color.blue));
            }
        });
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new FrmMenu().setVisible(true);
    }

}
