package controller;

import model.GestoreTurni;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Questa classe definisce un'azione passa turno
 * per il gioco di carte uno.
 */
public class PassaTurnoAzione implements ActionListener {

    public PassaTurnoAzione() {}

    @Override
    public void actionPerformed(ActionEvent e) {
        // Il bottone che fa passare il turno
        // viene reso invisibile dopo la sua
        // pressione.
        JButton bottone = (JButton) e.getSource();
        bottone.getParent().setVisible(false);

        // Impostazione del giocatore successivo.
        GestoreTurni gestoreTurni = GestoreTurni.getGestoreTurni();
        gestoreTurni.impostaGiocatoreSuccessivo();

        // Esecuzione del manager dei turni.
        ManagerPartita.getManagerTurni().getTimer().start();
    }

}