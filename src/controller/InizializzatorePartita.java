package controller;

import model.giocatori.GestoreGiocatori;
import model.giocatori.Giocatore;
import utilita.Observer;

import java.util.List;

public class InizializzatorePartita implements Observer {

    private static InizializzatorePartita inizializzatorePartita;

    private InizializzatorePartita() {}

    public static InizializzatorePartita getInizializzatorePartita() {
        if(inizializzatorePartita == null) inizializzatorePartita = new InizializzatorePartita();
        return inizializzatorePartita;
    }

    public void inizializzaPartita() {
        GestoreGiocatori gestoreGiocatori = GestoreGiocatori.getGestoreGiocatori();
        List<Giocatore> giocatori = gestoreGiocatori.getGiocatori();
        // giocatori.get(0).addObserver(pannelloCarteBot1);
        // giocatori.get(1).addObserver(pannelloCarteBot2);
        // giocatori.get(2).addObserver(pannelloCarteBot3);
        // giocatori.get(3).addObserver(pannelloCarteUmano);
        // Visualizzare pannello partita.
    }

    @Override
    public void update(Object o) {
        if(o instanceof ControlloreNickname) {
            inizializzaPartita();
        } else throw new IllegalArgumentException("Tipo dell'oggetto non valido. ControlloreNickname atteso.");
    }

}