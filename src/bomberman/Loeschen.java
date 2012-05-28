package bomberman;

import java.util.TimerTask;

class Loeschen extends TimerTask {
		private int neux;
		private int neuy;
		private LaunchFrame lf;
	public Loeschen(int x, int y, LaunchFrame la) {
			neux=x;
			neuy=y;
			lf = la;
		}
		public void run() {    		
			lf.block[neux][neuy].setIcon(lf.field);
	}
}
