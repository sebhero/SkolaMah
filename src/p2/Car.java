package p2;

import javax.swing.ImageIcon;

/**
 * The car model. Represent the car that we are using in the racing game
 * 
 */
public class Car {

	private final ImageIcon image;
	private int x;
	private int y;

	/**
	 * Creates a car model. adds the image for the car
	 * 
	 * @param image
	 *            of the car.
	 */
	public Car(ImageIcon image) {
		this.image = image;
	}

	/**
	 * Get the image of the car
	 * 
	 * @return the image of the car
	 */
	public ImageIcon getImage() {
		return image;
	}

	/**
	 * Gets the X cord of the car in the window
	 * 
	 * @return a int of the X cords.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Gets y cord for the car
	 * 
	 * @return the int of the Y cords.
	 */
	public int getY() {
		return y;
	}

	/**
	 * Updates the x and y cords for the car. Moves it to the new position
	 * 
	 * @param x
	 *            int cord
	 * @param y
	 *            int cord
	 */
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
