/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab4.packages;
import java.util.*;

public class RealNbr implements Comparable<RealNbr> {
    private double value;
    
    public RealNbr(double value) {
        this.value = value;
    }
    
    public static RealNbr[] randomNumbers( int n, int min, int max) {
        Random rand = new Random();
        RealNbr[] res = new RealNbr[ n ];
        double realValue;
        for( int i = 0; i < res.length; i++ ) { 
            realValue = rand.nextDouble() * ( max - min ) + min;
            res[ i ] = new RealNbr( realValue  );
        }
        return res;
    }
    
    public double getValue() {
        return value;
    }
    
    public boolean equals(Object obj) {
        boolean res = false;
        if( obj != null ) {
            RealNbr t = ( RealNbr ) obj;
            res = ( this.value == t.value );
        }
        return res;
    }

    public int compareTo( RealNbr nbr ) {
        double diff = this.value - nbr.value;
        if( diff < 0 )
            return -1;
        else if( diff == 0 )
            return 0;
        else
            return 1;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
