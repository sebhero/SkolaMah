/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab4.packages;
import java.util.*;

public class IdAscending implements Comparator<Person> {
    public int compare( Person p1, Person p2 ) {
        String id1 = p1.getId();
        String id2 = p2.getId();
        return id1.compareTo( id2 );  // använder metoden compareTo( String )
    }
}
