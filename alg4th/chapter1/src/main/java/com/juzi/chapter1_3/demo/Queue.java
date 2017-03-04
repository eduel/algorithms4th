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

	public static class CircleListQueue<T> implements Iterable<T> {
		private Node last;
		private int n;

		private class Node {
			T t;
			Node next;
		}

		public boolean isEmpty() {
			return n == 0;
		}

		public int size() {
			return n;
		}

		public CircleListQueue<T> enQueue(T t) {
			if (isEmpty()) {
				last = new Node();
				last.t = t;
				last.next = last;
			} else {
				Node newNode = new Node();
				newNode.t = t;
				Node oldFirst = last.next;
				last.next = newNode;
				newNode.next = oldFirst;
				last = newNode;
			}
			n++;
			return this;
		}

		public T deQueue() {
			if (isEmpty())
				throw new NoSuchElementException();
			if (n == 1) {
				T temp = last.t;
				last = null;
				n = 0;
				return temp;
			}
			Node oldFirst = last.next;
			T temp = oldFirst.t;//first;
			last.next = oldFirst.next;
			oldFirst = null;
			n--;
			return temp;
		}

		@Override
		public Iterator<T> iterator() {
			return new Iterator<T>() {
				int i = 0;
				Node current = null;

				@Override
				public boolean hasNext() {
					return i < n;
				}

				@Override
				public T next() {
					if (isEmpty())
						throw new NoSuchElementException("has no element");
					if (i == n)
						throw new NoSuchElementException("queue end");
					if (current == null) {
						current = last.next;
					}
					T t = current.t;
					current = current.next;
					i++;
					return t;

				}
			};
		}

		public CircleListQueue<T> printElements() {
			Iterator<T> iterator = iterator();
			while (iterator.hasNext()) {
				StdOut.print(iterator.next() + " ");
			}
			StdOut.println();
			return this;
		}
	}
}
