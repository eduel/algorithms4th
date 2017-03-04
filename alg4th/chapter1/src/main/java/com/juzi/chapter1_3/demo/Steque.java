package com.juzi.chapter1_3.demo;

import java.util.Iterator;

public class Steque<T> implements Iterable<T> {

	private DoubleLinkedList<T> nestedList = new DoubleLinkedList<>();

	public Steque<T> push(T t) {
		DoubleLinkedList.insertAfterLast(nestedList, t);
		return this;
	}

	public T pop() {
		T poped = DoubleLinkedList.removeFromLast(nestedList);
		return poped;
	}

	public Steque<T> enqueue(T t) {
		DoubleLinkedList.insertBeforeFirst(nestedList, t);
		return this;
	}

	@Override
	public Iterator<T> iterator() {
		return nestedList.iterator();
	}

	public void printElement() {
		DoubleLinkedList.printElements(nestedList);
	}

}
