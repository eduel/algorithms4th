package com.juzi.chapter1_3.demo;

import edu.princeton.cs.algs4.Stack;

//three stack-->n stack
//http://stackoverflow.com/questions/5538192/how-to-implement-a-queue-with-three-stacks
//fuck you,waste time;
public class ThreeStackQueue<T> {

	private Stack<T> stack1 = new Stack<>();
	private Stack<T> stack2 = new Stack<>();
	private Stack<T> pointStack3 = new Stack<>();

	private int n;
	private T cur;

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	public void enqueue(T t) {
		if (isEmpty()) {
			stack1.push(t);
		} else {
			stack2.push(t);
		}

	}

	public T dequeue() {
		return null;
	}

}
