package model.carta;

public enum ColoreUno implements Colore {

	/** Colore Blue. */
	BLU,

	ROSSO,

	GIALLO,

	VERDE,

	NERO;

	
	@Override
	public boolean isNero() { return name().equals("NERO");}

	@Override
	public boolean isBlu() { return name().equals("BLU");}

	@Override
	public boolean isRosso() { return name().equals("ROSSO");}

	@Override
	public boolean isGiallo() { return name().equals("GIALLO");}

	@Override
	public boolean isVerde() { return name().equals("VERDE");}	

}
