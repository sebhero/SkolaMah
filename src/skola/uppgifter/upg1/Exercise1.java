

/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.uppgifter.upg1;
import java.net.URL;
import java.util.Random;
import javax.swing.*;

public class Exercise1 {

    private PaintWindow pw;
    private int y;
    private Icon image;
    private int x;
    private int dx;
    private int dy;

    /*
         * Metoden beräknar totala biljettpriset och det genomsnittliga
         * biljettpriset för ett antal vuxna, barn och pensionärer.
         **/
	public void exercise1a() {

        //Get a input string from user with the amount of passangers
        String passangersString = JOptionPane.showInputDialog("ange antal Vuxna,Barn och Pensionärer.\n" +
                "Använd , för att sepera\n" +
                "tex: 2,3,1");

        //convert the string of passangers
        String[] passangersList = passangersString.split(",");

        //try to convert the inputs to ints
        try {
            //converting the input to ints
            int vuxna=Integer.parseInt(passangersList[0]);
            int barn=Integer.parseInt(passangersList[1]);
            int pensionar=Integer.parseInt(passangersList[2]);

            //calculate sum of price and average for each passenger
            int sum = (110*vuxna)+(60*barn)+(80*pensionar);
            int avg = sum/(barn+vuxna+pensionar);

            //display the result
            JOptionPane.showMessageDialog(null,"Totala priset ar: "+sum+"\n" +
                    "Genomsnittspriset ar: "+avg);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            //Display error message if the user didnt make a correct input
            JOptionPane.showMessageDialog(null,"Error! kunde inte beräknas!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Skriv ut alla udda tal fran 1-100
     */
	public void exercise1b() {
        for (int i = 0; i < 100; i++) {
            //check if input is odd
            if(i%2>0)
            {
                System.out.println("number is odd: "+i);
            }
        }
    }

    /***
     * Check if input is a zero, negative or positive
     */
	public void exercise1c() {

        Integer theNumber = Integer.parseInt(JOptionPane.showInputDialog("ange ett tal"));

        if(theNumber == 0)
        {
            System.out.println(theNumber + " the number is Zero");
        }
        if(theNumber < 0)
        {
            System.out.println(theNumber + " the number is negative");
        }
        if(theNumber > 0)
        {
            System.out.println(theNumber + " the number is positive");
        }

    }

    /**
     * List numbers between 2 numbers and it will loop
     * through and display every 7 increase
     */
    public void exercise1d() {

        String[] theNumber = JOptionPane.showInputDialog("ange minsta och största tal. seperar med ,\n" +
                "tex: 1,4").split(",");
        //for testing
//        String[] theNumber = {"10","50"};
        for (int i = Integer.parseInt(theNumber[0]); i < Integer.parseInt(theNumber[1]); i+=7) {
            System.out.println(i);
        }

        
    }

    /**
     * paint a guy in windows bouncing from left to right
     */
	public void exercise1e() {

        //load the window set dx and dy
        createWindow(-3,0);


		// oändlig loop, raderna 36-42 upprepas tills PaintWindow-fönstret stängs
		while(true) {
			pw.showImage(this.image, this.x, this.y);
			PaintWindow.pause(20); // pausa exekveringen i 20 ms innan nästa förflyttning
			x += dx;
			y += dy;
            //if image x is less than windows width
			if(x<0) {
				dx = -dx;
			}
            //om image x pos is bigger than the windows edge and image width chang direction
            if(x>pw.getWidth()-image.getIconWidth()) {
                dx = -dx;
            }
		}
	}

    /**
     * paint a guy in windows bouncing from cornor to corner
     */
	public void exercise1f() {
        //load the window with a x random
        createWindow(3, -2,500);

        // oändlig loop, raderna 36-42 upprepas tills PaintWindow-fönstret stängs
        while(true) {
            pw.showImage(this.image, this.x, this.y);
            PaintWindow.pause(20); // pausa exekveringen i 20 ms innan nästa förflyttning
            x += dx;
            y += dy;
            //if image y is smaller than window height
            if(y<0) {
                dy = -dy;
            }
            //om image x pos is bigger than the windows edge and image width chang direction
            if(y>pw.getHeight()-image.getIconHeight()-28) {
                dy = -dy;
            }

            //if image x is less than windows width
            if(x<0) {
                dx = -dx;
            }
            //om image x pos is bigger than the windows edge and image width chang direction
            if(x>pw.getWidth()-image.getIconWidth()) {
                dx = -dx;
            }

        }


    }

    /**
     * Method for creating the window with movement speed in both x and y
     * @param dx movement speed in horizontal
     * @param dy movement speed in vertical
     * @param newX the random x start value
     */
    private void createWindow(int dx, int dy, int newX) {
        //call the normal createWindow function with out a random X
        createWindow(dx,dy);
        Random rand = new Random();
        this.x = rand.nextInt(newX);
    }

    /**
     * Method for creating the window with movement speed in both x and y
     * @param dx movement speed in horizontal
     * @param dy movement speed in vertical
     */
    private void createWindow(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
        this.pw = new PaintWindow();
        Random rand = new Random();
        //get the image relative path to the project
        URL imgPath = this.getClass().getResource("/res/gubbe.jpg");
        this.image = new ImageIcon(imgPath);
        //not really used!?
        int width = pw.getBackgroundWidth();
        int height = pw.getBackgroundHeight();

        x = 250;
        y = rand.nextInt(height-100);  // Bildens höjd är 100
    }



}
