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
    
    private int nRows;
    private int nCols;
    private int exitRow;
    private int exitCol;
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
    
    public void spreadPlayers(Player[] players){}
    
    public boolean haveAWinner(){
        return (this.players[this.exitRow][this.exitCol] != null);
    }
    
    @Override
    public String toString(){
        throw new UnsupportedOperationException();
    }
    
    public void addMonster(int row, int col, Monster monster){
        if (this.emptyPos(row, col) && this.posOK(row, col)) {
            this.labyrinth[row][col] = MONSTER_CHAR;
            this.monsters[row][col] = monster;
            monster.setPos(row, col);
            
        }
    }
    
    public Monster putPlayer(Directions direction, Player player){
        throw new UnsupportedOperationException();
    }
    
    public void addBlock(Orientation orientation, int startRow, int startCol, 
                         int length){}
    
    public Directions[] validMoves(int row, int col){
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException();
    }
}   


