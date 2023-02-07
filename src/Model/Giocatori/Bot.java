package Model.Giocatori;

import Model.Carta.Carta;
import Model.FornitoreDelleCarteValide;
import Utilità.Observable;
import Utilità.Observer;


import java.util.ArrayList;
import java.util.List;

public class Bot implements Observable, Giocatore {

    private final List<Carta> carte;

    private final List<Observer> observers;

    private final String nome;

    public Bot(String nome) {
        this.nome = nome;
        this.carte = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public Carta mossa() {
        // In base alla carta in cima alla pila degli scarti
        // questo giocatore (bot) decide quale carta fornire
        // e, se ha almeno una carta che può giocare, ne ritorna
        // una. Altrimenti ritorna null.

        FornitoreDelleCarteValide fornitoreDelleCarteValide = FornitoreDelleCarteValide.getFornitoreDelleCarteValide();
        List<Carta> carteValide = fornitoreDelleCarteValide.getCarteValide(carte);
        return carteValide.size() == 0 ?  null : carteValide.get(0);
    }

    public void add(Carta carta){
        carte.add(carta);
        updateAll();
    }

    public void remove(Carta carta){
        carte.remove(carta);
        updateAll();
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
        for ( Observer o : observers ) o.update(this);
    }
}