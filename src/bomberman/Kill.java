package bomberman;


import javax.swing.ImageIcon;

public class Kill {
	LaunchFrame lf;
	public int ex;
	public int ey;
	
	public void killplayer(LaunchFrame la, int x, int y){
		ex = x;
		ey = y;
		lf = la;
		if(lf.exploaktiv[ex][ey]==true && ((lf.bombix==ex && lf.bombiy==ey) ||(lf.bombax==ex && lf.bombay==ey))) // wenn player bei explosion dort steht
		{	

			System.out.println("Bei Bombe stehengeblieben.");
  		   ImageIcon tot = new ImageIcon(  this.getClass().getResource("/dateien/tot2.gif" ));
  		   if(lf.bombix==ex && lf.bombiy==ey){
		lf.block[lf.bombix][lf.bombiy].setIcon(tot);}
  		   else if(lf.bombax==ex && lf.bombay==ey){
		lf.block[lf.bombax][lf.bombay].setIcon(tot);}

			lf.spielende=true;
			//lf.timer.cancel(); //explosionstimer canceln, damit die volle sekunde das kreuz angezeigt wird
			/*lf.timer = new Timer();
			lf.timer.schedule(new Ende(lf, "bombe"), 1000);*/
			Ende el = new Ende(lf, "bombe");
			el.start();
			}
		// todo: wenn player in bombe läuft
	}
}