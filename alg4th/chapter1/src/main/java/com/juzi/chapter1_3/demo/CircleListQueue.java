package com.juzi.chapter1_3.demo;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircleListQueue<T> implements IterableAndPrintable<T> {
	private Node last;
	private int n;

	private class Node {
		T t;
		Node next;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	public CircleListQueue<T> enQueue(T t) {
		if (isEmpty()) {
			last = new Node();
			last.t = t;
			last.next = last;
		} else {
			Node newNode = new Node();
			newNode.t = t;
			Node oldFirst = last.next;
			last.next = newNode;
			newNode.next = oldFirst;
			last = newNode;
		}
		n++;
		return this;
	}

	public T deQueue() {
		if (isEmpty())
			throw new NoSuchElementException();
		if (n == 1) {
			T temp = last.t;
			last = null;
			n = 0;
			return temp;
		}
		Node oldFirst = last.next;
		T temp = oldFirst.t;//first;
		last.next = oldFirst.next;
		oldFirst = null;
		n--;
		return temp;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int i = 0;
			Node current = null;

			@Override
			public boolean hasNext() {
				return i < n;
			}

			@Override
			public T next() {
				if (isEmpty())
					throw new NoSuchElementException("has no element");
				if (i == n)
					throw new NoSuchElementException("queue end");
				if (current == null) {
					current = last.next;
				}
				T t = current.t;
				current = current.next;
				i++;
				return t;

			}
		};
	}
}