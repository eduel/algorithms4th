package com.juzi.chapter1_3.demo;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import edu.princeton.cs.algs4.StdOut;

public class SimpleRingBuffer<T> implements IterableAndPrintable<T> {

	private T[] items;
	private volatile int n;
	private int consumeIndex;
	private int produceIndex;
	private volatile boolean full;
	private volatile boolean empty;
	private final int capacity;

	@SuppressWarnings("unchecked")
	public SimpleRingBuffer(int capacity) {
		items = (T[]) new Object[capacity];
		full = false;
		empty = true;
		this.capacity = capacity;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public boolean isFull() {
		return n == capacity;
	}

	public void produce(T t) {
		while(full){
			try {
				StdOut.println("###wait 1s to produce###");
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		items[produceIndex++] = t;
		produceIndex = produceIndex % capacity;
		n++;
		StdOut.println("pd add " + t + " to rb");
		if (empty)
			empty = false;
		if (n == capacity)
			full = true;
	}

	public T consume() {
		while(empty){
			try {
				StdOut.println("###wait 1s to consume###");
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		T t = items[consumeIndex];
		items[consumeIndex] = null;
		consumeIndex++;
		consumeIndex = consumeIndex % capacity;
		n--;
		StdOut.println("cs reduce " + t + " from rb");
		if (full)
			full = false;
		if (n == 0)
			empty = true;
		return t;
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
				T ret = items[(i + produceIndex) % capacity];
				i++;
				return ret;
			}
		};
	}
}
