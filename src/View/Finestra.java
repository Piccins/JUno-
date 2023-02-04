package View;

import javax.swing.*;
import java.awt.*;

public class Finestra extends JFrame {

    private static Finestra finestra;

    private Finestra() {
        setName("JUno Serena");
        // setUndecorated(true);
        // setBackground(new Color(147, 146, 204));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(getToolkit().getScreenSize());
        // setSize(new Dimension(500, 500));
        add(Sfondo.getSfondo());
    };

    public static Finestra getFinestra() {
        if(finestra == null) finestra = new Finestra();
        return finestra;
    }

}