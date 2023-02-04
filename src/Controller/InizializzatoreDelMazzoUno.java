package Controller;

import Model.Mazzo.MazzoUno;
import Model.Mazzo.MazzoUnoFactory;
import Model.Mazzo.MescolatoreUno;

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
        MazzoUno mazzo = MazzoUno.getMazzoUno();
        mazzo.clear();
        MazzoUnoFactory factory = MazzoUnoFactory.getMazzoUnoFactory();
        mazzo.addAll(factory.produciMazzo());
        MescolatoreUno.getMescolatore().mescola(mazzo);
    }

}