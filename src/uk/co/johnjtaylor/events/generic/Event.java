package uk.co.johnjtaylor.events.generic;

import java.util.EventObject;

import uk.co.johnjtaylor.events.EventImportance;
import uk.co.johnjtaylor.events.EventType;

public abstract class Event extends EventObject {
	private static final long serialVersionUID = -8983402706390183976L;
	private EventType type;
	private EventImportance importance;

	public Event(Object source, EventType type, EventImportance importance) {
		super(source);
		this.type = type;
		this.importance = importance;
	}
	
	public EventType getEventType() {
		return type;
	}
	
	public EventImportance getEventImportance() {
		return importance;
	}
	
	public abstract String getEventName();
	
}
