import controller.*;
import model.GestoreTurni;
import model.giocatori.GestoreGiocatori;
import model.mazzo.*;
import view.*;
import view.centro.*;
import view.centro.Mazzo;
import view.centro.PilaScarti;
import view.giocatori.*;

public class Inizializzatore {

    private Inizializzatore() {}

    public static void inizializza() {
        //////////////////////
        // Istanze della view.
        EvidenziatoreDelTurno evidenziatoreDelTurno = EvidenziatoreDelTurno.getEvidenziatoreDelTurno();
        PassaTurno passaTurno = PassaTurno.getPassaTurno();
        AttivatoreAzione attivatoreAzione = AttivatoreAzione.getAttivatoreEffetti();
        CardPannello cardPannello = CardPannello.getCardPannello();
        Colore colore = Colore.getColore();
        ColoreInGioco coloreInGioco = ColoreInGioco.getColoreInGioco();
        ControlloreVincita controlloreVincita = ControlloreVincita.getControlloreVincita();
        DistributoreCarte distributoreCarte = DistributoreCarte.getDistributoreCarte();
        Finestra finestra = Finestra.getFinestra();
        GestoreNickname gestoreNickname = GestoreNickname.getControlloreNickname();
        GestoreTurni gestoreTurni = GestoreTurni.getGestoreTurni();
        ImpostaColore impostaColore = ImpostaColore.getImpostaColore();
        InizializzatorePartita inizializzatorePartita = InizializzatorePartita.getInizializzatorePartita();
        ManagerPartita managerPartita = ManagerPartita.getManagerTurni();
        Mazzo mazzo = Mazzo.getMazzo();
        MazzoUno mazzoUno = MazzoUno.getMazzoUno();
        Menu menu = Menu.getMenu();
        MescolatoreUno mescolatoreUno = MescolatoreUno.getMescolatore();
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
        TimerPenitenza timerPenitenza = TimerPenitenza.getTimerPenitenza();
        Penitenza penitenza = Penitenza.getPenitenza();
        Verso verso = Verso.getVerso();
        AbilitatoreDelleCarte abilitatoreDelleCarte = AbilitatoreDelleCarte.getAbilitatoreDelleCarte();
        ///////////////////////////////////////////

        ///////////////////////////////
        // Impostazione della view. //
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
        pannelloCentralePartita.setPassaTurno(passaTurno);
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
        passaTurno.inizializza();
        partita.inizializza();
        pilaScarti.inizializza();
        sfondo.inizializza();
        verso.inizializza();
        //////////////////////////////////////

        ///////////////////////////////////////////
        // Collegamenti Observer - Observable.
        attivatoreAzione.addObserver(managerPartita);
        coloreInGioco.addObserver(colore);
        controlloreVincita.addObserver(attivatoreAzione);
        distributoreCarte.addObserver(managerPartita);
        distributoreCarte.addObserver(pannelloCarteUmano);
        gestoreNickname.addObserver(inizializzatorePartita);
        gestoreNickname.addObserver(partita);
        gestoreTurni.addObserver(abilitatoreDelleCarte);
        gestoreTurni.addObserver(evidenziatoreDelTurno);
        gestoreTurni.addObserver(mazzo);
        gestoreTurni.addObserver(verso);
        impostaColore.addObserver(managerPartita);
        mazzoUno.addObserver(riempitoreUno);
        penitenza.addObserver(attivatoreAzione);
        pilaScartiUno.addObserver(coloreInGioco);
        pilaScartiUno.addObserver(controlloreVincita);
        pilaScartiUno.addObserver(pilaScarti);
        riempitoreUno.addObserver(mescolatoreUno);
        timerPenitenza.addObserver(attivatoreAzione);
        timerPenitenza.addObserver(partita);
    }

}