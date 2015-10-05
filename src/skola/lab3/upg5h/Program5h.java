package skola.lab3.upg5h;

import skola.lab3.upg5e.PaintWindow;

import javax.swing.*;

import java.net.URL;

/**
 * Created by sebadmin on 2015-09-14.
 */
public class Program5h {

    private PaintWindow window;
    private ImageIcon imageSummer;
    private int maxMove;
    private int imageWidth;
    private int currentX=10;

    public void loadImage() {
        window = new PaintWindow();



        URL summerPath = this.getClass().getResource("/res/gubbe.jpg");
        imageSummer = new ImageIcon(summerPath);

        imageWidth = imageSummer.getIconWidth();
        maxMove = window.getWidth()-this.imageWidth;

        window.showImage(imageSummer, currentX, 10);
    }

    public static void main(String[] args) {
        Program5h prog = new Program5h();
        prog.loadImage();

        prog.moveTheGuy();
    }

    private void moveTheGuy() {

        try {
            while(currentX < maxMove)
            {
                Thread.sleep(100);
                currentX +=10;
                //ritar om bilden
                window.showImage(imageSummer, currentX, 10);

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
