package uk.co.johnjtaylor.testing;

import org.junit.Before;
import org.junit.Test;

import uk.co.johnjtaylor.DataGenerator;
import uk.co.johnjtaylor.Tester;
import uk.co.johnjtaylor.Time;
import uk.co.johnjtaylor.enums.DataType;
import uk.co.johnjtaylor.sorts.BubbleSort;
import uk.co.johnjtaylor.structures.LinkedListNode;

public class TestBubbleSort<T extends Comparable<T>> {
	private DataGenerator<T> dg;
	private BubbleSort<T> sort;
	private Tester<T> t;

	@Before
	public void setUp() throws Exception {
		dg = new DataGenerator<T>();
		sort = new BubbleSort<T>();
		t = new Tester<T>();
	}

	@Test
	public void testBubbleSortArrayIntegers() {
		 T[] intArray = dg.makeArray(50, DataType.INTEGER);
		 Object sortResult = sort.sort(intArray, new Time());
		 assert(t.validateSort(sortResult) == true);
	}
	
	@Test
	public void testBubbleSortArrayStrings() {
		T[] stringArray = dg.makeArray(50, DataType.STRING);
		Object sortResult = sort.sort(stringArray, new Time());
		assert(t.validateSort(sortResult) == true);
	}
	
	@Test
	public void testBubbleSortLinkedListIntegers() {
		LinkedListNode<T> head = dg.makeLinkedList(50, DataType.INTEGER);
		Object sortResult = sort.sort(head, new Time());
		assert(t.validateSort(sortResult) == true);
	}
	
	@Test
	public void testBubbleSortLinkedListStrings() {
		LinkedListNode<T> head = dg.makeLinkedList(50, DataType.STRING);
		Object sortResult = sort.sort(head, new Time());
		assert(t.validateSort(sortResult) == true);
	}

}
