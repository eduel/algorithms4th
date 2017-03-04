package com.juzi.chapter1_3.demo;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class DoubleLinkedList<T> implements Iterable<T> {
	private static class DoubleNode<T> {
		T val;
		DoubleNode<T> previous;
		DoubleNode<T> next;

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			T prev = previous == null ? null : previous.val;
			T nex = next == null ? null : next.val;
			String result = "[" + prev + "<-【" + val + "】->" + nex + "]";
			return result;
		}
	}

	private DoubleNode<T> first;
	private DoubleNode<T> last;
	private int n;

	public static <T> DoubleLinkedList<T> insertBeforeFirst(DoubleLinkedList<T> list, T t) {
		DoubleNode<T> newNode = new DoubleNode<>();
		newNode.val = t;
		if (list.isEmpty()) {
			list.first = newNode;
			list.last = list.first;
		} else {
			newNode.next = list.first;
			list.first.previous = newNode;
			list.first = newNode;
		}
		list.n++;
		return list;
	}

	public static <T> void insertAfterLast(DoubleLinkedList<T> list, T t) {
		DoubleNode<T> newNode = new DoubleNode<>();
		newNode.val = t;
		if (list.isEmpty()) {
			list.first = newNode;
			list.last = list.first;
		} else {
			newNode.previous = list.last;
			list.last.next = newNode;
			list.last = newNode;
		}
		list.n++;
	}

	public static <T> T removeFromFirst(DoubleLinkedList<T> list) {
		if (list.isEmpty()) {
			throw new NoSuchElementException("no elements");
		}
		DoubleNode<T> newFirst = list.first.next;
		T removed = list.first.val;
		if (newFirst == null) {//only one element;
			list.first = null;
		} else {
			newFirst.previous = null;
			list.first.next = null;
			list.first = null;
			list.first = newFirst;
		}
		list.n--;
		return removed;
	}

	public static <T> T removeFromLast(DoubleLinkedList<T> list) {
		if (list.isEmpty()) {
			throw new NoSuchElementException();
		}
		DoubleNode<T> newLast = list.last.previous;
		T moved = list.last.val;
		if (newLast == null) {//only one element;
			list.last = null;
			list.first = null;
		} else {
			newLast.next = null;
			list.last = null;
			list.last = newLast;
		}
		list.n--;
		return moved;
	}

	public static <T> void insertBefore(DoubleLinkedList<T> list, int n, T t) {
		assert n > 0 && n <= list.size();
		if (n == 1){
			insertBeforeFirst(list, t);
			return;
		}
		NodeIterator<T> nodeIterator = new NodeIterator<>(list);
		int j = 0;
		while (nodeIterator.hasNext()) {
			DoubleNode<T> node = nodeIterator.next();
			j++;
			if (j == n) {
				DoubleNode<T> newNode = new DoubleNode<>();
				newNode.val = t;
				newNode.previous = node.previous;
				newNode.next = node;
				node.previous.next = newNode;
				node.previous = newNode;
				break;
			}
		}
		list.n++;
	}

	public static <T> void insertAfter(DoubleLinkedList<T> list, int n, T t) {
		assert n > 0 && n <= list.size();
		if (n == list.size()) {
			insertAfterLast(list, t);
			return;
		}
		NodeIterator<T> nodeIterator = new NodeIterator<>(list);
		int j = 0;
		while (nodeIterator.hasNext()) {
			DoubleNode<T> node = nodeIterator.next();
			j++;
			if (j == n) {
				DoubleNode<T> newNode = new DoubleNode<>();
				newNode.val = t;
				newNode.previous = node;
				newNode.next = node.next;
				node.next.previous = newNode;
				node.next = newNode;
				break;
			}
		}
		list.n++;
	}

	public static <T> T remove(DoubleLinkedList<T> list, int n) {
		assert n > 0 && n <= list.size();

		NodeIterator<T> nodeIterator = new NodeIterator<>(list);
		if (n == 1)
			return removeFromFirst(list);
		if (n == list.size())
			return removeFromLast(list);
		int j = 0;
		T removed = null;
		while (nodeIterator.hasNext()) {
			DoubleNode<T> node = nodeIterator.next();
			j++;
			if (j == n) {
				removed = node.val;
				node.previous.next = node.next;
				node.next.previous = node.previous;
				node.previous = null;
				node.next = null;
				node = null;
				break;
			}
		}
		list.n--;
		return removed;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	private static class NodeIterator<T> implements Iterator<DoubleNode<T>> {
		int i = 0;
		DoubleNode<T> current = null;
		DoubleLinkedList<T> list;

		public NodeIterator(DoubleLinkedList<T> list) {
			this.list = list;
		}

		@Override
		public boolean hasNext() {

			return i < list.n;
		}

		@Override
		public DoubleNode<T> next() {
			if (list.isEmpty()) {
				throw new NoSuchElementException();
			}
			DoubleNode<T> result = null;
			if (current == null) {
				result = list.first;
				current = list.first;
			} else {
				result = current;
			}
			current = current.next;
			i++;
			return result;
		}

	}

	public static <T> void printElements(DoubleLinkedList<T> list) {
		NodeIterator<T> nodeIterator = new NodeIterator<>(list);
		while (nodeIterator.hasNext()) {
			DoubleNode<T> node = nodeIterator.next();
			StdOut.print(node + " ");
		}
		StdOut.println();
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int i = 0;
			DoubleNode<T> current = null;

			@Override
			public boolean hasNext() {
				return i < n;
			}

			@Override
			public T next() {
				if (isEmpty())
					throw new NoSuchElementException();
				T t = null;
				if (current == null) {
					t = first.val;
					current = first.next;
				} else {
					t = current.val;
					current = current.next;
				}
				i++;
				return t;
			}
		};
	}
}
