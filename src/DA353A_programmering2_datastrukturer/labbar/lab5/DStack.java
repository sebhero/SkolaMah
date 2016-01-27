/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab5;

public interface DStack {
    public void push(Double element);
    public Double pop();
    public Double peek();
    public boolean isEmpty();
    public int size();
}

