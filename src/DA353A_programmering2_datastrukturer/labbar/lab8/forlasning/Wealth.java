/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab8.forlasning;
import java.util.*;

public class Wealth implements Comparator<Person>{
    public int compare(Person p1, Person p2) {
        return p2.getWealth() - p1.getWealth();
    }
}
