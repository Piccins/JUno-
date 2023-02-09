package model.mazzo;

import java.util.List;

public interface PilaScarti<T> extends List<T>{
		/**
		 * Scarta la carta passata in input in cima alla pila degli scarti.
		 * @param carta
		 */
	void scarta(T carta);
		
}
