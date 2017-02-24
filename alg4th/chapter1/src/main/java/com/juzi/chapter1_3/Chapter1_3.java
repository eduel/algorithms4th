package com.juzi.chapter1_3;

import java.util.Arrays;
import java.util.List;

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
			Stack.main(null);//?
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
				P1('{', '}'), P2('(', ')'), P3('[', ']');
				final char left;
				final char right;

				private Pair(char left, char right) {
					this.left = left;
					this.right = right;
				}

				static char getRight(char left) {
					char right;
					if (left == P1.left)
						right = P1.right;
					else if (left == P2.left)
						right = P2.right;
					else
						right = P3.right;
					return right;
				}

				static char getLeft(char right) {
					char left;
					if (right == P1.right)
						left = P1.left;
					else if (right == P2.right)
						left = P2.left;
					else
						left = P3.left;
					return left;
				}
			}

			static boolean isPair(String s) {
				Stack<Character> stack = new Stack<>();
				for (char c : s.toCharArray()) {
					boolean isLeft = c == Pair.P1.left || c == Pair.P2.left || c == Pair.P3.left;
					if (isLeft) {
						stack.push(c);
					} else {
						if (stack.isEmpty())
							return false;
						char leftC = stack.pop();
						char leftC2 = Pair.getLeft(c);
						if (leftC != leftC2)
							return false;
					}
				}
				return true;
			}

			public static void main(String[] args) {
				String s1 = "[()]{}{[()]()}";
				String s2 = "[(])";
				StdOut.println(isPair(s1));
				StdOut.println(isPair(s2));
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

	static class C1_3_8 {//?DoublingStackOfStrings

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
			for(int i=result.length()-1;i>=0;i--){
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
}
