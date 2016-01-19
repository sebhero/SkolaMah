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
public class Exercise18e {

        public void program() {
//            Population[] countries = Populations.readPopulations(
//                    "filer/befolkning.txt" );
            URL filePath = Populations.class.getClassLoader().getResource("DA339A_programmering1/Patterns/skola/lab18/befolkning.txt");
            Population[] countries= Populations.readPopulations( filePath.getPath());

            Arrays.sort(countries);
            for( int i = 0; i < countries.length; i++ ) {
                System.out.println(countries[ i ].toString() );
            }
        }
        public static void main( String[] args ) {
            Exercise18e e18e = new Exercise18e();
            e18e.program();
        }

}
