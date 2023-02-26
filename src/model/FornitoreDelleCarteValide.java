package model;

import model.carta.Carta;
import model.mazzo.PilaScartiUno;

import java.util.List;

public class FornitoreDelleCarteValide {

    private static FornitoreDelleCarteValide fornitoreDelleCarteValide;

    private FornitoreDelleCarteValide() {}

    public static FornitoreDelleCarteValide getFornitoreDelleCarteValide() {
        if(fornitoreDelleCarteValide == null) fornitoreDelleCarteValide = new FornitoreDelleCarteValide();
        return fornitoreDelleCarteValide;
    }

    public List<Carta> getCarteValide(List<Carta> carte) {
        PilaScartiUno pilaScartiUno = PilaScartiUno.getPilaScartiUno();
        ControlloreCartaValida controlloreCartaValida = ControlloreCartaValida.getControlloreCartaValida();
        return carte.stream()
                .filter(carta -> controlloreCartaValida.isCompatibile(carta, pilaScartiUno.get(pilaScartiUno.size() - 1)))
                .toList();
    }

}