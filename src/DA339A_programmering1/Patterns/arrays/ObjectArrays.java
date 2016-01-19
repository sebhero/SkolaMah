/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * Created by Sebastian Börebäck on 2015-11-08.
 */

/**
 * A Object array util
 */
public class ObjectArrays {

    /**
     * Creates a string out of a array
     * @param array the array
     * @return a string of the data in the array
     */
    public static String toString(Object[] array) {

        String str = "{";

        for (int i = 0; i < array.length; i++) {
            str+=array[i].toString();
            if(i+1 < array.length) {
                str += ",";
            }
        }
        str += "}";
        return str;
    }

    /**
     * Find the index of a object in the array
     * @param array the array
     * @param o the object
     * @return 1 if its found else -1 if it didnt find it.
     */
    public static int indexOf(Object[] array, Object o) {
        for (Object currentObject : array) {
            if (o.equals(currentObject)) {
                return 1;
            }
        }
        //hittade inte
        return -1;
    }

    /**
     * Check if the object is a member of the array
     * @param array the array
     * @param o the object we are looking for
     * @return true if its found.
     */
    public static boolean member(Object[] array, Object o) {
        int result = indexOf(array, o);
        if (result == 1) {
            return true;
        }

        //otherwise
        return false;


    }

    /**
     * Finds the biggest object in the array
     * @param array the array
     * @return the biggest object
     */
    public static Object max(Object[] array) {

        Object res = array[0];
        Comparable comp;

        for (int i = 0; i < array.length; i++) {
            comp = (Comparable) array[i];
            if (comp.compareTo(res) > 0) {
                res = comp;
            }
        }
        return res;

    }

    /**
     * Finds the smallest object in the array.
     * @param array the array
     * @return the smallest object
     */
    public static Object min(Object[] array) {

        Object res = array[0];
//        Comparable comp;
//
//        for (int i = 0; i < array.length; i++) {
//            comp = (Comparable) array[i];
//            if (comp.compareTo(DA339A_programmering1.Patterns.res) < 0) {
//                DA339A_programmering1.Patterns.res = comp;
//            }
//        }

        //Converts the array to a list
        List values = new ArrayList(Arrays.asList(array));
        res = Collections.min(values);


        return res;
    }
}
