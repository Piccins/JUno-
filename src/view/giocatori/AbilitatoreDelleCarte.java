package view.giocatori;

import model.ControlloreCartaValida;
import model.GestoreTurni;
import model.giocatori.Umano;
import model.mazzo.PilaScartiUno;
import utilita.Observer;
import view.CartaGrafica;

import java.awt.*;
import java.util.Arrays;

/**
 * Questa classe definisce un abilitatore delle carte
 * del giocatore umano (l'utente dell'applicazione).
 * Mediante l'applicazione del patter Observer/Observable
 * vengono automaticamente abilitati i bottoni rappresentanti
 * le carte compatibili con la carta in cima alla pila degli
 * scarti quando è il turno del giocatore umano.
 * Ogni volta che il turno viene cambiato, questa classe viene
 * aggiornata. Se, dopo aver ricevuto l'aggiornamento, il turno
 * del giocatore corrente non è quello del giocatore umano,
 * tutte le carte del giocatore umano vengono disabilitate.
 */
public class AbilitatoreDelleCarte implements Observer {

    // L'istanza della classe AbilitatoreDelleCarte.
    private static AbilitatoreDelleCarte abilitatoreDelleCarte;

    // Costruisce l'istanza della classe AbilitatoreDelleCarte.
    private AbilitatoreDelleCarte() {}

    /**
     * Restituisce l'istanza della classe AbilitatoreDelleCarte.
     * @return L'unica istanza della classe AbilitatoreDelleCarte.
     */
    public static AbilitatoreDelleCarte getAbilitatoreDelleCarte() {
        if(abilitatoreDelleCarte == null) abilitatoreDelleCarte = new AbilitatoreDelleCarte();
        return abilitatoreDelleCarte;
    }

    /**
     * Abilita le carte compatibili contenuto all'interno dell'array
     * specificato.
     * @param components Un array
     */
    public void abilitaCarteGrafiche(Component[] components) {
        // Per ogni componente (JButton a tempo di esecuzione) viene
        // abilitato se, e soltanto se, il controllore di compatibilità
        // restituisce il valore booleano true dopo aver effettuato
        // il controllo con la carta in cima alla pila degli scarti.
        Arrays.asList(components)
                .forEach(c ->
                        c.setEnabled(ControlloreCartaValida.getControlloreCartaValida()
                                // Il primo argomento del metodo 'isCompatibile()' deve essere la carta
                                // da controllare. Il secondo invece dev'essere la carta in cima alla
                                // pila degli scarti.
                                .isCompatibile(((CartaGrafica) c).getCarta(), PilaScartiUno.getPilaScartiUno().peek())));
    }

    @Override
    public void update(Object o) {
        if(o instanceof GestoreTurni gestoreTurni) {
            if(gestoreTurni.giocatoreAttuale() == Umano.getUmano())
                // Abilitazione delle carte compatibili (turno dell'utente dell'applicazione).
                abilitaCarteGrafiche(PannelloCarteUmano.getPannelloCarteUmano().getComponents());
            else
                // Non è il turno dell'utente dell'applicazione.
                Arrays.asList(PannelloCarteUmano.getPannelloCarteUmano().getComponents()).forEach(c -> c.setEnabled(false));
        } else throw new IllegalArgumentException(
                "Tipo dell'oggetto non valido. Tipo atteso GestoreTurni");
    }

}