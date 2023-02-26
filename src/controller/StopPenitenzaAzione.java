package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Questa classe definisce un action listener
 * che permette a un componente grafico di poter
 * interrompere il timer di un oggetto TimerPenitenza.
 */
public class StopPenitenzaAzione implements ActionListener {

    // L'oggetto TimerPenitenza da interrompere.
    private final TimerPenitenza timer;

    /**
     * Costruisce un oggetto StopPenitenzaAzione
     * con l'oggetto TimerPenitenza specificato.
     * @param timer Un oggetto TimerPenitenza.
     */
    public StopPenitenzaAzione(TimerPenitenza timer) {
        this.timer = timer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.timer.stop();
    }

}