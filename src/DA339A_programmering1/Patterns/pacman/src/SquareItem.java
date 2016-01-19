/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.pacman.src;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * Write a description of class SquareItem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class SquareItem
{
    // instance variables - replace the example below with your own
    private boolean wallToLeft;
    private boolean wallToRight;
    private boolean wallAbove;
    private boolean wallBelow;
    private PacOrGhost someone;	// link to object in this square
    private int row;            //position in game field
    private int col;			//position in game field
    private int pill;
    private boolean fill;
    private ArrayList field;	//link back to field - to find other squares
    private PaintWindow canvas;	//link to window - to draw
     
    final int blocksize=20;
            
    /**
     * Constructor for objects of class SquareItem
     * param walls uses bits to define walls: 
     *      bit 1 (weight 1) = walltoleft
     *      bit 2 (weight 2) = walltoright
     *      bit 3 (weight 4) = wallabove
     *      bit 4 (weight 8) = wallbelow
     */
    public SquareItem(int row, int col, int walls, ArrayList field, int p, PaintWindow canvas)
    {
        // initialise instance variables
        this.field = field;
        this.canvas = canvas;
        someone = null;
        wallToLeft  = ((walls & 1) != 0);
        wallToRight = ((walls & 2) != 0);
        wallAbove   = ((walls & 4) != 0);
        wallBelow   = ((walls & 8) != 0);
        this.row = row;
        this.col = col;
        fill        = ((walls & 32) != 0);
        pill = 0;
        if ((walls & 32) == 0) {
            pill = p;                   //all places that are not filled get pills
        }
    }

    /**
	 * draw at startup
     */
    public void draw()
    {
      //canvas.setForegroundColor(Color.black);
      if (wallToLeft)  {canvas.line (col * blocksize, row * blocksize, col * blocksize, row * blocksize + blocksize, Color.BLACK, 1);}
      if (wallToRight) {canvas.line (col * blocksize+blocksize, row * blocksize, col * blocksize + blocksize, row * blocksize + blocksize, Color.BLACK, 1);}
      if (wallAbove)   {canvas.line (col * blocksize, row * blocksize, col * blocksize + blocksize, row * blocksize, Color.BLACK, 1);}
      if (wallBelow)   {canvas.line (col * blocksize, row * blocksize + blocksize, col * blocksize + blocksize, row * blocksize + blocksize, Color.BLACK, 1);}
      if (pill > 0) {
         //canvas.setForegroundColor(Color.yellow);
       canvas.fillOval(col * blocksize+blocksize/2, row * blocksize+blocksize/2, pill, pill, Color.YELLOW); //pill value reflected in size
      }
      if (fill) {
         //canvas.setForegroundColor(Color.blue);
         canvas.fillRect(col * blocksize, row * blocksize, blocksize, blocksize, Color.BLACK);
      }
    }


    /**
     * Erase at its current position.
     **/
    public void eraseMe(ImageIcon img)
    {
        canvas.fillRect(col * blocksize, row * blocksize, blocksize, blocksize, Color.WHITE); //to remove pill
        canvas.hideImage(img);
        draw();
    }    
    
    /**
     * Draw image at its current position onto the canvas.
     **/
    public void drawMe(ImageIcon img)
    {
       canvas.showImage(img, col * blocksize+1, row * blocksize+1);			//Image or Icon???
    }
    
    
    /** 
     * Get a new position, if allowed.
     */
    
    public SquareItem newPosition(int direction, PacOrGhost s)
    {
        SquareItem newPos = this;
        // compute new position

        switch (direction) {
        case 37:  //Left
                    if (!wallToLeft) {
                        newPos = (SquareItem) field.get((row)*blocksize+col-1);
                    }
                    break;
        case 38:  // Up
                    if (!wallAbove) {
                        newPos = (SquareItem) field.get((row-1)*blocksize+col);
                     }
                    break;
        case 39:  //Right
                    if ((row == 12) && (col == 19)) {             //teleport!
                        newPos = (SquareItem) field.get((17)*blocksize+4);
                    } 
                    else
                    if (!wallToRight) {
                        newPos = (SquareItem) field.get((row)*blocksize+col+1);
                     }
                    break;
        case 40:  //Down  
                    if (!wallBelow) {
                        newPos = (SquareItem) field.get((row+1)*blocksize+col);
                     }
                    break;
        default:    break;
        }
        
        return newPos;
    }    


   /**
     * Consume pill if exists and return how much it was worth
     **/
    public int eatPill()
    {
        int p = pill;
        pill = 0;
        return p;
    }
    
    
    /**
     * Set that someone is in this square
     */
    
    public void setSomeoneAtPos(PacOrGhost s)
    {
        someone = s;
    }
    
    
    /**
     * Get who is in this square
     */
    
    public PacOrGhost getSomeoneAtPos()
    {
        return someone;
    }
    
    
    /**
     * Calculate the best direction to go to a specified square
     */
    
    public int getDirectionToSquare(SquareItem s)
    {
        int dir = 0;
        int destCol = s.getCol();
        int destRow = s.getRow();
        int vert = destRow - row;
        int hor = destCol - col;
        int absHor = hor;
        if (absHor < 0) {absHor = -hor; }
        int absVert = vert;
        if (absVert < 0) {absVert = -vert; }
        if (absVert > absHor)  {                //Go vertical  
           if (vert > 0) {
               dir = 40;                        //Go up
            } else {
               dir = 38;                        //Go down
            }
        } else {                                //Go horizontal
            if (hor > 0) {
                dir = 39;                       //Go right
            } else {
                dir = 37;                       //Go left
            }
        }
        return dir;
    }    
    
    
    
     /**
     * Get column in position
     */
    
    public int getCol()
    {
        return col;
    }
    
         /**
     * Get row in position
     */
    
    public int getRow()
    {
        return row;
    }
    
    public PaintWindow getCanvas() {
    	return canvas;
    }
}
