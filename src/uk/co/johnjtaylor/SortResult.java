package uk.co.johnjtaylor;

public class SortResult {
	private long time;
	private String timeUnits;
	private int size;
	private String dataType;
	private DataStructure dataStructure;
	private boolean sortCorrectness;
	
	/**
	 * Initialise a new sortResult with appropriate values
	 * @param time 
	 * @param timeUnits
	 * @param size Size of data input
	 * @param dataType
	 * @param dataStructure
	 * @param sortCorrectness
	 */
	public SortResult(long time, String timeUnits, int size, String dataType, DataStructure dataStructure,
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
	public String getDataType() {
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
