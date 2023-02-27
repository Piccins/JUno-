package view.centro;

import model.carta.Colore;

import javax.swing.*;

/**
 * Questa classe definisce colori grafici, ovvero
 * bottoni che incapsulano oggetti di tipo Colore.
 * Tale classe è stata creata per risolvere un problema
 * di programmazione che si è presentato quando è stato
 * realizzato il pannello per il contenimento dei bottoni
 * contenenti i colori che l'utente può cliccare quando
 * egli scarta una carta jolly. L'ascoltatore può
 * chiedere, mediante l'implementazione di questa classe,
 * l'oggetto Colore incapsulato dalla sorgente dell'evento.
 */
public class ColoreGrafico extends JButton {

    // L'oggetto Colore incapsulato.
    private final Colore colore;

    /**
     * Costruisce un oggetto ColoreGrafico con
     * l'oggetto Icona e Colore specificati.
     * @param icona Un oggetto Icona.
     * @param colore Un oggetto Colore.
     */
    public ColoreGrafico(Icon icona, Colore colore) {
        super(icona);
        this.colore = colore;
    }

    /**
     * Restituisce l'oggetto Colore
     * incapsulato da questa istanza.
     * @return Un oggetto Colore.
     */
    public Colore getColore() {
        return colore;
    }

}