package uk.co.johnjtaylor.events;

public enum EventImportance {
	LOWEST(1),
	LOW(2),
	MEDIUM(3),
	HIGH(4),
	CRITICAL(5);
	
	private int rank;
	
	private EventImportance(int rank) {
		this.rank = rank;
	}
	
	/**
	 * Returns the ranking for this EventImportance
	 * (Higher ranking = more significant event)
	 * @return
	 */
	public int getRank() {
		return rank;
	}
	
}
