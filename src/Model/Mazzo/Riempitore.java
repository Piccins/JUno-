package Model.Mazzo;

import java.util.List;

<<<<<<< HEAD
import Model.Carta.Carta;
	/**
	 * Il riempitore riempe il mazzo passato in input con le carte salvate su una lista
	 * @param mazzo
	 */
=======
/**
 * Questa interfaccia definisce riempitori generici di liste.
 * @param <T> Il tipo della lista da riempire.
 */
>>>>>>> e3a2bf5 (update)
public interface Riempitore<T> {
	
	/**
	 * Riempe la lista specificata in input.
<<<<<<< HEAD
	 * @param mazzo
	 */
	void riempi(List<T> mazzo);
=======
	 */
	void riempi();
>>>>>>> e3a2bf5 (update)
		
}
