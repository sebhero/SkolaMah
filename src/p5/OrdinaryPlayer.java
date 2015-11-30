/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package p5;

import java.util.Random;

/**
 * Created by Sebastian Börebäck on 2015-11-29.
 */
public class OrdinaryPlayer extends Player{

    private Dice dice;


    public OrdinaryPlayer(String name) {
        super(name);
        dice = new SimpleDice(6);
    }

    public OrdinaryPlayer(String name, Dice dice) {
        super(name);
        this.dice = dice;
    }

    @Override
    public int throwDice() {
        return dice.throwDice();
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }
}
