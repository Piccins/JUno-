package Model.Giocatori;

import java.util.List;

import static Model.Giocatori.Umano.getUmano;

public class GestoreGiocatori {

    private static GestoreGiocatori gestoreGiocatori;

    private List<Giocatore> giocatori;

    private GestoreGiocatori(){}

    public static GestoreGiocatori getGestoreGiocatori(){
        if (gestoreGiocatori == null) gestoreGiocatori = new GestoreGiocatori();
        return gestoreGiocatori;
    }

    public void setGiocatori() {
        giocatori.clear();
        Bot bot1 = new Bot("drago");
        Bot bot2 = new Bot( "serpente");
        Bot bot3 = new Bot("cavallo");
        giocatori.add(bot1);
        giocatori.add(bot2);
        giocatori.add(bot3);
        giocatori.add(getUmano());
    }

    public List<Giocatore> getGiocatori(){
        return giocatori;
    }
}
