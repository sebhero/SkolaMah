/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab1.snowFlake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Square extends JPanel{
	private LinkedList<Runnable> buffer = new LinkedList<Runnable>();
    private JLabel[][] squares;  // representerar de olik rutorna i kvadraten 
    private int[][] values;      // värdena som visas i rutorna
    private Font font = new Font("SansSerif", Font.BOLD, 18);  // typsnitt i rutorna
    private int cols,  rows;  // antal kol, antal rader
    
    public static void pause(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
        }
    }
    
    private void setUp() {
    	Dimension squareDim = new Dimension(50,50);
    	setLayout(new GridLayout(rows, cols, 5, 5));
    	setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    	values = new int[rows][cols];
    	squares = new JLabel[rows][cols];
    	for (int row = 0; row < rows; row++) {
    		for (int col = 0; col < cols; col++) {
    			squares[row][col] = new JLabel(" ", JLabel.CENTER);
    			squares[row][col].setOpaque(true);
    			squares[row][col].setBackground(Color.BLACK);
    			squares[row][col].setForeground(Color.WHITE);
    			squares[row][col].setFont(font);
    			squares[row][col].setPreferredSize(squareDim);
    			add(squares[row][col]);
    		}
    	}
    }

    public Square(int rows, int cols) {
        this.cols = cols;
        this.rows = rows;
        setUp();
    }
    
    public void setValues(int[][] values) {
    	for (int row = 0; row < rows; row++) {
    		for (int col = 0; col < cols; col++) {
    			this.values[row][col] = values[row][col];
    		}
    	}
    	buffer.addLast(new Runnable() {
    		public void run() {
    	    	for(int row=0; row<rows; row++) {
    	    		for(int col=0; col<cols; col++) {
    	    			squares[row][col].setText(String.valueOf(values[row][col]));
    	    		}
    	    	}
    		}
    	});
    	repaint();
    }
    
    public void unmarkSquare() {
    	buffer.addLast(new Runnable() {
    		public void run() {
    	    	for(JLabel[] labels : squares ) {
    	    		for(JLabel label : labels) {
    	    			label.setBackground(Color.BLACK);
    	    		}
    	    	}
    		}
    	});
    	repaint();
    }
    
    public boolean validRow(int row) {
    	return (row>=0) && (row<rows);
    }
    
    public boolean validCol(int col) {
    	return (col>=0) && (col<cols);
    }
    
	public void mark(int row, int col) {
		buffer.addLast(new Runnable() {
			public void run() {
				squares[row][col].setBackground(Color.RED);
			}
		});
		repaint();
	}
	
	public void unmark(int row, int col) {
		buffer.addLast(new Runnable() {
			public void run() {
				squares[row][col].setBackground(Color.BLACK);
			}
		});
		repaint();
	}
	
	public void setValue(int row, int col, int value) {
		buffer.addLast(new Runnable() {
			public void run() {
				squares[row][col].setText(String.valueOf(values[row][col]));
			}
		});
		values[row][col] = value;
		repaint();
	}
	
	public int getValue(int row, int col) {
		return values[row][col];
	}
	
	public int getRows() {
		return values.length;
	}
	
	public int getCols() {
		return values[0].length;
	}
	
	protected void paintComponent(Graphics g) {
		while(buffer.size()>0) {
			buffer.removeFirst().run();
		}
	}
}
