package DA339A_programmering1.Patterns.p2;

import java.net.URL;

import javax.swing.ImageIcon;

/**
 * Klassen startar programmet Race
 * 
 * @author TSROAX
 */
public class StartRace { // /Volumes/Home/TSROAX/
	public static void main(String[] args) {
		PaintWindow window = new PaintWindow();
		URL imgPath1 = StartRace.class.getResource("/DA339A_programmering1/Patterns/p2/CarBlue.GIF");
		URL imgPath2 = StartRace.class.getResource("/DA339A_programmering1/Patterns/p2/CarRed.GIF");
		Car c1 = new Car(new ImageIcon(imgPath1));
		Car c2 = new Car(new ImageIcon(imgPath2));
		Race race = new Race(window, c1, c2);

        race.action();
		if (args.length > 0) {
			PaintWindow.pause(2000);
			window.dispose();
		}
	}
}
