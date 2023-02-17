package view.centro;

import controller.CreatoreCartaGrafica;
import model.carta.Carta;
import model.mazzo.PilaScartiUno;
import utilita.Observer;
import view.CartaGrafica;

import javax.swing.*;
import java.awt.*;

/**
 * Questa classe definisce l'implementazione
 * del pannello dell'interfaccia grafica che
 * descrive la pila degli scarti, che notifica
 * all'utente la carta in cima alla pila degli
 * scarti mediante la visualizzazione di un immagine.
 */
public class PilaScarti extends JPanel implements Observer {

    // L'istanza della classe PilaScarti.
    private static PilaScarti pilaScarti;

    // Costruisce l'istanza della classe PilaScarti.
    private PilaScarti() {}

    /**
     * Restituisce l'istanza della classe PilaScarti.
     * @return Un oggetto della classe PilaScarti.
     */
    public static PilaScarti getPilaScarti() {
        if(pilaScarti == null) pilaScarti = new PilaScarti();
        return pilaScarti;
    }

    /**
     * Inizializza questa istanza con
     * alcuni valori di default.
     */
    public void inizializza() {
         setOpaque(false);
         setLayout(new BorderLayout());
    }

    @Override
    public void update(Object o) {
        if(o instanceof PilaScartiUno pila) {
            Carta carta = pila.getCarta();
            CartaGrafica cartaGrafica = CreatoreCartaGrafica
                    .getCreatoreCartaGrafica().creaCartaGrafica(carta);

            // Sempre rimuovere il vecchio componente
            // per evitare la sovrapposizione.
            removeAll();

            // Aggiunta e aggiornamento.
            add(cartaGrafica, BorderLayout.CENTER);
            revalidate();
            repaint();
        } else throw new IllegalArgumentException(
                "Tipo dell'oggetto specificato non valido." +
                        "Tipo atteso PilaScartiUno");
    }

}