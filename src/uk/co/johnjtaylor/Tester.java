package uk.co.johnjtaylor;

import java.util.ArrayList;
import uk.co.johnjtaylor.structures.DataStructures;
import uk.co.johnjtaylor.structures.LinkedListNode;

public class Tester<T extends Comparable<T>> {
	private Time timer;
	private DataGenerator<T> gen;
	@SuppressWarnings("unused")
	private ScaleParser parser;
	
	public Tester() {
		timer = new Time();
		gen = new DataGenerator<T>();
		parser = new ScaleParser();
	}
	
	/**
	 * Runs and times a sorting algorithm 
	 * 
	 * @param test A SortTest object to be tested as specified
	 */
	public ArrayList<SortResult> run(SortTest test) {
		//TODO throw events to be handled for data printouts etc @ start; sort finish; overall end etc
		switch(test.getDataStructure()) {
		case ARRAY:
			T[] array = gen.makeArray(test.getInitialSize(), test.getDataType());
			for(int i = 0; i < test.getIterations(); i++) {
				timer.start();
				Object res = test.getSort().sort(array);
				timer.stop();
				test.addResult(new SortResult(timer.getTime(), "ms", array.length, test.getDataType(), test.getDataStructure(), true));
				
				array = gen.makeArray(array.length * 2, test.getDataType());
			}
			break;
		case LINKEDLIST:
			LinkedListNode<T> head = gen.makeLinkedList(test.getInitialSize(), test.getDataType());
			int currentLength = test.getInitialSize();
			for(int i = 0; i < test.getIterations(); i++) {
				timer.start();
				Object result = test.getSort().sort(head);
				timer.stop();
				test.addResult(new SortResult(timer.getTime(), "ms", currentLength, test.getDataType(), test.getDataStructure(), true));
				currentLength *= 2;
				
				head = gen.makeLinkedList(currentLength, test.getDataType());
			}
			break;
		default:
			throw new UnsupportedOperationException("Implementation pending for " + test.getDataStructure().toString());
		}
		return test.getAllResults();
	}
	
	
	/**
	 * Validates that a sorting algorithm produced correct results
	 * @param values Any array/custom data structure that implements toArray()
	 * @return true if the sort is valid; false otherwise
	 * @throws UnsupportedOperationException when the values given couldn't be converted to an array
	 */
	public boolean validateSort(Object values) {
		if(values instanceof DataStructures<?>) {
			@SuppressWarnings("unchecked") // Checked as best as possible, can't do a <T> check though so
			DataStructures<T> valueStructure = (DataStructures<T>) values;
			values = valueStructure.toArray(values);
		}
		
		if(values instanceof String[]) {
			String[] valuesToCheck = (String[]) values;
			for(int i=1; i < valuesToCheck.length; i++) {
				if(valuesToCheck[i-1].compareToIgnoreCase(valuesToCheck[i]) > 0) {
					return false;
				}
			}
			return true;
		}
		else if(values instanceof Comparable<?>[]) {
			T[] valuesToCheck  = (T[]) values;
			for(int i=1; i < valuesToCheck.length; i++) {
				if(valuesToCheck[i-1].compareTo(valuesToCheck[i]) > 0) {
					return false;
				}
			}
			return true;
		} else {
			throw new UnsupportedOperationException("The given data couldn't be converted to an array for processing");
		}
	}
	
}
