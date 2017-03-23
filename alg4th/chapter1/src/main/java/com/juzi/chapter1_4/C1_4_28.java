package com.juzi.chapter1_4;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.Stack;

public class C1_4_28 {

	public static class TwoStackSteque<T> {
		private Stack<T> pushStack = new Stack<>();
		private Stack<T> popStack = new Stack<>();

		public boolean isEmpty() {
			return pushStack.isEmpty() && popStack.isEmpty();
		}

		public int size() {
			return pushStack.size() + popStack.size();
		}

		public void push(T t) {
			pushStack.push(t);
		}

		public void enqueue(T t) {
			while (!pushStack.isEmpty()) {
				popStack.push(pushStack.pop());
			}
			popStack.push(t);
			while (!popStack.isEmpty()) {
				pushStack.push(popStack.pop());
			}
		}

		public T pop() {
			if (isEmpty())
				throw new NoSuchElementException();
			return pushStack.pop();
		}
	}
}
