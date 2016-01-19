/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.lab17;

/**
 * Created by Sebastian Börebäck on 2015-10-27.
 */
public class Exercise17f {

    public static void main(String[] args) {
        int[] array = { 12, 5, 8, 2, 3, 3,3,11,221,7 };

        //array = getNumbers();
        System.out.println("Print normal");
        printNumbers(array);
        System.out.println();
        System.out.println("Print second");
        printEverySecond(array);
        System.out.println();
        System.out.println("print revese");
        Exercise17d.reverse(array);

    }

    private static void printEverySecond(int[] array) {
        for (int i = 0; i < array.length; i+=2) {
            System.out.print(array[i]+" ");
        }

    }

    private static void printNumbers(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
    }
}
