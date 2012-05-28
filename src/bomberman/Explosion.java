package bomberman;

import java.util.TimerTask;

//import bomberman.SirBomberman.*;

class Explosion extends TimerTask {
	public LaunchFrame lf;
	public Explosion(LaunchFrame la){
		lf = la;
	}
	public void run() {

	if(lf.block[lf.bombex+1][lf.bombey].destroyable==true) { //bombe 1unten
	lf.block[lf.bombex+1][lf.bombey].setIcon(lf.explo);System.out.println(lf.explo);
		lf.timer.schedule(new Loeschen(lf.bombex+1,lf.bombey, lf), 1000);  	
	}
	if(lf.block[lf.bombex-1][lf.bombey].destroyable==true) { //bombe 1oben
		lf.block[lf.bombex-1][lf.bombey].setIcon(lf.explo);System.out.println(lf.explo);
		lf.timer.schedule(new Loeschen(lf.bombex-1,lf.bombey,lf), 1000);  	
	}
	if(lf.bombex+2<lf.block.length && lf.block[lf.bombex+1][lf.bombey].destroyable==true && lf.block[lf.bombex+2][lf.bombey].destroyable==true) { //bombe 2unten
		lf.block[lf.bombex+2][lf.bombey].setIcon(lf.explo);System.out.println(lf.explo);
		lf.timer.schedule(new Loeschen(lf.bombex+2,lf.bombey,lf), 1000);  	
	}
	if(lf.bombex-2<lf.block.length && lf.block[lf.bombex-1][lf.bombey].destroyable==true && lf.block[lf.bombex-2][lf.bombey].destroyable==true) { //bombe 2oben
		lf.block[lf.bombex-2][lf.bombey].setIcon(lf.explo);System.out.println(lf.explo);
		lf.timer.schedule(new Loeschen(lf.bombex-2,lf.bombey,lf), 1000);  	
	}
	if(lf.block[lf.bombex][lf.bombey+1].destroyable==true) { //bombe 1rechts
		lf.block[lf.bombex][lf.bombey+1].setIcon(lf.explo);System.out.println(lf.explo);
		lf.timer.schedule(new Loeschen(lf.bombex,lf.bombey+1,lf), 1000);  	

	}
	if(lf.block[lf.bombex][lf.bombey-1].destroyable==true) { //bombe 1links
		lf.block[lf.bombex][lf.bombey-1].setIcon(lf.explo);System.out.println(lf.explo);
		lf.timer.schedule(new Loeschen(lf.bombex,lf.bombey-1,lf), 1000);  	

	}
	if(lf.bombey+2<lf.block.length && lf.block[lf.bombex][lf.bombey+1].destroyable==true && lf.block[lf.bombex][lf.bombey+2].destroyable==true) { //bombe 2rechts
		lf.block[lf.bombex][lf.bombey+2].setIcon(lf.explo);System.out.println(lf.explo);
		lf.timer.schedule(new Loeschen(lf.bombex,lf.bombey+2,lf), 1000);  	

	}
	if(lf.bombey-2<lf.block.length && lf.block[lf.bombex][lf.bombey-1].destroyable==true && lf.block[lf.bombex][lf.bombey-2].destroyable==true) { //bombe 2links
		lf.block[lf.bombex][lf.bombey-2].setIcon(lf.explo);System.out.println(lf.explo);
		lf.timer.schedule(new Loeschen(lf.bombex,lf.bombey-2,lf), 1000);  	

	}
	lf.timer.schedule(new Loeschen(lf.bombex,lf.bombey,lf), 1000);  
	lf.gesperrt=false;
	}
}

