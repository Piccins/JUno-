package View;

import javax.swing.*;
import java.awt.*;

public class Finestra extends JFrame {

    private static Finestra finestra;

    private Finestra() {
        setLayout(new BorderLayout());
        setName("JUno Serena");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(getToolkit().getScreenSize());
        setMinimumSize(new Dimension(1200, 800));
        add(Sfondo.getSfondo(), BorderLayout.CENTER);
    };

    public static Finestra getFinestra() {
        if(finestra == null) finestra = new Finestra();
        return finestra;
    }

}