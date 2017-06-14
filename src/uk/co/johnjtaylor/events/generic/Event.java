package uk.co.johnjtaylor.events.generic;

import java.util.EventObject;

import uk.co.johnjtaylor.events.EventType;

public abstract class Event extends EventObject {
	private static final long serialVersionUID = -8983402706390183976L;
	private EventType type;

	public Event(Object source, EventType type) {
		super(source);
		this.type = type;
	}
	
	public EventType getEventType() {
		return type;
	}
	
	public abstract String getEventName();
	public abstract EventImportance getEventImportance();
	
}
