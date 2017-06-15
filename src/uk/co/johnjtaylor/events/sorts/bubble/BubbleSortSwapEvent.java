package uk.co.johnjtaylor.events.sorts.bubble;

import uk.co.johnjtaylor.events.EventImportance;
import uk.co.johnjtaylor.events.EventType;
import uk.co.johnjtaylor.events.generic.SortEvent;

/**
 * Represents the occurrence of a swap during a 
 * bubble sort
 * @author John
 */
public class BubbleSortSwapEvent extends SortEvent {
	private static final long serialVersionUID = -2878743748757999887L; // Required due to serializable extension via EventObject
	private static final EventType TYPE = EventType.BubbleSortSwapEvent;
	private static final EventImportance IMPORTANCE = EventImportance.LOW;

	/**
	 * Constructs a new BubbleSortSwapEvent instance
	 * @param source The source that is spawning the event (EventObject super constr.)
	 */
	public BubbleSortSwapEvent(Object source) {
		super(source, TYPE, IMPORTANCE);
	}

	
	//TODO: store the values (or indexes) swapped and potentially a pre/post representation of the entire datasets
}
