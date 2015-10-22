/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package p3;

import java.util.Random;

/**
 * Created by Sebastian Börebäck on 2015-10-21.
 */
public class SSPController {

    private SSPViewer viewer;
    private SSPPlayer computerPlayer;
    private Random rnd = new Random();

    public SSPController(SSPPlayer player, SSPViewer viewer) {
        this.computerPlayer = player;
        this.viewer = viewer;
    }

    public void newGame() {

    }

    public void finish() {

    }

    public theChoice newChoice() {

        return theChoice.values()[rnd.nextInt(3)];

    }

}

