/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

/**
 * Created by Sebastian Börebäck on 2016-03-23.
 */
public class Guard {
	private Cops cops;

	public boolean sendGuard() {
		boolean breaking = true;
		//breakin
		if (breaking) {
			callCops();
			return true;
		}
		return false;

	}

	private void callCops() {
		cops.call();
	}
}
