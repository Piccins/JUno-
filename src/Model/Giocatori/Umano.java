package Model.Giocatori;

import Model.Carta.Carta;
import Utilita.Observable;
import Utilita.Observer;

import java.util.ArrayList;
import java.util.List;

public class Umano implements Observable, Giocatore {

    // L'ultima carta coinvolta.
    private Carta carta;

    private boolean cartaAggiunta = false;

    // Lista degli osservatori.
    private final List<Observer> observers;

    // Il nome del giocatore.
    private String nome;

    // Lista delle carte.
    private final List<Carta> carte;

    // Instanza della classe umano.
    private static Umano umano;

    // Costruisce l'oggetto umano.
    private Umano() {
        carte = new ArrayList<>();
        observers = new ArrayList<>();
    }

    /**
     * Restituisce l'oggetto Umano.
     * @return Un oggetto Umano.
     */
    public static Umano getUmano() {
        if(umano == null) umano = new Umano();
        return umano;
    }

    /**
     * Aggiunge una carta nella mano di
     * questo giocatore.
     * @param carta Un oggetto Carta.
     */
    public void add(Carta carta) {
        this.cartaAggiunta = true;
        this.carta = carta; // Ultima carta coinvolta.
        this.carte.add(carta);
        updateAll();
    }

    /**
     * Rimuove la carta specificata nella mano
     * di questo giocatore.
     * @param carta Un oggetto Carta.
     */
    public void remove(Carta carta) {
        this.cartaAggiunta = false;
        this.carta = carta; // Ultima carta coinvolta.
        this.carte.remove(carta);
        updateAll();
    }

    /**
     * Restituisce l'ultima carta
     * coinvolta.
     * @return Un oggetto Carta.
     */
    public Carta getCarta() {
        return carta;
    }

    /**
     * Restituisce le carte in mano di questo giocatore.
     * @return Una lista di carte.
     */
    public List<Carta> getCarte() {
        return carte;
    }

    /**
     * Imposta il nome del giocatore umano.
     * Se il nome ha una lunghezza uguale a zero
     * oppure una lunghezza superiore a 20 lancia
     * una RuntimeException.
     * @param nome Una Stringa.
     */
    public void setNome(String nome) {
        int length = nome.length();
        if(length == 0)
            throw new IllegalArgumentException("Lunghezza del nickname uguale a 0 non accettata.");
        else if(length > 20)
            throw new IllegalArgumentException("Lunghezza del nickname superiore a 20 non accettata.");
        this.nome = nome;
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
        for(Observer o : observers) o.update(this);
    }

    public String toString() {
        return "Giocatore[" + nome + "]";
    }

}