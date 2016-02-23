/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab11;

import DA353A_programmering2_datastrukturer.labbar.lab11.assets.Filter;

/**
 * Created by seb on 2016-02-23.
 */
public class EvenNumbers implements Filter<Integer> {
	@Override
	public boolean accept(Integer element) {
		return ((element % 2) == 0);
	}
}
