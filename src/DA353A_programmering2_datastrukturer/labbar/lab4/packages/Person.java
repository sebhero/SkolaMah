/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab4.packages;

public class Person {
    private String id;
    private String firstname;
    private String lastname;
    private int length;
    private double weight;

    public Person(String id, String firstname, String lastname, int length, double weight) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.length = length;
        this.weight = weight;
    }
    
    public String getId() {
        return this.id;
    }
    
    public String getFirstname() {
        return this.firstname;
    }
    
    public String getLastname() {
        return this.lastname;
    }
    
    public int getLength() {
        return this.length;
    }
    
    public double getWeight() {
        return this.weight;
    }
    
    public String toString() {
        return this.id + " " + this.firstname + " " + this.lastname + ", längd=" + this.length +" vikt=" + this.weight;
    }
}
