/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab8.assets;

import DA353A_programmering2_datastrukturer.labbar.lab8.LinkedQueue;

public class TestLinkedQueue {
    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        System.out.println("size=" + queue.size());
        System.out.println("Först placerad i kön:");
        System.out.println(queue.peek());
        while (!queue.empty()) {
            System.out.print(queue.dequeue() + " ");
        }
    }
}
