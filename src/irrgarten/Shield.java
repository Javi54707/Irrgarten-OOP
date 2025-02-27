package irrgarten;

/**
 *
 * @author Fco Javier Ortiz Molinero
 * @author Alejandro Pérez Pérez
 * 
 * Esta clase representa los escudos que utiliza el jugador cuando se defiende 
 * de un ataque de un monstruo.
 */

public class Shield {   
    /* atributos de instancia*/
    private float protection = 0;
    private int uses = 0;
    
    Shield (float p, int u) {
        protection = p;
        uses = u;
    }
    
    public float protect() {       
        if (uses > 0) {
            uses--;
            return protection;
        } else {
            return 0;
        }
    }
    
    @Override    
    public String toString() {
        return "S[" + protection + "," + uses + "]";
    }
    
    public boolean discard() {
        return Dice.discardElement(uses);
    }
}
