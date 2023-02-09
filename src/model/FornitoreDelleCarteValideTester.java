package model;

import controller.InizializzatoreDelMazzoUno;
import model.carta.Carta;
import model.mazzo.*;

import java.util.ArrayList;
import java.util.List;

public class FornitoreDelleCarteValideTester {

    public static void main(String[] args) {
        ColoreInGioco coloreInGioco = ColoreInGioco.getColoreInGioco();
        PilaScartiUno pilaScartiUno = PilaScartiUno.getPilaScartiUno();
        MazzoUno mazzoUno = MazzoUno.getMazzoUno();
        MazzoUnoFactory mazzoUnoFactory = MazzoUnoFactory.getMazzoUnoFactory();
        InizializzatoreDelMazzoUno inizializzatoreDelMazzoUno = InizializzatoreDelMazzoUno.getInizializzatoreDelMazzoUno();
        FornitoreDelleCarteValide fornitoreDelleCarteValide = FornitoreDelleCarteValide.getFornitoreDelleCarteValide();

        // Impostazione.
        pilaScartiUno.addObserver(coloreInGioco);
        fornitoreDelleCarteValide.setPilaScarti(pilaScartiUno);

        // Creazione del mazzo.
        inizializzatoreDelMazzoUno.actionPerformed(null);

        // Prima carta scartata.
        pilaScartiUno.scarta(mazzoUno.pesca());

        // Lista delle carte pescate.
        List<Carta> carte = new ArrayList<>();
        for(int i = 0; i < 7; i++) carte.add(mazzoUno.pesca());

        System.out.println("Carte in mano: ");
        carte.forEach(System.out::println);

        System.out.println("-------------------------");

        System.out.println("Carte giocabili: ");
        fornitoreDelleCarteValide.getCarteValide(carte).forEach(System.out::println);

        System.out.println("-------------------------");
        System.out.println("Carta in cima: ");
        System.out.println(pilaScartiUno.get(pilaScartiUno.size() - 1));
    }

}