package Model.giocatori;

import Model.Carta.Carta;

import java.util.ArrayList;
import java.util.List;

public class Bot {

    private final List<Carta> carte;

    private final String nome;

    public Bot(String nome) {
        this.nome = nome;
        this.carte = new ArrayList<>();
    }

    public Carta mossa() {
        // In base alla carta in cima alla pila degli scarti
        // questo giocatore (bot) decide quale carta fornire
        // e, se ha almeno una carta che può giocare, ne ritorna
        // una. Altrimenti ritorna null.
        return null;

    }

}