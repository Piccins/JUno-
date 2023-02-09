package view.giocatori;

import controller.CreatoreCartaGrafica;
import model.giocatori.Bot;
import model.giocatori.Giocatore;
import utilita.Observer;

import javax.swing.*;
import java.awt.*;

/**
 * pannello east bot.
 */
public class PannelloCarteBot1 extends JScrollPane implements Observer {

    private JPanel pannello;

    private static PannelloCarteBot1 pannelloCarteBot1;

    private PannelloCarteBot1() {}

    public static PannelloCarteBot1 getPannelloCarteBot1() {
        if(pannelloCarteBot1 == null) pannelloCarteBot1 = new PannelloCarteBot1();
        return pannelloCarteBot1;
    }

    public void inizializza() {
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        setOpaque(false);

        pannello = new JPanel();
        pannello.setLayout(new BoxLayout(pannello, BoxLayout.Y_AXIS));

        setPreferredSize(new Dimension(150, 600));
    }

    @Override
    public void update(Object o) {
        if(o instanceof Bot bot) {
            if(bot.isCartaAggiunta()) {
                JButton cartaGrafica = CreatoreCartaGrafica.getCreatoreCartaGrafica()
                        .creaCartaGrafica(bot.getCarta());
                pannello.add(cartaGrafica);
            } else {
                // carta rimossa.
            }
        } else throw new IllegalArgumentException(
                "Tipo dell'oggetto non valido. Giocatore atteso.");
    }

}