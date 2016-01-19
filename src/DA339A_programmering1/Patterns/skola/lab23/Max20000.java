/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.lab23;

/**
 * Created by Sebastian Börebäck on 2015-11-20.
 */
public class Max20000 implements WageFilter {


    @Override
    public boolean accept(WageEmployee employed) {
        double wage = employed.wage();
        return wage <= 20_000;
    }
}
