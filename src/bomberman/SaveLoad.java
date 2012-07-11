package bomberman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Speichern und laden eines Spielstandes
 * @author Levent Sarp, Dennis Weber, Daniel Gros, Adrian Schmidt, Fabian Pegel
 * @version 0.1
 * 
 *  */

public class SaveLoad {
	
	/**
	 * Spielfeld speichern
	 * @param lf Objekt
	 */
		
	public void save(LaunchFrame lf){
				
				//Felder in Datei speichern - ähnlich dem Fieldcreator
	        	File file = new File("save.txt");
			     try {
				      FileWriter writer = new FileWriter(file);
				       for(int i=0; i<=10; i++){
				    	   for(int j=0; j<=10; j++){
					        	//Spieler 1
					        	System.out.println("Speicher!");
					        	if(i == lf.bombix && j == lf.bombiy) {
					        		writer.write("i");
					        	}
					        	//Spieler 2
					        	else if(i == lf.bombax && j == lf.bombay) {
					        		writer.write("a");
					        	}
					        	//Feld
					        	else if(lf.block[i][j].destroyable==true && lf.block[i][j].walkable==true && lf.block[i][j].fin==false && lf.block[i][j].bombe==false ) {
					        		writer.write("1");
					        	}
					        	//unzerstörbarer Block
					        	else if (lf.block[i][j].destroyable==false && lf.block[i][j].walkable==false && lf.block[i][j].fin==false && lf.block[i][j].bombe==false){
					        		writer.write("0");
					        	}
					        	//cuttable Block!
					        	else if (lf.block[i][j].destroyable==true && lf.block[i][j].walkable==false && lf.block[i][j].fin==false && lf.block[i][j].bombe==false){
					        		writer.write("2");
					        	}
					        	//Könige gewinnen!
					        	else if (lf.block[i][j].destroyable==false && lf.block[i][j].walkable==true && lf.block[i][j].fin==true && lf.block[i][j].bombe==false){
					        		writer.write("f");
					        	}
					        	//versteckter Finblock!
					        	else if (lf.block[i][j].destroyable==true && lf.block[i][j].walkable==false && lf.block[i][j].fin==true && lf.block[i][j].bombe==false){
					        		writer.write("h");
					        	}
				    	   }
					       writer.write(System.getProperty("line.separator"));
				       }
				       
				       
				       
				       // Schreibt den Stream in die Datei
				       // Sollte immer am Ende ausgeführt werden, sodass der Stream 
				       // leer ist und alles in der Datei steht.
				       writer.flush();
				       lf.frame.setTitle("SirBomberman - Spielstand gespeichert!");
				       //titel nach speichern ändern
				       // Schließt den Stream
				       writer.close();
				    } catch (IOException e) {
				      e.printStackTrace();
				    }
	        	

		
		  
	}
	
	/**
	 * Spielfeld laden
	 * @param lf Objekt
	 */
	public void load(LaunchFrame lf){
		
		// Abfrage, ob der Spieler wirklich speichern möchte
		int eingabe = JOptionPane.showConfirmDialog(null, "Willst du das Spiel wirklich laden? Das Aktuelle Spiel geht dadurch verloren!", "Laden",JOptionPane.OK_CANCEL_OPTION);
		
		//falls Spieler ja drückt
		if(eingabe == 0){
			
			//altes Fenster löschen, um Platz für neue Daten zu machen.
			lf.panel.removeAll();
			
			//Informationen aus der save-Datei in das Programm laden - ähnlich dem allgemeinem Spielstart.
			File file = new File("save.txt");
		    String feldlayout = "";
	
		    FileReader fr = null;
			try {
				
				fr = new FileReader(file);
				System.out.println(file);
	
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   BufferedReader br = new BufferedReader(fr);
		   String line[] = new String[11];
		   for(int i=0; i<=10; i++){
		  	 try {
				line[i] = br.readLine();
				feldlayout = feldlayout + line[i];
	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		   }
		   try {
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		   char[] c = feldlayout.toCharArray();
		   /*datei auslesen ende*/
		   System.out.println(feldlayout);
		   
		   
		   int sx=0; int sy=-1;
		   for(int i=0; i<=120; i++) {
		   	sy++;
		   	if(sy==11){
		   		sx++;
		   		sy = 0;
		   	}
		   	System.out.println("block["+sx+"]["+sy+"]");
		   	switch(c[i]){
		   	case '0': // unbreakable
		   		lf.block[sx][sy] = new  Block(lf.unbreakablefield);
		   		lf.block[sx][sy].destroyable = false;
		   		lf.block[sx][sy].walkable = false;
		   		lf.block[sx][sy].fin = false;
		   		lf.block[sx][sy].bombe = false;
		   		lf.panel.add(lf.block[sx][sy]);             
		   		break;
		   	case '1': //laufbares feld
		   		lf.block[sx][sy] = new  Block(lf.field);
		   		lf.block[sx][sy].destroyable = true;
		   		lf.block[sx][sy].walkable = true;
		   		lf.block[sx][sy].fin = false;
		   		lf.block[sx][sy].bombe = false;
		   		lf.panel.add(lf.block[sx][sy]);             
		   		break;
		   	case '2': //breakable feld
		   		lf.block[sx][sy] = new  Block(lf.breakablefield);
		   		lf.block[sx][sy].destroyable = true;
		   		lf.block[sx][sy].walkable = false;
		   		lf.block[sx][sy].fin = false;
		   		lf.block[sx][sy].bombe = false;
		   		lf.panel.add(lf.block[sx][sy]);             
		   		break;
		   	case 'f': //zielfeld
		   		lf.block[sx][sy] = new  Block(lf.finpic);
		   		lf.block[sx][sy].destroyable = false;
		   		lf.block[sx][sy].walkable = true;
		   		lf.block[sx][sy].fin = true;
		   		lf.block[sx][sy].bombe = false;
		   		lf.panel.add(lf.block[sx][sy]);             
		   		break;
		   	case 'h': //verstecktes zielfeld
		   		lf.block[sx][sy] = new  Block(lf.breakablefield);
		   		lf.block[sx][sy].destroyable = true;
		   		lf.block[sx][sy].walkable = false;
		   		lf.block[sx][sy].fin = true;
		   		lf.block[sx][sy].bombe = false;
		   		lf.panel.add(lf.block[sx][sy]);             
		   		break;
		   	case 'b': //Bombe auf Feld
		   		lf.block[sx][sy] = new  Block(lf.bombe);
		   		lf.block[sx][sy].destroyable = true;
		   		lf.block[sx][sy].walkable = false;
		   		lf.block[sx][sy].fin = false;
		   		lf.block[sx][sy].bombe = true;
		   		lf.panel.add(lf.block[sx][sy]);             
		   		break;
		   	case 'i': //Spieler 1
		   		lf.block[sx][sy] = new  Block(lf.bomberman);
		   		lf.block[sx][sy].destroyable = true;
		   		lf.block[sx][sy].walkable = true;
		   		lf.block[sx][sy].fin = false;
		   		lf.block[sx][sy].bombe = false;
		   		lf.bombix = sx; lf.bombiy = sy;
		   		lf.panel.add(lf.block[sx][sy]); 
		   		
		   		break;
		   	case 'a': //Spieler 2
		   		lf.block[sx][sy] = new  Block(lf.bomberman2);
		   		lf.block[sx][sy].destroyable = true;
		   		lf.block[sx][sy].walkable = false;
		   		lf.block[sx][sy].fin = false;
		   		lf.block[sx][sy].bombe = true;
		   		lf.bombax = sx; lf.bombay = sy;
		   		lf.panel.add(lf.block[sx][sy]);     
		   		
		   		break;
		   	}
		   	}
		  
		  // geladenes Feld neu zeichnen lassen.
		  lf.load_malen(lf);
		}
	}

}

