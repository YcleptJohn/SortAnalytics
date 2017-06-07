package uk.co.johnjtaylor.structures;

public abstract class DataStructure<T extends Comparable<T>> {
	abstract public T[] toArray(Object inputData);
}
