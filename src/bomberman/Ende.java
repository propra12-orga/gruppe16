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
	    	if(sf.equals("bombepl1")||sf.equals("bombepl2")){
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
	    	if(sf.equals("bombepl1")){
	            endlabel.setIcon(lf.end_bombepl1);}
	    	else if(sf.equals("bombepl2")){
	    		endlabel.setIcon(lf.end_bombepl2);}
	    	else if(sf.equals("treppe")){
	            endlabel.setIcon(lf.end_game);
	    	}
	    	endpanel.add(endlabel);
	    	
	        lf.frame.add(endpanel);
	        lf.frame.validate();
	        
    	

		}
	}
}
