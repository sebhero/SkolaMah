/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package arrays;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Sebastian Börebäck on 2015-11-08.
 */

////the hole class can be replaced with this code.
//IntSummaryStatistics stats = values.stream()
//        .mapToInt((x) -> x)
//        .summaryStatistics();
//        System.out.println(stats);
//TODO read more about stats
//http://docs.oracle.com/javase/8/docs/api/java/util/IntSummaryStatistics.html
//https://dzone.com/articles/jdk-8-summarystatistics

/**
 * A helper class for Int arrays
 */
public class IntegerArrays {

    private static final boolean ASCENDING = true;
    private static final boolean DESCENDING = false;

    /**
     * Gets the biggest number in the array
     * @param theArray the int array
     * @return the biggest int
     */
    public static int max(int[] theArray) {

        int biggest = theArray[0];

        //loop through array and find biggest.


        for (int number : theArray) {
            //check which is the biggest
            // current biggest or the new number
            biggest = Math.max(number, biggest);
        }

        return biggest;

    }

    /**
     * Creates a String of the array
     * @param theArray the int array
     * @return a string of the array
     */
    public static String toString(int[] theArray) {
        String str = "{";

        for (int i = 0; i < theArray.length; i++) {
            str+=theArray[i];
            //adds a comma after every number except the last one
            if(i+1 < theArray.length) {
                str += ",";
            }
        }
        str += "}";
        return str;
    }

    /**
     * Gets the smallest number in the array.
     * @param theArray the int array
     * @return the smallest int in the array
     */
    public static int min(int[] theArray) {

        //sets a starting value is used if use the alternative code.
        int smallest = theArray[0];

        for (int number : theArray) {
            //check if new number is smaller than current smallest
            smallest= Math.min(number, smallest);
        }
        return smallest;

    }

    /**
     * Sums the numbers in the array
     * @param theArray the int array
     * @return a int sum
     */
    public static int sum(int[] theArray) {

        int sum = 0;

        for (int number : theArray) {
            sum += number;
        }
        return sum;

    }

    /**
     * Calculates the avarege of the array
     * @param theArray the int array
     * @return a double average
     */
    public static double average(int[] theArray) {

        double sum = IntegerArrays.sum(theArray);
        //total amount diveded by all the numbers in the list
        return  sum / theArray.length;
    }

    /**
     * Calculate the range between min and max
     * @param theArray the array
     * @return the range.
     */
    public static int range(int[] theArray) {

        int min = IntegerArrays.min(theArray);
        int max = IntegerArrays.max(theArray);
        return max - min;

    }

    /**
     * Creates a copy of the array
     * @param theArray the array
     * @return a clone of the array
     */
    public static int[] copy(int[] theArray) {

        return  theArray.clone();
    }

    /**
     * Sorts the array in ascending order
     * @param theArray the input array
     */
    public static void sortAsc(int[] theArray) {
        //alt solution
//        Arrays.sort(theArray);

        //Alt would be to use a Enum
        boolean order = ASCENDING;
        sortingOrder(theArray,order);

    }

    /**
     * Sorts the array in descending order
     * @param theArray the array that needs to be sorted.
     */
    public static void sortDesc(int[] theArray) {


        //Alt would be to use a Enum
        boolean order = DESCENDING;
        sortingOrder(theArray,order);

    }


    /**
     * Sorts the array in order that is sent to the sortingOrder
     * @param theArray the array to sort
     * @param order in which order to sort.
     */
    private static void sortingOrder(int[] theArray, boolean order) {
        int len = theArray.length;
        int temp = 0;

        //using bubblesort Algorithm
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < (len-i); j++) {

                //check if current number is bigger/smaller than last
                //depending on sorting order.
                if (theArray[j - 1] > theArray[j] == order) {
                    //switch position
                    temp = theArray[j - 1];
                    theArray[j - 1] = theArray[j];
                    theArray[j] = temp;
                }

            }
        }
    }
}
