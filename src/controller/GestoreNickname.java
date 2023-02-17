package controller;

import model.giocatori.Umano;
import utilita.Observable;
import utilita.Observer;
import view.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe definisce un gestore
 * per il nickname inserito dall'utente.
 * Se il nome utente inserito dall'utente non
 * è stato ritenuto valido dalla classe Umano
 * (che si occupa di controllarlo ed eventualmente
 * impostarlo), viene visualizzato un messaggio di
 * errore nell'applicazione che permette all'utente
 * dell'applicazione di conoscere la causa della
 * invalidità del dato inserito. Nel caso in cui
 * il dato inserito dall'utente è stato ritenuto
 * corretto, viene eseguito un aggiornamento che
 * permette d'impostare i dati richiesti per eseguire
 * la partita.
 */
public class GestoreNickname implements Observable, ActionListener {

    // Gli osservatori di questa istanza.
    private final List<Observer> observers;

    // L'istanza della classe ControlloreNickname.
    private static GestoreNickname controlloreNickname;

    // Costruisce l'istanza della classe ControlloNickname.
    private GestoreNickname() {
        this.observers = new ArrayList<>();
    }

    /**
     * Restituisce l'istanza della classe ControlloreNickname.
     * @return Un oggetto della classe Nickname.
     */
    public static GestoreNickname getControlloreNickname() {
        if(controlloreNickname == null) controlloreNickname = new GestoreNickname();
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
        // Il dato da impostare.
        String nickname = menu.getNickname();
        try {
            // Tentativo d'impostazione del
            // dato inserito dell'utente.
            Umano.getUmano().setNome(nickname);

            // Quest'aggiornamento automatizza il procedimento
            // d'impostazione della partita. Se questa
            // istruzione viene eseguita, il nickname è
            // sicuramente stato accettato della classe Umano.
            updateAll();

        } catch (RuntimeException exception) {
            // Visualizzazione sul terminale dello stack trace
            // e del messaggio di errore per l'utente dell'applicazione.
            // Accade quando il nome inserito dall'utente ha una
            // lunghezza uguale a zero oppure superiore a venti.
            exception.printStackTrace();
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }

}