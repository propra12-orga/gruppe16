package bomberman;
// grafiken:http://lostgarden.com, wikimedia
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Fladd implements KeyListener {
	JFrame frame3 = new JFrame("Bonuslevel");
    JPanel panel3 = new JPanel();
    JLabel label3 = new JLabel();

public Fladd(){
	ImageIcon icon = new ImageIcon(  this.getClass().getResource("/dateien/animation.gif" ));
    frame3.setLocation(0,0);
    frame3.setVisible(true);
    frame3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    frame3.setSize(640, 480);
    panel3.setLayout(new GridLayout(1,1));     
    label3.setIcon(icon);
    panel3.add(label3);
    frame3.add(panel3);
    frame3.validate();
    panel3.addKeyListener(this);
    panel3.requestFocus();

}

@Override
public void keyPressed(KeyEvent e) {
	System.out.println(e.getKeyCode());

	if(e.getKeyCode()==88) {
		System.out.println("ja");
		frame3.dispose();	
	}
}

@Override
public void keyReleased(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}

}
