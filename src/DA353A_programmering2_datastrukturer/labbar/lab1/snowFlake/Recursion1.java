/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab1.snowFlake;

public class Recursion1 {

    public void print(int n) {
        if (n > 0) {
            System.out.println(n);
            print(n - 1);
        }
    }

    public void neverStop(int tal) {
        System.out.println(tal);
        neverStop(tal + 1);
    }

    public void fill(char chr, int n) {
        if (n > 0) {
            System.out.print(chr);
            fill(chr, n - 1);
        }
    }

    public void print(String str, int pos) {
        if ((pos >= 0) && (pos < str.length())) {
            System.out.print(str.charAt(pos));
            print(str, pos + 1);
        }
    }

    public void positive(int[] array, int pos) {
        if (pos >= 0 && pos < array.length) {
            if (array[pos] > 0) {
                System.out.print(array[pos] + " ");
            }
            positive(array, pos + 1);
        }
    }

    public static void main(String[] args) {
        Recursion1 rec1 = new Recursion1();
//        rec1.printInOrder(5);
//        rec1.neverStop(23);
//        rec1.fill('-', 60);
//        rec1.printInOrder("Hej student", 0);
//        rec1.printInOrder("Hej student", 5);
//        rec1.positive(new int[]{4, 7, -3, 5, -2, 8, 6, 5, -7}, 0);
    }
}
