package com.juzi.chapter1_3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import com.juzi.chapter1_3.Chapter1_3.C1_3_10.InfixToPostfix;
import com.juzi.chapter1_3.Chapter1_3.C1_3_4.Parenthess.Pair;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

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
					i++;
					if (i == n - 1) {
						current.next = null;
						n--;
						break;
					}
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
		}
	}
}
