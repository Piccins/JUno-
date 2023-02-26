package controller;

import model.GestoreTurni;
import model.giocatori.Umano;
import utilita.Observable;
import utilita.Observer;
import view.giocatori.PannelloCarteUmano;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe definisce un timer per la penitenza
 *
 */
public class TimerPenitenza implements ActionListener, Observable {

    // Determina se il timer è stato avviato.
    private boolean iniziato;

    // Lista degli osservatori.
    private final List<Observer> observers;

    // Il timer.
    private final Timer timer;

    // L'istanza della classe TimerPenitenza.
    private static TimerPenitenza timerPenitenza;


    // Costruttore della classe TimerPenitenza
    private TimerPenitenza() {
        this.timer = new Timer(0, this);
        this.timer.setInitialDelay(3000);
        this.timer.setRepeats(false);
        this.observers = new ArrayList<>();
        this.iniziato = false;
    }

    /**
     * Restituisce l'istanza della classe TimerPenitenza.
     * @return Un oggetto TimerPenitenza.
     */
    public static TimerPenitenza getTimerPenitenza() {
        if(timerPenitenza == null) timerPenitenza = new TimerPenitenza();
        return timerPenitenza;
    }

    /**
     * Avvia il timer di questa istanza.
     */
    public void start() {
        this.timer.start();
        this.iniziato = true;
        updateAll();
    }

    /**
     * Ferma il timer di questa istanza.
     */
    public void stop() {
        this.timer.stop();
        this.iniziato = false;
        updateAll();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Imposta il valore di penalità a true se
        // il turno del giocatore attuale è quello
        // dell'utente dell'applicazione. Tale valore
        // booleano comunica che le carte che verranno
        // aggiunte devono essere disabilitate quando inserite.
        PannelloCarteUmano.getPannelloCarteUmano()
                .setInPenalita(GestoreTurni.getGestoreTurni()
                        .giocatoreAttuale() instanceof Umano);

        // Avvio della penitenza.
        Penitenza.getPenitenza().getTimer().start();
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

    /**
     * Restituisce true se, e soltanto se, il timer
     * di questa istanza è stato avviato, altrimenti false.
     * @return Un booleano
     */
    public boolean isIniziato() {
        return iniziato;
    }

}