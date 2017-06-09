package uk.co.johnjtaylor.testing;

import org.junit.Before;
import org.junit.Test;

import uk.co.johnjtaylor.DataGenerator;
import uk.co.johnjtaylor.enums.DataType;
import uk.co.johnjtaylor.structures.LinkedListNode;

public class TestDataGenerator <T extends Comparable<T>> {
	DataGenerator<T> dg;

	@Before
	public void setUp() throws Exception {
		dg = new DataGenerator<>();
	}

	
	@Test
	public void testMakeArrayIntegers() {
		T[] array = dg.makeArray(50, DataType.INTEGER);
		assert(array.length == 50);
		assert(array instanceof Integer[]);
	}
	
	@Test
	public void testMakeArrayStrings() {
		T[] array = dg.makeArray(20, DataType.STRING);
		assert(array.length == 20);
		assert(array instanceof String[]);
	}
	
	@Test
	public void testMakeLinkedListIntegers() {
		LinkedListNode<T> head = dg.makeLinkedList(5, DataType.INTEGER);
		LinkedListNode<T> curr = head;
		int length = 0;
		while(curr != null) {
			assert(curr.getValue() instanceof Integer);
			length++;
			curr = curr.getNextNode();
		}
		assert(length == 5);
	}
	
	@Test
	public void testMakeLinkedListStrings() {
		LinkedListNode<T> head = dg.makeLinkedList(5, DataType.STRING);
		LinkedListNode<T> curr = head;
		int length = 0;
		while(curr != null) {
			assert(curr.getValue() instanceof String);
			length++;
			curr = curr.getNextNode();
		}
		assert(length == 5);
	}

}
