package view;

import model.carta.Carta;

import javax.swing.*;

/**
 * Classe per la costruzione di bottoni
 * che rappresentano carte grafiche all'interno
 * dell'applicazione. Ciascun bottone costruito
 * mediante questa classe incapsula una corrispettiva
 * carta della classe model 'Carta'.
 */
public class CartaGrafica extends JButton {

    // L'oggetto Carta model incapsulato.
    private final Carta carta;

    /**
     * Costruisce un oggetto CartaGrafica con
     * l'oggetto Carta specificato.
     * @param carta Un oggetto Carta.
     */
    public CartaGrafica(Carta carta) {
        if(carta == null) throw new IllegalArgumentException(
                "L'oggetto di tipo Carta specificato dev'essere " +
                        "diverso da null");
        this.carta = carta;
    }

    // Costruttore non accessibile.
    private CartaGrafica() throws InstantiationException {
        throw new InstantiationException();
    }

    /**
     * Restituisce l'oggetto Carta
     * incapsulato da questa istanza.
     * @return Un oggetto Carta.
     */
    public Carta getCarta() {
        return carta;
    }

}