package controller;

import model.giocatori.Umano;
import model.mazzo.PilaScartiUno;
import view.CartaGrafica;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScartoAzione implements ActionListener {

    public ScartoAzione() {}

    @Override
    public void actionPerformed(ActionEvent e) {
        CartaGrafica cartaGrafica = (CartaGrafica) e.getSource();

        // Prima di scartare la carta nell pila, la carta viene rimossa
        // dalla mano del giocatore (Umano).
        Umano.getUmano().remove(cartaGrafica.getCarta());

        // Scarta la carta incapsulata nella pila degli scarti.
        PilaScartiUno.getPilaScartiUno().scarta(cartaGrafica.getCarta());
    }

}