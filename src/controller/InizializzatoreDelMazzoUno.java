package controller;

import model.mazzo.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InizializzatoreDelMazzoUno implements ActionListener {

    private static InizializzatoreDelMazzoUno inizializzatoreDelMazzoUno;

    private InizializzatoreDelMazzoUno() {}

    public static InizializzatoreDelMazzoUno getInizializzatoreDelMazzoUno() {
        if(inizializzatoreDelMazzoUno == null) inizializzatoreDelMazzoUno = new InizializzatoreDelMazzoUno();
        return inizializzatoreDelMazzoUno;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /////////////////////////////////////
        MescolatoreUno mescolatoreUno = MescolatoreUno.getMescolatore();
        ColoreInGioco coloreInGioco = ColoreInGioco.getColoreInGioco();
        RiempitoreUno riempitoreUno = RiempitoreUno.getRiempitore();
        MazzoUno mazzo = MazzoUno.getMazzoUno();
        PilaScartiUno pilaScartiUno = PilaScartiUno.getPilaScartiUno();

        ////////////////////////////////////////////////
        // Impostazione delle classi necessarie.
        riempitoreUno.setPilaScarti(pilaScartiUno);
        riempitoreUno.setMazzo(mazzo);
        mescolatoreUno.setMazzo(mazzo);

        /////////////////////////////////////
        // Connessioni Observer - Observable
        mazzo.addObserver(riempitoreUno);
        riempitoreUno.addObserver(mescolatoreUno);
        pilaScartiUno.addObserver(coloreInGioco);

        ///////////////////////////////////////////
        // Procedura d'inizializzazione del mazzo.
        mazzo.clear();
        MazzoUnoFactory factory = MazzoUnoFactory.getMazzoUnoFactory();
        mazzo.addAll(factory.produciMazzo());
        MescolatoreUno.getMescolatore().mescola(mazzo);
    }

}