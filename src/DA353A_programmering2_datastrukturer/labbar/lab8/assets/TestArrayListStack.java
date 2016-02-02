/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab8.assets;

import DA353A_programmering2_datastrukturer.labbar.lab5.ArrayListStack;

public class TestArrayListStack {
    public static void main(String[] args) {
        ArrayListStack<Integer> stack = new ArrayListStack<Integer>();
        for (int i = 0; i < 10; i++) {
            stack.push(new Integer(i));
        }
        System.out.println("size=" + stack.size());
        System.out.println("Senast placerad i stacken:");
        System.out.println(stack.peek());
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
