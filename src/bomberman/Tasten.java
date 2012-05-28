package bomberman;

import java.awt.event.KeyEvent;

public class Tasten {
	public LaunchFrame lf;
	public KeyEvent e;
	public Check ch;
	

	
	 public void abfragen(LaunchFrame la, KeyEvent ke) {
			lf = la;
			e = ke;
			ch = new Check();

	    	lf.input=e.getKeyCode();
	        System.out.println(lf.input);
	        
	        if(lf.input==39 && lf.block[lf.bombix][lf.bombiy+1].walkable==true) { //rechts
	    		if(lf.baktiv==true) {
	    			lf.block[lf.bombix][lf.bombiy].setIcon(lf.bombe);
	    			lf.baktiv=false;
	    		}
	    		else {
	    			lf.block[lf.bombix][lf.bombiy].setIcon(lf.field);
	    		}
	    		lf.bombiy++;
	    		lf.block[lf.bombix][lf.bombiy].setIcon(lf.bombermanr);
	    		ch.check(lf);
	    	}
	        if(lf.input==37 && lf.block[lf.bombix][lf.bombiy-1].walkable==true) { //links
	    		if(lf.baktiv==true) {
	    			lf.block[lf.bombix][lf.bombiy].setIcon(lf.bombe);
	    			lf.baktiv=false;

	    		}
	    		else {
	    			lf.block[lf.bombix][lf.bombiy].setIcon(lf.field);
	    		}
	    		lf.bombiy--;
	    		lf.block[lf.bombix][lf.bombiy].setIcon(lf.bombermanl);
	    		ch.check(lf);
	    	}
	        if(lf.input==38 && lf.block[lf.bombix-1][lf.bombiy].walkable==true) { //oben
	    		if(lf.baktiv==true) {
	    			lf.block[lf.bombix][lf.bombiy].setIcon(lf.bombe);
	    			lf.baktiv=false;

	    		}
	    		else {
	    			lf.block[lf.bombix][lf.bombiy].setIcon(lf.field);
	    		}
	    		lf.bombix--;
	    		lf.block[lf.bombix][lf.bombiy].setIcon(lf.bombermano);
	    		ch.check(lf);
	    	}
	        if(lf.input==40 && lf.block[lf.bombix+1][lf.bombiy].walkable==true) { //unten
	    		if(lf.baktiv==true) {
	    			lf.block[lf.bombix][lf.bombiy].setIcon(lf.bombe);
	    			lf.baktiv=false;

	    		}
	    		else {
	    			lf.block[lf.bombix][lf.bombiy].setIcon(lf.field);
	    		}
	    		lf.bombix++;
	    		lf.block[lf.bombix][lf.bombiy].setIcon(lf.bombermanu);
	    		ch.check(lf);
	    	}
	    	    	if(lf.input==32 && lf.gesperrt==false) { //wenn leerzeichen gedrückt
	    	    		lf.bombex = lf.bombix;
	    	    		lf.bombey = lf.bombiy; // das muss hier hin, damit die explosion nicht "mitläuft"
	    	    		lf.baktiv = true;
	    	    		lf.block[lf.bombix][lf.bombiy].setIcon(lf.bombermano2);   
	    	    		lf.gesperrt =true; 
	    	    		lf.timer.schedule(new Explosion(lf), 3000);  	
	    	    	}

	        // SPIEL ENDE?
	        if (lf.spielende==true && lf.input==78) {System.exit(0);}
	        else if (lf.spielende==true && lf.input==89) 
	        {lf.frame.dispose();SirBomberman bombe = new SirBomberman();bombe.launchFrame(); lf.spielende=false;}
	    }
	    
}
