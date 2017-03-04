package com.juzi.chapter1_3.demo;

import java.util.Comparator;
import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

public class List<T> implements Iterable<T> {
	private Node first;
	private Node last;
	private int n;

	private class Node {
		T t;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;//or n==0;
	}

	public int size() {
		return n;
	}

	public List<T> add(T t) {
		if (isEmpty()) {
			first = new Node();
			first.t = t;
			last = first;
			n++;
		} else {
			Node node = new Node();
			node.t = t;
			last.next = node;
			last = node;
			n++;
		}
		return this;
	}

	public List<T> removeAfter(int k) {
		int i = 0;
		NodeIterator nodeIterator = new NodeIterator();
		while (nodeIterator.hasNext()) {
			Node current = nodeIterator.next();
			i++;
			if (i == k) {
				current.next = current.next.next;
				break;
			}
		}
		n--;
		return this;
	}

	public List<T> remove(T key) {
		NodeIterator nodeIterator = new NodeIterator();
		Node previous = null;
		int i = 0;
		while (nodeIterator.hasNext()) {
			Node current = nodeIterator.next();

			if (current.t.equals(key)) {
				if (previous == null) {//first node;
					first = current.next;
					current = null;
				} else {
					previous.next = current.next;
					if (current.next == null) {//last node
						last = previous;
					}
				}
				i++;
			}
			previous = current;
		}
		n = n - i;
		return this;
	}

	public List<T> insertAfter(int k, T t) {
		int i = 0;
		NodeIterator nodeIterator = new NodeIterator();
		while (nodeIterator.hasNext()) {
			Node current = nodeIterator.next();
			i++;
			if (i == k) {
				Node insertNode = new Node();
				insertNode.t = t;
				insertNode.next = current.next;
				current.next = insertNode;
				break;
			}
		}
		n++;
		return this;
	}

	public T max(Comparator<T> comparator) {
		if (isEmpty())
			throw new RuntimeException();
		Iterator<T> t = iterator();
		T max = null;
		while (t.hasNext()) {
			T current = t.next();
			if (max == null)
				max = current;
			boolean isMax = comparator.compare(current, max) > 0;
			if (isMax)
				max = current;
		}
		return max;

	}

	public T max(Comparator<T> comparator, Iterator<T> iterator, T max, T compared) {
		if (!iterator.hasNext())
			return max;
		if (max == null) {
			max = iterator.next();
			return max(comparator, iterator, max, iterator.next());
		}
		boolean isMax = comparator.compare(compared, max) > 0;
		if (isMax) {
			max = compared;
		}
		return max(comparator, iterator, max, iterator.next());

	}

	private class NodeIterator implements Iterator<Node> {
		int i = 0;
		Node current = first;

		@Override
		public boolean hasNext() {
			return i < n;
		}

		@Override
		public List<T>.Node next() {
			Node node = current;
			current = current.next;
			i++;
			return node;
		}

	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int i = 0;
			Node current = first;

			@Override
			public boolean hasNext() {
				return i < n;
			}

			@Override
			public T next() {
				T t = current.t;
				current = current.next;
				i++;
				return t;
			}
		};
	}

	public List<T> printElements() {
		Iterator<T> iterator = iterator();
		while (iterator.hasNext()) {
			T t = iterator.next();
			StdOut.print(t + " ");
		}
		StdOut.println();
		return this;
	}

	public T reserve() {
		Node firstNode = first;
		Node reverseNode = null;
		while (firstNode != null) {
			Node secondNode = firstNode.next;
			firstNode.next = reverseNode;
			reverseNode = firstNode;
			firstNode = secondNode;
		}
		return reverseNode.t;
	}
}
