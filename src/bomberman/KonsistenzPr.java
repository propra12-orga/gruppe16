package bomberman;

//ACHTUNG! X UND Y SIND VERTAUSCHT
public class KonsistenzPr {
	char spielfeld[][];
	boolean konsistent=false;
	
	int anzahl_ende=0;
	boolean ende_plaziert=false;
	boolean ausgangfrei;
	
	int blockbuffer;
	
	int endeX; int endeY;
	String fehler="";
	
	public KonsistenzPr(char[][] spielfeld){
		this.spielfeld=spielfeld;
		findeEnde();
		if (ende_plaziert==true)
			endefrei();
		else konsistent=false;
		checkeAlles();
	}
	
	public void checkeAlles() { //überprüfe ob alle bedingungen stimmen
		if (ausgangfrei==true && ende_plaziert==true && anzahl_ende==1) konsistent=true;
		else konsistent=false;
	}
	
	public void endefrei () {
		//bedingungen um zu überprüfen ob ende frei ist; die umgebung muss frei sein
		if (spielfeld[endeX-1][endeY] == '1' || spielfeld[endeX-1][endeY] == '2')ausgangfrei=true; //ueber
		else if (spielfeld[endeX+1][endeY] == '1' || spielfeld[endeX+1][endeY] == '2')ausgangfrei=true; //unter
		else if (spielfeld[endeX][endeY-1] == '1' || spielfeld[endeX][endeY-1] == '2')ausgangfrei=true; //links)
		else if (spielfeld[endeX][endeY+1] == '1' || spielfeld[endeX][endeY+1] == '2')ausgangfrei=true;	//rechts	
		else {konsistent=false; fehler+="Das Ende ist nicht begehbar. ";}		
		}
	
	public void checkeEnde(){ // überprüfen ob ende vorhanden ist...
		boolean gefunden=false;
		//durchsuche spielfeld
		for (int i = 0; i!=11; i++)
			for (int j=0; j!=11;j++) {
				if (spielfeld[i][j]=='f' || spielfeld[i][j]=='h') gefunden=true;
				if (i==11 && j==11) gefunden=false;
			}
		if (gefunden==true) ende_plaziert =true;
		else {ende_plaziert=false; fehler+="Kein Ende plaziert! ";}
	}
	
	
	public void findeEnde(){ //... und wo sich dieses befindet
		checkeEnde();
		//durchsuche spielfeld
		if (ende_plaziert==true)
		for (int i = 0; i!=11; i++)
			for (int j=0; j!=11;j++) {
				if (spielfeld[i][j]=='f' || spielfeld[i][j]=='h') {endeX=i; endeY=j; anzahl_ende+=1;}
				if (i==11 && j==11) {
				}
			}
		else {System.out.println("kein Ende!");}
		if (anzahl_ende>1) {fehler+="Zu viele Enden! ";}  //zuviele Enden? Karte ist nicht konsistent!
	}
	
}
