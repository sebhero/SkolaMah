/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab13;

public class Building {
    private int floors;
    private int area;
    
    public Building(int floors, int area) {
        this.floors = floors;
        this.area = area;
    }

    public int getFloors() {
        return this.floors;
    }

    public int getArea() {
        return this.area;
    }
    
    public String toString() {
        return "Byggnad: " + this.floors + " våningar, yta " + this.area + " kvm";
    }
    
    public static void main(String[] args) {
        Building building = new Building(4, 832);
        System.out.println("Våningar=" + building.getFloors() + ", Yta=" + building.getArea());
        System.out.println("--------------------------------");
        System.out.println(building.toString());
    }
}
