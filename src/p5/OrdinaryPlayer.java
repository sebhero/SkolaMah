package p5;

import java.util.Random;

/**
 * Ordinary player for the dice game
 * @author Sebastian Börebäck
 * Copyright (c) 2015.
 */
public class OrdinaryPlayer extends Player{

    private Dice dice;


    /**
     * Ordinary player for the dice game
     * @param name the players name
     * uses a @SimpleDice with 6 sides
     */
    public OrdinaryPlayer(String name) {
        super(name);
        dice = new SimpleDice(6);
    }

    /**
     * Ordinary player for the dice game
     * @param name the players name
     * @param dice the die that the players uses
     */
    public OrdinaryPlayer(String name, Dice dice) {
        super(name);
        this.dice = dice;
    }

    /**
     * Players throws the die
     * @return the result of the dice throw.
     */
    @Override
    public int throwDice() {
        return dice.throwDice();
    }

    /**
     * returns the players die
     * @return the die the player is using
     */
    public Dice getDice() {
        return dice;
    }

    /**
     * Sets the which die the player is using
     * @param dice the die to use
     */
    public void setDice(Dice dice) {
        this.dice = dice;
    }
}
