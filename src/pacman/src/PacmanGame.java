/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package pacman.src;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.*;

/**
 * Class PacmanGame - 
*/
public class PacmanGame // implements KeyListener, ActionListener
{
   public PaintWindow canvas = new PaintWindow();
   private Pacman pacman;
   private JTextField typingArea;
   private JTextArea displayArea;  
   private boolean finished, started;
   private Random randomGenerator;
   private SquareItem pacmanpos;
   private ArrayList field, ghosts;
   private int noOfBlocks = 20;
   private int[] fielddata = { 5,12,12,12, 4,12,12, 4,12, 6,32, 5,12, 4,12,12, 4,12,12, 6,
                               3,32,32,32, 3,32,32, 3,32, 3,32, 3,32, 3,32,32, 3,32,32, 3,
                               3,32,32,32, 3,32,32, 1,12, 8,12, 8,12, 2,32,32, 3,32,32, 3,
                               1,12, 4,12, 2,32,32, 3,32,32,32,32,32, 3,32,32, 1,12, 4, 2,
                               3,32, 3,32, 3,32,32, 1,12, 6,32, 5,12, 2,32,32, 3,32, 1, 10,
                               3,32, 3,32, 3,32,32, 3,32, 3,32, 3,32, 3,32,32, 3,32, 3,32,
                               3,32, 3,32, 3,32,32, 3,32, 3,32, 3,32, 3,32,32, 3,32, 3,32,
                               9,12, 0,12, 2,32,32, 3,32, 1, 4, 2,32, 3,32,32, 3,32, 3,32,
                              32,32, 3,32, 1, 4, 4, 0, 4, 8, 0, 8, 4, 0,12, 4,10,32, 1,14,
                              32,32, 3,32, 1, 0, 0, 0, 2,32,11,32, 1,10,32, 3,32,32, 3,32,
                              13,12, 2,32, 1, 0, 0, 0, 2,32,32,32, 3,32,32, 1,12,12,10,32,
                              32,32, 3,32, 1, 0, 0, 8, 8,12,12,12, 8, 6,32, 3,32,32,32,32,
                              32,32, 3,32, 1, 0, 2,32,32,32,32,32,32, 3,32, 1, 6,32, 5,14,
                               5,12, 8,12, 8, 8, 0, 4, 6,32, 5,12,12, 8,12, 8, 2,32, 3,32,
                               3,32,32,32,32,32, 1, 0, 2,32, 3,32,32,32,32,32, 1,12, 2,32,
                               3,32, 5,12, 6,32, 1, 8,10,32, 9,12, 6,32, 5,12, 2,32,11,32,
                               3,32, 3,32, 3,32, 3,32,32,32,32,32, 3,32, 3,32, 3,32,32,32,
                               3,32, 3,32,11,32, 1,12, 6,32, 5,12,10,32, 9,12, 8,12,12, 6,
                               3,32, 3,32,32,32, 3,32, 3,32, 3,32,32,32,32,32,32,32,32, 3,
                               9,12, 8,12,12,12,10,32, 9,12, 8,12,12,12,12,12,12,12,12,10};
                               
   private int[] fielddata2 = {32,32,32,32,32, 5,12, 6,32, 7,32, 5,12, 6,32,32,32,32,32,32,
                               5,12,12,12,12,10,32, 9, 4, 8, 4,10,32, 9,12,12,12,12,12,06,
                               3,32,32,32,32,32,32,32, 3,32, 3,32,32,32,32,32,32,32,32, 3,
                               3,32, 5,12,12, 4,12, 4,10,32, 9, 4,12, 4,12,12,12, 6,32, 3,
                               3,32, 3,32,32, 3,32, 3,32,32,32, 3,32, 3,32,32,32, 3,32, 3,
                               3,32, 3,32, 5,10,32, 9, 6,32, 5,10,32, 9,12, 6,32, 3,32, 3,
                               3,32, 3,32, 3,32,32,32, 3,32, 3,32,32,32,32, 3,32, 3,32, 3,
                               3,32, 3,32, 9,12, 6,32, 3,32, 3,32, 5,12,12,10,32, 3,32, 3,
                               1,12, 2,32,32,32, 3,32, 3,32, 3,32, 3,32,32,32,32, 1,12, 2,
                               3,32, 3,32, 5,12,10,32, 3,32, 3,32, 9,12,12, 6,32, 3,32, 3,
                               3,32, 3,32, 3,32,32,32, 1,12,10,32,32,32,32, 3,32, 3,32, 3,
                               3,32, 3,32, 3,32,32,32, 3,32,32,32,32,32,32, 3,32, 3,32, 3,
                               3,32, 3,32, 9,12,12,12, 2,32, 5,12,12,12,12,10,32, 3,32, 3,
                               3,32, 3,32,32,32,32,32, 3,32, 3,32,32,32,32,32,32, 3,32, 3,
                               3,32, 1,12, 4, 6,32, 5, 8, 4, 0,12, 6,32, 5, 4,12, 2,32, 3,
                               3,32, 3,32, 1, 8,12, 2,32, 1, 2,32, 1,12, 8, 2,32, 3,32, 3,
                               3,32, 1,12, 2,32,32, 3,32, 1, 2,32, 3,32,32, 1,12, 2,32, 3,
                               3,32,11,32, 9, 4,12, 8,12, 8, 8,12, 8,12, 4,10,32,11,32, 3,
                               3,32,32,32,32, 3,32,32,32,32,32,32,32,32, 3,32,32,32,32, 3,
                               9,12,12,12,12, 8,12,12,12,12,12,12,12,12, 8,12,12,12,12,10};

    private int[] fielddata3 = {5,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,6,
                               1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,
                               1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,
                               1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,
                               1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,
                               1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,
                               1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,
                               1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,
                               1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,
                               1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,
                               1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,
                               1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,
                               1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,
                               1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,
                               1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,
                               1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,
                               1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,
                               1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,
                               1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,
                               9,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,10};

                            
    /**
     * Create a PacmanGame object. 
     *      */
    public PacmanGame()
    {
        //Create Canvas - contains the frame and Graphics

                
        //JMenuItem mi = canvas.getMenuItem(0);
       // mi.addActionListener(this);
        // create field
        randomGenerator = new Random ();
        int randomvalue; 
        field = new ArrayList();
        for (int i=0; i<noOfBlocks; i++) {
           for (int j=0; j<noOfBlocks; j++) {
              randomvalue = randomGenerator.nextInt (11);  //random 0..5 -temp to make packman strong - was 6
              field.add (
            		  new SquareItem (i,j,fielddata2[i*noOfBlocks+j], field, randomvalue, canvas)
            		    );
            }
        }

        //Draw initial field
        SquareItem item;
        Iterator it = field.iterator ();
        while (it.hasNext()) {
           item =  (SquareItem) it.next();
           item.draw();
        }
        pacmanpos = (SquareItem) field.get(10*noOfBlocks);
        pacman = new Pacman(pacmanpos);							//there is only ONE pacman
        ghosts = new ArrayList();								//there can be many ghosts
        started = true;//false;
        
        canvas.addMyKeyListener(new Input());					//
     }
    
   
    /**
     * Handle mouse clicks on Menu item...
     */
    public void actionPerformed(ActionEvent e) {        //start in menu
       started = true;									//temp solution before menus are fixed...
    }
       
	private class Input implements KeyListener {
		
		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			pacman.setDirection (keyCode);
			finished = keyCode == 81;   // q = 81
			started =  keyCode == 78;   // n = 78
        
			if (keyCode == e.VK_UP){
			
			}
			if (keyCode == e.VK_DOWN){
			
			}
			if (keyCode == e.VK_RIGHT){
			
			}
			if (keyCode == e.VK_LEFT){
			
			}
		}
	
		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
		}
	}
    
    /**
     * Play game
     */
    public void play()
    { 
        while(!started) {               //wait to start - attribute set by menu
        }
        finished =  false;
        boolean pacmanIsStrong;
        while(!finished) {
        	PaintWindow.pause(300);                     // small delay
            pacmanIsStrong = pacman.move();                     //Pacman moves first and may become "strong"
            if (!pacman.isDead()) {                     //did he die?
                if (randomGenerator.nextInt (100) == 0) {   // once in 100 loops, make new Ghost
                    ghosts.add(new Ghost((SquareItem) field.get(9*noOfBlocks+10)));
                }
                pacmanpos = pacman.getPos ();
                Ghost ghost;
                Iterator it = ghosts.iterator ();
                while (it.hasNext()) {
                    ghost =  (Ghost) it.next();
                    if (!ghost.isDead()) {
                        ghost.move(pacmanIsStrong, pacmanpos);	//ghosts are afraid if packman is strong
                    }
                }
            }
            else {
                finished = true;    //Pacman is dead!
            }
        }
    }
    
    private static void createAndRunGame() {
        PacmanGame p = new PacmanGame();
        p.play();
    } 
        
    
    public static void main(String[] args) {

       createAndRunGame();
    }
    
    
}
