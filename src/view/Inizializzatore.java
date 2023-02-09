package view;

import controller.ControlloreNickname;
import controller.InizializzatorePartita;
import model.giocatori.Bot;
import model.giocatori.GestoreGiocatori;
import model.giocatori.Giocatore;
import view.giocatori.PannelloCarteBot1;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Inizializzatore {

    private Inizializzatore() {}

    public static void inizializza() {
        // VIEW

        // Pannelli dei giocatori.
        PannelloCarteBot1 pannelloCarteBot1 = PannelloCarteBot1.getPannelloCarteBot1();

        Partita partita = Partita.getPartita();
        Menu menu = Menu.getMenu();
        CardPannello cardPannello = CardPannello.getCardPannello();
        Sfondo sfondo = Sfondo.getSfondo();
        Finestra finestra = Finestra.getFinestra();

        menu.setCardPannello(cardPannello);
        cardPannello.setPartita(partita);
        cardPannello.setMenu(menu);
        sfondo.setPannello(cardPannello);
        finestra.setSfondo(sfondo);

        partita.setPannelloEast(pannelloCarteBot1);
        partita.setPannelloWest(new JPanel());
        partita.setPannelloNorth(new JPanel());
        partita.setPannelloSouth(new JPanel());
        partita.setPannelloCenter(new JPanel());

        menu.inizializza();
        partita.inizializza();
        cardPannello.inizializza();
        sfondo.inizializza();
        finestra.inizializza();

        pannelloCarteBot1.inizializza();

        // CONTROLLER.

        ControlloreNickname.getControlloreNickname()
                .addObserver(InizializzatorePartita.getInizializzatorePartita());
    }

}