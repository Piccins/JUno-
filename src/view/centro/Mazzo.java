package view.centro;

import controller.PescaAzione;
import model.giocatori.Umano;
import model.mazzo.MazzoUno;
import utilita.Observer;

import javax.swing.*;
import java.awt.*;

/**
 * Questa classe definisce il pannello
 * nella quale viene mostrato il bottone
 * che permette al giocatore umano (l'utente)
 * di pescare una carta.
 */
public class Mazzo extends JPanel implements Observer {

    // L'istanza della classe mazzo.
    private static Mazzo mazzo;

    // Costruisce l'istanza della classe Mazzo.
    private Mazzo() {};

    /**
     * Restituisce l'istanza della classe Mazzo.
     * @return Un oggetto della classe Mazzo.
     */
    public static Mazzo getMazzo() {
        if(mazzo == null) mazzo = new Mazzo();
        return mazzo;
    }

    /**
     * Inizializza questa istanza della classe Mazzo
     * impostando alcuno valori di default.
     */
    public void inizializza() {
        // Impostazione pannello.
        setOpaque(false);
        setLayout(new BorderLayout());

        // Impostazione bottone.
        JButton bottone = new JButton();
        ImageIcon icona = new ImageIcon("resources/carte/RETRO.png");
        int larghezza = icona.getIconWidth()  / 7;
        int lunghezza = icona.getIconHeight() / 7;
        icona.setImage(icona.getImage()
                .getScaledInstance(larghezza, lunghezza, Image.SCALE_SMOOTH));
        bottone.setIcon(icona);
        bottone.setOpaque(false);
        bottone.setContentAreaFilled(false);
        bottone.setFocusPainted(false);
        bottone.setBorderPainted(false);
        bottone.addActionListener(new PescaAzione(Umano.getUmano(), MazzoUno.getMazzoUno()));

        add(bottone, BorderLayout.CENTER);
    }

    @Override
    public void update(Object o) {

    }

}