package View;

import javax.swing.*;

public class Partita extends JPanel {

    private static Partita partita;

    private Partita() {}

    public static Partita getPartita() {
        if(partita == null) partita = new Partita();
        return partita;
    }

    public void inizializza() {
        setOpaque(false);
    }

}