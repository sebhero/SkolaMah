/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

    /**
     * Gets the biggest number in the array
     * @param theArray the int array
     * @return the biggest int
     */
    public static int max(int[] theArray) {

        int biggest = theArray[0];

        //Converts the array to a list
        List<Integer> values = Arrays.stream(theArray).boxed().collect(Collectors.toList());

        //get the biggest by streaming the list and using min which gets the min value by using the Integer Comparator.comparing().
        //which means it will loop through the array and compare all the values for the biggest values
        biggest= values.stream().max(Integer::compare).get();

//        //Alternative code does the samething
//        for (int number : theArray) {
//
//            if (biggest < number) {
//                biggest = number;
//            }
//        }

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

        //Converts the array to a list
        List<Integer> values = Arrays.stream(theArray).boxed().collect(Collectors.toList());

        Collections.min(values);

        //get the smallest by streaming the list and using min which gets the min value by using the Integer Comparator.comparing().
        //which means it will loop through the array and compare all the values for the smallest values
        smallest = values.stream().min(Integer::compare).get();

        ////Alternative code does the same thing.
//        for (int number : theArray) {
//
//            if (smallest > number) {
//                smallest = number;
//            }
//        }

        return smallest;

    }

    /**
     * Sums the numbers in the array
     * @param theArray the int array
     * @return a int sum
     */
    public static int sum(int[] theArray) {


        //Converts the array to a list
        List<Integer> values = Arrays.stream(theArray).boxed().collect(Collectors.toList());

        //Streams through all the values and using lambda sums them up.
        //result is current sum and currentElement is the current element that is being added
        //see javadocs for reduce for more info.
//        int sum = values.stream().reduce(0, (result, currentElement) -> result + currentElement);
        int sum = values.stream().reduce(0, Integer::sum);
        // sum = integers.reduce(0, Integer::sum);
        return sum;


        ////Alternative code does the same job.
//        int sum = 0;
//        for (int num : theArray) {
//            sum += num;
//        }
//        return sum;

    }

    /**
     * Calculates the avarege of the array
     * @param theArray the int array
     * @return a double average
     */
    public static double average(int[] theArray) {

        double answer;
        double sum = IntegerArrays.sum(theArray);
        answer = sum / theArray.length;

        return answer;

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
        Arrays.sort(theArray);
    }

    /**
     * Sorts the array in descending order
     * @param theArray the array that needs to be sorted.
     */
    public static void sortDesc(int[] theArray) {


        //convert the array with int to a list with Integer
        //boxed convert the int to an Integer. collectors.toList() converts the array to a list.
        List<Integer> thelist = Arrays.stream(theArray).boxed().collect(Collectors.toList());
        //sort it in reverse
        Collections.sort(thelist, Collections.reverseOrder());

        //since the List has Integer and not int anymore..
        for (int i = 0; i < theArray.length; i++) {
            theArray[i] = thelist.get(i);
        }

        ////ALT code
        ////using bubblesort Algorithm

//        int len = theArray.length;
//        int temp = 0;
//
//        for (int i = 0; i < len; i++) {
//            for (int j = 1; j < (len-i); j++) {
//
//                if (theArray[j - 1] < theArray[j]) {
//                    //switch position
//                    temp = theArray[j - 1];
//                    theArray[j - 1] = theArray[j];
//                    theArray[j] = temp;
//                }
//
//            }
//        }

    }
}
