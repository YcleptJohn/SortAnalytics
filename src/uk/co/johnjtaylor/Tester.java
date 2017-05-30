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
	 * @throws IllegalArgumentException When the given scale string is an invalud calculation for scaling by 'n'
	 */
	public int parseScaleString(String scale, int n){
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
		System.out.println("LB: " + leftBracketCount);
		System.out.println("RB: " + rightBracketCount);
		System.out.println("#: " + numberCount);
		System.out.println("Op: " + operatorCount);
		
		printArrayList(scalePieces);
		if(leftBracketCount != rightBracketCount) {
			throw new IllegalArgumentException("An unequal number of left and right brackets were given - they must be paired");
		}
		else if(nCount == 0) {
			throw new IllegalArgumentException("Your scale contained no reference to \'n\'(the current size). This is required for a scaling operation.");
		}
		
		// Replace all references to 'n' with the actual value of n
		while(findNext(scalePieces, "n") != null) {
			Integer i = findNext(scalePieces, "n");
			scalePieces.set(i, "" + n);
		}
		boolean complete = false;
		int i = 0;
		while(!complete) {
			String currentPiece = scalePieces.get(i);
			
			while(findNext(scalePieces, "(") != null) {
				Integer leftBracketIndex = findNext(scalePieces, "(");
				Integer rightBracketIndex = findNext(scalePieces, ")", leftBracketIndex);
				if(rightBracketIndex == null) {
					printArrayList(scalePieces);
					throw new IllegalArgumentException("Left bracket with no successive right back found. All brackets must be paired, left to right");
				}
				if((rightBracketIndex - i) != 4) {
					printArrayList(scalePieces);
					throw new IllegalArgumentException("Invalid number of values inside a bracket pair - must contain 2 integer values and an operator between");
				}
				
				String[] bracketCalculation = new String[3];
				int bcIndex = 0;
				for(int j = leftBracketIndex+1; j < rightBracketIndex; j++) {
					bracketCalculation[bcIndex] = scalePieces.get(j);
					bcIndex++;
				}
				
				
				if(!bracketCalculation[1].matches("[+-/*^]")) {
					throw new IllegalArgumentException("Second character inside of a bracket expression was not an operator");
				}
				else if(!(bracketCalculation[0].matches("[0-9]*") && bracketCalculation[2].matches("[0-9]*"))) {
					throw new IllegalArgumentException("The first or last value inside a bracket pair must be an integer value. E.g \'(2+5)\'");
				}
				
				int firstValue = Integer.parseInt(bracketCalculation[0]);
				int secondValue = Integer.parseInt(bracketCalculation[2]);
				Integer bracketResult = null;
				switch(bracketCalculation[1]) {
				case "+": 
					bracketResult = firstValue + secondValue;
				break;
				case "-":
					bracketResult = firstValue - secondValue;
				break;
				case "*":
					bracketResult = firstValue * secondValue;
				break;
				case "/":
					bracketResult = (int) Math.floor(firstValue / secondValue);
				break;
				case "^":
					bracketResult = (int) Math.floor(Math.pow(firstValue, secondValue));
				break;
				}
				System.out.println("br: " + bracketResult);
				
				scalePieces.set(leftBracketIndex, "" + bracketResult);
				scalePieces.remove(leftBracketIndex+1);
				
				
				
				printArrayList(new ArrayList<String>(Arrays.asList(bracketCalculation)));
				
			}
			

			printArrayList(scalePieces);
			i++;
			if(i == scalePieces.size()) { i = 0; }
			complete = true;
		}
		
		
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
	 * Searches a given arraylist for a given character
	 * @param alToSearch The arraylist to be searched through
	 * @param s The character to search for
	 * @return The index of the character if found; Null if not found
	 */
	public Integer findNext(ArrayList<String> alToSearch, String s) {
		return findNext(alToSearch, s, 0);
	}
	
	public Integer findNext(ArrayList<String> alToSearch, String s, int startIndex) {
		for(int i = startIndex; i < alToSearch.size(); i++) {
			if(alToSearch.get(i).equals(s)) {
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
	public void test(Sort sortProgram, int initialLength, String scale, int iterations) {
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
	
}
