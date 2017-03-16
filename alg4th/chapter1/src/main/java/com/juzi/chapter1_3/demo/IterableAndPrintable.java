package com.juzi.chapter1_3.demo;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

public interface IterableAndPrintable<T> extends Iterable<T> {

	default void printElements() {
		Iterator<T> iterator = iterator();
		while (iterator.hasNext()) {
			StdOut.print(iterator.next() + " ");
		}
		StdOut.println();
	}

	default void print() {
		forEach(System.out::print);
	}
}
