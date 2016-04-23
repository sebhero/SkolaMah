/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.tenta20160324.tenta140505;

/**
 * Created by Sebastian Börebäck on 2016-03-23.
 */
public class Upg6 {
	private String name;
	private int age;
	/**
	 * A
	 * Put så lägger man till Hello värdet på nyckeln "hej"
	 * Så när man gör get så använder man sig utav nyckeln "Adjö" för
	 * att få dess värde tex "Goodbye"
	 * I en hashmap mappar man upp nycklar med värden för att
	 * snabbt hitta det man letar efter.
	 * Den gör det genom att skapa en hashnyckel från nyckeln vi skickar in.
	 *
	 */

	/**
	 * B
	 * Mergesort, Quicksort
	 */

	/**
	 * upg6 C
	 * Y
	 * E
	 * S
	 * S
	 * E
	 * Y
	 */

	public void mystery(String str) {
		if (str.length() > 0) {
			System.out.println(str.charAt(0));
			mystery(str.substring(1));
			System.out.println(str.charAt(0));
		}
	}

	public static void main(String[] args) {
		Upg6 upg6 = new Upg6();
		upg6.mystery("YES");
	}

	/**
	 * D
	 * Nyckeln A kan ha ett värde som är mellan 62 och 68
	 * alltså 63 - 67
	 * För att vänstra är mindre än A och högra värdet är Högre än A.
	 * Därmed måste a vara mellan dessa två värdena.
	 * detta är pga ordningen värdena har kommit in i trädet.
	 * A har kommit in i trädet efter 56 och innan 62 och 68
	 */

	/**
	 * E
	 * Djup 4
	 * 1
	 * 2
	 * 4
	 * 8
	 * 16 *djup 0 finns oxa
	 * svar 31 = 2^45-1
	 */

	/**
	 * upg7
	 */

	public boolean eqausl(Object otherP) {
		if (otherP == null) {
			return false;
		}

		if (otherP instanceof Person) {
			Person p = (Person) otherP;

			if (this.name.equals(p.getName()) && this.age == p.getAge()) {
				return true;
			}
			else return false;
		}
		return false;


	}


}
