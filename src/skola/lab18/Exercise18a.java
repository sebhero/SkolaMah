/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab18;

import java.net.URL;
import java.text.MessageFormat;

/**
 * Created by Sebastian Börebäck on 2015-11-03.
 */
public class Exercise18a {


    public static void main(String[] args) {
        Exercise18a app = new Exercise18a();
        app.program();


    }

    private void program() {
        URL filePath = Populations.class.getClassLoader().getResource("skola/lab18/befolkning.txt");
        Population[] countries= Populations.readPopulations( filePath.getPath());

        //toString print
        printWithToString(countries);

        //print  countries
        printWithCountries(countries);

        //print land + inv over 100 mil
        printBiggerThan100mil(countries);

        //print starting with M
        printWithM(countries);

        //4 print inv mellan 8-10mil
        printBetween8_10(countries);

        //5 skriv ut alla l'nder med mindre an 1 mil
        countLess1mil(countries);

        //6 antal med startar po K
        countStartingWithK(countries);

        //7 spara undan array och skriv ut
        printAndSave10_12(countries);

        //8 lagra och skriv ut med K
        printAndSaveStartWithK(countries);

        //9 skriv ut alla lander
        printCountries(countries);

        //10 skrivut alla minder an 1 mil
        printLess1milSimple(countries);

    }

    public void printLess1milSimple(Population[] countries) {
        for (Population country : countries) {

            if(country.getPopulation() < 1_000_000)
            {
                System.out.println(country.toString());
            }

        }
    }

    public void printCountries(Population[] countries) {
        for (Population country : countries) {
            System.out.println(country.getCountry());
        }
    }

    public Population[] printAndSaveStartWithK(Population[] countries) {

        int count =0;
        int index = 0;

        for (Population country : countries) {
            if (country.getCountry().charAt(0) == 'K') {
                count++;
            }
        }

        Population[] newArr = new Population[count];


        for (Population country : countries) {
            if (country.getCountry().charAt(0) == 'K') {
                newArr[index] = country;
                index++;
            }
        }

        for (Population population : newArr) {
            System.out.println(population.toString());
        }

        return newArr;

    }

    public Population[] printAndSave10_12(Population[] countries) {

        int count= 0,index= 0;
        long inhabitants = 0;

        for (Population country : countries) {
            if(country.getPopulation() >= 10_000_000 && country.getPopulation()<= 12_000_000)
            {
                count++;
            }
        }

        System.out.println("print new Array");
        System.out.println("count "+count);

        Population[] newArr = new Population[count];

        for (Population country : countries) {
            inhabitants = country.getPopulation();
            //System.out.println(inhabitants);
            if(inhabitants  >= 10_000_000 && inhabitants <= 12_000_000)
            {

                newArr[index] = country;
                index++;
            }
        }


        for (Population population : newArr) {
            System.out.println(population.toString());
        }

        return newArr;
    }

    public int countStartingWithK(Population[] countries) {
        int count = 0;
        for (Population country : countries) {
            if(country.getCountry().charAt(0) == 'K')
                count++;
        }
        System.out.println("Antal med K: "+count);
        return count;
    }

    public int countLess1mil(Population[] countries) {
        int count = 0;
        for (Population country : countries) {
            if(country.getPopulation() < 1_000_000)
            {
                count++;
                //System.out.println(country.toString());
            }
        }

        System.out.println("Antal: "+count);
        return count;
    }

    public void printBetween8_10(Population[] countries) {
        for (Population country : countries) {

            if(country.getPopulation()>= 8_000_000 && country.getPopulation()<= 10_000_000)
            {
                System.out.println(country.toString());
            }
        }
    }

    public void printWithM(Population[] countries) {

        for (Population country : countries) {
            if(country.getCountry().charAt(0) == 'M')
            {
                System.out.println(country.toString());
            }
        }
    }

    public void printBiggerThan100mil(Population[] countries) {
        for (Population country : countries) {
            if(country.getPopulation() > 100_000_000)
            {
                System.out.println(country.toString());
            }
        }
    }

    public void printWithCountries(Population[] countries) {
        for(Population country : countries)
        {
            System.out.println(country.getCountry());
        }
    }

    public void printWithToString(Population[] countries) {

        for(Population country : countries)
        {
            System.out.println(country.toString());
        }
    }
}
