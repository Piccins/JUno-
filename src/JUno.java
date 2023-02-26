import model.giocatori.GestoreGiocatori;
import model.giocatori.Giocatore;
import view.Finestra;

import java.util.List;

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
    }

}