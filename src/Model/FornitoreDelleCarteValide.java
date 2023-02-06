package Model;

import Model.Carta.Carta;
import Model.Mazzo.PilaScarti;

import java.util.ArrayList;
import java.util.List;

public class FornitoreDelleCarteValide {

    private PilaScarti<Carta> pilaScarti;

    private static FornitoreDelleCarteValide fornitoreDelleCarteValide;

    private FornitoreDelleCarteValide() {}

    public static FornitoreDelleCarteValide getFornitoreDelleCarteValide() {
        if(fornitoreDelleCarteValide == null) fornitoreDelleCarteValide = new FornitoreDelleCarteValide();
        return fornitoreDelleCarteValide;
    }

    public void setPilaScarti(PilaScarti<Carta> pilaScarti) {
        this.pilaScarti = pilaScarti;
    }

    public List<Carta> getCarteValide(List<Carta> carte) {
        ControlloreCartaValida controlloreCartaValida = ControlloreCartaValida.getControlloreCartaValida();
        return carte.stream()
                .filter(carta -> controlloreCartaValida.isCompatibile(carta, pilaScarti.get(pilaScarti.size() - 1)))
                .toList();
    }

}