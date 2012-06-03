package bomberman;


import javax.swing.ImageIcon;


public class Check {
	private LaunchFrame lf;

    public void check(LaunchFrame la) {
    	lf=la;
    	System.out.println("Ausgange gefunden: "+lf.block[lf.bombix][lf.bombiy].fin);
        if (lf.block[lf.bombix][lf.bombiy].fin == true) {
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
    }
    
    

}
