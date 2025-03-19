package irrgarten;

/**
 *
 * @author Fco Javier Ortiz Molinero
 * @author Alejandro Pérez Pérez
 */
public class Game {
    
    private static final int MAX_ROUNDS = 10;
    
    private int currentPlayerIndex;
    
    private String log;
    
    private Monster monsters;
    
    private Player players;
    
    private Player currentPlayer;
    
    public Game (int nplayers) {}
    
    public boolean finished(){
        throw new UnsupportedOperationException();
    }
    
    public boolean nextStep(Directions preferredDirection) {
        throw new UnsupportedOperationException();
    }
    
    public GameState getGameState(){
        throw new UnsupportedOperationException();
    }
    
    public void configureLabyrinth(){}
    
    public void nextPlayer(){}
    
    public Directions actualDirection(Directions preferredDirection){
        throw new UnsupportedOperationException();
    }
    
    public GameCharacter combat(Monster monster){
        throw new UnsupportedOperationException();
    }
    
    public void manageReward(GameCharacter winner){}
    
    public void manageResurrection(){}
    
    public void logPlayerWon(){}
    
    public void logMonsterWon(){}
    
    public void logResurrected(){}
    
    public void logPlayerSkipTurn(){}
    
    public void logPlayerNoOrders(){}
    
    public void logNoMonster(){}
    
    public void logRounds(int rounds, int max) {}
}
