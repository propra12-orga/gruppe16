package bomberman;

import java.awt.Desktop;
import java.net.URI;

import javax.swing.JOptionPane;

public class Highscore {
public LaunchFrame lf;
	public void highscore_frage(LaunchFrame la) {
		lf=la;
		long highzeit = System.currentTimeMillis();
		long endzeit = (highzeit - lf.startzeit)/1000;
		System.out.println(endzeit);
        String name = JOptionPane.showInputDialog(null,
                "In den Highscore eintragen? Bitte Namen eingeben!", "Highscore",
                JOptionPane.PLAIN_MESSAGE);
        if (name == null) {
            System.out.println("kein Highscore-Eintrag");
        } else {
            System.out.println("rufe Website auf... \nName:" + name + "\nZeit:" + endzeit);
            try
            {
              Desktop.getDesktop().browse( new URI("http://fapeg.com/bman/bomberman.php?name=" + name + "&zeit=" + endzeit) );
            }
            catch ( Exception /* IOException, URISyntaxException */ e )
            {
              e.printStackTrace();
            }
        }
	}

}
