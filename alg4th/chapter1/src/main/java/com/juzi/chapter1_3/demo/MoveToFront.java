package com.juzi.chapter1_3.demo;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MoveToFront<T> implements IterableAndPrintable<T> {
	private Node first;
	private Node last;
	private int n;

	private class Node {
		T item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;//&n==0;
	}

	public int size() {
		return n;
	}

	public void addToHead(T t) {
		Node nn = new Node();
		nn.item = t;
		nn.next = first;
		first = nn;
		if (isEmpty())
			last = first;
		n++;
	}

	public void addToLast(T t) {
		Node nn = new Node();
		nn.item = t;
		if (isEmpty()) {
			last = nn;
			first = last;
		} else {
			last.next = nn;
			last = nn;
		}
		n++;
	}

	//t must override equals and hashcode;
	public void delete(T t) {
		if (isEmpty())
			throw new NoSuchElementException();
		Node pre = null;
		Node cur = null;
		T curVal = null;
		Iterator<Node> nodeIterator = nodeIterator();
		while (nodeIterator.hasNext()) {
			pre = cur;
			cur = nodeIterator.next();
			curVal = cur.item;
			if (curVal.equals(t))
				break;
		}
		if (pre == null) {//cur = first;
			first = cur.next;
		} else if (cur.next == null) {//cur = last;
			pre.next = cur.next;
			last = pre;
		} else {
			pre.next = cur.next;
		}
		cur = null;
		addToHead(curVal);
		n--;
	}

	private Iterator<Node> nodeIterator() {
		return new Iterator<MoveToFront<T>.Node>() {
			Node cur = first;

			@Override
			public boolean hasNext() {
				return cur != null;
			}

			@Override
			public MoveToFront<T>.Node next() {
				if (isEmpty())
					throw new NoSuchElementException();
				Node nv = cur;
				cur = cur.next;
				return nv;
			}
		};
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
				T curVal = cur.item;
				cur = cur.next;
				return curVal;
			}
		};
	}
}
