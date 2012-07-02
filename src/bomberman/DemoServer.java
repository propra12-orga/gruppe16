package bomberman;

import java.net.*;
import java.awt.*;
import java.io.IOException; 
import javax.swing.*;
/* Codegrundlage: Java ist auch eine Insel */
class Change{
	public JLabel jlnew;
	public String sn;
	ImageIcon bomberman = new ImageIcon(  this.getClass().getResource("/dateien/bomberman links.png" ));
	ImageIcon gras = new ImageIcon(  this.getClass().getResource("/dateien/field.png" ));

	public void ändern(JLabel jl, String st){
		jlnew = jl;
		sn = st;
		if(sn.equals("bomberman")){
			jlnew.setIcon(bomberman);
		}
		if(sn.equals("gras")){
			jlnew.setIcon(gras);
		}

	}
}

public class DemoServer {
	public static void main(String[] args) throws IOException {
		Change ch = new Change();
		JFrame frame = new JFrame("UDPTest");
		JPanel panel = new JPanel();
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();

	     frame.setLocation(0,0);
	     frame.setVisible(true);
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     frame.setSize(200, 200);
	     panel.setLayout(new GridLayout(1,1));
	     ch.ändern(label1, "gras");
	     ch.ändern(label2, "bomberman");
	     panel.add(label1);
	     panel.add(label2);
	     frame.add(panel);
	     frame.validate();

		byte[] data = new byte[ 1024 ]; 
		DatagramSocket socket = new DatagramSocket( 4712 ); 
		while(true) {
			DatagramPacket packet = new DatagramPacket( data, data.length ); 
			socket.receive( packet );
			String s = new String(packet.getData()); 
			s = s.trim();
			System.out.println(s);
			if(s.equals("links")==true){
			ch.ändern(label2, "gras");
			ch.ändern(label1, "bomberman");
			}

		}
	}
}