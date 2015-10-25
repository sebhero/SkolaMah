/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package p3;

import java.util.Random;

/**
 * Created by Sebastian Börebäck on 2015-10-21.
 */

/**
 * A cpu player for sten sax pose
 */
public class SSPPlayer {
    private Random rnd = new Random();


    public SSPPlayer() {
    }

    /**
     * Get a new choice from cpu player
     * @return a int repesenting the choice. 0-2 where
     * 0 = sten
     * 1 = sax
     * 2 = pose
     */
    public int newChoice()
    {
        return rnd.nextInt(3);
    }

}
