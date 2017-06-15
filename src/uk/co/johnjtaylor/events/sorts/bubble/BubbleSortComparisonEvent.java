package uk.co.johnjtaylor.events.sorts.bubble;

import uk.co.johnjtaylor.events.EventImportance;
import uk.co.johnjtaylor.events.EventType;
import uk.co.johnjtaylor.events.generic.Event;
/**
 * BubbleSortComparison events occur whenever two values
 * are compared via the bubble sorting algorithm. This
 * class is a representation of those events. 
 * @author John
 */
public class BubbleSortComparisonEvent extends Event {
	private static final long serialVersionUID = -8342214094362821912L; // Enforced serializable due to EventObject extension
	private static final EventType TYPE = EventType.BubbleSortComparisonEvent; // Type of event (super constr)
	private static final EventImportance IMPORTANCE = EventImportance.LOWEST; //  Importance of event (super constr)

	/**
	 * Construct a new BubbleSortComparisonEvent instance
	 * @param source The source that is spawning the event (EventObject super constr.)
	 */
	public BubbleSortComparisonEvent(Object source) {
		super(source, TYPE, IMPORTANCE);
	}
	
	
	//TODO: Constructor takes 2 values (or indexes) that are being compared)
	//TODO: values are stored as part of the event's data
}
