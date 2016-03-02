/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab13.assets;

import java.net.URL;
import java.text.MessageFormat;
import java.util.*; // HashMap, Iterator
import java.io.*;
import javax.swing.*;

public class Laboration13 {

	public static HashMap<String, String> readFromFile(String filename) throws IOException {
		HashMap<String, String> map = new HashMap<String, String>();
		FileInputStream fis = new FileInputStream(filename);
		InputStreamReader isr = new InputStreamReader(fis, "ISO-8859-1");
		BufferedReader reader = new BufferedReader(isr);
		String str;
		String[] values;
		while ((str = reader.readLine()) != null) {
			values = str.split(",");
			map.put(values[0], values[1]);
		}
		reader.close();
		return map;
	}

	public static void writeToFile(String filename, HashMap<? extends Object, ? extends Object> map) throws IOException {
		FileOutputStream fos = new FileOutputStream(filename);
		OutputStreamWriter osw = new OutputStreamWriter(fos, "ISO-8859-1");
		BufferedWriter writer = new BufferedWriter(osw);
		Iterator<? extends Object> keys = map.keySet().iterator();
		String key;
		while (keys.hasNext()) {
			key = (String) keys.next();
			writer.write(key + "," + map.get(key));
			writer.newLine();
		}
		writer.close();
	}

	public static void printHashMap(HashMap<String, String> map) {
		Iterator<String> keys = map.keySet().iterator();
		String key;
		System.out.println("----------LISTNING---------");
		while (keys.hasNext()) {
			key = keys.next();
			System.out.println(key + ": " + map.get(key));
		}
		System.out.println();
	}

	private void add(HashMap<String, String> map) {
		String theInput=JOptionPane.showInputDialog("Lagg till, ange nyckel och varde seperare med ,");
		String[] inputs = theInput.split(",");
		map.put(inputs[0], inputs[1]);
	}

	private void seek(HashMap<String, String> map) {
		String theInput=JOptionPane.showInputDialog("What are u looking for with key?");
		String found = map.get(theInput);
		System.out.println(MessageFormat.format("Looking for {0} found: {1}", theInput, found));
	}

	private void remove(HashMap<String, String> map) {
		String theInput=JOptionPane.showInputDialog("What do want to remove?");
		String removed = map.remove(theInput);
		System.out.println(MessageFormat.format("Removing {0} result of remove: {1}", theInput, removed));
	}

	public void activity() {
		String menu = "1. Lägg till\n2. Sök\n3. Ta bort\n4. Lista\n5. Spara\n\n0. Avsluta";
		URL filePath = this.getClass().getResource("/files/lexikon.txt");
		int choice = -1;
		try {

			HashMap<String, String> table = readFromFile(filePath.getPath());
			while (choice != 0) {
				do {
					try {
						choice = Integer.parseInt(JOptionPane.showInputDialog(menu));
					} catch (NumberFormatException e) {
						choice = 0;
					}
				} while (choice < 0 || choice > 5);
				switch (choice) {
					case 1:
						add(table);
						break;
					case 2:
						seek(table);
						break;
					case 3:
						remove(table);
						break;
					case 4:
						printHashMap(table);
						break;
					case 5:
						writeToFile(filePath.getPath(), table);
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		Laboration13 lab13 = new Laboration13();
		lab13.activity();
	}
}
