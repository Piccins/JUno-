package controller;

import model.ControlloreCartaValida;
import model.GestoreTurni;
import model.carta.Carta;
import model.mazzo.MazzoUno;
import model.mazzo.PilaScartiUno;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RitardoCartaAggiunta implements ActionListener {

    private final Timer timer;

    private static RitardoCartaAggiunta ritardoCartaAggiunta;

    private RitardoCartaAggiunta() {
        this.timer = new Timer(0, this);
        this.timer.setInitialDelay(750);
        this.timer.setRepeats(false);
    }

    public static RitardoCartaAggiunta getRitardoCartaAggiunta() {
        if(ritardoCartaAggiunta == null) ritardoCartaAggiunta = new RitardoCartaAggiunta();
        return ritardoCartaAggiunta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GestoreTurni gestoreTurni = GestoreTurni.getGestoreTurni();
        Carta carta = MazzoUno.getMazzoUno().pesca();
        gestoreTurni.giocatoreAttuale().add(carta);

        // Caso in cui la carta appena aggiunta è scartabile.
        if(ControlloreCartaValida.getControlloreCartaValida()
                .isCompatibile(carta, PilaScartiUno.getPilaScartiUno().peek()))
            RitardoCartaScartata.getRitardoCartaScartata().getTimer().start();

        // Caso in cui la carta appena aggiunta non è scartabile
        // quindi viene passato il turno al giocatore successivo
        // e il ManagerPartita viene chiamato per gestire il
        // giocatore successivo.
        else {
            gestoreTurni.impostaGiocatoreSuccessivo();
            ManagerPartita.getManagerTurni().getTimer().start();
        }
    }

    /**
     * Restituisce il timer di quest
     * istanza.
     * @return Un oggetto Timer.
     */
    public Timer getTimer() {
        return timer;
    }

}