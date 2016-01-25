/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab2;

import java.util.Random;

/**
 * Created by seb on 2016-01-20.
 */
public class Exercise4 {

	private static void swap(Object[] array, int elem1, int elem2) {
		Object temp = array[elem1];
		array[elem1] = array[elem2];
		array[elem2] =temp;
	}

	public static Object[] shuffle(Object[] objects) {
		int pos;
		Random rnd = new Random();
		for (int i = objects.length-1; i > 0; i--) {
			pos = rnd.nextInt(i + 1);
			swap(objects,i,pos);
		}

		return objects;

	}
}
