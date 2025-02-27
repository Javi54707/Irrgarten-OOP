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
 * Esta clase alamcena una representación del estado del juego
 */
public class GameState {
    private String labyrinth;
    private String players;
    private String monsters;
    private int currentPlayer;
    private boolean winner;
    private String log;
    
    //Constructor
    GameState(String lab, String p, String m, int cp, boolean w, String l) {
        labyrinth = lab;
        players = p;
        monsters = m;
        currentPlayer = cp;
        winner = w;
        log = l;
    }
    
    //métodos get
    public String getlabyrinth() {
        return labyrinth;
    }
    
    public String getplayers() {
        return players;
    }
    
    public String getmonsters() {
        return monsters;
    }
    
    public int getcurrentPlayer() {
        return currentPlayer;
    }
    
    public boolean getwinner() {
        return winner;
    }
    
    public String getlog() {
        return log;
    }
}
