package controller;

import model.giocatori.Umano;
import model.mazzo.PilaScartiUno;
import view.CartaGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Questa classe definisce oggetti per permettere
 * a un oggetto CartaGrafica di potersi 'scartare'
 * nella pila degli scarti. Un oggetto CartaGrafica
 * incapsula un oggetto Carta, ovvero il tipo degli
 * oggetti che viene ospitato nella pila degli scarti
 * descritto della classe PilaScartiUno.
 */
public class ScartoAzione implements ActionListener {

    // L'istanza ScartoAzione.
    private static ScartoAzione scartoAzione;

    // Costruisce un oggetto ScartoAzione.
    private ScartoAzione() {}

    /**
     * Restituisce l'istanza della classe ScartoAzione.
     * @return Un oggetto ScartoAzione.
     */
    public static ScartoAzione getScartoAzione() {
        if(scartoAzione == null) scartoAzione = new ScartoAzione();
        return scartoAzione;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Piuttosto che incapsulare l'oggetto CartaGrafica
        // all'interno di un oggetto ScartoAzione, l'oggetto
        // di tipo CartaGrafica che ha generato l'evento viene
        // prelevato direttamente mediante l'invocazione del metodo
        // getSource della classe ActionEvent.
        CartaGrafica cartaGrafica = (CartaGrafica) e.getSource();

        // Prima di scartare la carta nell pila, la carta viene rimossa
        // dalla mano del giocatore (Umano).
        Umano.getUmano().remove(cartaGrafica.getCarta());

        // Scarta la carta incapsulata nella pila degli scarti.
        PilaScartiUno.getPilaScartiUno().scarta(cartaGrafica.getCarta());
    }

}