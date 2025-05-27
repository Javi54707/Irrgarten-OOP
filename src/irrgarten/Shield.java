package irrgarten;

/**
 * Esta clase representa los escudos que utiliza el jugador cuando se defiende 
 * de un ataque de un monstruo.
 * 
 * @author Fco Javier Ortiz Molinero
 * @author Alejandro Pérez Pérez
 */

public class Shield extends CombatElement {   
    
    /**
     * Constructor de la clase Shield
     * @param p protección del escudo
     * @param u usos restantes del escudo
     */
    Shield (float p, int u) {
        super(p,u);
    }
    
    /**
     * Método para proteger con el escudo
     * @return Intensidad de la protección del escudo
     */
    public float protect() {       
        return this.produceEffect();
    }
    
    /**
     * Método para representar el estado del escudo en un string
     * @return String con el estado del escudo
     */
    @Override    
    public String toString() {
        String toReturn="S";
        toReturn+=super.toString();
        return toReturn;
    }
}
