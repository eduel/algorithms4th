package com.juzi.chapter1_3.demo;

import edu.princeton.cs.algs4.Queue;
//edit buffer;
public class Buffer {

	private Queue<Character> qInsert = new Queue<>();
	private Queue<Character> qDelete = new Queue<>();

	public void insert(char c) {
		qInsert.enqueue(c);
	}

	public char delete() {
		char d = qInsert.dequeue();
		qDelete.enqueue(d);
		return d;
	}

	public void left(int k) {
		for (int i = 0; i < k; i++) {
			qDelete.enqueue(qInsert.dequeue());
		}
	}

	public void right(int k) {
		for (int i = 0; i < k; i++) {
			qInsert.enqueue(qDelete.dequeue());
		}
	}

	public int size() {
		return qInsert.size();
	}
}
