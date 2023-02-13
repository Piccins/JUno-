package view.giocatori;

import model.giocatori.Bot;
import utilita.Observer;

import javax.swing.*;
import java.awt.*;

public class PannelloCarteBot3 extends JPanel implements Observer {

    private static PannelloCarteBot3 pannelloCarteBot3;

    private PannelloCarteBot3() {}

    public static PannelloCarteBot3 getPannelloCarteBot3() {
        if(pannelloCarteBot3 == null) pannelloCarteBot3 = new PannelloCarteBot3();
        return pannelloCarteBot3;
    }

    public void inizializza() {
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    @Override
    public void update(Object o) {
        if(o instanceof Bot bot) {
            if(bot.isCartaAggiunta()) {
                JButton cartaGrafica = new JButton();
                ImageIcon imageIcon = new ImageIcon("resources/carte/RETROversoWEST.png");

                // Ridimensionamento dell'immagine.
                int larghezza = imageIcon.getIconWidth() / 7;
                int lunghezza = imageIcon.getIconHeight() / 7;
                imageIcon.setImage(imageIcon.getImage()
                        .getScaledInstance(larghezza, lunghezza, Image.SCALE_SMOOTH));
                cartaGrafica.setPreferredSize(new Dimension(larghezza, lunghezza));
                cartaGrafica.setIcon(imageIcon);

                // Impostazioni del bottone.
                cartaGrafica.setOpaque(true);
                cartaGrafica.setBorderPainted(false);
                cartaGrafica.setContentAreaFilled(false);
                cartaGrafica.setFocusPainted(false);

                add(cartaGrafica);

            } else remove(getComponents().length - 1);

            revalidate();
            repaint();

        } else throw new IllegalArgumentException(
                "Tipo dell'oggetto non valido. Giocatore atteso.");
    }

}