package view;

import controller.CambiaPannello;
import controller.ControlloreNickname;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel {

    private final ButtonGroup gruppoRadio = new ButtonGroup();

    private JPanel cardPannello;

    private final JTextField textField;

    private static Menu menu;

    private Menu() {
        textField = new JTextField(20);
    }

    public void inizializza() {
        setLayout(new GridBagLayout());
        setOpaque(false);
        setPreferredSize(new Dimension(1000, 1000));

        // impostazione del titolo
        JLabel titolo = new JLabel();
        titolo = new JLabel();
        titolo.setIcon(new ImageIcon("resources/titolo.png"));
        titolo.setPreferredSize(new Dimension(834, 137));

        // impostazione nickname
        JLabel nickname = new JLabel();
        nickname = new JLabel();
        nickname.setText("Nickname: ");
        nickname.setFont(new Font(Font.DIALOG, Font.ITALIC, 30));

        // Avatar
        JLabel avatar = new JLabel();
        avatar = new JLabel();
        avatar.setText("Avatar: ");
        avatar.setFont(new Font(Font.DIALOG, Font.ITALIC, 30));

        Border border = BorderFactory.createLineBorder(Color.WHITE, 5, false);

        // Radio cane
        JRadioButton radioCane = new JRadioButton(new ImageIcon("resources/cane.png"));
        radioCane.setBorder(border);
        radioCane.setSelected(true);
        radioCane.setActionCommand("Radio cane");

        // Radio gallo
        JRadioButton radioGallo = new JRadioButton(new ImageIcon("resources/gallo.png"));
        radioGallo.setBorder(null);
        radioGallo.setOpaque(false);
        radioGallo.setActionCommand("Radio gallo");

        // Radio tigre
        JRadioButton radioTigre = new JRadioButton(new ImageIcon("resources/tigre.png"));
        radioTigre.setBorder(null);
        radioTigre.setOpaque(false);
        radioTigre.setActionCommand("Radio tigre");

        class CambiaColore implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton radioButton = (JRadioButton) e.getSource();
                radioButton.setBorder(border);
                radioButton.setOpaque(true);

                String actionCommand = radioButton.getActionCommand();
                if(!radioCane.getActionCommand().equals(actionCommand)) {
                    radioCane.setBorder(null);
                    radioCane.setOpaque(false);
                } if(!radioGallo.getActionCommand().equals(actionCommand)) {
                    radioGallo.setBorder(null);
                    radioGallo.setOpaque(false);
                } if(!radioTigre.getActionCommand().equals(actionCommand)) {
                    radioTigre.setBorder(null);
                    radioTigre.setOpaque(false);
                }
            }

        }

        radioCane.addActionListener(new CambiaColore());
        radioGallo.addActionListener(new CambiaColore());
        radioTigre.addActionListener(new CambiaColore());

        gruppoRadio.add(radioCane);
        gruppoRadio.add(radioGallo);
        gruppoRadio.add(radioTigre);

        // Bottone start.
        JButton start = new JButton("Start");
        start.setFont(new Font(Font.DIALOG, Font.ITALIC, 30));
        start.addActionListener(ControlloreNickname.getControlloreNickname());

        GridBagConstraints gbc = new GridBagConstraints();

        // Titolo
        gbc.insets = new Insets(0, 0, 300, 0);
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(titolo, gbc);

        // Nickname
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(nickname, gbc);

        // Text field
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(textField, gbc);

        // Avatar
        gbc.insets = new Insets(50, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(avatar, gbc);

        // Radio cane
        gbc.insets = new Insets(0, 0, 0, 120);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(radioCane, gbc);

        // Radio gallo
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(radioGallo, gbc);

        // Radio tigre
        gbc.insets = new Insets(0, 120, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(radioTigre, gbc);

        // Start
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(start, gbc);
    }

    public static Menu getMenu() {
        if(menu == null) menu = new Menu();
        return menu;
    }

    /**
     * Imposta il card pannello.
     * @param cardPannello Un JPanel
     */
    public void setCardPannello(JPanel cardPannello) {
        this.cardPannello = cardPannello;
    }

    /**
     * Restituisce il nickname inserito.
     * @return Il nickname.
     */
    public String getNickname() {
        return textField.getText();
    }

    /**
     * Restituisce il comando azione dell'avatar
     * selezionato.
     * @return Una stringa.
     */
    public String getAvatarSelezionato() {
        return gruppoRadio.getSelection().getActionCommand();
    }

}