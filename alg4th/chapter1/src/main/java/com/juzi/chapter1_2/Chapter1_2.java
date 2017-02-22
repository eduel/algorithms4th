package com.juzi.chapter1_2;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

import com.juzi.Constant;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Transaction;

public class Chapter1_2 {

	static class C1_2_1 {
		static double findMinDistance(int N) {
			Point2D[] points = new Point2D[N];
			for (int i = 0; i < N; i++) {
				double x = StdRandom.uniform(1, 100);
				double y = StdRandom.uniform(1, 100);
				points[i] = new Point2D(x, y);
			}
			double minDistance = 100 * 100;
			Point2D a, b = null;
			// !N
			for (int i = 0; i < N - 1; i++) {
				a = points[i];
				for (int j = i + 1; j < N; j++) {
					b = points[j];
					if (i == j || a.equals(b))// the same point;
						continue;

					double d = a.distanceTo(b);
					minDistance = d < minDistance ? d : minDistance;
				}
			}
			return minDistance;
		}

		public static void main(String[] args) {
			StdOut.println("enter N:");
			int N = StdIn.readInt();
			double minDistance = findMinDistance(N);
			StdOut.println(String.format("minDistance=%f", minDistance));
		}
	}

	static class C1_2_2 {
		static String createInput(int N) {
			StringBuilder input = new StringBuilder();
			for (int i = 0; i < N; i++) {
				int d1 = StdRandom.uniform(1, 100);
				int d2 = StdRandom.uniform(1, 100);
				input.append(Math.min(d1, d2) + Constant.WHITE_SPACE + Math.max(d1, d2) + Constant.LINE_SEPARATOR);
			}
			return input.toString();
		}

		static void printIntersets(Interval1D[] interval1ds) {
			int N = interval1ds.length;
			Interval1D a, b = null;
			int count = 0;
			// N!
			for (int i = 0; i < N - 1; i++) {
				a = interval1ds[i];
				for (int j = i + 1; j < N; j++) {
					b = interval1ds[j];
					if (i == j) {
						continue;
					}
					boolean isInter = a.intersects(b);
					if (isInter) {
						count++;
						StdOut.println(String.format("a=%s,b=%s,index=%d", a.toString(), b.toString(), count));
					}
				}
			}
		}

		public static void main(String[] args) {
			StdOut.println("enter N:");
			int N = StdIn.readInt();
			In in = new In(new Scanner(new ByteArrayInputStream(createInput(N).getBytes(StandardCharsets.UTF_8))));
			String[] inputs = in.readAllLines();
			Interval1D[] interval1ds = new Interval1D[N];
			for (int i = 0; i < N; i++) {
				String toSplit = inputs[i];
				String[] splited = toSplit.split(Constant.WHITE_SPACE);
				double min = Double.valueOf(splited[0]);
				double max = Double.valueOf(splited[1]);
				interval1ds[i] = new Interval1D(min, max);
			}
			printIntersets(interval1ds);
		}
	}

	// TODO
	static class C1_2_3 {
		static Interval2D[] createInterval2Ds(int N, double min, double max) {
			Interval2D[] interval2ds = new Interval2D[N];
			for (int i = 0; i < N; i++) {
				double minX = StdRandom.uniform(min, max + 1);
				double maxX = StdRandom.uniform(min, max + 1);
				double minY = StdRandom.uniform(min, max + 1);
				double maxY = StdRandom.uniform(min, max + 1);
				Interval1D x = new Interval1D(Math.min(minX, maxX), Math.max(minX, maxX));
				Interval1D y = new Interval1D(Math.min(minY, maxY), Math.max(minY, maxY));
				interval2ds[i] = new Interval2D(x, y);
			}
			return interval2ds;
		}

		static void draw(Interval2D[] interval2ds) {
			StdDraw.setPenRadius(0.001);
			StdDraw.setPenColor(Color.RED);
			StdDraw.setXscale(0, 100);
			StdDraw.setYscale(0, 100);

			int N = interval2ds.length;
			for (int i = 0; i < N; i++) {
				interval2ds[i].draw();
			}
			int intersectsCounts = 0, containsCounts = 0;// ???do not exposure x
															// and y?
			Interval2D a = null, b = null;
			for (int i = 0; i < N - 1; i++) {
				a = interval2ds[i];
				for (int j = i + 1; j < N; j++) {
					b = interval2ds[j];
					if (a.intersects(b)) {
						intersectsCounts++;
					}
				}
			}
			StdOut.println("intersectsCount:" + intersectsCounts);
		}

		public static void main(String[] args) {
			StdOut.println("enter N:");
			int N = StdIn.readInt();
			StdOut.println("enter min:");
			double min = StdIn.readDouble();
			StdOut.println("enter max:");
			double max = StdIn.readDouble();
			draw(createInterval2Ds(N, min, max));
		}
	}

	static class C1_2_4 {
		static void print() {
			String string1 = "hello";
			String string2 = string1;
			string1 = "world";
			StdOut.println(string1);
			StdOut.println(string2);
		}

		public static void main(String[] args) {
			print();
		}
	}

	static class C1_2_5 {
		static void print() {
			String s = "Hello World";
			s.toUpperCase();
			s.substring(6, 11);
			StdOut.println(s);
		}

		static void changeSToPrint() {
			String s = "Hello World";
			s = s.toUpperCase();
			StdOut.println(s);
			s = s.substring(6, 11);
			StdOut.println(s);
		}

		public static void main(String[] args) {
			print();
			changeSToPrint();
		}
	}

	// circular rotation;
	static class C1_2_6 {
		static boolean cr(String s, String t) {
			return (s.length() == t.length()) && (s.concat(s).indexOf(t) > 0);
		}

		public static void main(String[] args) {
			String s = "ABCDE";
			String t = "DEABC";
			StdOut.println(cr(s, t));
		}
	}

	static class C1_2_7 {
		// reverse;
		static String mystery(String s) {
			int N = s.length();
			if (N <= 1)
				return s;
			String a = s.substring(0, N / 2);
			String b = s.substring(N / 2, N);// [a,b);
			return mystery(b) + mystery(a);
		}

		public static void main(String[] args) {
			String s = "ABCDEF";
			StdOut.println(mystery(s));
			String s2 = "abcdefghijklmnop";
			StdOut.println(mystery(s2));
		}
	}

	static class C1_2_8 {
		//
		static void referenceSwap(int[] a, int[] b) {
			int[] t = a;
			a = b;
			b = t;
		}
	}

	static class C1_2_9 {
		static int indexOf(int[] a, int key, Counter counter) {
			int lo = 0;
			int hi = a.length - 1;
			while (lo <= hi) {
				// Key is in a[lo..hi] or not present.
				int mid = lo + (hi - lo) / 2;
				counter.increment();
				if (key < a[mid])
					hi = mid - 1;
				else if (key > a[mid])
					lo = mid + 1;
				else
					return mid;
			}
			return -1;
		}

		public static void main(String[] args) {
			Counter counter = new Counter("key counter");
			In in = new In(Constant.getParentPath() + "largeW.txt");
			int[] ints = in.readAllInts();
			Arrays.sort(ints);
			StdOut.println("enter key:");
			int key = StdIn.readInt();
			int index = indexOf(ints, key, counter);
			StdOut.println(String.format("find key=%d in index=%d use %d times", key, index, counter.tally()));
		}
	}

	// ???
	static class C1_2_10 {
		static class VisualCounter {
			int N;
			int max;
			int count;
			int operationCount;

			public VisualCounter(int N, int max) {
				this.N = N;
				this.max = max;
			}

			void increment() {
				check();
				count++;
				operationCount++;
			}

			void decrement() {
				count--;
			}

			void reset() {
				count = 0;
				operationCount = 0;
			}

			void check() {
				if (count == max || operationCount == N)
					throw new UnsupportedOperationException();
			}
		}
	}

	// TODO
	static class C1_2_11 {

	}

	// TODO
	static class C1_2_12 {

	}

	static class C1_2_13 {
		public static void main(String[] args) {
			Transaction transaction;
		}
	}

	static class C1_2_14 {
		public static void main(String[] args) {
			Transaction t = new Transaction("eduel", new Date("02/22/2017"), 9527.77);
			Transaction t2 = new Transaction("eduel", new Date("02/22/2017"), 9527.77);
			StdOut.println(t.equals(t2));
		}
	}

	static class C1_2_15 {
		// only supporte use \\s as split char;
		static int[] readInts(String name) {
			In in = new In(name);
			String input = in.readAll();
			String[] splited = input.split("\\s+");//
			int[] ints = new int[splited.length];
			for (int i = 0; i < ints.length; i++) {
				ints[i] = Integer.valueOf(splited[i]);
			}
			return ints;
		}
	}

	static class C1_2_16 {
		static class Rational {
			int numerator;
			int denomerator;

			public Rational(int numerator, int denomerator) {
				super();
				this.numerator = numerator;
				this.denomerator = denomerator;
			}

			//TODO
			Rational plus(Rational b) {
				return null;
			}

			static long gcd(long p, long q) {
				if (q == 0)
					return p;
				if (p % q == 0)
					return q;
				while (q > 0) {
					long r = p % q;
					p = q;
					q = r;
				}
				return p;
			}
		}
	}

}
