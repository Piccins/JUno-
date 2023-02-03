package Model.Carta;

class CartaTester {

    private CartaTester() {}

    public static void main(String[] args) {
    	
    	
    	ColoreUno c = ColoreUno.ROSSO; 
    	
     	CartaUno carta = new CartaUno(c, 2, null);   	
     	System.out.println(carta); 
    	
    }
}
