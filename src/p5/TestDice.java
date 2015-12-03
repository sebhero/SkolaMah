/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package p5;

import java.text.MessageFormat;

/**
 * Created by Sebastian Börebäck on 2015-11-29.
 */
public class TestDice {


    /**
     * Test the die
     * @param dice the die
     * @param nbrOfThrows the number of throws
     */
    public static void test(Dice dice, int nbrOfThrows) {
        System.out.println("Test die\n");
        int[] res = new int[dice.getSides()];

        for (int i = 0; i < nbrOfThrows; i++) {
            //increases the amount of times the number has occured.
            res[dice.throwDice()-1]++;
        }
        for (int i = 0; i < res.length; i++) {
            TextWindow.println(MessageFormat.format("{0}\t{1}",i+1,res[i]));
        }


    }

    /**
     * Test cheater and player.
     * @param player the player
     * @param nbrOfThrows number of throws.
     */
    public static void test( Player player, int nbrOfThrows ) {
        if (player instanceof OrdinaryPlayer) {
            OrdinaryPlayer thePlayer = (OrdinaryPlayer) player;
            test(thePlayer.getDice(), nbrOfThrows);
        }
        else if (player instanceof Cheater) {


            Cheater theCheater = (Cheater) player;
            int[] res = new int[theCheater.getDice().getSides()];
            System.out.println(theCheater.getName());

            //Cant use this becuase then the player cant cheat.
            //test(theCheater.getDice(), nbrOfThrows);

            for (int i = 0; i < nbrOfThrows; i++) {
                //increase the value that is thrown.
                //att the position in the array.
                res[theCheater.throwDice()-1]++;
            }
            for (int i = 0; i < res.length; i++) {
                TextWindow.println(MessageFormat.format("{0}\t{1}",i+1,res[i]));
            }
        }
    }

    public static void main(String[] args) {
//        TestDice.test( new SimpleDice( 6 ), 1_000_000 );
//        //TextWindow.println();
//        System.out.println();
//        TestDice.test( new SimpleDice( 4 ), 1_000_000 );

        TextWindow.println("OrdinaryPlayer Rut");
        TestDice.test( new OrdinaryPlayer( "Rut", new SimpleDice( 6 ) ), 1000000 );
        TextWindow.println();
        TextWindow.println("Cheater Fuffe");
        TestDice.test( new Cheater( "Fuffe", new SimpleDice( 6 ) ), 1000000 );
    }
}
