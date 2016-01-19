/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.pacman.src;

import javax.swing.ImageIcon;

/**
 * Write a description of class Ghost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ghost extends PacOrGhost
{
    private SquareItem position;
    private int direction; 
    private ImageIcon normalImage, scaredImage;
    private boolean scared, dead;

    /**
     * Constructor
     *
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public Ghost(SquareItem pos)
    {
        position        = pos;
        direction       = 37;  //start facing left
        setDirection (direction);
        scared          = false;
        dead            = false;
        pos.setSomeoneAtPos (this);
        
         // Load the images.
        //DA339A_programmering1.Patterns.pacman/closedMouthD.png
        normalImage = new ImageIcon(this.getClass().getResource("/DA339A_programmering1/Patterns/pacman/ghostNormal.jpg"));
        scaredImage = new ImageIcon(this.getClass().getResource("/DA339A_programmering1/Patterns/pacman/ghostScared.jpg"));
    }                                

    /**
     * Move and redraw.
     **/
     
    public void move(boolean pacmanIsStrong, SquareItem pacmanpos)
    {
        //figure out which direction to go to catch Pacman
        // use packmanpos...
        
        int direction = position.getDirectionToSquare(pacmanpos);
        if (scared) {
            position.eraseMe(scaredImage);   // hide correct image
         }
         else {
            position.eraseMe(normalImage);   // hide correct image
         }
        
        scared = pacmanIsStrong;
        SquareItem oldposition = position;
        position = position.newPosition(direction, this); //move, if allowed
        while (position == oldposition) {
           direction += 1;
           if (direction == 41) { direction = 37; }           //try to the right
           position = position.newPosition(direction, this); //try another direction
        } //OK, I moved..
        PacOrGhost s = position.getSomeoneAtPos();    //is someone there?
        if (s != null) {
            if (!scared) {                           //Yes, and I can eat him!
                s.kill();
            }
            else {
                this.kill();                        //Too bad, I die  
                if (scared) {
                    position.eraseMe(scaredImage);   // hide correct image
                 }
                 else {
                    position.eraseMe(normalImage);   // hide correct image
                 }
            }
        }
        position.setSomeoneAtPos (this);            //I moved here
        oldposition.setSomeoneAtPos(null);          //I am not there anymore
        
        if (scared) {
           position.drawMe(scaredImage);   // draw at new position
        }
        else {
           position.drawMe(normalImage);   // draw at new position
        }
     }    

    
    public void setDirection(int dir)
    {
        direction = dir;        
    }
   
    
    public void kill()
    {
       dead = true;        
    }
    
     public boolean isDead()
    {
       return dead;       
    }
}
