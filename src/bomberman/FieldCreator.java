package bomberman;
import java.awt.GridLayout;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;

/**
 * modifizierte JLabel-Klasse, zusätzlich char "state"
 * @author Levent Sarp, Dennis Weber, Daniel Gros, Adrian Schmidt, Fabian Pegel
 * @version 0.1
 * 
 *  */

class Feld extends JLabel {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public char state;
    
    
    public Feld(ImageIcon imageicon){
        super(imageicon);
    }
} 

/**
 * Spielfeld-Ersteller
 * @author Levent Sarp, Dennis Weber, Daniel Gros, Adrian Schmidt, Fabian Pegel
 * @version 0.1
 * 
 *  */

public class FieldCreator {
	public ImageIcon unbreakablefield;
	public ImageIcon breakablefield;
	public ImageIcon field;
	public ImageIcon finpic;
	public ImageIcon hiddenfinpic;
	public JFrame frame;
	public Boolean schreiberfolg=false;
	public JPanel panel;
	public Feld label[][] = new Feld[11][11];
	public MouseListener l[][] = new MouseListener[11][11];
	public 	int x, y;
	
	/**
	 * ImageIcons definieren
	 */
	
	public FieldCreator(){
		unbreakablefield = new ImageIcon( this.getClass().getResource("/dateien/unbreakable.png"));
	    breakablefield = new ImageIcon( this.getClass().getResource("/dateien/breakable.png"));
	    field = new ImageIcon( this.getClass().getResource("/dateien/field.png"));
	    finpic = new ImageIcon( this.getClass().getResource("/dateien/end field.png"));
	    hiddenfinpic = new ImageIcon( this.getClass().getResource("/dateien/hiddenendfield.png"));
	
		frame = new JFrame("Spielfeld-Ersteller für Bomberman");
		panel = new JPanel();
	    frame.setLocation(0,0);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(660, 660);
	    panel.setLayout(new GridLayout(12,12));   
	    int i; int j;
	
		for(i=0; i <= 10; i++){
	        for(j=0; j <= 10; j++){
	        	if(i==0||j==0||i==10||j==10){
	                label[i][j] = new Feld(unbreakablefield);
	                label[i][j].state = '0';
	        	}
	        	else {
	                label[i][j] = new Feld(field);
	                label[i][j].state = '1';
	
	        	}
	            x=i;
	            y=j;
	            System.out.println("x="+x+" und y="+y);
	            final int ix = i;
	            final int iy = j;
				label[i][j].addMouseListener(new MouseListener()
					{
						public void mouseReleased(MouseEvent e)
						{
							//System.out.println("Mouse Released "); 
						}
						public void mouseClicked(MouseEvent e)
						{
							//System.out.println("Mouse Pressed "); 
						}
						public void mouseExited(MouseEvent e)
						{
							//System.out.println("Mouse Exited "); 
						}
						public void mouseEntered(MouseEvent e)
						{
							//System.out.println("Mouse Entered ");
						}
				
						/**
						 * Bei Mausklick Icon und state des Feldes ändern
						 */
						public void mousePressed(MouseEvent e)
						{		
							
							switch(label[ix][iy].state){
							case '0':
								label[ix][iy].state = '1';
								label[ix][iy].setIcon(field);
								System.out.println(label[ix][iy].state);
								break;
							case '1':
								label[ix][iy].state = '2';
								label[ix][iy].setIcon(breakablefield);
								System.out.println(label[ix][iy].state);
								break;
							case '2':
								label[ix][iy].state = 'f';
								label[ix][iy].setIcon(finpic);
								System.out.println(label[ix][iy].state);
								break;
							case 'f':
								label[ix][iy].state = 'h';
								label[ix][iy].setIcon(hiddenfinpic);
								System.out.println(label[ix][iy].state);
								break;
							case 'h':
								label[ix][iy].state = '0';
								label[ix][iy].setIcon(unbreakablefield);
								System.out.println(label[ix][iy].state);
								break;
							}
							System.out.println("Mouse clicked "); 
			                System.out.println("x="+x+" und y="+y);
						}
					});
	                
	            panel.add(label[i][j]);
	        }
		}
		
		JButton save = new JButton("save");
		save.addMouseListener(new MouseListener()
					{
						public void mouseReleased(MouseEvent e)
						{
							//System.out.println("Mouse Released "); 
						}
						public void mouseClicked(MouseEvent e)
						{
							//System.out.println("Mouse Pressed "); 
						}
						public void mouseExited(MouseEvent e)
						{
							//System.out.println("Mouse Exited "); 
						}
						public void mouseEntered(MouseEvent e)
						{
							//System.out.println("Mouse Entered ");
						}
						public void mousePressed(MouseEvent e)
						{		
						    FileWriterExample fw = new FileWriterExample();
						    fw.schreiben();
						    if(schreiberfolg){
						    	JOptionPane.showMessageDialog(frame, "Spielfeld erfolgreich in Datei geschrieben.");
						    	schreiberfolg = false;
						    }
						}
					});
		
		//zufallsgenerator
		JButton zufall = new JButton("zufall");
		zufall.addMouseListener(new MouseListener()
		{
			public void mouseReleased(MouseEvent e)
			{
				//System.out.println("Mouse Released "); 
			}
			public void mouseClicked(MouseEvent e)
			{
				//System.out.println("Mouse Pressed "); 
			}
			public void mouseExited(MouseEvent e)
			{
				//System.out.println("Mouse Exited "); 
			}
			public void mouseEntered(MouseEvent e)
			{
				//System.out.println("Mouse Entered ");
			}
			public void mousePressed(MouseEvent e)
			{		
				for (int ix=1; ix!=10; ix++){
					for (int iy=1; iy!=10;iy++){
					char _zufall;
					double rand=Math.random();
					
					if (rand>= 0   && rand<=0.4) _zufall = '1';
					else if (rand>= 0.4 && rand<=0.66) _zufall = '0';
					else if ( rand>= 0.66 && rand<=1) _zufall = '2';
					else _zufall = 'b';
						
					label[ix][iy].state=_zufall;

						switch(label[ix][iy].state){
						case '1':
							label[ix][iy].setIcon(field);
							//System.out.println(label[ix][iy].state);
							break;
						case '2':
							label[ix][iy].setIcon(breakablefield);
							//System.out.println(label[ix][iy].state);
							break;
						case '0':
							label[ix][iy].setIcon(unbreakablefield);
							//System.out.println(label[ix][iy].state);
							break;
						}
					}
				}
				//Startpositionen freimachen und ausgang in mitte setzen
				label[1][1].state = '1';
				label[1][1].setIcon(field);
				label[2][1].state = '1';
				label[2][1].setIcon(field);
				label[1][2].state = '1';
				label[1][2].setIcon(field);
				label[9][9].state = '1';
				label[9][9].setIcon(field);
				label[8][9].state = '1';
				label[8][9].setIcon(field);
				label[9][5].state = '1';
				label[9][8].setIcon(field);
				label[5][5].state = 'f';
				label[5][5].setIcon(finpic);
			    }

			});
		
		
		//konsistenzpruefung
		JButton konsistenz = new JButton("konsistenz");
		konsistenz.addMouseListener(new MouseListener()
		{
			public void mouseReleased(MouseEvent e)
			{
				//System.out.println("Mouse Released "); 
			}
			public void mouseClicked(MouseEvent e)
			{
				//System.out.println("Mouse Pressed "); 
			}
			public void mouseExited(MouseEvent e)
			{
				//System.out.println("Mouse Exited "); 
			}
			public void mouseEntered(MouseEvent e)
			{
				//System.out.println("Mouse Entered ");
			}
			public void mousePressed(MouseEvent e)
			{	
				System.out.println("konsistenz AN");
				
				//feld einlesen
				char feldlayout[][] = new char[11][11];
				
				for (int xi=0; xi!=11; xi++)
					for (int yj=0; yj!=11; yj++)
						feldlayout[xi][yj]=label[xi][yj].state;
				
			   //feld einlesen ende
			   //konsistenz mit den eingelesenen daten prüfen
			   KonsistenzPr konsistent = new KonsistenzPr(feldlayout);
			   if (konsistent.konsistent == true) JOptionPane.showMessageDialog(frame, "Das Spielfeld ist konsistent!");
			   else JOptionPane.showMessageDialog(frame, "Das Spielfeld ist nicht konsistent. "+konsistent.fehler);
				
			}

			});
		
		panel.add(save);
		panel.add(zufall);
		panel.add(konsistenz);
	    frame.add(panel);
	    frame.validate();
	}
	
	/**
	 * Spielfeld in Datei schreiben
	 * @author Levent Sarp, Dennis Weber, Daniel Gros, Adrian Schmidt, Fabian Pegel
	 * @version 0.1
	 * 
	 *  */
	
	class FileWriterExample {
		  
		  FileWriter writer;
		  File file;
		  
		  /**
		   * schreibe states der einzelnen Felder in <i>field.txt</i>
		   */
		  public void schreiben(){
			  // Filechooser, damit man Dateien einzeln Speichern kann und nicht nur auf eine einzige Karte hat!
			  // erst Filechooser erstellen und dann als save-dialog deklarieren
			  
			  JFileChooser fc = new JFileChooser("./maps");
			  fc.setDialogType(JFileChooser.SAVE_DIALOG);
			   
			  fc.setDialogTitle("Speicher dein Level");
			  
			  int state = fc.showSaveDialog(null);
			  
			  // wenn tatsächlich auf speichern gedrückt wird, erstelle die Datei und hänge .txt dran.
			  
			  if (state == JFileChooser.APPROVE_OPTION)
			      {
			        String path = fc.getSelectedFile().getPath();
			   
			        path = path + ".txt";
			   
			        file = new File(path);
			      }
			  
		     try {
		       writer = new FileWriter(file);
		       for(int k=0; k<=10; k++){
		    	   for(int m=0; m<=10; m++){
		    		   writer.write(label[k][m].state);
		    	   }
			       writer.write(System.getProperty("line.separator"));
		       }
		       
		       
		       
		       // Schreibt den Stream in die Datei
		       // Sollte immer am Ende ausgeführt werden, sodass der Stream 
		       // leer ist und alles in der Datei steht.
		       writer.flush();
		       
		       // Schließt den Stream
		       writer.close();
		       schreiberfolg=true;
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		  }}
	
	/**
	 * rufe Konstruktor auf
	 * @param args
	 */
	public static void main(String[] args){
		new FieldCreator();
		
	}
}
