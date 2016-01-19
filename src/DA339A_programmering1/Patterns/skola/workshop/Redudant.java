/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.workshop;

/**
 * Created by seb on 2015-11-19.
 */
public class Redudant {



    public static void main(String[] args) {

        int[] rawData = {1,2,0,0,0,0,3,4,0,5,6,0};


        int len = rawData.length;
        int temp = 0;



        //using bubblesort Algorithm
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < (len-i); j++) {

                //check if current number is bigger/smaller than last
                //depending on sorting order.
                //if (rawData[j - 1] < rawData[j]) {
                if(rawData[j] > 0) {
                    //if (rawData[j - 1] < rawData[j]) {
                        //switch position
                        temp = rawData[j - 1];
                        rawData[j - 1] = rawData[j];
                        rawData[j] = temp;
                    //}
                }

            }
        }

        //rawData =new int[6];

        for (int data : rawData) {
            System.out.println(data);
        }

    }
}
