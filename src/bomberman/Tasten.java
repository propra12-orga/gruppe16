package bomberman;
import java.awt.event.KeyEvent;

/**
 * Tastenauswertung Player1
 * @author Levent Sarp, Dennis Weber, Daniel Gros, Adrian Schmidt, Fabian Pegel
 * @version 0.1
 * 
 *  */

public class Tasten {
	public LaunchFrame lf;
	public KeyEvent e;
	public Check ch;
	
    boolean f1=false;
    boolean l1=false;
    boolean a1=false;
    boolean d1=false;
    boolean d2=false;

	/**
	 * Abfragen, welche Taste gedrückt wurde, weiterverarbeiten 
	 * @param la Objekt
	 * @param ke Tasten-Event
	 */
	 public void abfragen(LaunchFrame la, KeyEvent ke) {
			lf = la;
			e = ke;
			ch = new Check();

	    	lf.input=e.getKeyCode();
	        System.out.println(lf.input);
	        if(lf.spielende==false){ // darf man noch laufen?
	       
	        	if(lf.input==39 && lf.block[lf.bombix][lf.bombiy+1].walkable==true) { //rechts
		    		if(lf.baktiv[lf.bombix][lf.bombiy]==true) {
		    			lf.block[lf.bombix][lf.bombiy].setIcon(lf.bombe);
		    			lf.block[lf.bombix][lf.bombiy].walkable=false;
		    			lf.baktiv[lf.bombix][lf.bombiy]=false;
		    		}
		    		else {
		    			lf.block[lf.bombix][lf.bombiy].setIcon(lf.field);
		    		}
		    		lf.bombiy++;
		    		lf.block[lf.bombix][lf.bombiy].setIcon(lf.bombermanr);
		    		ch.check(lf);
		    	}
	        
		        if(lf.input==37 && lf.block[lf.bombix][lf.bombiy-1].walkable==true) { //links
		    		if(lf.baktiv[lf.bombix][lf.bombiy]==true) {
		    			lf.block[lf.bombix][lf.bombiy].setIcon(lf.bombe);
		    			lf.block[lf.bombix][lf.bombiy].walkable=false;
		    			lf.baktiv[lf.bombix][lf.bombiy]=false;
	
		    		}
		    		else {
		    			lf.block[lf.bombix][lf.bombiy].setIcon(lf.field);
		    		}
		    		lf.bombiy--;
		    		lf.block[lf.bombix][lf.bombiy].setIcon(lf.bombermanl);
		    		ch.check(lf);
		    	}
		        
		        if(lf.input==38 && lf.block[lf.bombix-1][lf.bombiy].walkable==true) { //oben
		    		if(lf.baktiv[lf.bombix][lf.bombiy]==true) {
		    			lf.block[lf.bombix][lf.bombiy].setIcon(lf.bombe);
		    			lf.block[lf.bombix][lf.bombiy].walkable=false;
		    			lf.baktiv[lf.bombix][lf.bombiy]=false;
	
		    		}
		    		else {
		    			lf.block[lf.bombix][lf.bombiy].setIcon(lf.field);
		    		}
		    		lf.bombix--;
		    		lf.block[lf.bombix][lf.bombiy].setIcon(lf.bombermano);
		    		ch.check(lf);
		    	}
		        
		        if(lf.input==40 && lf.block[lf.bombix+1][lf.bombiy].walkable==true) { //unten
		    		if(lf.baktiv[lf.bombix][lf.bombiy]==true) {
		    			lf.block[lf.bombix][lf.bombiy].setIcon(lf.bombe);
		    			lf.block[lf.bombix][lf.bombiy].walkable=false;
		    			lf.baktiv[lf.bombix][lf.bombiy]=false;
	
		    		}
		    		else {
		    			lf.block[lf.bombix][lf.bombiy].setIcon(lf.field);
		    		}
		    		lf.bombix++;
		    		lf.block[lf.bombix][lf.bombiy].setIcon(lf.bombermanu);
		    		ch.check(lf);
		    	}
		        
		        if(lf.input==32) { // BOMBE wenn leerzeichen gedrückt
		        	lf.bombex = lf.bombix;
		    	    lf.bombey = lf.bombiy; // das muss hier hin, damit die explosion nicht "mitläuft"
		    	    lf.baktiv[lf.bombex][lf.bombey] = true;
		    	    lf.block[lf.bombix][lf.bombiy].setIcon(lf.bombermano2);  //icon bombi+bombe im hintergrund 
		    	    lf.block[lf.bombix][lf.bombiy].bombe=true;
		    	    Explosion explos = new Explosion(lf,lf.bombex,lf.bombey);
		    	    explos.start();
		        }
	        }

	        /* Bonuslevel fladd */
	        
	        if(lf.input==70) {f1=true;System.out.println(f1);}
	        if(lf.input==76) {l1=true;System.out.println(l1);}
	        if(lf.input==65) {a1=true;System.out.println(a1);}
	        if(lf.input==68 && d1) {d2=true;System.out.println(d2);}
	        if(lf.input==68) {d1=true;System.out.println(d1);}
	        
	        if(f1 && l1 && a1 && d1 && d2){
	        	new Fladd();
	        	f1=false;l1=false;a1=false;d1=false;d2=false;
	        }
	        
	        /* ENDE Bonuslevel fladd */

	        
	        // SPIEL ENDE?
	        if (lf.spielende==true && lf.input==78) {System.exit(0);}

	        
	        else if (lf.spielende==true && lf.input==89) 
	        { 
	        	lf.frame.dispose();
	        	SirBomberman bombe = new SirBomberman();
	        	bombe.launchFrame();
	        	lf.spielende=false;
	        }
	    }  
}
