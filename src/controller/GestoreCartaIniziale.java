package controller;

import model.carta.Carta;
import model.mazzo.MazzoUno;
import model.mazzo.PilaScartiUno;

/**
 * Questa classe si occupa di gestire lo scarto
 * della prima carta in cima alla pila degli scarti.
 * Lo scarto della prima carta dev'essere effettuato
 * fintanto che la carta scartata non risulta essere
 * diversa da una carta jolly.
 */
public class GestoreCartaIniziale {

    // L'istanza della classe ControlloreCartaIniziale.
    private static GestoreCartaIniziale controlloreCartaIniziale;

    // Costruire l'istanza della classe GestoreCartaIniziale.
    private GestoreCartaIniziale() {}

    /**
     * Restituisce l'istanza della classe GestoreCartaIniziale.
     * @return Un oggetto GestoreCartaIniziale.
     */
    public static GestoreCartaIniziale getControlloreCartaIniziale() {
        if(controlloreCartaIniziale == null) controlloreCartaIniziale = new GestoreCartaIniziale();
        return controlloreCartaIniziale;
    }

    /**
     * Questo metodo svolge la funzione di scartamento
     * della prima carta in cima alla pila degli scarti.
     * Fintanto che la carta prelevata dal mazzo (per poi
     * essere scartata) è uguale a una carta jolly, il processo
     * viene eseguito. Il processo quindi viene interrotto quando
     * la carta prelevata dalla cima del mazzo è diversa da
     * una carta jolly, caso in cui la carta viene finalmente scartata.
     */
    public void gestisci() {
        // Il mazzo delle carte nell'applicazione.
        MazzoUno mazzoUno = MazzoUno.getMazzoUno();

        while(true) {
            // La carta prelevata dalla cima del mazzo.
            Carta carta = mazzoUno.pesca();

            // Caso della carta jolly
            if(carta.getColore().isNero())
                // Re-inserimento della carta
                // in fondo al mazzo.
                mazzoUno.add(0, carta);

            // Carta valida, scartamento di essa
            // in cima alla pila degli scarti e
            // interruzione del while.
            else {
                PilaScartiUno.getPilaScartiUno().scarta(carta);
                break;
            }
        }
    }

}