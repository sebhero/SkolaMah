/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.lab13;

public class Address {
    private String street;
    private int postalCode;
    private String town;
    
    public Address(String street, int postalCode, String town) {
        this.street = street;
        this.postalCode = postalCode;
        this.town = town;
    }

    public String getStreet() {
        return this.street;
    }

    public int getPostalCode() {
        return this.postalCode;
    }

    public String getTown() {
        return this.town;
    }
    
    public String toString() {
        return "Adress: " + this.street + ", " + this.postalCode + " " + this.town;
    }
    
    public static void main(String[] args) {
        Address address = new Address("Södergatan 23", 21112, "Malmö");
        System.out.println("Gatan är " + address.getStreet());
        System.out.println("Postnummer och postadress: " + address.getPostalCode() +
                " " + address.getTown());
        System.out.println("-------------------------------------");
        System.out.println(address.toString());
    }
}
