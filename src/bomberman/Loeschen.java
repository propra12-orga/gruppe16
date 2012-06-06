package bomberman;

//import java.util.TimerTask;

class Loeschen extends Thread {
		private int neux;
		private int neuy;
		private LaunchFrame lf;
	public Loeschen(int x, int y, LaunchFrame la) {
			neux=x;
			neuy=y;
			lf = la;
		}
		public void run() { 

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(lf.block[lf.bombix][lf.bombiy]!=lf.block[neux][neuy] && lf.block[lf.bombax][lf.bombay]!=lf.block[neux][neuy] && lf.block[neux][neuy].fin!=true) {
				lf.block[neux][neuy].setIcon(lf.field);
			
			}
			/*if(lf.block[lf.bombax][lf.bombay]!=lf.block[neux][neuy] && lf.block[neux][neuy].fin!=true) {
				lf.block[neux][neuy].setIcon(lf.field);
			
			}*/

			if(lf.block[neux][neuy].fin==true){
				lf.block[neux][neuy].setIcon(lf.finpic);
			}
			lf.exploaktiv[neux][neuy]=false;

			lf.block[neux][neuy].walkable=true;
	}
}
