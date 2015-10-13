/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab13;

/**
 * Created by seb on 2015-10-13.
 */
public class upg13c {

    public static void main(String[] args) {

        Contact contact = new Contact("Eva Bok","040-123456","040-333333","0705223344");
                System.out.println( "Namn: " + contact.getName() + "\n" +
                        "Telefonnummer: " + contact.getHome() + ", " +
                        contact.getWork() + ", " + contact.getMobile() );
        System.out.println("--------------------------------");
        System.out.println( contact.toString() );

        System.out.println("--------------------------------");
        contact.setHome("040-999999");
        contact.setWork("0415-22222");
        contact.setMobile("0776192837");
        System.out.println( contact.toString() );
    }


}
