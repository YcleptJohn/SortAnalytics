package uk.co.johnjtaylor;

import java.util.Random;

import uk.co.johnjtaylor.enums.DataType;
import uk.co.johnjtaylor.structures.LinkedListNode;

/**
 * Generates data to be sorted in different DataStructures 
 * specified by the DataStructure enum
 * @author John
 *
 */
public class DataGenerator<T extends Comparable<T>> {
	private Random rand;
	private static final int DEFAULT_MAX_STRING = 10;
	
	public DataGenerator() {
		rand = new Random();
		rand.setSeed(System.currentTimeMillis());
	}
	
	private Integer getInt() {
		return rand.nextInt();
	}
	
	private Float getFloat() {
		return rand.nextFloat();
	}
	
	private Long getLong() {
		return rand.nextLong();
	}
	
	private String getString(int maxLength) {
		int strLength = rand.nextInt(maxLength);
		String generatedString = "";
		for(int i = 0; i <= strLength; i++) {
			char character;
			int lowAsciiIndex = rand.nextInt((90-65) + 1) + 65;
			int highAsciiIndex = rand.nextInt((122-97) + 1) + 97;
			boolean selector = rand.nextBoolean();
			if(selector) {
				character = (char) lowAsciiIndex;
			} else {
				character = (char) highAsciiIndex;
			}
				
			generatedString += character;
		}
		return generatedString;
	}
	
	/**
	 * Make an array of random data with a given size
	 * and data type. Ignore the minimum/maximum range 
	 * for each generated value
	 * @param size size of data
	 * @param type type of the data (enum)
	 * @return an array of the random data per the size/type given
	 */
	@SuppressWarnings("unchecked") // All casts are checked via 'DataType'; unneeded
	public T[] makeArray(int size, DataType type) {
		T[] array = null;
		switch(type) {
		case INTEGER:
			array = (T[]) new Integer[size];
			break;
		case FLOAT:
			array = (T[]) new Float[size];
			break;
		case LONG:
			array = (T[]) new Long[size];
			break;
		case STRING:
			array = (T[]) new String[size];
			break;
		}
		
		for(int i=0; i < size; i++) {
			T newEntry = null;
			switch(type) {
			case INTEGER:
				newEntry = (T) getInt();
				break;
			case FLOAT:
				newEntry = (T) getFloat();
				break;
			case LONG:
				newEntry = (T) getLong();
				break;
			case STRING:
				newEntry = (T) getString(DEFAULT_MAX_STRING);
				break;
			}
			array[i] = (T) newEntry;
		}
		return array;
	}
	
	
	/**
	 * Returns the head node of a generated LinkedList
	 * of randomised data of the given type + size
	 * @param size number of nodes in list
	 * @param type data type of values (enum)
	 * @return
	 */
	@SuppressWarnings("unchecked") // Already checked via DataType enum
	public LinkedListNode<T> makeLinkedList(int size, DataType type) {
		LinkedListNode<T> head = null;
		LinkedListNode<T> prev = null;
		for(int i=0; i < size; i++) {
			LinkedListNode<T> newNode = null;
			switch(type) {
			case INTEGER:
				newNode = new LinkedListNode<T>((T) getInt(), null);
				break;
			case FLOAT:
				newNode = new LinkedListNode<T>((T) getFloat(), null);
				break;
			case LONG:
				newNode = new LinkedListNode<T>((T) getLong(), null);
				break;
			case STRING:
				newNode = new LinkedListNode<T>((T) getString(DEFAULT_MAX_STRING), null);
				break;
			}
			if(i == 0) {
				head = newNode;
				prev = newNode;
			} else {
				prev.setNext(newNode);
				prev = newNode;
			}
		}
		return head;
	}
}
