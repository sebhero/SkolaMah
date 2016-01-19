package p2.redovisning;

public class Painting {
	
	private String title;
	private String painter;
	private int year;
	
	//Konstruktorn ser till att variablerna i den nya instansen har de v�rden de ska ha
	// V�rdena ska i konstruktorn f�ras �ver till motsvarande instansvariabler i klassen
	public Painting ( String title, String painter, int year){
		this.title = title;         
		this.painter = painter;         
		this.year = year;
	}
	//Retunerar v�rdet av variabeln title
	public String getTitle (){
		return this.title;
	}
	//Retunerar v�rdet av variabeln painter
	public String getPainter (){
		return this.painter;
	}
	//Retunerar v�rdet av variabeln year
	public int getYear (){
		return this.year;
	}
	//Retunerar en str�ng
	public String toString (){
		return this.title + " av " + this.painter + ", " + this.year; 
	}

}