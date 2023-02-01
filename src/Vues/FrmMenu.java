package Vues;

import com.toedter.calendar.JCalendar;

import javax.swing.*;
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


        //Calendrier
        pnlCalendar.add((jcal));

    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new FrmMenu().setVisible(true);
    }

}
