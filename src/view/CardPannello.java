package view;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class CardPannello extends JPanel {

    /** ActionCommand del pannello del vincitore. */
    public static final String PANNELLO_VINCITORE = "Vincitore";

    /** ActionCommand del menu */
    public static final String MENU = "Menu";

    /** ActionCommand della partita. */
    public static final String PARTITA = "Partita";

    // Il menu.
    private JPanel menu;

    // La partita
    private JPanel partita;

    // Pannello del vincitore.
    private JPanel pannelloVincitore;

    // Istanza della classe CardPannello.
    private static CardPannello cardPannello;

    /* Costruttore. */
    private  CardPannello() {}

    /**
     * Inizializza
     */
    public void inizializza() {
        setOpaque(false);
        setLayout(new CardLayout());
        add(menu, MENU);
        add(partita, PARTITA);
    }

    /**
     * Restituisce l'unica instanza di questa classe.
     * @return Un oggetto della classe CardPannello.
     */
    public static CardPannello getCardPannello() {
        if(cardPannello == null) cardPannello = new CardPannello();
        return cardPannello;
    }

    /**
     * Imposta il pannello del menu.
     * @param menu Un JPanel.
     */
    public void setMenu(JPanel menu) {
        this.menu = menu;
    }

    /**
     * Imposta il pannello della partita
     * @param partita Un JPanel.
     */
    public void setPartita(JPanel partita) {
        this.partita = partita;
    }

}