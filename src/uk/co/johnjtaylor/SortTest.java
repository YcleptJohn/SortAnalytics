package uk.co.johnjtaylor;

import java.util.ArrayList;

import uk.co.johnjtaylor.enums.DataStructure;
import uk.co.johnjtaylor.enums.DataType;

/**
 * Represents a Sort to be tested/during testing(i.e storing
 * SortResult objects)
 * @author John
 *
 */
public class SortTest {
	private Sort sort;
	private DataStructure dataStructure;
	private DataType dataType;
	private int initialSize;
	private String scale;
	private int iterations;
	private ArrayList<SortResult> results;
	private Time timer;
	
	/**
	 * Initialise a new SortTest object to represent a sort to 
	 * be tested
	 * @param sort An object that extends the Sort class
	 * @param dataStructure the structure of the data to be sorted (enum)
	 * @param dataType the type of data to be sorted (must be comparable; DataType enum)
	 * @param initialSize Initial input size to the sort
	 * @param scale Scaling factor represented by a transformation of 'n'
	 * @param iterations Number of iterations to be tested
	 */
	public SortTest(Sort sort, DataStructure dataStructure, DataType dataType, int initialSize, String scale, int iterations) {
		this.sort = sort;
		this.dataStructure = dataStructure;
		this.dataType = dataType;
		this.initialSize = initialSize;
		this.scale = scale;
		this.iterations = iterations;
		results = new ArrayList<>();
		this.timer = new Time();
	}
	
	/**
	 * @return the dataStructure of the sort data
	 */
	public DataStructure getDataStructure() {
		return dataStructure;
	}
	
	/**
	 * @return the dataType of the sort
	 */
	public DataType getDataType() {
		return dataType;
	}

	/**
	 * Add a new result to the current list of results
	 * @param newResult
	 */
	public void addResult(SortResult newResult) {
		results.add(newResult);
	}
	
	/**
	 * @return the current list of results
	 */
	public ArrayList<SortResult> getAllResults() {
		return results;
	}

	/**
	 * @return the sort
	 */
	public Sort getSort() {
		return sort;
	}
	
	/**
	 * @return the initialSize
	 */
	public int getInitialSize() {
		return initialSize;
	}
	
	/**
	 * @return the scale
	 */
	public String getScale() {
		return scale;
	}
	
	/**
	 * @return the iterations
	 */
	public int getIterations() {
		return iterations;
	}
	
	/**
	 * @return Time object representing this test's timer
	 */
	public Time getTimer() {
		return timer;
	}
	
	
}
