package Model.Mazzo;

import Model.Carta.Carta;

import java.util.List;

public class MescolatoreUnoTester {

    public static void main(String[] args) {
        MescolatoreUno mescolatoreUno = MescolatoreUno.getMescolatore();
        MazzoUnoFactory factory = MazzoUnoFactory.getMazzoUnoFactory();
        List<Carta> mazzo = factory.produciMazzo();
        mescolatoreUno.mescola(mazzo);
        mazzo.forEach(System.out::println);
    }

}