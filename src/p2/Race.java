package p2;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.net.URL;
import java.util.Random;

/***
 * A race program that handles creating a race between 2 cars.
 * 
 *
 */
public class Race {

	// The goal position
	private static final int GOAL_LINE_POS = 100;
	// a font object, handling the font for the text
	private final Font font;
	// a paint window to show the race
	private final PaintWindow pw;
	// the cars that are racing in the game
	private final Car car1;
	private final Car car2;
	// random for setting random speed of the car
	private final Random rnd;
	// text holder for the cars position
	private Text car1Text;
	private Text car2Text;
	// soundhandler
	private AudioClip clip;

	/**
	 * Creates a race object for handling the race
	 * 
	 * @param window
	 *            the paintwindow where the race is displayed
	 * 
	 * @param car1
	 *            first car in the game
	 * @param car2
	 *            second car in the game
	 */
	public Race(PaintWindow window, Car car1, Car car2) {

		// connect the variables to the object.
		this.pw = window;
		this.car1 = car1;
		this.car2 = car2;

		// create a randomzier later used fro randomizing the speed
		this.rnd = new Random();

		// create a font for using in displaying the steps left for the cars
		this.font = new Font(Font.MONOSPACED, Font.BOLD, 24);

		// init the cars. can be use to reset the race
		init();

		// show stuff
		// draw the static things, like racetrack, goalline m.m.
		// background, the green color
		pw.fillRect(0, 0, pw.getWidth(), pw.getHeight(), Color.GREEN);

		// racetrack. draws the race track
		pw.fillRect(0, 180, pw.getWidth(), 50, Color.GRAY);
		pw.fillRect(0, 260, pw.getWidth(), 50, Color.GRAY);
		// draw the goal line
		pw.line(GOAL_LINE_POS, 180, GOAL_LINE_POS, 310, Color.BLACK, 10);

	}

	/**
	 * Init the cars position and sets the start text (late can be used to reset the game)
	 */
	private void init() {
		// init positions
		// get the start position for the car, from the window widht - car size and 20 px from the edge
		int starPos = this.pw.getWidth() - car1.getImage().getIconWidth() - 20;
		this.car1.moveTo(starPos, 190);
		this.car2.moveTo(starPos, 270);

		// init the Textboxes with the car x position
		this.car1Text = new Text(String.valueOf(this.car1.getX()), font, Color.white, Color.BLUE);
		this.car2Text = new Text(String.valueOf(this.car2.getX()), font, Color.white, Color.RED);

		// displays cars in start position in x cords
		pw.showImage(car1.getImage(), car1.getX(), car1.getY());
		pw.showImage(car2.getImage(), car2.getX(), car2.getY());

	}

	/**
	 * Start the game, starts the car race
	 */
	public void action() {

		// variables used in the loop
		// Y values for the car 1,2.
		int y1 = car1.getY();
		int y2 = car2.getY();

		// movment speed for the cars
		int dx;

		// the second textbox should be next to the first
		int text2Pos = 10 + car1Text.getIconWidth();

		// The winning text displayed at the end
		String winnerString;

		// start The sound
		startSound();

		// while true loop is because i do the check in the loop
		// because i want to save the winner. instead of doing a double check
		// later.
		while (true) {

			/**
			 * Draw the car at the new position and Cars position text
			 */
			pw.showImage(car1.getImage(), car1.getX(), y1);
			pw.showImage(car2.getImage(), car2.getX(), y2);
			pw.showImage(car1Text, 10, 50);
			pw.showImage(car2Text, text2Pos, 50);

			// update freq. the speed for the game to update in ms (updates with 20ms)
			PaintWindow.pause(20);

			// movement
			/*
			 * Randomize first speed then move the car first for car1 and then for car2
			 */
			dx = this.rnd.nextInt(10);
			car1.moveTo(car1.getX() - dx, y1);
			dx = this.rnd.nextInt(10);
			car2.moveTo(car2.getX() - dx, y2);

			// added setText to the Text element due to it was missing.
			// otherwise i would cause a memory leak
			// the - 100 is because that the finish line is 100px from edge of the window.
			car1Text.setText(car1.getX() - 100);
			car2Text.setText(car2.getX() - 100);

			// Check which if a car won.
			// if the car X is at x position 100 where the line is, it has won
			// break out of the loop if true
			if (car1.getX() <= GOAL_LINE_POS) {
				System.out.println("Car 1 won");
				winnerString = "Winner BLUE";
				break;
			}

			// Check which if a car won.
			// if the car X is at x position 100 where the line is, it has won
			// break out of the loop if true
			if (car2.getX() <= GOAL_LINE_POS) {
				System.out.println("Car 2 won");
				winnerString = "Winner RED";
				break;
			}
		}
		// extra to display in console that the game has ended
		System.out.println("Game end");

		// Stop the sound, the if is because it may not been able to init the sound object.
		if (clip != null) {
			System.out.println("stop sound");
			clip.stop();
		}

		// create winning textbox and display it
		Text winnerText = new Text(winnerString, font, Color.BLACK, Color.white);
		pw.showImage(winnerText, pw.getWidth() / 2, 100);


	}

	private void startSound() {
		this.clip = null;
		try {

			// URL url = new File("/p2/car.wav").toURI().toURL();
			URL url = this.getClass().getResource("/p2/car.wav");

			clip = Applet.newAudioClip(url);
		} catch (Exception e) {
			// if couldnt add sound sets sound. clip == null
		}

		if (clip != null) {
			System.out.println("play sound");
			clip.play();
		}
		else
		{
			System.out.println("NO sound");
		}

	}

}
