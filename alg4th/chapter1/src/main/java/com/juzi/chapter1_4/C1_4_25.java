package com.juzi.chapter1_4;

import static java.lang.Math.sqrt;

import edu.princeton.cs.algs4.StdOut;

//throw 2 eggs
//题目不是太清楚
public class C1_4_25 {

	//dynamic programming;DP;
	//2sqrtN
	//return max step;
	public static int dp(int n) {
		int step = (int) sqrt(n);//
		int start = step;
		int sum = 0;
		while (start <= n) {
			//broken
			//not broken
			start += step;
			sum ++;
		}
		sum += (start-1) - (start-step +1);
		return sum;
	}
	public static void main(String[] args) {
		StdOut.println(dp(100));
	}
}
