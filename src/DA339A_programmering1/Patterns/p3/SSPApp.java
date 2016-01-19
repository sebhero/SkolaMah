/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.p3;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Created by Sebastian Börebäck on 2015-10-21.
 */

/**
 * Used to start the Sten sax pose game
 * 
 * @author xxborebs
 *
 */
public class SSPApp {

	public static void main(String[] args) {

		// create the object i need for the game
		SSPPlayer player = new SSPPlayer();
		SSPViewer viewer = new SSPViewer();
		SSPController controller = new SSPController(player, viewer);
		SSPUserInput userInput = new SSPUserInput(controller);

		// TestGui userInput = new TestGui(controller);

		JFrame frame1 = new JFrame("SSPViewer");
		frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame1.add(viewer);
		frame1.pack();
		frame1.setVisible(true);

		JFrame frame2 = new JFrame("SSPUserInput");
		frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// frame2.setContentPane(userInput.panel1);
		frame2.add(userInput);
		// set start position middle of the screen.
		frame2.setLocation(getMidlePosition(0, 0, frame2));
		frame2.pack();
		frame2.setVisible(true);

		// sets that fram1 viwer is directly above frame2
		// the x offset i center + frane2 width / 2 and Y offset is - frame1 height -frame2 height.
		// above frame2 height and above frame1 height is y start for frame2
		frame1.setLocation(getMidlePosition(frame2.getWidth() / 2, -(frame1.getHeight() - frame2.getHeight()), frame1));
	}

	/**
	 * Get middle position for the frame to be placed in center. with offsets
	 * 
	 * @param offX
	 *            x offset for the frame
	 * @param offY
	 *            y offset for the frame
	 * @param frame
	 *            the frame used
	 * @return a point where the frame should be placed
	 */
	private static Point getMidlePosition(int offX, int offY, JFrame frame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);

		return new Point(x + offX, y + offY);
	}

}
