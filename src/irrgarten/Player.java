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
    private static final int INVALID = -1;

    private final String name;
    private final char number;
    private final float intelligence;
    private final float strength;
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
        
        this.row = INVALID;
        this.col = INVALID;
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
    
    public Directions move(Directions direction,
            ArrayList<Directions> validMoves){
        int size = validMoves.size();
        boolean valid = validMoves.contains(direction);

        Directions toReturn;

        if ((size > 0) && !valid){
            toReturn = validMoves.get(0);
        }
        else{
            toReturn = direction;
        }

        return toReturn;
    }

    public float attack(){
        return (this.strength + this.sumWeapons());
    }
    
    public boolean defend(float receivedAttack) {
        return this.manageHit(receivedAttack);
    }
    
    public void receiveReward(){
        int wReward = Dice.weaponsReward();
        for (int i = 0; i < wReward; i++)
            this.receiveWeapon(this.newWeapon());

        int sReward = Dice.shieldsReward();
        for (int i = 0; i < sReward; i++)
            this.receiveShield(this.newShield());

        this.health += Dice.healthReward();
    }
      
    public String to_string(){
        String r = this.name + "[i:" + this.intelligence + ", s:" +
                this.strength + ", h:" + this.health + ", p:(" + this.row +
                "," + this.col + "), ch:" + this.consecutiveHits;
        
        String w = "w:[";
        for (int i = 0; i < this.weapons.size() - 1; i++) {
            w += this.weapons.get(i).toString() + ", ";
        }
        
        if (!this.weapons.isEmpty()) {
            w += this.weapons.get(this.weapons.size() - 1);
        }
        w += "]";
        
        String s = "s:[";
        for (int i = 0; i < this.shields.size() - 1; i++) {
            s += this.shields.get(i).toString() + ", ";
        }
        
        if (!this.shields.isEmpty()) {
            s += this.shields.get(this.shields.size() - 1);
        }
        s += "]";
        
        r += ", " + w + ", " + s + "]";
        
        return r;
    }
    
    private void receiveWeapon(Weapon w) {
        for (int i = 0; i < weapons.size(); i++){
            if (weapons.get(i).discard()){
                weapons.remove(i);
                i--;
            }
        }
        
        if (weapons.size() < MAX_WEAPONS)
            weapons.add(w);
    }
    
    private void receiveShield(Shield s) {
        for (int i = 0; i < shields.size(); i++){
            if (shields.get(i).discard()){
                shields.remove(i);
                i--;
            }
        }

        if (shields.size() < MAX_SHIELDS)
            shields.add(s);
    }
    
    private Weapon newWeapon(){
        return new Weapon(Dice.weaponPower(), Dice.usesLeft());
    }
    
    private Shield newShield(){
        return new Shield(Dice.shieldPower(), Dice.usesLeft());
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
        if (this.defensiveEnergy() < receivedAttack){
            this.gotWounded();
            this.incConsecutiveHits();
        }
        else {
            this.resetHits();
        }

        boolean lost = (this.consecutiveHits == Player.HITS2LOSE)||this.dead();

        if (lost)
            resetHits();

        return lost;
    }
    
    private void resetHits(){
        this.consecutiveHits = 0;
    }
    
    private void gotWounded(){
        this.health--;
    }
    
    private void incConsecutiveHits(){
        this.consecutiveHits++;
    }
}
