/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab21.upg1;

/**
 * Created by seb on 2015-11-17.
 */
public class TestUpg1 {

    public static void main(String[] args) {
        //FUlltime test
        System.out.println();
        System.out.println("Test Fulltime");
        Fulltime employee = new Fulltime( 19938278, 21500 );
        System.out.println( employee.toString() );
        System.out.println( "Anställd med id " + employee.getId() +
                " har månadslönen " + employee.getWage() + " kr");
        employee.setWage( 22250 );
        System.out.println( "Lön denna månad: " + employee.wage() + " kr");

        //Test Hours
        System.out.println();
        System.out.println("Test Hours");
        Hours employeeH = new Hours( 17233534, 95.0 );
        employeeH.setHours( 128 );
        System.out.println( employeeH.toString() );
        System.out.println( "Anställd med id " + employeeH.getId() +
                " har arbetat " + employeeH.getHours() +
                " timmar till lönen " + employeeH.getHourlyWage() + " kr" );
        employeeH.setHourlyWage(98.50);
        System.out.println( "Lön denna månad: " + employeeH.wage() + " kr");

        //Test Commision
        System.out.println();
        System.out.println("Test commision");
        Commission employeeC = new Commission( 19278865, 0.10 );
        employeeC.setSales(208000);
        System.out.println( employeeC.toString() );
        System.out.println("Anställd med id " + employeeC.getId() +
                " har sålt för " + employeeC.getSales() +
                " kr till provisionen " + employeeC.getRate() * 100 +
                " %");
        employeeC.setRate(0.12);
        System.out.println( "Lön denna månad: " + employeeC.wage() + " kr");

    }

}
