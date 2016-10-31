package uk.co.johnjtaylor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class Tester {
	private Random rand;
	private Time timer;
	
	public Tester() {
		rand = new Random();
		timer = new Time();
		
	}
	
	/**
	 * Generate an array of given length but only including a chosen range of numbers
	 * @param length Length of the generated array
	 * @param min Minimum number the integer values inside the array can have
	 * @param max Maximum number the integer values inside the array can have
	 */
	public Integer[] genArray(int length, int min, int max) {
		Integer[] result = new Integer[length];
		for(int i = 0; i < length; i++) {
			Integer nextNum = rand.nextInt((max-min) + 1) + min;
			result[i] = nextNum;
		}
		return result;
	}
	
	
	/**
	 * Generates an array of given length with no min/max
	 * @param length Length of the array
	 */
	public Integer[] genArray(int length) {
		Integer[] result = new Integer[length];
		for(int i = 0; i < length; i++) {
			int nextNum = rand.nextInt();
			result[i] = nextNum;
		}
		return result;
	}
	
	/**
	 * Parses a scale-string, these are used to call tester's test methods with specific
	 * input length scaling functions, e.g "n*2", "n^3", "n+5"
	 * @param scale The scale string to parse
	 * @param n The actual length of the array in use(used as n values in scale formulae)
	 * @return The calculated result which is the next array length to use for testing
	 */
	public int parseScaleString(String scale, int n) {
		scale = scale.trim().toLowerCase();
		String[] scaleArray = scale.split("(?=[*+-/^()])|(?<=[*+-/^()])");
		ArrayList<String> scalePieces = new ArrayList<String>(Arrays.asList(scaleArray));
		
		Iterator<String> it = scalePieces.iterator();
		int leftBracketCount = 0;
		int rightBracketCount = 0;
		int numberCount = 0;
		int operatorCount = 0;
		int nCount = 0;
		while(it.hasNext()) {
			String current = it.next();
			if(current.equals("(")) { 
				leftBracketCount++;
			} 
			else if (current.equals(")")) { 
				rightBracketCount++;
			}
			else if(current.matches("[0-9]*")) {
				numberCount++;
			}
			else if(current.matches("[-+/*^]")) {
				operatorCount++;
			}
			else if(current.equals("n")) {
				nCount++;
			}
		}
		if(leftBracketCount != rightBracketCount) {
			throw new IllegalArgumentException("An unequal number of left and right brackets were given - they must be paired");
		}
		else if(nCount == 0) {
			throw new IllegalArgumentException("Your scale contained no reference to \'n\'(the current size). This is required for a scaling operation.");
		}
		
		
		
		
		
		
		System.out.println("LB: " + leftBracketCount);
		System.out.println("RB: " + rightBracketCount);
		System.out.println("#: " + numberCount);
		System.out.println("Op: " + operatorCount);
		
		printArrayList(scalePieces);
		return 0;
	}
	
	public void printArrayList(ArrayList<String> al) {
		Iterator<String> it = al.iterator();
		System.out.print("[");
		while(it.hasNext()) {
			String current = it.next();
			if(it.hasNext()) {
				System.out.print(current + ", ");
			} else {
				System.out.print(current);
			}
		}
		System.out.print("]\n");
	}
	
	/**
	 * Searches a given array for a given character
	 * @param array The array to be searched through
	 * @param s The character to search for
	 * @return The index of the character if found; Null if not found
	 */
	public Integer findNext(String[] array, String s) {
		return findNext(array, s, 0);
	}
	
	public Integer findNext(String[] array, String s, int startIndex) {
		for(int i = startIndex; i < array.length; i++) {
			if(array[i].equals(s)) {
				return i;
			}
		}
		return null;
	}

	
	/**
	 * Runs and times a sorting algorithm 
	 * 
	 * @param sortProgram A sorting object to be used to sort the array
	 * @param initialLength The initial length of the array used for testing (first iteration length)
	 * @param scale The factor of which to scale the length of the test array based on "n".
	 * 				Where "n" is the current iteration's length. E.g "n*2" with an initial 
	 * 				iteration length of 100 would be 200, then 400, then 800 etc. 
	 * 				Supports single-operator changes of n: n*, n+, n^
	 * @param iterations The amount of test sorts to run
	 */
	public void test(Sort<Integer> sortProgram, int initialLength, String scale, int iterations) {
		System.out.format("%15s%15s%n", "Size", "Time");
		Integer[] array = genArray(initialLength);
		for (int i = 0; i < iterations; i++) {
			timer.start();
			sortProgram.sortArray(array);
			timer.stop();
			System.out.format("%15s%15s%n", array.length, timer.getTime() + "ms");
			array = genArray(array.length * 2);
		}
	}
	
	public static void main(String[] args) {
		Tester t = new Tester();
		t.parseScaleString("(n*500)^2+(30*2)", 50);
		System.exit(0);
	}
}
