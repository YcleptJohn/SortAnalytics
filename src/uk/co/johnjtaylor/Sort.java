package uk.co.johnjtaylor;

import java.util.Arrays;

public abstract class Sort<T extends Comparable<T>> {
	
    public void printArray(T[] array) {
        System.out.println(Arrays.toString(array));
    }
    
}
