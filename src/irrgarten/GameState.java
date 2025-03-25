package irrgarten;

/**
 * Esta clase almacena una representación del estado del juego
 * 
 * @author Fco Javier Ortiz Molinero
 * @author Alejandro Pérez Pérez
 */
public class GameState {
    private String labyrinth;
    private String players;
    private String monsters;
    private int currentPlayer;
    private boolean winner;
    private String log;
    
    /**
     * Constructor de la clase Game State
     * @param lab Estado del laberinto
     * @param p Estado de los jugadores
     * @param m Esrado de los monstruos
     * @param cp Número identificador del jugador actual
     * @param w Indicador de si hay ganador
     * @param l Eventos interesantes a lo largo de la partida
     */
    GameState(String lab, String p, String m, int cp, boolean w, String l) {
        labyrinth = lab;
        players = p;
        monsters = m;
        currentPlayer = cp;
        winner = w;
        log = l;
    }
    
    /**
     * Consultor del estado del laberinto
     * @return Estado del laberinto
     */
    public String getlabyrinth() {
        return labyrinth;
    }
    
    /**
     * Consultor del estado de los jugadores
     * @return Estado de los jugadores
     */
    public String getplayers() {
        return players;
    }
    
    /**
     * Consultor del estado de los monstruos
     * @return Estado de los monstruos
     */
    public String getmonsters() {
        return monsters;
    }
    
    /**
     * Consultor del jugador actual
     * @return Identificador del jugador actual
     */
    public int getcurrentPlayer() {
        return currentPlayer;
    }
    
    /**
     * Consultor de si hay un ganador
     * @return true si hay ganador, false si no lo hay
     */
    public boolean getwinner() {
        return winner;
    }
    
    /**
     * Consultor de eventos interesantes en la partida
     * @return Eventos interesantes en la partida
     */
    public String getlog() {
        return log;
    }
}
