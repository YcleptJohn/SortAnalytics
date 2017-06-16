package uk.co.johnjtaylor.events;

import java.util.HashMap;

import uk.co.johnjtaylor.events.listeners.Listener;
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
	
	/**
	 * Registers a new listener to a particular type of event
	 * @param event EventType(enum) - The given type of event to attach this listener to
	 * @param listener The event handler/listener to be attached to the given event type
	 */
	public synchronized void registerListener(EventType event, Listener listener) {
		ListenerList listeners = eventListeners.get(event);
		listeners.add(listener); // Update current ListenerList
		eventListeners.remove(event);
		eventListeners.put(event, listeners);
	}
}
