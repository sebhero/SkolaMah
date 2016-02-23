/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab8;

/**
 * Created by seb on 2016-02-03.
 */
public class Upg5 {
	public static void main(String[] args) {
		String txt = "hej";
		LinkedStack2<Character> stack = new LinkedStack2();
		LinkedQueue<Character> que = new LinkedQueue<>();

		for (char theChar : txt.toCharArray()) {
			stack.push(theChar);
			System.out.print(stack.pop());
			que.enqueue(theChar);
			System.out.print(que.dequeue());
		}
//
//		System.out.println("stack "+stack.size());
//
//		while (!stack.isEmpty())
//		{
//			System.out.print(stack.pop());
//		}
//		System.out.println();
//		System.out.println("que");
//		while (!que.isEmpty()){
//			System.out.print(que.dequeue());
//		}


	}
}
