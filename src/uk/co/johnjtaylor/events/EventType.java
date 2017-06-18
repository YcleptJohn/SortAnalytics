package uk.co.johnjtaylor.events;

import uk.co.johnjtaylor.events.generic.*;
import uk.co.johnjtaylor.events.sorts.bubble.*;
import uk.co.johnjtaylor.events.listeners.*;

public enum EventType {
	BubbleSortStartEvent {
		@Override
		public void invoke(Event e, Listener l) {
			((BubbleSortListener) l).onStart((BubbleSortStartEvent) e);
		}
	},
	BubbleSortComparisonEvent {
		@Override
		public void invoke(Event e, Listener l) {
			((BubbleSortListener) l).onComparison((BubbleSortComparisonEvent) e);
		}
	},
	BubbleSortSwapEvent {
		@Override
		public void invoke(Event e, Listener l) {
			((BubbleSortListener) l).onSwap((BubbleSortSwapEvent) e);
		}
	},
	BubbleSortEndEvent {
		@Override
		public void invoke(Event e, Listener l) {
			((BubbleSortListener) l).onFinish((BubbleSortEndEvent) e);
		}
	};
	
	public abstract void invoke(Event e, Listener l);
}
