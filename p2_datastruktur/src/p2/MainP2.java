/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package p2;

import p2.model.roffe.Position;
import p2.presenter.P2Controller;

import javax.swing.*;

public class MainP2 {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Position mapLeftUp = new Position(12.527, 56.346);
				Position mapRightDown = new Position(14.596, 55.324); 
				new P2Controller("files/skane.jpg", mapLeftUp, mapRightDown,
						         "files/places.txt","files/roads.txt");
			}
		});
	}
}
