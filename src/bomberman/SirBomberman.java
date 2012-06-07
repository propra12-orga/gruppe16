package bomberman;
import java.awt.event.*;
import javax.swing.*;

import bomberman.LaunchFrame;
public class SirBomberman implements KeyListener {
	Tasten t = new Tasten();
	Tasten2 t2 = new Tasten2();

	public LaunchFrame lf = new LaunchFrame();
	
	public static void main(String[] args) {
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
    	t.abfragen(lf, e);
    	t2.abfragen(lf, e);

    }
    
    
    
}
