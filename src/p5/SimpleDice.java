package p5;

import java.util.Random;

/**
 * A simple 6 sided dice
 * @author Sebastian Börebäck
 * Copyright (c) 2015.
  */
public class SimpleDice implements Dice {

    int sides;
    Random rnd = new Random();

    /**
     * A simple 6 sided dice
     */
    public SimpleDice() {
        sides = 6;
    }

    /**
     * A simple die
     * @param sides how many sides of the die
     */
    public SimpleDice(int sides) {
        if (sides <= 0) {
            throw new NegativeSidesException("Need to have atleast 1 side");
        }
        this.sides = sides;
    }


    @Override
    public int throwDice() {
        //Returns a random value which represents the dice rolle.
        return rnd.nextInt(sides) + 1;
    }

    @Override
    public int getSides() {
        //Returns the sides
        return sides;
    }
}
