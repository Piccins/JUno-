package model.mazzo;

import java.util.ArrayList;
import java.util.List;
import model.carta.Carta;
import utilita.Observable;
import utilita.Observer;

public class RiempitoreUno implements Riempitore<Carta>, Observer, Observable {

	private static RiempitoreUno riempitoreUno;

	private PilaScarti<Carta> pilaScarti;

	private Mazzo<Carta> mazzo;

	private List<Observer> observers;
	
	/**
	 * Costruttore del Riempitore
	 */
	private RiempitoreUno() { 
		observers = new ArrayList<>();
	}
	
	public static RiempitoreUno getRiempitore() {
		if(riempitoreUno==null) riempitoreUno= new RiempitoreUno();
		return riempitoreUno;		
	}

	@Override
	public void riempi() {
		int indiceCartaInCima = pilaScarti.size() - 1;
		Carta cartaAncoraNecessaria  = pilaScarti.get(indiceCartaInCima);
		pilaScarti.remove(indiceCartaInCima);
		mazzo.addAll(pilaScarti);
		pilaScarti.clear();
		pilaScarti.add(cartaAncoraNecessaria);
		updateAll();
	}

	public void setPilaScarti(PilaScarti<Carta> pl) {
		this.pilaScarti=pl;
	}

	public void setMazzo(Mazzo<Carta> mazzo) {
		this.mazzo = mazzo;
	}

	@Override
	public void update(Object o) {		
		if (o instanceof List<?> lista ) {
			// Mappa gli oggetti della lista in oggetti di tipo carta e converte
			// lo stream in una lista di oggetti Carta
			if(lista.size() < 10)
				riempi();
		} else throw new IllegalArgumentException("il tipo in input è errato. Tipo atteso: MazzoUno");
	}

	@Override
	public void addObserver(Observer observer) {
		this.observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		this.observers.remove(observer);		
	}

	@Override
	public void updateAll() {
		for (Observer o : observers) o.update(this);
	}

}