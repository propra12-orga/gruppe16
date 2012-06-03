package bomberman;

import java.util.Timer;


public class Check {
	private LaunchFrame lf;

    public void check(LaunchFrame la) {
    	lf=la;
    	Timer sieg = new Timer();
    	System.out.println("Ausgange gefunden: "+lf.block[lf.bombix][lf.bombiy].fin);
        if (lf.block[lf.bombix][lf.bombiy].fin == true) {
        	lf.spielende=true;
        System.out.println(lf.block[lf.bombix][lf.bombiy].fin);
		sieg.schedule(new Ende(lf, "treppe"), 0);
        }
    		if(lf.exploaktiv[lf.bombix][lf.bombiy]!=null && lf.exploaktiv[lf.bombix][lf.bombiy]==true) {
    			System.out.println("In Explosion gelaufen.");
    			lf.block[lf.bombix][lf.bombiy].setIcon(lf.tot);
    			lf.spielende=true;
    			/*lf.timer.cancel(); //explosionstimer canceln, damit die volle sekunde das kreuz angezeigt wird
    			lf.timer2.cancel(); //explosionstimer canceln, damit die volle sekunde das kreuz angezeigt wird
				*/
    			Timer finish = new Timer();
    			finish.schedule(new Ende(lf, "bombe"), 1000);
    		}
    }
    
    

}
