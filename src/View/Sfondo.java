package View;

import javax.swing.*;
import java.awt.*;

public class Sfondo extends JLabel {

    private static Sfondo sfondo;

    private Sfondo() {
        setOpaque(true);
        setBackground(new Color(147, 146, 204));
    }

    public static Sfondo getSfondo() {
        if(sfondo == null) sfondo = new Sfondo();
        return sfondo;
    }

}