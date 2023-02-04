package Model.Mazzo;

import java.util.*;
import Model.Carta.*;
import Utilità.Observable;
import Utilità.Observer;

<<<<<<< HEAD
public class MazzoUno extends Stack<Carta> implements Mazzo<Carta>, Observable, FornitoreDellaCartaPescata{
=======
public class MazzoUno extends Stack<Carta> implements Mazzo<Carta>, Observable, FornitoreDellaCartaPescata, Observer{
>>>>>>> e3a2bf5 (update)

	private List<Observer> Observers;
	private static MazzoUno mazzoUno;
	private Carta cartaPescata;
	
	private MazzoUno() { 
		Observers = new ArrayList<Observer>();	}
	
	/**
	 * Creazione mazzo in Singleton
	 * @return
	 */
	public static MazzoUno getMazzoUno() { 
		if (mazzoUno == null) mazzoUno = new MazzoUno();
		return mazzoUno; }
			
	@Override
	public Carta pesca() {
<<<<<<< HEAD
		updateAll();
		cartaPescata=pop();
		return cartaPescata; 
=======
		cartaPescata=pop();
		updateAll();
		return cartaPescata;
>>>>>>> e3a2bf5 (update)
	}
	
	@Override
	public Carta getCartaPescata() {return cartaPescata;}
	

	@Override
	public void addObserver(Observer observer) { 
		
		this.Observers.add(observer);		
	}

	@Override
	public void removeObserver(Observer observer) {

		this.Observers.remove(observer);		
	}

	@Override
<<<<<<< HEAD
	public void updateAll() { 
		for (Observer o: Observers) {	 
			o.update(this); }	}

	}
=======
	public void updateAll() {
		for (Observer o: Observers) {
			o.update(this); }	}

	@Override
	public void update(Object o) {
		if(o instanceof MazzoFactory<?> factory) {
			factory.produciMazzo();
		}
	}
}
>>>>>>> e3a2bf5 (update)
