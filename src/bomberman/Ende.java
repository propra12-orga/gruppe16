package bomberman;

import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ende extends TimerTask {
	public LaunchFrame lf;
	public String sf;

public Ende(LaunchFrame la, String st){
	lf=la;
	sf=st;
}
public void run(){
    if (lf.spielende==true){

    	lf.panel.removeAll();
        JLabel endlabel = new JLabel();
        JPanel endpanel = new JPanel();
    	if(sf.equals("bombe")){
            endlabel.setIcon(lf.end_bombe);
    	}
    	else if(sf.equals("treppe")){
            endlabel.setIcon(lf.end_game);
    	}



        endpanel.add(endlabel);
        lf.frame.add(endpanel);
        lf.frame.validate();
	}

}
}
