package uk.co.johnjtaylor;

import java.util.Random;

public class Tester {
	private Random rand = new Random();
	
	public Tester() {
		
	}
	
	/**
	 * Generate an array of given length but only including a chosen range of numbers
	 * @param length Length of the generated array
	 * @param min Minimum number the integer values inside the array can have
	 * @param max Maximum number the integer values inside the array can have
	 */
	public int[] genArray(int length, int min, int max) {
		int[] result = new int[length];
		for(int i = 0; i < length; i++) {
			int nextNum = rand.nextInt((max-min) + 1) + min;
			result[i] = nextNum;
		}
		return result;
	}
	
	
	/**
	 * Generates an array of given length with no min/max
	 * @param length Length of the array
	 */
	public int[] genArray(int length) {
		int[] result = new int[length];
		for(int i = 0; i < length; i++) {
			int nextNum = rand.nextInt();
			result[i] = nextNum;
		}
		return result;
	}
	
	

}
