package uk.co.johnjtaylor.testing;

import org.junit.Before;
import org.junit.Test;

import uk.co.johnjtaylor.DataGenerator;
import uk.co.johnjtaylor.Tester;
import uk.co.johnjtaylor.Time;
import uk.co.johnjtaylor.enums.DataType;
import uk.co.johnjtaylor.sorts.QuickSort;

public class TestQuickSort<T extends Comparable<T>> {
	private DataGenerator<T> dg;
	private QuickSort<T> sort;
	private Tester<T> t;

	@Before
	public void setUp() throws Exception {
		dg = new DataGenerator<T>();
		sort = new QuickSort<T>();
		t = new Tester<T>();
	}

	@Test
	public void testQuickSortArrayIntegers() {
		 T[] intArray = dg.makeArray(50, DataType.INTEGER);
		 Object sortResult = sort.sort(intArray, new Time());
		 assert(t.validateSort(sortResult) == true);
	}
	
	@Test
	public void testQuickSortArrayStrings() {
		T[] stringArray = dg.makeArray(5, DataType.STRING);
		Object sortResult = sort.sort(stringArray, new Time());
		assert(t.validateSort(sortResult) == true);
	}

}
