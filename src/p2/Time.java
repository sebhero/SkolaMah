package p2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time {

	Calendar cal = Calendar.getInstance();

	public Time() {

		cal.setTime(new Date()); // Klassen Date finns i java.util

	}

	public int getHour() {
		// TODO Auto-generated method stub
		return cal.get(Calendar.HOUR);
	}

	public int getMinute() {
		// TODO Auto-generated method stub
		return cal.get(Calendar.MINUTE);
	}

	public int getSecond() {
		return cal.get(Calendar.SECOND);
	}

	public void update() {

		cal.setTime(new Date()); // Klassen Date finns i java.util

	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		return dateFormat.format(this.cal.getTime());
	}
}
