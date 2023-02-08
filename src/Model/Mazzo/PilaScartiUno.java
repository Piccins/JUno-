package Model.Mazzo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import Model.Carta.Carta;
import Utilita.Observable;
import Utilita.Observer;

public class PilaScartiUno extends Stack<Carta> implements PilaScarti<Carta>, Observable {
	
	private static PilaScartiUno pilaScartiUno;
	private List<Observer> Observers;
	
	private PilaScartiUno() {	Observers = new ArrayList<Observer>();	}
	
	public static PilaScartiUno getPilaScartiUno() {
		if (pilaScartiUno == null ) pilaScartiUno = new PilaScartiUno();
		return pilaScartiUno; 	}

	
	@Override
	public void addObserver(Observer observer) { 
		
		this.Observers.add(observer);		}

	@Override
	public void removeObserver(Observer observer) {
		this.Observers.remove(observer);
	}

	@Override
	public void updateAll() { for (Observer o: Observers) {	 o.update(this); }	}

	@Override
	public void scarta(Carta carta) {
		push(carta);
		updateAll();
	}

}
