package Model.Mazzo;

import java.util.List;

import Model.Carta.Carta;

<<<<<<< HEAD
public interface Mescolatore {
	
	void mescola(List<Carta> mazzo);
=======
/**
 * Quest'interfaccia definisce mescolatori di liste.
 * @param <T> Il tipo della lista da mescolare.
 */
public interface Mescolatore<T> {

	/**
	 * Mescola il lista passata in input.
	 * @param mazzo Il mazzo da mescolare.
	 */
	void mescola(List<T> mazzo);
>>>>>>> e3a2bf5 (update)
	
}
