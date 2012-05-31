package bomberman;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class Block extends JLabel {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public boolean walkable;
    public boolean destroyable ;
    public boolean fin;
    public boolean bombe;

    
    
    public Block(ImageIcon imageicon){
        super(imageicon);
    }
}