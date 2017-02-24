package com.juzi.chapter1_3.demo;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class Queue {

	// FIFO
	static class CommonQueue<Item> implements Iterable<Item> {
		//first==null,then last is null;
		Node first;
		Node last;
		int N;

		private class Node {
			private Item item;
			private Node next;
		}

		boolean isEmpty() {
			return first == null;//N==0
		}

		int size() {
			return N;
		}

		void enqueue(Item item) {
			Node oldLast = last;
			last = new Node();
			last.item = item;
			last.next = null;
			if (isEmpty()) {// oldLast ==null;
				first = last;
			} else {
				oldLast.next = last;
			}
			N++;
		}

		Item dequeue() {
			if (isEmpty())
				throw new NoSuchElementException();
			Item item = first.item;
			first = first.next;
			if (isEmpty())
				last = null;
			N--;
			return item;

		}

		@Override
		public Iterator<Item> iterator() {
			return new Iterator<Item>() {

				@Override
				public boolean hasNext() {
					return !isEmpty();
				}

				@Override
				public Item next() {
					return dequeue();
				}
			};
		}

		public static void main(String[] args) {
			CommonQueue<String> queue = new CommonQueue<>();
//			queue.dequeue();
			queue.enqueue("q1");
			queue.enqueue("q2");
			queue.enqueue("q3");
			Iterator<String> iterator = queue.iterator();
			while (iterator.hasNext()) {
				String item = iterator.next();
				StdOut.println(item);
			}
		}

	}
}
