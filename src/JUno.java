import model.GestoreTurni;
import model.carta.Carta;
import model.giocatori.GestoreGiocatori;
import model.giocatori.Giocatore;
import model.giocatori.Umano;
import model.mazzo.MazzoUno;
import model.mazzo.PilaScartiUno;
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
     *
     * @param args Gli argomenti passati nella riga di comando.
     */
    public static void main(String[] args) {
        Inizializzatore.inizializza();

        List<Giocatore> giocatoreList = GestoreGiocatori.getGestoreGiocatori().getGiocatori();

        System.out.println(System.getProperty("user.dir"));

        Finestra.getFinestra().setVisible(true);
    }
}