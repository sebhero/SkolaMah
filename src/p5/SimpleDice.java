/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package p5;

import java.util.Random;

/**
 * Created by Sebastian Börebäck on 2015-11-29.
 */
public class SimpleDice implements Dice {

    int sides;
    Random rnd = new Random();

    public SimpleDice() {
        sides = 6;
    }

    public SimpleDice(int sides) {
        if (sides <= 0) {
            throw new NegativeSidesException("Need to have atleast 1 side");
        }
        this.sides = sides;
    }


    @Override
    public int throwDice() {
        return rnd.nextInt(sides) + 1;
    }

    @Override
    public int getSides() {
        return sides;
    }
}
