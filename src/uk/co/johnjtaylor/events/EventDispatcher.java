package uk.co.johnjtaylor.events;

import java.util.HashMap;

import uk.co.johnjtaylor.events.listeners.ListenerList;
/**
 * Handles Listener registration, de-registration and
 * the dispatching of events
 * @author John
 *
 */
public class EventDispatcher {
	private HashMap<EventType, ListenerList> eventListeners = new HashMap<>();
	
	/**
	 * EventDispatcher Constructor;
	 * Populates the eventListeners HashMap with every possible
	 * event having an empty list of listeners (ListenerList) 
	 * associated with it. 
	 */
	public EventDispatcher() {
		for(EventType evtType : EventType.values()) {
			eventListeners.put(evtType, new ListenerList());
		}
	}
	
	
}
