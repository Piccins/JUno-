package model.carta;

/**
 * Tramite questa interfaccia stabiliamo l'azione della carta.
 * Solo una alla volta delle interfacce estese restituirà "vero". 
 * Il boolean restituirà "vero" se è una carta Azione.
 * @author seren
 *
 */
public interface Azione extends CambiaGiro, CambiaColore, PescaDue, PescaQuattro, SaltaGiro {
	

}
