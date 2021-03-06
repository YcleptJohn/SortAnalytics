package uk.co.johnjtaylor.events;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

import uk.co.johnjtaylor.events.generic.Event;
import uk.co.johnjtaylor.events.listeners.Listener;
import uk.co.johnjtaylor.events.listeners.ListenerList;
/**
 * Handles Listener registration, de-registration and
 * the dispatching of events
 * @author John
 *
 */
public class EventDispatcher {
	private static HashMap<EventType, ListenerList> eventListeners = new HashMap<>();
	private static Queue<Event> eventQueue = new LinkedList<Event>();
	
	/**
	 * EventDispatcher eventListener list construction;
	 * Populates the eventListeners HashMap with every possible
	 * event having an empty list of listeners (ListenerList) 
	 * associated with it. 
	 */
	public static void prepareEventListenerRegister() {
		for(EventType evtType : EventType.values()) {
			eventListeners.put(evtType, new ListenerList());
		}
		//startDispatchingQueuedEvents();
	}
	
	/**
	 * Registers a new listener to a particular type of event
	 * @param event EventType(enum) - The given type of event to attach this listener to
	 * @param listener The event handler/listener to be attached to the given event type
	 */
	public static void registerListener(EventType event, Listener listener) {
		ListenerList currentlisteners = eventListeners.get(event);
		currentlisteners.add(listener); // Update current ListenerList
		eventListeners.remove(event);
		eventListeners.put(event, currentlisteners);
	}
	
	/**
	 * Remove a registered listener from a particular set of events
	 * @param event The event that the target listener is attached to
	 * @param listener The target listener to be removed from this event
	 */
	public static void unregisterListener(EventType event, Listener listener) {
		ListenerList currentListeners = eventListeners.get(event);
		currentListeners.remove(listener);
		eventListeners.remove(event);
		eventListeners.put(event, currentListeners);
	}
	
	public static void requestInvoke(Event e) {
		eventQueue.add(e);
	}
	
	/**
	 * Handles the dispatching of events to all appropriate listeners
	 * @param event the event to dispatch
	 * @deprecated replaced by startDisaptchingQueuedEvents and event queueing methods
	 */
	@Deprecated
	private static synchronized void dispatch(Event event) {
		for(Listener currListener : eventListeners.get(event.getEventType())) {
			event.getEventType().invoke(event, currListener);
		}
	}
	
	private static void startDispatchingQueuedEvents() {
		Timer scheduler = new Timer();
		TimerTask invokeEvents = new TimerTask() {
			@Override
			public void run() {
				if(eventQueue.peek() != null) {
					Event targetEvent = eventQueue.poll();
					for(Listener currListener : eventListeners.get(targetEvent.getEventType())) {
						targetEvent.getEventType().invoke(targetEvent, currListener);
					}
				}
			}
		};
		scheduler.scheduleAtFixedRate(invokeEvents, 0L, 000000000000000000000000000001L);
	}
}
