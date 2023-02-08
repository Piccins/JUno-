package Model.Mazzo;

import Model.Carta.Carta;
import Utilita.Observable;
import Utilita.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MescolatoreUno implements Mescolatore<Carta>, Observable, Observer {

    // Il mazzo da mescolare.
    private Mazzo<Carta> mazzo;

    // Lista degli Observer
    private final List<Observer> observers;

    /* Il mescolatore. */
    private static MescolatoreUno mescolatore;

    // Costruttore privato.
    private MescolatoreUno() {
        observers = new ArrayList<>();
    }

    /**
     * Restituisce l'unica instanza di questa classe.
     * @return Un oggetto di tipo Mescolatore.
     */
    public static MescolatoreUno getMescolatore() {
        if(mescolatore == null) mescolatore = new MescolatoreUno();
        return mescolatore;
    }

    /**
     * Imposta il mazzo da mescolare.
     * @param mazzo Un oggetto di tipo Mazzo.
     */
    public void setMazzo(Mazzo<Carta> mazzo) {
        this.mazzo = mazzo;
    }

    @Override
    public void mescola(List<Carta> mazzo) {
        Random r = new Random();
        for(int i = 0; i < 1000; i++) {

            // Prendiamo un valore intero casuale tra
            // 0 e size() - 1.
            int indice = r.nextInt(mazzo.size());

            // Prelevamento della carta e rimozione.
            Carta c = mazzo.get(indice);
            mazzo.remove(c);

            // Introduzione della carta in coda alla lista.
            mazzo.add(c);
        }
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
    public void update(Object o) {
        if(o instanceof Riempitore<?>) {
            mescola(mazzo);
        } else throw new IllegalArgumentException(
               "Il tipo dell'oggetto " + o + " non è valido. "
                       + " Riempitore o ProduttoreMazzo tipo atteso.");
    }

}
