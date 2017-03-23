package com.juzi.chapter1_4;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.Stack;

public class C1_4_26 {

	public static class TwoStackQueue<T> {
		private Stack<T> enqueueStack = new Stack<>();
		private Stack<T> dequeueStack = new Stack<>();

		public boolean isEmpty() {
			return enqueueStack.isEmpty() && dequeueStack.isEmpty();
		}

		public int size() {
			return enqueueStack.size() + dequeueStack.size();
		}

		public void enqueue(T t) {
			if (dequeueStack.isEmpty())
				enqueueStack.push(t);
			else {
				while (!dequeueStack.isEmpty()) {
					enqueueStack.push(dequeueStack.pop());
				}
				enqueueStack.push(t);
			}
		}

		public T dequeue() {
			T ret = null;
			if (enqueueStack.isEmpty()) {
				if (dequeueStack.isEmpty()) {
					throw new NoSuchElementException();
				}
				ret = dequeueStack.pop();
			} else {
				while (!enqueueStack.isEmpty()) {
					dequeueStack.push(enqueueStack.pop());
				}
				ret = dequeueStack.pop();
			}
			return ret;
		}
	}
}
