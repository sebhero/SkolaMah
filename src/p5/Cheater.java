/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package p5;

/**
 * Created by Sebastian Börebäck on 2015-11-29.
 */
public class Cheater extends Player{
    private Dice dice;
    private boolean doCheat = true;
    int cheatedTimes = 0;

    public Cheater(String name, Dice dice) {
        super(name);
        this.dice = dice;

    }

    public Cheater(String name) {
        super(name);
        dice = new SimpleDice();

    }

    @Override
    public int throwDice() {
        int res = dice.throwDice();
        //cheat if can
        if (res < dice.getSides() && doCheat) {
            res++;
            doCheat=false;

        }
        else {
            //next time cheat
            doCheat =true;
        }
        return res;
    }

    public void setDice(SimpleDice dice) {
        this.dice = dice;
    }

    public Dice getDice() {
        return dice;
    }

    public static void main(String[] args) {
        Player spelare1 = new OrdinaryPlayer( "Viktor",new SimpleDice( 6 ) );
        Player spelare2 = new Cheater( "Signe", new SimpleDice( 6 ) );
        Game spel = new Game( spelare1, spelare2 );
        TextWindow.println( "\nResultatet av tio spel" );
        for( int i=0; i<10; i++ )
            spel.play( false );
    }
}
