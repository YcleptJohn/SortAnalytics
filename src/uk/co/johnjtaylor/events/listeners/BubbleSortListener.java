package uk.co.johnjtaylor.events.listeners;

import uk.co.johnjtaylor.events.sorts.bubble.*;

public interface BubbleSortListener extends Listener {
	public void onStart(BubbleSortStartEvent e);
	public void onComparison(BubbleSortComparisonEvent e);
	public void onSwap(BubbleSortSwapEvent e);
	public void onFinish(BubbleSortEndEvent e);
}
