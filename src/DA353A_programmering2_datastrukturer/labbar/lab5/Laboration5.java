/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab5;

import java.util.Arrays;

public class Laboration5 {
    public void reverse(Double[] array) {
        DoubleStack dst = new DoubleStack(array.length);
	    for (Double element : array) {
		    dst.push(element);
	    }
	    for (int i = 0; i < array.length; i++) {
		    array[i] = dst.pop();
	    }
    }
    
    public void descending(Double[] array) {
	    Arrays.sort(array);
	    reverse(array);
    }
    
    public void uppgift5() {
        Double[] arr = {new Double(5),new Double(14),new Double(12),new Double(9),
        		        new Double(3),new Double(7),new Double(5),new Double(12)};
        reverse( arr );
        for(Double d : arr) {
            System.out.print(d+" ");
        }
    }
    
    public void uppgift6() {
        Double[] arr = {new Double(5),new Double(14),new Double(12),new Double(9),
		                new Double(3),new Double(7),new Double(5),new Double(12)};
        descending( arr );
        for(Double d : arr) {
            System.out.print(d+" ");
        }
    }
    
    public static void main(String[] args) {
        Laboration5 lab6 = new Laboration5();
        lab6.uppgift5();
	    System.out.println();
	    lab6.uppgift6();
    }
}
