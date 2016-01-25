package DA339A_programmering1.p4.src.DA339A_programmering1.Patterns.arrays;/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */



/**
 * Created by Sebastian Börebäck on 2015-11-08.
 */

/**
 * A helper class for Matrix or 2d Arrays
 * help out with the basic things like, min max m.m.
 */
public class Integer2dArrays {


    /**
     * Converts the Matrix to a string
     * @param array the int matrix
     * @return a string of the matrix
     */
    public static String toString(int[][] array) {

        String str = "{";

        //loops through the rows and converts them to strings
        for (int i = 0; i < array.length; i++) {

            str += IntegerArrays.toString(array[i]);
            if(i+1 < array.length) {
                str += ",";
            }
        }
        str += "}";

        return str;

    }

    /**
     * Calculates how many elements there are in the Matrix
     * @param array the int matrix
     * @return a int count value of how many elements
     */
    public static int elements(int[][] array) {

        int count = 0;

        for (int[] row : array) {
            count += row.length;
        }
        return count;

    }

    /**
     * Get the biggest value in the matrix
     * @param array the int matrix
     * @return a int of the biggest value
     */
    public static int max(int[][] array) {

        //biggest value
        int biggest = 0;
        //the rows biggest value
        int rowBiggest;

        for (int[] row : array) {
            //get the rows biggest value
            rowBiggest = IntegerArrays.max(row);
            //check if its the biggest value in the matrix
            if (rowBiggest > biggest) {
                biggest = rowBiggest;
            }
        }

        return biggest;
    }

    /**
     * Gets the smallest value in the matrix
     * @param array the int matrix
     * @return a int of the smallest value
     */
    public static int min(int[][] array) {

        //smallest value, sets it to the first value in the matrix
        int smallest = array[0][0];

        //the rows smallest number
        int rowSmallest;

        for (int[] row : array) {
            //get the smallest value in the row
            rowSmallest = IntegerArrays.min(row);

            //check if its the smallest value in the matrix
            if (rowSmallest < smallest) {
                smallest = rowSmallest;
            }
        }

        return smallest;


    }

    /**
     * Sums the values in the matrix
     * @param array the int matrix
     * @return a int of the sum of all the values
     */
    public static int sum(int[][] array) {

        int sum = 0;

        for (int[] row : array) {
            sum += IntegerArrays.sum(row);
        }

        return sum;
    }

    /**
     * Calculates the average of all the values in the matrix
     * @param array the int matrix
     * @return double of the average.
     */
    public static double average(int[][] array) {

        //get the sum
        double sum = sum(array);
        //get the elements
        double elm = elements(array);

        return (sum / elm);

    }
}
