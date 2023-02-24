package view;

import controller.GestoreNickname;
import controller.StopPenitenzaAzione;
import controller.TimerPenitenza;
import utilita.Observer;

import javax.swing.*;
import java.awt.*;

/**
 * Questa classe definisce il pannello della partita.
 */
public class Partita extends JPanel implements Observer {

    private JLabel botAvatar1;

    private JLabel botAvatar2;

    private JLabel botAvatar3;

    private JLabel avatar;

    private JPanel panelSouth;

    // Pannello south della partita.
    private JPanel pannelloSouth;

    // Pannello north della partita.
    private JPanel pannelloNorth;

    // Pannello west della partita.
    private JPanel pannelloWest;

    // Pannello east della partita.
    private JPanel pannelloEast;

    // Pannello centrale della partita.
    private JPanel pannelloCenter;

    // Bottone uno.
    private JButton bottoneUno;

    // Istanza della classe Partita.
    private static Partita partita;

    // Costruttore della classe Partita.
    private Partita() {}

    /**
     * Restituisce l'unica istanza della
     * classe Partita.
     * @return Un oggetto di tipo Partita.
     */
    public static Partita getPartita() {
        if(partita == null) partita = new Partita();
        return partita;
    }

    /**
     * Inizializza questa istanza della classe Partita.
     */
    public void inizializza() {
        setLayout(new BorderLayout());
        setOpaque(false);

        // Impostazione del JScrollPane pannello west.
        JScrollPane scrollPaneWest = new JScrollPane(pannelloWest,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneWest.setOpaque(false);
        scrollPaneWest.setPreferredSize(new Dimension(180, 700));
        scrollPaneWest.setMinimumSize(new Dimension(180, 700));
        scrollPaneWest.setIgnoreRepaint(false);
        scrollPaneWest.getViewport().setOpaque(false);
        scrollPaneWest.setBorder(BorderFactory.createEmptyBorder());

        // Impostazione del JScrollPane pannello east.
        JScrollPane scrollPaneEast = new JScrollPane(pannelloEast,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneEast.setOpaque(false);
        scrollPaneEast.setPreferredSize(new Dimension(180, 700));
        scrollPaneEast.setMinimumSize(new Dimension(180, 700));
        scrollPaneEast.setIgnoreRepaint(false);
        scrollPaneEast.getViewport().setOpaque(false);
        scrollPaneEast.setBorder(BorderFactory.createEmptyBorder());

        // Impostazione del JScrollPane pannello north.
        JScrollPane scrollPanelNorth = new JScrollPane(pannelloNorth,
                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanelNorth.setOpaque(false);
        scrollPanelNorth.setPreferredSize(new Dimension(700, 180));
        scrollPanelNorth.setMinimumSize(new Dimension(700,180));
        scrollPanelNorth.setIgnoreRepaint(false);
        scrollPanelNorth.getViewport().setOpaque(false);
        scrollPanelNorth.setBorder(BorderFactory.createEmptyBorder());

        // Impostazione del JScrollPane pannello south.
        JScrollPane scrollPaneSouth = new JScrollPane(pannelloSouth,
                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPaneSouth.setOpaque(false);
        scrollPaneSouth.setPreferredSize(new Dimension(700, 180));
        scrollPaneSouth.setMinimumSize(new Dimension(700, 180));
        scrollPaneSouth.setIgnoreRepaint(false);
        scrollPaneSouth.getViewport().setOpaque(false);
        scrollPaneSouth.setBorder(BorderFactory.createEmptyBorder());

        GridBagConstraints gbc = new GridBagConstraints();

        // Pannello south.
        panelSouth = new JPanel();
        panelSouth.setOpaque(false);
        panelSouth.setLayout(new GridBagLayout());
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        panelSouth.add(scrollPaneSouth, gbc);
        // Avatar pannello east.
        // Questa pannello dev'essere aggiunto al pannello south nonostante
        // sia attribuibile al giocatore di destra (east) in quanto altrimenti
        // sparirebbe (coperto dal pannello south).
        // Avatar del bot numero tre (East)
        botAvatar3 = new JLabel(new ImageIcon("resources/cavallo.png"));
        botAvatar3.setBorder(BorderFactory.createTitledBorder("cavallo"));
        botAvatar3.setPreferredSize(new Dimension(85, 85));
        gbc.insets = new Insets(0, 1750, 50, 0);
        panelSouth.add(botAvatar3, gbc);
        // Bottone Uno.
        bottoneUno = new JButton();
        bottoneUno.setOpaque(false);
        bottoneUno.setContentAreaFilled(false);
        bottoneUno.setBorderPainted(false);
        bottoneUno.setFocusPainted(false);
        ImageIcon icona = new ImageIcon("resources/UNO.png");
        int larghezza = icona.getIconWidth() / 7;
        int lunghezza = icona.getIconHeight() / 7;
        icona.setImage(icona.getImage()
                .getScaledInstance(larghezza, lunghezza, Image.SCALE_SMOOTH));
        bottoneUno.setIcon(icona);
        bottoneUno.addActionListener(new StopPenitenzaAzione(TimerPenitenza.getTimerPenitenza()));
        gbc.insets = new Insets(0, 950, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        panelSouth.add(bottoneUno, gbc);
        ///////////////////////////////

        // Pannello west. /////////////
        JPanel panelWest = new JPanel();
        panelWest.setOpaque(false);
        panelWest.setLayout(new GridBagLayout());
        // Pannello carte.
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        panelWest.add(scrollPaneWest, gbc);

        // Pannello north. //////////////
        JPanel panelNorth = new JPanel();
        panelNorth.setOpaque(false);
        panelNorth.setLayout(new GridBagLayout());
        // Pannello carte.
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        panelNorth.add(scrollPanelNorth, gbc);
        // Avatar pannello north.
        // Avatar del bot numero 2 (North)
        botAvatar2 = new JLabel(new ImageIcon("resources/serpente.png"));
        botAvatar2.setBorder(BorderFactory.createTitledBorder("serpente"));
        botAvatar2.setPreferredSize(new Dimension(85, 85));
        gbc.insets = new Insets(0, 850, 0, 0);
        panelNorth.add(botAvatar2, gbc);
        ///////////////////////////////
        // Avatar pannello west.
        // Questa pannello dev'essere aggiunto al pannello north nonostante
        // sia attribuibile al giocatore di sinistra (west) in quanto altrimenti
        // sparirebbe (coperto dal pannello north).
        // Avatar del bot numero uno (West)
        botAvatar1 = new JLabel(new ImageIcon("resources/drago.png"));
        botAvatar1.setBorder(BorderFactory.createTitledBorder("drago"));
        botAvatar1.setPreferredSize(new Dimension(85, 85));
        gbc.insets = new Insets(50, 0, 0, 1735);
        panelNorth.add(botAvatar1, gbc);
        ///////////////////////////////

        // Pannello east. //////////////
        JPanel panelEast = new JPanel();
        panelEast.setOpaque(false);
        panelEast.setLayout(new GridBagLayout());
        // Pannello carte.
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        panelEast.add(scrollPaneEast, gbc);

        // Aggiunta dei pannelli.
        add(pannelloCenter, BorderLayout.CENTER);
        add(panelSouth, BorderLayout.SOUTH);
        add(panelNorth, BorderLayout.NORTH);
        add(panelWest, BorderLayout.WEST);
        add(panelEast, BorderLayout.EAST);
    }

    /**
     * Imposta il pannello south di questa istanza.
     * @param pannelloSouth Un oggetto JPanel.
     */
    public void setPannelloSouth(JPanel pannelloSouth) {
        this.pannelloSouth = pannelloSouth;
    }

    /**
     * Imposta il pannello north di questa classe.
     * @param pannelloNorth Un oggetto JPanel.
     */
    public void setPannelloNorth(JPanel pannelloNorth) {
        this.pannelloNorth = pannelloNorth;
    }

    /**
     * Imposta il pannello west di questa istanza.
     * @param pannelloWest Un oggetto JPanel.
     */
    public void setPannelloWest(JPanel pannelloWest) {
        this.pannelloWest = pannelloWest;
    }

    /**
     * Imposta il pannello east di questa istanza.
     * @param pannelloEast Un oggetto JPanel.
     */
    public void setPannelloEast(JPanel pannelloEast) {
        this.pannelloEast = pannelloEast;
    }

    /**
     * Imposta il pannello centrale di questa istanza.
     * @param pannelloCenter Un oggetto JPanel.
     */
    public void setPannelloCenter(JPanel pannelloCenter) {
        this.pannelloCenter = pannelloCenter;
    }


    @Override
    public void update(Object o) {
        if(o instanceof GestoreNickname) {
            // Fornitore dei dati.
            Menu menu = Menu.getMenu();
            // I dati dell'utente.
            ImageIcon icona = menu.getAvatarSelezionato();
            String nome = menu.getNickname();

            // Impostazione dell'avatar dell'utente (pannello south).
            avatar = new JLabel(icona);
            avatar.setPreferredSize(new Dimension(85, 85));
            avatar.setBorder(BorderFactory.createTitledBorder(nome));
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(0, 0, 0, 830);
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.ipadx = 0;
            gbc.ipady = 0;
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 0.0;
            gbc.weighty = 0.0;
            panelSouth.add(avatar, gbc);
        }

        // Impostazione della visibilità del bottone
        // uno quando il giocatore umano ha soltanto una
        // carta nella mano.
        else if(o instanceof TimerPenitenza timerPenitenza) {
            bottoneUno.setVisible(timerPenitenza.isIniziato());
        }

        else throw new IllegalArgumentException(
                "Tipo dell'oggetto non valido: " + o +
                        ". Tipo atteso GestoreNickname oppure TimerPenitenza.");
    }

    public JLabel getBotAvatar1() {
        return botAvatar1;
    }

    public JLabel getBotAvatar2() {
        return botAvatar2;
    }

    public JLabel getBotAvatar3() {
        return botAvatar3;
    }

    public JLabel getAvatar() {
        return avatar;
    }

}