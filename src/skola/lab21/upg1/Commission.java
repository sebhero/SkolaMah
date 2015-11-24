/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab21.upg1;

/**
 * Created by Sebastian Börebäck on 2015-11-17.
 */
public class Commission extends Wage {


    private double rate;
    private double sales;

    public Commission(long id, double rate) {
        super(id);
        this.rate = rate;
    }

    @Override
    protected double wage() {
        return rate*sales;
    }

    public double getRate() {
        return rate;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
