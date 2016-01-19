/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

/*
 * TestP1.java
 *
 * Created 26/9 - 2012
 */
package DA339A_programmering1.Patterns.p1;

import java.lang.reflect.*;

import javax.swing.*;

/*
 * TestP1.java
 * Testprogram för metoderna i Programmeringsuppgift 1
 * @author Rolf Axelsson
 **/
public class TestP1 {

	public static void runMethod(String methodName) throws Exception {
		Class cls = Class.forName("DA339A_programmering1.Patterns.skola.uppgifter.upg1.Exercise1");
		Constructor constructor = cls.getConstructor();
		Object exercise1 = constructor.newInstance();
		Method method = cls.getDeclaredMethod(methodName);
		method.invoke(exercise1);
		System.out.println(" " + methodName + " exekverad");
	}

	public static void main(String[] args) {
		String menu = "Välj den metod som ska exekveras:\n\n"
				+ "1.  Test av Uppgift 1a\n" + "2.  Test av Uppgift 1b\n"
				+ "3.  Test av Uppgift 1c\n" + "4.  Test av Uppgift 1d\n"
				+ "5.  Test av Uppgift 1e\n" + "6.  Test av Uppgift 1f\n"
				+ "0.  Avsluta programmet\n\n" + "Ange ditt val";
		int choice = -1;
		while (choice != 0) {
			try {
				switch (choice) {
				case 1:
					runMethod("exercise1a");
					break;
				case 2:
					runMethod("exercise1b");
					break;
				case 3:
					runMethod("exercise1c");
					break;
				case 4:
					runMethod("exercise1d");
					break;
				case 5:
					runMethod("exercise1e");
					break;
				case 6:
					runMethod("exercise1f");
					break;
				}
				choice = Integer.parseInt(JOptionPane.showInputDialog(menu));
			} catch (Exception e) {
				System.out.println(e);
				choice = -1;
			}
		}
	}
}
