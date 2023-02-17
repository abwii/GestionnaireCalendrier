package Vues;

import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.sql.SQLException;
import org.python.util.PythonInterpreter;


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

    JCalendar jcal = new JCalendar();

    public FrmMenu() throws SQLException, ClassNotFoundException {
        this.setTitle("Gestionnaire de Calendriers");
        this.setContentPane(rootPane);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        setSize(500,300);


        //Calendrier
        pnlCalendar.add((jcal));

        btnExporter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Tout le code rigolo : récup infos checkbox, écriture dans .json, requête Google API

                JOptionPane.showMessageDialog(null,"tu as cliqué sur le bouton bravo !");

                //Récup des infos, création du .json

                //Requête Google Calendar API en Python

                PythonInterpreter pythonInterpreter = new PythonInterpreter();
                pythonInterpreter.execfile("src/py/googleAPI.py");

                //Fini

                JOptionPane.showMessageDialog(null,"owo");

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

    public JCheckBox getBoxApi1() {
        return boxApi1;
    }

    public JCheckBox getBoxApi2() {
        return boxApi2;
    }

    public JCheckBox getBoxApi3() {
        return boxApi3;
    }

    public JCheckBox getBoxApi4() {
        return boxApi4;
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
