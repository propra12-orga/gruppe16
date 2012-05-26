
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
public class SirBomberman implements KeyListener {
    public JFrame frame;
    public JPanel panel;
    public Block[][] block = new Block[11][11];
    public ImageIcon bomberman;
    public ImageIcon bombe;
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
	public int bombix;
	public int bombiy;
	public int bombex;
	public int bombey;
	public int x;
	public int y;
	public Boolean baktiv =false;
	public Boolean gesperrt=false;
	public Timer timer = new Timer();
    public int input;
    boolean spielende=false;
    
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    
    public SirBomberman(){
        frame = new JFrame("SirBomberman");
        panel = new JPanel();
    }
    
    public void launchFrame() {
        bombix = 1;
        bombiy = 1;
        frame.setLocation(0,0);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(660, 660);
        panel.setLayout(new GridLayout(11,11));
        int i;        
        
        unbreakablefield = new ImageIcon( "img/unbreakable.png" );
        field = new ImageIcon( "img/field.png" );
        explo = new ImageIcon( "img/explosion.png" ); 
        finpic = new ImageIcon( "img/end field.png" );
        bomberman = new ImageIcon( "img/bomberman standard.png" );
        bombermanu = new ImageIcon( "img/bomberman standard.png" );
        bombermano = new ImageIcon( "img/bomberman rücken.png" );
        bombermanl = new ImageIcon( "img/bomberman links.png" );
        bombermanr = new ImageIcon( "img/bomberman rechts.png" );
        bombermanu2 = new ImageIcon( "img/2bomberman standard.png" );
        bombermano2 = new ImageIcon( "img/2bomberman rücken.png" );
        bombermanl2 = new ImageIcon( "img/2bomberman links.png" );
        bombermanr2 = new ImageIcon( "img/2bomberman rechts.png" );       
        bombe = new ImageIcon( "img/bombe.png" );
        
         for(i=0; i <= 10; i++){
             for(int j=0; j <= 10; j++){
                     if(i == 0 || i == 10 || j == 0 || j == 10 || (i%2 == 0 && j%2 == 0)){
                         block[i][j] = new  Block(unbreakablefield);
                         block[i][j].destroyable = false;
                         block[i][j].walkable = false;
                         block[i][j].fin = false;
                         panel.add(block[i][j]);             
                         }
                    
                     else if(i == 5 && j == 5){
                         block[i][j] = new Block(finpic);
                         block[i][j].destroyable = false;
                         block[i][j].walkable = true;
                         block[i][j].fin = true;
                         panel.add(block[i][j]);                            
                     }
                     else {
                         block[i][j] = new Block(field);
                         block[i][j].destroyable = true;
                         block[i][j].walkable = true;
                         block[i][j].fin = false;
                         panel.add(block[i][j]);                     }
             }
     }    
        block[1][1].setIcon(bomberman);
        frame.add(panel);
        frame.validate();
        panel.addKeyListener(this);
        panel.requestFocus();
    }
    
    public static void main(String[] args) {
        SirBomberman bombe = new SirBomberman();
        bombe.launchFrame();
    }
    	class explosion extends TimerTask {
		public void run() {

		if(block[bombex+1][bombey].destroyable==true) { //bombe 1unten
		block[bombex+1][bombey].setIcon(explo);System.out.println(explo);
			timer.schedule(new loeschen(bombex+1,bombey), 1000);  	
		}
		if(block[bombex-1][bombey].destroyable==true) { //bombe 1oben
			block[bombex-1][bombey].setIcon(explo);System.out.println(explo);
			timer.schedule(new loeschen(bombex-1,bombey), 1000);  	
		}
		if(bombex+2<block.length && block[bombex+1][bombey].destroyable==true && block[bombex+2][bombey].destroyable==true) { //bombe 2unten
			block[bombex+2][bombey].setIcon(explo);System.out.println(explo);
			timer.schedule(new loeschen(bombex+2,bombey), 1000);  	
		}
		if(bombex-2<block.length && block[bombex-1][bombey].destroyable==true && block[bombex-2][bombey].destroyable==true) { //bombe 2oben
			block[bombex-2][bombey].setIcon(explo);System.out.println(explo);
			timer.schedule(new loeschen(bombex-2,bombey), 1000);  	
		}
		if(block[bombex][bombey+1].destroyable==true) { //bombe 1rechts
			block[bombex][bombey+1].setIcon(explo);System.out.println(explo);
			timer.schedule(new loeschen(bombex,bombey+1), 1000);  	

		}
		if(block[bombex][bombey-1].destroyable==true) { //bombe 1links
			block[bombex][bombey-1].setIcon(explo);System.out.println(explo);
			timer.schedule(new loeschen(bombex,bombey-1), 1000);  	

		}
		if(bombey+2<block.length && block[bombex][bombey+1].destroyable==true && block[bombex][bombey+2].destroyable==true) { //bombe 2rechts
			block[bombex][bombey+2].setIcon(explo);System.out.println(explo);
			timer.schedule(new loeschen(bombex,bombey+2), 1000);  	

		}
		if(bombey-2<block.length && block[bombex][bombey-1].destroyable==true && block[bombex][bombey-2].destroyable==true) { //bombe 2links
			block[bombex][bombey-2].setIcon(explo);System.out.println(explo);
			timer.schedule(new loeschen(bombex,bombey-2), 1000);  	

		}
		timer.schedule(new loeschen(bombex,bombey), 1000);  
		gesperrt=false;
		}
	}
	
	class loeschen extends TimerTask {
		private int neux;
		private int neuy;
		loeschen(int x, int y) {
			neux=x;
			neuy=y;
		}
		public void run() {
		block[neux][neuy].setIcon(field);
		}
	}
	

    public void keyPressed(KeyEvent e) {
        input=e.getKeyCode();
        System.out.println(input);
        
        if(input==39 && block[bombix][bombiy+1].walkable==true) { //rechts
    		if(baktiv==true) {
    			block[bombix][bombiy].setIcon(bombe);
    			baktiv=false;
    		}
    		else {
    			block[bombix][bombiy].setIcon(field);
    		}
    		bombiy++;
    		block[bombix][bombiy].setIcon(bombermanr);
    		check();
    	}
        if(input==37 && block[bombix][bombiy-1].walkable==true) { //links
    		if(baktiv==true) {
    			block[bombix][bombiy].setIcon(bombe);
    			baktiv=false;

    		}
    		else {
    			block[bombix][bombiy].setIcon(field);
    		}
    		bombiy--;
    		block[bombix][bombiy].setIcon(bombermanl);
    		check();
    	}
        if(input==38 && block[bombix-1][bombiy].walkable==true) { //oben
    		if(baktiv==true) {
    			block[bombix][bombiy].setIcon(bombe);
    			baktiv=false;

    		}
    		else {
    			block[bombix][bombiy].setIcon(field);
    		}
    		bombix--;
    		block[bombix][bombiy].setIcon(bombermano);
    		check();
    	}
        if(input==40 && block[bombix+1][bombiy].walkable==true) { //unten
    		if(baktiv==true) {
    			block[bombix][bombiy].setIcon(bombe);
    			baktiv=false;

    		}
    		else {
    			block[bombix][bombiy].setIcon(field);
    		}
    		bombix++;
    		block[bombix][bombiy].setIcon(bombermanu);
    		check();
    	}
    	    	if(input==32 && gesperrt==false) { //wenn leerzeichen gedrückt
    		bombex = bombix;
    		bombey = bombiy; // das muss hier hin, damit die explosion nicht "mitläuft"
    		baktiv = true;
    		block[bombix][bombiy].setIcon(bombermano2);   
    		gesperrt =true; 
    		timer.schedule(new explosion(), 3000);  	

    	}

        // SPIEL ENDE?
        if (spielende==true && input==78) {System.exit(0);}
        else if (spielende==true && input==89) 
        {frame.dispose();SirBomberman bombe = new SirBomberman();bombe.launchFrame(); spielende=false;}
    }
    
    public int getCoordX () {
        return bombix;
    }
    
    public int getCoordY () {
        return bombiy;
    }
    
    public Block[][] getBlock () {
        return block;
    }
    
    public void check() {
        if (block[bombix][bombiy].fin == true) spielende=true;
        if (spielende==true){
            beende_spiel();
            }
    }
    
    public void beende_spiel() {
        end_game = new ImageIcon( "img/ENDGAME.png" );
        panel.removeAll();
        JLabel endlabel = new JLabel(end_game);
        JPanel endpanel = new JPanel();
        endlabel.setIcon(end_game);
        endpanel.add(endlabel);
        frame.add(endpanel);
        frame.validate();
    }
}
