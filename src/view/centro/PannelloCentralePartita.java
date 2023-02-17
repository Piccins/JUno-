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
        gbc.insets = new Insets(0, 0, 100, 250);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(mazzo, gbc);

        // Pila scarti.
        gbc.insets = new Insets(0, 250, 100, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(pilaScarti, gbc);

        // Colore
        gbc.insets = new Insets(200, 0, 0, 150);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(colore, gbc);

        // Verso
        gbc.insets = new Insets(200, 150, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(verso, gbc);
    }

    public void setColore(JPanel colore) {
        this.colore = colore;
    }

    public void setPilaScarti(JPanel pilaScarti) {
        this.pilaScarti = pilaScarti;
    }

    public void setMazzo(JPanel mazzo) {
        this.mazzo = mazzo;
    }

    public void setVerso(JPanel verso) {
        this.verso = verso;
    }

}