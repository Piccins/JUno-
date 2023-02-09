package view;

import model.giocatori.Bot;
import model.giocatori.GestoreGiocatori;
import model.giocatori.Giocatore;
import model.mazzo.MazzoUno;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FinestraTester {

    public static void main(String[] args) {
        Inizializzatore.inizializza();
        Finestra finestra = Finestra.getFinestra();
        finestra.setVisible(true);
        List<Giocatore> giocatoreList = GestoreGiocatori.getGestoreGiocatori().getGiocatori();

        try {
            TimeUnit.SECONDS.sleep(10);
            ((Bot) giocatoreList.get(0)).add(MazzoUno.getMazzoUno().pesca());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
