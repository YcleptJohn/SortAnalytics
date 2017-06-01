package uk.co.johnjtaylor.structures;

public class LinkedListNode<T extends Comparable<T>> {
	private T value;
	private LinkedListNode nextNode;
	
	/**
	 * Construct a new LinkedListNode
	 * @param value Value of the node
	 * @param nextNode The next node of the list
	 */
	public LinkedListNode(T value, LinkedListNode nextNode) {
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
	public LinkedListNode getNextNode() {
		return nextNode;
	}
	
	
}
