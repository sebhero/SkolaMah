package DA339A_programmering1.Patterns.skola.lab23;
import java.awt.*;
import javax.swing.*;

public class DiscardIcon implements Icon {
    private Icon icon;
    private int width;
    
    public DiscardIcon(Icon iconObject, int width) {
        this.icon = iconObject;
        this.width = width;
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        icon.paintIcon(c,g,x,y);
        g.setColor(Color.RED);
        for(int i=0; i<width; i++) {
            g.drawLine(x, y+i, x+icon.getIconWidth(), y+icon.getIconHeight()-width+i);
            g.drawLine(x, y+icon.getIconHeight()-width+i, x+icon.getIconWidth(), y+i);
        }
        
    }

    public int getIconWidth() {
        return icon.getIconWidth();
    }

    public int getIconHeight() {
        return icon.getIconHeight();
    }
    
    public static void main(String[] args) {
        ImageIcon icon = new ImageIcon("bilder/Gubbe.jpg");
        IconWindow.showIcon(new DiscardIcon(icon,5));
    }
}
