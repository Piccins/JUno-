package view.centro;

import model.mazzo.ColoreInGioco;
import utilita.Observer;

import javax.swing.*;
import java.awt.*;

/**
 * Questa classe descrive il pannello
 * per la visualizzazione del colore
 * corrente durante la partita.
 * Per colore corrente si intende il colore
 * della carta in cima alla pila degli scarti.
 * Nel caso il cui la carta in cima alla pila
 * degli scarti sia una carta jolly, il colore
 * viene impostato manualmente mediante la
 * scelta dell'utente oppure dell'AI.
 */
public class Colore extends JPanel implements Observer {

    // La label rappresentante il colore.
    private JLabel label;

    // L'istanza della classe colore.
    private static Colore colore;

    private Colore() {}

    /**
     * Restituisce l'unica istanza di
     * questa classe.
     * @return Un oggetto della classe Colore.
     */
    public static Colore getColore() {
        if(colore == null) colore = new Colore();
        return colore;
    }

    /**
     * Inizializza questa istanza impostando
     * alcuni valori di default.
     */
    public void inizializza() {
        setOpaque(false);
        setLayout(new BorderLayout());
        label = new JLabel();
        label.setOpaque(false);
        add(label, BorderLayout.CENTER);
    }


    @Override
    public void update(Object o) {
        if(o instanceof ColoreInGioco coloreInGioco) {
            int parametro = 3;
            model.carta.Colore coloreAttuale = coloreInGioco.getColore();
            ImageIcon icona = new ImageIcon("resources/" + coloreAttuale + ".png");
            int larghezza = icona.getIconWidth()  / parametro;
            int lunghezza = icona.getIconHeight() / parametro;
            icona.setImage(icona.getImage()
                    .getScaledInstance(larghezza, lunghezza, Image.SCALE_SMOOTH));
            label.setIcon(icona);
            label.setPreferredSize(new Dimension(larghezza, lunghezza));
            revalidate();
            repaint();
        } else throw new IllegalArgumentException("Tipo dell'oggetto passato" +
                "in input errato. ColoreInGioco atteso.");
    }

}