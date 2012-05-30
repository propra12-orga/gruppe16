package bomberman;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ende {
public LaunchFrame lf;
public String sf;
public void spielende(LaunchFrame la, String st){
	lf=la;
	sf=st;
    if (lf.spielende==true){
    	if(sf.equals("treppe")){
    		lf.end_game = new ImageIcon(  this.getClass().getResource("/dateien/ENDGAME.png" ));
    	}
    	else if(sf.equals("bombe")){
    		lf.end_game = new ImageIcon(  this.getClass().getResource("/dateien/ENDGAME-bombe.png" ));
    	}

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
