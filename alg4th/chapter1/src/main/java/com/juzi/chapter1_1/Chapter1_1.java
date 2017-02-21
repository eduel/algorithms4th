package com.juzi.chapter1_1;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

import com.juzi.Constant;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
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
				StdOut.printf("%s %s %s %.3f \r\n", columns[0], columns[1], columns[2],
						Double.valueOf(columns[1]) / Double.valueOf(columns[2]));
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
			In in = new In(Constant.getParentPath() + "tinyW.txt");
			int[] whiteList = in.readAllInts();
			Arrays.sort(whiteList);
			int key = StdIn.readInt();
			int rank = rank(key, whiteList);
			StdOut.println(String.format("get %d element lt %d", rank, key));
			key = StdIn.readInt();
			int count = count(key, whiteList);
			StdOut.println(String.format("get %d element eq %d", count, key));

		}
	}

	static class C1_1_30 {
		static boolean[][] createArray(int N) {
			boolean[][] r = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int g = gcd(i, j);
					r[i][j] = (g == 1) ? true : false;
				}
			}
			return r;
		}

		static int gcd(int p, int q) {
			if (p == 0 || q == 0)
				return 1;
			if (p % q == 0)
				return q;
			while (q > 0) {
				int r = p % q;
				p = q;
				q = r;
			}
			return p;
		}

		static int gcd2(int p, int q) {
			if (p == 0 || q == 0)
				return 1;
			if (p % q == 0)
				return q;
			return gcd(q, p % q);
		}

		public static void main(String[] args) {
			int N = 10;
			for (int i = 0; i < N; i++) {
				StdOut.println(Arrays.toString(createArray(N)[i]));
			}
		}
	}

	static class C1_1_31 {
		static void drawcircle(double x, double y, double r, int N, double p, double[][] a) {
			StdDraw.setXscale(0, x * 2);
			StdDraw.setYscale(0, y * 2);
			StdDraw.setPenRadius(0.05);
			StdDraw.setPenColor(Color.red);
			StdDraw.circle(x, y, r);
			for (int i = 0; i < N; i++) {
				StdDraw.setPenRadius(0.05);
				StdDraw.setPenColor(Color.BLACK);
				double m = 50 - 50 * Math.cos(2 * Math.PI * i / N);
				double n = 50 + 50 * Math.sin(2 * Math.PI * i / N);
				StdDraw.point(m, n);
				a[i][0] = m;
				a[i][1] = n;
				StdDraw.setPenColor(Color.red);
			}
		}

		static void drawRandomLine(double x, double y, double[][] a) {
			StdDraw.setXscale(0, 2 * x);
			StdDraw.setYscale(0, 2 * y);
			StdDraw.setPenRadius(0.01);
			StdDraw.setPenColor(Color.DARK_GRAY);
			int N = a.length;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (StdRandom.bernoulli(0.5))
						StdDraw.line(a[i][0], a[i][1], a[j][0], a[j][1]);
				}
			}
		}

		public static void main(String[] args) {
			double[][] a = new double[10][2];
			drawcircle(50, 50, 50, 10, 0.2, a);
			drawRandomLine(50, 50, a);
		}
	}

	static class C1_1_32 {
		static double[] segmentation(int N, double l, double r, double[] a) {
			if (N == 0)
				return a;
			double s = (r - l) / N;
			a[0] = l;
			for (int i = 1; i < a.length; i++) {
				a[i] = a[i - 1] + s;
			}
			return a;
		}

		static void histogram(double[] a, double[] b, double l, double h) {
			int[] c = new int[a.length - 1];
			for (int i = 0; i < b.length; i++) {
				for (int j = 0; j < a.length - 1; j++) {
					if (b[i] >= a[j] && b[i] < a[j + 1]) {
						c[j]++;
						continue;
					}
				}
			}
			int N = c.length;
			StdDraw.setXscale(0, (h - l) * 1.2);
			StdDraw.setYscale(0, b.length / N * 1.5);
			for (int i = 0; i < N; i++) {
				double x = l + (h - l) / N * i;
				double y = c[i] / 2.0;
				double rw = (h - l) / (2 * N);
				double rh = c[i] / 2.0;
				StdDraw.filledRectangle(x, y, rw, rh);
				StdOut.println(c[i] + " ");
			}
		}

		public static void main(String[] args) {
			int N = 10;
			int l = 2;
			int h = 20;
			double[] a = new double[N + 1];
			double[] b = new double[N * N * N];
			a = segmentation(N, l, h, a);
			for (int i = 0; i < b.length; i++) {
				b[i] = StdRandom.uniform(l, h);
			}
			histogram(a, b, l, h);
		}
	}

	static class C1_1_33 {
		static double dot(double[] x, double[] y) {
			double r = 0;
			for (int i = 0; i < x.length; i++) {
				r += x[i] * y[i];
			}
			return r;
		}

		// a = N*P b = P*M-->r = N*M;
		static double[][] mult(double[][] a, double[][] b) {
			int N = a.length;
			int M = b[0].length;
			int P = a[0].length;
			int P1 = b.length;
			double[][] r = new double[N][M];
			if (P != P1)
				throw new IllegalArgumentException();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					for (int k = 0; k < P; k++) {
						r[i][j] += a[i][k] * b[k][j];
					}
				}
			}
			return r;
		}

		static double[][] transpose(double[][] a) {
			double[][] r = new double[a.length][a[0].length];
			for (int i = 0; i < r.length; i++) {
				for (int j = 0; j < r[0].length; j++) {
					r[i][j] = a[j][i];
				}
			}
			return r;
		}

		// a = N*P b = P*1; r = N;
		static double[] mult(double[][] a, double[] y) {
			int N = a.length;
			double[] r = new double[N];
			int P = a[0].length;
			int P1 = y.length;
			if (P != P1)
				throw new IllegalArgumentException();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < P; j++) {
					r[i] += a[i][j] * y[j];
				}
			}
			return r;
		}

		// x = 1*P a = P*N;r=N;
		static double[] mult(double[] x, double[][] a) {
			int N = a[0].length;
			double[] r = new double[N];
			int P = x.length;
			int P1 = a.length;
			if (P != P1)
				throw new IllegalArgumentException();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < P; j++) {
					r[i] += x[j] * a[j][i];
				}
			}
			return r;
		}

		static double[][] matrix(int N, int M) {
			double[][] r = new double[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					r[i][j] = StdRandom.uniform(0, 10);
				}
			}
			return r;
		}

		static double[] vector(int N) {
			double[] r = new double[N];
			for (int i = 0; i < N; i++) {
				r[i] = StdRandom.uniform(0, 10);
			}
			return r;
		}

		static void print(double[][] matrix) {
			StdOut.println("matrix:");
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					StdOut.print(matrix[i][j] + " ");
				}
				StdOut.println();
			}
		}

		static void print(double[] vector) {
			StdOut.println("vector:");
			for (int i = 0; i < vector.length; i++) {
				StdOut.print(vector[i] + " ");
			}
			StdOut.println();
		}

		public static void main(String[] args) {
			double[][] a1 = matrix(2, 2);
			print(a1);
			double[][] a2 = matrix(2, 3);
			print(a2);
			double[][] a3 = mult(a1, a2);
			print(a3);

			double[] a4 = vector(2);
			print(a4);
			double[] a5 = mult(a4, a1);
			print(a5);
			double[] a6 = mult(a1, a4);
			print(a6);
		}
	}

	static class C1_1_34 {
		static double[] initData(int N) {
			double[] r = new double[N];
			for (int i = 0; i < r.length; i++) {
				r[i] = StdRandom.uniform();
			}
			return r;
		}

		static double min(double min, double input) {
			return input < min ? input : min;
		}

		static double max(double max, double input) {
			return input > max ? input : max;
		}

		// do not need array to store the inputs;
		// only nedd 2 vars to store min and max;
		static void printMinAndMax(double[] inputs) {
			double min = 0;
			double max = 0;
			for (int i = 0; i < inputs.length; i++) {
				min = min(min, inputs[i]);
				max = max(max, inputs[i]);
			}
			StdOut.println(String.format("min=%f,max=%f", min, max));
		}

		// need to store in array,need to sort first;
		static void printMedian(double[] inputs) {
			Arrays.sort(inputs);
			int length = inputs.length;
			double median = 0;
			median = (length % 2 == 0) ? (inputs[length / 2] + inputs[length / 2 - 1]) / 2 : inputs[length / 2];
			StdOut.println(String.format("midian=%f", median));
		}

		//
		static void printKmin(double[] inputs, int k) {
			int[] a = new int[k];
		}

		// only need r;
		static void printPows(double[] inputs) {
			double r = 0;
			for (int i = 0; i < inputs.length; i++) {
				r += Math.pow(inputs[i], 2);
			}
			StdOut.println(String.format("pows=%f", r));
		}

		static void avg(double[] inputs) {
			double r = 0;
			int length = inputs.length;
			for (int i = 0; i < length; i++) {
				r += inputs[i];
			}
			r = r / length;
			StdOut.println(String.format("avg=%f", r));
		}

		// need a array to store;
		static void printGreaterThanAVGPercentage(double[] inputs) {
			// 1、evaluate avg；

			// 2、count num;
		}

		// N;
		static void printASC(double[] inputs) {
			double[] r = new double[inputs.length];

		}
	}

	static class C1_1_35 {
		private static final int sides = 6;

		static double[] dist() {
			double[] dist = new double[2 * sides + 1];
			for (int i = 1; i <= sides; i++) {
				for (int j = 1; j <= sides; j++) {
					dist[i + j] += 1.0;
				}
			}
			for (int k = 2; k <= 2 * sides; k++) {
				dist[k] /= 6 * 6;
			}
			return dist;
		}

		static double[] toDo(int N) {
			StdOut.println(Arrays.toString(dist()));
			double[] a = new double[dist().length];
			for (int i = 1; i <= N; i++) {
				int s1 = StdRandom.uniform(1, 7);
				int s2 = StdRandom.uniform(1, 7);
				int r = s1 + s2;
				a[r] += 1;
			}
			for (int k = 2; k <= 2 * sides; k++) {
				a[k] /= N;
			}
			StdOut.println(Arrays.toString(a));
			return a;
		}

		public static void main(String[] args) {

			double[] dist = dist();
			for (int i = 0; i < dist.length; i++) {
				dist[i] = new BigDecimal(dist[i]).setScale(3, RoundingMode.DOWN).doubleValue();
			}
			int N = 1;
			while (true) {
				boolean matched = true;
				double[] toDo = toDo(N);
				for (int i = 0; i < toDo.length; i++) {
					toDo[i] = new BigDecimal(toDo[i]).setScale(3, RoundingMode.DOWN).doubleValue();
					if (toDo[i] != dist[i]) {
						matched = false;
						N++;
						break;
					}
				}
				if (matched) {
					StdOut.println(String.format("matched=%d", N));
					break;
				}
			}
		}
	}

	static class C1_1_36 {

		static int[] reset(int[] a) {
			for (int i = 0; i < a.length; i++) {
				a[i] = i;
			}
			return a;
		}

		static int[][] initTable(int M) {
			int[][] r = new int[M][M];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < M; j++) {
					r[i][j] = 0;
				}
			}
			return r;
		}

		static void print(int M, int[][] r) {
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < M; j++) {
					StdOut.print(r[i][j] + " ");
				}
				StdOut.println();
			}
		}

		public static void main(String[] args) {
			int M, N;
			StdOut.println("enter M:");
			M = StdIn.readInt();
			StdOut.println("enter N:");
			N = StdIn.readInt();
			int[][] r = initTable(M);
			int[] a = reset(new int[M]);
			for (int i = 0; i < N; i++) {
				StdRandom.shuffle(a);
				// C1_1_37.newShuffle(a);
				for (int j = 0; j < M; j++) {
					int t = a[j];
					r[j][t]++;
				}
				reset(a);
			}
			print(M, r);
		}
	}

	/**
	 * 
	 * @author dsk
	 * @see C1_1_36#main(String[]) to test;
	 */
	static class C1_1_37 {

		static void newShuffle(int[] a) {
			if (a == null)
				throw new IllegalArgumentException("argument array is null");
			int n = a.length;
			for (int i = 0; i < n; i++) {
				int r = StdRandom.uniform(n); // between i and n-1
				int temp = a[i];
				a[i] = a[r];
				a[r] = temp;
			}
		}
	}

	static class C1_1_38 {
		static int rank(int key, int[] a) {
			for (int i = 0; i < a.length; i++) {
				if (key == a[i])
					return i;
			}
			return -1;
		}

		public static void main(String[] args) {
			In in = new In(Constant.getParentPath() + "largeW.txt");
			int[] allLines = in.readAllInts();
			StdOut.println("enter key:");
			int key = StdIn.readInt();
			long start = System.currentTimeMillis();
			int index = rank(key, allLines);
			long end = System.currentTimeMillis();
			StdOut.println(String.format("key=%d,index=%d,time=%d", key, index, end - start));

			long start1 = System.currentTimeMillis();
			Arrays.sort(allLines);
			int index2 = BinarySearch.indexOf(allLines, key);
			long end1 = System.currentTimeMillis();
			StdOut.println(String.format("key=%d,index=%d,time=%d", key, index2, end1 - start1));
		}
	}

	static class C1_1_39 {
		static int bs(int N) {
			int[] a = new int[N];
			int[] b = new int[N];
			for (int i = 0; i < a.length; i++) {
				a[i] = StdRandom.uniform(100000, 1000000);
				b[i] = StdRandom.uniform(100000, 1000000);
			}
			Arrays.sort(b);
			int count = 0;
			for (int i = 0; i < N; i++) {
				int index = BinarySearch.indexOf(b, a[i]);
				if (index > 1)
					count++;
			}
			return count;
		}

		public static void main(String[] args) {
			int[] n = { 1000, 10000, 100000, 1000000 };
			StdOut.println("enter T:");
			int T = StdIn.readInt();
			for (int j = 0; j < n.length; j++) {
				StdOut.print("n=" + n[j] + " ");
				int count =0;
				for(int i=0;i<T;i++){
					count += bs(n[j]);
				}
				double avg = (double)count/T;
				StdOut.print("avg=" + avg);
				StdOut.println();
			}
		}
	}
}
