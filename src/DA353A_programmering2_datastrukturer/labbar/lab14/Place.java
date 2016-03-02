/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab14;

public class Place {
    private String name;
    private Position position;

    public Place(String name, double longitude, double latitude) {
        this.name = name;
        this.position = new Position(longitude, latitude);
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public String toString() {
        return name + ": " + position;
    }
}
