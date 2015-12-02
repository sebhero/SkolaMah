package p5;

/**
 * Dice game cheater. a player for dice game that cheats
 * @author Sebastian Börebäck
 * Copyright (c) 2015.
 */
public class Cheater extends Player{
    private Dice dice;
    private boolean doCheat = true;

    /**
     * Dice game cheater
     * @param name the name of the cheater
     * @param dice the type of dice that we will use
     */
    public Cheater(String name, Dice dice) {
        super(name);
        this.dice = dice;

    }

    /**
     * Dice game cheater
     * @param name the name of the cheater
     * this has a SimpleDice as dice
     */
    public Cheater(String name) {
        super(name);
        dice = new SimpleDice();

    }

    /**
     * Overrides the die Throw with a Cheating die throw.
     * If the player doesnt throws the highest value it will add 1 to the dice throw.
     * Only cheates 50% of the time
     * @return returns the cheated dice throw result
     */
    @Override
    public int throwDice() {
        int res = dice.throwDice();
        //cheat if can. if the result is less than max and didnt cheat last time
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

    /**
     * Set the dice that we will use
     * @param dice the Dice object
     */
    public void setDice(Dice dice) {
        this.dice = dice;
    }

    /**
     * Get the dice
     * @return The dice we are using
     */
    public Dice getDice() {
        return dice;
    }

    /**
     * Test main for testing the cheater with 2 players.
     * @param args
     */
    public static void main(String[] args) {
        Player spelare1 = new OrdinaryPlayer( "Viktor",new SimpleDice( 6 ) );
        Player spelare2 = new Cheater( "Signe", new SimpleDice( 6 ) );
        Game spel = new Game( spelare1, spelare2 );
        TextWindow.println( "\nResultatet av tio spel" );
        for( int i=0; i<10; i++ )
            spel.play( false );
    }
}
