package controller;

import model.giocatori.GestoreGiocatori;
import model.giocatori.Giocatore;
import utilita.Observable;
import utilita.Observer;
import view.CardPannello;
import view.giocatori.PannelloCarteBot1;

import javax.swing.*;
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
        GestoreGiocatori gestoreGiocatori = GestoreGiocatori.getGestoreGiocatori();
        gestoreGiocatori.setGiocatori();
        List<Giocatore> giocatori = gestoreGiocatori.getGiocatori();
        InizializzatoreDelMazzoUno.getInizializzatoreDelMazzoUno().actionPerformed(null);
        ((Observable) giocatori.get(0)).addObserver(PannelloCarteBot1.getPannelloCarteBot1());

        // giocatori.get(1).addObserver(pannelloCarteBot2);
        // giocatori.get(2).addObserver(pannelloCarteBot3);
        // giocatori.get(3).addObserver(pannelloCarteUmano);

        CardLayout layoutManager = (CardLayout) CardPannello.getCardPannello().getLayout();
        layoutManager.show(CardPannello.getCardPannello(), CardPannello.PARTITA);
    }

    @Override
    public void update(Object o) {
        if(o instanceof ControlloreNickname) {
            inizializzaPartita();
        } else throw new IllegalArgumentException("Tipo dell'oggetto non valido. ControlloreNickname atteso.");
    }

}