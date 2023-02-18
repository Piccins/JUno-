package controller;

import model.GestoreTurni;
import model.giocatori.Giocatore;
import utilita.Observable;
import utilita.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe definisce un controllore di vincita nel
 * gioco di carte Uno.
 */
public class ControlloreVincita implements Observable {

    private final List<Observer> observers;

    // L'istanza ControlloreVincita
    private static ControlloreVincita controlloreVincita;

    // Costruisce l'istanza ControlloreVincita.
    private ControlloreVincita() {
        observers = new ArrayList<>();
    }

    /**
     * Restituisce l'istanza della classe ControlloreVincita.
     * @return Un oggetto ControlloreVincita.
     */
    public static ControlloreVincita getControlloreVincita() {
        if(controlloreVincita == null) controlloreVincita = new ControlloreVincita();
        return controlloreVincita;
    }

    public void controlla() {
        GestoreTurni gestoreTurni = GestoreTurni.getGestoreTurni();
        Giocatore giocatore = gestoreTurni.giocatoreAttuale();
        if(giocatore.getCarte().size() == 0) {
            // Mostra del pannello del vincitore.
        } else updateAll();
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