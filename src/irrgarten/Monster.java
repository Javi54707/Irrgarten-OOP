package irrgarten;

/**
 *
 * @author Fco Javier Ortiz Molinero
 * @author Alejandro Pérez Pérez
 */
public class Monster {
    private static final int INVALID = -1;
    private static final int INITIAL_HEALTH = 5;
    private final String name;
    private final float intelligence;
    private final float strength;
    private float health;
    private int row;
    private int col;
    
    public Monster (String name, float intelligence, float strength){
        this.name = name;
        this.intelligence = intelligence;
        this.strength = strength;
        this.health = INITIAL_HEALTH;
        this.row = INVALID;
        this.col = INVALID;
    };
    
    
    public boolean dead(){
        return (this.health <= 0);
    }
    
    public float attack(){
        return Dice.intensity(this.strength);
    }
    
    public boolean defend(float receivedAttack){
        boolean dead = this.dead();
 
        if (!dead){
            if (Dice.intensity(this.intelligence) < receivedAttack){
                this.gotWounded();
                dead = this.dead();
            }
        }

        return dead;
    }
    
    public void setPos(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    @Override
    public String toString() {
        String r = this.name + "[i:" + this.intelligence + ", s:" +
                this.strength + ", h:" + this.health + ", p:(" + this.row +
                "," + this.col + ")]";
        
        return r;
    }
    
    private void gotWounded(){
        this.health--;
    }
}
