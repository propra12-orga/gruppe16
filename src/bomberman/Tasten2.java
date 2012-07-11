package bomberman;
import java.awt.event.KeyEvent;

/**
 * Tastenauswertung Player2
 * @author Levent Sarp, Dennis Weber, Daniel Gros, Adrian Schmidt, Fabian Pegel
 * @version 0.1
 * 
 *  */

public class Tasten2 {
	public LaunchFrame lf;
	public KeyEvent e;
	public Check ch;
	

/**
 * Abfragen, welche Taste gedrückt wurde, weiterverarbeiten
 * <b>Steuerung Player2: &lt;w&gt; oben - &lt;a&gt; links - &lt;s&gt; unten - &lt;d&gt; rechts - &lt;q&gt; Bombe
 * @param la Objekt
 * @param ke Tasten-Event
 */
	 public void abfragen(LaunchFrame la, KeyEvent ke) {
			lf = la;
			e = ke;
			ch = new Check();
			if(!lf.networkgame) {
				lf.input=e.getKeyCode();
			}
			if (lf.networkgame && lf.playernr==2){
				lf.input=e.getKeyCode();
			}
			if (lf.networkgame && lf.playernr!=2){
				lf.input=lf.anweisung;
			}
	    	
	        System.out.println(lf.input);
	        if(lf.spielende==false){ // darf man noch laufen?
		       
	        	if(lf.input==68 && lf.block[lf.bombax][lf.bombay+1].walkable==true) { //rechts
		    		if(lf.baktiv[lf.bombax][lf.bombay]==true) {
		    			lf.block[lf.bombax][lf.bombay].setIcon(lf.bombe);
		    			lf.block[lf.bombax][lf.bombay].walkable=false;
		    			lf.baktiv[lf.bombax][lf.bombay]=false;
		    		}
		    		else {
		    			lf.block[lf.bombax][lf.bombay].setIcon(lf.field);
		    			lf.block[lf.bombax][lf.bombay].walkable=true;
		    		}
		    		lf.bombay++;
		    		lf.block[lf.bombax][lf.bombay].setIcon(lf.bomberman2r);
		    		lf.block[lf.bombax][lf.bombay].walkable=false;
		    		ch.check(lf);
		    	}
		        
		        if(lf.input==65 && lf.block[lf.bombax][lf.bombay-1].walkable==true) { //links
		    		if(lf.baktiv[lf.bombax][lf.bombay]==true) {
		    			lf.block[lf.bombax][lf.bombay].setIcon(lf.bombe);
		    			lf.block[lf.bombax][lf.bombay].walkable=false;
		    			lf.baktiv[lf.bombax][lf.bombay]=false;
		    		}
		    		else {
		    			lf.block[lf.bombax][lf.bombay].setIcon(lf.field);
		    			lf.block[lf.bombax][lf.bombay].walkable=true;
		    		}
		    		lf.bombay--;
		    		lf.block[lf.bombax][lf.bombay].setIcon(lf.bomberman2l);
		    		lf.block[lf.bombax][lf.bombay].walkable=false;
		    		ch.check(lf);
		    	}
		        
		        if(lf.input==87 && lf.block[lf.bombax-1][lf.bombay].walkable==true) { //oben
		    		if(lf.baktiv[lf.bombax][lf.bombay]==true) {
		    			lf.block[lf.bombax][lf.bombay].setIcon(lf.bombe);
		    			lf.block[lf.bombax][lf.bombay].walkable=false;
		    			lf.baktiv[lf.bombax][lf.bombay]=false;
		    		}
		    		else {
		    			lf.block[lf.bombax][lf.bombay].setIcon(lf.field);
		    			lf.block[lf.bombax][lf.bombay].walkable=true;
		    		}
		    		lf.bombax--;
		    		lf.block[lf.bombax][lf.bombay].setIcon(lf.bomberman2o);
		    		lf.block[lf.bombax][lf.bombay].walkable=false;
		    		ch.check(lf);
		    	}
		        
		        if(lf.input==83 && lf.block[lf.bombax+1][lf.bombay].walkable==true) { //unten
		    		if(lf.baktiv[lf.bombax][lf.bombay]==true) {
		    			lf.block[lf.bombax][lf.bombay].setIcon(lf.bombe);
		    			lf.block[lf.bombax][lf.bombay].walkable=false;
		    			lf.baktiv[lf.bombax][lf.bombay]=false;
		    		}
		    		else {
		    			lf.block[lf.bombax][lf.bombay].setIcon(lf.field);
		    			lf.block[lf.bombax][lf.bombay].walkable=true;
		    		}
		    		lf.bombax++;
		    		lf.block[lf.bombax][lf.bombay].setIcon(lf.bomberman2u);
		    		lf.block[lf.bombax][lf.bombay].walkable=false;
		    		ch.check(lf);
		    	}
		        
		        if(lf.input==81) { // BOMBE
		        	lf.bombex = lf.bombax;
		    	    lf.bombey = lf.bombay; // das muss hier hin, damit die explosion nicht "mitläuft"
		    	    lf.baktiv[lf.bombex][lf.bombey] = true;
		    	    lf.block[lf.bombax][lf.bombay].setIcon(lf.bomberman2o2);  //icon bomba+bombe im hintergrund 
		    	    lf.block[lf.bombax][lf.bombay].bombe=true;
		    	    Explosion explos = new Explosion(lf,lf.bombex,lf.bombey);
		    	    explos.start();
		        }
	        }	    
	    }    

/** 
 * 
 * überladenes Abfragen
 */
	 public void abfragen(LaunchFrame la) {
			lf = la;
			//e = ke;
			ch = new Check();
			

			if(!lf.networkgame) {
				lf.input=e.getKeyCode();
			}
			/*if (lf.networkgame && lf.playernr==2){
				lf.input=e.getKeyCode();
			}*/
			if (lf.networkgame && lf.playernr!=2){
				lf.input=lf.anweisung;
			}

	        System.out.println(lf.input);
	        if(lf.spielende==false){ // darf man noch laufen?
		       
	        	if(lf.input==68 && lf.block[lf.bombax][lf.bombay+1].walkable==true) { //rechts
		    		if(lf.baktiv[lf.bombax][lf.bombay]==true) {
		    			lf.block[lf.bombax][lf.bombay].setIcon(lf.bombe);
		    			lf.block[lf.bombax][lf.bombay].walkable=false;
		    			lf.baktiv[lf.bombax][lf.bombay]=false;
		    		}
		    		else {
		    			lf.block[lf.bombax][lf.bombay].setIcon(lf.field);
		    			lf.block[lf.bombax][lf.bombay].walkable=true;
		    		}
		    		lf.bombay++;
		    		lf.block[lf.bombax][lf.bombay].setIcon(lf.bomberman2r);
		    		lf.block[lf.bombax][lf.bombay].walkable=false;
		    		ch.check(lf);
		    	}
		        
		        if(lf.input==65 && lf.block[lf.bombax][lf.bombay-1].walkable==true) { //links
		    		if(lf.baktiv[lf.bombax][lf.bombay]==true) {
		    			lf.block[lf.bombax][lf.bombay].setIcon(lf.bombe);
		    			lf.block[lf.bombax][lf.bombay].walkable=false;
		    			lf.baktiv[lf.bombax][lf.bombay]=false;
		    		}
		    		else {
		    			lf.block[lf.bombax][lf.bombay].setIcon(lf.field);
		    			lf.block[lf.bombax][lf.bombay].walkable=true;
		    		}
		    		lf.bombay--;
		    		lf.block[lf.bombax][lf.bombay].setIcon(lf.bomberman2l);
		    		lf.block[lf.bombax][lf.bombay].walkable=false;
		    		ch.check(lf);
		    	}
		        
		        if(lf.input==87 && lf.block[lf.bombax-1][lf.bombay].walkable==true) { //oben
		    		if(lf.baktiv[lf.bombax][lf.bombay]==true) {
		    			lf.block[lf.bombax][lf.bombay].setIcon(lf.bombe);
		    			lf.block[lf.bombax][lf.bombay].walkable=false;
		    			lf.baktiv[lf.bombax][lf.bombay]=false;
		    		}
		    		else {
		    			lf.block[lf.bombax][lf.bombay].setIcon(lf.field);
		    			lf.block[lf.bombax][lf.bombay].walkable=true;
		    		}
		    		lf.bombax--;
		    		lf.block[lf.bombax][lf.bombay].setIcon(lf.bomberman2o);
		    		lf.block[lf.bombax][lf.bombay].walkable=false;
		    		ch.check(lf);
		    	}
		        
		        if(lf.input==83 && lf.block[lf.bombax+1][lf.bombay].walkable==true) { //unten
		    		if(lf.baktiv[lf.bombax][lf.bombay]==true) {
		    			lf.block[lf.bombax][lf.bombay].setIcon(lf.bombe);
		    			lf.block[lf.bombax][lf.bombay].walkable=false;
		    			lf.baktiv[lf.bombax][lf.bombay]=false;
		    		}
		    		else {
		    			lf.block[lf.bombax][lf.bombay].setIcon(lf.field);
		    			lf.block[lf.bombax][lf.bombay].walkable=true;
		    		}
		    		lf.bombax++;
		    		lf.block[lf.bombax][lf.bombay].setIcon(lf.bomberman2u);
		    		lf.block[lf.bombax][lf.bombay].walkable=false;
		    		ch.check(lf);
		    	}
		        
		        if(lf.input==81) { // BOMBE wenn leerzeichen gedrückt
		        	lf.bombex = lf.bombax;
		    	    lf.bombey = lf.bombay; // das muss hier hin, damit die explosion nicht "mitläuft"
		    	    lf.baktiv[lf.bombex][lf.bombey] = true;
		    	    lf.block[lf.bombax][lf.bombay].setIcon(lf.bomberman2o2);  //icon bomba+bombe im hintergrund 
		    	    lf.block[lf.bombax][lf.bombay].bombe=true;
		    	    Explosion explos = new Explosion(lf,lf.bombex,lf.bombey);
		    	    explos.start();
		        }
	        }	    
	    }   
}
