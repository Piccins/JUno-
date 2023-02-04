package View;

import javax.swing.*;
import java.awt.*;

public class Sfondo extends JPanel {

    private static Sfondo sfondo;

    private Sfondo() {
        setLayout(new BorderLayout());
        setOpaque(true);
        setBackground(new Color(147, 146, 204));
        add(Menu.getMenu(), BorderLayout.CENTER);
    }

    public static Sfondo getSfondo() {
        if(sfondo == null) sfondo = new Sfondo();
        return sfondo;
    }

}