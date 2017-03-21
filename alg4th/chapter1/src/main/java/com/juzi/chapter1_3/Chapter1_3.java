package com.juzi.chapter1_3;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import com.juzi.chapter1_3.Chapter1_3.C1_3_10.InfixToPostfix;
import com.juzi.chapter1_3.Chapter1_3.C1_3_4.Parenthess.Pair;
import com.juzi.chapter1_3.demo.CircleListQueue;
import com.juzi.chapter1_3.demo.DoubleLinkedList;
import com.juzi.chapter1_3.demo.GeneralizedArrayQueue;
import com.juzi.chapter1_3.demo.GeneralizedListQueue;
import com.juzi.chapter1_3.demo.IterableAndPrintable;
import com.juzi.chapter1_3.demo.MoveToFront;
import com.juzi.chapter1_3.demo.RandomBag;
import com.juzi.chapter1_3.demo.RandomQueue;
import com.juzi.chapter1_3.demo.ResizingArrayDeque;
import com.juzi.chapter1_3.demo.SimpleRingBuffer;
import com.juzi.chapter1_3.demo.Steque;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Chapter1_3 {

	/**
	 * 
	 * @author eduel
	 */
	static class C1_3_1 {

	}

	static class C1_3_2 {
		public static void main(String[] args) {
			Stack.main(null);// ?
		}
	}

	static class C1_3_3 {
		void f() {
			Stack<Integer> f = new Stack<>();
			f.push(0);
			f.pop();
			f.push(1);
			f.push(2);
			f.push(3);
			f.push(4);
			f.pop();
			f.push(5);
			f.push(6);
			f.pop();
			f.pop();
			f.pop();
			f.push(7);
			f.push(8);
			f.pop();
		}
	}

	static class C1_3_4 {
		static class Parenthess {
			static enum Pair {
				P1("{", "}"), P2("(", ")"), P3("[", "]");
				String left;
				String right;
				static String lefts = "([{";
				static String rights = ")]}";

				private Pair(String left, String right) {
					this.left = left;
					this.right = right;
				}

				static String getRight(String left) {
					if (lefts.indexOf(left) < 0)
						throw new IllegalArgumentException("not left");
					String right;
					if (P1.left.equals(left))
						right = P1.right;
					else if (P2.left.equals(left))
						right = P2.right;
					else
						right = P3.right;
					return right;
				}

				static String getLeft(String right) {
					if (rights.indexOf(right) < 0)
						throw new IllegalArgumentException("not right");
					String left;
					if (P1.right.equals(right))
						left = P1.left;
					else if (P2.right.equals(right))
						left = P2.left;
					else
						left = P3.left;
					return left;
				}

				static boolean isLeft(String input) {
					return lefts.indexOf(input) != -1;
				}

				static boolean isRight(String input) {
					return rights.indexOf(input) != -1;
				}
			}

			static boolean isPair(String[] input) {
				Stack<String> stack = new Stack<>();
				for (String s : input) {
					boolean isLeft = Pair.isLeft(s);
					if (isLeft) {
						stack.push(s);
					} else {
						if (stack.isEmpty())
							return false;
						String leftC = stack.pop();
						String leftC2 = Pair.getLeft(s);
						if (!leftC.equals(leftC2))
							return false;
					}
				}
				return true;
			}

			public static void main(String[] args) {
				String s1 = "[()]{}{[()]()}";
				String s2 = "[(])";
				StdOut.println(isPair(s1.split("")));
				StdOut.println(isPair(s2.split("")));
			}
		}
	}

	static class C1_3_5 {
		static void printBinaryString(int N) {
			Stack<Integer> stack = new Stack<>();
			while (N > 0) {
				stack.push(N % 2);
				N = N / 2;
			}
			for (int n : stack) {
				StdOut.print(n);
			}
		}

		static void printIntToX(int N, int x) {
			assert x > 0;
			Stack<Integer> stack = new Stack<>();
			while (N > 0) {
				stack.push(N % x);
				N = N / x;
			}
			for (int n : stack) {
				StdOut.print(n);
			}
		}

		public static void main(String[] args) {
			printBinaryString(50);
			StdOut.println();
			printIntToX(50, 8);
			StdOut.println();
			printIntToX(50, 16);
		}
	}

	static class C1_3_6 {
		static void reserve(String[] strings) {
			StdOut.println(Arrays.toString(strings));
			Stack<String> stack = new Stack<>();
			Queue<String> queue = new Queue<>();
			for (String s : strings) {
				queue.enqueue(s);
			}
			while (!queue.isEmpty()) {
				stack.push(queue.dequeue());
			}
			while (!stack.isEmpty()) {
				queue.enqueue(stack.pop());
			}
			for (String s : queue) {
				StdOut.print(s + " ");
			}
		}

		public static void main(String[] args) {
			String[] strings = { "a", "b", "c" };
			reserve(strings);
		}
	}

	static class C1_3_7 {
		public static void main(String[] args) {
			Stack<String> stack = new Stack<>();
			stack.push("a");
			StdOut.println(stack.peek());
			StdOut.println(stack.size());
			StdOut.println(stack.isEmpty());
			StdOut.println(stack.pop());
		}
	}

	static class C1_3_8 {// ?DoublingStackOfStrings

	}

	static class C1_3_9 {
		static void print(String[] s) {
			Stack<String> valStack = new Stack<>();
			Stack<String> opStack = new Stack<>();
			String left = "(";
			String right = ")";
			List<String> opList = Arrays.asList("+", "-", "*", "/");
			for (String v : s) {
				if (opList.contains(v)) {
					opStack.push(v);
				} else if (right.equals(v)) {
					String temp = right + valStack.pop() + opStack.pop() + valStack.pop() + left;
					valStack.push(temp);
				} else {
					valStack.push(v);
				}
			}
			String result = valStack.pop();
			String reverseResult = "";
			for (int i = result.length() - 1; i >= 0; i--) {
				reverseResult += result.charAt(i);
			}
			StdOut.println(reverseResult);
		}

		public static void main(String[] args) {
			String s = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
			String[] splited = s.split(" ");
			print(splited);

		}
	}

	// TODO
	static class C1_3_10 {
		// +,-,*,/,(,);
		static class InfixToPostfix {
			static List<String> ops = Arrays.asList("+", "-", "*", "/");
			static String lowOP = "+-";
			static String highOP = "*/";
			static String plus = "+";
			static String minus = "-";
			static String mult = "*";
			static String div = "/";

			static int priority(String op) {
				if (!ops.contains(op))
					throw new IllegalArgumentException("not op");
				return highOP.indexOf(op) == -1 ? 1 : 2;
			}

			static boolean isHigh(String op1, String op2) {
				return priority(op1) >= priority(op2);
			}

			// input must be ok;
			static String toPostfix(String[] input) {
				Queue<String> expression = new Queue<>();
				Stack<String> stack = new Stack<>();
				for (String s : input) {
					boolean isLeft = Pair.isLeft(s);
					boolean isRight = Pair.isRight(s);
					if (isLeft) {
						stack.push(s);
					} else if (isRight) {
						if (stack.isEmpty())
							throw new ArithmeticException();
						while (!stack.isEmpty()) {
							String temp = stack.pop();
							if (temp.equals(Pair.getLeft(s)))
								break;
							expression.enqueue(temp);
						}
					} else if (ops.contains(s)) {
						while (true) {
							if (stack.isEmpty()) {
								stack.push(s);
								break;
							}
							String topOP = stack.peek();
							boolean isOp = ops.contains(topOP);
							if (isOp) {
								boolean isHigh = isHigh(topOP, s);
								if (isHigh) {
									expression.enqueue(stack.pop());
									continue;
								}
							} else {
								boolean isNotLeft = !Pair.isLeft(topOP);
								if (isNotLeft) {
									expression.enqueue(stack.pop());
									continue;
								}
							}
							stack.push(s);
							break;
						}

					} else {
						expression.enqueue(s);
					}
				}

				StringBuilder result = new StringBuilder();
				for (String s : expression) {
					result.append(s);
				}
				for (String s : stack) {
					result.append(s);
				}
				return result.toString();
			}

			public static void main(String[] args) {
				String s = "2*3/(2-1)+3*(4-1)";
				StdOut.println(toPostfix(s.split("")));
			}
		}

	}

	static class C1_3_11 {
		static int evaluatePostfix(String[] input) {
			String postfix = C1_3_10.InfixToPostfix.toPostfix(input);
			Stack<Integer> stack = new Stack<>();
			for (String s : postfix.split("")) {
				if (InfixToPostfix.ops.contains(s)) {
					int c1 = stack.pop();
					int c2 = stack.pop();
					switch (s) {
					case "+":
						stack.push(c2 + c1);
						break;
					case "-":
						stack.push(c2 - c1);
						break;
					case "*":
						stack.push(c2 * c1);
						break;
					case "/":
						stack.push(c2 / c1);
						break;
					default:
						break;
					}
				} else {
					stack.push(Integer.valueOf(s));
				}
			}
			return stack.pop();
		}

		public static void main(String[] args) {
			String s = "2*3/(2-1)+3*(4-1)";
			String[] splited = s.split("");
			StdOut.println(evaluatePostfix(splited));
		}
	}

	static class C1_3_12 {
		static class CopyableStack {

			static Stack<String> copy(Stack<String> input) {
				Stack<String> tempStack = new Stack<>();
				Iterator<String> stackIterator = input.iterator();
				while (stackIterator.hasNext()) {
					String element = stackIterator.next();
					tempStack.push(element);
				}
				Stack<String> copy = new Stack<>();
				Iterator<String> tempStackIterator = tempStack.iterator();
				while (tempStackIterator.hasNext()) {
					copy.push(tempStackIterator.next());
				}
				return copy;
			}

			public static void main(String[] args) {
				Stack<String> stack = new Stack<>();
				stack.push("a");
				stack.push("b");
				stack.push("c");
				Stack<String> copy = copy(stack);
				for (String s : copy) {
					StdOut.print(s);
				}
			}
		}
	}

	static class C1_3_13 {
		// b,c,d
	}

	static class C1_3_14 {
		static class ResizingArrayQueueOfStrings implements Iterable<String> {
			String[] vals;
			int head;
			int tail;
			int n;

			public ResizingArrayQueueOfStrings(int capacity) {
				assert capacity > 0;
				vals = new String[capacity];
			}

			boolean isEmpty() {
				return n == 0;
			}

			int size() {
				return n;
			}

			void enqueue(String e) {
				if (n == vals.length)
					vals = resize(vals.length * 2);
				vals[tail++] = e;
				if (tail == vals.length)
					tail = 0;
				n++;
			}

			String dequeue() {
				if (isEmpty())
					throw new NoSuchElementException();
				String e = vals[head];
				vals[head++] = null;
				n--;
				if (head == vals.length)
					head = 0;
				if (n > 0 && n == vals.length / 4)
					resize(vals.length / 2);
				return e;
			}

			public String[] resize(int capacity) {
				assert capacity >= n;
				String[] newVals = new String[capacity];
				for (int i = 0; i < n; i++) {
					newVals[i] = vals[(head + i) % vals.length];// importent;
				}
				head = 0;
				tail = n;
				vals = newVals;
				return vals;
			}

			@Override
			public Iterator<String> iterator() {
				return new Iterator<String>() {
					int i = 0;

					@Override
					public boolean hasNext() {
						return i < n;

					}

					@Override
					public String next() {
						if (!hasNext())
							throw new NoSuchElementException();
						return vals[(head + i++) % vals.length];
					}
				};

			}

		}

		public static void main(String[] args) {
			ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings(2);
			queue.enqueue("1");
			queue.enqueue("2");
			queue.enqueue("3");
			for (String e : queue) {
				StdOut.print(e);
			}
			StdOut.println();
			queue.dequeue();
			queue.dequeue();
			queue.enqueue("4");
			queue.enqueue("5");
			// queue.enqueue("6");
			for (String e : queue) {
				StdOut.print(e);
			}

		}
	}

	static class C1_3_15 {
		static void k(String[] input, int k) {
			Queue<String> queue = new Queue<>();
			for (String s : input) {
				queue.enqueue(s);
			}
			int index = input.length - k;
			for (int i = 0; i < index + 1; i++) {
				String kString = queue.dequeue();
				if (i == index)
					StdOut.println(kString);
			}
		}

		public static void main(String[] args) {
			String[] strings = "1,2,3,4,5,6,7,8,9,10".split(",");
			k(strings, 6);
		}
	}

	static class C1_3_16 {

	}

	static class C1_3_17 {

	}

	static class C1_3_18 {
		// delete p.next;
	}

	static class C1_3_19 {
		static class List<Item> implements Iterable<Item> {
			Item[] items;
			int head;
			int tail;
			int n;

			@SuppressWarnings("unchecked")
			public List(int capacity) {
				items = (Item[]) new Object[capacity];
			}

			boolean isEmpty() {
				return n == 0;
			}

			int size() {
				return n;
			}

			public void add(Item item) {
				items[n++] = item;
				tail++;
			}

			public void delete(int x) {
				@SuppressWarnings("unchecked")
				Item[] newItems = (Item[]) new Object[items.length];
				for (int i = 0; i < x; i++) {
					newItems[i] = items[i];
				}
				for (int i = x; i < items.length; i++) {
					newItems[i - 1] = items[i];
				}
				items = newItems;
				tail--;
				n--;
			}

			@Override
			public Iterator<Item> iterator() {
				return new Iterator<Item>() {
					int i = 0;

					@Override
					public boolean hasNext() {
						return i < n;
					}

					@Override
					public Item next() {
						Item item = items[i++];
						return item;
					}
				};

			}
		}
	}

	static class C1_3_20 {
		// first.next->null,
		static class List implements Iterable<Integer> {
			Node first;
			Node last;
			int n;

			static class Node {
				int val;
				Node next;
			}

			boolean isEmpty() {
				return n == 0;
			}

			int size() {
				return n;
			}

			List add(int val) {
				if (isEmpty()) {
					first = new Node();
					first.val = val;
					first.next = null;
					last = first;
					n++;
				} else {
					Node oldLast = last;
					last = new Node();
					last.val = val;
					last.next = null;
					oldLast.next = last;
					n++;
				}
				return this;
			}

			List deleteLast() {
				Node current = first;
				int i = 0;
				while (true) {
					current = current.next;
					if (i == n - 2) {
						current.next = null;
						n--;
						break;
					}
					i++;
				}
				return this;
			}

			List deleteK(int k) {
				Node current = first;
				int i = 0;
				while (true) {
					current = current.next;
					if (i == k - 2) {
						current.next = current.next.next;
						n--;
						break;
					}
					i++;
				}
				return this;
			}

			@Override
			public Iterator<Integer> iterator() {
				return new Iterator<Integer>() {
					int i = 0;
					Node current = first;

					@Override
					public boolean hasNext() {
						return i < n;
					}

					@Override
					public Integer next() {
						int val = current.val;
						current = current.next;
						i++;
						return val;
					}
				};
			}
		}

		public static void main(String[] args) {
			List list = new List();
			list.add(1).add(2).add(3).deleteLast();
			Iterator<Integer> iterator = list.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
			list.add(4).add(5).deleteK(2);

			Iterator<Integer> iterator2 = list.iterator();
			while (iterator2.hasNext()) {
				System.out.println(iterator2.next());
			}
		}
	}

	static class C1_3_21 {
		//no resizing;
		static class List<Item> implements Iterable<Item> {
			Item[] items;
			int n;

			@SuppressWarnings("unchecked")
			public List(int capacity) {
				items = (Item[]) new Object[capacity];
			}

			boolean isEmpty() {
				return n == 0;
			}

			int size() {
				return n;
			}

			void add(Item item) {
				int length = items.length;
				if (n != length)
					items[n++] = item;
			}

			@Override
			public Iterator<Item> iterator() {
				return new Iterator<Item>() {
					int i = 0;

					@Override
					public boolean hasNext() {
						return i < n;
					}

					@Override
					public Item next() {
						return items[i++];
					}
				};
			}

		}

		static boolean find(List<String> list, String key) {
			Iterator<String> iterator = list.iterator();
			while (iterator.hasNext()) {
				String currentString = iterator.next();
				if (currentString.equals(key))
					return true;
			}
			return false;
		}

		public static void main(String[] args) {
			List<String> list = new List<>(5);
			list.add("1");
			list.add("2");
			list.add("3");
			boolean isFinded = find(list, "3");
			StdOut.println(isFinded);
		}
	}

	static class C1_3_22 {
		//draw a pic;
	}

	static class C1_3_23 {

	}

	static class C1_3_24 {
		//see 1.3.18
		public static void main(String[] args) {
			com.juzi.chapter1_3.demo.List<Integer> list = new com.juzi.chapter1_3.demo.List<>();
			list.add(1).add(2).add(3).removeAfter(1).printElements();
		}
	}

	static class C1_3_25 {
		public static void main(String[] args) {
			com.juzi.chapter1_3.demo.List<Integer> list = new com.juzi.chapter1_3.demo.List<>();
			list.add(1).add(2).add(3).printElements();
			list.insertAfter(2, 4).printElements();
		}
	}

	static class C1_3_26 {
		public static void main(String[] args) {
			com.juzi.chapter1_3.demo.List<Integer> list = new com.juzi.chapter1_3.demo.List<>();
			list.add(1).add(2).add(3).printElements();
			list.add(1).add(1).printElements();
			list.remove(1).printElements();
		}
	}

	static class C1_3_27 {
		public static void main(String[] args) {
			com.juzi.chapter1_3.demo.List<Integer> list = new com.juzi.chapter1_3.demo.List<>();
			list.add(2).add(5).add(10).add(6);
			int max = list.max((i1, i2) -> {
				if (i1 == i2)
					return 0;
				return i1 > i2 ? 1 : -1;
			});
			StdOut.println(max);
		}
	}

	static class C1_3_28 {
		public static void main(String[] args) {
			com.juzi.chapter1_3.demo.List<Integer> list = new com.juzi.chapter1_3.demo.List<>();
			list.add(2).add(5).add(10).add(6);
			Iterator<Integer> iterator = list.iterator();
			int max = list.max((i1, i2) -> {
				if (i1 == i2)
					return 0;
				return i1 > i2 ? 1 : -1;
			}, iterator, null, null);
			StdOut.print(max);

		}
	}

	static class C1_3_29 {
		public static void main(String[] args) {
			CircleListQueue<Integer> queue = new CircleListQueue<>();
			queue.enQueue(1).enQueue(2).enQueue(3).printElements();
			queue.deQueue();
			queue.printElements();
			queue.deQueue();
			queue.printElements();
			queue.deQueue();
			queue.printElements();

		}
	}

	static class C1_3_30 {
		public static void main(String[] args) {
			com.juzi.chapter1_3.demo.List<Integer> list = new com.juzi.chapter1_3.demo.List<>();
			int reserveT = list.add(1).add(2).add(3).reserve();
			StdOut.println(reserveT);
		}
	}

	static class C1_3_31 {
		public static void main(String[] args) {
			DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
			DoubleLinkedList.insertBeforeFirst(list, 1);
			DoubleLinkedList.insertBeforeFirst(list, 2);
			DoubleLinkedList.insertBeforeFirst(list, 3);
			DoubleLinkedList.printElements(list);
			DoubleLinkedList.insertAfterLast(list, 4);
			DoubleLinkedList.printElements(list);
			DoubleLinkedList.removeFromFirst(list);
			DoubleLinkedList.printElements(list);
			DoubleLinkedList.removeFromLast(list);
			DoubleLinkedList.printElements(list);
			DoubleLinkedList.removeFromFirst(list);
			DoubleLinkedList.printElements(list);
			DoubleLinkedList.insertBeforeFirst(list, 3);
			DoubleLinkedList.printElements(list);
			DoubleLinkedList.insertBefore(list, 2, 5);
			DoubleLinkedList.printElements(list);
			DoubleLinkedList.insertAfter(list, 2, 6);
			DoubleLinkedList.printElements(list);
			DoubleLinkedList.insertBefore(list, 3, 7);
			DoubleLinkedList.printElements(list);
			DoubleLinkedList.remove(list, 2);
			DoubleLinkedList.printElements(list);
		}
	}

	static class C1_3_32 {
		public static void main(String[] args) {
			Steque<Integer> steque = new Steque<>();
			steque.push(1).push(2).push(3);
			steque.printElement();
			steque.pop();
			steque.printElement();
			steque.enqueue(4);
			steque.printElement();
		}
	}

	static class C1_3_33 {
		public static void main(String[] args) {
			ResizingArrayDeque<Integer> deque = new ResizingArrayDeque<>();
			deque.pushLeft(1);
			deque.pushLeft(2);
			deque.pushLeft(3);
			deque.printElements();
			deque.pushRight(4);
			deque.printElements();
			deque.popLeft();
			deque.printElements();
			deque.popRight();
			deque.printElements();
			deque.popLeft();
			deque.printElements();
			deque.popLeft();
			deque.printElements();
		}
	}

	static class C1_3_34 {
		public static void main(String[] args) {
			RandomBag<Integer> randomBag = new RandomBag<>();
			randomBag.add(1);
			randomBag.add(2);
			randomBag.add(3);
			randomBag.printElements();

			int[] ints = { 1, 2, 3 };
			StdOut.println(StdRandom.discrete(ints));
			StdOut.println(StdRandom.discrete(ints));
			StdOut.println(StdRandom.discrete(ints));
			StdOut.println(StdRandom.discrete(ints));
		}
	}

	static class C1_3_35 {
		static class Card {
			static final String[][] init = { { "aA", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9", "a10", "aJ", "aQ", "aK" },
					{ "bA", "b2", "b3", "b4", "b5", "b6", "b7", "b8", "b9", "b10", "bJ", "bQ", "bK" }, { "cA", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9", "c10", "cJ", "cQ", "cK" },
					{ "dA", "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9", "d10", "dJ", "dQ", "dK" }

			};
			private String card;

			private Card(String card) {
				this.card = card;
			}

			public static Card[][] deal() {
				RandomQueue<Card> queue = new RandomQueue<>();
				for (int i = 0; i < init.length; i++) {
					for (int j = 0; j < init[0].length; j++) {
						Card temp = new Card(init[i][j]);
						queue.enqueue(temp);
					}
				}
				Card[][] cards = new Card[4][13];

				for (int i = 0; i < cards.length; i++) {
					for (int j = 0; j < cards[0].length; j++) {
						cards[i][j] = queue.dequeue();
					}
				}
				return cards;

			}

			@Override
			public String toString() {
				return card;
			}
		}

		public static void main(String[] args) {
			RandomQueue<Integer> randomQueue = new RandomQueue<>();
			randomQueue.enqueue(1);
			randomQueue.enqueue(2);
			randomQueue.enqueue(3);
			randomQueue.printElements();
			randomQueue.dequeue();
			randomQueue.printElements();
			randomQueue.samle();
			randomQueue.dequeue();
			randomQueue.printElements();
			Card[][] card = Card.deal();
			for (int i = 0; i < card.length; i++) {
				StdOut.println(Arrays.toString(card[i]));
			}

		}
	}

	static class C1_3_37 {
		public static void main(String[] args) {
			Queue<Integer> queue = new Queue<>();
			int n = 7;
			int m = 2;
			for (int i = 0; i < n; i++) {
				queue.enqueue(i);
			}
			while (true) {
				for (int i = 0; i < m - 1; i++) {
					queue.enqueue(queue.dequeue());
				}
				int kill = queue.dequeue();
				StdOut.println(kill);
				n--;
				if (n == 1) {
					int remain = queue.dequeue();
					StdOut.println(remain);
					break;
				}
			}
		}
	}

	static class C1_3_38 {
		public static void main(String[] args) {
			GeneralizedArrayQueue<Integer> arrayQueue = new GeneralizedArrayQueue<>();
			for (int i = 0; i < 10; i++) {
				arrayQueue.insert(i);
			}
			arrayQueue.printElements();
			arrayQueue.delete(3);
			arrayQueue.printElements();
			arrayQueue.insert(10);
			arrayQueue.printElements();
			arrayQueue.delete(6);
			arrayQueue.printElements();

			//listQueue
			StdOut.println("***for list queue***");
			GeneralizedListQueue<Integer> listQueue = new GeneralizedListQueue<>();
			for (int i = 0; i < 10; i++) {
				listQueue.insert(i);
			}
			listQueue.printElements();
			listQueue.delete(3);
			listQueue.printElements();
			listQueue.insert(10);
			listQueue.printElements();
			listQueue.delete(6);
			listQueue.printElements();
			listQueue.delete(1);
			listQueue.printElements();
			listQueue.delete(8);
			listQueue.insert(11);
			listQueue.printElements();

		}
	}

	static class C1_3_39 {
		public static void main(String[] args) {
			SimpleRingBuffer<Integer> ringBuffer = new SimpleRingBuffer<>(2);
			Thread t = new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						try {
							TimeUnit.MILLISECONDS.sleep(StdRandom.uniform(999));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						ringBuffer.consume();
					}
				}
			});
			t.setName("consume thread");
			t.start();
			Thread t2 = new Thread(new Runnable() {

				@Override
				public void run() {
					for (int i = 0; i < 100; i++) {
						ringBuffer.produce(i);
						try {
							TimeUnit.MILLISECONDS.sleep(StdRandom.uniform(999));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			});
			t2.setName("produce thread");
			t2.start();
		}
	}

	static class C1_3_40 {
		public static void main(String[] args) {
			MoveToFront<Integer> list = new MoveToFront<>();
			for (int i = 0; i < 5; i++) {
				list.addToLast(i);
			}
			list.printElements();
			list.delete(4);
			list.printElements();
			list.delete(3);
			list.printElements();
			list.addToLast(5);
			list.printElements();
		}
	}

	//??copy queue;
	static class C1_3_41 {
		public static void main(String[] args) {
			class NewQueue<Item> extends Queue<Item> implements IterableAndPrintable<Item> {

				public NewQueue() {
					super();
				}

				public NewQueue(NewQueue<Item> old) {
					Iterator<Item> iterator = old.iterator();
					while (iterator.hasNext()) {
						this.enqueue(iterator.next());
					}
				}
			}
			NewQueue<Integer> old = new NewQueue<>();
			for (int i = 0; i < 10; i++)
				old.enqueue(i);
			NewQueue<Integer> newQueue = new NewQueue<>(old);
			newQueue.dequeue();
			newQueue.dequeue();
			old.printElements();
			old.enqueue(11);
			newQueue.printElements();
			old.printElements();
		}
	}

	static class C1_3_43 {
		static void files(File d, Queue<String> files, int level) {
			String prefix = "";
			for (int i = 0; i < level; i++) {
				prefix += "-";
			}
			files.enqueue(prefix + d.getName());
			level++;
			File[] childFiles = d.listFiles();
			for (File f : childFiles) {
				if (f.isDirectory())
					files(f, files, level);
				else
					files.enqueue(prefix+"-" + f.getName());
			}
		}

		public static void main(String[] args) {
			Queue<String> queue = new Queue<>();
			File d = new File("E:\\迅雷下载");
			files(d, queue, 0);
			Iterator<String> iterator = queue.iterator();
			while (iterator.hasNext()) {
				StdOut.println(iterator.next());

			}
		}
	}
	//?
	static class C1_3_45{
		
	}
	//?
	static class C1_3_46{
		
	}
	static class C1_3_49{
		
	}
}
