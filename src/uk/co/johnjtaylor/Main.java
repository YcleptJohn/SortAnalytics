package uk.co.johnjtaylor;

import uk.co.johnjtaylor.arrays.QuickSort;

public class Main {
	public static void main(String[] args) {
		Tester t = new Tester();
		/*t.parseScaleString("(n*500)^2+(30*2)", 69);
		System.exit(0);
		BubbleSort<Integer> bub = new BubbleSort<>();
		t.test(bub, 100, "ff", 5);*/
		QuickSort<Integer> qs = new QuickSort<>();
		t.run(qs, 1500, "2", 15);
		System.out.println("EXEC END");
	}
}
