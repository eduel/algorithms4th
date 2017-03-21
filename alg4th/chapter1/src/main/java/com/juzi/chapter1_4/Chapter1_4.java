package com.juzi.chapter1_4;

import java.util.Arrays;

import com.juzi.Constant;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StaticSETofInts;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Chapter1_4 {

	static class C1_4_1 {
		//if n=3 ,n(n-1)(n-2)/6=1
		//n=k,k(k-1)(k-2)/6
		//n=k+1 k(k-1)(k-2)/6 + k(k-1)/2 = k(k-1)(k+1)/6
	}

	static class C1_4_2 {
		//use BigInteger;

	}

	static class C1_4_3 {
	}

	static class C1_4_4 {
	}

	static class C1_4_5 {
		//N
		//1
		//1
		//N3
		//1
		//1
		//?
	}

	static class C1_4_6 {
		//N2
		//N2
		//N2*log2N;
	}

	static class C1_4_7 {

	}

	static class C1_4_8 {
		public static void main(String[] args) {
			In in = new In(Constant.getParentPath() + "2Kints.txt");
			int[] data = in.readAllInts();
			int count = 0;
			for (int i = 0; i < data.length; i++) {
				for (int j = i + 1; j < data.length; j++) {
					if (data[i] + data[j] == 0) {
						count++;
					}
				}
			}
			StdOut.println("count:" + count);//N2;

			Arrays.sort(data);
			int countB = 0;
			for (int i = 0; i < data.length; i++) {
				if (BinarySearch.indexOf(data, -data[i]) > i) {
					countB++;
				}
			}
			StdOut.println("countB:" + countB);
		}
	}

	static class C1_4_9 {
		public static void main(String[] args) {
			//ratio
		}
	}

	static class C1_4_10 {
		static int rank(int[] a, int key) {
			int lo = 0;
			int hi = a.length - 1;
			int ret = -1;
			while (lo <= hi) {
				int mid = lo + (hi - lo) / 2;
				StdOut.printf("[%d,%d]\n", lo, hi);
				if (key < a[mid]) {
					hi = mid - 1;
				} else if (key > a[mid]) {
					lo = mid + 1;
				} else {
					ret = mid;
					hi = mid - 1;
				}
			}
			return ret;
		}

		public static void main(String[] args) {
			int[] a = { 1, 2, 2, 2, 4 };
			int ret = rank(a, 2);
			StdOut.println(ret);

		}
	}

	static class C1_4_11 {//?where is 1.2.15
		static class C1411StaticSETofInts extends StaticSETofInts {
			public C1411StaticSETofInts(int[] keys) {
				super(keys);
			}

			public int howmany(int[] a, int key) {

				int lo = 0;
				int hi = a.length - 1;
				int ret = 0;
				while (lo <= hi) {
					int mid = lo + (hi - lo) / 2;
					StdOut.printf("[%d,%d]\n", lo, hi);
					if (key < a[mid]) {
						hi = mid - 1;
					} else if (key > a[mid]) {
						lo = mid + 1;
					} else {
						ret++;
						hi = mid - 1;
					}
				}
				return ret;
			}
		}

		public static void main(String[] args) {
			int[] a = new int[] { 1, 2, 2, 2, 4 };
			C1411StaticSETofInts c = new C1411StaticSETofInts(a);
			int kc = c.howmany(a, 2);
			StdOut.println("keyCount:" + kc);

		}
	}

	static class C1_4_12 {
		static void printSame(int[] sortedA, int[] sortedB) {
			int i = 0;
			int j = 0;
			int k = 0;
			int loop = 0;
			while (i < sortedA.length && j < sortedB.length) {
				if (sortedA[i] < sortedB[j]) {
					i++;
				} else if (sortedA[i] > sortedB[j]) {
					j++;
				} else {
					StdOut.println(sortedA[i]);
					i++;
					j++;
					k++;
				}
				loop++;
			}
			StdOut.println("k:" + k + "loop:" + loop);
		}

		public static void main(String[] args) {
			int[] a = new In(Constant.getParentPath() + "1Kints.txt").readAllInts();
			Arrays.sort(a);
			int[] b = a;
			printSame(a, b);
		}
	}

	static class C1_4_13 {//for 64bit computer;
		//16+4+8+8+4
		//16+8+8++8,24+2n(string),16+8+8+8(date);
		//16+24+4+4+8C,24+2n+padding;
		//16+8+8
		//16+8+8
		//16+8+8,16*2+16*2
		//16+8;
	}

	static class C1_4_14 {
		static void fSum(int[] a) {
			int l = a.length;
			for (int i = 0; i < l; i++) {
				for (int j = i + 1; j < l; j++) {
					for (int k = j + 1; k < l; k++) {
						int ind = BinarySearch.indexOf(a, -(a[i] + a[j] + a[k]));
						if (ind > k)
							StdOut.printf("[%d,%d,%d,%d]\n", a[i], a[j], a[k], a[ind]);
					}
				}
			}
		}

		public static void main(String[] args) {
			int[] a = new In(Constant.getParentPath() + "1Kints.txt").readAllInts();
			fSum(a);
		}
	}

	static class C1_4_15 {
		static void f2sum(int[] a) {
			int le = a.length;
			Arrays.sort(a);
			int i = 0;
			int j = le - 1;
			int k = 0;
			int c = 0;
			while (i != j) {
				if (-a[i] > a[j]) {
					i++;
				} else if (-a[i] < a[j]) {
					j--;
				} else {
					StdOut.printf("[%d,%d]\n", a[i], a[j]);
					i++;
					j--;
					k++;
				}
				c++;
			}
			StdOut.printf("sumCount:%d,loop:%d\n", k, c);
		}

		static void f3sum(int[] a) {
			int le = a.length;
			int le2 = le * (le - 1) / 2;
			int[] b = new int[le2];
			int m = 0;
			for (int i = 0; i < le; i++) {
				for (int j = i + 1; j < le; j++) {
					b[m++] = a[i] + a[j];
				}
			}
			Arrays.sort(a);
			Arrays.sort(b);
			int i = 0;
			int j = le2 - 1;
			int k = 0;
			int c = 0;
			while (i < le && j >= 0) {
				if (-a[i] > b[j]) {
					i++;
				} else if (-a[i] < b[j]) {
					j--;
				} else {
					StdOut.printf("[%d]\n", a[i]);
					i++;
					j--;
					k++;
				}
				c++;
			}
			StdOut.printf("sumCount:%d,loop:%d\n", k, c);
		}

		public static void main(String[] args) {
			int[] a = new In(Constant.getParentPath() + "4Kints.txt").readAllInts();
			f2sum(a);
			f3sum(a);
			int[] b = { -10, -8, -6, -4, -2, -1, 0, 1, 3, 5, 6, 8, 10 };
			f2sum(b);
			f3sum(b);
		}
	}

	static class C1_4_16 {
		//差的绝对值，还是绝对值的差啊？//差的绝对值
		static void closestPair(double[] a) {
			Arrays.sort(a);
			int le = a.length;
			int i = 0;
			double abs = 0;
			int j = 0;
			while (i < le - 1) {
				double v = Math.abs(a[i] - a[i + 1]);
				if (v < abs) {
					abs = v;
					j = i;
				}
				i++;
			}
			StdOut.printf("[%f,%f]\n", a[j], a[j + 1]);
		}

		//绝对值的差
		static void closePair(double[] a) {
			int le = a.length;
			double abs = 0;

		}

		public static void main(String[] args) {
			double[] a = new double[100];
			for (int i = 0; i < 100; i++) {
				a[i] = StdRandom.uniform(-100, 100);
			}
			closestPair(a);
		}
	}

	static class C1_4_17 {

	}

	static class C1_4_18 {
		static int part(int[] a, int s, int e) {
			int le = a.length;
			if (le == 1)
				return 0;
			if (le == 2)
				return a[0] < a[1] ? 0 : 1;
			int mid = s + (e - s) / 2;
			if (a[mid] < a[mid - 1] && a[mid] < a[mid + 1]) {
				StdOut.printf("mid=%d,[%d,%d,%d]\n", mid, a[mid - 1], a[mid], a[mid + 1]);
				return mid;
			}
			if (a[mid] > a[mid - 1])
				return part(a, s, mid + 1);
			if (a[mid] > a[mid + 1])
				return part(a, mid - 1, e);
			return -1;

		}

		static int partNoRecursive(int[] a) {
			int le = a.length;
			if (le == 1)
				return 0;
			if (le == 2)
				return a[0] > a[1] ? 1 : 0;
			int s = 0;
			int e = le - 1;
			while (s < e) {
				int mid = s + (e - s) / 2;
				if (a[mid] < a[mid - 1] && a[mid] < a[mid - 1]) {
					StdOut.printf("mid=%d,[%d,%d,%d]\n", mid, a[mid - 1], a[mid], a[mid + 1]);
					return mid;
				}
				if (a[mid] > a[mid - 1]) {
					e = mid + 1;
				} else if (a[mid] > a[mid - 1]) {
					s = mid - 1;
				}
			}
			return -1;
		}

		public static void main(String[] args) {
			int[] a = new In(Constant.getParentPath() + "4Kints.txt").readAllInts();
			int[] b = { 8, 3, 2, 4, 5, 6, 7, 9, 19, 25, 14, 16, 11 };
			part(b, 0, b.length - 1);
			part(a, 0, a.length - 1);
			partNoRecursive(b);
			partNoRecursive(a);
		}
	}

	static class C1_4_19 {
		static int matrixN2(int[][] a) {
			int mL = a.length;
			if (mL < 3)
				return -1;//小于3阶不管
			for (int i = 1; i < mL - 2; i++) {
				for (int j = 1; j < mL - 2; j++) {
					int mid = a[i][j];
					int u = a[i][j - 1];
					int d = a[i][j + 1];
					int l = a[i - 1][j];
					int r = a[i + 1][j];
					if (mid < u && mid < d && mid < l && mid < r)
						return mid;
				}
			}
			return -1;
		}
		static void matrix(int[][] a){
			
		}
	}

}