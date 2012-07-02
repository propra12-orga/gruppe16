package bomberman;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.net.URISyntaxException;
import java.util.regex.*;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class Vorabfragen {
   	public LaunchFrame lf;
   /**
    * von: stackoverflow.com
    * Validate ip address with regular expression
    * @param ip ip address for validation
    * @return true valid ip address, false invalid ip address
    */
    public boolean IPvalidate(String ip){
    	Pattern ippattern = Pattern.compile("^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");
    	Matcher ipmatcher = ippattern.matcher(ip);
    	Pattern hostpattern = Pattern.compile("^(([a-zA-Z]|[a-zA-Z][a-zA-Z0-9\\-]*[a-zA-Z0-9])\\.)*([A-Za-z]|[A-Za-z][A-Za-z0-9\\-]*[A-Za-z0-9])$");
    	Matcher hostmatcher = hostpattern.matcher(ip);
    	if(ipmatcher.matches()) {return true;}
    	else if(hostmatcher.matches()) {return true;}
    	else {return false;}
    }

	public void fragen(LaunchFrame la) {
		lf=la;
        System.out.println("Alles ok!");
    	lf.networkgame=false;
        JTextField new_text = new JTextField("hier IP des anderen Rechners eintragen");
        final JDialog new_dialog = new JDialog(lf.frame, "Spielmodus");
        new_dialog.toFront();
        new_dialog.setSize(500,150);
        new_dialog.setLocationRelativeTo(lf.frame);
        new_dialog.setModal(true);
	    new_dialog.setLayout(new GridLayout(9,1));        
	    
	    JRadioButton p1 = new JRadioButton("Ich bin Player 1");
	    p1.setActionCommand("Ich bin Player 1");
	    
	    JRadioButton p2 = new JRadioButton("Ich bin Player 2");
	    p2.setActionCommand("Ich bin Player 2");
	    ButtonGroup group = new ButtonGroup();
	    group.add(p1);
	    group.add(p2);

		final JRadioButton t1=p1;
		final JRadioButton t2=p2;
		t1.setVisible(false);
		t2.setVisible(false);
		final JTextField txt=new_text;
		txt.setVisible(false);


	    
	    JRadioButton sf1 = new JRadioButton("Standardspielfeld laden");
	    JRadioButton sf2 = new JRadioButton("eigenes Spielfeld laden");
		final JRadioButton s1=sf1;
		final JRadioButton s2=sf2;

	    // wenn eigenes Spielfeld dann boolesche Variable,
	    // die in Spielfeld.java den Datei-Dialog aufruft
	    
	    JRadioButton net1 = new JRadioButton("lokal am Computer spielen");
	    JRadioButton net2 = new JRadioButton("über Netzwerk spielen");
	    ButtonGroup group2 = new ButtonGroup();
	    group2.add(net1);
	    group2.add(net2);
	    net1.setSelected(true);
		ActionListener netl = new ActionListener() {
		    public void actionPerformed( ActionEvent e )
		    {
		    	File currentJar = null;
				try {
					currentJar = new File(SirBomberman.class.getProtectionDomain().getCodeSource().getLocation().toURI());
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	System.out.println(currentJar.getPath());
		    	
		    	t1.setVisible(true);
		    	t2.setVisible(true);
				txt.setVisible(true);

		    	lf.networkgame=true;

		    }
		   };
			ActionListener netm = new ActionListener() {
			    public void actionPerformed( ActionEvent e )
			    {
			    	System.out.println();
			    	t1.setVisible(false);
			    	t2.setVisible(false);
					txt.setVisible(false);

			    	lf.networkgame=false;

			    }
			   };

			   net1.addActionListener(netm);
			   net2.addActionListener(netl);



	    
		JButton save = new JButton("speichern");
		ActionListener al = new ActionListener() {
		    public void actionPerformed( ActionEvent e )
		    {
		    	
		    if(s1.isSelected()){
		    	lf.auswahldialog=false;
		    	System.out.println("auswahl: " + lf.auswahldialog);

		    }
		    if(s2.isSelected()){
		    	lf.auswahldialog=true;
		    	System.out.println("auswahl: "+lf.auswahldialog);
		    }
		    if(t1.isSelected()){
    		    lf.playernr=1;
    		    System.out.println("saved"+lf.playernr+getPl(t1));
		    }
		    if(t2.isSelected()){
    		    lf.playernr=2;
    		    System.out.println("saved"+lf.playernr+getPl(t2));
		    }
		    
		    if(lf.networkgame && IPvalidate(txt.getText()) && (lf.playernr==1 || lf.playernr==2)){
		    	lf.ip=txt.getText();
		    	new_dialog.dispose();
		    }
		    if( lf.networkgame && (!IPvalidate(txt.getText()) || (lf.playernr!=1 && lf.playernr!=2))) {
		    	JOptionPane.showMessageDialog(lf.frame, "Bitte korrekte IP oder Hostnamen eingeben und Playernummer festelegen!", "Falsche Eingabe", JOptionPane.INFORMATION_MESSAGE);
		    }
		    
		    if (!lf.networkgame){
		    	new_dialog.dispose();

		    }
		  }
		};
		save.addActionListener(al);
		
		FocusListener fl = new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				if(txt.getText().length()<1){
					txt.setText("hier IP des anderen Rechners eintragen");
				}
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				txt.setText("");
				
			}
		};
		txt.addFocusListener(fl);
		JSeparator jsep = new JSeparator();
		//if(bu.)
		new_dialog.add(sf1);
        new_dialog.add(sf2);
	    ButtonGroup group3 = new ButtonGroup();
	    sf1.setSelected(true);
	    group3.add(sf1);
	    group3.add(sf2);
	    new_dialog.add(jsep);
	    new_dialog.add(net1);
		new_dialog.add(net2);


		new_dialog.add(t1);
		new_dialog.add(t2);
        new_dialog.add(new_text);

        new_dialog.add(save);
        
        new_dialog.pack();
        new_dialog.setVisible(true);



   

}

public String getPl(JRadioButton jb){
	String bt = jb.getText();
	return bt;
	
}
}
