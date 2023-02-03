package Utilità;

import java.util.List;

import Model.Carta.Carta;
import Model.Mazzo.FornitoreDellaCartaPescata;
import Model.Mazzo.Mazzo;
import Model.Mazzo.MazzoUno;

public class ObserverExample implements Observer {
/**
 * o = mazzo 
 */
	
	public static void main(String[] args) {
		ObserverExample obs = new ObserverExample();	
		MazzoUno mazzo = MazzoUno.getMazzoUno();
		mazzo.addObserver(obs);
	}
	
	/**
	 * per ricevere aggiornamenti solo dalle classi che implementano FornitoreClassePescata
	 */
	@Override
	public void update(Object o) {
		if (o instanceof FornitoreDellaCartaPescata mazzo ) { 
		System.out.println("L'ultima carta pescata è:" + mazzo.getCartaPescata());
		}
		else throw new IllegalArgumentException("il tipo in input è errato. Tipo atteso: FornitoreDellaCartaPescata");
	}
	
	
	
	

}
