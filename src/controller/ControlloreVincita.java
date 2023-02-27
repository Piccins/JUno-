package controller;

import model.GestoreTurni;
import model.giocatori.Bot;
import model.giocatori.Giocatore;
import model.mazzo.PilaScarti;
import utilita.Observable;
import utilita.Observer;
import view.CardPannello;
import view.PannelloVincitore;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Questa classe definisce un controllore di vincita nel
 * gioco di carte Uno.
 */
public class ControlloreVincita implements Observable, Observer {

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

        // Caso in cui il giocatore ha
        // zero carte in mano.
        if(size == 0) {
            PannelloVincitore.getPannelloVincitore().impostaPannelloVincitore();
            ((CardLayout) CardPannello.getCardPannello().getLayout())
                    .show(CardPannello.getCardPannello(), CardPannello.PANNELLO_VINCITORE);
        }

        // Caso in cui ha almeno una carta nella
        // sua mano.
        else {

            // Caso nella quale ha una carta nella
            // sua mano.
            if(size == 1) {

                // BOT.
                if(giocatore instanceof Bot) {
                    Random r = new Random();
                    int valore = r.nextInt(2);

                    // Il bot non ha detto UNO.
                    if (valore == 1) {
                        Penitenza.getPenitenza()
                                .getTimer().start();
                    }

                    else {
                        // Il bot ha detto uno.
                        // Aggiorniamo la classe che
                        // attiva la eventuale azione
                        // della carta appena scartata.
                        updateAll();
                    }
                }

                // UMANO.
                else {
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

    @Override
    public void update(Object o) {
        if(o instanceof PilaScarti<?> pilaScarti) {
            if(pilaScarti.size() > 1) controlla();
        } else throw new IllegalArgumentException(
                "Il tipo dell'oggetto non valido: " + o.getClass() +
                        ". Tipo atteso PilaScarti.");
    }

}