package Model.Mazzo;

import java.util.List;

import Model.Carta.Carta;
	/**
	 * Il riempitore riempe il mazzo passato in input con le carte salvate su una lista
	 * @param mazzo
	 */
public interface Riempitore<T> {
	
	/**
	 * Riempe la lista specificata in input.
	 * @param mazzo
	 */
	void riempi(List<T> mazzo);
		
}
