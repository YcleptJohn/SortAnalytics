package uk.co.johnjtaylor.events.generic;

import java.util.EventObject;

import uk.co.johnjtaylor.events.EventImportance;
import uk.co.johnjtaylor.events.EventType;

/**
 * Base representation of an Event; extended
 * into either a SortEvent type or Tester event to
 * then be further defined into an individual event class.
 * 
 * @author John
 */
public abstract class Event extends EventObject {
	private static final long serialVersionUID = -8983402706390183976L;
	private EventType type;
	private EventImportance importance;

	/**
	 * @param source Source creating this event (EventObject constr.)
	 * @param type EventType (enum) of the event instance
	 * @param importance EventImportance (enum) of the event significance
	 */
	public Event(Object source, EventType type, EventImportance importance) {
		super(source);
		this.type = type;
		this.importance = importance;
	}
	
	/**
	 * @return EventType (enum) representation of which Event this is
	 */
	public EventType getEventType() {
		return type;
	}
	
	/**
	 * @return EventImportance (enum) representation of the significance of the occuring event
	 */
	public EventImportance getEventImportance() {
		return importance;
	}
	
	/**
	 * @return The name of the event that occurred (class name of event)
	 */
	public String getEventName() {
		return this.getClass().getSimpleName();
	}
	
}
