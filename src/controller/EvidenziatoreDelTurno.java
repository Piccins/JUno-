package controller;

import model.GestoreTurni;
import model.giocatori.Giocatore;
import utilita.Observer;
import view.Partita;

import javax.swing.*;

public class EvidenziatoreDelTurno implements Observer {

    private JPanel pannelloGiocatoreCorrente;

    private static EvidenziatoreDelTurno evidenziatoreDelTurno;

    private EvidenziatoreDelTurno() {}

    public static EvidenziatoreDelTurno getEvidenziatoreDelTurno() {
        if(evidenziatoreDelTurno == null) evidenziatoreDelTurno = new EvidenziatoreDelTurno();
        return evidenziatoreDelTurno;
    }

    @Override
    public void update(Object o) {
        if(o instanceof GestoreTurni gestoreTurni) {
            if(pannelloGiocatoreCorrente != null)
                pannelloGiocatoreCorrente.setOpaque(false);
            Giocatore giocatore = gestoreTurni.giocatoreAttuale();
            Partita partita = Partita.getPartita();
            switch (giocatore.getNome()) {
                case("drago")    -> pannelloGiocatoreCorrente = partita.getPannelloAvatar1();
                case("serpente") -> pannelloGiocatoreCorrente = partita.getPannelloAvatar2();
                case("cavallo")  -> pannelloGiocatoreCorrente = partita.getPannelloAvatar3();
                default          -> pannelloGiocatoreCorrente = partita.getPannelloAvatarUmano();
            }
            pannelloGiocatoreCorrente.setOpaque(true);
            partita.revalidate();
            partita.repaint();
        } else throw new IllegalArgumentException(
                "Tipo dell'oggetto specificato non valido: " + o.getClass() +
                        ". Tipo atteso GestoreTurni.");
    }

}