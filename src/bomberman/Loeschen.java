package bomberman;

/**
 * Löschen einer Explosion
 * @author Levent Sarp, Dennis Weber, Daniel Gros, Adrian Schmidt, Fabian Pegel
 * @version 0.1
 * 
 *  */

public class Loeschen extends Thread {
		private int neux;
		private int neuy;
		private LaunchFrame lf;
		/**
		 * 
		 * @param x x-Koordinate des zu löschenden Feldes
		 * @param y y-Koordinate des zu löschenden Feldes
		 * @param la Objekt
		 */
		public Loeschen(int x, int y, LaunchFrame la) {
			neux=x;
			neuy=y;
			lf = la;
		}
	/**
	 * nach einer Sekunde Explosionszeit wieder Spielfeld anzeigen
	 */
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

			if(lf.block[neux][neuy].fin==true){
				lf.block[neux][neuy].setIcon(lf.finpic);
				lf.block[neux][neuy].destroyable=false;
			}
			lf.exploaktiv[neux][neuy]=false;
			lf.block[neux][neuy].walkable=true;
	}
}
