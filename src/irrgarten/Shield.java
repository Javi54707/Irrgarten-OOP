package irrgarten;

/**
 * Esta clase representa los escudos que utiliza el jugador cuando se defiende 
 * de un ataque de un monstruo.
 * 
 * @author Fco Javier Ortiz Molinero
 * @author Alejandro Pérez Pérez
 */

public class Shield {   
    // Atributos de instancia privados
    private float protection = 0;
    private int uses = 0;
    
    /**
     * Constructor de la clase Shield
     * @param p protección del escudo
     * @param u usos restantes del escudo
     */
    Shield (float p, int u) {
        protection = p;
        uses = u;
    }
    
    /**
     * Método para proteger con el escudo
     * @return Intensidad de la protección del escudo
     */
    public float protect() {       
        if (uses > 0) {
            uses--;
            return protection;
        } else {
            return 0;
        }
    }
    
    /**
     * Método para representar el estado del escudo en un string
     * @return String con el estado del escudo
     */
    @Override    
    public String toString() {
        return "S[" + protection + "," + uses + "]";
    }
    
    /**
     * Método para determinar si un escudo se debe descartar o no. La 
     * probabilidad de ser descartado es inversamente proporcional a los usos
     * restantes del escudo
     * @return True si se descarta, false si no
     */
    public boolean discard() {
        return Dice.discardElement(uses);
    }
}
