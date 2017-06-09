package uk.co.johnjtaylor.testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import uk.co.johnjtaylor.Sort;
import uk.co.johnjtaylor.SortResult;
import uk.co.johnjtaylor.SortTest;
import uk.co.johnjtaylor.enums.DataStructure;
import uk.co.johnjtaylor.enums.DataType;
import uk.co.johnjtaylor.sorts.QuickSort;

public class TestSortTest <T extends Comparable<T>> {
	SortTest test;

	@Before
	public void setUp() throws Exception {
		test = new SortTest(
				new QuickSort<T>(),
				DataStructure.LINKEDLIST,
				DataType.FLOAT,
				50,
				"n*2",
				10
				);
	}

	@Test
	public void testGetDataStructure() {
		assert(test.getDataStructure() == DataStructure.LINKEDLIST);
	}

	@Test
	public void testGetDataType() {
		assert(test.getDataType() == DataType.FLOAT);
	}

	@Test
	public void testAddResult() {
		int sizeBefore = test.getAllResults().size();
		try {
			SortResult r = new SortResult(321L, "ms", 10000, DataType.STRING, DataStructure.ARRAY, true);
			test.addResult(r);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception occurred when adding result");
		}
		int sizeAfter = test.getAllResults().size();
		assert(sizeBefore != sizeAfter);
	}

	@Test
	public void testGetAllResults() {
		assertTrue(test.getAllResults().isEmpty());
		SortResult r = new SortResult(321L, "ms", 10000, DataType.STRING, DataStructure.ARRAY, true);
		test.addResult(r);
		ArrayList<SortResult> expectedResult = new ArrayList<>();
		expectedResult.add(r);
		assert(expectedResult.equals(test.getAllResults()));
	}

	@Test
	public void testGetSort() {
		assert(test.getSort() instanceof Sort);
	}

	@Test
	public void testGetInitialSize() {
		assert(test.getInitialSize() == 50);
	}

	@Test
	public void testGetScale() {
		assert(test.getScale().equals("n*2"));
	}

	@Test
	public void testGetIterations() {
		assert(test.getIterations() == 10);
	}

}
