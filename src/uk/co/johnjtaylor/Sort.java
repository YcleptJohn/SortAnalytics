package uk.co.johnjtaylor;


public abstract class Sort<T extends Comparable<T>> {
    public void printArray(T[] array) {
        System.out.print("\n[");
	    for(int i = 0; i < array.length; i++) {
	        if(i == array.length-1) {
	            System.out.print(array[i]);
	        } else {
	            System.out.print(array[i] + ", ");
	        }
	    }
	    System.out.print("]\n");
    }
}
