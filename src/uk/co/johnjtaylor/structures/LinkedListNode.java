package uk.co.johnjtaylor.structures;

public class LinkedListNode<T extends Comparable<T>> {
	private T value;
	private LinkedListNode<T> nextNode;
	
	/**
	 * Construct a new LinkedListNode
	 * @param value Value of the node
	 * @param nextNode The next node of the list
	 */
	public LinkedListNode(T value, LinkedListNode<T> nextNode) {
		this.value = value;
		this.nextNode = nextNode;
	}

	/**
	 * @return the value
	 */
	public T getValue() {
		return value;
	}
	
	/**
	 * @return the nextNode
	 */
	public LinkedListNode<T> getNextNode() {
		return nextNode;
	}
	
	/**
	 * Sets the next node
	 */
	public void setNext(LinkedListNode<T> newNext) {
		this.nextNode = newNext;
	}
	
	
}
