package view.centro;

import model.carta.Colore;

import javax.swing.*;

public class ColoreGrafico extends JButton {

    private final Colore colore;

    public ColoreGrafico(Icon icona, Colore colore) {
        super(icona);
        this.colore = colore;
    }

    public Colore getColore() {
        return colore;
    }

}