/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author Fco Javier Ortiz Molinero
 * @author Alejandro Pérez Pérez
 * 
 * Esta clase representa las armas utilizadas por el jugador en los ataques
 * durante los combates.
 */
public class Weapon {
    /* Atributos de instancia privados*/
    private float power = 0;
    private int uses = 0;
    
    /* Constructor de la clase weapon*/
    Weapon (float p, int u) {
        power = p;
        uses = u;
    }
    
    /* Método devuelve la intensidad de ataque del jugador*/
    public float attack () {
        if (uses > 0) {
            uses--;
            return power;
        }
        else
            return 0;
    }
    
    /* Método tostring*/
    @Override
    public String toString() {
        return "W[" + power + "," + uses + "]";
    }
}