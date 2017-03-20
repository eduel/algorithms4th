package com.juzi.chapter1_4;

import java.util.Arrays;

import com.juzi.Constant;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StaticSETofInts;
import edu.princeton.cs.algs4.StdOut;

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
							StdOut.printf("[%d,%d,%d,%d]\n", a[i], a[j], a[k],a[ind]);
					}
				}
			}
		}

		public static void main(String[] args) {
			int[] a = new In(Constant.getParentPath() + "1Kints.txt").readAllInts();
			fSum(a);
		}
	}

}