package controller;

import model.carta.Colore;
import model.mazzo.ColoreInGioco;
import utilita.Observable;
import utilita.Observer;
import view.centro.ColoreGrafico;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe definisce oggetti ImpostaColore,
 * ovvero oggetti che permettono d'impostare uno
 * specifico colore nella classe ColoreInGioco.
 * Tali oggetti vengono inseriti nella lista degli
 * ascoltatori dei bottoni nell'interfaccia grafica
 * della partita per permettere all'utente dell'applicazione
 * di scegliere quale colore impostare quando egli
 * scarta una carta jolly.
 */
public class ImpostaColore implements ActionListener, Observable {

    private final List<Observer> observers;

    private static ImpostaColore impostaColore;

    private ImpostaColore() {
        observers = new ArrayList<>();
    }

    public static ImpostaColore getImpostaColore() {
        if(impostaColore == null) impostaColore = new ImpostaColore();
        return impostaColore;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // impostazione del colore nella classe che si occupa
        // della gestione del colore in gioco.
        if(e.getSource() instanceof ColoreGrafico coloreGrafico) {
            Colore colore = coloreGrafico.getColore();
            ColoreInGioco coloreInGioco = ColoreInGioco.getColoreInGioco();
            coloreInGioco.setColore(colore);
            JButton button = (JButton) e.getSource();
            button.getParent().setVisible(false);

            // Dopo aver impostato il colore è finalmente
            // possibile passare il turno al giocatore
            // successivo.
            updateAll();
        } else throw new IllegalArgumentException(
                "La sorgente di quest'evento dov'essere un oggetto" +
                        " di tipo ColoreGrafico.");
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void updateAll() {
        for(Observer o : observers) o.update(this);
    }
}