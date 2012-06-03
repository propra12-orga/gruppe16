package bomberman;

import java.awt.event.KeyEvent;
import java.util.Timer;

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
	        if(lf.spielende==false){ // darf man noch laufen?
	        if(lf.input==39 && lf.block[lf.bombix][lf.bombiy+1].walkable==true) { //rechts
	    		if(lf.baktiv==true) {
	    			lf.block[lf.bombix][lf.bombiy].setIcon(lf.bombe);
	    			lf.block[lf.bombix][lf.bombiy].walkable=false;
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
	    			lf.block[lf.bombix][lf.bombiy].walkable=false;
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
	    			lf.block[lf.bombix][lf.bombiy].walkable=false;
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
	    			lf.block[lf.bombix][lf.bombiy].walkable=false;
	    			lf.baktiv=false;

	    		}
	    		else {
	    			lf.block[lf.bombix][lf.bombiy].setIcon(lf.field);
	    		}
	    		lf.bombix++;
	    		lf.block[lf.bombix][lf.bombiy].setIcon(lf.bombermanu);
	    		ch.check(lf);
	    	}
	    	    	if(lf.input==32) { // BOMBE wenn leerzeichen gedrückt
	    	    		//lf.timer = new Timer();
	    	    		lf.bombex = lf.bombix;
	    	    		lf.bombey = lf.bombiy; // das muss hier hin, damit die explosion nicht "mitläuft"
	    	    		lf.baktiv = true;
	    	    		lf.block[lf.bombix][lf.bombiy].setIcon(lf.bombermano2);  //icon bombi+bombe im hintergrund 
	    	    		lf.block[lf.bombix][lf.bombiy].bombe=true;
	    	    		lf.timer[lf.bombex][lf.bombey] = new Timer();
	    	    		lf.timer[lf.bombex][lf.bombey].schedule(new Explosion(lf,lf.bombex,lf.bombey), 3000);
	    	    	}
	        }

	        // SPIEL ENDE?
	        if (lf.spielende==true && lf.input==78) {System.exit(0);}
	        else if (lf.spielende==true && lf.input==89) 
	        {	for (int k=0; k<=10; k++){
	        		for (int l=0; l<=10; l++){
	        	if(lf.timer[k][l]!=null){lf.timer[k][l].cancel();}
	        	if(lf.timer2[k][l]!=null){lf.timer2[k][l].cancel();}
	        		}
	        		}
	        	
	        	lf.frame.dispose();SirBomberman bombe = new SirBomberman();bombe.launchFrame(); lf.spielende=false;}
	    }
	    
}
