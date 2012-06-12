package bomberman;
import java.awt.event.*;
import javax.swing.*;
import bomberman.LaunchFrame;

/**
 * Hauptklasse
 * @author Levent Sarp, Dennis Weber, Daniel Gros, Adrian Schmidt, Fabian Pegel
 * @version 0.1
 * 
 *  */
public class SirBomberman implements KeyListener {
	Tasten t = new Tasten();
	Tasten2 t2 = new Tasten2();

	/**
	 * Objekt erzeugen, das an alle Klassen weitergegeben wird
	 */
	public LaunchFrame lf = new LaunchFrame();
	
	public static void main(String[] args) {
        SirBomberman game = new SirBomberman();
        game.launchFrame(); 
    }

    
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    
    /**
     * Konstruktor zur Frameerzeugung
     */
    public SirBomberman() {
    	lf.frame = new JFrame("SirBomberman");
        lf.panel = new JPanel();
    }
    
    /**
     * Spielfeld erzeugen
     */
    public void launchFrame() {
        lf.spielfeld_malen(lf);
        lf.panel.addKeyListener(this);
        lf.panel.requestFocus();
    }


/**
 * Abfragen der Tastatureingaben während des Spiels
 */
    public void keyPressed(KeyEvent e) {
    	t.abfragen(lf, e);
    	t2.abfragen(lf, e);
    }   
}
