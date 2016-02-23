/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab5;

import java.util.*;
import java.util.Stack;

public class DynamicString implements Comparable<DynamicString> {

	private char[] chars;

	private int length;

	public DynamicString() {
		chars = new char[10];
	}

	public DynamicString(DynamicString str) {
		chars = Arrays.copyOf(str.chars, str.length);
		length = str.length;
	}

	public DynamicString(String str) {
		chars = str.toCharArray();
		length = chars.length;
	}

	public void add(char chr) {
		add(length, chr);
	}

	public void add(int index, char chr) {
		checkIndex(index, length);
		if (length == chars.length) {
			chars = Arrays.copyOf(chars, chars.length * 2);
		}
		for (int i = length; i > index; i--) {
			chars[i] = chars[i - 1];
		}
		chars[index] = chr;
		length++;


//		value = Arrays.copyOf(value, newCapacity);
	}

	public void remove(int index) {
		checkIndex(index, length - 1);
		for (int i = index + 1; i < length; i++) {
			chars[i - 1] = chars[i];
		}
		length--;
	}

	public String toString() {
		return new String(chars, 0, length);
	}

	// tas upp på föreläsning 14
	public int hashCode() {
		int hash = 0;
		for (int i = 0; i < length; i++) {
			hash = 31 * hash + chars[i];
		}
		return hash;
	}

	// kontroll av index
	private void checkIndex(int index, int max) {
		if (index < 0 || index > max) {
			throw new IndexOutOfBoundsException("index: " + index + ", range: 0-" + max);
		}
	}

	public int length() {
		return length;
	}

	public char charAt(int index) {
		if (index < length) {
			return chars[index];
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	public void removeAll() {
		chars = new char[10];
		length = 0;
	}

	public int indexOf(char chr) {
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == chr) {
				return i;
			}
		}
		return -1;
	}

	public DynamicString subString(int start) {
		return subString(start, length);
	}

	public DynamicString subString(int start, int end) {
		if (start < 0 || end > length || start > end) {
			throw new IndexOutOfBoundsException();
		}
		if (start == end) {
			return new DynamicString();
		}
		DynamicString temp = new DynamicString();
		for (int i = start; i < end; i++) {
			temp.add(chars[i]);
		}
		return temp;
	}

	/**
	 * Add string to the end of the current string
	 *
	 * @param str the new string
	 */
	public void concat(DynamicString str) {
		int size = str.length();
		DynamicString tmp = new DynamicString(str);
		//i < str.length()
		for (int i = 0; i < tmp.length(); i++) {
			add(tmp.charAt(i));
		}
	}


	@Override
	public int compareTo(DynamicString anotherString) {

//		int res = 0;
//		int len = Math.min(length, anotherString.length);
//		for(int i=0; i<len && res==0; i++) {
//			if(chars[i]<anotherString.chars[i])
//				res = -1;
//			else if(chars[i]>anotherString.chars[i])
//				res = 1;
//		}
//		if(res==0) {
//			res = length-anotherString.length;
//		}
//		return res;

		int len1 = this.length;
		int len2 = anotherString.length;
		int lim = Math.min(len1, len2);
		char v1[] = chars;
		char v2[] = anotherString.chars;

		int k = 0;
		while (k < lim) {
			char c1 = v1[k];
			char c2 = v2[k];
			if (c1 != c2) {
				return c1 - c2;
			}
			k++;
		}
		return len1 - len2;
	}


	@Override
	public boolean equals(Object obj) {
		//return super.equals(obj);
		if (obj instanceof DynamicString) {
			if (this.compareTo((DynamicString) obj) == 0) {
				return true;
			}
			return false;
		} else
			return false;
	}

	public static void main(String[] args) {

		//chars keeps track of all the chars in the string

		//is the size of the string. standard is either 10 or the length
		//of the input string
		//is the size of the array

		//char {S t u d e n t} length 7
		//DynamicString ds2 = new DynamicString("Student");

		//add its dubbles the size and shift the chars down to the first half
		// when you do a add length increases with 1
		//G add uses length as position where to place the char.
		// which is the last position. so the letter ends up at the end.

		//H the loop in remove is for shifting the chars down 1.

		//chars ="" lenght = 10
		DynamicString ds1 = new DynamicString();            // ds1 -> DynamicString med längden 0
		//chars {'H','e','j',' ','L','i','s','a','!'} length 14
		DynamicString ds2 = new DynamicString("Hej Lisa!"); // ds2 -> DynamicString med 'H','e','j',' ','L','i','s','a','!'
		//chars {'H','e','j',' ','L','i','s','a','!'} length 14 samma som ds2
		DynamicString ds3 = new DynamicString(ds2);         // ds3 -> DynamicString med 'H','e','j',' ','L','i','s','a','!'
		System.out.println("ds1: " + ds1);
		System.out.println("ds2: " + ds2);
		System.out.println("ds3: " + ds3);
		ds1.add('J');                                       // ds1 -> 'J'
		ds1.add('a');                                       // ds1 -> 'J','a'
		ds1.add('a');                                       // ds1 -> 'J','a','a'
		ds1.add(2, 'v');                                     // ds1 -> 'J','a','v','a'
		ds2.remove(4);                                      // ds2 -> 'H','e','j',' ','i','s','a','!'
		ds2.remove(4);                                      // ds2 -> 'H','e','j',' ','s','a','!'
		System.out.println("ds1: " + ds1);
		System.out.println("ds2: " + ds2);
		System.out.println("ds3: " + ds3);


		System.out.println("size " + ds2.length());
		ds2.concat(ds2);
		System.out.println(ds2);
		System.out.println("size " + ds2.length());

//		DynamicString test = new DynamicString("Hello");
//		DynamicString test2 = test.subString(0,4);
//		test2.concat(new DynamicString(" yeah!"));
//		System.out.println(test2);
//		System.out.println(test2.compareTo(test));

		DynamicString dss1 = new DynamicString("hej");
		DynamicString dss2 = new DynamicString("hej");
		DynamicString dss3 = new DynamicString("hejda");
		String str = "asd";
		System.out.println(dss1.equals(dss2));
		System.out.println(dss1.equals(str));
		System.out.println(dss1.equals(dss3));


	}


}
