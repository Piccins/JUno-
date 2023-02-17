package view;

import controller.GestoreNickname;
import controller.InizializzatorePartita;
import model.GestoreTurni;
import model.mazzo.ColoreInGioco;
import model.mazzo.PilaScartiUno;
import view.centro.*;
import view.giocatori.PannelloCarteBot1;
import view.giocatori.PannelloCarteBot2;
import view.giocatori.PannelloCarteBot3;
import view.giocatori.PannelloCarteUmano;

public class Inizializzatore {

    private Inizializzatore() {}

    public static void inizializza() {
        //////////////////////
        // Istanze della view.
        Mazzo mazzo = Mazzo.getMazzo();
        Colore colore = Colore.getColore();
        Verso verso = Verso.getVerso();
        PilaScarti pilaScarti = PilaScarti.getPilaScarti();
        PannelloCarteBot1 pannelloCarteBot1 = PannelloCarteBot1.getPannelloCarteBot1();
        PannelloCarteBot2 pannelloCarteBot2 = PannelloCarteBot2.getPannelloCarteBot2();
        PannelloCarteBot3 pannelloCarteBot3 = PannelloCarteBot3.getPannelloCarteBot3();
        PannelloCarteUmano pannelloCarteUmano = PannelloCarteUmano.getPannelloCarteUmano();
        PannelloCentralePartita pannelloCentralePartita = PannelloCentralePartita.getPannelloCentralePartita();
        Partita partita = Partita.getPartita();
        Menu menu = Menu.getMenu();
        CardPannello cardPannello = CardPannello.getCardPannello();
        Sfondo sfondo = Sfondo.getSfondo();
        Finestra finestra = Finestra.getFinestra();
        ///////////////////////////////////////////

        ///////////////////////////////
        // Impostazione della view. //
        menu.setCardPannello(cardPannello);
        cardPannello.setPartita(partita);
        cardPannello.setMenu(menu);
        sfondo.setPannello(cardPannello);
        finestra.setSfondo(sfondo);
        partita.setPannelloCenter(pannelloCentralePartita);
        partita.setPannelloSouth(pannelloCarteUmano);
        partita.setPannelloWest(pannelloCarteBot1);
        partita.setPannelloNorth(pannelloCarteBot2);
        partita.setPannelloEast(pannelloCarteBot3);
        pannelloCentralePartita.setColore(colore);
        pannelloCentralePartita.setPilaScarti(pilaScarti);
        pannelloCentralePartita.setMazzo(mazzo);
        pannelloCentralePartita.setVerso(verso);
        ////////////////////////////////////////

        ///////////////////////////////
        // Inizializzazione della view.
        mazzo.inizializza();
        colore.inizializza();
        pilaScarti.inizializza();
        verso.inizializza();
        menu.inizializza();
        partita.inizializza();
        cardPannello.inizializza();
        sfondo.inizializza();
        finestra.inizializza();
        pannelloCarteBot1.inizializza();
        pannelloCarteBot2.inizializza();
        pannelloCarteBot3.inizializza();
        pannelloCarteUmano.inizializza();
        pannelloCentralePartita.inizializza();
        //////////////////////////////////////

        ///////////////////////////////////////////
        // Collegamenti Observer - Observable.
        ColoreInGioco.getColoreInGioco().addObserver(colore);
        PilaScartiUno.getPilaScartiUno().addObserver(pilaScarti);
        GestoreTurni.getGestoreTurni().addObserver(verso);
        GestoreNickname.getControlloreNickname()
                .addObserver(InizializzatorePartita.getInizializzatorePartita());
    }

}