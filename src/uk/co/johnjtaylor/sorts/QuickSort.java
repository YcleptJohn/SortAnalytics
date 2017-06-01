package uk.co.johnjtaylor.sorts;

import java.util.Arrays;

import uk.co.johnjtaylor.Sort;

public class QuickSort<T extends Comparable<T>> extends Sort<Integer> {

	@Override
	public Object sort(Object input) {
		Integer[] array = null;
		if(input instanceof Comparable<?>[]) {
			array = (Integer[]) input;
		}
		
		Integer[] result = qSort(array, 0, array.length-1);
		return result;
	}
	
	public void confirmSorted(Integer[] array) {
		boolean sorted = true;
		Integer last = Integer.MIN_VALUE;
		for(int i=0; i < array.length; i++) {
			if(array[i] >= last) {
				last = array[i];
			} else {
				sorted = false;
				System.out.println("INVALID SORT");
			}
		}
		if(sorted) {
			System.out.println("SORT VALID");
		}
	}
	

	public Integer[] qSort(Integer[] array, int lo, int hi) {
		int pivotVal = array[lo];
		int left = lo;
		int right = hi;
		while(left <= right) {
			while(array[left] < pivotVal) {
				left++;
			}
			while(array[right] > pivotVal) {
				right--;
			}
			if(left <= right) {
				Integer temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			}
		}
		if(right > lo) {
			qSort(array, lo, right);
		}
		if(left < hi) {
			qSort(array, left, hi);
		}
		
		return array;
	}
}
