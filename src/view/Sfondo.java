package view;

import javax.swing.*;
import java.awt.*;

public class Sfondo extends JPanel {

    private JPanel pannello;

    private static Sfondo sfondo;

    private Sfondo() {}

    public void inizializza() {
        setLayout(new BorderLayout());
        setOpaque(true);
        setBackground(new Color(147, 146, 204));
        add(pannello, BorderLayout.CENTER);
    }

    public static Sfondo getSfondo() {
        if(sfondo == null) sfondo = new Sfondo();
        return sfondo;
    }

    public void setPannello(JPanel pannello) {
        this.pannello = pannello;
    }

}