
import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class Block    extends JLabel {
    
    public boolean walkable;
    public boolean destroyable ;
    public boolean fin;
    
    
    public Block(ImageIcon imageicon){
        super(imageicon);
    }
}