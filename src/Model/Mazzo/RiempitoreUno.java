package Model.Mazzo;

import java.util.ArrayList;
import java.util.List;
import Model.Carta.Carta;
import Utilità.Observable;
import Utilità.Observer;

public class RiempitoreUno implements Riempitore<Carta>, Observer, Observable {

	private static RiempitoreUno riempitoreUno;
	private PilaScarti<Carta> pilaScarti;
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
	public void riempi(List<Carta> lista) {	
		Carta cartaAncoraNecessaria  = pilaScarti.get(pilaScarti.size()-1);
		pilaScarti.remove(pilaScarti.size()-1);
		lista.addAll(pilaScarti);
		pilaScarti.clear();
		pilaScarti.add(cartaAncoraNecessaria);
	}

	public void setPilaScarti(PilaScarti<Carta> pl) {
		this.pilaScarti=pl;
	}
	
	@Override
	public void update(Object o) {		
		if (o instanceof List<?> lista ) {
			/*
			 * Mappa gli oggetti della lista in oggetti di tipo carta e converte
			 * lo stream in una lista di oggetti Carta
			 */
			if(lista.size() < 10) riempi(lista.stream().map(c->(Carta)c).toList());			
			
			else throw new IllegalArgumentException("il tipo in input è errato. Tipo atteso: MazzoUno");		
		}
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
		for (Observer o : observers) { o.update(this); }
	}
}