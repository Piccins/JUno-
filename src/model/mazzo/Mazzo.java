package model.mazzo;

import java.util.List;

/**
 * Tramite questa interfaccia, viene utilizzata per implementare il metodo che ci 
 * permetterà di pescare la carta in cima al mazzo sfruttando le caratteristiche
 * della classe List.
 * @author seren
 * @param <T> il tipo delle carte
 *
 */
public interface Mazzo<T> extends List<T>{
	
	/**
	 * Metodo per pescare dal mazzo
	 * @return la carta in cima al mazzo 
	 */
		T pesca();

}
