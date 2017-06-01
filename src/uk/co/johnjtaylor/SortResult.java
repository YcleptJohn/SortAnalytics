package uk.co.johnjtaylor;

import uk.co.johnjtaylor.enums.DataStructure;
import uk.co.johnjtaylor.enums.DataType;

public class SortResult {
	private long time;
	private String timeUnits;
	private int size;
	private DataType dataType;
	private DataStructure dataStructure;
	private boolean sortCorrectness;
	
	/**
	 * Initialise a new sortResult with appropriate values
	 * @param time time taken
	 * @param timeUnits measurement unit of time
	 * @param size Size of data input
	 * @param dataType Type of data (enum)
	 * @param dataStructure Structure of data (enum)
	 * @param sortCorrectness Valid sort?
	 */
	public SortResult(long time, String timeUnits, int size, DataType dataType, DataStructure dataStructure,
			boolean sortCorrectness) {
		this.time = time;
		this.timeUnits = timeUnits;
		this.size = size;
		this.dataType = dataType;
		this.dataStructure = dataStructure;
		this.sortCorrectness = sortCorrectness;
	}
	
	
	/**
	 * @return the time
	 */
	public long getTime() {
		return time;
	}
	
	/**
	 * @return the timeUnits
	 */
	public String getTimeUnits() {
		return timeUnits;
	}
	
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * @return the dataType
	 */
	public DataType getDataType() {
		return dataType;
	}
	
	/**
	 * @return the dataStructure
	 */
	public DataStructure getDataStructure() {
		return dataStructure;
	}
	
	/**
	 * @return the sortCorrectness
	 */
	public boolean isSortCorrect() {
		return sortCorrectness;
	}
	

}
