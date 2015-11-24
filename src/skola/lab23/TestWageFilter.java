/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab23;

/**
 * Created by Sebastian Börebäck on 2015-11-20.
 */
public class TestWageFilter {
        public static void main( String[] args ) {


            WageEmployee[] employees = { new FullTime( 19938278, 21500 ),
                    new Commission( 19278865, 0.10 ),
                    new Hours( 17233534, 95.0 ),
                    new FullTime( 27348263, 18000 )};

            ((Commission)employees[ 1 ]).setSales( 208000 );
            (( Hours )employees[ 2 ]).setHours(128);

            System.out.println("MAX 20 000");
            WageFilter filter = new Max20000();
            for( int i = 0; i < employees.length; i++ ) {
                if( filter.accept( employees[ i ] ) ) {
                    System.out.println( employees[ i ] );
                }
            }
            System.out.println();
            System.out.println("Between 17 000 and 21 000");
            filter = new Between17000And21000();

            for( int i = 0; i < employees.length; i++ ) {
                if( filter.accept( employees[ i ] ) ) {
                    System.out.println( employees[ i ] );
                }
            }

            System.out.println();
            System.out.println("Between 19 000 and 21 000");
            filter = new Interval(19_000,21_000);
            for( int i = 0; i < employees.length; i++ ) {
                if( filter.accept( employees[ i ] ) ) {
                    System.out.println( employees[ i ] );
                }
            }
        }
}
