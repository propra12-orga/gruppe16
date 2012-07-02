package bomberman;


import java.io.IOException; 
import java.net.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame; 
/* Codegrundlage: javabeginners.de, Java i. a. e. Insel */

public class DemoClient extends JFrame implements ActionListener { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean geklickt=false;

    private JButton button;
    
    public DemoClient(){
        button = new JButton("click mich!");
        button.addActionListener(this);
        
        this.getContentPane().add(button);
    }
    
    public void actionPerformed(ActionEvent e)  {
        if(e.getSource() == button){
            System.out.println("Button geklickt!");
           
            try {
            senden();
            }
            catch (IOException ioe) {
            	System.out.println("IOException");
            	System.exit(0);
            }
            catch (InterruptedException iex){
            	System.out.println("InterruptedException");
            	System.exit(0);

            }
        }
    }
    
    public void senden() throws IOException, InterruptedException {
        InetAddress ia = InetAddress.getByName( "localhost" ); 
        String s = "links";
        byte[] raw = s.getBytes(); 
        DatagramPacket packet = new DatagramPacket( raw, raw.length, ia, 4712 ); 
        DatagramSocket dSocket = new DatagramSocket(); 
        dSocket.send( packet ); 
        System.out.println( "Angabe abgeschickt" ); 

    }
	
  public static void main( String[] args ) 
  { 
	  DemoClient bec = new DemoClient();
      bec.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      bec.setSize(200, 200);
	  bec.setLocation(250,250);
      bec.setVisible(true); 

      

  } 
}