package Model.Mazzo;

import Model.Carta.Carta;
import Model.Carta.Colore;
import Utilità.Observable;
import Utilità.Observer;

import java.util.List;

public class ColoreInGioco implements Observable, Observer {

    private List<Observer> observers;

    private Colore colore;

    private static ColoreInGioco coloreInGioco;

    private ColoreInGioco() {}

    public static ColoreInGioco getColoreInGioco() {
        if(coloreInGioco == null)  coloreInGioco = new ColoreInGioco();
        return coloreInGioco;
    }

    public void setColore(Colore colore) {
        this.colore = colore;
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
        if(o instanceof PilaScarti<?> pilaScarti) {
            Carta carta = (Carta) pilaScarti.get(pilaScarti.size() - 1);
            if(carta.getColore() != null) setColore(carta.getColore());
        } else throw new IllegalArgumentException("Tipo dell'oggetto specificato errato. " +
                "Tipo atteso: PilaScarti.");
    }

}