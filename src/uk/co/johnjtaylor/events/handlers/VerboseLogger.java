package uk.co.johnjtaylor.events.handlers;

import uk.co.johnjtaylor.events.listeners.BubbleSortListener;
import uk.co.johnjtaylor.events.listeners.QuickSortListener;
import uk.co.johnjtaylor.events.listeners.TesterListener;
import uk.co.johnjtaylor.events.sorts.bubble.BubbleSortComparisonEvent;
import uk.co.johnjtaylor.events.sorts.bubble.BubbleSortEndEvent;
import uk.co.johnjtaylor.events.sorts.bubble.BubbleSortStartEvent;
import uk.co.johnjtaylor.events.sorts.bubble.BubbleSortSwapEvent;

public class VerboseLogger implements BubbleSortListener, QuickSortListener, TesterListener {

	@Override
	public void onStart(BubbleSortStartEvent e) {
		System.out.println("Bubble sort started");
	}

	@Override
	public void onComparison(BubbleSortComparisonEvent e) {
		System.out.println("Bubble sort comparison occurred");
	}

	@Override
	public void onSwap(BubbleSortSwapEvent e) {
		System.out.println("bubble sort swap occurred");
	}

	@Override
	public void onFinish(BubbleSortEndEvent e) {
		System.out.println("Bubble sort finished");
	}

}
