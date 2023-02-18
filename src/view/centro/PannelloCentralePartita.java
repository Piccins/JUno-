package view.centro;

import javax.swing.*;
import java.awt.*;

/**
 * Questa classe descrive il pannello centrale
 * dell'interfaccia grafica della partita.
 * Nella parte centrale dell'interfaccia grafica
 * della partita sono presenti quattro sotto pannelli:
 * - Pannello del mazzo.
 * - Pannello della pila degli scarti.
 * - Pannello del colore.
 * - Pannello del verso.
 */
public class PannelloCentralePartita extends JPanel {

    // Pannello del mazzo.
    private JPanel mazzo;

    // Pannello della pila degli scarti.
    private JPanel pilaScarti;

    // Pannello del colore corrente.
    private JPanel colore;

    // Pannello del verso.
    private JPanel verso;

    // Pannello dei colori.
    private JPanel colori;

    // L'istanza della classe PannelloCentralePartita.
    private static PannelloCentralePartita pannelloCentralePartita;

    // Costruisce l'istanza della classe PannelloCentralePartita.
    private PannelloCentralePartita() {}

    public static PannelloCentralePartita getPannelloCentralePartita() {
        if(pannelloCentralePartita == null) pannelloCentralePartita = new PannelloCentralePartita();
        return pannelloCentralePartita;
    }

    public void inizializza() {
        setOpaque(false);
        setPreferredSize(new Dimension(500, 500));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // Mazzo.
        gbc.insets = new Insets(0, 0, 75, 230);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(mazzo, gbc);

        // Pila scarti.
        gbc.insets = new Insets(0, 200, 75, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(pilaScarti, gbc);

        // Colore
        gbc.insets = new Insets(0, 205, 350, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(colore, gbc);

        // Verso
        gbc.insets = new Insets(0, 53, 50, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(verso, gbc);

        // Pannello colori
        gbc.insets = new Insets(230, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(colori, gbc);
    }

    /**
     * Imposta il pannello del colore corrente
     * di questa istanza.
     * @param colore Un oggetto JPanel.
     */
    public void setColore(JPanel colore) {
        this.colore = colore;
    }

    /**
     * Imposta il pannello della pila
     * degli scarti di questa istanza.
     * @param pilaScarti Un oggetto JPanel.
     */
    public void setPilaScarti(JPanel pilaScarti) {
        this.pilaScarti = pilaScarti;
    }

    /**
     * Imposta il pannello del mazzo
     * di questa istanza.
     * @param mazzo Un oggetto JPanel.
     */
    public void setMazzo(JPanel mazzo) {
        this.mazzo = mazzo;
    }

    /**
     * Imposta il pannello del verso di
     * questa istanza.
     * @param verso Un oggetto JPanel.
     */
    public void setVerso(JPanel verso) {
        this.verso = verso;
    }

    /**
     * Imposta il pannello dei colori
     * di questa istanza.
     * @param colori Un oggetto JPanel.
     */
    public void setColori(JPanel colori) {
        this.colori = colori;
    }

}