package Model.Carta;

public enum AzioneUno implements Azione { 
	
	CAMBIAGIRO, CAMBIACOLORE, PESCADUE, PESCAQUATTRO, SALTAGIRO	;

	@Override
	public boolean isCambiaGiro() {return name().equals("CAMBIAGIRO");}
	@Override
	public boolean isCambiaColore() {return name().equals("CAMBIACOLORE");}

	@Override
	public boolean isPescaDue() {return name().equals("PESCADUE");}

	@Override
	public boolean isPescaQuattro() {return name().equals("PESCAQUATTRO");}

	@Override
	public boolean isSaltaGiro() {return name().equals("SALTAGIRO");}
	
}
