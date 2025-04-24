package irrgarten;

import java.util.ArrayList;

/**
 *
 * @author Fco Javier Ortiz Molinero
 * @author Alejandro Pérez Pérez
 */
public class Game {
    
    private static final int MAX_ROUNDS = 10;
    
    // ---------------------- PARA PERSONALIZAR LABERINTO ---------------- //
    // Tamaño del laberinto
    /**
     * Número de filas del laberinto.
     */
    private static final int ROWS = 10;
    /**
     * Número de columnas del laberinto.
     */
    private static final int COLS = 10;
    

    // Monstruos a incluir
    /**
     * Número de monstruos a incluir en el laberinto.
     */
    private static final int NUM_MONSTERS = 3;
    /**
     * Posiciones iniciales de los monstruos en el laberinto.
     */
    private static final int[][] INIT_MONSTERS= {{0,0}, {1,1}, {2,2}};
    
    // Bloques a incluir
    /**
     * Número de bloques a incluir en el laberinto.
     */
    private static final int NUM_BLOCKS = 3;
    /**
     * Bloques iniciales a incluir en el laberinto donde el último parámetro
     * indica la longitud.
     */
    private static final Object[][] INIT_BLOCKS =
    {{Orientation.HORIZONTAL,0,0,3}, {Orientation.HORIZONTAL,3,3,5}, 
        {Orientation.VERTICAL,8,9,2}};

// ---------------------- PARA PERSONALIZAR LABERINTO ---------------- //
    
    private int currentPlayerIndex;
    private String log;
    private Player currentPlayer;
    private final ArrayList<Player> players;
    private final ArrayList<Monster> monsters;
    private final Labyrinth labyrinth;
    
    public Game (int nplayers) {
        // Definimos casilla de salida
        int exitRow = Dice.randomPos(ROWS);
        int exitCol = Dice.randomPos(COLS);
        
        this.players = new ArrayList<>();
        this.monsters = new ArrayList<>();
         
        // Creamos los jugadores y los introducimos en el vector players
        for(int i = 0; i < nplayers; i++){
            this.players.add(new Player((char)('0' + i),
                    Dice.randomIntelligence(), Dice.randomStrength()));
        }
                 
        // Definimos el jugador que empezará, es decir, el currentPlayer
        this.currentPlayerIndex = Dice.whoStarts(nplayers);
        this.currentPlayer = this.players.get(this.currentPlayerIndex);
        
        // Inicializamos la instancia de laberinto y la configuramos
        this.labyrinth = new Labyrinth(ROWS, COLS, exitRow, exitCol);
        this.configureLabyrinth();
        this.labyrinth.spreadPlayers(this.players);
         
        // Inicializamos log
        this.log = "Game just started.\n";
    }
    
    public boolean finished(){
        return this.labyrinth.haveAWinner();
    }
    
    public boolean nextStep(Directions preferredDirection) {
        log = "";

        if (currentPlayer.dead()){
            manageResurrection();
        }
        else{
            Directions direction = this.actualDirection(preferredDirection);
            if (direction != preferredDirection){
                logPlayerNoOrders();
            }

            Monster monster = this.labyrinth.putPlayer(direction,currentPlayer);

            if (monster == null){
                logNoMonster();
            }
            else{
                GameCharacter winner = combat(monster);
                manageReward(winner);
            }
        }

 
        boolean endGame = finished();
        if (!endGame)
            nextPlayer();

        return endGame;
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
        // Inicializamos el vector de monstruos y los añadimos al laberinto
        for (int i = 0; i < NUM_MONSTERS; i++){
            Monster monster = new Monster ("Monster " + i,
                    Dice.randomIntelligence(), Dice.randomStrength());
            this.monsters.add(monster);
            this.labyrinth.addMonster(INIT_MONSTERS[i][0], INIT_MONSTERS[i][1],
                    monster);
        }
        
        // Añadimos los bloques al laberinto
        for (int i = 0; i < NUM_BLOCKS; i++){
            this.labyrinth.addBlock((Orientation)INIT_BLOCKS[i][0],
                    (int)INIT_BLOCKS[i][1], (int)INIT_BLOCKS[i][2],
                    (int)INIT_BLOCKS[i][3]);
        }
    }
    
    private void nextPlayer(){
        this.currentPlayerIndex=(this.currentPlayerIndex+1)%this.players.size();
        this.currentPlayer = this.players.get(this.currentPlayerIndex);
    }
    
    private Directions actualDirection(Directions preferredDirection){
        int currentRow = this.currentPlayer.getRow();
        int currentCol = this.currentPlayer.getCol();

        ArrayList<Directions> valids = this.labyrinth.validMoves(currentRow,
                currentCol);

        return currentPlayer.move(preferredDirection, valids);
    }
    
    private GameCharacter combat(Monster monster){
        int rounds = 0;

        GameCharacter winner = GameCharacter.PLAYER;
        boolean lose = monster.defend(currentPlayer.attack());

        while (!lose && rounds<MAX_ROUNDS){
            rounds++;

            winner = GameCharacter.MONSTER;
            lose = currentPlayer.defend(monster.attack());

            if (!lose){
                winner = GameCharacter.PLAYER;
                lose = monster.defend(currentPlayer.attack());
            }
        }

        this.logRounds(rounds, MAX_ROUNDS);
        return winner;
    }
    
    private void manageReward(GameCharacter winner){
        if (winner == GameCharacter.PLAYER){
            this.currentPlayer.receiveReward();
            this.logPlayerWon();
        }
        else{
            this.logMonsterWon();
        }
    }
    
    private void manageResurrection(){
        if (Dice.resurrectPlayer()){
            this.currentPlayer.resurrect();
            this.logResurrected();
        }            
        else
            this.logPlayerSkipTurn();
    }
    
    private void logPlayerWon(){
        this.log += "Player " + this.currentPlayerIndex +
                " has won the combat.\n";
    }
    
    private void logMonsterWon(){
        this.log += "Monster won the combat.\n";
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
