package bomberman;

import java.awt.GridLayout;
import java.util.Timer;

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
	public Timer timer = new Timer();
    public int input;
    public Boolean spielende=false;
	int i;      
	private LaunchFrame lf;

public LaunchFrame() {
    bombix = 1;
    bombiy = 1;
    unbreakablefield = new ImageIcon( this.getClass().getResource("/dateien/unbreakable.png"));
    field = new ImageIcon(  this.getClass().getResource("/dateien/field.png" ));
    explo = new ImageIcon(  this.getClass().getResource("/dateien/explosion.png" )); 
    finpic = new ImageIcon(  this.getClass().getResource("/dateien/end field.png") );
    tot = new ImageIcon(  this.getClass().getResource("/dateien/tot.png" ));
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

    bombe = new ImageIcon(  this.getClass().getResource("/dateien/bombe.png" ));
}
public void spielfeld_malen(LaunchFrame la){
	 lf = la;
     lf.frame.setLocation(0,0);
     lf.frame.setVisible(true);
     lf.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     lf.frame.setSize(660, 660);
     lf.panel.setLayout(new GridLayout(11,11));        

	 for(i=0; i <= 10; i++){
         for(int j=0; j <= 10; j++){
                 if(i == 0 || i == 10 || j == 0 || j == 10 || (i%2 == 0 && j%2 == 0)){
                     /* nicht zerstörbare Blöcke zeichnen */
                	 lf.block[i][j] = new  Block(lf.unbreakablefield);
                     lf.block[i][j].destroyable = false;
                     lf.block[i][j].walkable = false;
                     lf.block[i][j].fin = false;
                     lf.panel.add(lf.block[i][j]);             
                     }
                
                 else if(i == 5 && j == 5){
                	 /* Ausgang zeichnen */
                     lf.block[i][j] = new Block(lf.finpic);
                     lf.block[i][j].destroyable = false;
                     lf.block[i][j].walkable = true;
                     lf.block[i][j].fin = true;
                     lf.panel.add(lf.block[i][j]);                            
                 }
                 else {
                	 /* laufbares Feld zeichnen */
                     lf.block[i][j] = new Block(lf.field);
                     lf.block[i][j].destroyable = true;
                     lf.block[i][j].walkable = true;
                     lf.block[i][j].fin = false;
                     lf.panel.add(lf.block[i][j]);
                 }
         }
 }   
	 /* Bomberman aufs Spielfeld setzen: */
     lf.block[1][1].setIcon(lf.bomberman); 
     lf.frame.add(lf.panel);
     lf.frame.validate();

}
}
