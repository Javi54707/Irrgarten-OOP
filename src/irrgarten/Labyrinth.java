/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

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
    
    public Labyrinth(int nRows, int nCols, int exitRow, int exitCol){}
    
    public void spreadPlayers(Player[] players){}
    
    public boolean haveAWinner(){
        throw new UnsupportedOperationException();
    }
    
    @Override
    public String toString(){
        throw new UnsupportedOperationException();
    }
    
    public void addMonster(int row, int col, Monster monster){}
    
    public Monster putPlayer(Directions direction, Player player){
        throw new UnsupportedOperationException();
    }
    
    public void addBlock(Orientation orientation, int startRow, int startCol, 
                         int length){}
    
    public Directions[] validMoves(int row, int col){
        throw new UnsupportedOperationException();
    }
    
    public boolean posOK(int row, int col){
        throw new UnsupportedOperationException();
    }
    
    public boolean emptyPos(int row, int col){
        throw new UnsupportedOperationException();
    }
    
    public boolean monsterPos(int row, int col){
        throw new UnsupportedOperationException();
    }
    
    public boolean exitPos(int row, int col){
        throw new UnsupportedOperationException();
    }
    
    public boolean combatPos(int row, int col){
        throw new UnsupportedOperationException();
    }
    
    public boolean canStepOn(int row, int col){
        throw new UnsupportedOperationException();
    }
    
    public void updateOldPos(int row, int col){}
    
    public int[] dir2Pos(int row, int col, Directions direction){
        throw new UnsupportedOperationException();
    }
    
    public int[] randomEmptyPos(){
        throw new UnsupportedOperationException();
    }
    
    public Monster putPlayer2D(int oldRow, int oldCol, int row, int col, 
                               Player player){
        throw new UnsupportedOperationException();
    }
    
}   


