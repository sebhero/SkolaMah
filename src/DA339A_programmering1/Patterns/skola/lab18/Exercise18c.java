/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.lab18;

import java.net.URL;

/**
 * Created by Sebastian Börebäck on 2015-11-03.
 */
public class Exercise18c {

    private final Exercise18a tools;

    public Exercise18c() {
        tools = new Exercise18a();
    }

    public int lessThanOneMillion( Population[] array ) {
// Komplettera med kod
        return tools.countLess1mil(array);
    }
    public int startsWithK( Population[] array ) {
// Komplettera med kod
        return tools.countStartingWithK(array);
    }
    public Population[] getTenToTwelveMillions( Population[] array ) {
// Komplettera med kod
        return tools.printAndSave10_12(array);

    }
    public Population[] getStartsWithK( Population[] array ) {
// Komplettera med kod
        return tools.printAndSaveStartWithK(array);
    }
    public void program() {
//        Population[] countries = Populations.readPopulations( "filer/befolkning.txt" );
        URL filePath = Populations.class.getClassLoader().getResource("DA339A_programmering1/Patterns/skola/lab18/befolkning.txt");
        Population[] countries= Populations.readPopulations( filePath.getPath());
        Population[] res;
//        Aktivera testerna en i taget, men först när du kompletterat
//        metoderna med kod.
//                test lessThanOneMillion
        int n = lessThanOneMillion(countries);
        System.out.println(n + " länder har mindre än 1 miljon invånare");
//        startsWithK
                n = startsWithK(countries);
        System.out.println(n + " länder börjar på bokstaven 'K'");
//        test getTenToTwelveMillions
        res = getTenToTwelveMillions(countries);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i].toString());
        }
//        test getStartsWithK
        res = getStartsWithK(countries);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i].toString());
        }
    }
    public static void main( String[] args ) {
        Exercise18c e18c = new Exercise18c();
        e18c.program();
    }
}


