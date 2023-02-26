package view.centro;

import controller.ImpostaColore;
import model.carta.ColoreUno;

import javax.swing.*;
import java.awt.*;

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
        setLayout(new GridBagLayout());
        setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();

        // Bottoni dei colori.
        ColoreGrafico rosso = new ColoreGrafico(new ImageIcon("resources/ROSSO.png"), ColoreUno.ROSSO);
        ColoreGrafico blu = new ColoreGrafico(new ImageIcon("resources/BLU.png"), ColoreUno.BLU);
        ColoreGrafico giallo = new ColoreGrafico(new ImageIcon("resources/GIALLO.png"), ColoreUno.GIALLO);
        ColoreGrafico verde = new ColoreGrafico(new ImageIcon("resources/VERDE.png"), ColoreUno.VERDE);

        // Impostazione della
        // trasparenza dei bottoni.
        rendiTrasparente(rosso);
        rendiTrasparente(blu);
        rendiTrasparente(giallo);
        rendiTrasparente(verde);
        // Ridimensionamento immagini.
        ridimensiona(rosso);
        ridimensiona(blu);
        ridimensiona(giallo);
        ridimensiona(verde);

        // Ascoltatori.
        ImpostaColore impostaColore = ImpostaColore.getImpostaColore();
        rosso.addActionListener(impostaColore);
        blu.addActionListener(impostaColore);
        giallo.addActionListener(impostaColore);
        verde.addActionListener(impostaColore);

        // Rosso
        gbc.insets = new Insets(0, 330, 0, 0);
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(rosso, gbc);

        // Blu
        gbc.insets = new Insets(0, 100, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(blu, gbc);

        // Giallo
        gbc.insets = new Insets(0, 0, 0, 105);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(giallo, gbc);

        // Verde
        gbc.insets = new Insets(0, 0, 0, 370);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(verde, gbc);

        setVisible(false);
    }

    private void rendiTrasparente(JButton bottone) {
        bottone.setOpaque(false);
        bottone.setContentAreaFilled(false);
        bottone.setBorderPainted(false);
        bottone.setFocusPainted(false);
    }

    private void ridimensiona(JButton bottone) {
        ImageIcon icona = (ImageIcon) bottone.getIcon();
        int larghezza = icona.getIconWidth();
        int lunghezza = icona.getIconHeight();
        ((ImageIcon) bottone.getIcon()).setImage(icona.getImage()
                .getScaledInstance(larghezza / 3, lunghezza / 3, Image.SCALE_SMOOTH));
    }

}