package controller;

import model.carta.Carta;
import model.giocatori.Giocatore;
import model.mazzo.Mazzo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PescaAzione implements ActionListener {

    private final Giocatore giocatore;

    private final Mazzo<Carta> mazzo;

    public PescaAzione(Giocatore giocatore, Mazzo<Carta> mazzo) {
        this.giocatore = giocatore;
        this.mazzo = mazzo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        giocatore.add(mazzo.pesca());
    }

}