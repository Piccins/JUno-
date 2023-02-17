package view.giocatori;

import model.giocatori.Bot;
import utilita.Observer;

import javax.swing.*;
import java.awt.*;

/**
 * pannello east bot.
 */
public class PannelloCarteBot1 extends JPanel implements Observer {

    private static PannelloCarteBot1 pannelloCarteBot1;

    private PannelloCarteBot1() {}

    public static PannelloCarteBot1 getPannelloCarteBot1() {
        if(pannelloCarteBot1 == null) pannelloCarteBot1 = new PannelloCarteBot1();
        return pannelloCarteBot1;
    }

    public void inizializza() {
        setOpaque(false);
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.LINE_AXIS);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    @Override
    public void update(Object o) {
        if(o instanceof Bot bot) {
            if(bot.isCartaAggiunta()) {
                JButton cartaGrafica = new JButton();
                ImageIcon imageIcon = new ImageIcon("resources/carte/RETROversoEAST.png");

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

                // Aggiunta della carta.
                add(cartaGrafica);

            } else
                remove(getComponents().length - 1);

            // Sempre dopo aver aggiunto o rimosso
            // componenti dall'interfaccia grafica.
            revalidate();
            repaint();

        } else throw new IllegalArgumentException(
                "Tipo dell'oggetto non valido. Giocatore atteso.");
    }

}