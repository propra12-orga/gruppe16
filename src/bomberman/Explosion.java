package bomberman;

import java.util.TimerTask;

//import bomberman.SirBomberman.*;

class Explosion extends TimerTask {
	public LaunchFrame lf;
	private int ex;
	private int ey;
	public Explosion(LaunchFrame la, int x, int y){
		lf = la;
		ex=x;
		ey=y;
	}
	public void run() {
		Kill k = new Kill();
		boolean noproblem=false;
		int d=0;
		for(int j=-2; j<=2; j++){
			if(j!=0){
				if(j==2||j==-2){
					if(j>0){d=1;}else{d=-1;}
						if(ex+j<lf.block.length && lf.block[ex+d][ey].destroyable==true && lf.block[ex+j][ey].destroyable==true)
				{noproblem=true;}else{noproblem=false;}
			}else{noproblem=true;}		

			if(noproblem==true && lf.block[ex+j][ey].destroyable==true) { //bombe 1unten
				lf.block[ex+j][ey].setIcon(lf.explo);
				lf.exploaktiv[ex+j][ey]=true;
				k.killplayer(lf,ex+j,ey);
					lf.timer2.schedule(new Loeschen(ex+j,ey, lf), 1000);
					if(lf.block[ex+j][ey].bombe==true){
						System.out.println("Weitere Bombe gezŸndet. x-achse");
						lf.timer.cancel();
			    		lf.timer2.schedule(new Explosion(lf,ex+j,ey), 0);  
			    		lf.block[ex+j][ey].bombe=false;

					}
				}	
			}}

		for(int j=-2; j<=2; j++){
			if(j!=0){
				if(j==2||j==-2){
					if(j>0){d=1;}else{d=-1;}
						if(ey+j<lf.block.length && lf.block[ex][ey+d].destroyable==true && lf.block[ex][ey+j].destroyable==true)
				{noproblem=true;}else{noproblem=false;}
			}else{noproblem=true;}			

			if(noproblem==true && lf.block[ex][ey+j].destroyable==true) { //bombe 1unten
				lf.block[ex][ey+j].setIcon(lf.explo);
				lf.exploaktiv[ex][ey+j]=true;
				k.killplayer(lf,ex,ey+j);
					lf.timer2.schedule(new Loeschen(ex,ey+j, lf), 1000);
					if(lf.block[ex][ey+j].bombe==true){
						System.out.println("Weitere Bombe gezŸndet. y-achse");
						lf.timer.cancel();
			    		lf.timer2.schedule(new Explosion(lf,ex,ey+j), 0);  
			    		lf.block[ex][ey+j].bombe=false;

					}
				}	
	}}

		
		
		
	
	/*if(lf.block[ex+1][ey].destroyable==true) { //bombe 1unten
	lf.block[ex+1][ey].setIcon(lf.explo);
	lf.exploaktiv[ex+1][ey]=true;
	k.killplayer(lf,ex+1,ey);
		lf.timer2.schedule(new Loeschen(ex+1,ey, lf), 1000);
		if(lf.block[ex+1][ey].bombe==true){
			System.out.println("Weitere Bombe gezŸndet.");
			lf.timer.cancel();
    		lf.timer2.schedule(new Explosion(lf,ex+1,ey), 0);  
    		lf.block[ex+1][ey].bombe=false;

		}
	}
	if(lf.block[ex-1][ey].destroyable==true) { //bombe 1oben
		lf.block[ex-1][ey].setIcon(lf.explo);
		lf.exploaktiv[ex-1][ey]=true;
		k.killplayer(lf,ex-1,ey);

		lf.timer2.schedule(new Loeschen(ex-1,ey,lf), 1000);  	
	}
	if(ex+2<lf.block.length && lf.block[ex+1][ey].destroyable==true && lf.block[ex+2][ey].destroyable==true) { //bombe 2unten
		lf.block[ex+2][ey].setIcon(lf.explo);
		lf.exploaktiv[ex+2][ey]=true;
		k.killplayer(lf,ex+2,ey);

		lf.timer2.schedule(new Loeschen(ex+2,ey,lf), 1000);  	
	}
	if(ex-2<lf.block.length && lf.block[ex-1][ey].destroyable==true && lf.block[ex-2][ey].destroyable==true) { //bombe 2oben
		lf.block[ex-2][ey].setIcon(lf.explo);
		lf.exploaktiv[ex-2][ey]=true;
		k.killplayer(lf,ex-2,ey);

		lf.timer2.schedule(new Loeschen(ex-2,ey,lf), 1000);  	
	}
	if(lf.block[ex][ey+1].destroyable==true) { //bombe 1rechts
		lf.block[ex][ey+1].setIcon(lf.explo);
		lf.exploaktiv[ex][ey+1]=true;
		k.killplayer(lf,ex,ey+1);

		lf.timer2.schedule(new Loeschen(ex,ey+1,lf), 1000);  	

	}
	if(lf.block[ex][ey-1].destroyable==true) { //bombe 1links
		lf.block[ex][ey-1].setIcon(lf.explo);
		lf.exploaktiv[ex][ey-1]=true;
		k.killplayer(lf,ex,ey-1);

		lf.timer2.schedule(new Loeschen(ex,ey-1,lf), 1000);  	

	}
	if(ey+2<lf.block.length && lf.block[ex][ey+1].destroyable==true && lf.block[ex][ey+2].destroyable==true) { //bombe 2rechts
		lf.block[ex][ey+2].setIcon(lf.explo);
		lf.exploaktiv[ex][ey+2]=true;
		k.killplayer(lf,ex,ey+2);

		lf.timer2.schedule(new Loeschen(ex,ey+2,lf), 1000);  	

	}
	if(ey-2<lf.block.length && lf.block[ex][ey-1].destroyable==true && lf.block[ex][ey-2].destroyable==true) { //bombe 2links
		lf.block[ex][ey-2].setIcon(lf.explo);
		lf.exploaktiv[ex][ey-2]=true;
		k.killplayer(lf,ex,ey-2);

		lf.timer2.schedule(new Loeschen(ex,ey-2,lf), 1000);  	

	}*/
	//feld auf dem bombe ist soll auch tšten:
	lf.exploaktiv[ex][ey]=true;
	k.killplayer(lf,ex,ey);
	lf.timer2.schedule(new Loeschen(ex,ey,lf), 1000);  //bombe selber
	lf.block[ex][ey].bombe=false;

	}
}

