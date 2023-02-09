package model.giocatori;

import model.GestoreTurni;

public class GestoreTurniTester {

    public static void main(String[] args) {
        // Oggetti.
        Umano umano = Umano.getUmano();
        GestoreGiocatori gestoreGiocatori = GestoreGiocatori.getGestoreGiocatori();
        GestoreTurni gestoreTurni = GestoreTurni.getGestoreTurni();

        // Impostazione.
        gestoreGiocatori.addObserver(gestoreTurni);
        umano.setNome("Serena");
        gestoreGiocatori.setGiocatori();

        // Test.
        System.out.println("Giocatori: ");
        gestoreGiocatori.getGiocatori().forEach(System.out::println);

        System.out.println("------------------");
        System.out.println(gestoreTurni.giocatoreAttuale());

        System.out.println("------------------");
        for(int i = 0; i < 4; i++) {
            gestoreTurni.impostaGiocatoreSuccessivo();
            System.out.println(gestoreTurni.giocatoreAttuale());
        }

        System.out.println("------------------");
        System.out.println("Inversione: ");
        gestoreTurni.inverti();
        for(int i = 0 ; i < 6; i++) {
            gestoreTurni.impostaGiocatoreSuccessivo();
            System.out.println(gestoreTurni.giocatoreAttuale());
        }
    }

}