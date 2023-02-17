package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Questa classe definisce oggetto CambiaPannello
 * che permetto di visualizzare un differente pannello
 * specificando un comando azione e un pannello il cui
 * layout manager è un CardLayout.
 */
public class CambiaPannello implements ActionListener {

    // Un oggetto JPanel il cui layout manager
    // è CardLayout.
    private final JPanel pannello;

    // Il comando azione per determinare il pannello
    // da visualizzare.
    private final String actionCommand;

    /**
     * Costruisce un oggetto CambiaPannello
     * con l'oggetto JPanel e l'oggetto String
     * specificati. L'oggetto String dev'essere
     * il comando azione da utilizzare per
     * comunicare al layout manager CardLayout
     * del JPanel specificato quale pannello visualizzare.
     * @param pannello Un oggetto JPanel.
     * @param actionCommand Un oggetto String.
     */
    public CambiaPannello(JPanel pannello, String actionCommand) {
        this.pannello = pannello;
        this.actionCommand = actionCommand;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(pannello.getLayout() instanceof CardLayout cardLayout) {
            cardLayout.show(pannello, actionCommand);
        } else throw new IllegalArgumentException(
                "Il layout manager dell'oggetto " + pannello.getName() +
                        "dev'essere di tipo CardLayout.");
    }

}