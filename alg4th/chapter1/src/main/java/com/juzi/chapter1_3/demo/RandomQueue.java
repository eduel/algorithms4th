package com.juzi.chapter1_3.demo;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomQueue<T> implements IterableAndPrintable<T> {

	private T[] items;
	private int n;

	@SuppressWarnings("unchecked")
	public RandomQueue() {
		items = (T[]) new Object[8];
		n = 0;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	public void enqueue(T item) {
		if (n == items.length) {
			resize(items.length * 2);
		}
		items[n++] = item;
	}

	private void resize(int capacity) {
		assert capacity > 0;
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[capacity];
		for (int i = 0; i < n; i++) {
			temp[i] = items[i];
		}
		items = temp;
	}

	public T dequeue() {
		if (isEmpty())
			throw new NoSuchElementException();
		if (n == 1)
			return items[n - 1];

		int a = StdRandom.uniform(n);

		T temp = items[a];
		items[a] = items[n - 1];
		items[n - 1] = null;
		n--;
		if (n >= 0 && n < items.length / 4) {
			resize(items.length / 2);
		}

		return temp;
	}

	public T samle() {
		if (isEmpty())
			throw new NoSuchElementException();
		int a = StdRandom.uniform(n);
		return items[a];
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
				return items[i++];
			}
		};
	}

}
