package controller;

import model.giocatori.GestoreGiocatori;
import model.giocatori.Giocatore;
import utilita.Observable;
import utilita.Observer;
import view.CardPannello;
import view.giocatori.PannelloCarteBot1;
import view.giocatori.PannelloCarteBot2;
import view.giocatori.PannelloCarteBot3;
import view.giocatori.PannelloCarteUmano;

import java.awt.*;
import java.util.List;

public class InizializzatorePartita implements Observer {

    private static InizializzatorePartita inizializzatorePartita;

    private InizializzatorePartita() {}

    public static InizializzatorePartita getInizializzatorePartita() {
        if(inizializzatorePartita == null) inizializzatorePartita = new InizializzatorePartita();
        return inizializzatorePartita;
    }

    public void inizializzaPartita() {
        // Creazione dei giocatori.
        GestoreGiocatori gestoreGiocatori = GestoreGiocatori.getGestoreGiocatori();
        gestoreGiocatori.setGiocatori();

        // Lista dei giocatori.
        List<Giocatore> giocatori = gestoreGiocatori.getGiocatori();

        // Inizializzazione del mazzo.
        InizializzatoreDelMazzoUno.getInizializzatoreDelMazzoUno().actionPerformed(null);

        // La gestione della prima carta dev'essere effettuata
        // dopo l'invocazione del metodo actionPerformed della
        // classe InizializzatoreDelMazzoUno.
        GestoreCartaIniziale.getControlloreCartaIniziale().gestisci();

        // Aggiunta degli osservatori.
        ((Observable) giocatori.get(0)).addObserver(PannelloCarteBot1.getPannelloCarteBot1());
        ((Observable) giocatori.get(1)).addObserver(PannelloCarteBot2.getPannelloCarteBot2());
        ((Observable) giocatori.get(2)).addObserver(PannelloCarteBot3.getPannelloCarteBot3());
        ((Observable) giocatori.get(3)).addObserver(PannelloCarteUmano.getPannelloCarteUmano());

        // Mostra del pannello partita.
        CardLayout layoutManager = (CardLayout) CardPannello.getCardPannello().getLayout();
        layoutManager.show(CardPannello.getCardPannello(), CardPannello.PARTITA);

        // Distribuzione delle carte delle carte.
        DistributoreCarte.getDistributoreCarte().start();
    }

    @Override
    public void update(Object o) {
        if(o instanceof GestoreNickname) {
            inizializzaPartita();
        } else throw new IllegalArgumentException("Tipo dell'oggetto non valido. ControlloreNickname atteso.");
    }

}