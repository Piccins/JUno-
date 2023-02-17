package view.centro;

import model.GestoreTurni;
import utilita.Observer;

import javax.swing.*;
import java.awt.*;

public class Verso extends JPanel implements Observer {

    private ImageIcon giro;

    private ImageIcon giroInvertito;

    private boolean invertito = false;

    private JLabel label;

    private static Verso verso;

    private Verso() {}

    public static Verso getVerso() {
        if(verso == null) verso = new Verso();
        return verso;
    }

    public void inizializza() {
        setOpaque(false);
        setLayout(new BorderLayout());

        // Impostazione icone
        giro = new ImageIcon("resources/GIRO.png");
        giroInvertito = new ImageIcon("resources/GIROINVERTITO.png");

        // Impostazione label.
        this.label = new JLabel();
        label.setOpaque(false);
        label.setPreferredSize(new Dimension(133, 150));
        label.setIcon(giro);

        add(label, BorderLayout.CENTER);
    }

    @Override
    public void update(Object o) {
        if(o instanceof GestoreTurni gestoreTurni) {
            if(gestoreTurni.isInvertito())
                inverti();
        } else throw new IllegalArgumentException();
    }

    private void inverti() {
        invertito = !invertito;
        if(invertito) label.setIcon(giroInvertito);
        else label.setIcon(giro);
        revalidate();
        repaint();
    }

}