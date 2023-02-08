package Model.Giocatori;

import Utilita.Observable;
import Utilita.Observer;

import java.util.ArrayList;
import java.util.List;

import static Model.Giocatori.Umano.getUmano;

public class GestoreGiocatori implements Observable {

    private final List<Observer> observers;

    private static GestoreGiocatori gestoreGiocatori;

    private final List<Giocatore> giocatori;

    // Costruisce il gestore dei giocatori.
    private GestoreGiocatori() {
        giocatori = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static GestoreGiocatori getGestoreGiocatori(){
        if (gestoreGiocatori == null) gestoreGiocatori = new GestoreGiocatori();
        return gestoreGiocatori;
    }

    public void setGiocatori() {
        giocatori.clear();
        Bot bot1 = new Bot("drago");
        Bot bot2 = new Bot( "serpente");
        Bot bot3 = new Bot("cavallo");
        giocatori.add(bot1);
        giocatori.add(bot2);
        giocatori.add(bot3);
        giocatori.add(getUmano());
        updateAll();
    }

    public List<Giocatore> getGiocatori(){
        return giocatori;
    }

    public List<Giocatore> getBots() {
        return giocatori.subList(0, 3);
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