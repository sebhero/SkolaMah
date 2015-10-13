/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab13;

/**
 * Created by seb on 2015-10-13.
 */
public class upg13e {

    public static void main(String[] args) {


        Building building = new Building(5, 1350);
        Address address = new Address("Nygatan 4", 12345,
                "Ystad");
        RealEstate re = new RealEstate("Kvarnen 4", building, address);
        System.out.println(re.getName());
        System.out.println(re.getBuilding().toString()); // toString i Building-klassen
        System.out.println(re.getAddress().toString()); // toString i Address-klassen
        System.out.println("---------------------------");
        System.out.println(re.toString());

        System.out.println("---------------------------");
        re.setName("Skorpionen 17");
        re.setBuilding( new Building(6, 1470) );
        re.setAddress( new Address("Nygatan 4", 55555, "Ystad") );
        System.out.println(re.toString());

    }

}
