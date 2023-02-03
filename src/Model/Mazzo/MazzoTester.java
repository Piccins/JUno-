package Model.Mazzo;

import Utilità.ObserverExample;

public class MazzoTester {
	
	public static void main(String[]args ) {
		
		ObserverExample obs = new ObserverExample();	
		MazzoUno mazzo = MazzoUno.getMazzoUno();
		PilaScartiUno pila = PilaScartiUno.getPilaScartiUno();
		pila.addObserver(obs);
		pila.updateAll();
		
		 		
		
		
	}
 
}
