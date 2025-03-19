package irrgarten;

import java.util.ArrayList;

/**
 *
 * @author Fco Javier Ortiz Molinero
 * @author ALejandro Pérez Pérez 
 */
public class Player {
    
    private static final int MAX_WEAPONS = 2;
    private static final int MAX_SHIELDS = 3;        
    private static final int INITIAL_HEALTH = 10;       
    private static final int HITS2LOSE = 3;

    private String name;
    private char number;
    private float intelligence;
    private float strength;
    private float health;
    private int row;
    private int col;
    private int consecutiveHits = 0;
    
    private ArrayList<Weapon> weapons;
    private ArrayList<Shield> shields;
     
    public Player (char number, float intelligence, float strength){
        this.number = number;
        name = "Player#" + this.number;
        this.intelligence = intelligence;
        this.strength = strength;
        this.health = INITIAL_HEALTH;
        
        weapons = new ArrayList<>();
        shields = new ArrayList<>();
    }
    
    public void resurrect(){
        this.health = INITIAL_HEALTH;
        this.resetHits();
        this.weapons.clear();
        this.shields.clear();
    }
    
    public int getRow(){
        return this.row;
    }
    
    public int getCol() {
        return this.col;
    }
    
    public char getNumber() {
        return this.number;
    }
    
    public void setPos(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    public boolean dead(){
        return (health <= 0);
    }
    
    public Directions move(Directions direction, Directions[] validMoves){
        throw new UnsupportedOperationException();
    }

    public float attack(){
        return (this.strength + this.sumWeapons());
    }
    
    public boolean defend(float receivedAttack) {
        return manageHit(receivedAttack);
    }
    
    public void receiveReward(){}
      
    public String to_string(){
        throw new UnsupportedOperationException();
    }
    
    private void receiveWeapon(Weapon w){}
    
    private void receiveShield(Shield s){}
    
    private Weapon newWeapon(){
        Weapon n(Dice.weaponPower(), Dice.usesLeft());
        return n;
    }
    
    private Shield newShield(){
        Shield n(Dice.shieldPower(), Dice.usesLeft());
        return n;
    }
    
    private float sumWeapons(){
        float sum = 0;
        for ( int i = 0; i < weapons.size(); i++) {
            sum += weapons.get(i).attack();
        }
        
        return sum;
    }
    
    private float sumShields(){
        float sum = 0;
        for ( int i = 0; i < shields.size(); i++) {
            sum += shields.get(i).protect();
        }
        
        return sum;
    }
    
    private float defensiveEnergy(){
        return (this.intelligence + this.sumShields());
    }
    
    private boolean manageHit(float receivedAttack){
        throw new UnsupportedOperationException();
    }
    
    private void resetHits(){
        this.consecutiveHits = 0;
    }
    
    private void gotWounded(){
        this.health--;
    }
    
    private void incConsecutiveHints(){
        this.consecutiveHits++;
    }
}
