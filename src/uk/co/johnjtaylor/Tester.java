package uk.co.johnjtaylor;

import java.util.ArrayList;
import uk.co.johnjtaylor.enums.DataStructure;

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
				//Object res = test.getSort().sort(array);
				timer.stop();
				test.addResult(new SortResult(timer.getTime(), "ms", array.length, test.getDataType(), test.getDataStructure(), true));
				System.out.println("Result stored");
				
				array = gen.makeArray(array.length * 2, test.getDataType());
			}
			break;
		default:
			System.out.println("Implementation pending for " + test.getDataStructure().toString());
		}
		return test.getAllResults();
	}
	
	
	public boolean validateSort(Object sortedValues, DataStructure ds) {
		
		return false;
	}
	
}
