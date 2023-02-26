package view.centro;

import controller.PescaAzione;
import controller.ScartoAzione;
import model.GestoreTurni;
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

    private JButton bottone;

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
        bottone = new JButton();
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

        // Da de-commentare dopo la fase di test.
        // bottone.setDisabledIcon(icona);

        add(bottone, BorderLayout.CENTER);
    }

    @Override
    public void update(Object o) {
        // Quando il turno viene cambiato e il
        // giocatore attuale è quello dell'umano,
        // il mazzo viene abilitato.
        if(o instanceof GestoreTurni gestoreTurni) {
            if (gestoreTurni.giocatoreAttuale() instanceof Umano)
                bottone.setEnabled(true);
        }

        // Se una carta viene scartata
        // il mazzo dev'essere automaticamente
        // disabilitato per prevenire la possibilità
        // di poter pescare da esso.
        if(o instanceof ScartoAzione)
            bottone.setEnabled(false);

        // Caso non valido.
        else throw new IllegalArgumentException(
                "Tipo dell'oggetto non valido: "  + o.getClass() +
                        ". Tipo atteso GestoreTurni.");
    }

}