package bomberman;

import java.util.Timer;


public class Check {
	private LaunchFrame lf;

    public void check(LaunchFrame la) {
    	lf=la;
        if (lf.block[lf.bombix][lf.bombiy].fin == true) {
        	lf.spielende=true;
        System.out.println(lf.block[lf.bombix][lf.bombiy].fin);
		lf.timer.schedule(new Ende(lf, "treppe"), 0);
        }
    		if(lf.exploaktiv[lf.bombix][lf.bombiy]!=null && lf.exploaktiv[lf.bombix][lf.bombiy]==true) {
    			System.out.println("In Explosion gelaufen.");
    			lf.block[lf.bombix][lf.bombiy].setIcon(lf.tot);
    			lf.spielende=true;
    			lf.timer.cancel();
    			lf.timer = new Timer();
    			lf.timer.schedule(new Ende(lf, "bombe"), 1000);
    		}
    }
    
    

}
