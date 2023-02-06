package Model.giocatori;

import Model.Carta.Carta;
import Utilità.Observable;
import Utilità.Observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Umano implements Observable {

    private final List<Observer> observers;

    private final List<Carta> carte;

    private static Umano umano;

    private Umano() {
        carte = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static Umano getUmano() {
        if(umano == null) umano = new Umano();
        return umano;
    }

    public void add(Carta carta) {
        this.carte.add(carta);
    }

    public void remove(Carta carta) {
        this.carte.remove(carta);
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