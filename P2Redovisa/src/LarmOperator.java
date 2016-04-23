/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

/**
 * Created by Sebastian Börebäck on 2016-03-23.
 */
public class LarmOperator {
	private Kund[] kundLista;
	private PrioritestLista prioList;
	private Guard guards;
	private Gui gui;

	public boolean callCustomer(String tele) {
		return true;//if answeard
	}

	public void doTask() {
		Larm task = prioList.pop();
		Kund kund = task.getKund();
		for (String tele : kund.getTele()) {
			callCustomer(tele);
			if (verifyPassword()) {
				//correct password
				task.resetAlarm();
				task.close();
			} else {
				//couldnt verify or no answear
				contactGuards(task);
			}
		}

	}

	private void contactGuards(Larm task) {

		if (guards.sendGuard()) {
			//break in
			task.close();
		} else {
			//false alarm
			task.resetAlarm();
			task.close();
		}
	}

	private boolean verifyPassword() {
		return false;
	}

}
