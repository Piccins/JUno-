import controller.*;
import model.GestoreTurni;
import model.giocatori.GestoreGiocatori;
import model.mazzo.*;
import view.*;
import view.centro.*;
import view.centro.Mazzo;
import view.centro.PilaScarti;
import view.giocatori.PannelloCarteBot1;
import view.giocatori.PannelloCarteBot2;
import view.giocatori.PannelloCarteBot3;
import view.giocatori.PannelloCarteUmano;

public class Inizializzatore {

    private Inizializzatore() {}

    public static void inizializza() {
        //////////////////////
        // Istanze della view.
        AttivatoreAzione attivatoreAzione = AttivatoreAzione.getAttivatoreEffetti();
        CardPannello cardPannello = CardPannello.getCardPannello();
        Colore colore = Colore.getColore();
        ColoreInGioco coloreInGioco = ColoreInGioco.getColoreInGioco();
        ControlloreVincita controlloreVincita = ControlloreVincita.getControlloreVincita();
        DistributoreCarte distributoreCarte = DistributoreCarte.getDistributoreCarte();
        Finestra finestra = Finestra.getFinestra();
        GestoreGiocatori gestoreGiocatori = GestoreGiocatori.getGestoreGiocatori();
        GestoreNickname gestoreNickname = GestoreNickname.getControlloreNickname();
        GestoreTurni gestoreTurni = GestoreTurni.getGestoreTurni();
        ImpostaColore impostaColore = ImpostaColore.getImpostaColore();
        InizializzatorePartita inizializzatorePartita = InizializzatorePartita.getInizializzatorePartita();
        ManagerPartita managerPartita = ManagerPartita.getManagerTurni();
        Mazzo mazzo = Mazzo.getMazzo();
        MazzoUno mazzoUno = MazzoUno.getMazzoUno();
        Menu menu = Menu.getMenu();
        MescolatoreUno mescolatoreUno = MescolatoreUno.getMescolatore();
        MyCardLayout cardLayout = new MyCardLayout();
        PannelloCarteBot1 pannelloCarteBot1 = PannelloCarteBot1.getPannelloCarteBot1();
        PannelloCarteBot2 pannelloCarteBot2 = PannelloCarteBot2.getPannelloCarteBot2();
        PannelloCarteBot3 pannelloCarteBot3 = PannelloCarteBot3.getPannelloCarteBot3();
        PannelloCarteUmano pannelloCarteUmano = PannelloCarteUmano.getPannelloCarteUmano();
        PannelloCentralePartita pannelloCentralePartita = PannelloCentralePartita.getPannelloCentralePartita();
        PannelloColori pannelloColori = PannelloColori.getPannelloColori();
        PannelloVincitore pannelloVincitore = PannelloVincitore.getPannelloVincitore();
        Partita partita = Partita.getPartita();
        PilaScarti pilaScarti = PilaScarti.getPilaScarti();
        PilaScartiUno pilaScartiUno = PilaScartiUno.getPilaScartiUno();
        RiempitoreUno riempitoreUno = RiempitoreUno.getRiempitore();
        Sfondo sfondo = Sfondo.getSfondo();
        Verso verso = Verso.getVerso();
        ///////////////////////////////////////////

        ///////////////////////////////
        // Impostazione della view. //
        cardPannello.setLayoutManager(cardLayout);
        cardPannello.setMenu(menu);
        cardPannello.setPannelloVincitore(pannelloVincitore);
        cardPannello.setPartita(partita);
        finestra.setSfondo(sfondo);
        mescolatoreUno.setMazzo(mazzoUno);
        pannelloCentralePartita.setColore(colore);
        pannelloCentralePartita.setColori(pannelloColori);
        pannelloCentralePartita.setMazzo(mazzo);
        pannelloCentralePartita.setPilaScarti(pilaScarti);
        pannelloCentralePartita.setVerso(verso);
        partita.setPannelloCenter(pannelloCentralePartita);
        partita.setPannelloEast(pannelloCarteBot3);
        partita.setPannelloNorth(pannelloCarteBot2);
        partita.setPannelloSouth(pannelloCarteUmano);
        partita.setPannelloWest(pannelloCarteBot1);
        riempitoreUno.setMazzo(mazzoUno);
        riempitoreUno.setPilaScarti(pilaScartiUno);
        sfondo.setPannello(cardPannello);
        ////////////////////////////////////////

        ///////////////////////////////
        // Inizializzazione della view.
        cardPannello.inizializza();
        colore.inizializza();
        finestra.inizializza();
        mazzo.inizializza();
        menu.inizializza();
        pannelloCarteBot1.inizializza();
        pannelloCarteBot2.inizializza();
        pannelloCarteBot3.inizializza();
        pannelloCarteUmano.inizializza();
        pannelloCentralePartita.inizializza();
        pannelloColori.inizializza();
        pannelloVincitore.inizializza();
        partita.inizializza();
        pilaScarti.inizializza();
        sfondo.inizializza();
        verso.inizializza();
        //////////////////////////////////////

        ///////////////////////////////////////////
        // Collegamenti Observer - Observable.
        attivatoreAzione.addObserver(managerPartita);
        cardLayout.addObserver(pannelloVincitore);
        coloreInGioco.addObserver(colore);
        controlloreVincita.addObserver(attivatoreAzione);
        distributoreCarte.addObserver(managerPartita);
        distributoreCarte.addObserver(pannelloCarteUmano);
        gestoreGiocatori.addObserver(gestoreTurni);
        gestoreNickname.addObserver(inizializzatorePartita);
        gestoreNickname.addObserver(partita);
        gestoreTurni.addObserver(verso);
        pilaScartiUno.addObserver(controlloreVincita);
        pilaScartiUno.addObserver(pilaScarti);
        mazzoUno.addObserver(riempitoreUno);
        riempitoreUno.addObserver(mescolatoreUno);
        pilaScartiUno.addObserver(coloreInGioco);
        impostaColore.addObserver(managerPartita);
    }

}