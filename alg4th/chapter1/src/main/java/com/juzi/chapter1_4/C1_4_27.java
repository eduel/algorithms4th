package com.juzi.chapter1_4;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.Queue;

public class C1_4_27 {

	public static class QueueStack<T> {
		private Queue<T> queue = new Queue<>();

		public boolean isEmpty() {
			return queue.isEmpty();
		}

		public int size() {
			return queue.size();
		}

		public void push(T t) {
			queue.enqueue(t);
		}

		public T pop() {
			if (isEmpty())
				throw new NoSuchElementException();
			int s = size();
			for (int i = 0; i < s - 1; i++) {
				queue.enqueue(queue.dequeue());
			}
			return queue.dequeue();
		}
	}
}
