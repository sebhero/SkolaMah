package p2;

import java.awt.Color;
import java.util.Random;

public class Race {

	private PaintWindow pw;
	private Car car1;
	private Car car2;
	private Random rnd;

	public Race(PaintWindow window, Car car1, Car car2) {

		this.pw = window;
		this.car1 = car1;
		this.car2 = car2;
		this.rnd = new Random();
	}

	public void action() {

		/**
		 * Rita bild rita bakgrund rita road rita goal linje rita hur langt kvar
		 * po car1 rita hur langt kvar po car2 loopa forflytt av X po bilar
		 * tills en bil nar goal X
		 */

		// init positions
		int starPos = this.pw.getWidth() - car1.getImage().getIconWidth() - 20;
		this.car1.moveTo(starPos, 200);
		this.car2.moveTo(starPos, 250);

		// Text car1Text = new Text("Hello car1", Font.MONOSPACED, Color.white
		// );

		// show stuff
		pw.getContentPane().setBackground(Color.GREEN);

		pw.fillRect(0, 0, pw.getWidth(), pw.getHeight(), Color.GREEN);
		pw.fillRect(0, 150, pw.getWidth(), 0, Color.GRAY);
		pw.line(100, 180, 100, 300, Color.BLACK, 10);
		pw.showImage(car1.getImage(), car1.getX(), car1.getY());
		pw.showImage(car2.getImage(), car2.getX(), car2.getY());
		// pw.showImage(car1Text, 0, 50);

		int y1 = car1.getY();
		int y2 = car2.getY();
		int dx = 3;

		while (true) {

			pw.showImage(car1.getImage(), car1.getX(), car1.getY());
			pw.showImage(car2.getImage(), car2.getX(), car2.getY());
			PaintWindow.pause(20); // pausa exekveringen i 20 ms innan nästa
			// förflyttning
			car1.moveTo(car1.getX() - dx, y1);
			car2.moveTo(car2.getX() - dx, y2);

			if (car1.getX() <= 100) {
				System.out.println("Car 1 won");
				break;
			}
			if (car2.getX() <= 100) {
				System.out.println("Car 2 won");
				break;
			}

			// om image x pos is bigger than the windows edge and image width
			// chang direction
			// if (car1.getX() > 50) {
			// dx = -dx;
			// break;
			// }
		}
		System.out.println("Game end");

	}

}
