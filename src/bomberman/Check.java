package bomberman;


public class Check {
	private LaunchFrame lf;
   public Ende end = new Ende();

    public void check(LaunchFrame la) {
    	lf=la;
        if (lf.block[lf.bombix][lf.bombiy].fin == true) lf.spielende=true;
        System.out.println(lf.block[lf.bombix][lf.bombiy].fin);
        end.spielende(lf, "treppe");
    		if(lf.exploaktiv[lf.bombix][lf.bombiy]!=null && lf.exploaktiv[lf.bombix][lf.bombiy]==true) {
    			System.out.println("In Explosion gelaufen.");
    			lf.spielende=true;
    			end.spielende(lf, "bombe");
    		}
    }
    
    

}
