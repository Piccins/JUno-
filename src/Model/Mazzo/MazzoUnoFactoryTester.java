package Model.Mazzo;

import Model.Carta.Carta;

import java.util.List;

public class MazzoUnoFactoryTester {

    public static void main(String[] args) {
        MazzoUnoFactory factory = MazzoUnoFactory.getMazzoUnoFactory();
        List<Carta> mazzo = factory.produciMazzo();
        // System.out.println(mazzo.size());
        mazzo.forEach(System.out::println);

        /**
         * JButton button = new JButton();
         * if(carta.isBlue()) {
         *      Integer valore = carta.getValore();
         *      if(valore != null) {
         *          if(valore == 0) {
         *              button.setIcon(
         *          }
         *      }
         * }
         */
    }

}
