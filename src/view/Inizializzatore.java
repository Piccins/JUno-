package view;

public class Inizializzatore {

    private Inizializzatore() {}

    public static void inizializza() {
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

        menu.inizializza();
        partita.inizializza();
        cardPannello.inizializza();
        sfondo.inizializza();
        finestra.inizializza();
    }

}