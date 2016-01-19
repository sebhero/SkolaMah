/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.lab13;

/**
 * Created by seb on 2015-10-13.
 */
public class upg13a {

    public static void main(String[] args) {
        PhoneNumber phone = new PhoneNumber( "0413-11111", "040-123456",
                "0735191919" );
        System.out.println( phone.getHome() + ", " + phone.getWork() + ", " +
                phone.getMobile() );
        System.out.println( "------------------------" );
        System.out.println( phone.toString() );
        System.out.println( "------------------------" );
        phone.setHome("040-222222");
        phone.setWork("");
        phone.setMobile("0707657654");
        System.out.println( phone.toString() );
    }

}
