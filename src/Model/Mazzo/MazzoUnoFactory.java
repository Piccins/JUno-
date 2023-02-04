package Model.Mazzo;

import Model.Carta.*;
import Utilità.Observable;
import Utilità.Observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MazzoUnoFactory implements MazzoFactory<Carta>, Observable {

    private final List<Observer> observers;

    private static MazzoUnoFactory mazzoUnoFactory;

    private MazzoUnoFactory() {
        this.observers = new ArrayList<>();
    }

    public static MazzoUnoFactory getMazzoUnoFactory() {
        if(mazzoUnoFactory == null) mazzoUnoFactory = new MazzoUnoFactory();
        return mazzoUnoFactory;
    }

    @Override
    public List<Carta> produciMazzo() {
        List<Carta> mazzo = new ArrayList<>();

        // Produzione delle carte numeriche.
        Arrays.asList(ColoreUno.values()).forEach(colore -> {

            // Carte jolly.
            if(colore.isNero()) {
                for(int i = 0; i < 4; i++) {
                    mazzo.add(new CartaUno(colore, null, AzioneUno.CAMBIACOLORE));
                    mazzo.add(new CartaUno(colore, null, AzioneUno.PESCAQUATTRO));
                }
            }

            // Carte colorate classiche.
            else {
                for(int i = 0; i <= 9; i++) {

                    // Carte numeriche con valore 0.
                    if(i == 0) {
                        mazzo.add(new CartaUno(colore, i, null));
                    }

                    // Carte numeriche che hanno valore che va da 1 a 9.
                    else {
                        mazzo.add(new CartaUno(colore, i, null));
                        mazzo.add(new CartaUno(colore, i, null));
                    }
                }

                // Creazione delle carte azione semplici.
                Arrays.asList(AzioneUno.values()).forEach(azione -> {
                    if(!azione.isPescaQuattro() && !azione.isCambiaColore()) {
                        mazzo.add(new CartaUno(colore, null, azione));
                        mazzo.add(new CartaUno(colore, null, azione));
                    }
                });
            }
        });
        updateAll();
        return mazzo;
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