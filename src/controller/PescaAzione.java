package controller;

import model.carta.Carta;
import model.giocatori.Giocatore;
import model.mazzo.Mazzo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Questa classe definisce un action listener
 * che permette di aggiungere una carta in mano
 * al giocatore umano (utente dell'applicazione).
 */
public class PescaAzione implements ActionListener {

    // Il giocatore umano (utente dell'applicazione).
    private final Giocatore giocatore;

    // Il mazzo da cui pescare le carte.
    private final Mazzo<Carta> mazzo;

    /**
     * Costruisce un oggetto PescaAzione con
     * gli oggetti specificati.
     * @param giocatore Un oggetto Giocatore.
     * @param mazzo Un oggetto Mazzo.
     */
    public PescaAzione(Giocatore giocatore, Mazzo<Carta> mazzo) {
        this.giocatore = giocatore;
        this.mazzo = mazzo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Quando questa azione viene eseguita, il
        // mazzo (view) dev'essere disabilitato.
        JButton mazzoView = (JButton) e.getSource();
        mazzoView.setEnabled(false);

        // Aggiunta della carta nella mano del
        // giocatore.
        giocatore.add(mazzo.pesca());
    }

}