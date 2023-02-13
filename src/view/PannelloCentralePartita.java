package view;

import view.giocatori.PannelloCarteUmano;

import javax.swing.*;
import java.awt.*;

public class PannelloCentralePartita extends JPanel {

    private static PannelloCentralePartita pannelloCentralePartita;

    private PannelloCentralePartita() {}

    public static PannelloCentralePartita getPannelloCentralePartita() {
        if(pannelloCentralePartita == null) pannelloCentralePartita = new PannelloCentralePartita();
        return pannelloCentralePartita;
    }

    public void inizializza() {
        setOpaque(false);
        setPreferredSize(new Dimension(500, 500));
    }

}