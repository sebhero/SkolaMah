/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package p5;

import p5.redovisa.p5.BadProbabilityException;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by Sebastian Börebäck on 2015-11-29.
 */
public class ProbabilityDice implements Dice {
    int[] probabilityArray;
    int sides;
    Random rnd = new Random();

    public ProbabilityDice(int[] probabilityArray) throws BadProbabilityException {
        this.probabilityArray = probabilityArray;
        sides = probabilityArray.length;

        //Streams through all the values and using lambda sums them up.
        //result is current sum and currentElement is the current element that is being added
        //see javadocs for reduce for more info.

        List<Integer> values = Arrays.stream(probabilityArray).boxed().collect(Collectors.toList());
        int sum = values.stream().reduce(0, Integer::sum);
        //check that the sum of probability is 100% else throw exception
        if (sum != 100) {
            throw new BadProbabilityException("Total of probability array must be 100% not: "+sum);
        }
    }

    /**
     * Returns a random by probablity die throw.
     * @return
     */
    @Override
    public int throwDice() {
        //generat a random die throw
        int randomProbablity = rnd.nextInt(100);

        //retun value
        int randomNumber = 1;
        //the sum of probability
        int sum =0;

        //goes throw the list of probabilty numbers
        for (int i = 0; i < probabilityArray.length; i++) {
            //sum the probablity
            sum += probabilityArray[i];
            //if the sum is same or greater than the randomProbabilty
            //and not a none number 0% probability
            //return it +1 because i starts at 0
            if(sum >=randomProbablity) {
                if (probabilityArray[i] == 0) {
                    continue;
                }
                randomNumber +=i;
                return randomNumber;

            }
        }
        //never used
        return randomNumber;
    }

    @Override
    public int getSides() {
        return sides;
    }

    public static void main(String[] args) {
        int[] prob = {5, 15, 20, 20, 20, 20};
        Player spelare1 = new Cheater("Viktor", new SimpleDice(6));
        Player spelare2 = new Cheater("Signe", new ProbabilityDice(prob));
        Game spel = new Game(spelare1, spelare2);
        TextWindow.println("\nResultatet av tio spel");
        for (int i = 0; i < 10; i++) {
            spel.play(false);
        }
    }
}
