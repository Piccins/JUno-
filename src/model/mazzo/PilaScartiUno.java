package model.mazzo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import model.ControlloreCartaValida;
import model.carta.Carta;
import utilita.Observable;
import utilita.Observer;

public class PilaScartiUno extends Stack<Carta> implements PilaScarti<Carta>, Observable {

	private Carta carta;
	
	private static PilaScartiUno pilaScartiUno;
	private final List<Observer> Observers;
	
	private PilaScartiUno() {	Observers = new ArrayList<Observer>();	}
	
	public static PilaScartiUno getPilaScartiUno() {
		if (pilaScartiUno == null ) pilaScartiUno = new PilaScartiUno();
		return pilaScartiUno;
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
		for (Observer o: Observers) o.update(this);
	}

	@Override
	public void scarta(Carta carta) {
		// Controllo validità
		// Secondo parametro: carta in cima
		// Primo parametro: carta da controllare.
		if(size() == 0 || ControlloreCartaValida.getControlloreCartaValida()
				.isCompatibile(carta, peek()))
			push(carta);
		else throw new IllegalArgumentException("La carta specificata non è " +
				"compatibile con la carta in cima a questa pila degli scarti.");
		updateAll();
	}

}