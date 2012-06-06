package bomberman;


import javax.swing.ImageIcon;


public class Check {
	private LaunchFrame lf;

    public void check(LaunchFrame la) {
    	lf=la;
    	System.out.println("Ausgange gefunden: "+lf.block[lf.bombix][lf.bombiy].fin);
    	System.out.println("Bombe auf feld: " + lf.block[lf.bombix][lf.bombiy].bombe);

        if (lf.block[lf.bombix][lf.bombiy].fin == true || lf.block[lf.bombax][lf.bombay].fin == true) {
        	lf.spielende=true;
        System.out.println(lf.block[lf.bombix][lf.bombiy].fin);
        Ende en = new Ende(lf, "treppe");
        en.start();
        }
    		if(lf.exploaktiv[lf.bombix][lf.bombiy]!=null && lf.exploaktiv[lf.bombix][lf.bombiy]==true) {

    			System.out.println("In Explosion gelaufen.");
      		   ImageIcon tot = new ImageIcon(  this.getClass().getResource("/dateien/tot2.gif" ));

    			lf.block[lf.bombix][lf.bombiy].setIcon(tot);
    			lf.spielende=true;
    	        Ende en = new Ende(lf, "bombe");
    	        en.start();

    		}
    		
    		else if(lf.exploaktiv[lf.bombax][lf.bombay]!=null && lf.exploaktiv[lf.bombax][lf.bombay]==true) {

    			System.out.println("In Explosion gelaufen.");
      		   ImageIcon tot = new ImageIcon(  this.getClass().getResource("/dateien/tot2.gif" ));

    			lf.block[lf.bombax][lf.bombay].setIcon(tot);
    			lf.spielende=true;
    	        Ende en = new Ende(lf, "bombe");
    	        en.start();

    		}

    }
    
    

}
