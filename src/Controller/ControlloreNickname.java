package Controller;

import Model.Giocatori.Umano;
import Utilita.Observable;
import Utilita.Observer;
import View.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ControlloreNickname implements Observable, ActionListener {

    private final List<Observer> observers;

    private static ControlloreNickname controlloreNickname;

    private ControlloreNickname() {
        this.observers = new ArrayList<>();
    }

    public static ControlloreNickname getControlloreNickname() {
        if(controlloreNickname == null) controlloreNickname = new ControlloreNickname();
        return controlloreNickname;
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

    @Override
    public void actionPerformed(ActionEvent e) {
        Menu menu = Menu.getMenu();
        String nickname = menu.getNickname();
        try {
            Umano.getUmano().setNome(nickname);
            updateAll();
        } catch (RuntimeException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }

}