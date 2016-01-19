/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.lab18;

import java.net.URL;
import java.util.Arrays;

/**
 * Created by Sebastian Börebäck on 2015-11-03.
 */
public class Exercise18f {

    public void program() {
        URL filePath = Populations.class.getClassLoader().getResource("DA339A_programmering1/Patterns/skola/lab18/befolkning.txt");
        Population[] countries= Populations.readPopulations( filePath.getPath());
        Arrays.sort(countries, new AlphabeticalOrder());
        for( int i = 0; i < countries.length; i++ ) {
            System.out.println(countries[ i ].toString() );
        }
    }
    public static void main( String[] args ) {
        Exercise18f e18f = new Exercise18f();
        e18f.program();
    }
}
