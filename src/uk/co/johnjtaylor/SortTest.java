package uk.co.johnjtaylor;

import java.util.ArrayList;

/**
 * Represents a Sort to be tested/during testing(i.e storing
 * SortResult objects)
 * @author John
 *
 */
public class SortTest {
	private Sort sort;
	private DataStructure dataStructure;
	private int initialSize;
	private String scale;
	private int iterations;
	private ArrayList<SortResult> results;
	
	/**
	 * Initialise a new SortTest object to represent a sort to 
	 * be tested
	 * @param sort An object that extends the Sort class
	 * @param dataStructure the structure of the data to be sorted (enum)
	 * @param initialSize Initial input size to the sort
	 * @param scale Scaling factor represented by a transformation of 'n'
	 * @param iterations Number of iterations to be tested
	 */
	public SortTest(Sort sort, DataStructure dataStructure, int initialSize, String scale, int iterations) {
		this.sort = sort;
		this.dataStructure = dataStructure;
		this.initialSize = initialSize;
		this.scale = scale;
		this.iterations = iterations;
		results = new ArrayList<>();
	}
	
	/**
	 * @return the dataStructure of the sort data
	 */
	public DataStructure getDataStructure() {
		return dataStructure;
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
	
	
}
