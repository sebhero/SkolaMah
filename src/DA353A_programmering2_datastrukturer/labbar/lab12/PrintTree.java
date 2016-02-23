/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab12;

import java.util.Arrays;

/**
 * Created by Sebastian Börebäck on 2016-02-23.
 */
public class PrintTree {

	private Data3[] theHeap;

	private int itemsInArray = 0;

	private int maxSize;

	public PrintTree(int maxSize) {
		this.maxSize = maxSize;

		theHeap = new Data3[maxSize];
	}

	public void insert(int index, Data3 newData) {
		theHeap[index] = newData;
		itemsInArray++;
	}

	public void generateFilledArray(int randNum) {
		Data3 randomData1;

		for (int i = 0; i < maxSize; i++) {
			randomData1 = new Data3((int) (Math.random() * randNum)+1);
			this.insert(i, randomData1);
		}
	}

	/**
	 * -2^n * (-16+2^n)
	 * <p>
	 * <p>
	 * 0.5*(-2+(Math.pow(2,iterator))
	 * <p>
	 * num of rows
	 * Math.pow(2,iterator-1)
	 * <p>
	 * max index per Row
	 * indexToPrint + itemsPerRow
	 * <p>
	 * indent number space number
	 */

	public void printTree(int rows) {
		int spaces = 0;
		int iteration =1;

		while (iteration < rows) {
			int indent = (int) Math.abs(((Math.pow(-2, -iteration)) * (-16 + (Math.pow(2, iteration)))));

			int indexToPrint = (int) (0.5 * (-2 + Math.pow(2, iteration)));

			int itemsPerRow = (int) Math.pow(2, iteration - 1);

			int maxIndexToPrint = indexToPrint+itemsPerRow;

			for (int j = 0; j < indent; j++) {
				System.out.print(" ");
			}

			for (int l = indexToPrint; l < maxIndexToPrint; l++) {
				///print value is list
				System.out.print(theHeap[l].key);


				for (int k = 0; k < spaces; k++) {
					System.out.print(" ");
				}
			}
			spaces = indent;

			iteration++;

			System.out.println();


		}
	}

	public void printTree2(int rows) {
		int spaces = 0;
		int iteration =1;

		int[] indent = getIndentArray(rows);

		while (iteration <= rows) {

			int indexToPrint = (int) (0.5 * (-2 + Math.pow(2, iteration)));

			int itemsPerRow = (int) Math.pow(2, iteration - 1);

			int maxIndexToPrint = indexToPrint+itemsPerRow;


			for (int j = 0; j < indent[iteration-1]; j++) {
				System.out.print(" ");
			}

			for (int l = indexToPrint; l < maxIndexToPrint; l++) {

				if (l < itemsInArray) {

					///print value is list
					System.out.print(String.format("%02d",theHeap[l].key));

					for (int k = 0; k < spaces; k++) {
						System.out.print(".");
					}

				}
			}
			spaces = indent[iteration-1];
			iteration++;
			System.out.println();
		}
	}

	private int[] getIndentArray(int rows) {
		int[] indentArray = new int[rows];


		for (int i = 0; i < rows; i++) {
			indentArray[i] = (int) Math.abs(0.5 * (-2 + Math.pow(2, i+1)));
		}

		Arrays.sort(indentArray);
		indentArray = reverseArray(indentArray);
		return indentArray;
	}

	private int[] reverseArray(int[] theArray) {

		int leftIndex = 0;
		int rightIndex = theArray.length - 1;

		while (leftIndex < rightIndex) {
			int temp = theArray[leftIndex];
			theArray[leftIndex] = theArray[rightIndex];
			theArray[rightIndex] = temp;

			rightIndex--;
			leftIndex++;
		}

		return theArray;
	}

	public static void main(String[] args) {
		System.out.println("OLD tree");

		PrintTree newHeap = new PrintTree(70);

		newHeap.generateFilledArray(90);

		newHeap.printTree2(4);
	}

}

class Data3{
	public  int key;

	public Data3(int key) {
		this.key = key;
	}
}
