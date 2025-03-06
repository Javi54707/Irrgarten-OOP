/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author usuario
 */
public class Monster {
    
    private static final int INITIAL_HEALTH = 5;
    private String name;
    private float intelligence = 0;
    private float strength = 0;
    private float health = 0;
    private int row = 0;
    private int col = 0;
    
    public Monster (String name, float intelligence, float strength){};
    
    
    public boolean dead(){
        throw new UnsupportedOperationException();
    }
    
    public float attack(){
        throw new UnsupportedOperationException();
    }
    
    public boolean defend(float receivedAttack){
        throw new UnsupportedOperationException();
    }
    
    public void setPos(int row, int col) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public String toString() {
        throw new UnsupportedOperationException();
    }
    
    public void gotWounded(){
        throw new UnsupportedOperationException();
    }
    
            
            
    
    
    
}
