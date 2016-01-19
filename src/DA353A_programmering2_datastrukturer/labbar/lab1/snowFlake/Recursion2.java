/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab1.snowFlake;

public class Recursion2 {
    
    public int sum( int n ) {
        if( n == 1 )
            return 1;
        else
            return n + sum( n - 1 );
    }
    
    public int sumArray( int[] array, int pos ) {
        if( pos == array.length-1 )
            return array[pos];
        else
            return array[ pos ] + sumArray( array, pos + 1 );
    }
    
    public boolean member( char tkn, String str ) {
        if( str.length() == 0 )
            return false;
        else if( tkn == str.charAt(0) )
            return true;
        else
            return member( tkn, str.substring(1));
    }
    
    public static void main(String[] args) {
        Recursion2 rec2 = new Recursion2();
        int[] a = { 17, 11, 9, 16 };
        int res;
//        res = rec2.sum( 5 );
        res = rec2.sumArray( a, 0 );
        System.out.println( res );
//        System.out.println(rec2.member( 'e', "Student") );
    }
}
