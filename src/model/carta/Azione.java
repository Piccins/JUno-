package model.carta;

/**
 * Tramite questa interfaccia stabiliamo l'azione della carta.
 * Solo una alla volta delle interfacce estese restituirĂ  "vero". 
 * Il boolean restituirĂ  "vero" se Ă¨ una carta Azione.
 * @author seren
 *
 */
public interface Azione extends CambiaGiro, CambiaColore, PescaDue, PescaQuattro, SaltaGiro {
	

}
