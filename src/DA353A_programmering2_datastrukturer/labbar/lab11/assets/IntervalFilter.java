/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab11.assets;

public class IntervalFilter implements Filter<Integer> {
    private int min;
    private int max;
    
    public IntervalFilter(int min, int max) {
        this.min = min;
        this.max = max;
    }
    
    public boolean accept( Integer element ) {
        int value = element.intValue();
        return (min<=value) && (value<=max);
    }
}
