package model;

import model.carta.Azione;
import model.carta.Carta;
import model.carta.Colore;
import model.mazzo.ColoreInGioco;

public class ControlloreCartaValida {

    private static ControlloreCartaValida controlloreCartaValida;

    private ControlloreCartaValida() {}

    public static ControlloreCartaValida getControlloreCartaValida() {
        if(controlloreCartaValida == null) controlloreCartaValida = new ControlloreCartaValida();
        return controlloreCartaValida;
    }

    /**
     * Questo metodo restituisce true se, e soltanto se, la Carta fornita
     * come primo ingresso è compatibile (secondo le regole del gioco Uno) con
     * la carta specificata come secondo parametro.
     * @param cartaDaControllare La carta da controllare.
     * @param cartaInCima La carta in cima alla pila degli scarti.
     * @return Un valore booleano.
     */
    public boolean isCompatibile(Carta cartaDaControllare, Carta cartaInCima) {
        // Carta in cima.
        Colore cartaInCimaColore = cartaInCima.getColore();
        Azione cartaInCimaAzione = cartaInCima.getAzione();
        Integer cartaInCimaValore = cartaInCima.getValore();

        // Carta da controllare.
        Colore cartaDaControllareColore = cartaDaControllare.getColore();
        Azione cartaDaControllareAzione = cartaDaControllare.getAzione();
        Integer cartaDaControllareValore = cartaDaControllare.getValore();

        boolean casoColore = cartaDaControllareColore != null &&
                (cartaDaControllareColore.equals(cartaInCimaColore) || cartaDaControllareColore.isNero() || cartaDaControllareColore.equals(ColoreInGioco.getColoreInGioco().getColore()));
        boolean casoAzione = cartaDaControllareAzione != null && cartaDaControllareAzione.equals(cartaInCimaAzione);
        boolean casoValore = cartaDaControllareValore != null && cartaDaControllareValore.equals(cartaInCimaValore);
        return casoColore || casoAzione || casoValore;
    }

}
