package controller;

import model.carta.Colore;
import model.mazzo.ColoreInGioco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Questa classe definisce oggetti ImpostaColore,
 * ovvero oggetti che permettono d'impostare uno
 * specifico colore nella classe ColoreInGioco.
 * Tali oggetti vengono inseriti nella lista degli
 * ascoltatori dei bottoni nell'interfaccia grafica
 * della partita per permettere all'utente dell'applicazione
 * di scegliere quale colore impostare quando egli
 * scarta una carta jolly.
 */
public class ImpostaColore implements ActionListener {

    // L'oggetto Colore da impostare.
    private final Colore coloreDaImpostare;

    /**
     * Costruisce un oggetto ImpostaColore
     * con l'oggetto Colore specificato.
     * @param coloreDaImpostare l'oggetto Colore da
     *                          impostare.
     */
    public ImpostaColore(Colore coloreDaImpostare) {
        if(coloreDaImpostare.isNero())
            throw new IllegalArgumentException(
                    "Oggetto Colore non valido per l'impostazione," +
                    "Utilizzare soltanto colori rosso, blu, verde e giallo");
        this.coloreDaImpostare = coloreDaImpostare;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // impostazione del colore nella classe che si occupa
        // della gestione del colore in gioco.
        ColoreInGioco coloreInGioco = ColoreInGioco.getColoreInGioco();
        coloreInGioco.setColore(coloreDaImpostare);
    }

}