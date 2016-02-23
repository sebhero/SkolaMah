/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab12;

/**
 * Created by Sebastian Börebäck on 2016-02-23.
 */
public class CollectEvenValues<T> extends CollectValues<T> {


	@Override
	public void action(T value) {
		if (value instanceof Integer) {
			int intVal =(Integer) value;
			if (intVal % 2 == 0) {
				//list.add(value);
				super.action(value);
			}
		}

	}
}
