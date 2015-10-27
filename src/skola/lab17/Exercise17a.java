/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab17;

import com.sun.deploy.util.ArrayUtil;
import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Sebastian Börebäck on 2015-10-27.
 */
public class Exercise17a {

    public void action() {
        double[] numbers = { 23.2, 14.7, 17.0, -5.9, -11.1, 26.3, 8.3, 7.6 };
//  double[] numbers = { -1, 2, 5, 8, 11, 14, 10, 6, 2, -4 };
        int counter=0;
        double sum=0;
        String res;
// Komplettera med kod
        System.out.println("Antal element = "+numbers.length);
        for(double item : numbers)
        {
            sum += item;
        }
        System.out.println("Talens summa ar "+sum);

        System.out.println("Skriv ut alla tal storre an 8");
        for (double item : numbers) {
            if (item > 8) {
                System.out.print(item+" ");
                counter++;
            }
        }
        System.out.println();
        System.out.println("Antal tal storre an 8: "+counter);

        System.out.println("Skriv ut alla tal minde an noll");

        sum = 0;

        for (double item : numbers) {
            if (item < 0) {
                System.out.print(item+" ");
                sum+=item;
            }
        }
        System.out.println();
        System.out.println("Summan av de negativa talen "+sum);

        System.out.println("Reverse list");
        List<Double> theList = Arrays.stream(numbers).boxed().collect(Collectors.toList());

        Collections.reverse(theList);

        theList.forEach(item -> System.out.print(item+" "));
        //alt
        System.out.println();
        System.out.println("Reverse list v2");
        for (int i = numbers.length-1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }

        System.out.println();
        System.out.println("skriv ut vart 3:e tal med start fran slutet");

        for (int i = numbers.length-1; i >= 0; i=i-3) {
            System.out.print(numbers[i] + " ");
        }

        System.out.println();
        System.out.println("skriv ut med forenklad for loop");
        Collections.reverse(theList);
        theList.forEach(item -> System.out.print(item + " "));

        System.out.println();

        System.out.println("Skriv ut med forenklad for loop alla over 8");
        theList.stream().filter(item -> item > 8 ).
                forEach(item -> System.out.print(item+" "));
        System.out.println();






    }
    public static void main( String[] args ) {
        Exercise17a e17a = new Exercise17a();
        e17a.action();
    }
}
