package bomberman;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.*;

public class Network {
	public LaunchFrame lf;
	public KeyEvent ke;
	public byte[] data = new byte[ 1024 ]; 
	public Network() throws IOException  {
		
	}
	public void hoeren(LaunchFrame la) throws IOException {
		lf = la;	
		lf.socket = new DatagramSocket( 4712 ); 

		while(true) {
			DatagramPacket packet = new DatagramPacket( data, data.length ); 
			try {lf.socket.receive( packet );
	    	} catch (SocketException se) {
	    		System.out.println("Exception abgefangen");
	    		lf.socket.disconnect();
	    		lf.socket = new DatagramSocket( 4712 );
	    			}
			String s = new String(packet.getData()); 
			s = s.trim();
			System.out.println(s);
			if(s.equals("llinks")==true){
				if(lf.playernr==1){
					lf.anweisung = 65;
					lf.t2.abfragen(lf);
				}
				else if(lf.playernr==2){
					lf.anweisung = 37;
					lf.t.abfragen(lf);
				}
			}
			if(s.equals("rechts")==true){
				if(lf.playernr==1){
					lf.anweisung = 68;
					lf.t2.abfragen(lf);
				}
				else if(lf.playernr==2){
					lf.anweisung = 39;
					lf.t.abfragen(lf);
				}
			}

			if(s.equals("oobenn")==true){
				if(lf.playernr==1){
					lf.anweisung = 87;
					lf.t2.abfragen(lf);
				}
				else if(lf.playernr==2){
					lf.anweisung = 38;
					lf.t.abfragen(lf);
				}
			}

			if(s.equals("uunten")==true){
				if(lf.playernr==1){
					lf.anweisung = 83;
					lf.t2.abfragen(lf);
				}
				else if(lf.playernr==2){
					lf.anweisung = 40;
					lf.t.abfragen(lf);
				}
			}
			if(s.equals("bbombe")==true){
				if(lf.playernr==1){
					lf.anweisung = 81;
					lf.t2.abfragen(lf);
				}
				else if(lf.playernr==2){
					lf.anweisung = 32;
					lf.t.abfragen(lf);
				}
			}


		}

	}
	
	public void senden(LaunchFrame lb, KeyEvent ee) throws IOException {
		lf=lb;
		ke=ee;
		String s = "";
        InetAddress ia = InetAddress.getByName( lf.ip ); 
       if(ke.getKeyCode()==37||ke.getKeyCode()==65){
        s = "llinks";
       }
       if(ke.getKeyCode()==39||ke.getKeyCode()==68){
           s = "rechts";
          }
       if(ke.getKeyCode()==38||ke.getKeyCode()==87){
           s = "oobenn";
          }
       if(ke.getKeyCode()==40||ke.getKeyCode()==83){
           s = "uunten";
          }
       if(ke.getKeyCode()==32||ke.getKeyCode()==81){
           s = "bbombe";
          }
       byte[] raw = s.getBytes(); 
        DatagramPacket packet = new DatagramPacket( raw, raw.length, ia, 4712 ); 
        DatagramSocket dSocket = new DatagramSocket(); 
        dSocket.send( packet ); 
        System.out.println( "Angabe abgeschickt" ); 

	}
	
	
    

}
