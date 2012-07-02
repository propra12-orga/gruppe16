package bomberman;
import java.io.BufferedReader;
<<<<<<< HEAD
import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JFileChooser;
=======
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
>>>>>>> 4d6066ee247af2e3a6ea389adf8e49e8518dba29

/**
 * Spielfeld zeichnen
 * @author Levent Sarp, Dennis Weber, Daniel Gros, Adrian Schmidt, Fabian Pegel
 * @version 0.1
 * 
 *  */

public class Spielfeld {
	private LaunchFrame lf;
<<<<<<< HEAD
	private File file;
=======
	private String file;
>>>>>>> 4d6066ee247af2e3a6ea389adf8e49e8518dba29
	
/**
 * Spielfeld aus Datei lesen und zeichnen
 * @param la Objekt
 * @param datei Datei aus der gelesen wird
 */
	
<<<<<<< HEAD
	public void zeichneFeld(LaunchFrame la){
		lf = la;
		try {
			file = new File(this.getClass().getResource("/dateien/field.txt" ).toURI());
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(lf.auswahldialog==true){
		System.out.println("auswahl true");
		JFileChooser fc = new JFileChooser();
		

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
		      }
		//
		//file = datei;
		 /*datei auslesen */
	}
		
		else {
			try {
				file = new File(this.getClass().getResource("/dateien/field.txt" ).toURI());
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	    
	    
	    if (file==null){		try {
			file = new File(this.getClass().getResource("/dateien/field.txt" ).toURI());
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
}
	    
	    String feldlayout = "";

	    FileReader fr = null;
		try {
			
			fr = new FileReader(file);
			System.out.println(file);

=======
	public void zeichneFeld(LaunchFrame la, String datei){
		lf = la;
		file = datei;
		
		 /* Datei auslesen */
		
	    String feldlayout = "";
	    FileReader fr = null;
		try {
			fr = new FileReader(file);
>>>>>>> 4d6066ee247af2e3a6ea389adf8e49e8518dba29
			
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
<<<<<<< HEAD

=======
	
>>>>>>> 4d6066ee247af2e3a6ea389adf8e49e8518dba29
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
<<<<<<< HEAD

=======
	
>>>>>>> 4d6066ee247af2e3a6ea389adf8e49e8518dba29
	   }
	   try {
		fr.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
<<<<<<< HEAD

=======
>>>>>>> 4d6066ee247af2e3a6ea389adf8e49e8518dba29
	
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
	   	}
	   	}
	}
}
