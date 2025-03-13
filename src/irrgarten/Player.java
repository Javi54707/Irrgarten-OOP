/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author Fco Javier Ortiz Molinero
 * @author ALejandro Pérez Pérez 
 */
public class Player {
    
    private static final int MAX_WEAPONS = 2;
    
    private static final int MAX_SHIELDS = 3;
        
    private static final int INTIAL_HEALTH = 10;
       
    private static final int HITS2LOSE = 3;

    private String name;
    private char number;
    private float intelligence;
    private float strength;
    private float health;
    private int row;
    private int col;
    private int consecutiveHits = 0;
    
    private Weapon weapons;
    private Shield shields;
     
    public Player (char number, float intelligence, float strength){}
    
    public void resurrect(){}
    
    public int getRow(){
        return this.row;
    }
    
    public int getCol() {
        return this.col;
    }
    
    public char getNumber() {
        return this.number;
    }
    
    public void setPos(int row, int col) {}
    
    public boolean dead(){
        throw new UnsupportedOperationException();
    }
    
    public Directions move(Directions direction, Directions[] validMoves){
        throw new UnsupportedOperationException();
    }

    public float attack(){
        throw new UnsupportedOperationException();
    }
    
    public boolean defend(float receivedAttack) {
        throw new UnsupportedOperationException();
    }
    
    public void receiveReward(){}
      
    public String to_string(){
        throw new UnsupportedOperationException();
    }
    
    public void receiveWeapon(Weapon w){}
    
    public void receiveShield(Shield s){}
    
    public Weapon newWeapon(){
        throw new UnsupportedOperationException();
    }
    
    public Shield newShield(){
        throw new UnsupportedOperationException();
    }
    
    public float sumWeapons(){
        throw new UnsupportedOperationException();
    }
    
    public float sumShields(){
        throw new UnsupportedOperationException();
    }
    
    public float defensiveEnergy(){
        throw new UnsupportedOperationException();
    }
    
    public boolean manageHit(float receivedAttack){
        throw new UnsupportedOperationException();
    }
    
    public void resetHits(){}
    
    public void gotWounded(){}
    
    public void incConsecutiveHints(){}
        
}
