package controller;

import model.carta.Azione;
import model.carta.Carta;
import model.carta.Colore;

import javax.swing.*;
import java.awt.*;

public class CreatoreCartaGrafica {

    private static CreatoreCartaGrafica creatoreCartaGrafica;

    private CreatoreCartaGrafica() {}

    public static CreatoreCartaGrafica getCreatoreCartaGrafica() {
        if(creatoreCartaGrafica == null) creatoreCartaGrafica = new CreatoreCartaGrafica();
        return creatoreCartaGrafica;
    }

    public JButton creaCartaGrafica(Carta carta) {
        JButton cartaGrafica = new JButton();

        // Dati della carta.
        Colore colore = carta.getColore();
        Azione azione = carta.getAzione();
        Integer valore = carta.getValore();

        StringBuilder percorso = new StringBuilder("resources/carte/");

        if(carta.getAzione() == null) {
            percorso.append(colore).append(valore);
        } else {
            percorso.append(colore).append(azione);
        }

        ImageIcon imageIcon = new ImageIcon(percorso.toString() + ".png");

        // Ridimensionamento dell'immagine.
        int larghezza = imageIcon.getIconWidth();
        int lunghezza = imageIcon.getIconHeight();
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(larghezza / 6, lunghezza / 6, Image.SCALE_SMOOTH));

        // Impostazioni del bottone.
        cartaGrafica.setOpaque(false);
        cartaGrafica.setBorderPainted(false);
        cartaGrafica.setContentAreaFilled(false);
        cartaGrafica.setFocusPainted(false);

        cartaGrafica.setIcon(imageIcon);
        return cartaGrafica;
    }

}