package DA339A_programmering1.Patterns.p2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * A program that hands time
 * 
 *
 */
public class Time {

	private final Calendar cal = Calendar.getInstance();

	public Time() {

		// sets the starting time. By calling New Date(), which creates a
		// timestamp for current time & date
		cal.setTime(new Date()); // Klassen Date finns i java.util

	}

	/**
	 * Returns the hour for the timestamp
	 * 
	 * @return a int of hour
	 */
	public int getHour() {
		return cal.get(Calendar.HOUR);
	}

	/**
	 * Returns the minutes for the timestamp
	 * 
	 * @return a int of minutes
	 */
	public int getMinute() {
		return cal.get(Calendar.MINUTE);
	}

	/**
	 * Returns the seconds for the timestamp
	 * 
	 * @return a int of seconds
	 */
	public int getSecond() {
		return cal.get(Calendar.SECOND);
	}

	/**
	 * Make a new timestamp. and removes the old one.
	 */
	public void update() {

		cal.setTime(new Date()); // Klassen Date finns i java.util

	}

	/**
	 * Prints out the timestamp in pretty format
	 */
	@Override
	public String toString() {
		// How the timestamp should be formatted
		// HH = hours with 2 digits. mm = minus with 2 digits, ss = seconds
		// with 2 digits
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		// returns a pretty formatted timestamp
		return dateFormat.format(this.cal.getTime());
	}
}
