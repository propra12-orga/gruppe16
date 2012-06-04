package bomberman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Spielfeld {
	private LaunchFrame lf;
	private String file;

	public void zeichneFeld(LaunchFrame la, String datei){
	lf = la;
	file = datei;
	 /*datei auslesen */
    String feldlayout = "";
    FileReader fr = null;
	try {
		fr = new FileReader(file);
		
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


   	}
   }
	}
}
