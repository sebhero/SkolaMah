/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab21.upg1;

/**
 * Created by Sebastian Börebäck on 2015-11-17.
 */
public class Hours extends Wage {


    private final double hourlyWage;
    private double hours;

    public Hours(long id, double hourlyWage) {
        super(id);
        this.hourlyWage = hourlyWage;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    @Override
    protected double wage() {
        return hourlyWage*hours;
    }
}
