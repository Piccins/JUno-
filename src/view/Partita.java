package view;

import javax.swing.*;
import java.awt.*;

public class Partita extends JPanel {

    private JPanel pannelloSouth;
    private JPanel pannelloNorth;
    private JPanel pannelloWest;
    private JScrollPane pannelloEast;
    private JPanel pannelloCenter;

    private static Partita partita;

    private Partita() {}

    public static Partita getPartita() {
        if(partita == null) partita = new Partita();
        return partita;
    }

    public void inizializza() {
        setLayout(new BorderLayout());
        setOpaque(false);
        add(pannelloCenter, BorderLayout.CENTER);
        add(pannelloSouth, BorderLayout.SOUTH);
        add(pannelloNorth, BorderLayout.NORTH);
        add(pannelloWest, BorderLayout.WEST);
        add(pannelloEast, BorderLayout.EAST);
    }

    public void setPannelloSouth(JPanel pannelloSouth) {
        this.pannelloSouth = pannelloSouth;
    }

    public void setPannelloNorth(JPanel pannelloNorth) {
        this.pannelloNorth = pannelloNorth;
    }

    public void setPannelloWest(JPanel pannelloWest) {
        this.pannelloWest = pannelloWest;
    }

    public void setPannelloEast(JScrollPane pannelloEast) {
        this.pannelloEast = pannelloEast;
    }

    public void setPannelloCenter(JPanel pannelloCenter) {
        this.pannelloCenter = pannelloCenter;
    }

}