package uk.co.johnjtaylor.events.sorts.bubble;

import uk.co.johnjtaylor.events.EventImportance;
import uk.co.johnjtaylor.events.EventType;
import uk.co.johnjtaylor.events.generic.SortEvent;

public class BubbleSortStartEvent extends SortEvent {
	private static final long serialVersionUID = -4600749413952297462L;
	private final EventImportance IMPORTANCE = EventImportance.MEDIUM;

	public BubbleSortStartEvent(Object source, EventType type, EventImportance importance) {
		super(source, type, importance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getEventName() {
		// TODO Auto-generated method stub
		return null;
	}

}
