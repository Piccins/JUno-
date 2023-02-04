package View;

import Controller.InizializzatoreDelMazzoUno;

import javax.swing.*;
import java.awt.*;

public class ButtonTest {


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(200, 200));
        button.addActionListener(InizializzatoreDelMazzoUno.getInizializzatoreDelMazzoUno());
        frame.add(button);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}