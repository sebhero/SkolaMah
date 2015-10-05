package skola.lab3.upg5f;

import skola.lab3.upg5e.PaintWindow;

import javax.swing.*;

import java.net.URL;

/**
 * Created by sebadmin on 2015-09-14.
 */
public class Program5f {

    public void demo1() {
        PaintWindow window = new PaintWindow();
        //ImageIcon image = new ImageIcon("M:/bilder/gubbe.jpg");
        URL summerPath = this.getClass().getResource("/res/summer.jpg");
        URL winterPath = this.getClass().getResource("/res/winter.jpg");
        ImageIcon imageSummer = new ImageIcon(summerPath);
        ImageIcon imageWinter = new ImageIcon(winterPath);
        //System.out.println(imagepath.getPath().toString());

        window.showImage(imageSummer, 10, 10);
        window.showImage(imageWinter, 200, 10);
    }

    public static void main(String[] args) {
        Program5f prog = new Program5f();
        prog.demo1();
    }

}
