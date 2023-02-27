package model;

import model.giocatori.GestoreGiocatori;
import model.giocatori.Giocatore;
import utilita.Observable;
import utilita.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Questa classe si occupa di definisce un gestore
 * dei turni nel gioco di carte Uno all'interno di
 * questa applicazione. Tale gestore svolge alcuni
 * operazioni fondamentali come:
 * - impostare il primo giocatore.
 * - impostare il giocatore successivo a quello corrente.
 * - invertire l'ordine dei turni.
 * - fornire aggiornamenti a delle classi interessate.
 */
public class GestoreTurni implements Observable {

    // Valore booleano per determinare se
    // l'ultima modifica ha comportato la
    // inversione dei turni.
    private boolean haInvertito = false;

    // Lista degli osservatori.
    private final List<Observer> observers;

    // L'indice del giocatore corrente.
    private int indiceGiocatoreCorrente;

    // Valore booleano per determinare se
    // l'ordine dei turni è invertito.
    private boolean invertito;

    // L'istanza della classe GestoreTurni.
    private static GestoreTurni gestoreTurni;

    // Costruisce l'oggetto GestoreTurni.
    private GestoreTurni() {
        invertito = false;
        this.observers = new ArrayList<>();
    }

    /**
     * Restituisce l'istanza della classe GestoreTurni.
     * @return Un oggetto GestoreTurni.
     */
    public static GestoreTurni getGestoreTurni() {
        if (gestoreTurni == null) gestoreTurni = new GestoreTurni();
        return gestoreTurni;
    }

    /**
     * Genera un indice casuale che determina il giocatore
     * che inizia la partita in una partita nel gioco di carte Uno.
     * @param giocatori Un oggetto List di oggetti Giocatori.
     */
    public void impostaPrimoGiocatore(List<Giocatore> giocatori) {
        Random r = new Random();
        this.indiceGiocatoreCorrente = r.nextInt(giocatori.size());
        updateAll();
    }

    /**
     * Permette al giocatore successivo a quello
     * corrente di salvare il turno.
     */
    public void saltaGiro() {
        giocatoreSuccessivo();
    }

    /**
     * Restituisce il giocatore attuale.
     * @return Un oggetto di tipo Giocatore.
     */
    public Giocatore giocatoreAttuale () {
        return GestoreGiocatori.getGestoreGiocatori()
                .getGiocatori().get(indiceGiocatoreCorrente);
    }

    /**
     * Imposta il giocatore successivo.
     */
    public void impostaGiocatoreSuccessivo() {
        giocatoreSuccessivo();
        this.haInvertito = false;
        updateAll();
    }

    /**
     * Imposta il giocatore successivo tenendo conto
     * della possibile inversione dei turni.
     */
    private void giocatoreSuccessivo() {
        if(invertito) {
            indiceGiocatoreCorrente--;
            if(indiceGiocatoreCorrente == - 1) indiceGiocatoreCorrente = 3;
        } else {
            indiceGiocatoreCorrente++;
            if(indiceGiocatoreCorrente == 4) indiceGiocatoreCorrente = 0;
        }
    }

    /**
     * Inverte l'ordine del turno.
     */
    public void inverti() {
        this.invertito = !invertito;
        this.haInvertito = true;
        updateAll();
    }

    /**
     * Restituisce true se, e soltanto s 'ordine dei turni
     * è stato invertito. Tale metodo viene utilizzato degli
     * eventuali osservatori che vogliono sapere se l'aggiornamento
     * ricevuto è arrivato in seguito all'inversione dei turni.
     * @return Un valore booleano.
     */
    public boolean haInvertito() {
        return haInvertito;
    }

    /**
     * Restituisce true se, e soltanto se, l'ordine dei
     * turni è invertito, altrimenti restituisce false.
     * @return Un valore booleano.
     */
    public boolean isInvertito() {
        return invertito;
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