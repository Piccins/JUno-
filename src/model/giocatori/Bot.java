package model.giocatori;

import model.carta.Carta;
import model.FornitoreDelleCarteValide;
import model.carta.Colore;
import model.carta.ColoreUno;
import utilita.Observable;
import utilita.Observer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Questa classe definisce i bot nel
 * gioco di carte Uno.
 */
public class Bot implements Observable, Giocatore {

    // L'ultima carta coinvolta.
    private Carta carta;

    // Comunica se l'ultima carta
    // coinvolta è stata aggiunta.
    private boolean cartaAggiunta = false;

    // Le carte del bot.
    private final List<Carta> carte;

    // La lista degli osservatori di questo bot.
    private final List<Observer> observers;

    // Il nome del bot.
    private final String nome;

    /**
     * Costruisce un'istanza Bot
     * con il nome specificato.
     * @param nome Il nome del bot.
     */
    public Bot(String nome) {
        this.nome = nome;
        this.carte = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    /**
     * Effettua una mossa nel gioco di carte Uno.
     * @return Un oggetto Carta.
     */
    public Carta mossa() {
        // In base alla carta in cima alla pila degli scarti
        // questo giocatore (bot) decide quale carta fornire
        // e, se ha almeno una carta che può giocare, ne ritorna
        // una. Altrimenti ritorna null.
        FornitoreDelleCarteValide fornitoreDelleCarteValide = FornitoreDelleCarteValide.getFornitoreDelleCarteValide();
        List<Carta> carteValide = fornitoreDelleCarteValide.getCarteValide(carte);
        return carteValide.size() == 0 ?  null : carteValide.get(0);
    }

    public Colore scegliColore() {
        Random r = new Random();
        ColoreUno[] colori = ColoreUno.values();
        Colore colore;

        do {
            int index = r.nextInt(colori.length);
            colore = colori[index];
        } while (colore.isNero());

        return colore;
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

    @Override
    public Carta getCarta() {
        return carta;
    }

    /**
     * Restituisce true se l'ultima carta
     * coinvolta è stato aggiunta, altrimenti false.
     * @return Un valore booleano.
     */
    public boolean isCartaAggiunta() {
        return cartaAggiunta;
    }

    @Override
    public List<Carta> getCarte() {
        return carte;
    }

    @Override
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