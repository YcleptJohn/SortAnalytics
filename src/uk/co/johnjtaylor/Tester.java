package uk.co.johnjtaylor;

import java.util.Random;

public class Tester {
	private Random rand = new Random();
	
	
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
	
	/**
	 * Convenience method to get the current timestamp
	 * @return The current time in a UNIX timestamp
	 */
	public Long currTime() {
		return System.currentTimeMillis();
	}
	
	/**
	 * Returns the difference between two times (All in milliseconds)
	 * @param startTime The time the algorithm began
	 * @param endTime The time the algorithm finished
	 * @return The difference between start & end time
	 */
	public Long timeDiff(long startTime, long endTime) {
		return endTime - startTime;
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
		int[] array = genArray(initialLength);
		for (int i = 0; i < iterations; i++) {
			
		}
	}
	
	
	

}
