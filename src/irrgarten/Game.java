package irrgarten;

import java.util.ArrayList;

/**
 *
 * @author Fco Javier Ortiz Molinero
 * @author Alejandro Pérez Pérez
 */
public class Game {
    
    private static final int MAX_ROUNDS = 10;
    
    private int currentPlayerIndex;
    private String log;
    private Player currentPlayer;
    private ArrayList<Player> players;
    private ArrayList<Monster> monsters;
    private Labyrinth labyrinth;
    
    public Game (int nplayers) {
        
    }
    
    public boolean finished(){
        return this.labyrinth.haveAWinner();
    }
    
    public boolean nextStep(Directions preferredDirection) {
        throw new UnsupportedOperationException();
    }
    
    public GameState getGameState(){
        String p = "";
        String m = "";
        
        for (int i = 0; i < this.players.size(); i++) {
            p += this.players.get(i).toString() + "\n";
        }
        
        for (int i = 0; i < this.monsters.size(); i++) {
            m += this.monsters.get(i).toString() + "\n";
        }
        
        GameState gs = new GameState(this.labyrinth.toString(), p, m,
                this.currentPlayerIndex, this.finished(), this.log);
        
        return gs;
    }
    
    private void configureLabyrinth(){
        
    }
    
    private void nextPlayer(){
        this.currentPlayerIndex=(this.currentPlayerIndex+1)%this.players.size();
        this.currentPlayer = this.players.get(this.currentPlayerIndex);
    }
    
    private Directions actualDirection(Directions preferredDirection){
        throw new UnsupportedOperationException();
    }
    
    private GameCharacter combat(Monster monster){
        throw new UnsupportedOperationException();
    }
    
    private void manageReward(GameCharacter winner){}
    
    private void manageResurrection(){}
    
    private void logPlayerWon(){
        this.log += "Player " + this.currentPlayerIndex +
                " has won the combat.\n";
    }
    
    private void logMonsterWon(){
        this.log += "Monster won the combat\n";
    }
    
    private void logResurrected(){
        this.log += "Player " + this.currentPlayerIndex + " has resurrected.\n";
    }
    
    private void logPlayerSkipTurn(){
        this.log += "Player " + this.currentPlayerIndex +
                " skipped turn (is dead).\n";
    }
    
    private void logPlayerNoOrders(){
        this.log += "Player " + this.currentPlayerIndex +
                " didn't follow orders, for it wasn't possible.\n";
    }
    
    private void logNoMonster(){
        this.log += "Player " + this.currentPlayerIndex +
                " has moved to an empty square or wasn't able to move.\n";
    }
    
    private void logRounds(int rounds, int max) {
        this.log += rounds + " out of " + max + " rounds have occurred.\n";
    }
}
