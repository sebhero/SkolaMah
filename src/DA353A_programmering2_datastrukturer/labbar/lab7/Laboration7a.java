/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab7;


import DA353A_programmering2_datastrukturer.labbar.lab7.f7.ObjectNode;

public class Laboration7a {
    
    public static void exercise2a() {
    	ObjectNode pos6 = new ObjectNode( 9, null );
    	ObjectNode pos5 = new ObjectNode( 11, pos6 );
    	ObjectNode pos4 = new ObjectNode( -9, pos5 );
    	ObjectNode pos3 = new ObjectNode( -5, pos4 );
    	ObjectNode pos2 = new ObjectNode( 20, pos3 );
    	ObjectNode pos1 = new ObjectNode( 17, pos2 );
    	ObjectNode list = new ObjectNode( 23, pos1 );
    	System.out.println( list );
        
        //komplettera med kod

        ObjectNode pos7 = new ObjectNode( 7, pos4 );
        pos3.setNext(pos7);
        
        System.out.println( list );
    }
    
    public static void exercise2b() {
        ObjectNode list = new ObjectNode( 23, new ObjectNode( 17, new ObjectNode( 20,new ObjectNode( -5, new ObjectNode( -9, new ObjectNode( 11, new ObjectNode( 9, null ) ) ) ) ) ) );
        
        // Komplettera med kod så att listan skrivs ut på följande form: [ 23 17 20 -5 -9 11 9 ]
        // OBS, ej anrop list.toString()
	    System.out.print("[");


	    ObjectNode next = list;
	    while (next != null) {
		    System.out.print(next.getData()+" ");
		    next = next.getNext();
	    }
	    System.out.print("]");
    }
    
    public static void exercise2c() {
        ObjectNode pos6 = new ObjectNode( 9, null );
        ObjectNode pos5 = new ObjectNode( 11, pos6 );
        ObjectNode pos4 = new ObjectNode( -9, pos5 );
        ObjectNode pos3 = new ObjectNode( -5, pos4 );
        ObjectNode pos2 = new ObjectNode( 20, pos3 );
        ObjectNode pos1 = new ObjectNode( 17, pos2 );
        ObjectNode list = new ObjectNode( 23, pos1 );
        System.out.println( list );
        
        // Komplettera med kod
	    ObjectNode pos7 = new ObjectNode( 4, pos2 );
	    ObjectNode pos8 = new ObjectNode( -14, pos7 );
	    pos1.setNext(pos8);

        System.out.println( list );
    }
    
    public static void exercise2d() {
        ObjectNode pos6 = new ObjectNode( 9, null );
        ObjectNode pos5 = new ObjectNode( 11, pos6 );
        ObjectNode pos4 = new ObjectNode( -9, pos5 );
        ObjectNode pos3 = new ObjectNode( -5, pos4 );
        ObjectNode pos2 = new ObjectNode( 20, pos3 );
        ObjectNode pos1 = new ObjectNode( 17, pos2 );
        ObjectNode list = new ObjectNode( 23, pos1 );
        System.out.println( list );
        
        // Komplettera med kod
	    ObjectNode pos7 = new ObjectNode( -14, pos2 );
	    pos1.setNext(pos7);
	    ObjectNode pos8 = new ObjectNode( 4, pos3 );
	    pos2.setNext(pos8);

        System.out.println( list );
    }
    
    public static void exercise2e() {
        ObjectNode pos6 = new ObjectNode( 9, null );
        ObjectNode pos5 = new ObjectNode( 11, pos6 );
        ObjectNode pos4 = new ObjectNode( -9, pos5 );
        ObjectNode pos3 = new ObjectNode( -5, pos4 );
        ObjectNode pos2 = new ObjectNode( 20, pos3 );
        ObjectNode pos1 = new ObjectNode( 17, pos2 );
        ObjectNode list = new ObjectNode( 23, pos1 );
        System.out.println( list );
        
        // Komplettera med kod
	    pos2.setNext(pos4);
	    pos3 = null;

        System.out.println( list );
    }
    
    public static void exercise2f() {
        ObjectNode list = new ObjectNode( 23, new ObjectNode( 17, new ObjectNode( 20,new ObjectNode( -5, new ObjectNode( -9, new ObjectNode( 11, new ObjectNode( 9, null ) ) ) ) ) ) );
        System.out.println( list );
        
        // Komplettera med kod
	    ObjectNode temp = list.getNext();
	    list = temp;

        System.out.println( list );
    }
    
    public static void exercise2g() {
        ObjectNode pos6 = new ObjectNode( 9, null );
        ObjectNode pos5 = new ObjectNode( 11, pos6 );
        ObjectNode pos4 = new ObjectNode( -9, pos5 );
        ObjectNode pos3 = new ObjectNode( -5, pos4 );
        ObjectNode pos2 = new ObjectNode( 20, pos3 );
        ObjectNode pos1 = new ObjectNode( 17, pos2 );
        ObjectNode list = new ObjectNode( 23, pos1 );
        System.out.println( list );
        
        // Komplettera med kod
	    pos1 = null;
	    list = null;
	    list = pos2;

        System.out.println( list );
    }
    
    public static void exercise2h() {
        ObjectNode list = new ObjectNode( 23, new ObjectNode( 17, new ObjectNode( 20,new ObjectNode( -5, new ObjectNode( -9, new ObjectNode( 11, new ObjectNode( 9, null ) ) ) ) ) ) );
        System.out.println( list );
        
        // Komplettera med kod
	    ObjectNode temp = list.getNext().getNext();
	    list = temp;

        System.out.println( list );
    }
    
    public static void exercise2i() {
        ObjectNode pos6 = new ObjectNode( 9, null );
        ObjectNode pos5 = new ObjectNode( 11, pos6 );
        ObjectNode pos4 = new ObjectNode( -9, pos5 );
        ObjectNode pos3 = new ObjectNode( -5, pos4 );
        ObjectNode pos2 = new ObjectNode( 20, pos3 );
        ObjectNode pos1 = new ObjectNode( 17, pos2 );
        ObjectNode list = new ObjectNode( 23, pos1 );
        System.out.println( list );
        
        // Komplettera med kod
	    pos1 =null;
        list.setNext(pos2);
	    pos3 = null;
	    pos2.setNext(pos4);
        System.out.println( list );
    }    
    
    
    public static void main(String[] args) {        
//        Laboration7a.exercise2a();
//        Laboration7a.exercise2b();
//        Laboration7a.exercise2c();
//        Laboration7a.exercise2d();
//        Laboration7a.exercise2e();
//        Laboration7a.exercise2f();
//        Laboration7a.exercise2g();
//        Laboration7a.exercise2h();
        Laboration7a.exercise2i();
    }
}
