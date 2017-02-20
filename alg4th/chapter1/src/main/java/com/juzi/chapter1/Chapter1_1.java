package com.juzi.chapter1;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Hello world!
 *
 */
public class Chapter1_1 {

	static class C1_1_1 {
		static void test() {
			// ( 0 + 15 ) / 2 
			int a = (0 + 15) / 2;
			// 2.0e-6*100000000.1
			double b = 2.0 * Math.pow(10.0, -6) * 100000000.1;
			// true && false || true && true
			boolean c = true && false || true && true;
			StdOut.printf("1.1.1:a=%d,b=%.10f,c=%b", a, b, c);
		}

		public static void main(String[] args) {
			test();
		}
	}

	static class C1_1_2 {
		static void test() {
			// (1+2.236)/2
			float a = (1 + 2.236f) / 2;
			// 1+2+3+4.0
			float b = 1 + 2 + 3 + 4.0f;
			// 4.1>=4
			boolean c = 4.1f >= 4;
			// 1+2+"3"
			String d = 1 + 2 + "3";
			StdOut.printf("1.1.2:a=%.3f,b=%.1f,c=%b,d=%s", a, b, c, d);
		}

		public static void main(String[] args) {
			test();
		}
	}

	static class C1_1_3 {

		static boolean compare(int a, int b, int c) {
			return a == b && b == c;
		}

		public static void main(String[] args) {
			int a, b, c;
			String equal = "equal", notEqual = "not equal";
			StdOut.println("enter 3 int numbers");
			a = StdIn.readInt();
			b = StdIn.readInt();
			c = StdIn.readInt();

			boolean isEqual = compare(a, b, c);
			StdOut.println(isEqual ? equal : notEqual);

		}
	}

	static class C1_1_4 {
		static void test() {
			// a:compile error
			// b:compile error
			// c:ok
			// d:ok
		}
	}

	static class C1_1_5 {
		static boolean isIn0to1(double x) {
			return (x > 0) && (x < 1);
		}

		public static void main(String[] args) {
			double x, y;
			StdOut.println("enter 2 double numbers");
			x = StdIn.readDouble();
			y = StdIn.readDouble();
			StdOut.println(isIn0to1(x) && isIn0to1(y));
		}
	}

	static class C1_1_6 {
		static void test() {
			int f = 0;
			int g = 1;
			for (int i = 0; i <= 15; i++) {
				StdOut.println(f);
				f = f + g;
				g = f - g;
			}
		}

		public static void main(String[] args) {
			test();
		}
	}

	static class C1_1_7 {
		static void printA() {
			double t = 9.0;
			while (Math.abs(t - 9.0 / t) > .001)
				t = (9.0 / t + t) / 2.0;
			StdOut.printf("%.5f\n", t);
		}

		static void printB() {
			int sum = 0;
			for (int i = 1; i < 1000; i++)
				for (int j = 0; j < i; j++)
					sum++;
			StdOut.println(sum);
		}

		static void printC() {
			int sum = 0;
			for (int i = 1; i < 1000; i *= 2)
				for (int j = 0; j < 1000; j++)
					sum++;
			StdOut.println(sum);
		}

		public static void main(String[] args) {
			printA();
			printB();
			printC();
		}
	}

	static class C1_1_8 {
		public static void main(String[] args) {
			System.out.println('b');
			System.out.println('b' + 'c');
			System.out.println((char) ('a' + 4));
		}
	}

	static class C1_1_9 {
		static String toBinaryString(int n) {
			String s = "";
			for (int N = n; N > 0; N /= 2)
				s = (N % 2) + s;
			return s;
		}

		static String toBinaryStringUseJDk(int n) {
			return Integer.toBinaryString(n);
		}

		public static void main(String[] args) {
			StdOut.println(toBinaryString(100));
			StdOut.println(toBinaryStringUseJDk(100));
		}
	}

	static class C1_1_10 {
		static void test() {
			int[] a;
			for (int i = 0; i < 10; i++) {
				// a[i] = i * i;//compile error;
			}
		}
	}

	static class C1_1_11 {
		static void print2DArray(boolean[][] a) {
			String space = " ";
			String star = "*";
			StdOut.print(space);
			for (int i = 0; i < a.length; i++) {
				StdOut.print(i);
			}
			StdOut.println();
			for (int i = 0; i < a.length; i++) {
				StdOut.print(i);
				for (int j = 0; j < a[i].length; j++) {
					StdOut.print(a[i][j] ? star : space);
				}
				StdOut.println();
			}
		}

		static boolean[][] initData(boolean[][] a) {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					a[i][j] = StdRandom.bernoulli(0.3);
				}
			}
			return a;
		}

		public static void main(String[] args) {
			print2DArray(initData(new boolean[10][10]));
		}

	}

	// System.out.println(i)-->System.out.println(a[i])
	static class C1_1_12 {
		static void print() {
			int[] a = new int[10];
			for (int i = 0; i < 10; i++)
				a[i] = 9 - i;
			for (int i = 0; i < 10; i++)
				a[i] = a[a[i]];
			for (int i = 0; i < 10; i++)
				System.out.println(a[i]);
			for (int i = 0; i < 10; i++)
				System.out.println(i);
		}

		public static void main(String[] args) {
			print();
		}
	}

	static class C1_1_13 {

		static int[][] initData(int[][] a) {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					a[i][j] = StdRandom.uniform(100);
					StdOut.print(a[i][j] + " ");
				}
				StdOut.println();
			}
			return a;
		}

		static int[][] swap(int[][] a) {
			int[][] b = new int[a.length][a[0].length];
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					b[j][i] = a[i][j];
				}
			}
			return b;
		}

		public static void main(String[] args) {

			int[][] b = swap(initData(new int[10][10]));
			StdOut.println("************");
			for (int i = 0; i < b.length; i++) {
				for (int j = 0; j < b[i].length; j++) {
					StdOut.print(b[i][j] + " ");
				}
				StdOut.println();
			}
		}
	}

	static class C1_1_14 {
		// logMN
		static int cal(int N, int M) {
			int a = 0;

			while (N >= M) {
				N = N / M;
				a++;
			}
			return a;
		}

		public static void main(String[] args) {
			StdOut.print(cal(9, 2));
		}
	}

	static class C1_1_15 {
		static int[] histogram(int[] a, int M) {
			int[] b = new int[M];
			int c = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < a.length; j++) {
					if (i == a[j])
						c++;
				}
				b[i] = c;
				c = 0;// clear;
			}
			return b;
		}

		static int[] initData(int n, int M) {
			int[] d = new int[n];
			for (int i = 0; i < d.length; i++) {
				d[i] = StdRandom.uniform(M);
			}
			return d;
		}

		static boolean compare(int[] a, int M) {
			int[] b = histogram(a, M);
			int v = 0;
			for (int i = 0; i < b.length; i++) {
				v += b[i];
			}
			return v == a.length;
		}

		public static void main(String[] args) {
			int n = 10;
			int M = 20;
			StdOut.print(compare(initData(n, M), M));
		}
	}

	static class C1_1_16 {
		public static String exR1(int n) {
			if (n <= 0)
				return "";
			return exR1(n - 3) + n + exR1(n - 2) + n;
		}

		public static void main(String[] args) {
			StdOut.print(exR1(6));
		}
	}

	static class C1_1_17 {
		public static String exR2(int n) {
			String s = exR2(n - 3) + n + exR2(n - 2) + n;
			if (n <= 0)
				return "";
			return s;
		}

		public static void main(String[] args) {
			StdOut.print(exR2(6));// StackOverflowError
		}
	}

	static class C1_1_18 {
		public static int mystery(int a, int b) {
			if (b == 0)
				return 0;
			if (b % 2 == 0)
				return mystery(a + a, b / 2);
			return mystery(a + a, b / 2) + a;
		}

		public static int mystery2(int a, int b) {
			if (b == 0)
				return 1;
			if (b % 2 == 0)
				return mystery2(a * a, b / 2);
			return mystery2(a * a, b / 2) * a;
		}

		public static void main(String[] args) {
			// mystery(a,b) = a * b;
			StdOut.println(mystery(2, 25));
			StdOut.println(mystery(3, 11));
			StdOut.println(mystery(4, 12));
			// mystery2(a,b) = Math.pow(a,b);
			StdOut.println(mystery2(2, 25));
			StdOut.println(mystery2(3, 11));
		}
	}

	static class C1_1_19 {
		static int fibonacci(int n) {
			if (n == 0)
				return 0;
			if (n == 1)
				return 1;
			return fibonacci(n - 2) + fibonacci(n - 1);
		}

		static int[] fibonacciArray(int n) {
			int[] a = new int[n];
			a[0] = 0;
			a[1] = 1;
			for (int i = 2; i < n; i++) {
				a[i] = a[i - 2] + a[i - 1];
			}
			return a;
		}

		static int fibonacci2(int n) {
			return fibonacciArray(n)[n - 1];
		}

		public static void main(String[] args) {
			// for (int i = 0; i < 100; i++) {
			// StdOut.println(fibonacci(i));//max 1836311903;
			// }
			StdOut.print(Arrays.toString(fibonacciArray(100)));
		}
	}

	static class C1_1_20 {
		// ln(N!) = lnN + ln(N-1) + ln(N-2) + ... + ln(1);
		static double lnN(int n) {
			if (n == 1)
				return 0;
			return Math.log(n) + lnN(n - 1);
		}

		public static void main(String[] args) {
			StdOut.println(lnN(1));
		}
	}

	static class C1_1_21 {
		public static void main(String[] args) {
			String clrf = "\r\n";// windows
			String whitespace = " ";
			String s = "zhangsan 10 20";
			String s2 = "lisi 15 24";
			String wholeS = s + clrf + s2 + clrf;
			In in = new In(new Scanner(new ByteArrayInputStream(wholeS.getBytes(StandardCharsets.UTF_8))));
			String[] allLines = in.readAllLines();
			for (int i = 0; i < allLines.length; i++) {
				String line = allLines[i];
				String[] columns = line.split(whitespace);
				StdOut.printf("%s %s %s %.3f \r\n", columns[0], columns[1], columns[2], Double.valueOf(columns[1]) / Double.valueOf(columns[2]));
			}
		}
	}

	static class C1_1_22 {
		static int rank(int key, int[] a) {
			return rank(key, a, 0, a.length - 1, 0);
		}

		static int rank(int key, int[] a, int lo, int hi) {
			if (lo > hi)
				return -1;
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid])
				return rank(key, a, lo, mid - 1);
			else if (key > a[mid])
				return rank(key, a, mid + 1, hi);
			else
				return mid;
		}

		static int rank(int key, int[] a, int lo, int hi, int level) {
			StdOut.println(String.format("lo=%d,hi=%d,level=%d", lo, hi, level));
			if (lo > hi)
				return -1;
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid]) {
				level++;
				for (int i = 0; i < level; i++) {
					StdOut.print(" ");
				}

				return rank(key, a, lo, mid - 1, level);
			} else if (key > a[mid]) {
				level++;
				for (int i = 0; i < level; i++) {
					StdOut.print(" ");
				}
				return rank(key, a, mid + 1, hi, level);
			} else {
				return mid;
			}
		}

		static int[] initData(int n) {
			int[] a = new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = StdRandom.uniform(100);
			}
			return a;
		}

		public static void main(String[] args) {
			int[] a = initData(100);
			Arrays.sort(a);
			System.out.println(Arrays.toString(a));
			System.out.println(rank(20, a));
		}
	}

	static class C1_1_23 {
		// white list; wtf??
		public static void main(String[] args) {
			// read the integers from a file
			In in = new In(args[0]);
			int[] whitelist = in.readAllInts();
			String type = args[1];
			String plus = "+";
			String minus = "-";
			// sort the array
			Arrays.sort(whitelist);

			// read integer key from standard input; print if not in whitelist
			while (!StdIn.isEmpty()) {
				int key = StdIn.readInt();
				if (plus.equals(plus)) {
					if (BinarySearch.indexOf(whitelist, key) == -1)
						StdOut.println(key);
				} else if (minus.equals(type)) {
					if (BinarySearch.indexOf(whitelist, key) > 0)
						StdOut.println(key);
				}
			}

		}
	}

	static class C1_1_24 {
		static int euclid(int p, int q, int l) {
			StdOut.println(String.format("p=%d,q=%d,l=%d", p, q, l));
			if (q == 0) {
				return p;
			}
			int r = p % q;
			l++;
			for (int i = 0; i < l; i++) {
				StdOut.print(" ");
			}
			return euclid(q, r, l);
		}

		public static void main(String[] args) {
			int p, q;
			p = StdIn.readInt();
			q = StdIn.readInt();
			StdOut.println(euclid(p, q, 0));
		}
	}

	static class C1_1_25 {
		// proof;
	}

	static class C1_1_26 {
		static void sortABC(int a, int b, int c) {
			if (a > b) {
				int t = a;
				a = b;
				b = t;
			}
			if (a > c) {
				int t = a;
				a = c;
				c = t;
			}
			if (b > c) {
				int t = b;
				b = c;
				c = t;
			}
			StdOut.println(String.format("a=%d,b=%d,c=%d", a, b, c));
		}

		public static void main(String[] args) {
			sortABC(5, 3, 4);
		}
	}

	static class C1_1_27 {

		// recursive
		static double binomial(int N, int k, double p) {
			StdOut.println(String.format("N=%d,k=%d", N, k));
			if (N == 0 && k == 0)
				return 1.0;
			if (N < 0 || k < 0)
				return 0.0;
			return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
		}

		// array
		static void binomialArray(int N, int K, double p) {
			double[][] a = new double[N + 1][K + 1];
			a[0][0] = 1;
			for (int i = 1; i < N + 1; i++) {
				a[i][0] = (1.0 - p) * a[i - 1][0];
			}
			for (int i = 1; i < K + 1; i++) {
				a[0][i] = 0;
			}
			for (int i = 0; i < N + 1; i++) {
				for (int j = 1; j <= i && j < K + 1; j++) {
					a[i][j] = (1.0 - p) * a[i - 1][j] + p * a[i - 1][j - 1];
				}
			}
			for (int i = 0; i < N + 1; i++) {
				for (int j = 0; j < K + 1; j++) {
					StdOut.printf("%.5f ", a[i][j]);
				}
				StdOut.println();
			}
		}

		public static void main(String[] args) {
			// StdOut.println(binomial(100, 50, 0.5));
			// 100times,50times,0.5success;
			binomialArray(100, 101, 0.5);
		}
	}

	static class C1_1_28 {
		static int count(int[] a) {// sorted array;
			int count = 0;
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] == a[i + 1])
					count++;
			}
			return count;

		}

		static int[] remove(int[] a, int count) {
			int[] r = new int[a.length - count];
			int s = 0;
			r[0] = a[0];
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] == a[i + 1]) {
					s++;
				} else {
					r[i - s + 1] = a[i + 1];
				}
			}
			return r;
		}

		public static void main(String[] args) {
			int[] a = { 1, 3, 3, 4, 4, 4, 6, 6, 7, 8, 9 };
			int count = count(a);
			StdOut.println(count);
			int[] r = remove(a, count(a));
			StdOut.println(Arrays.toString(r));
		}
	}

	static class C1_1_29 {
		static int rank(int key, int[] a) {
			int lo = 0;
			int hi = a.length - 1;
			while (lo <= hi) {
				int mid = lo + (hi - lo) / 2;
				if (key < a[mid]) {
					hi = mid - 1;
				} else if (key > a[mid]) {
					lo = mid + 1;
				} else {
					while (mid > 0 && a[mid] == a[mid - 1])
						mid--;
					return mid;
				}
			}
			return -1;
		}

		static int count(int key, int[] a) {
			int count = 1;
			int i = rank(key, a);
			if (i == -1)
				return 0;
			while (i < a.length - 1 && a[i] == a[i + 1]) {
				count++;
				i++;
			}
			return count;
		}

		public static void main(String[] args) {
			//			In in = new In

		}
	}
}
