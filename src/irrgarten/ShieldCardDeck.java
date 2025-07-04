package irrgarten;

/**
 * Clase que representa la baraja de cartas de tipo Escudo.
 * 
 * @author Fco Javier Ortiz Molinero
 * @author Alejandro Perez Perez
 */

public class ShieldCardDeck extends CardDeck<Shield>{
    
    /**
     * Método que añade todas las cartas de tipo Escudo a la baraja
     * con un tamaño máximo de TAMANIO_MAX cartas
     */
    @Override 
    protected void addCards(){     
        for(int i=0; i<ShieldCardDeck.TAMANIO_MAX; i++){
            this.addCard(new Shield(Dice.shieldPower(), Dice.usesLeft()));
        }
    }
}
