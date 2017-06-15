package uk.co.johnjtaylor.events.generic;

import uk.co.johnjtaylor.events.EventImportance;
import uk.co.johnjtaylor.events.EventType;
/**
 * Extended representation of a Tester-Event;
 * Still presented as an abstract class as all appropriate
 * test-based events will implement these abstractions in 
 * their own class definitions. 
 * @author John
 */
public abstract class TesterEvent extends Event {
	private static final long serialVersionUID = -2166632761580844788L;

	/**
	 * @param source Source creating this event (EventObject constr.)
	 * @param type EventType (enum) Representing which specific event occurred
	 * @param importance EventImportance (enum) representing the significance of this event (class constant)
	 */
	public TesterEvent(Object source, EventType type, EventImportance importance) {
		super(source, type, importance);
	}
}
