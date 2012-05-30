package bomberman;
import java.awt.event.*;
import javax.swing.*;

import bomberman.LaunchFrame;
public class SirBomberman implements KeyListener {
	public LaunchFrame lf = new LaunchFrame();
	
	public static void main(String[] args) {
		/* erstelle Instanz von SirBomberman */
        SirBomberman game = new SirBomberman();
        game.launchFrame(); 
    }

    
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    
    public SirBomberman() {
    	/* JFrame erzeugen */
    	lf.frame = new JFrame("SirBomberman");
        lf.panel = new JPanel();
    }
    
    public void launchFrame() {
        lf.spielfeld_malen(lf);
        lf.panel.addKeyListener(this);
        lf.panel.requestFocus();
    }


    /* Tastatureingaben abfragen: */
    public void keyPressed(KeyEvent e) {
    	Tasten t = new Tasten();
    	t.abfragen(lf, e);
    }
    
    
    
}
