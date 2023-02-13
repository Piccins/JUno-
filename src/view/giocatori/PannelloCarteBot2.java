package view.giocatori;

import model.giocatori.Bot;
import utilita.Observer;

import javax.swing.*;
import java.awt.*;

public class PannelloCarteBot2 extends JPanel implements Observer {

    private static PannelloCarteBot2 pannelloCarteBot2;

    private PannelloCarteBot2() {}

    public static PannelloCarteBot2 getPannelloCarteBot2() {
        if(pannelloCarteBot2 == null) pannelloCarteBot2 = new PannelloCarteBot2();
        return pannelloCarteBot2;
    }

    public void inizializza() {
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    }

    @Override
    public void update(Object o) {
        if(o instanceof Bot bot) {
            if(bot.isCartaAggiunta()) {
                JButton cartaGrafica = new JButton();
                ImageIcon imageIcon = new ImageIcon("resources/carte/RETROversoSOUTH.png");

                // Ridimensionamento dell'immagine.
                int larghezza = imageIcon.getIconWidth() / 7;
                int lunghezza = imageIcon.getIconHeight() / 7;
                imageIcon.setImage(imageIcon.getImage()
                        .getScaledInstance(larghezza, lunghezza, Image.SCALE_SMOOTH));

                // Impostazioni del bottone.
                cartaGrafica.setOpaque(true);
                cartaGrafica.setBorderPainted(false);
                cartaGrafica.setContentAreaFilled(false);
                cartaGrafica.setFocusPainted(false);
                cartaGrafica.setPreferredSize(new Dimension(larghezza, lunghezza));
                cartaGrafica.setIcon(imageIcon);

                add(cartaGrafica);

            } else remove(getComponents().length - 1);

            revalidate();
            repaint();

        } else throw new IllegalArgumentException(
                "Tipo dell'oggetto non valido. Giocatore atteso.");
    }
}
