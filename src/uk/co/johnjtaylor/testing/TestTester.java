package uk.co.johnjtaylor.testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import uk.co.johnjtaylor.SortResult;
import uk.co.johnjtaylor.SortTest;
import uk.co.johnjtaylor.Tester;
import uk.co.johnjtaylor.enums.DataStructure;
import uk.co.johnjtaylor.enums.DataType;
import uk.co.johnjtaylor.sorts.QuickSort;
import uk.co.johnjtaylor.structures.LinkedListNode;

public class TestTester <T extends Comparable<T>> {
	Tester<T> t;

	@Before
	public void setUp() throws Exception {
		t = new Tester<T>();
	}


	@Test
	public void testValidateSortArray() {
		Integer[] badInts = {2,5,3};
		Integer[] goodInts = {1,2,3};
		String[] badStrings = {"aa", "D", "c", "b"};
		String[] goodStrings = {"Aa", "Bb", "Cc"};
		
		assert(t.validateSort(badInts) == false);
		assert(t.validateSort(badStrings) == false);
		assert(t.validateSort(goodInts) == true);
		assert(t.validateSort(goodStrings) == true);
	}
	
	@SuppressWarnings("unchecked") // Unecessary; direct casts
	@Test
	public void testValidateSortLinkedList() {
		LinkedListNode<T> badTail = new LinkedListNode<T>((T) (Integer) 5, null);
		LinkedListNode<T> badMiddle = new LinkedListNode<T>((T) (Integer) 7, badTail);
		LinkedListNode<T> badHead = new LinkedListNode<T>((T) (Integer) 3, badMiddle);
		
		LinkedListNode<T> goodTail = new LinkedListNode<T>((T) "c", null);
		LinkedListNode<T> goodMiddle = new LinkedListNode<T>((T) "b", goodTail);
		LinkedListNode<T> goodHead = new LinkedListNode<T>((T) "a", goodMiddle);
		
		assert(t.validateSort(badHead) == false);
		assert(t.validateSort(goodHead) == true);
	}

}
