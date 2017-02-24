package com.juzi.chapter1_3.demo;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.juzi.Constant;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ResizingArrayBag;
import edu.princeton.cs.algs4.ResizingArrayQueue;
import edu.princeton.cs.algs4.ResizingArrayStack;
import edu.princeton.cs.algs4.StdOut;

public class Stack {
	// No check array bounds
	static class FixedCapacityStackOfString {
		String[] vals;
		int N;

		FixedCapacityStackOfString(int n) {
			super();
			vals = new String[n];
		}

		void push(String val) {
			vals[N++] = val;
		}

		String pop() {
			return vals[--N];
		}

		int size() {
			return N;
		}

		boolean isEmpty() {
			return N == 0;
		}

		public static void main(String[] args) {
			In in = new In(Constant.getParentPath() + "tobe.txt");
			String[] vals = in.readAllStrings();
			int N = vals.length;
			FixedCapacityStackOfString stack = new FixedCapacityStackOfString(N);
			for (int i = 0; i < N; i++) {
				stack.push(vals[i]);
			}
			for (int i = 0; i < N; i++) {
				StdOut.println(stack.pop());
			}
		}
	}

	static class FixedCapacityStack<Item> {
		Item[] items;
		int N;

		@SuppressWarnings("unchecked")
		public FixedCapacityStack(int n) {
			items = (Item[]) new Object[n];
		}

		void push(Item item) {
			items[N++] = item;
		}

		Item pop() {
			return items[--N];
		}

		boolean isEmpty() {
			return N == 0;
		}

		boolean isFull() {
			return items.length == N;
		}

		int size() {
			return N;
		}

		public static void main(String[] args) {
			In in = new In(Constant.getParentPath() + "tobe.txt");
			String[] vals = in.readAllStrings();
			int N = vals.length;
			FixedCapacityStack<String> stack = new FixedCapacityStack<>(N);
			for (int i = 0; i < N; i++) {
				stack.push(vals[i]);
			}
			StdOut.println(stack.isEmpty());
			StdOut.println(stack.size());
			for (int i = 0; i < N; i++) {
				StdOut.println(stack.pop());
			}
		}
	}

	/**
	 * 
	 * @author dsk
	 *
	 * @param <Item>
	 * @see ResizingArrayStack
	 * @see ResizingArrayBag
	 * @see ResizingArrayQueue
	 */
	static class CommonStack<Item> {
		Item[] items;
		int capacity = 10;// capacity%2=0;
		int N;

		@SuppressWarnings("unchecked")
		CommonStack(int initCapacity) {
			this.capacity = initCapacity;
			items = (Item[]) new Object[initCapacity];
		}

		void resize(int max) {
			@SuppressWarnings("unchecked")
			Item[] newItems = (Item[]) new Object[max];
			for (int i = 0; i < N; i++) {
				newItems[i] = items[i];
			}
			items = newItems;
		}

		void push(Item item) {
			if (N == capacity)
				resize(2 * capacity);
			items[N++] = item;
		}

		Item pop() {
			if (isEmpty())
				throw new NoSuchElementException();
			Item item = items[--N];
			items[N] = null;
			if (N > 0 && N == capacity / 4)
				resize(2 / capacity);
			return item;
		}

		boolean isEmpty() {
			return N == 0;
		}

		int size() {
			return N;
		}
	}

	static class ListStack<Item> implements Iterable<Item> {
		Node first;
		int N;

		private class Node {
			Item item;
			Node next;
		}

		boolean isEmpty() {
			return N == 0;
		}

		int size() {
			return N;
		}

		void push(Item item) {
			Node oldFirst = first;
			first = new Node();
			first.item = item;
			first.next = oldFirst;
			first.next = new Node();
			N++;
		}

		Item pop() {
			if (isEmpty())
				throw new NoSuchElementException();
			first = first.next;
			N--;
			return first.item;
		}

		@Override
		public Iterator<Item> iterator() {
			return new Iterator<Item>() {
				Node current = first;

				@Override
				public boolean hasNext() {
					return !isEmpty();
				}

				@Override
				public Item next() {
					Item currentItem = current.item;
					current = first.next;
					return currentItem;
				}
			};
		}

		public static void main(String[] args) {
			ListStack<String> listStack = new ListStack<>();
			listStack.push("n1");
			listStack.push("n2");
			listStack.push("n3");
			Iterator<String> iterator = listStack.iterator();
			while (iterator.hasNext()) {
				String item = iterator.next();
				StdOut.println(item);
			}
		}
	}

}