package skola.lab3.upg5e;
import java.awt.Color;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 * Programmet demonstrerar olika metoder i PaintWindow
 * @author TSROAX
 */
public class PaintWindowDemo {
    public void demo1() {
        PaintWindow window = new PaintWindow();
        //ImageIcon image = new ImageIcon("M:/bilder/gubbe.jpg");
        URL imagepath = this.getClass().getResource("/res/gubbe.jpg");
        ImageIcon image = new ImageIcon(imagepath);
        System.out.println(imagepath.getPath().toString());
        window.line(200, 100, 400, 200, Color.CYAN, 10);
        window.line(100, 280, 400, 100, Color.BLACK, 3);
        window.drawRect(10, 10, 280, 380, Color.YELLOW, 4);
        window.fillRect(30, 280, 200, 60, Color.BLUE);
        window.drawOval(240, 40, 100, 100, Color.MAGENTA, 10);
        window.fillOval(270, 70, 40, 60, Color.GREEN);
        window.showImage(image, 400, 150);
    }
    
    public static void main(String[] args) {
        PaintWindowDemo prog = new PaintWindowDemo();
        prog.demo1();
    }
}