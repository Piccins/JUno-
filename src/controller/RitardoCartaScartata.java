package controller;

import model.ControlloreCartaValida;
import model.GestoreTurni;
import model.carta.Carta;
import model.giocatori.Giocatore;
import model.mazzo.MazzoUno;
import model.mazzo.PilaScartiUno;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RitardoCartaScartata implements ActionListener {

    private final Timer timer;

    private static RitardoCartaScartata ritardoCartaScartata;

    private RitardoCartaScartata() {
        timer = new Timer(0, this);
        timer.setInitialDelay(650);
        timer.setRepeats(false);
    }

    public static RitardoCartaScartata getRitardoCartaScartata() {
        if(ritardoCartaScartata == null) ritardoCartaScartata = new RitardoCartaScartata();
        return ritardoCartaScartata;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GestoreTurni gestoreTurni = GestoreTurni.getGestoreTurni();
        Giocatore giocatore = gestoreTurni.giocatoreAttuale();
        Carta carta = giocatore.getCarta();
        giocatore.remove(carta);
        PilaScartiUno.getPilaScartiUno().scarta(carta);
    }

    public Timer getTimer() {
        return timer;
    }

}