package p2;

import java.awt.*;
import java.util.Random;

public class Race {

    private static final int GOAL_LINE_POS = 100;
    private final Font font;
    private final PaintWindow pw;
	private final Car car1;
	private final Car car2;
	private final Random rnd;
    private Text car1Text;
    private Text car2Text;

    public Race(PaintWindow window, Car car1, Car car2) {

		this.pw = window;
		this.car1 = car1;
		this.car2 = car2;
		this.rnd = new Random();

        this.font = new Font(Font.MONOSPACED,Font.BOLD,24);

        //init the cars. can be use to reset the race
        init();


        // show stuff
        //draw the static things, like racetrack, goalline m.m.
        //background
        pw.fillRect(0, 0, pw.getWidth(), pw.getHeight(), Color.GREEN);

        //racetrack
        pw.fillRect(0, 180, pw.getWidth(), 50, Color.GRAY);
        pw.fillRect(0, 260, pw.getWidth(), 50, Color.GRAY);
        //goal line
        pw.line(GOAL_LINE_POS, 180, GOAL_LINE_POS, 310, Color.BLACK, 10);

    }

    /**
     * Init the cars position and sets the start text
     */
    private void init() {
        // init positions
        int starPos = this.pw.getWidth() - car1.getImage().getIconWidth() - 20;
        this.car1.moveTo(starPos, 190);
        this.car2.moveTo(starPos, 270);

        //init the Textboxes
        this.car1Text = new Text(String.valueOf(this.car1.getX()), font, Color.white,Color.BLUE);
        this.car2Text = new Text(String.valueOf(this.car2.getX()), font, Color.white,Color.RED);

        //displays cars in start position
        pw.showImage(car1.getImage(), car1.getX(), car1.getY());
        pw.showImage(car2.getImage(), car2.getX(), car2.getY());

    }

    public void action() {

		/**
		 * Rita bild rita bakgrund rita road rita goal linje rita hur langt kvar
		 * po car1 rita hur langt kvar po car2 loopa forflytt av X po bilar
		 * tills en bil nar goal X
		 */
        
        //variables used in the loop
        //Y values for the car 1,2.
		int y1 = car1.getY();
		int y2 = car2.getY();
        //movment speed
		int dx;
        //the second textbox should be next to the first
        int text2Pos = 10+car1Text.getIconWidth();
        String winnerString;

        //while true loop is because i do the check in the loop
        //because i want to save the winner. instead of doing a double check later.
		while (true) {

            // redraw the car and car text
			pw.showImage(car1.getImage(), car1.getX(), y1);
			pw.showImage(car2.getImage(), car2.getX(), y2);
            pw.showImage(car1Text,10, 50);
            pw.showImage(car2Text,text2Pos, 50);

			PaintWindow.pause(20); // pausa exekveringen i 20 ms innan nästa

			// movement
            /*
            Randomize first speed
            then move the car
             */
            dx = this.rnd.nextInt(10);
			car1.moveTo(car1.getX() - dx, y1);
            dx = this.rnd.nextInt(10);
			car2.moveTo(car2.getX() - dx, y2);

            //added setText to the Text element due to it was missing.
            //otherwise i would cause a memory leak
            car1Text.setText(car1.getX());
            car2Text.setText(car2.getX());

            //Check which if a car won.
            //if the car X is at x position 100 where the line is, it has won
			if (car1.getX() <= GOAL_LINE_POS) {
				System.out.println("Car 1 won");
                winnerString = "Winner BLUE";
				break;
			}

            //Check which if a car won.
            //if the car X is at x position 100 where the line is, it has won
			if (car2.getX() <= GOAL_LINE_POS) {
				System.out.println("Car 2 won");
                winnerString = "Winner RED";
				break;
			}
		}
		System.out.println("Game end");

        //create winning textbox and dispaly
        Text winnerText = new Text(winnerString, font, Color.BLACK,Color.white);
        pw.showImage(winnerText,pw.getWidth()/2,100);

    }

}
