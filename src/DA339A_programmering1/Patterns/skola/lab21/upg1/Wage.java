/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.lab21.upg1;

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

    /**
     * Uses the implemented wage in the child class.
     * Since this class is abstract and has no real implementation.
     * @return
     */
    @Override
    public String toString() {
        return "Id: " + this.id + ", lön denna månad: " + wage() + " kr";
    }

    /**
     * Must be implemented since its a from a abstract class
     * @return the wage calculated
     */
    protected abstract double wage();


}
