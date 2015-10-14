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

		// show stuff
		pw.getContentPane().setBackground(Color.GREEN);
		pw.line(200, 100, 400, 200, Color.BLACK, 10);
		pw.showImage(car1.getImage(), car1.getX(), car1.getY());
		pw.showImage(car2.getImage(), car2.getX(), car2.getY());

		// while (true) {
		//
		// pw.showImage(this.image, this.x, this.y);
		// PaintWindow.pause(20); // pausa exekveringen i 20 ms innan nästa
		// // förflyttning
		// x += dx;
		// y += dy;
		// // if image x is less than windows width
		// if (x < 0) {
		// dx = -dx;
		// }
		// // om image x pos is bigger than the windows edge and image width
		// // chang direction
		// if (x > pw.getWidth() - image.getIconWidth()) {
		// dx = -dx;
		// }
		// }

	}

	private void createWindowUpgE() {
		// this.dx = dx;
		// this.dy = dy;
		// this.dx = -3;
		// this.dy = 0;
		// this.pw = new PaintWindow();
		// Random rand = new Random();
		// // get the image relative path to the project
		// URL imgPath = this.getClass().getResource("/p1/gubbe.jpg");
		// this.image = new ImageIcon(imgPath);
		// // not really used!?
		// int width = pw.getBackgroundWidth();
		// int height = pw.getBackgroundHeight();
		//
		// x = 250;
		// y = rand.nextInt(height - 100); // Bildens höjd är 100
	}

}
