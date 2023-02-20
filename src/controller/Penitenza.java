package controller;

import model.GestoreTurni;
import model.mazzo.MazzoUno;
import utilita.Observable;
import utilita.Observer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe definisce l'esecutore della
 * penitenza nel gioco di carte Uno.
 */
public class Penitenza implements ActionListener, Observable {

    // Il numero delle carte da pescare.
    private int carteDaPescare;

    // Lista degli observer.
    private final List<Observer> observers;

    // Il timer.
    private final Timer timer;

    // L'istanza della classe Penitenza.
    private static Penitenza penitenza;

    // Costruttore dell'istanza della classe Penitenza.
    private Penitenza() {
        this.observers = new ArrayList<>();
        this.timer = new Timer(350, this);
        this.timer.setInitialDelay(0);
        this.carteDaPescare = 2;
    }

    /**
     * Restituisce l'istanza della classe Penitenza.
     * @return Un oggetto Penitenza.
     */
    public static Penitenza getPenitenza() {
        if(penitenza == null) penitenza = new Penitenza();
        return penitenza;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GestoreTurni.getGestoreTurni()
                .giocatoreAttuale()
                .add(MazzoUno.getMazzoUno().pesca());
        carteDaPescare --;
        if(carteDaPescare == 0) {
            timer.stop();
            carteDaPescare = 2;
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

    /**
     * Restituisce il timer di quest'istanza.
     * @return Un oggetto Timer.
     */
    public Timer getTimer() {
        return timer;
    }
}
