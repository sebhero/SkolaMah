/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab18;

/**
 * Klassen lagrar ett lands befolkning
 * @author Rolf
 */
public class Population implements Comparable{
    private String country;
    private long population;
    
    public Population( String country, long population ) {
        this.country = country;
        this.population = population;
    }
    
    public String getCountry() {
        return this.country;
    }
    
    public long getPopulation() {
        return this.population;
    }
    
    public String toString() {
        return String.format( "%-30s%15d", this.country, this.population );
    }

    @Override
    public int compareTo(Object o) {
        Population country = (Population)o;
        long inhabitants = country.getPopulation();

        if(this.population < inhabitants)
        {
            return -1;
        }
        else if(this.population > inhabitants)
        {
            return 1;
        }
        else return 0;
    }
}