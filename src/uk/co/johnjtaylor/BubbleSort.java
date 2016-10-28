package uk.co.johnjtaylor;

/**
 * A Simple bubblesort class used as an easy base-line for algorithm testing
 * @author John
 * @param <T>
 *
 */
public class BubbleSort<T extends Comparable<T>> extends Sort {

	/**
	 * Takes an array of any comparable type and sorts it
	 * @param array The array the be sorted
	 */
	public void sortArray(T[] array) {
	    int swaps;
		do {
		    swaps = 0;
			for(int i = 0; i < array.length-1; i++) {
				if(array[i].compareTo(array[i+1]) > 0) {
					T temp = array[i+1];
					array[i+1] = array[i];
					array[i] = temp;
					swaps++;
				}
			}
		} while (swaps > 0);
	}

}
