package model.carta;

/**
 * Tramite questa interfaccia valutiamo se una determinara carta è di colore Nero (ossia una carta Jolly).
 * Infatti il boolean restituirà true se è NEro.
 * @author seren
 *
 */
public interface Nero {
	/**
	 * Ritorna true se e soltanto se l'oggetto invocante è il colore nero
	 * @return un valore booleano
	 */
	boolean isNero();
}
