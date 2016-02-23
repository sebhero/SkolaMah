/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab11.assets;

public class TestPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Person> queue = new PriorityQueue<Person>(10);
//        PriorityQueue<Person> queue = new PriorityQueue<Person>(10,new ReverseComparable<Person>());
//        PriorityQueue<Person> queue = new PriorityQueue<Person>(10,new Wealth());
//        PriorityQueue<Person> queue = new PriorityQueue<Person>(10,new Age());
        Person[] list = {new Person("A",20,100), new Person("C",28,200), 
                         new Person("E",24,50), new Person("B",28,50),
                         new Person("D",28,100),new Person("F",24,100)};
        
        for( Person p : list )
            queue.enqueue( p );
        System.out.println( "Size = " + queue.size() );
        System.out.println( "Första element: " + queue.peek() );
        while( !queue.isEmpty() )
            System.out.println( "Element: " + queue.dequeue() +", size = " + queue.size() );
    }
}
