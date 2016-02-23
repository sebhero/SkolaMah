/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab12.assets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastian Börebäck on 2016-02-23.
 */
public class CollectValues<T> implements Action<T> {

	protected ArrayList<T> list = new ArrayList<>();

	@Override
	public void action(T value) {
		list.add(value);
	}

	public List<T> getValues() {
		return list;
	}
}
