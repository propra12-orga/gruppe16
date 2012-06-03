package bomberman;

import java.util.Timer;
import java.util.TimerTask;

public class Test {

public Timer[][] torte = new Timer[2][2];
public Test(){
	torte[0][0]=new Timer();
torte[0][0].schedule(new Sagwas(), 2000);
}
class Sagwas extends TimerTask{
		public void run(){
		System.out.println("2 sekunden");
		torte[0][0].cancel();
		}
}
public static void main(String args[]){
	System.out.println("Hallo");
	new Test();
}
}
