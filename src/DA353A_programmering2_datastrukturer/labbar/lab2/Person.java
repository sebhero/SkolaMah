/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab2;

public class Person {
    private String firstName;
    private String familyName;
    private int age;

	String tele1;
	String tele2;
	String tele3;

    public Person(String firstName, String familyName, int age) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public String getFamilyName() {
        return this.familyName;

    }

    public String getFirstName() {
        return this.firstName;
    }
    
    public String toString() {
        return this.firstName + " " + this.familyName;
    }
}
