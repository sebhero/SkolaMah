/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab8.assets;
import java.util.Comparator;

public class Age implements Comparator<Person>{
    public int compare(Person p1, Person p2) {
        return p1.getAge() - p2.getAge();
    }
}
