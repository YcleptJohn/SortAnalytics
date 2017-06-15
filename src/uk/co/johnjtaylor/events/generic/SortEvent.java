package uk.co.johnjtaylor.events.generic;

import uk.co.johnjtaylor.events.EventImportance;
import uk.co.johnjtaylor.events.EventType;
/**
 * Extended representation of a SortEvent;
 * Still presented as an abstract class as all appropriate
 * sort-based events will implement these abstractions in 
 * their own class definitions. 
 * @author John
 */
public abstract class SortEvent extends Event {
	private static final long serialVersionUID = -6134362372222328200L;

	/**
	 * @param source Source creating this event (EventObject constr.)
	 * @param type EventType (enum) of the event instance
	 * @param importance EventImportance (enum) of the event significance
	 */
	public SortEvent(Object source, EventType type, EventImportance importance) {
		super(source, type, importance);
	}
}
