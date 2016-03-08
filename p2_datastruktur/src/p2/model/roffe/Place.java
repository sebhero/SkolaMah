/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package p2.model.roffe;public class Place {
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
        return name;
    }
}
