/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab24;

import skola.lab24.resources.InOut;

/**
 * Created by Sebastian Börebäck on 2015-11-23.
 */
public class Upg2 {

    public static void main( String[] args ) {
        double real;
        int nbr;
        real = InOut.readDouble();
        System.out.println( "Inmatat tal: " + real );
        real = InOut.readDouble( "Mata in ett stort decimaltal" );
        System.out.println( "Inmatat tal: " + real );
        nbr = InOut.readInt();
        System.out.println( "Inmatat tal: " + nbr );
        nbr = InOut.readInt("Mata in ett positivt heltal");
        System.out.println( "Inmatat tal: " + nbr );
    }


}
