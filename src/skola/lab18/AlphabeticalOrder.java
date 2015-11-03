/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab18;

import java.text.MessageFormat;
import java.util.Comparator;
import java.util.Objects;

/**
 * Created by Sebastian Börebäck on 2015-11-03.
 */
public class AlphabeticalOrder implements Comparator{

    public int compare(Object obj1, Object obj2) {
        Population country1 = ( Population )obj1;
        Population country2 = ( Population )obj2;
        String name1 = country1.getCountry();
        String name2 = country2.getCountry();

        if(name1.compareTo(name2) < 0)
        {
            return -1;
        }
        else if(name1.compareTo(name2) > 0)
        {
            return 1;
        }
        else
        {
            //if equals
            return 0;
        }

// Här ska du jämföra name1 med name2
// Är name1 mindre än name2 så ska metoden returnera -1. Denna jämförelse
// gör du så här:
// if( name1.compareTo( name2 ) < 0 ) osv
// Är name1 större än name2 så ska metoden returnera 1
// Är name1 och name2 lika stora så ska metoden returnera 0
// Ovanståend jämförelse görs korrektare med hjälp av ett Collator-objekt.
// Skulle det funnits länder som börjar med Å eller Ä så skulle även dessa
// ordnats på avsett sätt.
// * importera java.text.*;
// * Efter ovanstående fyra rader lägg till
// Collator coll = Collator.getInstance();
// * Jämför sedan med coll.compare( name1, name2 )

    }
}
