/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab5;

public class TestDoubleStack {
    public static void main(String[] args) {
        DoubleStack stack = new DoubleStack(100);
        
        for( int i = 10; i < 20; i++ )
            stack.push( new Double(i) );
        System.out.println( "Size = " + stack.size() );
        System.out.println( "Första element = " + stack.peek() );
        while( !stack.isEmpty() )
            System.out.println( "Element = " + stack.pop() +", size = " + stack.size() );




    }


}
