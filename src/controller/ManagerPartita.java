package controller;

import model.GestoreTurni;
import model.carta.Carta;
import model.giocatori.Bot;
import model.giocatori.Giocatore;
import model.mazzo.PilaScartiUno;
import utilita.Observable;
import utilita.Observer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ManagerPartita implements Observer, Observable, ActionListener {

    private final Timer timer;

    private final List<Observer> observers;

    private static ManagerPartita managerTurni;

    private ManagerPartita() {
        observers = new ArrayList<>();
        timer = new Timer(1000, this);
        timer.setInitialDelay(1000);
        timer.setRepeats(false);
    }

    public static ManagerPartita getManagerTurni() {
        if(managerTurni == null) managerTurni = new ManagerPartita();
        return managerTurni;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void updateAll() {
        for(Observer o : observers) o.update(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GestoreTurni gestoreTurni = GestoreTurni.getGestoreTurni();
        Giocatore giocatore = gestoreTurni.giocatoreAttuale();
        if(giocatore instanceof Bot bot) {
            Carta carta = bot.mossa();

            // Il bot non possiede carte da
            // giocare e quindi deve pescare.
            if(carta == null)
                RitardoCartaAggiunta.getRitardoCartaAggiunta()
                        .getTimer().start();
            else {
                giocatore.remove(carta);
                PilaScartiUno.getPilaScartiUno().scarta(carta);
            }

        } else
            // Aggiorna la view predisponendola
            // all'immissione dell'input dell'utente.
            updateAll();
    }

    public Timer getTimer() {
        return timer;
    }

    @Override
    public void update(Object o) {
        if(o instanceof DistributoreCarte || o instanceof AttivatoreAzione)
            timer.start();
        else throw new IllegalArgumentException(
                "Tipo dell'oggetto non valido: " + o.getClass() +
                        ". Tipo atteso DistributoreCarte.");
    }

}