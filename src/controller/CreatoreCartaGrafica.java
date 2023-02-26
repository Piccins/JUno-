package controller;

import model.carta.Azione;
import model.carta.Carta;
import model.carta.Colore;
import view.CartaGrafica;

import javax.swing.*;
import java.awt.*;

public class CreatoreCartaGrafica {

    private static CreatoreCartaGrafica creatoreCartaGrafica;

    private CreatoreCartaGrafica() {}

    public static CreatoreCartaGrafica getCreatoreCartaGrafica() {
        if(creatoreCartaGrafica == null) creatoreCartaGrafica = new CreatoreCartaGrafica();
        return creatoreCartaGrafica;
    }

    public CartaGrafica creaCartaGrafica(Carta carta) {
        CartaGrafica cartaGrafica = new CartaGrafica(carta);

        // Dati della carta.
        Colore colore = carta.getColore();
        Azione azione = carta.getAzione();
        Integer valore = carta.getValore();

        StringBuilder percorso = new StringBuilder("resources/carte/");

        if(carta.getAzione() == null)
            percorso.append(colore).append(valore);
        else
            percorso.append(colore).append(azione);

        ImageIcon imageIcon = new ImageIcon(percorso + ".png");

        // Ridimensionamento dell'immagine.
        int larghezza = imageIcon.getIconWidth() / 7;
        int lunghezza = imageIcon.getIconHeight() / 7;
        imageIcon.setImage(imageIcon.getImage()
                .getScaledInstance(larghezza, lunghezza, Image.SCALE_SMOOTH));

        // Impostazioni del bottone.
        cartaGrafica.setPreferredSize(new Dimension(larghezza, lunghezza));
        cartaGrafica.setOpaque(false);
        cartaGrafica.setBorderPainted(false);
        cartaGrafica.setContentAreaFilled(false);
        cartaGrafica.setFocusPainted(false);
        cartaGrafica.setIcon(imageIcon);
        cartaGrafica.setDisabledIcon(imageIcon);

        return cartaGrafica;
    }

}