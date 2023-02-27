package view.centro;

import model.GestoreTurni;
import utilita.Observer;

import javax.swing.*;
import java.awt.*;

/**
 * Questa classe definisce il pannello contenente
 * l'immagine che descrive il verso dei turni durante
 * una partita al gioco di carte Uno in questa applicazione.
 */
public class Verso extends JPanel implements Observer {

    // L'immagine del giro non invertito.
    private ImageIcon giro;

    // L'immagine del giro invertito.
    private ImageIcon giroInvertito;

    private JLabel label;

    private static Verso verso;

    private Verso() {}

    public static Verso getVerso() {
        if(verso == null) verso = new Verso();
        return verso;
    }

    /**
     * Inizializza questa istanza con valori di default.
     */
    public void inizializza() {
        setOpaque(false);
        setLayout(new BorderLayout());

        // Impostazione icone
        giro = new ImageIcon("resources/GIRO.png");
        giroInvertito = new ImageIcon("resources/GIROINVERTITO.png");

        int larghezza = giro.getIconWidth() / 2;
        int lunghezza = giro.getIconWidth() / 2;
        giro.setImage(giro.getImage().getScaledInstance(larghezza, lunghezza, Image.SCALE_SMOOTH));
        giroInvertito.setImage(giroInvertito.getImage().getScaledInstance(larghezza, lunghezza, Image.SCALE_SMOOTH));

        // Impostazione label.
        this.label = new JLabel();
        label.setOpaque(false);
        label.setPreferredSize(new Dimension(133, 150));
        label.setIcon(giro);

        add(label, BorderLayout.CENTER);
    }

    @Override
    public void update(Object o) {
        if(o instanceof GestoreTurni gestoreTurni) {
            if(gestoreTurni.haInvertito()) {
                if (gestoreTurni.isInvertito())
                    label.setIcon(giroInvertito);
                else label.setIcon(giro);
                revalidate();
                repaint();
            }
        } else throw new IllegalArgumentException(
                "Tipo dell'oggetto non valido: " + o.getClass() +
                        ". Tipo atteso GestoreTurni.");
    }

}