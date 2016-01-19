/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.pacman.src;

import java.awt.*;
import javax.swing.ImageIcon;
import java.lang.*;

/**
 * Class Pacman
 */

public class Pacman extends PacOrGhost
{

    private SquareItem position;
    private int direction; 
    private ImageIcon openMouthImage,  closedMouthImage;	//changes to point to images with right direction
    private ImageIcon openMouthImageL, closedMouthImageL;
    private ImageIcon openMouthImageR, closedMouthImageR;
    private ImageIcon openMouthImageU, closedMouthImageU;
    private ImageIcon openMouthImageD, closedMouthImageD;
    private boolean previousWasOpen;
    private int foodLevel;
    private boolean strong, dead;

    /**
     * Constructor
     *

     */
    public Pacman(SquareItem pos)
    {
        position    = pos;
        direction   = 37;  //start facing left
        setDirection (direction);
        foodLevel   = 0;
        strong      = false;
        dead        = false;
        pos.setSomeoneAtPos(this);

//        URL imgPath1 = StartRace.class.getResource("/DA339A_programmering1.Patterns.p2/CarBlue.GIF");
         // Load the images.
        openMouthImageL = 	new ImageIcon(this.getClass().getResource("/DA339A_programmering1/Patterns/pacman/openMouthL.png"));
        closedMouthImageL = new ImageIcon(this.getClass().getResource("/DA339A_programmering1/Patterns/pacman/closedMouthL.png"));
        openMouthImageR = 	new ImageIcon(this.getClass().getResource("/DA339A_programmering1/Patterns/pacman/openMouthR.png"));
        closedMouthImageR = new ImageIcon(this.getClass().getResource("/DA339A_programmering1/Patterns/pacman/closedMouthR.png"));
        openMouthImageU = 	new ImageIcon(this.getClass().getResource("/DA339A_programmering1/Patterns/pacman/openMouthU.png"));
        closedMouthImageU = new ImageIcon(this.getClass().getResource("/DA339A_programmering1/Patterns/pacman/closedMouthU.png"));
        openMouthImageD = 	new ImageIcon(this.getClass().getResource("/DA339A_programmering1/Patterns/pacman/openMouthD.png"));
        closedMouthImageD = new ImageIcon(this.getClass().getResource("/DA339A_programmering1/Patterns/pacman/closedMouthD.png"));
                                
        openMouthImage = openMouthImageR;
        closedMouthImage = closedMouthImageR;
    }                                

    /**
     * Move this ball and redraw.
     **/
    public boolean move()
    {
        foodLevel += position.eatPill();
        // foodLevel -= 1;  //energy is needed to move...

        if (!previousWasOpen) {
            position.eraseMe(closedMouthImage);   	// hide correct image
         }
         else {
            position.eraseMe(openMouthImage);   	// hide correct image   
         }

        SquareItem oldposition = position;
        position = position.newPosition(direction, this); //move, if allowed
        if (position != oldposition) {                    //OK, Pacman moved..
            PacOrGhost s = position.getSomeoneAtPos();    //is someone there?
            if (s != null) {
                if (strong) {                           //Yes, and Packman can eat him!
                    s.kill();
                    foodLevel -= 200;
                }
                else {
                    this.kill();                        //Too bad, Pacman dies   
                }
            }
            position.setSomeoneAtPos (this);            //I moved here
            oldposition.setSomeoneAtPos(null);          //I am not there anymore
        }
        
        //Now draw Packman at his position
        if (previousWasOpen) {
           position.drawMe(closedMouthImage);   // draw at new position
           previousWasOpen = false;
        }
        else {
           position.drawMe(openMouthImage);   // draw at new position
           previousWasOpen = true;    
        }

    //show status after move - should this be done here?
    //   canvas.eraseRectangle(20, 401, 380, 20);  //clean first       
    //    canvas.setFont(new Font("helvetica", Font.BOLD, 14));
    //    canvas.setForegroundColor(Color.blue);
        if (dead) {
            String s = "Packman is dead!";
            //canvas.drawString(s, 20, 420);
        }
        else {
            String s = "Energylevel: " + foodLevel;
            //canvas.drawString(s, 20, 420);
            int f = foodLevel;
            if (foodLevel > 200) {
                f = 200;
                strong = true;
                //canvas.setForegroundColor(Color.red);
            }
            else {
                strong = false;
            }
            position.getCanvas().fillRect(100, 405, f, 10, Color.BLUE);
        }
        return strong;
     }    

    /**
     *  Get Pacman's position
     */
    
    public SquareItem getPos ()
    {
        return position;
    }
    
    public void setDirection(int dir)
    {
        direction = dir;
        
        switch (direction) {
        case 37:    openMouthImage = openMouthImageL;
                    closedMouthImage = closedMouthImageL;
                    break;
        case 38:    openMouthImage = openMouthImageU;
                    closedMouthImage = closedMouthImageU;
                    break;
        case 39:    openMouthImage = openMouthImageR;
                    closedMouthImage = closedMouthImageR;
                    break;
        case 40:    openMouthImage = openMouthImageD;
                    closedMouthImage = closedMouthImageD;
                    break;
        default:    break;
        }
    }
    
    /**
     * Set Pacman Dead!
     */
    
    public void kill()
    {
      dead = true;
    }
    
    
    /**
     * Check if Pacman is Dead
     */
    
    public boolean isDead()
    {
        return dead;
    }
}
