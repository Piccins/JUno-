package controller;

import model.GestoreTurni;
import model.carta.Azione;
import model.carta.Carta;
import model.giocatori.Bot;
import model.giocatori.Giocatore;
import model.mazzo.ColoreInGioco;
import model.mazzo.MazzoUno;
import model.mazzo.PilaScartiUno;
import utilita.Observable;
import utilita.Observer;
import view.centro.PannelloColori;

import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe si occupa di attivare le azioni
 * delle carte quando quest'ultime vengono scartate
 * nella pila degli scarti.
 */
public class AttivatoreAzione implements Observer, Observable {

    private final List<Observer> observers;

    private static AttivatoreAzione attivatoreEffetti;

    private AttivatoreAzione() {
        observers = new ArrayList<>();
    }

    public static AttivatoreAzione getAttivatoreEffetti() {
        if(attivatoreEffetti == null) attivatoreEffetti = new AttivatoreAzione();
        return attivatoreEffetti;
    }

    public void attiva(Carta carta) {
        // Fornitori dei servizi.
        GestoreTurni gestoreTurni = GestoreTurni.getGestoreTurni();
        MazzoUno mazzoUno = MazzoUno.getMazzoUno();
        Giocatore giocatore = gestoreTurni.giocatoreAttuale();
        ColoreInGioco coloreInGioco = ColoreInGioco.getColoreInGioco();

        // Attivazione carta.
        if(carta.getAzione() != null) {
            Azione azione = carta.getAzione();
            switch(azione.toString()) {
                case("CAMBIA_GIRO") -> gestoreTurni.inverti();
                case("SALTA_GIRO")  -> gestoreTurni.saltaGiro();
                case("PESCA_DUE")   -> {
                    gestoreTurni.saltaGiro();
                    gestoreTurni.giocatoreAttuale().add(mazzoUno.pesca());
                    gestoreTurni.giocatoreAttuale().add(mazzoUno.pesca());
                } case("PESCA_QUATTRO") -> {
                    gestoreTurni.saltaGiro();
                    for(int i = 0; i < 4; i++)
                        gestoreTurni.giocatoreAttuale().add(mazzoUno.pesca());
                }
            }

            // Caso carta jolly.
            // Bisogna cambiare il colore
            // Nella classe ColoreInGioco.
            if(carta.getColore().isNero()) {

                // Impostazione del colore
                // Scelto dal bot casualmente.
                if(giocatore instanceof Bot bot) {
                    coloreInGioco.setColore(bot.scegliColore());
                }

                // Turno dell'umano.
                // Impostazione a true della
                // visibilità del pannello dei colori.
                else {
                    PannelloColori.getPannelloColori()
                            .setVisible(true);
                    return;
                }
            }
        }

        // Dopo l'eventuale attivazione dell'effetto della carta
        // si rende necessario passare il turno al giocatore successivo
        // e successivamente aggiornare la classe ManagerPartita.
        gestoreTurni.impostaGiocatoreSuccessivo();
        updateAll();
    }

    @Override
    public void update(Object o) {
        if(o instanceof ControlloreVincita ||
            o instanceof Penitenza) {
            // Attivazione dell'azione dell'ultima
            // carta coinvolta nella pila degli scarti.
            attiva(PilaScartiUno.getPilaScartiUno().peek());
        }

        // Caso non valido.
        else throw new IllegalArgumentException(
                "Tipo dell'oggetto specificato non valido." + o.getClass()
                + ". Atteso ControlloreVincita.");
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void updateAll() {
        for(Observer o : observers) o.update(this);
    }
}