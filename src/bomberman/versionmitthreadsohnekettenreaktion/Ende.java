package bomberman;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ende extends Thread {
	public LaunchFrame lf;
	public String sf;

public Ende(LaunchFrame la, String st){
	lf=la;
	sf=st;
}
public void run(){
    if (lf.spielende==true){
    	try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
