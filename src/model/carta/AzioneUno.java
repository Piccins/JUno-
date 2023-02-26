package model.carta;

public enum AzioneUno implements Azione {

	CAMBIA_GIRO,

	CAMBIA_COLORE,

	PESCA_DUE,

	PESCA_QUATTRO,

	SALTA_GIRO;

	@Override
	public boolean isCambiaGiro() {
		return name().equals("CAMBIA_GIRO");
	}
	@Override
	public boolean isCambiaColore() {
		return name().equals("CAMBIA_COLORE");
	}

	@Override
	public boolean isPescaDue() {
		return name().equals("PESCA_DUE");
	}

	@Override
	public boolean isPescaQuattro() {
		return name().equals("PESCA_QUATTRO");
	}

	@Override
	public boolean isSaltaGiro() {
		return name().equals("SALTA_GIRO");
	}

}