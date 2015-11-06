/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package TileGame;

/**
 * Created by Sebastian Börebäck on 2015-11-06.
 */

import TileGame.display.Display;

/**
 * Starts the game
 */
public class Launcher {

    public static void main(String[] args) {
//        new Display("Title",300,300);
        Game theGame = new Game("Tile Game", 640, 360);
        theGame.start();


    }

}
