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
		QuickSort<Integer> qs = new QuickSort<>();
		SortTest st = new SortTest(qs, DataStructure.LINKEDLIST, DataType.STRING, 5, "~", 1);
		ArrayList<SortResult> results = t.run(st);
		for(SortResult r : results) {
			System.out.print(r.getSize());
			System.out.print(" | " + r.getTime());
			System.out.print(r.getTimeUnits());
			System.out.print(" | (" + r.getDataStructure() + ")[" + r.getDataType() + "]\n");
			
		}
		
		
		
		
		
		DataGenerator dg = new DataGenerator();/*
		Integer[] array = (Integer[]) dg.makeArray(20, DataType.INTEGER);
		for(Integer s : array) {
			//System.out.println(s);
		}*/
		
		LinkedListNode<Integer> head = dg.makeLinkedList(5, DataType.INTEGER);
		LinkedListNode<Integer> curr = head;
		System.out.println("UNSORTED");
		while(curr.getNextNode() != null) {
			System.out.println(curr.getValue());
			curr = curr.getNextNode();
		}
		System.out.println("~\n~\n~");
		
		BubbleSort<Integer> bs = new BubbleSort<>();
		bs.sort(head);
		
		
		System.out.println("EXEC END");
	}
}
