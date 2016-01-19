/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab1.snowFlake;
import java.util.Random;

import javax.swing.SwingUtilities;

public class SquareSearch {
	private Random random = new Random();
	private Square square;
	private SquareFrame frame;
    private long delay;

    public SquareSearch(SquareFrame frame, long delay) {
    	this.frame = frame;
    	this.square = frame.getSquare();
    	frame.setController(this);
        this.delay = delay;	
    }
    
    public void cheapestWay(int fromRow, int fromCol, int toRow, int toCol) {
    	frame.enableStart(false);
    	SearchResult result = new SearchResult("",Integer.MAX_VALUE);
        cheapestWay(fromRow, fromCol, toRow, toCol, "", 0, result);
    	showPath(0,0,result.getPath());
        System.out.println("Billigaste väg: " + result.getCost());
        frame.enableStart(true);
    }

    private void cheapestWay(int row, int col, int stopRow, int stopCol, 
    		                 String path, int cost, SearchResult result) {
        if (square.validRow(row) && square.validCol(col)) {
        	cost += square.getValue(row, col);
        	square.mark(row,col);
            Square.pause(delay);
            if (row == stopRow && col == stopCol && cost < result.getCost()) {
            	result.setCost(cost);
            	result.setPath(path);
            } else {
                cheapestWay(row + 1, col, stopRow, stopCol, path + 'D', cost, result);
                cheapestWay(row, col + 1, stopRow, stopCol, path + 'R', cost, result);
            }
            square.unmark(row, col);
            Square.pause(delay / 2);
        }
    }
    
    private void setUpSquare() {
    	int rows = square.getRows();
    	int cols = square.getCols();
    	for(int row=0; row<rows; row++) {
    		for(int col=0; col<cols; col++) {
    			square.setValue(row,col,random.nextInt(10));
    			square.unmark(row, col);
    		}
    	}
    }
    
    public void start() {
    	setUpSquare();
    	new Thread(new Runnable() {
    		public void run() {
    	    	cheapestWay(0,0,square.getRows()-1,square.getCols()-1);
    		}
    	}).start();
    }
    
    public void showPath(int row, int col, String path) {
    	square.mark(row, col);
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'D') {
                row++;
            } else if (path.charAt(i) == 'R') {
                col++;
            } else if (path.charAt(i) == 'U') {
                row--;
            } else if (path.charAt(i) == 'L') {
                col--;
            }
        	square.mark(row, col);
        }
    }
    
    public static void main(String[] args) {
    	final int ROWS = 4;
    	final int COLS = 4;
    	SquareFrame frame = new SquareFrame(ROWS,COLS);
        SquareSearch search = new SquareSearch(frame, 50);
    	search.setUpSquare();
    	search.cheapestWay(0,0,ROWS-1,COLS-1);
    }
}    

class SearchResult {
	private String path;
	private int cost;
	
	public SearchResult(String path, int cost) {
		this.path = path;
		this.cost = cost;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
}

