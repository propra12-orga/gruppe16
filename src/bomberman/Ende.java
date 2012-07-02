package bomberman;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Blende den End-Bildschirm ein
 * @author Levent Sarp, Dennis Weber, Daniel Gros, Adrian Schmidt, Fabian Pegel
 * @version 0.1
 * 
 *  */

public class Ende extends Thread {
	public LaunchFrame lf;
	public String sf;

	/**
	 * 
	 * @param la Objekt
	 * @param st Überprüfungsstring <small>("bombe", oder "treppe")</small>
	 */
	
	public Ende(LaunchFrame la, String st){
		lf=la;
		sf=st;
	}

	/**
	 * Wenn "treppe" übergeben wird, Zielscreen einblenden; bei "Bombe" den Explosionsscreen
	 */
	
	public void run(){
	    if (lf.spielende==true){
<<<<<<< HEAD
	    	if(sf.equals("bombepl1")||sf.equals("bombepl2")){
=======
	    	if(sf.equals("bombe")){
>>>>>>> 4d6066ee247af2e3a6ea389adf8e49e8518dba29
		    	try {
					Thread.sleep(800);
					System.out.println("habe gewartet");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
	    	lf.panel.removeAll();
	        JLabel endlabel = new JLabel();
	        JPanel endpanel = new JPanel();
<<<<<<< HEAD
	    	if(sf.equals("bombepl1")){
	            endlabel.setIcon(lf.end_bombepl1);}
	    	else if(sf.equals("bombepl2")){
	    		endlabel.setIcon(lf.end_bombepl2);}
=======
	    	if(sf.equals("bombe")){
	            endlabel.setIcon(lf.end_bombe);
	    	}
>>>>>>> 4d6066ee247af2e3a6ea389adf8e49e8518dba29
	    	else if(sf.equals("treppe")){
	            endlabel.setIcon(lf.end_game);
	    	}
	    	endpanel.add(endlabel);
<<<<<<< HEAD
	    	
	        lf.frame.add(endpanel);
	        lf.frame.validate();
	        
    	

=======
	        lf.frame.add(endpanel);
	        lf.frame.validate();
>>>>>>> 4d6066ee247af2e3a6ea389adf8e49e8518dba29
		}
	}
}
