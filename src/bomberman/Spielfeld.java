package bomberman;
import java.io.BufferedReader;
import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 * Spielfeld zeichnen
 * @author Levent Sarp, Dennis Weber, Daniel Gros, Adrian Schmidt, Fabian Pegel
 * @version 0.1
 * 
 *  */

public class Spielfeld {
	private LaunchFrame lf;
	private File file;
	
/**
 * Spielfeld aus Datei lesen und zeichnen
 * @param la Objekt
 * @param datei Datei aus der gelesen wird
 */
	
	public void zeichneFeld(LaunchFrame la){
		lf = la;
		// todo: Standarddatei in Package lesen. Im Moment muss iene field.txt im gleichen Verzeichnis wie die ausführbare .jar sein
		String feldlayout="";
		if(lf.auswahldialog==true){
		System.out.println("auswahl true");
		JFileChooser fc = new JFileChooser("./maps");
		

		  fc.setDialogType(JFileChooser.OPEN_DIALOG);
			

		  fc.setDialogTitle("Wähle das Level");
			

		  //Filefilter, damit man nur .txt Dateien öffnen kann. -> Bessere Übersicht.
		  
		  fc.setFileFilter( new FileFilter()
		    {			

		      @Override public boolean accept( File f )
		      {			

		        return f.isDirectory() ||
		          f.getName().toLowerCase().endsWith( ".txt" );

		      }
		      @Override public String getDescription()
		      {
					

		        return "Textdateien - .txt";
		      }
		    } );
			

		  int state = fc.showOpenDialog(null);
		   
		  //Wenn Datei ausgewählt wurde, Öffne sie und übergib sie ans Programm.
			System.out.println("s fc");

		  if (state == JFileChooser.APPROVE_OPTION)
		      {				

		        String path = fc.getSelectedFile().getPath();

		        file = new File(path);
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

		      }
		//
		//file = datei;
		 /*datei auslesen */
	}
		
		else {
			feldlayout="000000000000112222222001020202020022222222200202020202002222f222200202020202002222222220020202020100222222211000000000000"; //standardfeld
		}
	    
	    
	    if (file==null){
			feldlayout="000000000000112222222001020202020022222222200202020202002222f222200202020202002222222220020202020100222222211000000000000"; //standardfeld
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
	   		lf.panel.add(lf.block[sx][sy]); 
	   		lf.bombix = sx; lf.bombiy = sy;
	   		break;
	   	case 'a': //Spieler 2
	   		lf.block[sx][sy] = new  Block(lf.bomberman2);
	   		lf.block[sx][sy].destroyable = true;
	   		lf.block[sx][sy].walkable = false;
	   		lf.block[sx][sy].fin = false;
	   		lf.block[sx][sy].bombe = true;
	   		lf.panel.add(lf.block[sx][sy]);     
	   		lf.bombax = sx; lf.bombay = sy;
	   		break;
	   	}
	   	}
	}
}
