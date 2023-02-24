package model.carta;

public enum AzioneUno implements Azione {

	CAMBIA_GIRO,

	CAMBIA_COLORE,

	PESCA_DUE,

	PESCA_QUATTRO,

	SALTA_GIRO;

	@Override
	public boolean isCambiaGiro() {
		return name().equals("CAMBIAGIRO");
	}
	@Override
	public boolean isCambiaColore() {
		return name().equals("CAMBIACOLORE");
	}

	@Override
	public boolean isPescaDue() {
		return name().equals("PESCADUE");
	}

	@Override
	public boolean isPescaQuattro() {
		return name().equals("PESCAQUATTRO");
	}

	@Override
	public boolean isSaltaGiro() {
		return name().equals("SALTAGIRO");
	}

}