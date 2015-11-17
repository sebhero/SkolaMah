/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab21.upg1;

/**
 * Created by Sebastian Börebäck on 2015-11-17.
 */
public abstract class Wage {

    private long id;

    public Wage(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + ", lön denna månad: " + wage() + " kr";
    }

    protected abstract double wage();
}
