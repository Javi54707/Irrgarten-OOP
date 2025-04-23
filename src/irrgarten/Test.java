package irrgarten;

import irrgarten.controller.Controller;
import irrgarten.UI.TextUI;

/**
 *
 * @author Fco Javier Ortiz Molinero
 * @author Alejandro Pérez Pérez
 */
public class Test {
    public static void main(String [] args) {
        final int N_PLAYERS = 3;
        
        TextUI view = new TextUI();
        Game game = new Game(N_PLAYERS);
        Controller controller = new Controller(game, view);
        
        controller.play();
    }
}
