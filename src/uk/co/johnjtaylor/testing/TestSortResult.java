package uk.co.johnjtaylor.testing;

import org.junit.Before;
import org.junit.Test;

import uk.co.johnjtaylor.SortResult;
import uk.co.johnjtaylor.enums.DataStructure;
import uk.co.johnjtaylor.enums.DataType;

public class TestSortResult {
	SortResult res;

	@Before
	public void setUp() throws Exception {
		res = new SortResult(321, "ms", 10000, DataType.STRING, DataStructure.ARRAY, true);
	}

	@Test
	public void testGetTime() {
		assert(res.getTime() == 321);
	}

	@Test
	public void testGetTimeUnits() {
		assert(res.getTimeUnits().equals("ms"));
	}

	@Test
	public void testGetSize() {
		assert(res.getSize() == 10000);
	}

	@Test
	public void testGetDataType() {
		assert(res.getDataType() == DataType.STRING);
	}

	@Test
	public void testGetDataStructure() {
		assert(res.getDataStructure() == DataStructure.ARRAY);
	}

	@Test
	public void testIsSortCorrect() {
		assert(res.isSortCorrect() == true);
	}

}
