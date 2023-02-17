import model.GestoreTurni;
import model.giocatori.Bot;
import model.giocatori.GestoreGiocatori;
import model.giocatori.Giocatore;
import model.giocatori.Umano;
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

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ignore) {}
        GestoreTurni gestoreTurni = GestoreTurni.getGestoreTurni();
        while(true) {
            if(gestoreTurni.giocatoreAttuale() == Umano.getUmano()) break;
            else gestoreTurni.impostaGiocatoreSuccessivo();
        }
    }

}