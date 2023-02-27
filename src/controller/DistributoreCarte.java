package controller;

import model.GestoreTurni;
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

/**
 * Questa classe definisce un distributore delle
 * carte per il gioco di carte Uno.
 */
public class DistributoreCarte implements ActionListener, Observable {

    /** Il numero delle carte distribuite all'inizio. */
    private int limite;

    // Il parametro per permettere la
    // distribuzione di una singola carta
    // per volta a ogni giocatore.
    private int parametro;

    // Lista degli observer.
    private final List<Observer> observers;

    // Il timer.
    private final Timer timer;

    // L'istanza DistributoreCarte.
    private static DistributoreCarte distributoreCarte;

    // Costruisce l'istanza DistributoreCarte.
    private DistributoreCarte() {
        observers = new ArrayList<>();
        timer = new Timer(100, this);
        timer.setInitialDelay(650);
        limite = 28;
        parametro = 0;
    }

    /**
     * Restituisce l'istanza della classe DistributoreCarte.
     * @return Un oggetto DistributoreCarte.
     */
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
            GestoreTurni.getGestoreTurni()
                    .impostaPrimoGiocatore(GestoreGiocatori
                            .getGestoreGiocatori().getGiocatori());
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
