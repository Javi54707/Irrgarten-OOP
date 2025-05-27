package irrgarten;

/**
 * Esta clase representa las armas utilizadas por el jugador en los ataques
 * durante los combates.
 * 
 * @author Fco Javier Ortiz Molinero
 * @author Alejandro Pérez Pérez
 */
public class Weapon extends CombatElement {
    // Atributos de instancia privados
   
    
    /**
     * Constructor de la clase Weapon
     * @param p poder del arma
     * @param u usos restantes del arma
     */
    Weapon(float p, int u) {
        super(p,u);
    }
    
    /**
     * Método para realizar un ataque
     * @return Intensidad del ataque del arma
     */
    public float attack() {
        return this.produceEffect();
    }
    
    /**
     * Método para representar el estado del arma en un string
     * @return String con el estado del arma
     */
    @Override
    public String toString() {
        String toReturn="W";
        toReturn+=super.toString();
        return toReturn;
    }

}