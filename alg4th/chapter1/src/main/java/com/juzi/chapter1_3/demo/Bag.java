package com.juzi.chapter1_3.demo;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

public class Bag {

	static class CommonBag<Item> implements Iterable<Item> {
		Node first;

		private class Node {
			Item item;
			Node next;//only commonbag can access;
		}

		void add(Item item) {
			Node oldFirst = first;
			first = new Node();
			first.item = item;
			first.next = oldFirst;
		}

		boolean isEmpty() {
			return first == null;
		}

		@Override
		public Iterator<Item> iterator() {
			return new Iterator<Item>() {
				Node current = first;

				@Override
				public boolean hasNext() {
					return current != null;
				}

				@Override
				public Item next() {
					Item item = current.item;
					current = current.next;
					return item;
				}
			};
		}

		public static void main(String[] args) {
			CommonBag<Integer> bag = new CommonBag<>();
			bag.add(1);
			bag.add(2);
			bag.add(3);
			Iterator<Integer> iterator = bag.iterator();
			while (iterator.hasNext()) {
				Integer item = iterator.next();
				StdOut.println(item);
			}
		}
	}
}
