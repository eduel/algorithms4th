package com.juzi.chapter1_3.demo;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GeneralizedListQueue<T> implements IterableAndPrintable<T> {

	private Node first;
	private Node last;
	private int n;

	private class Node {
		T t;
		Node prev;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return n;
	}

	public void insert(T t) {
		if (isEmpty()) {
			first = new Node();
			first.t = t;
			first.prev = null;
			first.next = null;
			last = first;
		} else {
			Node node = new Node();
			node.t = t;
			last.next = node;
			node.prev = last;
			last = node;
		}
		n++;
	}

	public T delete(int k) {
		assert k > 0 && k <= n;
		if (isEmpty())
			throw new NoSuchElementException();
		int s = 0;
		Node toDel = null;
		while (true) {
			if (toDel == null)
				toDel = first;
			else
				toDel = toDel.next;
			s++;
			if (s == k)
				break;
		}
		T ret = toDel.t;
		Node pre = toDel.prev;
		if (pre != null)
			pre.next = toDel.next;
		else
			first = toDel.next;
		if (toDel.next != null)
			toDel.next.prev = toDel.prev;
		else
			last = toDel.prev;
		toDel = null;
		n--;
		return ret;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			Node cur = first;

			@Override
			public boolean hasNext() {
				return cur != null;
			}

			@Override
			public T next() {
				if (isEmpty())
					throw new NoSuchElementException();
				T ret = cur.t;
				cur = cur.next;
				return ret;
			}
		};
	}
}
