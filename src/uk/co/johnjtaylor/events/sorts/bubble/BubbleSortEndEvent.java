package uk.co.johnjtaylor.events.sorts.bubble;

import uk.co.johnjtaylor.events.EventImportance;
import uk.co.johnjtaylor.events.EventType;
import uk.co.johnjtaylor.events.generic.SortEvent;
/**
 * Represents the end of a bubble sort across a dataset;
 * (detected via the lack of swaps and then spawned)
 * @author John
 */
public class BubbleSortEndEvent extends SortEvent {
	private static final long serialVersionUID = -8427959870167493795L; // Enforced serializable due to EventObject extension
	private static final EventType TYPE = EventType.BubbleSortEndEvent;
	private static final EventImportance IMPORTANCE = EventImportance.MEDIUM;
	
	/**
	 * @param source The source that is spawning the new instance of this event
	 */
	public BubbleSortEndEvent(Object source) {
		super(source, TYPE, IMPORTANCE);
	}
}
