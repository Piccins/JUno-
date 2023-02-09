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

        setPreferredSize(new Dimension(700, 170));
        setMinimumSize(new Dimension(700, 170));

        setIgnoreRepaint(false);
        getViewport().setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder());

        pannello = new JPanel();
        pannello.setOpaque(false);
        pannello.setLayout(new BoxLayout(pannello, BoxLayout.Y_AXIS));

        setPreferredSize(new Dimension(150, 500));
    }

    @Override
    public void update(Object o) {
        if(o instanceof Bot bot) {
            if(bot.isCartaAggiunta()) {
                JLabel cartaGrafica = new JLabel();
                ImageIcon imageIcon = new ImageIcon("resources/carte/RETROversoWEST.png");

                // Ridimensionamento dell'immagine.
                int larghezza = imageIcon.getIconWidth();
                int lunghezza = imageIcon.getIconHeight();
                imageIcon.setImage(imageIcon.getImage().getScaledInstance(larghezza / 6, lunghezza / 6, Image.SCALE_SMOOTH));

                // Impostazioni del bottone.
                cartaGrafica.setOpaque(false);
            } else pannello.remove(pannello.getComponents().length - 1);

            revalidate();
            repaint();

        } else throw new IllegalArgumentException(
                "Tipo dell'oggetto non valido. Giocatore atteso.");
    }

}