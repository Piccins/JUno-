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

        Finestra.getFinestra().setVisible(true);

        try {
            TimeUnit.SECONDS.sleep(5);
            MazzoUno mazzoUno = MazzoUno.getMazzoUno();
            GestoreTurni gestoreTurni = GestoreTurni.getGestoreTurni();
            while(true) {
                TimeUnit.MILLISECONDS.sleep(350);
                Carta carta = mazzoUno.pesca();
                PilaScartiUno.getPilaScartiUno().scarta(carta);
                gestoreTurni.giocatoreAttuale().add(carta);
                gestoreTurni.impostaGiocatoreSuccessivo();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}