package com.juzi.chapter1_3.demo;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class ResizingArrayDeque<T> implements Iterable<T> {
	private T[] items;
	private int first;
	private int last;
	private int n;

	@SuppressWarnings("unchecked")
	public ResizingArrayDeque() {
		items = (T[]) new Object[2];
		n = 0;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	@SuppressWarnings("unchecked")
	private void resize(int capacity) {
		assert capacity > 0;
		T[] temp = (T[]) new Object[capacity];
		for (int i = 0; i < n; i++) {
			temp[i] = items[(first + i) % items.length];
		}
		items = temp;
		first = 0;
		last = n;
	}

	public void pushLeft(T t) {
		if (isEmpty()) {
			items[first] = t;
			n++;
			return;
		}
		if (n == items.length) {
			resize(items.length * 2);
		}
		if (first > 0) {
			items[first - 1] = t;
			first--;
		} else {
			items[items.length - 1] = t;
			first = items.length - 1;
		}

		n++;
	}

	public void pushRight(T t) {
		if (isEmpty()) {
			items[last] = t;
			n++;
			return;
		}
		if (n == items.length) {
			resize(items.length * 2);
		}
		if (last == items.length - 1) {
			items[0] = t;
			last = 0;
		} else {
			items[last + 1] = t;
			last++;
		}
		n++;
	}

	public T popLeft() {
		if (isEmpty())
			throw new NoSuchElementException();
		T result = items[first];
		items[first] = null;
		if (first == items.length - 1) {
			first = 0;
		} else {
			first++;
		}
		n--;
		if (n >= 0 && n < items.length / 4) {
			resize(items.length / 2);
		}
		return result;
	}

	public T popRight() {
		if (isEmpty())
			throw new NoSuchElementException();
		T result = items[last];
		items[last] = null;
		if (last == 0) {
			last = items.length - 1;
		} else {
			last--;
		}
		n--;
		if (n >= 0 && n < items.length / 4) {
			resize(items.length / 2);
		}
		return result;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int i = 0;

			@Override
			public boolean hasNext() {
				return i < n;
			}

			@Override
			public T next() {
				if (isEmpty())
					throw new NoSuchElementException();

				T t = items[(first + i) % items.length];
				i++;
				return t;
			}
		};
	}

	public void printElements() {
		Iterator<T> iterator = iterator();
		while (iterator.hasNext()) {
			StdOut.print(iterator.next() + " ");
		}
		StdOut.println();
	}
}
