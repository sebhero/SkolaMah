/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.workshop;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Sebastian Börebäck on 2015-12-02.
 */
public class SorteraStrumpor {


    public static void main(String[] args) {
        Random rnd = new Random();
//        int[]  strumplista = new int[14];
        int[]  strumplista = {7,1,1,1,1,1,2,2,2,2,3,3,4,4};
        int[] sortedArr = new int[28];
        for (int i = 0; i < strumplista.length; i++) {
//            strumplista[i] = rnd.nextInt(7)+1;
        }



        int k =0;
        for (int i = 0; i < strumplista.length; i++) {
            for (int j = 1; j < strumplista.length; j++) {

                if (strumplista[i] == strumplista[j] && strumplista[j] != 0 && strumplista[i] !=0) {
                    System.out.println("I current strumpa: "+strumplista[i]);
                    System.out.println("J current strumpa: "+strumplista[j]);
                    k = strumplista[i];
                    sortedArr[k]++;

                    strumplista[i] =0;
                    strumplista[j] =0;
                }
            }
            strumplista[i] =0;
        }

        int antal =0;
        for (int i = 0; i < sortedArr.length; i++) {
            if(sortedArr[i] != 0)
            System.out.println(i+": antal= "+sortedArr[i]);
        }
        System.out.println(antal);

    }
}
