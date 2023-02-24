package view;

import controller.DistributoreCarte;
import controller.GestoreNickname;
import controller.ImpostaColore;
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
        MyCardLayout cardLayout = new MyCardLayout();
        PannelloVincitore pannelloVincitore = PannelloVincitore.getPannelloVincitore();
        Mazzo mazzo = Mazzo.getMazzo();
        Colore colore = Colore.getColore();
        PannelloColori pannelloColori = PannelloColori.getPannelloColori();
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
        DistributoreCarte distributoreCarte = DistributoreCarte.getDistributoreCarte();
        GestoreNickname gestoreNickname = GestoreNickname.getControlloreNickname();
        PilaScartiUno pilaScartiUno = PilaScartiUno.getPilaScartiUno();
        GestoreTurni gestoreTurni = GestoreTurni.getGestoreTurni();
        ColoreInGioco coloreInGioco = ColoreInGioco.getColoreInGioco();
        InizializzatorePartita inizializzatorePartita = InizializzatorePartita.getInizializzatorePartita();
        ImpostaColore impostaColore = ImpostaColore.getImpostaColore();
        ///////////////////////////////////////////

        ///////////////////////////////
        // Impostazione della view. //
        cardPannello.setLayoutManager(cardLayout);
        cardPannello.setPartita(partita);
        cardPannello.setMenu(menu);
        cardPannello.setPannelloVincitore(pannelloVincitore);
        sfondo.setPannello(cardPannello);
        finestra.setSfondo(sfondo);
        partita.setPannelloCenter(pannelloCentralePartita);
        partita.setPannelloSouth(pannelloCarteUmano);
        partita.setPannelloWest(pannelloCarteBot1);
        partita.setPannelloNorth(pannelloCarteBot2);
        partita.setPannelloEast(pannelloCarteBot3);
        pannelloCentralePartita.setColore(colore);
        pannelloCentralePartita.setColori(pannelloColori);
        pannelloCentralePartita.setPilaScarti(pilaScarti);
        pannelloCentralePartita.setMazzo(mazzo);
        pannelloCentralePartita.setVerso(verso);
        ////////////////////////////////////////

        ///////////////////////////////
        // Inizializzazione della view.
        mazzo.inizializza();
        colore.inizializza();
        pannelloColori.inizializza();
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
        pannelloVincitore.inizializza();
        //////////////////////////////////////

        ///////////////////////////////////////////
        // Collegamenti Observer - Observable.
        coloreInGioco.addObserver(colore);
        pilaScartiUno.addObserver(pilaScarti);
        gestoreTurni.addObserver(verso);
        gestoreNickname.addObserver(inizializzatorePartita);
        gestoreNickname.addObserver(partita);
        cardLayout.addObserver(pannelloVincitore);
        distributoreCarte.addObserver(pannelloCarteUmano);

        // Aggiungere il cambiatore dei turni.
        impostaColore.addObserver(null);
    }

}