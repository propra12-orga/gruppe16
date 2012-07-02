package bomberman;
import java.awt.event.*;
<<<<<<< HEAD
import java.io.IOException;

import javax.swing.*;

=======
import javax.swing.*;
>>>>>>> 4d6066ee247af2e3a6ea389adf8e49e8518dba29
import bomberman.LaunchFrame;

/**
 * Hauptklasse
 * @author Levent Sarp, Dennis Weber, Daniel Gros, Adrian Schmidt, Fabian Pegel
 * @version 0.1
 * 
 *  */
public class SirBomberman implements KeyListener {
<<<<<<< HEAD
=======
	Tasten t = new Tasten();
	Tasten2 t2 = new Tasten2();
>>>>>>> 4d6066ee247af2e3a6ea389adf8e49e8518dba29

	/**
	 * Objekt erzeugen, das an alle Klassen weitergegeben wird
	 */
<<<<<<< HEAD
	public LaunchFrame lf;
	

=======
	public LaunchFrame lf = new LaunchFrame();
>>>>>>> 4d6066ee247af2e3a6ea389adf8e49e8518dba29
	
	public static void main(String[] args) {
        SirBomberman game = new SirBomberman();
        game.launchFrame(); 
<<<<<<< HEAD
        
     
=======
>>>>>>> 4d6066ee247af2e3a6ea389adf8e49e8518dba29
    }

    
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
<<<<<<< HEAD
=======
    
>>>>>>> 4d6066ee247af2e3a6ea389adf8e49e8518dba29
    /**
     * Konstruktor zur Frameerzeugung
     */
    public SirBomberman() {
<<<<<<< HEAD
    	lf = new LaunchFrame();

    	lf.frame = new JFrame("SirBomberman");
        lf.panel = new JPanel();
        Vorabfragen Va = new Vorabfragen();
        Va.fragen(lf);
=======
    	lf.frame = new JFrame("SirBomberman");
        lf.panel = new JPanel();
>>>>>>> 4d6066ee247af2e3a6ea389adf8e49e8518dba29
    }
    
    /**
     * Spielfeld erzeugen
     */
    public void launchFrame() {
        lf.spielfeld_malen(lf);
        lf.panel.addKeyListener(this);
        lf.panel.requestFocus();
<<<<<<< HEAD
        if(lf.networkgame){
        	//if(lf.netz.socket!=null){System.out.println(lf.netz.socket);}
        	

        try {
        		//lf.netz.socket.close();
     			lf.netz = new Network();
     		} catch (IOException e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     		}
             try {
				lf.netz.hoeren(lf);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
   }
=======
    }

>>>>>>> 4d6066ee247af2e3a6ea389adf8e49e8518dba29

/**
 * Abfragen der Tastatureingaben während des Spiels
 */
    public void keyPressed(KeyEvent e) {
<<<<<<< HEAD
    	if(lf.networkgame && lf.playernr==1){
    	lf.t.abfragen(lf, e);
    	try {
			lf.netz.senden(lf, e);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	}
    	if(lf.networkgame && lf.playernr==2){
    	lf.t2.abfragen(lf, e);
    	try {
			lf.netz.senden(lf, e);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

    	}
    	
    	if(!lf.networkgame) {
        	lf.t2.abfragen(lf, e);
        	lf.t.abfragen(lf, e);

    	}
    }   
    
    /**
     * Netzwerk nach Tastendrücken abfragen
     */
    	
}

=======
    	t.abfragen(lf, e);
    	t2.abfragen(lf, e);
    }   
}
>>>>>>> 4d6066ee247af2e3a6ea389adf8e49e8518dba29
