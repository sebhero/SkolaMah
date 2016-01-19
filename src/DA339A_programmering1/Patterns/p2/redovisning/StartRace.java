package p2.redovisning;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

/**
 * Klassen startar programmet Race
 * @author TSROAX
 */
public class StartRace { // /Volumes/Home/TSROAX/
    public static void main(String[] args) {
        PaintWindow window = new PaintWindow();
        Car c1 = new Car(new ImageIcon("bilder/CarBlue.GIF"));
        Car c2 = new Car(new ImageIcon("bilder/CarRed.GIF"));
        Race race = new Race(window,c1,c2);
        race.action();
        if(args.length>0) {
            PaintWindow.pause(2000);
            window.dispose();
        }
    }
}
