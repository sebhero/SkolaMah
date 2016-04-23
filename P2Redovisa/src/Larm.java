/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

/**
 * Created by Sebastian Börebäck on 2016-03-23.
 */
public class Larm {
	private Kund kund;
	private String address;
	private boolean alarm=false;
	private boolean closed;

	public Kund getKund() {
		return kund;
	}

	public void resetAlarm() {
		this.alarm = false;
	}

	public void close() {
		this.closed = true;
	}
}
