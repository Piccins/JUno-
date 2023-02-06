package Controller;

import View.CardPannello;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CambiaPannello implements ActionListener {

    private JPanel pannello;

    private String actionCommand;

    public CambiaPannello(JPanel pannello, String actionCommand) {
        this.pannello = pannello;
        this.actionCommand = actionCommand;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(pannello.getLayout() instanceof CardLayout cardLayout) {
            cardLayout.show(pannello, actionCommand);
        } else throw new IllegalArgumentException();
    }

}