package uk.co.johnjtaylor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class Tester {
	private Random rand;
	private Time timer;
	private DataGenerator gen;
	
	public Tester() {
		rand = new Random();
		timer = new Time();
		gen = new DataGenerator();
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
			Comparable[] array = gen.makeArray(test.getInitialSize(), test.getDataType());
			for(int i = 0; i < test.getIterations(); i++) {
				timer.start();
				Object res = test.getSort().sort(array);
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
	
}
