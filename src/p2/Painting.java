package p2;

import java.text.MessageFormat;

/**
 * A model of a painting.
 * 
 *
 */
public class Painting {

	// Variables used for the Painting
	private final String title;
	private final String painter;
	private final int year;

	/**
	 * Painting constructor take the title,Painter and year when it was painted
	 * 
	 * @param title the title of the painting
	 * @param painter the name of the painter
	 * @param year the year it was painted
	 */
	public Painting(String title, String painter, int year) {
		super();
		this.title = title;
		this.painter = painter;
		this.year = year;
	}

	/**
	 * Get the title of the painting
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Get the painter for the painting
	 * 
	 * @return the string name of the painter
	 */
	public String getPainter() {
		return painter;
	}

	/**
	 * Gets the year when the painting was painted
	 * 
	 * @return the year it was painted
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Gives a string variable of the painting model
	 */
	@Override
	public String toString() {
		return MessageFormat.format("{0} av {1}, {2}", this.title,
				this.painter, this.year);
	}

}
