package Model.Mazzo;

import Utilità.ObserverExample;

public class MazzoTester {
	
	public static void main(String[]args ) {
<<<<<<< HEAD
		
		ObserverExample obs = new ObserverExample();	
		MazzoUno mazzo = MazzoUno.getMazzoUno();
		PilaScartiUno pila = PilaScartiUno.getPilaScartiUno();
		pila.addObserver(obs);
		pila.updateAll();
		
		 		
		
		
	}
 
=======
		ObserverExample obs = new ObserverExample();
		PilaScartiUno pila = PilaScartiUno.getPilaScartiUno();
		pila.addObserver(obs);
		pila.updateAll();
	}

>>>>>>> e3a2bf5 (update)
}
