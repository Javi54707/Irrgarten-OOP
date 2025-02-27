/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

import java.util.Random;

/**
 *
 * @author Fco Javier Ortiz Molinero
 * @author Alejandro Pérez Pérez
 * 
 * Esta clase toma las decisiones que dependen del azar en el juego
 */
public class Dice {
    static private float MAX_USES = 5;
    static private float MAX_INTELLIGENCE = 10.0f;
    static private float MAX_STRENGHT = 10.0f;
    static private float RESURRECT_PROB = 0.3f;
    static private float WEAPONS_REWARD = 2;
    static private float SHIELDS_REWARD = 3;
    static private float HEALTH_REWARD = 5;
    static private float MAX_ATTACK = 3;
    static private float MAX_SHIELD = 2;
    
    static private Random generator = new Random();
    
    /* Metedo random pos*/
    public int randomPos(int max) {
        return generator.nextInt(max);
    }
}
