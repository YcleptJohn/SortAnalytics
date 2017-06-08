package uk.co.johnjtaylor.structures;

import java.util.ArrayList;

public class LinkedListNode<T extends Comparable<T>> extends DataStructures<T> {
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
	 * Set the value of a LinkedListNode @ runtime
	 * @param val new Value to be set
	 */
	public void setValue(T val) {
		this.value = val;
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

	@SuppressWarnings("unchecked") // It is checked reversely
	@Override
	public T[] toArray(Object inputData) {
		if(!(inputData instanceof LinkedListNode)) {
			throw new IllegalArgumentException("Linked List Node toArray() only accepts Linked List Nodes as input");
		}
		
		LinkedListNode<T> node = (LinkedListNode<T>) inputData;
		ArrayList<T> nodeList = new ArrayList<T>();
		while(node != null) {
			nodeList.add(node.getValue());
			node = node.getNextNode();
		}
		
		return (T[]) nodeList.toArray();
	}
	
	
}
