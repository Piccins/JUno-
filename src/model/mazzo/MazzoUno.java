package model.mazzo;

import java.util.*;
import model.carta.*;
import utilita.Observable;
import utilita.Observer;

public class MazzoUno extends Stack<Carta> implements Mazzo<Carta>, Observable, FornitoreDellaCartaPescata {

	private final List<Observer> Observers;
	private static MazzoUno mazzoUno;
	private Carta cartaPescata;

	private MazzoUno() {
		Observers = new ArrayList<Observer>();
	}

	/**
	 * Creazione mazzo in Singleton
	 * @return Il mazzo
	 */
	public static MazzoUno getMazzoUno() {
		if (mazzoUno == null) mazzoUno = new MazzoUno();
		return mazzoUno;
	}

	@Override
	public Carta pesca() {
		if(size() == 0) throw new IllegalArgumentException("Deck vuoto");
		cartaPescata = pop();
		updateAll();
		return cartaPescata;
	}

	@Override
	public Carta getCartaPescata() {
		return cartaPescata;
	}

	@Override
	public void addObserver(Observer observer) {
		this.Observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		this.Observers.remove(observer);
	}

	@Override
	public void updateAll() {
		for (Observer o : Observers) o.update(this);
	}

}