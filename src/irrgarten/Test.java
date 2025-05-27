package irrgarten;

import irrgarten.controller.Controller;
import irrgarten.UI.GraphicUI;

/**
 * Programa de prueba para la practica 5
 * 
 * @author Fco Javier Ortiz Molinero
 * @author Alejandro Perez Perez
 */
public class Test {
    
    /**
     * Método que realiza las pruebas unia
     * tarias de la práctica 5
     *
     */
    public static void main ( ) {
        
        final int N_PLAYERS = 3;

        GraphicUI vista = new GraphicUI();
        Game juego = new Game(N_PLAYERS);
        Controller controlador = new Controller(juego, vista);

        controlador.play();
    }
}
