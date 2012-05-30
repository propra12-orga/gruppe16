package bomberman;

public class Kill {
	LaunchFrame lf;
	public int ex;
	public int ey;
	
	public void killplayer(LaunchFrame la, int x, int y){
		ex = x;
		ey = y;
		lf = la;
		Ende end = new Ende();
		if(lf.exploaktiv[ex][ey]==true && lf.bombix==ex && lf.bombiy==ey) // wenn player bei explosion dort steht
		{	System.out.println("Bei Bombe stehengeblieben.");
			lf.spielende=true;
			end.spielende(lf,"bombe");
			}
		// todo: wenn player in bombe läuft
	}
}