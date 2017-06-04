package uk.co.johnjtaylor.sorts;

import uk.co.johnjtaylor.Sort;

public class QuickSort<T extends Comparable<T>> extends Sort<Integer> {

	@Override
	public Object sort(Object input) {
		T[] array = null;
		if(input instanceof Comparable<?>[]) {
			array = (T[]) input;
		}
		
		T[] result = qSort(array, 0, array.length-1);
		return result;
	}
	

	public T[] qSort(T[] array, int lo, int hi) {
		T pivotVal = array[lo];
		Integer left = lo;
		Integer right = hi;
		while(left <= right) {
			while(array[left].compareTo(pivotVal) < 0) {
				left++;
			}
			while(array[right].compareTo(pivotVal) > 0) {
				right--;
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
			qSort(array, lo, right);
		}
		if(left.compareTo(hi) < 0) {
			qSort(array, left, hi);
		}
		
		return array;
	}
}
