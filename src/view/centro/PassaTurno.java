package view.centro;

import controller.PassaTurnoAzione;

import javax.swing.*;
import java.awt.*;

/**
 * Questa classe definisce il pannello
 * nella quale è contenuto il bottone
 * per permette all'utente di passare
 * il turno al giocatore successivo quando
 * egli pesca una carta e non può/non vuole
 * giocarla.
 */
public class PassaTurno extends JPanel {

    // L'istanza PassaTurno.
    private static PassaTurno passaTurno;

    // Costruisce l'istanza PassaTurno.
    private PassaTurno() {}

    /**
     * Restituisce l'istanza della classe PassaTurno.
     * @return Un oggetto PassaTurno.
     */
    public static PassaTurno getPassaTurno() {
        if(passaTurno == null) passaTurno = new PassaTurno();
        return passaTurno;
    }

    /**
     * Inizializza questa istanza a valori di default.
     */
    public void inizializza() {
        setOpaque(false);
        setLayout(new BorderLayout());
        setVisible(false);

        // Impostazione del bottone passa turno.
        JButton bottone = new JButton();
        bottone.setText("PASSA");
        bottone.setFont(new Font(Font.DIALOG, Font.ITALIC, 30));
        bottone.setForeground(Color.WHITE);
        bottone.setPreferredSize(new Dimension(200, 75));
        bottone.setOpaque(false);
        bottone.setContentAreaFilled(false);
        bottone.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        bottone.setFocusPainted(false);
        bottone.addActionListener(new PassaTurnoAzione());

        // Aggiunta del componente.
        add(bottone, BorderLayout.CENTER);
    }

}