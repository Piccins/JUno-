package Model;

import Model.Giocatori.GestoreGiocatori;
import Model.Giocatori.Giocatore;

import java.util.List;
import java.util.Random;

public class GestoreTurni {

    private static GestoreTurni gestoreTurni;

    private int indiceGiocatoreCorrente;

    private GestoreTurni(){    }

    public static GestoreTurni getGestoreTurni() {
        if (gestoreTurni == null) gestoreTurni = new GestoreTurni();
        return gestoreTurni;
    }

    public void impostaPrimoGiocatore(List<Giocatore> giocatori)   {
        GestoreGiocatori gestoreGiocatori = GestoreGiocatori.getGestoreGiocatori();
        Random r = new Random();

        indiceGiocatoreCorrente = r.nextInt(giocatori.size());
        Giocatore primoGiocatore = giocatori.get(indiceGiocatoreCorrente);
    }

    public Giocatore giocatoreAttuale(List<Giocatore> giocatori){
        return GestoreGiocatori.getGestoreGiocatori().getGiocatori().get(indiceGiocatoreCorrente);
    }

    public void impostaGiocatoreSuccessivo(){
        indiceGiocatoreCorrente = indiceGiocatoreCorrente == 3 ? 0 : indiceGiocatoreCorrente ++;
    }

    public void impostaGiocatorePrecedente(){
        indiceGiocatoreCorrente = indiceGiocatoreCorrente == 0 ? 3 : indiceGiocatoreCorrente --;
    }
}
