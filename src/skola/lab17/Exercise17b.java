/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab17;

/**
 * Created by Sebastian Börebäck on 2015-10-27.
 */
public class Exercise17b {

    public void greaterThan8( double[] array ) {
// Komplettera med kod
        for (double item : array) {
            if(item > 8)
            {
                System.out.print(item + " ");
            }
        }
        System.out.println();
    }
    public void negativeNumbers( double[] array ) {
        for (double item : array) {
            if(item < 0)
            {
                System.out.print(item + " ");
            }
        }
        System.out.println();
    }
    public void reverse( double[] array ) {

        for (int i = array.length-1; i >= 0; i--) {
            System.out.print(array[i]+ " ");
        }
        System.out.println();

    }
    public void everyThirdReverse( double[] array ) {

        for (int i = array.length-1; i >= 0; i=i-3) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public void action() {
// double[] numbers={ 23.2, 14.7, 17.0, -5.9, -11.1, 26.3, 8.3, 7.6 };
        double[] numbers = { -1, 2, 5, 8, 11, 14, 10, 6, 2, -4 };
        greaterThan8(numbers);
        negativeNumbers(numbers);
        reverse(numbers);
        everyThirdReverse(numbers);
    }
    public static void main( String[] args ) {
        Exercise17b e17b = new Exercise17b();
        e17b.action();
    }
}


