/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab12.assets;

/**
 * Created by Sebastian Börebäck on 2016-02-23.
 */
public class Print<T> implements Action<T>{
	@Override
	public void action(T value) {
		System.out.print(value +" ");
	}
}
