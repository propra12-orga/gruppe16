package bomberman;
import javax.swing.ImageIcon;

/**
 * überprüfen ob Ausgang gefunden oder in Explosion gelaufen
 * @author Levent Sarp, Dennis Weber, Daniel Gros, Adrian Schmidt, Fabian Pegel
 * @version 0.1
 * 
 *  */

public class Check {
	private LaunchFrame lf;

	/**
 * Funktion für Überprüfung
 * @param la Objekt
 */
    public void check(LaunchFrame la) {
    	lf=la;
    	System.out.println("Ausgange gefunden: "+lf.block[lf.bombix][lf.bombiy].fin);
    	System.out.println("Bombe auf feld: " + lf.block[lf.bombix][lf.bombiy].bombe);
    	
    	/** Wenn einer der beiden Spieler den Ausgang erreicht hat */
        
    	if (lf.block[lf.bombix][lf.bombiy].fin == true || lf.block[lf.bombax][lf.bombay].fin == true) {
        	/** Dann spielende true und Zielscreen an Ende() übergeben */
        	lf.spielende=true;
        	System.out.println(lf.block[lf.bombix][lf.bombiy].fin);
        	Ende en = new Ende(lf, "treppe");
        	en.start();
        }
    	
        /** sonst in-Bombe-gelaufen-Screen übergeben: */
    	
    	if(lf.exploaktiv[lf.bombix][lf.bombiy]!=null && lf.exploaktiv[lf.bombix][lf.bombiy]==true) {
    		System.out.println("In Explosion gelaufen.");
      		ImageIcon tot = new ImageIcon(  this.getClass().getResource("/dateien/tot2.gif" ));
    		lf.block[lf.bombix][lf.bombiy].setIcon(tot);
    		lf.spielende=true;
    	    Ende en = new Ende(lf, "bombepl1");
    	    en.start();
    	}
    	
    	/** (Überprüfunge bei Player2) */
    	
    	else if(lf.exploaktiv[lf.bombax][lf.bombay]!=null && lf.exploaktiv[lf.bombax][lf.bombay]==true) {
    		System.out.println("In Explosion gelaufen.");
      		ImageIcon tot = new ImageIcon(  this.getClass().getResource("/dateien/tot2.gif" ));
    		lf.block[lf.bombax][lf.bombay].setIcon(tot);
    		lf.spielende=true;
    	    Ende en = new Ende(lf, "bombepl2");
    	    en.start();
    	}
    }
}
