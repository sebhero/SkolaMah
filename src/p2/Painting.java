package p2;

import java.text.MessageFormat;

import com.sun.glass.ui.Pixels.Format;

public class Painting {
	
	private String title;
	private String painter;
	private int year;
	
	public Painting(String title, String painter, int year) {
		super();
		this.title = title;
		this.painter = painter;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public String getPainter() {
		return painter;
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return MessageFormat.format("{0} av {1}, {2}", this.title,this.painter,this.year);
	}
	
	

}
