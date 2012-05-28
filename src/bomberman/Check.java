package bomberman;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Check {
	private LaunchFrame lf;
	
    public void check(LaunchFrame la) {
    	lf=la;
        if (lf.block[lf.bombix][lf.bombiy].fin == true) lf.spielende=true;
        System.out.println(lf.block[lf.bombix][lf.bombiy].fin);
        if (lf.spielende==true){
        	lf.end_game = new ImageIcon(  this.getClass().getResource("/dateien/ENDGAME.png" ));
        	lf.panel.removeAll();
            JLabel endlabel = new JLabel(lf.end_game);
            JPanel endpanel = new JPanel();
            endlabel.setIcon(lf.end_game);
            endpanel.add(endlabel);
            lf.frame.add(endpanel);
            lf.frame.validate();
        }
    }

}
