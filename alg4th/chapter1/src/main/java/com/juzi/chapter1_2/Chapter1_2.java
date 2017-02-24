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
			static Rational ZERO = new Rational(0, 1);

			// can not input a irrational number;
			public Rational(int numerator, int denomerator) {
				if (denomerator <= 0)
					throw new ArithmeticException("denomerator can not be negative or zero");
				long gcd = gcd(Math.abs(numerator), denomerator);
				if (numerator != 0 && gcd != 1)
					throw new ArithmeticException("gcd is not 1");
				this.numerator = numerator;
				this.denomerator = denomerator;
			}

			Rational plus(Rational b) {
				long p = this.numerator * b.denomerator + b.numerator * this.denomerator;
				long q = this.denomerator * b.denomerator;
				long gcd = gcd(Math.abs(p), q);

				p = p / gcd;
				q = q / gcd;
				return new Rational((int) p, (int) q);
			}

			Rational minus(Rational b) {
				return this.plus(new Rational(-b.numerator, b.denomerator));
			}

			Rational times(Rational b) {
				long p = this.numerator * b.numerator;
				long q = this.denomerator * b.denomerator;
				long gcd = gcd(p, q);
				p = p / gcd;
				q = q / gcd;
				return new Rational((int) p, (int) q);
			}

			Rational divides(Rational b) {
				return times(new Rational(b.denomerator, b.numerator));
			}

			static long gcd(long p, long q) {
				if (q == 0)
					return p;
				if (p % q == 0)
					return q;
				while (q != 0) {
					long r = p % q;
					p = q;
					q = r;
				}
				return p;
			}

			@Override
			public boolean equals(Object other) {
				if (this == other)
					return true;
				if (other == null)
					return false;
				if (this.getClass() != other.getClass())
					return false;
				Rational that = (Rational) other;
				return this.minus(that).numerator == 0;
			}

			@Override
			public String toString() {
				return "" + this.numerator + "/" + this.denomerator;
			}

			public static void main(String[] args) {
				// for one zero;
				Rational r1 = new Rational(0, 5);
				Rational r2 = new Rational(2, 3);
				StdOut.println(r1.plus(r2));
				// //for normal;
				Rational r3 = new Rational(-2, 3);
				Rational r4 = new Rational(-3, 2);
				StdOut.println(r3.plus(r4));
				// for gcd;
				Rational r5 = new Rational(2, 3);
				Rational r6 = new Rational(3, 5);
				StdOut.println(r5.plus(r6));
				// for minus;
				StdOut.println(r5.minus(r6));
				StdOut.println(r5.times(r6));
				StdOut.println(r5.divides(r6));
				StdOut.println(r1.equals(ZERO));
			}
		}
	}

	/**
	 * @see C1_2_16
	 * @author eduel
	 *
	 */
	static class C1_2_17 {

	}

	static class C1_2_18 {
		static class Accumulator {
			double m;
			double s;
			int N;

			void addDataValue(double x) {
				N++;
				s = s + 1.0 * (N - 1) / N * (x - m) * (x - m);
				m = m + (x - m) / N;
			}

			double mean() {
				return m;
			}

			double var() {
				return s / N - 1;
			}

			double stddev() {
				return Math.sqrt(var());
			}
		}

		static class Accumulator2 {
			double[] xs;

			Accumulator2(double[] xs) {
				this.xs = xs;
			}

			double var() {
				int m = 0;
				double sum = 0;
				double avg = 0;
				int N = xs.length;
				for (int i = 0; i < N; i++) {
					sum += xs[i];
				}
				avg = sum / N;
				for (int i = 0; i < N; i++) {
					m += (avg - xs[i]) * (avg - xs[i]);
				}
				m /= N - 1;// 标准差N,样本标准差N-1;
				return m;
			}

			double stddev() {
				return Math.sqrt(var());
			}
		}

		static double[] initData(int N) {
			double[] xs = new double[N];
			for (int i = 0; i < N; i++) {
				xs[i] = StdRandom.uniform(0, 50);
			}
			return xs;
		}

		public static void main(String[] args) {
			int N = 100;
			double[] xs = initData(N);
			Accumulator ac1 = new Accumulator();
			for (int i = 0; i < N; i++) {
				ac1.addDataValue(xs[i]);
			}
			StdOut.printf("ac1 cal mean=%f,stddev=%f\n", ac1.var(), ac1.stddev());
			Accumulator2 ac2 = new Accumulator2(xs);
			StdOut.printf("ac2 cal mean=%f,stddev=%f", ac2.var(), ac2.stddev());
		}
	}

	/**
	 * 
	 * @author dsk
	 * @see Date
	 * @see Transaction
	 */
	static class C1_2_19 {

	}

}
