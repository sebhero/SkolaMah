/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab7.f7;

public class Person {
    private String name;
    private int age;
    
    public Person( String name, int age ) {
        this.name = name;
        this.age = age;
    }
    
    public String toString() {
        return this.name + ", " + this.age + " år";
    }
}
