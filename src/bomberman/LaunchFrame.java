package bomberman;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LaunchFrame {
    public JFrame frame;
    public JPanel panel;
    public Block[][] block = new Block[11][11];
    public ImageIcon bomberman;
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
    public ImageIcon bombermanr2; //bomberman2 = mit bombe im bg
    public ImageIcon bombermanu2;
    public ImageIcon bombermano2;
    public ImageIcon bombermanl2;
    public ImageIcon end_game;
    public ImageIcon end_bombe;
	public int bombix; //position x von bomberman
	public int bombiy; //position y von bomberman
	public int bombex; //position x von bombe
	public int bombey; //position y von bombe
	public int x;
	public int y;
	public Boolean baktiv =false;
	public Boolean[][] exploaktiv = new Boolean[11][11];
	//public Timer[][] timer = new Timer[11][11]; //mehrdimesnional machen??
	//public Timer[][] timer2 = new Timer[11][11];
    public int input;
    public Boolean spielende=false;
	public Boolean anderebombe=false;
    int i;      
	private LaunchFrame lf;

public LaunchFrame() {
    bombix = 1;
    bombiy = 1;
    unbreakablefield = new ImageIcon( this.getClass().getResource("/dateien/unbreakable.png"));
    breakablefield = new ImageIcon( this.getClass().getResource("/dateien/breakable.png"));
    field = new ImageIcon(  this.getClass().getResource("/dateien/field.png" ));
    explo = new ImageIcon(  this.getClass().getResource("/dateien/explosion.png" )); 
    finpic = new ImageIcon(  this.getClass().getResource("/dateien/end field.png") );
    bomberman = new ImageIcon(  this.getClass().getResource("/dateien/bomberman standard.png" ));
    bombermanu = new ImageIcon(  this.getClass().getResource("/dateien/bomberman standard.png" ));
    bombermano = new ImageIcon(  this.getClass().getResource("/dateien/bomberman rücken.png" ));
    bombermanl = new ImageIcon(  this.getClass().getResource("/dateien/bomberman links.png" ));
    bombermanr = new ImageIcon(  this.getClass().getResource("/dateien/bomberman rechts.png" ));
    bombermanu2 = new ImageIcon(  this.getClass().getResource("/dateien/2bomberman standard.png" ));
    bombermano2 = new ImageIcon(  this.getClass().getResource("/dateien/2bomberman rücken.png" ));
    bombermanl2 = new ImageIcon(  this.getClass().getResource("/dateien/2bomberman links.png" ));
    bombermanr2 = new ImageIcon(  this.getClass().getResource("/dateien/2bomberman rechts.png" ));   
	end_game = new ImageIcon(  this.getClass().getResource("/dateien/ENDGAME.png" ));
	end_bombe = new ImageIcon(  this.getClass().getResource("/dateien/ENDGAME-bombe.png" ));
	tot = new ImageIcon(  this.getClass().getResource("/dateien/tot.gif" ));

    bombe = new ImageIcon(  this.getClass().getResource("/dateien/bombe.png" ));
}
public void spielfeld_malen(LaunchFrame la){
	 lf = la;
     lf.frame.setLocation(0,0);
     lf.frame.setVisible(true);
     lf.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     lf.frame.setSize(660, 660);
     lf.panel.setLayout(new GridLayout(11,11));        
     
    Spielfeld sf = new Spielfeld();
    sf.zeichneFeld(lf, "field.txt");
    
	 /* Bomberman aufs Spielfeld setzen: */
     lf.block[1][1].setIcon(lf.bomberman); 
     lf.frame.add(lf.panel);
     lf.frame.validate();

}
}
