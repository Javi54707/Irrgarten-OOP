package irrgarten;

import java.util.ArrayList;

/**
 *
 * @author Fco Javier Ortiz Molinero
 * @author Alejandro Pérez Pérez
 */
public class Labyrinth {
    
    private static final char BLOCK_CHAR = 'X';
    private static final char EMPTY_CHAR = '-';
    private static final char MONSTER_CHAR = 'M';
    private static final char COMBAT_CHAR = 'C';
    private static final char EXIT_CHAR = 'E';
    private static final int ROW = 0;
    private static final int COL = 1;
    private static final int INVALID = -1;
    
    private final int nRows;
    private final int nCols;
    private final int exitRow;
    private final int exitCol;
    private Monster[][] monsters;
    private Player[][] players;
    private char[][] labyrinth;
    
    public Labyrinth(int nRows, int nCols, int exitRow, int exitCol){
        this.nRows = nRows;
        this.nCols = nCols;
        this.exitRow = exitRow;
        this.exitCol = exitCol;
        
        this.labyrinth = new char[nRows][nCols];
        this.monsters = new Monster[nRows][nCols];
        this.players = new Player[nRows][nCols];
        
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                this.labyrinth[i][j] = EMPTY_CHAR;
            }
        }
        
        this.labyrinth[exitRow][exitCol] = EXIT_CHAR;
    }
    
    public void spreadPlayers(ArrayList<Player> players){
        for (int i=0; i<players.size(); i++){

            int [] pos = randomEmptyPos();
            putPlayer2D(INVALID, INVALID, pos[ROW], pos[COL], players.get(i));
        }
    }
    
    public boolean haveAWinner(){
        return (this.players[this.exitRow][this.exitCol] != null);
    }
    
    @Override
    public String toString(){
        String r = "";
        
        for (int i = 0; i < this.nCols; i++) {
           r += i + " ";
        }
        r += "\n";
        
        for (int j = 0; j < this.nRows; j++) {
            r += j;
            for (int k = 0; k < this.nCols; k++) {
                r += this.labyrinth[j][k];
            }
            r += "\n";
        }
        
        return r;
    }
    
    public void addMonster(int row, int col, Monster monster){
        if (this.emptyPos(row, col) && this.posOK(row, col)) {
            this.labyrinth[row][col] = MONSTER_CHAR;
            this.monsters[row][col] = monster;
            monster.setPos(row, col);
            
        }
    }
    
    public Monster putPlayer(Directions direction, Player player){
        int oldRow = player.getRow();
        int oldCol = player.getCol();

        int[] newPos = dir2Pos(oldRow, oldCol, direction);

        Monster monster = putPlayer2D(oldRow, oldCol, newPos[ROW],
                newPos[COL], player);

        return monster;
    }
    
    public void addBlock(Orientation orientation, int startRow, int startCol, 
                         int length){
        int incRow, incCol;
        if (orientation == Orientation.VERTICAL){
            incRow = 1;
            incCol = 0;
        }
        else{
            incRow = 0;
            incCol = 1;            
        }

        int row=startRow;
        int col=startCol;

        while (posOK(row, col) && emptyPos(row, col) && length>0){
            this.labyrinth[row][col]=BLOCK_CHAR;
            row+=incRow;
            col+=incCol;
            length--;
        }
    }
    
    public ArrayList<Directions> validMoves(int row, int col){
        ArrayList<Directions> output = new ArrayList<>();

        if (canStepOn(row+1, col))
            output.add(Directions.DOWN);
        if (canStepOn(row-1, col))
            output.add(Directions.UP);
        if (canStepOn(row, col+1))
            output.add(Directions.RIGHT);
        if (canStepOn(row, col-1))
            output.add(Directions.LEFT);

        return output;
    }
    
    private boolean posOK(int row, int col){
        return (row >= 0 && row < this.nRows && col >= 0 && col < this.nCols);
    }
    
    private boolean emptyPos(int row, int col){
        return (this.labyrinth[row][col] == EMPTY_CHAR);
    }
    
    private boolean monsterPos(int row, int col){
        return (this.labyrinth[row][col] == MONSTER_CHAR);
    }
    
    private boolean exitPos(int row, int col){
        return (this.labyrinth[row][col] == EXIT_CHAR);
    }
    
    private boolean combatPos(int row, int col){
        return (this.labyrinth[row][col] == COMBAT_CHAR);
    }
    
    private boolean canStepOn(int row, int col){
        return (this.posOK(row, col) && (this.emptyPos(row, col) ||
                this.monsterPos(row, col) || this.exitPos(row, col)));
    }
    
    private void updateOldPos(int row, int col){
        if (this.posOK(row, col)) {
            if (this.combatPos(row, col)) {
                this.labyrinth[row][col] = MONSTER_CHAR;
            }
            else {
                this.labyrinth[row][col] = EMPTY_CHAR;
            }
        }
    }
    
    private int[] dir2Pos(int row, int col, Directions direction){
        int[] dir = new int[2];
        dir[ROW] = row;
        dir[COL] = col;
        
        switch(direction) {
            case UP:
                dir[ROW]--;
                break;
            case DOWN:
                dir[ROW]++;
                break;
            case LEFT:
                dir[COL]--;
                break;
            case RIGHT:
                dir[COL]++;
                break;
        }
        
        return dir;
    }
    
    private int[] randomEmptyPos(){
        int row,col;
        
        do {
            row = Dice.randomPos(this.nRows);
            col = Dice.randomPos(this.nCols);
        } while (!this.emptyPos(row, col));
        
        int[] pos = new int [2];
        pos[ROW] = row;
        pos[COL] = col;
        
        return pos;
    }
    
    private Monster putPlayer2D(int oldRow, int oldCol, int row, int col, 
                               Player player){
        Monster output = null;

        if (canStepOn(row, col)){
            if (posOK(oldRow, oldCol)){
                if (players[oldRow][oldCol] == player){
                    updateOldPos(oldRow, oldCol);
                    this.players[oldRow][oldCol] = null;                    
                }
            }
            if (monsterPos(row, col)){
                this.labyrinth[row][col] = COMBAT_CHAR;
                output = this.monsters[row][col];
            }
            else{
                this.labyrinth[row][col] = player.getNumber();
            }

            this.players[row][col] = player;
            player.setPos(row, col);
        }

        return output;
    }
}   


