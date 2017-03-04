package com.juzi.chapter1_3.demo;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

public class RandomBag<T> implements IterableAndPrintable<T> {
	private T[] items;
	private int n;

	@SuppressWarnings("unchecked")
	public RandomBag() {
		items = (T[]) new Object[10];
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	public void add(T t) {
		if (n == items.length) {
			resize(items.length * 2);
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

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int i = 0;
			int[] k = new int[n];

			@Override
			public boolean hasNext() {
				return i < n;
			}

			@Override
			public T next() {
				int j = StdRandom.uniform(0, n);
				T t = null;
				if (k[j] == 0) {
					t = items[j];
					k[j] = 1;
					i++;
				} else {
					return next();
				}
				return t;

			}
		};
	}
}
