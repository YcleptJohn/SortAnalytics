package uk.co.johnjtaylor;

import java.util.Random;

public class Tester {
	private Random rand = new Random();
	
	public Tester() {
		
	}
	
	public int[] genArray(int length, int min, int max) {
		int[] result = new int[length];
		for(int i = 0; i < length; i++) {
			int nextNum = rand.nextInt((max-min) + 1) + min;
			result[i] = nextNum;
		}
		return result;
	}
	
	

}
