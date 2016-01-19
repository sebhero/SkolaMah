/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.lab13;

/**
 * Created by seb on 2015-10-13.
 */
public class RealEstate {

    String name;
    Building building;
    Address address;

    public RealEstate(String name, Building building, Address address) {

        this.name = name;
        this.building = building;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Building getBuilding() {
        return building;
    }

    public Address getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "RealEstate{" +
                "name='" + name + '\'' +
                ", building=" + building.toString() +
                ", address=" + address.toString() +
                '}';
    }
}
