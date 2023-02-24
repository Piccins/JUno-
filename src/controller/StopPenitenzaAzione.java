package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopPenitenzaAzione implements ActionListener {

    private final TimerPenitenza timer;

    public StopPenitenzaAzione(TimerPenitenza timer) {
        this.timer = timer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.timer.stop();
    }

}