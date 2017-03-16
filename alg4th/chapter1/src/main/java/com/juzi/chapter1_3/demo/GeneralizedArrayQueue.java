package com.juzi.chapter1_3.demo;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GeneralizedArrayQueue<T> implements IterableAndPrintable<T> {

	private T[] items;
	private int n;

	@SuppressWarnings("unchecked")
	public GeneralizedArrayQueue() {
		items = (T[]) new Object[5];
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	public void insert(T t) {
		if (n == items.length) {
			resize(items.length << 1);
		}
		items[n] = t;
		n++;
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

	public T delete(int k) {
		assert k > 0 && k <= n;
		if (isEmpty())
			throw new NoSuchElementException();
		T ret = items[k - 1];
		for (int i = k; i < n; i++) {
			items[i - 1] = items[i];
			items[i] = null;
		}
		n--;
		if (n > 0 && n < items.length >> 2)
			resize(items.length >> 1);
		return ret;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int s = 0;

			@Override
			public boolean hasNext() {
				return s < n;
			}

			@Override
			public T next() {
				if (isEmpty())
					throw new NoSuchElementException();
				T ret = items[s++];
				return ret;
			}
		};
	}
}
