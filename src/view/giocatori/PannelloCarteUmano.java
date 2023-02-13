package view.giocatori;

import controller.CreatoreCartaGrafica;
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

    private boolean partitaIniziata;

    private boolean inPenalita;

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

            Carta carta = umano.getCarta();

            // Aggiunta di una carta.
            if(umano.isCartaAggiunta()) {

                // Creazione della carta in versione grafica.
                CartaGrafica cartaGrafica = CreatoreCartaGrafica
                        .getCreatoreCartaGrafica()
                        .creaCartaGrafica(carta);

                // Aggiunta dell'Action listener
                // per scartare la carta nella pila.
                cartaGrafica.addActionListener(new ScartoAzione());

                mappaCarteGrafiche.put(carta, cartaGrafica);

                // Se la partita non è iniziata ciascuna carta aggiunta
                // deve essere inizialmente disabilitata.
                // Se la partita è iniziata l'abilitazione dipende dalla
                // compatibilità della carta con la carta in cima alla pila e
                // dal fatto che il giocatore di turno sia quello umano e
                // dallo stato della penalità.
                if(partitaIniziata && !inPenalita &&
                        GestoreTurni.getGestoreTurni()
                                .giocatoreAttuale() == Umano.getUmano()) {
                    Arrays.asList(getComponents()).forEach(c -> c.setEnabled(false));
                    cartaGrafica.setEnabled(ControlloreCartaValida.getControlloreCartaValida()
                            .isCompatibile(carta, PilaScartiUno.getPilaScartiUno().peek()));
                }

                // Partita non iniziata.
                // Penalità
                // Effetto di una carta dell'avversario.
                else cartaGrafica.setEnabled(false);

                // Aggiunta della carta.
                add(cartaGrafica);
            }

            // Rimozione di una carta.
            else remove(mappaCarteGrafiche.get(carta));

            revalidate();
            repaint();

        } else throw new IllegalArgumentException(
                "Tipo dell'oggetto non valido. Umano atteso");
    }

}