package uk.co.johnjtaylor.sorts;

import java.util.Arrays;

import uk.co.johnjtaylor.Sort;
import uk.co.johnjtaylor.Time;
import uk.co.johnjtaylor.events.EventDispatcher;
import uk.co.johnjtaylor.events.sorts.bubble.BubbleSortComparisonEvent;
import uk.co.johnjtaylor.events.sorts.bubble.BubbleSortEndEvent;
import uk.co.johnjtaylor.events.sorts.bubble.BubbleSortStartEvent;
import uk.co.johnjtaylor.events.sorts.bubble.BubbleSortSwapEvent;
import uk.co.johnjtaylor.structures.LinkedListNode;

/**
 * A Simple bubblesort class used as an easy base-line for algorithm testing
 * @author John
 * @param <T> Any type which is Comparable
 *
 */
public class BubbleSort<T extends Comparable<T>> extends Sort<T> {

	/**
	 * Takes an array of any comparable type and sorts it
	 * @param array The array the be sorted
	 */
	public Object sort(Object input, Time timer) {
		if(input instanceof Comparable<?>[]) {
			T[] inArray = (T[]) input;
			return bubbleSortArray(inArray, timer);
		}
		else if(input instanceof LinkedListNode<?>) {
			return bubbleSortLinkedList(input, timer);
		}
		else {
			throw new UnsupportedOperationException(this.getClass().getSimpleName() + " does not support sorts for this data structure(" + input.getClass().getSimpleName() + ")");
		}
	}

	public Object bubbleSortArray(T[] array, Time timer) {
		EventDispatcher.requestInvoke(new BubbleSortStartEvent(this));
		timer.start();
		int swaps;
		if(array instanceof String[]) {
			do {
				swaps = 0;
				String[] strArray = (String[]) array;
				for(int i = 0; i < strArray.length-1; i++) {
					EventDispatcher.requestInvoke(new BubbleSortComparisonEvent(this));
					if(strArray[i].compareToIgnoreCase(strArray[i+1]) > 0) {
						timer.pause();
						EventDispatcher.requestInvoke(new BubbleSortSwapEvent(this));
						timer.unpause();
						String temp = strArray[i+1];
						strArray[i+1] = strArray[i];
						strArray[i] = temp;
						swaps++;
					}
				}
			} while (swaps > 0);
		} else { // Non-string but Comabarable
			do {
				swaps = 0;
				for(int i = 0; i < array.length-1; i++) {
					timer.pause();
					EventDispatcher.requestInvoke(new BubbleSortComparisonEvent(this));
					timer.unpause();
					if(array[i].compareTo(array[i+1]) > 0) {
						timer.pause();
						EventDispatcher.requestInvoke(new BubbleSortSwapEvent(this));
						timer.unpause();
						T temp = array[i+1];
						array[i+1] = array[i];
						array[i] = temp;
						swaps++;
					}
				}
			} while (swaps > 0);
		}
		timer.stop();
		EventDispatcher.requestInvoke(new BubbleSortEndEvent(this));
		return array;
	}

	public Object bubbleSortLinkedList(Object input, Time timer) {
		EventDispatcher.requestInvoke(new BubbleSortStartEvent(this));
		timer.start();
		LinkedListNode<T> head = (LinkedListNode<T>) input;
		LinkedListNode<T> curr = head;
		int swaps;
		do {
			swaps = 0;
			while(curr.getNextNode() != null) {
				LinkedListNode<T> next = curr.getNextNode();
				timer.pause();
				EventDispatcher.requestInvoke(new BubbleSortComparisonEvent(this));
				timer.unpause();
				if(curr.getValue().compareTo(next.getValue()) > 0) {
					timer.pause();
					EventDispatcher.requestInvoke(new BubbleSortSwapEvent(this));
					timer.unpause();
					T currValue = curr.getValue();
					curr.setValue(next.getValue());
					next.setValue(currValue);
					swaps++;
				}
				curr = curr.getNextNode();
			}
			curr = head;
		} while(swaps > 0);
		EventDispatcher.requestInvoke(new BubbleSortEndEvent(this));
		timer.stop();
		return head;
	}

}
