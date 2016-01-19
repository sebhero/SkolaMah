package p2.redovisning;

import java.util.*;



public class Time {
	
	private Calendar cal;
	private int hour;
	private int minute;
	private int second;
	
	// Ger variablerna sina v�rden.
	public Time() {

		cal = Calendar.getInstance();
        hour = cal.get(Calendar.HOUR_OF_DAY);
        minute = cal.get(Calendar.MINUTE);
        second = cal.get(Calendar.SECOND);
	}
	// Retunerar v�rdet av variabeln hour
	public int getHour() {
		return hour;
	}
	// Retunerar v�rdet av variabeln minute
	public int getMinute() {
		return minute;
	}
	// Retunerar v�rdet av variabeln second
	public int getSecond() {
		return second;
	}
	// Retunerar en str�ng
	public String toString() {
		return hour + ":" + minute + ":" + second;
	}
	
	// Uppdaterar klockan/ Ger variablerna nya v�rden.
	public void update() {
		
		cal.setTime(new Date());
		hour = cal.get(Calendar.HOUR_OF_DAY);  
		minute = cal.get(Calendar.MINUTE);
	    second = cal.get(Calendar.SECOND);
	
	}

}
