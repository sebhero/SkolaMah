/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab5;
import java.util.*; // ArrayList
import java.io.*; // BufferedReader, FileReader, IOException

public class Exercise1 {
    public static ArrayList<Person> readPersons( String fileName ) {
        ArrayList<Person> list = new ArrayList<Person>();
        try {
            BufferedReader br = new BufferedReader( new FileReader( fileName ) );
            String[] parts;
            Person person;
            String txt = br.readLine();
            while( txt != null ) {
                parts = txt.split( "," );
                person = new Person( parts[ 0 ], parts[ 1 ], parts[ 2 ] );
                list.add( person );
                txt = br.readLine();
            }
            br.close();
        } catch( IOException e ) {
            System.out.println( "readPersons: " + e );
        }
        return list;
    }
    
    public static void main( String[] args ) {
        ArrayList<Person> persons = Exercise1.readPersons( "files/personer.txt" );
        Person pers1 = new Person( "761201-7654", "Henry", "Smith" );
        Person pers2 = new Person( "011003-4444", "Alma", "Björk" );
        Person p;
        int a;
        System.out.println("-------- A ---------");
        System.out.println( persons.toString() ); // A
        //skriver ut listan po alla personer i arraylist
	    // och skriver ut infon om
	    // socialSecurityNumber + " " + firstName + " " + lastName;

        System.out.println("-------- B ---------");
        p = persons.get( 2 ); // B
        System.out.println( p.toString() );
	    //hamtar 690320-2345,Elin,Gustavsson
        
        System.out.println("-------- C ---------");
        persons.add( pers1 ); // C
        System.out.println( persons.toString() );
        //listan har nu oxa "761201-7654", "Henry", "Smith"

        System.out.println("-------- D ---------");
        persons.add( 4, pers2 ); // D
        System.out.println( persons.toString() );
	    //po 4:e plats finns nu pers2 "011003-4444", "Alma", "Björk" );
        
        System.out.println("-------- E ---------");
        a = persons.size(); // E
        System.out.println( a );
	    //skriver ut storleken po arraylisten
        
        System.out.println("-------- F ---------");
        a = persons.indexOf( pers2 ); // F
        System.out.println( a );
	    //skriver ut indexet for pers2 som ar 4
        
        System.out.println("-------- G ---------");
        if( persons.contains( pers1 ) ) { // G
            System.out.println( pers1.toString() + " FINNS" );
        } else {
            System.out.println( pers1.toString() + " FINNS EJ" );
        }
	    //finns var tillagd i C
        
        System.out.println("-------- H ---------");
        persons.remove( 1 ); // H
        System.out.println( persons.toString() );
        //tar bort elementet po pos 1

        System.out.println("-------- I ---------");
        persons.clear(); // I
        System.out.println( persons.toString() );
	    //tommer listan
    }
}
