package View;

import javax.swing.*;

public class FinestraTester {

    public static void main(String[] args) {
        Inizializzatore.inizializza();
        Finestra finestra = Finestra.getFinestra();
        finestra.setVisible(true);
    }
}
