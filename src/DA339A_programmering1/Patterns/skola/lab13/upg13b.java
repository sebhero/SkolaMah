/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.lab13;

/**
 * Created by seb on 2015-10-13.
 */
public class upg13b {

    public static void main(String[] args) {
        Contact contact = new Contact("Eva Bok","040-123456","040-333333","0705223344");
                System.out.println( "Namn: " + contact.getName() + "\n" +
                        "Telefonnummer: " + contact.getHome() + ", " +
                        contact.getWork() + ", " + contact.getMobile() );
        System.out.println("--------------------------------");
        System.out.println( contact.toString() );
    }

}
