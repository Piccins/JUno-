package controller;

import model.giocatori.GestoreGiocatori;
import model.giocatori.Giocatore;
import model.mazzo.MazzoUno;
import utilita.Observable;
import utilita.Observer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DistributoreCarte implements ActionListener, Observable {

    /** Il numero delle carte distribuite all'inizio. */
    private int limite;

    private int parametro;

    private final List<Observer> observers;

    private final Timer timer;

    private static DistributoreCarte distributoreCarte;

    private DistributoreCarte() {
        observers = new ArrayList<>();
        timer = new Timer(100, this);
        timer.setInitialDelay(650);
        limite = 28;
        parametro = 0;
    }

    public static DistributoreCarte getDistributoreCarte() {
        if(distributoreCarte == null) distributoreCarte = new DistributoreCarte();
        return distributoreCarte;
    }

    /**
     * Avvia la distribuzione delle carte.
     */
    public void start() {
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Fornitori.
        MazzoUno mazzoUno = MazzoUno.getMazzoUno();
        List<Giocatore> giocatori = GestoreGiocatori
                .getGestoreGiocatori().getGiocatori();

        // Aggiunta della carta.
        giocatori.get(parametro).add(mazzoUno.pesca());

        // Impostazione per future invocazioni.
        limite --;
        parametro ++;

        // Ritorniamo al primo giocatore.
        if(parametro == 4) parametro = 0;

        // Tutte le carte sono state
        // distribuite.
        if(limite == 0) {
            timer.stop();

            // Aggiorna il ManagerTurni.
            updateAll();
        }
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
}
