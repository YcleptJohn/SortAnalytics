package uk.co.johnjtaylor.sorts;

import uk.co.johnjtaylor.Sort;
import uk.co.johnjtaylor.Time;

public class QuickSort<T extends Comparable<T>> extends Sort<Integer> {

	@Override
	public Object sort(Object input, Time timer) {
		T[] array = null;
		if(input instanceof Comparable<?>[]) {
			array = (T[]) input;
		} else {
			throw new UnsupportedOperationException(this.getClass().getName() + " does not support non-array sorts in this version");
		}
		timer.start();
		T[] result = qSort(array, 0, array.length-1, timer);
		timer.stop();
		return result;
	}
	

	public T[] qSort(T[] array, int lo, int hi, Time timer) {
		T pivotVal = array[lo];
		Integer left = lo;
		Integer right = hi;
		while(left <= right) {
			if(array instanceof String[]) { // Current array is Strings
				while(((String) array[left]).compareToIgnoreCase((String) pivotVal) < 0) {
					left++;
				}
				while(((String)array[right]).compareToIgnoreCase((String) pivotVal) > 0) {
					right--;
				}
			}
			else { // Current array is NOT Strings
				while(array[left].compareTo(pivotVal) < 0) {
					left++;
				}
				while(array[right].compareTo(pivotVal) > 0) {
					right--;
				}
			}
			
			if(left.compareTo(right) <= 0) {
				T temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			}
		}
		if(right.compareTo(lo) > 0) {
			qSort(array, lo, right, timer);
		}
		if(left.compareTo(hi) < 0) {
			qSort(array, left, hi, timer);
		}
		
		return array;
	}
}
