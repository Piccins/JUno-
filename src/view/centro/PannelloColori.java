package view.centro;

import javax.swing.*;

/**
 * Questa classe descrive il pannello dei colori, ovvero
 * i bottoni che l'utente è abilitato a cliccare quando
 * egli scarta una carta jolly. Tali bottoni permettono
 * all'utente dell'applicazione d'impostare un colore nella
 * classe ColoreInGio'.
 */
public class PannelloColori extends JPanel {

    // L'istanza della classe PannelloColori
    private static PannelloColori pannelloColori;

    // Costruisce l'istanza della classe PannelloColori.
    private PannelloColori() {}

    /**
     * Restituisce l'istanza della classe PannelloColori.
     * @return Un oggetto della classe PannelloColori.
     */
    public static PannelloColori getPannelloColori() {
        if(pannelloColori == null) pannelloColori = new PannelloColori();
        return pannelloColori;
    }

    /**
     * Inizializza l'istanza della classe PannelloColori
     * con valori di default.
     */
    public void inizializza() {
        
    }

}