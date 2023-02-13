package view;

import model.carta.Carta;

import javax.swing.*;

public class CartaGrafica extends JButton {

    private final Carta carta;

    public CartaGrafica(Carta carta) {
        this.carta = carta;
    }

    public Carta getCarta() {
        return carta;
    }

}