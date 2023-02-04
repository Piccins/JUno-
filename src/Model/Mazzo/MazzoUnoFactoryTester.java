package Model.Mazzo;

import Model.Carta.Carta;

import java.util.List;

public class MazzoUnoFactoryTester {

    public static void main(String[] args) {
        MazzoUnoFactory factory = MazzoUnoFactory.getMazzoUnoFactory();
        List<Carta> mazzo = factory.produciMazzo();
        System.out.println(mazzo.size());
    }

}
