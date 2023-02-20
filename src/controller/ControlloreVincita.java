package controller;

import model.GestoreTurni;
import model.giocatori.Bot;
import model.giocatori.Giocatore;
import utilita.Observable;
import utilita.Observer;
import view.CardPannello;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        int size = giocatore.getCarte().size();
        if(size == 0)
            ((CardLayout) CardPannello.getCardPannello().getLayout())
                    .show(CardPannello.getCardPannello(), CardPannello.PANNELLO_VINCITORE);
        else {
            if(size == 1) {
                if(giocatore instanceof Bot) {
                    Random r = new Random();
                    int valore = r.nextInt(2);
                    if (valore == 1) {
                        Penitenza.getPenitenza()
                                .getTimer().start();
                    } else {

                        // Il bot ha detto uno.
                        updateAll();
                    }
                } else {
                    TimerPenitenza.getTimerPenitenza().start();
                }
            } else updateAll();
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