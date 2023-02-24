package model;

import model.giocatori.GestoreGiocatori;
import model.giocatori.Giocatore;
import utilita.Observable;
import utilita.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GestoreTurni implements Observer, Observable {

    private boolean haInvertito = false;

    private final List<Observer> observers;

    private int indiceGiocatoreCorrente;

    private boolean invertito;

    private static GestoreTurni gestoreTurni;

    private GestoreTurni() {
        invertito = false;
        this.observers = new ArrayList<>();
    }

    public static GestoreTurni getGestoreTurni() {
        if (gestoreTurni == null) gestoreTurni = new GestoreTurni();
        return gestoreTurni;
    }

    public void impostaPrimoGiocatore(List<Giocatore> giocatori) {
        Random r = new Random();
        this.indiceGiocatoreCorrente = r.nextInt(giocatori.size());
    }

    public void saltaGiro() {
        giocatoreSuccessivo();
    }

    public Giocatore giocatoreAttuale () {
        return GestoreGiocatori.getGestoreGiocatori()
                .getGiocatori().get(indiceGiocatoreCorrente);
    }

    /**
     * Imposta il giocatore successivo.
     */
    public void impostaGiocatoreSuccessivo() {
        giocatoreSuccessivo();
        this.haInvertito = false;
        updateAll();
    }

    // Imposta il giocatore successivo.
    private void giocatoreSuccessivo() {
        if(invertito) {
            indiceGiocatoreCorrente--;
            if(indiceGiocatoreCorrente == - 1) indiceGiocatoreCorrente = 3;
        } else {
            indiceGiocatoreCorrente++;
            if(indiceGiocatoreCorrente == 4) indiceGiocatoreCorrente = 0;
        }
    }

    /**
     * Inverte l'ordine del turno.
     */
    public void inverti() {
        this.invertito = !invertito;
        this.haInvertito = true;
        updateAll();
    }

    /**
     * Restituisce true se, e soltanto se
     * l'ordine dei turni è invertito.
     * @return Un booleano.
     */
    public boolean isInvertito() {
        return haInvertito;
    }

    @Override
    public void update(Object o) {
        if(o instanceof GestoreGiocatori gestoreGiocatori) {
            impostaPrimoGiocatore(gestoreGiocatori.getGiocatori());
        } else throw new IllegalArgumentException(
                "Tipo non valido. Tipo atteso GestoreGiocatori.");
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