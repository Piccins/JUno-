package view;

import javax.swing.*;
import java.awt.*;

public class Partita extends JPanel {

    private JPanel pannelloSouth;
    private JPanel pannelloNorth;
    private JPanel pannelloWest;
    private JPanel pannelloEast;
    private JPanel pannelloCenter;

    private static Partita partita;

    private Partita() {}

    public static Partita getPartita() {
        if(partita == null) partita = new Partita();
        return partita;
    }

    public void inizializza() {
        setLayout(new BorderLayout());
        setOpaque(false);

        // Impostazione del JScrollPane pannello west.
        JScrollPane scrollPaneWest = new JScrollPane(pannelloWest, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneWest.setOpaque(false);
        scrollPaneWest.setPreferredSize(new Dimension(180, 700));
        scrollPaneWest.setMinimumSize(new Dimension(180, 700));
        scrollPaneWest.setIgnoreRepaint(false);
        scrollPaneWest.getViewport().setOpaque(false);
        scrollPaneWest.setBorder(BorderFactory.createEmptyBorder());

        // Impostazione del JScrollPane pannello east.
        JScrollPane scrollPaneEast = new JScrollPane(pannelloEast, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneEast.setOpaque(false);
        scrollPaneEast.setPreferredSize(new Dimension(180, 700));
        scrollPaneEast.setMinimumSize(new Dimension(180, 700));
        scrollPaneEast.setIgnoreRepaint(false);
        scrollPaneEast.getViewport().setOpaque(false);
        scrollPaneEast.setBorder(BorderFactory.createEmptyBorder());

        // Impostazione del JScrollPane pannello north.
        JScrollPane scrollPanelNorth = new JScrollPane(pannelloNorth, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanelNorth.setOpaque(false);
        scrollPanelNorth.setPreferredSize(new Dimension(700, 180));
        scrollPanelNorth.setMinimumSize(new Dimension(700,180));
        scrollPanelNorth.setIgnoreRepaint(false);
        scrollPanelNorth.getViewport().setOpaque(false);
        scrollPanelNorth.setBorder(BorderFactory.createEmptyBorder());

        // Impostazione del JScrollPane pannello south.
        JScrollPane scrollPaneSouth = new JScrollPane(pannelloSouth, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPaneSouth.setOpaque(false);
        scrollPaneSouth.setPreferredSize(new Dimension(700, 180));
        scrollPaneSouth.setMinimumSize(new Dimension(700, 180));
        scrollPaneSouth.setIgnoreRepaint(false);
        scrollPaneSouth.getViewport().setOpaque(false);
        scrollPaneSouth.setBorder(BorderFactory.createEmptyBorder());

        GridBagConstraints gbc = new GridBagConstraints();

        JPanel panelSouth = new JPanel();
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

        JPanel panelWest = new JPanel();
        panelWest.setOpaque(false);
        panelWest.setLayout(new GridBagLayout());
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        panelWest.add(scrollPaneWest, gbc);

        JPanel panelEast = new JPanel();
        panelEast.setOpaque(false);
        panelEast.setLayout(new GridBagLayout());
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        panelEast.add(scrollPaneEast, gbc);

        JPanel panelNorth = new JPanel();
        panelNorth.setOpaque(false);
        panelNorth.setLayout(new GridBagLayout());
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        panelNorth.add(scrollPanelNorth, gbc);

        // Aggiunta dei pannelli.
        add(pannelloCenter, BorderLayout.CENTER);
        add(panelSouth, BorderLayout.SOUTH);
        add(panelNorth, BorderLayout.NORTH);
        add(panelWest, BorderLayout.WEST);
        add(panelEast, BorderLayout.EAST);
    }

    public void setPannelloSouth(JPanel pannelloSouth) {
        this.pannelloSouth = pannelloSouth;
    }

    public void setPannelloNorth(JPanel pannelloNorth) {
        this.pannelloNorth = pannelloNorth;
    }

    public void setPannelloWest(JPanel pannelloWest) {
        this.pannelloWest = pannelloWest;
    }

    public void setPannelloEast(JPanel pannelloEast) {
        this.pannelloEast = pannelloEast;
    }

    public void setPannelloCenter(JPanel pannelloCenter) {
        this.pannelloCenter = pannelloCenter;
    }

}