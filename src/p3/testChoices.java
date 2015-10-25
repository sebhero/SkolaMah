/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package p3;

/**
 * Created by Sebastian Börebäck on 2015-10-25.
 */
public class testChoices {
    public static void main(String[] args) {
        int human = 0;
        int[] cpu = {0,1,2};

        for(int item : cpu)
        {
            System.out.println("diff: " +(item-human));
        }
        // 0   -1 -2
        // 1    0 -1
        // 2    1  0

        // 0 lika
        // -1 och 2 vann

    }
}
