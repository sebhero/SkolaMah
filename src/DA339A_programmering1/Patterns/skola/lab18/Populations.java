/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.lab18;
import java.net.URL;
import java.util.*;
import java.io.*;

/**
 * Metoden readPopultaions läser in ett antal länder och deras invånareantal i objekt av
 * typen Population. Popultation-objekten returneras i en Popultation-array.
 * @author Rolf
 */
public class Populations {
    private static Population[] read( String filename ) throws IOException {
        ArrayList population = new ArrayList();
        BufferedReader br = new BufferedReader( new InputStreamReader( new FileInputStream( filename ), "ISO-8859-1" ) );
        String input;
        String[] data;
        
        while( ( input = br.readLine() ) != null ) {
            data = input.split( "," );
            population.add( new Population( data[1], Long.parseLong( data[2].replaceAll(" ","") ) ) );
        }
        return ( Population[] )population.toArray( new Population[]{} );
    }
    
    public static Population[] readPopulations( String filename ) {
        Population[] populations = {};
        try {
            populations = read( filename );
        }
        catch( IOException e ) {
            System.out.println( e );
        }
        return populations;
    }
    
    public static void main( String[] args ) {
//        Population[] invåndare = Populations.readPopulations( "filer/befolkning.txt" );

        URL filePath = Populations.class.getClassLoader().getResource("DA339A_programmering1/Patterns/skola/lab18/befolkning.txt");
        System.out.println(filePath.getPath());
        Population[] invåndare = Populations.readPopulations( filePath.getPath());
        System.out.printf( "%-30s%15s\n", "LAND", "INVÅNARE" );
        for(int i = 0; i < invåndare.length; i++ ) {
            System.out.println( invåndare[ i ].toString() );
        }
    }
}
