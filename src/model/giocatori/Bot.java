package model.giocatori;

import model.carta.Carta;
import model.FornitoreDelleCarteValide;
import utilita.Observable;
import utilita.Observer;


import java.util.ArrayList;
import java.util.List;

public class Bot implements Observable, Giocatore {

    // L'ultima carta coinvolta.
    private Carta carta;

    private boolean cartaAggiunta = false;

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

    /**
     * Aggiunge l'oggetto Carta specificato
     * nella mano di questo giocatore.
     * @param carta Un oggetto Carta.
     */
    public void add(Carta carta){
        cartaAggiunta = true;
        this.carta = carta;
        carte.add(carta);
        updateAll();
    }

    /**
     * Rimuove la carta specificata nella
     * mano di questo giocatore.
     * @param carta Un oggetto Carta.
     */
    public void remove(Carta carta){
        cartaAggiunta = false;
        this.carta = carta;
        carte.remove(carta);
        updateAll();
    }

    /**
     * Restituisce l'ultima carta coinvolta.
     * @return Un oggetto carta.
     */
    public Carta getCarta() {
        return carta;
    }

    public boolean isCartaAggiunta() {
        return cartaAggiunta;
    }

    /**
     * Restituisce le carte in mano di
     * questo giocatore.
     * @return Un oggetto List.
     */
    public List<Carta> getCarte() {
        return carte;
    }

    /**
     * Restituisce il nome di questo giocatore.
     * @return Una stringa.
     */
    public String getNome() {
        return nome;
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

    public String toString() {
        return "Giocatore[" + nome + "]";
    }
}