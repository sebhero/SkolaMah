/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.lab21.upg1;



/**
 * Created by Sebastian Börebäck on 2015-11-17.
 */
public class Fulltime extends Wage{


    private double wage;

    public Fulltime(long id, double wage) {
        super(id);
        this.wage = wage;
    }

    public double getWage() {
        return wage;
    }

    @Override
    protected double wage() {
        return wage;
    }


    public void setWage(int wage) {
        this.wage = wage;
    }

}
