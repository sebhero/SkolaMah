package p2.redovisning;

import java.awt.Color;
import java.util.Random;

public class Race {
	private PaintWindow window;
	private Car car1;
	private Car car2;

	// konstruktor som tar emot dessa objekt som argument
	// V�rdena ska i konstruktorn f�ras �ver till motsvarande instansvariabler i klassen
	public Race(PaintWindow window, Car c1, Car c2) { 
		this.window = window; 
		this.car1 = c1;
		this.car2 = c2;
	}
	
	//Initierar spelet och genomf�r ett race mellan tv� bilar.
	public void action(){
		
		Random random = new Random();
		
		 // Tre rektanglar och en linje skapas i paintWindow f�nstret.
		 window.fillRect(0, 0, 600, 400, Color.GREEN);
		 window.fillRect(40, 100, 500, 70, Color.GRAY);
		 window.fillRect(40, 200, 500, 70, Color.GRAY);
		 window.line(100, 50, 100, 320, Color.BLACK, 5);
		 
		 // Visar bilarna och vart de ska b�rja.
		 car1.moveTo(470, 120);
	     car2.moveTo(470, 220);
	     window.showImage(car1.getImage(), car1.getX(), car1.getY());
	     window.showImage(car2.getImage(), car2.getX(), car2.getY());
	
	  
	        // En while-loop som loppar tills en av bilarna n�r ett X-v�rde p� 100 eller mindre.  
	        while (car1.getX()>100 && car2.getX()>100 ){
	        	
	         
	         //Ger getX ett nytt v�rde, flyttar bilarna.
	         car1.moveTo(car1.getX()-random.nextInt(10)+1, 120);
	         car2.moveTo(car2.getX()-random.nextInt(10)+1, 220);
	         
	         window.showImage(car1.getImage(), car1.getX(), car1.getY());
		     window.showImage(car2.getImage(), car2.getX(), car2.getY());
	
	        PaintWindow.pause(20);
	        
	       }
	
	
	
	
	
	}
}
