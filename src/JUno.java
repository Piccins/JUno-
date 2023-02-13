import model.giocatori.Bot;
import model.giocatori.GestoreGiocatori;
import model.giocatori.Giocatore;
import model.mazzo.MazzoUno;
import view.Finestra;
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

        Finestra.getFinestra().setVisible(true);


        int x = 25;
        int i = 0;
        try {
            TimeUnit.SECONDS.sleep(5);
            Bot bot = (Bot) giocatoreList.get(0);
            while(true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                    giocatoreList.get(i).add(MazzoUno.getMazzoUno().pesca());
                    i ++; x--;
                    if(x == 0);
                    if(i == 4) i = 0;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}