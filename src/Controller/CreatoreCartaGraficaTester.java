package Controller;

import Model.Carta.AzioneUno;
import Model.Carta.Carta;
import Model.Carta.CartaUno;
import Model.Carta.ColoreUno;

import javax.swing.*;

public class CreatoreCartaGraficaTester {

    public static void main(String[] args) {
        CreatoreCartaGrafica creatoreCartaGrafica = CreatoreCartaGrafica.getCreatoreCartaGrafica();

        Carta carta = new CartaUno(ColoreUno.NERO, null, AzioneUno.PESCAQUATTRO);

        JButton cartaGrafica = creatoreCartaGrafica.creaCartaGrafica(carta);

        JFrame frame = new JFrame();
        frame.add(cartaGrafica);
        frame.pack();
        frame.setVisible(true);
    }

}