package uk.co.johnjtaylor.events.sorts.bubble;

import uk.co.johnjtaylor.events.EventImportance;
import uk.co.johnjtaylor.events.EventType;
import uk.co.johnjtaylor.events.generic.SortEvent;
/**
 * Represents the start of a new bubble sort
 * @author John
 */
public class BubbleSortStartEvent extends SortEvent {
	private static final long serialVersionUID = -4600749413952297462L;
	private static final EventType TYPE = EventType.BubbleSortStartEvent;
	private static final EventImportance IMPORTANCE = EventImportance.MEDIUM;
	
	/**
	 * Spawn a new BubbleSortStartEvent instance
	 * @param source The source that is spawning the event (EventObject super constr.)
	 */
	public BubbleSortStartEvent(Object source) {
		super(source, TYPE, IMPORTANCE);
	}
}
