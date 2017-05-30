package uk.co.johnjtaylor.arrays;

import java.util.Arrays;

import uk.co.johnjtaylor.Sort;

/**
 * A Simple bubblesort class used as an easy base-line for algorithm testing
 * @author John
 * @param <T> Any type which is Comparable
 *
 */
public class BubbleSort<T extends Comparable<T>> extends Sort<T> {

	/**
	 * Takes an array of any comparable type and sorts it
	 * @param array The array the be sorted
	 */
	public T[] sortArray(T[] array) {
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
		System.out.println(Arrays.deepToString(array));;
		return array;
	}

}
