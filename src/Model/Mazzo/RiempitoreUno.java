package Model.Mazzo;

import java.util.ArrayList;
import java.util.List;
import Model.Carta.Carta;
import Utilità.Observable;
import Utilità.Observer;

public class RiempitoreUno implements Riempitore<Carta>, Observer, Observable {

	private static RiempitoreUno riempitoreUno;
	private PilaScarti<Carta> pilaScarti;
<<<<<<< HEAD
=======

	private Mazzo<Carta> mazzo;

>>>>>>> e3a2bf5 (update)
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
<<<<<<< HEAD
	public void riempi(List<Carta> lista) {	
		Carta cartaAncoraNecessaria  = pilaScarti.get(pilaScarti.size()-1);
		pilaScarti.remove(pilaScarti.size()-1);
		lista.addAll(pilaScarti);
		pilaScarti.clear();
		pilaScarti.add(cartaAncoraNecessaria);
=======
	public void riempi() {
		int indiceCartaInCima = pilaScarti.size() - 1;
		Carta cartaAncoraNecessaria  = pilaScarti.get(indiceCartaInCima);
		pilaScarti.remove(indiceCartaInCima);
		mazzo.addAll(pilaScarti);
		pilaScarti.clear();
		pilaScarti.add(cartaAncoraNecessaria);
		updateAll();
>>>>>>> e3a2bf5 (update)
	}

	public void setPilaScarti(PilaScarti<Carta> pl) {
		this.pilaScarti=pl;
	}
<<<<<<< HEAD
=======

	public void setMazzo(Mazzo<Carta> mazzo) {
		this.mazzo = mazzo;
	}
>>>>>>> e3a2bf5 (update)
	
	@Override
	public void update(Object o) {		
		if (o instanceof List<?> lista ) {
<<<<<<< HEAD
			/*
			 * Mappa gli oggetti della lista in oggetti di tipo carta e converte
			 * lo stream in una lista di oggetti Carta
			 */
			if(lista.size() < 10) riempi(lista.stream().map(c->(Carta)c).toList());			
			
			else throw new IllegalArgumentException("il tipo in input è errato. Tipo atteso: MazzoUno");		
		}
=======
			// Mappa gli oggetti della lista in oggetti di tipo carta e converte
			// lo stream in una lista di oggetti Carta
			if(lista.size() < 10)
				riempi();
			
		} else throw new IllegalArgumentException("il tipo in input è errato. Tipo atteso: MazzoUno");
>>>>>>> e3a2bf5 (update)
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
<<<<<<< HEAD
		for (Observer o : observers) { o.update(this); }
=======
		for (Observer o : observers) o.update(this);
>>>>>>> e3a2bf5 (update)
	}
}