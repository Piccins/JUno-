package view.giocatori;

import controller.CreatoreCartaGrafica;
import controller.DistributoreCarte;
import controller.ScartoAzione;
import model.ControlloreCartaValida;
import model.GestoreTurni;
import model.carta.Carta;
import model.giocatori.Umano;
import model.mazzo.PilaScartiUno;
import utilita.Observer;
import view.CartaGrafica;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PannelloCarteUmano extends JPanel implements Observer {

    private boolean partitaIniziata = true;

    private boolean inPenalita = false;

    private Map<Carta, CartaGrafica> mappaCarteGrafiche;

    private static PannelloCarteUmano pannelloCarteUmano;

    private PannelloCarteUmano() {}

    public static PannelloCarteUmano getPannelloCarteUmano() {
        if(pannelloCarteUmano == null) pannelloCarteUmano = new PannelloCarteUmano();
        return pannelloCarteUmano;
    }

    public void inizializza() {
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        // Mappa carte grafiche.
        mappaCarteGrafiche = new HashMap<>();
    }

    @Override
    public void update(Object o) {
        if(o instanceof Umano umano) {

            // L'ultima carta coinvolta dal
            // giocatore umano.
            Carta carta = umano.getCarta();

            // Aggiunta di una carta.
            if(umano.isCartaAggiunta()) {

                // Creazione della carta in versione grafica.
                CartaGrafica cartaGrafica = CreatoreCartaGrafica
                        .getCreatoreCartaGrafica()
                        .creaCartaGrafica(carta);

                // Aggiunta dell'Action listener
                // per scartare la carta nella pila.
                cartaGrafica.addActionListener(ScartoAzione.getScartoAzione());

                // Memorizzazione della carta inserita per
                // la sua futura rimozione.
                mappaCarteGrafiche.put(carta, cartaGrafica);

                // Se la partita non è iniziata ciascuna carta aggiunta
                // deve essere inizialmente disabilitata.
                // Se la partita è iniziata l'abilitazione dipende dalla
                // compatibilità della carta con la carta in cima alla pila e
                // dal fatto che il giocatore di turno sia quello umano e anche
                // dallo stato della penalità.
                if(partitaIniziata && !inPenalita &&
                        GestoreTurni.getGestoreTurni().giocatoreAttuale() == Umano.getUmano()) {
                    Arrays.asList(getComponents()).forEach(c -> c.setEnabled(false));
                    cartaGrafica.setEnabled(ControlloreCartaValida.getControlloreCartaValida()
                            .isCompatibile(carta, PilaScartiUno.getPilaScartiUno().peek()));
                }

                // Caso in cui la Partita non è iniziata, penalità
                // oppure l'effetto di una carta dell'avversario
                // che ha fatto pescare il giocatore umano.
                else cartaGrafica.setEnabled(false);

                // Aggiunta della carta.
                add(cartaGrafica);
            }

            // Rimozione di una carta.
            else remove(mappaCarteGrafiche.get(carta));

            // Sempre dopo aver aggiunto o rimosso dei
            // componenti dall'interfaccia grafica.
            revalidate();
            repaint();

        }

        // Le carte sono state distribuite.
        // Possiamo abilitare il campo partitaIniziata.
        else if(o instanceof DistributoreCarte)
            partitaIniziata = true;

        // Caso non valido.
        else throw new IllegalArgumentException(
                "Tipo dell'oggetto non valido. Umano atteso");
    }

    /**
     * Imposta il valore booleano di penalità
     * @param inPenalita un valore booleano.
     */
    public void setInPenalita(boolean inPenalita) {
        this.inPenalita = inPenalita;
    }

}