package Vues;

import com.toedter.calendar.JDayChooser;

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
    private JDayChooser calendar;


    public FrmMenu() throws SQLException, ClassNotFoundException {
        this.setTitle("Gestionnaire de Calendriers");
        this.setContentPane(rootPane);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);



    }
}
