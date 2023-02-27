package view;

import model.GestoreTurni;

import javax.swing.*;
import java.awt.*;

/**
 * Questa classe definisce un pannello per la
 * mostra del vincitore.
 */
public class PannelloVincitore extends JPanel {

    // Istanza della classe PannelloVincitore.
    private static PannelloVincitore pannelloVincitore;

    // Costruisce l'istanza della classe PannelloVincitore.
    private PannelloVincitore() {}

    /**
     * Restituisce l'istanza della classe PannelloVincitore.
     * @return Un oggetto PannelloVincitore.
     */
    public static PannelloVincitore getPannelloVincitore() {
        if(pannelloVincitore == null) pannelloVincitore = new PannelloVincitore();
        return pannelloVincitore;
    }

    /**
     * Inizializza questa istanza con valori predefiniti.
     */
    public void inizializza() {
        setOpaque(false);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        Font font = new Font(Font.DIALOG, Font.ITALIC, 30);

        // 'Il vincitore è' label.
        JLabel labelVincitore = new JLabel("Il vincitore è: ");
        labelVincitore.setFont(font);
        labelVincitore.setOpaque(false);
        gbc.insets = new Insets(0, 0, 200, 0);
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(labelVincitore, gbc);

        // Bottone exit.
        JButton bottoneExit = new JButton();
        bottoneExit.setText("EXIT");
        bottoneExit.setOpaque(false);
        bottoneExit.setContentAreaFilled(false);
        bottoneExit.setFocusPainted(false);
        bottoneExit.setBorderPainted(false);
        bottoneExit.setFont(font);
        bottoneExit.setPreferredSize(new Dimension( 700, 300));
        bottoneExit.addActionListener(i -> System.exit(0));
        gbc.insets = new Insets(250, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(bottoneExit, gbc);
    }

    /**
     * Aggiunge l'avatar del giocatore in base
     * al nome del vincitore (ovvero il giocatore
     * attuale quando la classe ControlloreVincita
     * rileva il giocatore corrente con zero carte
     * nella mano).
     */
    public void impostaPannelloVincitore() {
        // Fornitore dei dati necessari.
        Partita partita = Partita.getPartita();
        String nome = GestoreTurni.getGestoreTurni()
                .giocatoreAttuale().getNome();

        // Aggiunta dell'avatar in base al
        // nome del giocatore vincente.
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        switch (nome) {
            case ("drago")    -> add(partita.getBotAvatar1(), gbc);
            case ("serpente") -> add(partita.getBotAvatar2(), gbc);
            case ("cavallo")  -> add(partita.getBotAvatar3(), gbc);
            default           -> add(partita.getAvatar(), gbc);
        }

        revalidate();
        repaint();
    }

}