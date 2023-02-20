package view;

import utilita.Observable;
import utilita.Observer;

import java.awt.*;

public class MyCardLayout extends CardLayout implements Observable {

    private String actionCommand;

    public void show(Container container, String actionCommand) {
        this.actionCommand = actionCommand;
        updateAll();
        super.show(container, actionCommand);
    }

    /**
     * Restituisce l'ultimo action command utilizzato
     * per l'invocazione del metodo show().
     * @return Un oggetto String.
     */
    public String getActionCommand() {
        return actionCommand;
    }

    @Override
    public void addObserver(Observer observer) {

    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void updateAll() {

    }
}