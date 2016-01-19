/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.lab23;

/**
 * Created by Sebastian Börebäck on 2015-11-20.
 */
public class Interval  implements WageFilter{

    private double min,max;

    public Interval(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean accept(WageEmployee employed) {
        double wage = employed.wage();
        return wage <= max && wage >= min;
    }
}
