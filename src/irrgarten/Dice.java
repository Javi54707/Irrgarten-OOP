package irrgarten;

import java.util.Random;

/**
 * Esta clase toma las decisiones que dependen del azar en el juego
 * 
 * @author Fco Javier Ortiz Molinero
 * @author Alejandro Pérez Pérez
 */
public class Dice {
    private static final int MAX_USES = 5;
    private static final float MAX_INTELLIGENCE = 10.0f;
    private static final float MAX_STRENGTH = 10.0f;
    private static final float RESURRECT_PROB = 0.3f;
    private static final int WEAPONS_REWARD = 2;
    private static final int SHIELDS_REWARD = 3;
    private static final int HEALTH_REWARD = 5;
    private static final int MAX_ATTACK = 3;
    private static final int MAX_SHIELD = 2;
    
    private static Random generator = new Random(); //Genera números aleatorios
    
    /**
     * Da una fila o clumna aleatoria en el tablero
     * @param max Dimensión máxima del tablero (filas o columnas)
     * @return una fila o columna aleatoria entre 0 y max
     */
    public static int randomPos(int max) {
        return generator.nextInt(max);
    }
    
    /**
     * Dice qué jugador empieza la partida
     * @param nplayers Número de jugadores de la partida
     * @return Número que representa al jugador que empieza la partida
     *          (los jugadores se numeran desde el 0
     */
    public static int whoStarts(int nplayers) {
        return generator.nextInt(nplayers);
    }
    
    /**
     * Genera un valor aleatorio de inteligencia para un personaje en el
     * intervalo [0,MAX_INTELLINGENCE[
     * @return Valor aleatorio de inteligencia
     */
    public static float randomIntelligence() {
        return generator.nextFloat() * MAX_INTELLIGENCE;
    }
    
    /**
     * Genera un valor aleatorio de fuerza para un personaje en el
     * intervalo [0,MAX_STRENGTH[
     * @return Valor aleatorio de fuerza
     */
    public static float randomStrength() {
        return generator.nextFloat() * MAX_STRENGTH;
    }
    
    /**
     * Determina si un jugador resucita o no
     * @return True si resucita, false si no lo hace
     */
    public static boolean resurrectPlayer() {
        return generator.nextFloat() <= RESURRECT_PROB;
    }
    
    /**
     * Determina la cantidad de armas que recibirá el jugador al ganar
     * un combate
     * @return Cantidad de armas recibidas
     */
    public static int weaponsReward() {
        return generator.nextInt(WEAPONS_REWARD + 1);
    }
    
    /**
     * Determina la cantidad de escudos que recibirá el jugador al ganar
     * un combate
     * @return Cantidad de escudos recibidos
     */
    public static int shieldsReward() {
        return generator.nextInt(SHIELDS_REWARD + 1);
    }
    
    /**
     * Determina la cantidad de puntos de salud que recibirá el jugador al ganar
     * un combate
     * @return Cantidad de puntos de salud recibidos
     */
    public static int healthReward() {
        return generator.nextInt(HEALTH_REWARD + 1);
    }
    
    /**
     * Genera un valor aleatorio de potencia para un arma en el
     * intervalo [0,MAX_ATTACK[
     * @return Valor aleatorio de potencia
     */
    public static float weaponPower() {
        return generator.nextFloat() * MAX_ATTACK;
    }
    
    /**
     * Genera un valor aleatorio de defensa para un escudo en el
     * intervalo [0,MAX_SHIELD[
     * @return Valor aleatorio de defensa
     */
    public static float shieldPower() {
        return generator.nextFloat() * MAX_SHIELD;
    }
    
    /**
     * Determina el número de usos de un arma o un escudo
     * @return Número aleatorio de usos asignado
     */
    public static int usesLeft() {
        return generator.nextInt(MAX_USES + 1);
    }
    
    /**
     * Determina la intensidad aplicada de una competencia máxima
     * @param competence Competencia máxima
     * @return Intensidad en el intervalo [0,competence[
     */
    public static float intensity(float competence) {
        return generator.nextFloat() * competence;
    }
    
    /**
     * Determina si se debe descartar un arma o un escudo con una probabilidad
     * inversamente proporcional al número de usos restantes del arma o escudo
     * @param usesLeft Número de usos restantes
     * @return True si se descarta, false si no se descarta
     */
    public static boolean discardElement(int usesLeft) {
        float p = usesLeft/MAX_USES;
        return generator.nextFloat() > p;
    }
}
