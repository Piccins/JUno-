package Model.Mazzo;

import Controller.InizializzatoreDelMazzoUno;

public class RiempitoreUnoTester {

    public static void main(String[] args) {

        // Inizializzatore.
        InizializzatoreDelMazzoUno.getInizializzatoreDelMazzoUno().actionPerformed(null);

        // Pila scarti.
        PilaScartiUno pilaScartiUno = PilaScartiUno.getPilaScartiUno();

        // Mazzo uno
        MazzoUno mazzoUno = MazzoUno.getMazzoUno();

        // Impostazione del riempitore.
        RiempitoreUno riempitoreUno = RiempitoreUno.getRiempitore();
        mazzoUno.addObserver(riempitoreUno);
        riempitoreUno.setPilaScarti(pilaScartiUno);
        riempitoreUno.setMazzo(mazzoUno);

        for(int i = 0; i < 98; i++) {
            pilaScartiUno.scarta(mazzoUno.pesca());
        }

        System.out.println(mazzoUno.size());

        System.out.println(pilaScartiUno.size());
    }

}