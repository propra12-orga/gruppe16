package bomberman;

import java.awt.event.KeyEvent;

public class Tasten2 {
	public LaunchFrame lf;
	public KeyEvent e;
	public Check ch;
	

	
	 public void abfragen(LaunchFrame la, KeyEvent ke) {
			lf = la;
			e = ke;
			ch = new Check();

	    	lf.input=e.getKeyCode();
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
	    		}
	    		lf.bombay++;
	    		lf.block[lf.bombax][lf.bombay].setIcon(lf.bomberman2r);
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
	    		}
	    		lf.bombay--;
	    		lf.block[lf.bombax][lf.bombay].setIcon(lf.bomberman2l);
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
	    		}
	    		lf.bombax--;
	    		lf.block[lf.bombax][lf.bombay].setIcon(lf.bomberman2o);
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
	    		}
	    		lf.bombax++;
	    		lf.block[lf.bombax][lf.bombay].setIcon(lf.bomberman2u);
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

	        // SPIEL ENDE?
	        if (lf.spielende==true && lf.input==78) {System.exit(0);}
	        else if (lf.spielende==true && lf.input==89) 
	        { 	        	
	        	lf.frame.dispose();
	        	SirBomberman bombe = new SirBomberman();
	        	bombe.launchFrame();
	        	lf.spielende=false;}
	    }
	    
}
