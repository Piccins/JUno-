package view;

import javax.swing.*;
import java.awt.*;

public class Finestra extends JFrame {

    private JPanel sfondo;

    private static Finestra finestra;

    private Finestra() {}

    public void inizializza() {
        setLayout(new BorderLayout());
        setName("JUno Serena");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(getToolkit().getScreenSize());
        setMinimumSize(new Dimension(1200, 800));
        add(sfondo, BorderLayout.CENTER);
    }


    public static Finestra getFinestra() {
        if(finestra == null) finestra = new Finestra();
        return finestra;
    }

    public void setSfondo(JPanel sfondo) {
        this.sfondo = sfondo;
    }

}