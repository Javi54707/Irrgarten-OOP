package irrgarten;

/**
 * Esta clase representa las armas utilizadas por el jugador en los ataques
 * durante los combates.
 * 
 * @author Fco Javier Ortiz Molinero
 * @author Alejandro Pérez Pérez
 */
public class Weapon {
    // Atributos de instancia privados
    private float power = 0;
    private int uses = 0;
    
    /**
     * Constructor de la clase Weapon
     * @param p poder del arma
     * @param u usos restantes del arma
     */
    Weapon(float p, int u) {
        power = p;
        uses = u;
    }
    
    /**
     * Método para realizar un ataque
     * @return Intensidad del ataque del arma
     */
    public float attack() {
        if (uses > 0) {
            uses--;
            return power;
        }
        else
            return 0;
    }
    
    /**
     * Método para representar el estado del arma en un string
     * @return String con el estado del arma
     */
    @Override
    public String toString() {
        return "W[" + power + "," + uses + "]";
    }
    
    /**
     * Método para determinar si un arma se debe descartar o no. La probabilidad
     * de ser descartada es inversamente proporcional a los usos restantes del
     * arma
     * @return True si se descarta, false si no
     */
    public boolean discard() {
        return Dice.discardElement(uses);
    }
}