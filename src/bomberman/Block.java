package bomberman;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Block auf Spielfeld
 * @author Levent Sarp, Dennis Weber, Daniel Gros, Adrian Schmidt, Fabian Pegel
 * @version 0.1
 * 
 *  */

public class Block extends JLabel {
    
	private static final long serialVersionUID = 1L;
	public boolean walkable;
    public boolean destroyable ;
    public boolean fin;
    public boolean bombe;
    
    /**
     * Imageicon übergeben
     * @param imageicon Bild des Feldes
     */
    public Block(ImageIcon imageicon){
        super(imageicon);
    }
}