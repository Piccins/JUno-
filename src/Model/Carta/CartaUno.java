package Model.Carta;

public class CartaUno implements Carta {

	private Colore colore;
	private Integer valore;
	private Azione azione;
	
	public CartaUno(Colore colore, Integer valore, Azione azione) { 
		
	this.colore=colore;
	this.valore=valore;
	this.azione=azione;					
	}
	
	@Override
	public Colore getColore() { return colore;	}

	@Override
	public Azione getAzione() {	return azione;	}

	@Override
	public Integer getValore() {return valore;	}

	@Override
	public String toString() {
		return "CartaUno" + "[" + colore + ", " + azione + ", " + valore + "]";	
	}
   }

