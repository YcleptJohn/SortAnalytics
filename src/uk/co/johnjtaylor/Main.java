package uk.co.johnjtaylor;

import java.util.ArrayList;

import uk.co.johnjtaylor.enums.DataStructure;
import uk.co.johnjtaylor.enums.DataType;
import uk.co.johnjtaylor.sorts.BubbleSort;
import uk.co.johnjtaylor.sorts.QuickSort;
import uk.co.johnjtaylor.structures.LinkedListNode;

public class Main {
	public static void main(String[] args) {
		Tester t = new Tester();
		/*t.parseScaleString("(n*500)^2+(30*2)", 69);
		System.exit(0);
		BubbleSort<Integer> bub = new BubbleSort<>();
		t.test(bub, 100, "ff", 5);*/
		BubbleSort<Integer> bubble = new BubbleSort<>();
		// QuickSort<Integer> qs = new QuickSort<>();
		SortTest st = new SortTest(bubble, DataStructure.ARRAY, DataType.STRING, 100, "~", 5);
		ArrayList<SortResult> results = t.run(st);
		for(SortResult r : results) {
			System.out.print(r.getSize());
			System.out.print(" | " + r.getTime());
			System.out.print(r.getTimeUnits());
			System.out.print(" | (" + r.getDataStructure() + ")[" + r.getDataType() + "]\n");
		}


		// DataGenerator dg = new DataGenerator();
		// Integer[] array = (Integer[]) dg.makeArray(20, DataType.INTEGER);
		// for(Integer s : array) {
		// 	//System.out.println(s);
		// }


		System.out.println("EXEC END");
		System.exit(0);
	}
}
