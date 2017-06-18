package uk.co.johnjtaylor;

public abstract class Sort<T extends Comparable<T>> {
	
	abstract public Object sort(Object inputData, Time timer);
	
}
