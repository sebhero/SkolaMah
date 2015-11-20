/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab23;

/**
 * Created by Sebastian Börebäck on 2015-11-20.
 */
public class Between17000And21000 implements WageFilter {


    @Override
    public boolean accept(WageEmployee employed) {
        double wage = employed.wage();
        return wage <= 21_000 && wage >= 17_000;
    }
}
