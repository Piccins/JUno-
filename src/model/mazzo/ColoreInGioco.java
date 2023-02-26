package model.mazzo;

import model.carta.Carta;
import model.carta.Colore;
import utilita.Observable;
import utilita.Observer;

import java.util.ArrayList;
import java.util.List;

public class ColoreInGioco implements Observable, Observer {

    private final List<Observer> observers;

    private Colore colore;

    private static ColoreInGioco coloreInGioco;

    private ColoreInGioco() {
        observers = new ArrayList<>();
    }

    public static ColoreInGioco getColoreInGioco() {
        if(coloreInGioco == null)  coloreInGioco = new ColoreInGioco();
        return coloreInGioco;
    }

    public void setColore(Colore colore) {
        this.colore = colore;
        updateAll();
    }

    public Colore getColore() {
        return colore;
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
        if(o instanceof PilaScartiUno pilaScarti) {
            Carta carta = pilaScarti.peek();
            if(!carta.getColore().isNero())
                setColore(carta.getColore());
        } else throw new IllegalArgumentException("Tipo dell'oggetto specificato errato. " +
                "Tipo atteso: PilaScarti.");
    }

}