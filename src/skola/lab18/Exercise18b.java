/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab18;

import java.net.URL;

/**
 * Created by Sebastian Börebäck on 2015-11-03.
 */
public class Exercise18b {


    private final Exercise18a tools;

    public Exercise18b() {
        tools = new Exercise18a();
    }

    public void printCountries( Population[] array ) {

        tools.printCountries(array);
    }
    public void moreThanHundredMillions( Population[] array ) {
// Komplettera med kod
        tools.printBiggerThan100mil(array);
    }
    public void startsWithM( Population[] array ) {
// Komplettera med kod
        tools.printWithM(array);
    }
    public void eightToTenMillions( Population[] array ) {
// Komplettera med kod
        tools.printBetween8_10(array);
    }
    public void program() {
        URL filePath = Populations.class.getClassLoader().getResource("skola/lab18/befolkning.txt");
        Population[] countries= Populations.readPopulations( filePath.getPath());
//        Population[]countries = Populations.readPopulations(
//                "filer/befolkning.txt" );

// Aktivera metoderna en i taget, men först när du kompletterat
// med kod.
  printCountries( countries );
  moreThanHundredMillions(countries);
  startsWithM(countries);
    eightToTenMillions(countries);
    }
    public static void main( String[] args ) {
        Exercise18b e18b = new Exercise18b();
        e18b.program();
    }
}
