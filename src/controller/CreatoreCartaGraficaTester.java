package controller;

import model.carta.AzioneUno;
import model.carta.Carta;
import model.carta.CartaUno;
import model.carta.ColoreUno;

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