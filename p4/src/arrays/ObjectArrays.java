/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package arrays;

import java.util.*;


/**
 * Created by Sebastian Börebäck on 2015-11-08.
 */

/**
 * A Object array util
 */
public class ObjectArrays {

    private static final boolean MAX = true;
    private static final boolean MIN = false;

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
        //didnt find the number
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

        boolean max  = MAX;
        return findObject(array, max);

    }

    /**
     * Finds the smallest object in the array.
     * @param array the array
     * @return the smallest object
     */
    public static Object min(Object[] array) {

        boolean min = MIN;
        return findObject(array, min);

    }

    /**
     * Find the object determined byt the what. if its true Max if false Min
     * @param array the array you are searching in
     * @param what what you are looking for true = MAX, false = MIN
     * @return the Object you are looking for.
     */
    private static Object findObject(Object[] array, boolean what) {
        Object result = array[0];
        Comparable comp;


        for (int i = 0; i < array.length; i++) {
            comp = (Comparable) array[i];

            //check if the value is better than the last we found
            if (comp.compareTo(result) > 0 == what) {
                result = comp;
            }
        }
        return result;
    }
}
