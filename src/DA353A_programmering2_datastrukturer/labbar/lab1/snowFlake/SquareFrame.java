/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab1.snowFlake;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SquareFrame {
	private JButton btnStart = new JButton("Starta");
	private Square square;
	private SquareSearch controller;
	
    public SquareFrame(int rows, int cols) {
    	this(rows,cols,new int[rows][cols]);
    }
    
    public SquareFrame(int rows, int cols, int[][] values) {
    	try {
    		SwingUtilities.invokeAndWait(new Runnable(){
    			public void run() {
    				init(rows, cols, values);
    			}
    		});
    	} catch(Exception e) {}
    }
    
    private void init(int rows, int cols, int[][] values) {
    	JFrame frame = new JFrame();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	square = new Square(rows,cols);
    	btnStart.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			controller.start();
    		}
    	});
    	frame.add(square,BorderLayout.CENTER);
    	frame.add(btnStart,BorderLayout.SOUTH);
    	frame.pack();
    	frame.setVisible(true);
    }
    public void setController(SquareSearch controller) {
    	this.controller = controller;
    }
    
    public Square getSquare() {
    	return this.square;
    }
    
	public void enableStart(boolean enabled) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				btnStart.setEnabled(enabled);
			}
		});
	}

}
