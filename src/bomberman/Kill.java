package bomberman;

import java.util.Timer;

public class Kill {
	LaunchFrame lf;
	public int ex;
	public int ey;
	
	public void killplayer(LaunchFrame la, int x, int y){
		ex = x;
		ey = y;
		lf = la;
		if(lf.exploaktiv[ex][ey]==true && lf.bombix==ex && lf.bombiy==ey) // wenn player bei explosion dort steht
		{	System.out.println("Bei Bombe stehengeblieben.");
		lf.block[lf.bombix][lf.bombiy].setIcon(lf.tot);
			lf.spielende=true;
			lf.timer.cancel();
			lf.timer = new Timer();
			lf.timer.schedule(new Ende(lf, "bombe"), 1000);

			lf.timer.schedule(new Ende(lf, "bombe"), 1000);
			}
		// todo: wenn player in bombe läuft
	}
}