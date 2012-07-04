package bomberman;

import java.awt.GridLayout;
import java.net.DatagramSocket;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Initialisierung der spielweiten Variablen
 * @author Levent Sarp, Dennis Weber, Daniel Gros, Adrian Schmidt, Fabian Pegel
 * @version 0.1
 * 
 *  */

public class LaunchFrame {
	public DatagramSocket socket;
    public JFrame frame;
    public JPanel panel;
    public Boolean networkgame;
    public Boolean auswahldialog;
    public Boolean musik;
    public Boolean go;
    public Block[][] block = new Block[11][11];
    public Network netz;
    public ImageIcon bomberman;
    public ImageIcon bomberman2;
    public Tasten t;
    public Tasten2 t2;
    public int playernr;
    public String ip;
    public ImageIcon bombe;
    public ImageIcon tot;
    public ImageIcon unbreakablefield;
    public ImageIcon breakablefield;
    public ImageIcon field;
    public ImageIcon finpic;
    public ImageIcon explo;
    public ImageIcon bombermanu;
    public ImageIcon bombermano;
    public ImageIcon bombermanl;
    public ImageIcon bombermanr;
    public ImageIcon bomberman2u;
    public ImageIcon bomberman2o;
    public ImageIcon bomberman2l;
    public ImageIcon bomberman2r;
    public ImageIcon bomberman2o2;

    public ImageIcon bombermanr2; //bomberman2 = mit bombe im bg
    public ImageIcon bombermanu2;
    public ImageIcon bombermano2;
    public ImageIcon bombermanl2;
    public ImageIcon end_bombepl1;
    public ImageIcon end_bombepl2;


    public ImageIcon end_game;
    public ImageIcon end_bombe;
    
    public long startzeit;
    public int anweisung;
	public int bombix; //position x von bomberman
	public int bombiy; //position y von bomberman
	public int bombax; //position x von bomberm�dchen
	public int bombay; //position y von bomberm�dchen

	public int bombex; //position x von bombe
	public int bombey; //position y von bombe
	public int x;
	public int y;
	public Boolean baktiv[][] = new Boolean[11][11];
	public Boolean[][] exploaktiv = new Boolean[11][11];
    public int input;
    public Boolean spielende=false;
	public Boolean anderebombe=false;
    int i;      
	private LaunchFrame lf;
	/**
	 * Festlegen der Variableninhalte zu Anfang des Spiels
	 */
	public LaunchFrame() {
		musik=false;
	    bombix = 1;
	    bombiy = 1;
	    bombax = 9;
	    bombay = 9;
	    anweisung=0;
	    go=true;
	    ip="";
	    for(int t=0; t<=10; t++){for(int r=0; r<=10; r++){baktiv[t][r]=false;}}
	    
	    unbreakablefield = new ImageIcon( this.getClass().getResource("/dateien/unbreakable.png"));
	    breakablefield = new ImageIcon( this.getClass().getResource("/dateien/breakable.png"));
	    field = new ImageIcon(  this.getClass().getResource("/dateien/field.png" ));
	    explo = new ImageIcon(  this.getClass().getResource("/dateien/explosion.png" )); 
	    finpic = new ImageIcon(  this.getClass().getResource("/dateien/end field.png") );
	    bomberman = new ImageIcon(  this.getClass().getResource("/dateien/bomberman standard.png" ));
	    bombermanu = new ImageIcon(  this.getClass().getResource("/dateien/bomberman standard.png" ));
	    bombermano = new ImageIcon(  this.getClass().getResource("/dateien/bomberman ruecken.png" ));
	    bombermanl = new ImageIcon(  this.getClass().getResource("/dateien/bomberman links.png" ));
	    bombermanr = new ImageIcon(  this.getClass().getResource("/dateien/bomberman rechts.png" ));
	    
	    bomberman2 = new ImageIcon(  this.getClass().getResource("/dateien/bomberman2 standard.png" ));
	    bomberman2u = new ImageIcon(  this.getClass().getResource("/dateien/bomberman2 standard.png" ));
	    bomberman2o = new ImageIcon(  this.getClass().getResource("/dateien/bomberman2 ruecken.png" ));
	    bomberman2l = new ImageIcon(  this.getClass().getResource("/dateien/bomberman2 links.png" ));
	    bomberman2r = new ImageIcon(  this.getClass().getResource("/dateien/bomberman2 rechts.png" ));
	    bomberman2o2 = new ImageIcon(  this.getClass().getResource("/dateien/2bomberman2 ruecken.png" ));
	    
	    bombermanu2 = new ImageIcon(  this.getClass().getResource("/dateien/2bomberman standard.png" ));
	    bombermano2 = new ImageIcon(  this.getClass().getResource("/dateien/2bomberman ruecken.png" ));
	    bombermanl2 = new ImageIcon(  this.getClass().getResource("/dateien/2bomberman links.png" ));
	    bombermanr2 = new ImageIcon(  this.getClass().getResource("/dateien/2bomberman rechts.png" ));   
		end_game = new ImageIcon(  this.getClass().getResource("/dateien/ENDGAME.png" ));
		end_bombepl1 = new ImageIcon(  this.getClass().getResource("/dateien/ENDGAME-bombe_pl2.png" )); //siegbild pl1
		end_bombepl2 = new ImageIcon(  this.getClass().getResource("/dateien/ENDGAME-bombe_pl1.png" )); //siegbild pl2

		end_bombe = new ImageIcon(  this.getClass().getResource("/dateien/ENDGAME-bombe.png" ));
		tot = new ImageIcon(  this.getClass().getResource("/dateien/tot.gif" ));
		t = new Tasten();
		t2 = new Tasten2();
	    bombe = new ImageIcon(  this.getClass().getResource("/dateien/bombe.png" ));
	}
	
	/**
	 * Frame erzeugen und anzeigen
	 * @param la Objekt
	 */
	public void spielfeld_malen(LaunchFrame la){
		 lf = la;
		 Spielfeld sf = new Spielfeld();
	     sf.zeichneFeld(lf);
	     System.out.println("gezeichnet");
	     lf.frame.setLocation(0,0);
	     lf.frame.setVisible(true);
	     lf.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     lf.frame.setSize(660, 660);
	     lf.panel.setLayout(new GridLayout(11,11));        
	     
	    
		 /* Bomberman aufs Spielfeld setzen: */
	     lf.block[1][1].setIcon(lf.bomberman); 
	     lf.block[9][9].setIcon(lf.bomberman2); 
	     lf.frame.add(lf.panel);
	     lf.frame.validate();
	     System.out.println("gezeichnet");

	}
}
