package view.giocatori;

import model.ControlloreCartaValida;
import model.GestoreTurni;
import model.giocatori.GestoreGiocatori;
import model.giocatori.Umano;
import model.mazzo.PilaScartiUno;
import utilita.Observer;
import view.CartaGrafica;

import java.awt.*;
import java.util.Arrays;

public class AbilitatoreDelleCarte implements Observer {

    private static AbilitatoreDelleCarte abilitatoreDelleCarte;

    private AbilitatoreDelleCarte() {}

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
        Arrays.asList(components)
                .forEach(c ->
                        c.setEnabled(ControlloreCartaValida.getControlloreCartaValida()
                                .isCompatibile(((CartaGrafica) c).getCarta(), PilaScartiUno.getPilaScartiUno().peek())));
    }

    @Override
    public void update(Object o) {
        if(o instanceof GestoreTurni gestoreTurni) {
            if(gestoreTurni.giocatoreAttuale() == Umano.getUmano())
                abilitaCarteGrafiche(PannelloCarteUmano.getPannelloCarteUmano().getComponents());
            else
                Arrays.asList(PannelloCarteUmano.getPannelloCarteUmano().getComponents()).forEach(c -> c.setEnabled(false));
        } else throw new IllegalArgumentException(
                "Tipo dell'oggetto non valido. Tipo atteso GestoreTurni");
    }

}