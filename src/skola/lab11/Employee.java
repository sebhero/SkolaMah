/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab11;

/**
 * Created by sebadmin on 2015-10-05.
 */
public class Employee {

    String name;
    String employer;
    double wage;

    public Employee(String name, String employer, double wage) {
        this.name = name;
        this.employer = employer;
        this.wage = wage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", employer='" + employer + '\'' +
                ", wage=" + wage +
                '}';
    }
}
