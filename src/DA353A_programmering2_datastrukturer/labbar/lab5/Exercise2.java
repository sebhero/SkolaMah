/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Optional;

public class Exercise2 {
    private ArrayList<Person> persons = new ArrayList<Person>();
    
    public void readPersons( String filnamn ) {
        try {
            BufferedReader br = new BufferedReader( new FileReader( filnamn ) );
            String[] parts;
            Person person;
            String txt = br.readLine();
            while( txt != null ) {
                parts = txt.split( "," );
                person = new Person( parts[ 0 ], parts[ 1 ], parts[ 2 ] );
                persons.add( person );
                txt = br.readLine();
            }
            br.close();
        } catch( IOException e ) {
            System.out.println( "readPersons: " + e );
        }
    }

    public String toString() {
        return "Lagrade personer: " + persons.toString();
    }
    
    public void printPersons() {
        persons.forEach(System.out::println);
    }
    
    public int position( String socialSecurityNumber ) {

        Optional<Person> found = persons.stream()
                .filter(p -> p.getSocialSecurityNumber().equals(socialSecurityNumber))
                .findFirst();

        //would like to implent it into the stream with orelse
        if (found.isPresent()) {
            return persons.indexOf(found.get());
        }
        else
            return -1;

    }
    
    public void printName( String socialSecurityNumber ) {

        Optional<Person> found = persons.stream().filter(p -> p.getSocialSecurityNumber().equals(socialSecurityNumber))
                .findFirst();

        if (found.isPresent()) {
            found.ifPresent(p ->
                System.out.println(MessageFormat.format("{0} {1}", p.getFirstName(), p.getLastName()))
            );
        } else {
            System.out.println(MessageFormat.format("{0} unknown",socialSecurityNumber ));
        }

    }
    
    public boolean containsFirstName( String firstName ) {
        return persons.stream().anyMatch(person -> person.getFirstName().equals(firstName));


    }
    
    public boolean changeLastName( String socialSecurityNumber, String lastName ) {


        Optional<Person> found = persons.stream().filter(p -> p.getSocialSecurityNumber().equals(socialSecurityNumber))
                .findFirst();

        if (found.isPresent()) {
            found.get().setLastName(lastName);
        } else {
            System.out.println("didnt find!");
        }
        return true;
    }


    
    public static void main( String[] args ) {
        Exercise2 ex2 = new Exercise2();
//        ex2.readPersons( "files/personer.txt" );
        ex2.readPersons( "src/DA353A_programmering2_datastrukturer/labbar/lab5/personer.txt" );
        System.out.println( ex2.toString() );
//        ex2.printPersons();
//        System.out.println( ex2.position( "840102-4567" ) );
//        System.out.println( ex2.position( "111111-2222" ) );
//        ex2.printName( "840102-4567" );
//        ex2.printName( "111111-2222" );
//        System.out.println( ex2.containsFirstName( "Edit" ) );
//        System.out.println( ex2.containsFirstName( "Anna" ) );
        ex2.changeLastName( "1660503-8901", "Trödrot" );
        ex2.changeLastName( "531019-1234", "Trödrot" );
        System.out.println( ex2.toString() );
    }
}