import model.giocatori.Bot;
import model.giocatori.GestoreGiocatori;
import model.giocatori.Giocatore;
import model.mazzo.MazzoUno;
import view.Inizializzatore;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Classe Main del programma JUno.
 */
public class JUno {

    /**
     * Esegue l'applicazione JUno.
     * @param args Gli argomenti passati nella riga di comando.
     */
    public static void main(String[] args) {
        Inizializzatore.inizializza();
        List<Giocatore> giocatoreList = GestoreGiocatori.getGestoreGiocatori().getGiocatori();
        Bot bot = (Bot) giocatoreList.get(0);

        try {
            TimeUnit.SECONDS.sleep(7);
            ((Bot) giocatoreList.get(0)).add(MazzoUno.getMazzoUno().pesca());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}