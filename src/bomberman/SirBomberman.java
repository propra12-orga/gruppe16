package bomberman;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;
import javax.swing.*;

import bomberman.LaunchFrame;

/**
 * Hauptklasse
 * @author Levent Sarp, Dennis Weber, Daniel Gros, Adrian Schmidt, Fabian Pegel
 * @version 0.1
 * 
 *  */
public class SirBomberman implements KeyListener {

	/**
	 * Objekt erzeugen, das an alle Klassen weitergegeben wird
	 */
	public LaunchFrame lf;
	

	
	public static void main(String[] args) {
        SirBomberman game = new SirBomberman();
        game.launchFrame(); 

     
    }

    
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    /**
     * Konstruktor zur Frameerzeugung
     */
    public SirBomberman() {
    	lf = new LaunchFrame();
    	
    	lf.frame = new JFrame("SirBomberman");
        lf.panel = new JPanel();
        Vorabfragen Va = new Vorabfragen();
        Va.fragen(lf);
    }
    
    /**
     * Musik abspielen
     */
    public void playMusic(){
    	if(lf.musik){
    	Sequencer sequencer = null;
		try {
			sequencer = MidiSystem.getSequencer();
		} catch (MidiUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
        try {
			sequencer.open();
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        InputStream midiFile = SirBomberman.class.getResourceAsStream( "/midi/funkydjent.mid" ); 
        try {
			sequencer.setSequence( MidiSystem.getSequence(midiFile) );
		} catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        sequencer.start(); 
        //sequencer.stop();
    }
    }
    
    
    
    /**
     * Spielfeld erzeugen
     */
    public void launchFrame() {
        lf.spielfeld_malen(lf);
        lf.panel.addKeyListener(this);
        lf.panel.requestFocus();
        playMusic();

        if(lf.networkgame){
        	//if(lf.netz.socket!=null){System.out.println(lf.netz.socket);}
        	

        try {
        		//lf.netz.socket.close();
     			lf.netz = new Network();
     		} catch (IOException e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     		}
             try {
				lf.netz.hoeren(lf);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
        

   }

    
    
/**
 * Abfragen der Tastatureingaben während des Spiels
 */
    public void keyPressed(KeyEvent e) {
    	if(lf.networkgame && lf.playernr==1){
    	lf.t.abfragen(lf, e);
    	try {
			lf.netz.senden(lf, e);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	}
    	if(lf.networkgame && lf.playernr==2){
    	lf.t2.abfragen(lf, e);
    	try {
			lf.netz.senden(lf, e);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

    	}
    	
    	if(!lf.networkgame) {
        	lf.t2.abfragen(lf, e);
        	lf.t.abfragen(lf, e);

    	}
    }   
    
    /**
     * Netzwerk nach Tastendrücken abfragen
     */
    	
}

