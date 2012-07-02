package bomberman;

/**
 * Explosionsthread
 * @author Levent Sarp, Dennis Weber, Daniel Gros, Adrian Schmidt, Fabian Pegel
 * @version 0.1
 * 
 *  */

public class Explosion extends Thread {
	public LaunchFrame lf;
	private int ex;
	private int ey;
	
	/**
	 * 
	 * @param la Objekt
	 * @param x x-Koordinate der Explosion
	 * @param y y-Koordinate der Explosion
	 */
	
	public Explosion(LaunchFrame la, int x, int y){
		lf = la;
		ex=x;
		ey=y;
	}
	
	/**
	 * Bombe nach 2 Sekunden, auslösen; bei Kettenreaktion sofort
	 */
	
	public void run() {
		
		if(lf.anderebombe==false){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		else if (lf.anderebombe==true){
			lf.anderebombe=false;
		}
		
		Kill k = new Kill();
		boolean noproblem=false;
		int d=0;
		
		/** Überprüfung x-Achse */
		
		if(lf.block[ex][ey].bombe==true){
			for(int j=-2; j<=2; j++){
				if(j!=0){
					if(j==2||j==-2){
						if(j>0){d=1;}else{d=-1;}
							if(ex+j<lf.block.length && lf.block[ex+d][ey].destroyable==true && lf.block[ex+j][ey].destroyable==true) {
								noproblem=true;}else{noproblem=false;
							}
					}
					else {
						noproblem=true;
					}		
	
					if(noproblem==true && lf.block[ex+j][ey].destroyable==true) { //bombe 1unten
						lf.block[ex+j][ey].setIcon(lf.explo);
						lf.exploaktiv[ex+j][ey]=true;
						k.killplayer(lf,ex+j,ey);
						Loeschen loe = new Loeschen(ex+j,ey,lf);
						loe.start();
						if(lf.block[ex+j][ey].bombe==true){
				    		int exj = ex+j;
				    		System.out.println("Weitere Bombe auf " + exj + "|" + ey + " gefunden.");
				    		lf.anderebombe = true;
		    	    		Explosion explox = new Explosion(lf,ex+j,ey);
		    	    		explox.start();
						}
					}	
				}
			}
		}
		
		/** Überprüfung y-Achse */
		
		if(lf.block[ex][ey].bombe==true){
			for(int j=-2; j<=2; j++){
				if(j!=0){
					if(j==2||j==-2){
						if(j>0){d=1;}else{d=-1;}
							if(ey+j<lf.block.length && lf.block[ex][ey+d].destroyable==true && lf.block[ex][ey+j].destroyable==true) {
								noproblem=true;}else{noproblem=false;
							}
					}
					else {
						noproblem=true;
					}			
	
				if(noproblem==true && lf.block[ex][ey+j].destroyable==true) { //bombe 1unten
					lf.block[ex][ey+j].setIcon(lf.explo);
					lf.exploaktiv[ex][ey+j]=true;
					k.killplayer(lf,ex,ey+j);
					Loeschen loe = new Loeschen(ex,ey+j,lf);
					loe.start();
					if(lf.block[ex][ey+j].bombe==true){
			    		int eyj = ey+j;
			    		System.out.println("Weitere Bombe auf " + ex + "|" + eyj + " gefunden.");
			    		lf.anderebombe = true;
	    	    		Explosion exploy = new Explosion(lf,ex,ey+j);
	    	    		exploy.start();
					}    	    		
				}	
				}
			}
		}
		
		/** Überprüfung Bombe selbst*/
		
		if(lf.block[ex][ey].bombe==true){
			lf.exploaktiv[ex][ey]=true;
			k.killplayer(lf,ex,ey);
			Loeschen loer = new Loeschen(ex,ey,lf);
			loer.start();
			lf.block[ex][ey].bombe=false;
		}
	}
}

