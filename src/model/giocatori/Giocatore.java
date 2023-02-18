package model.giocatori;

import model.carta.Carta;

import java.util.List;

public interface Giocatore {

    public void add(Carta carta);

    public void remove(Carta carta);

    public List<Carta> getCarte();

    public Carta getCarta();

    public String getNome();

}