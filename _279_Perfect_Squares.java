package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : Triangle
 * Creator : Edward
 * Date : Feb, 2018
 * Description : 279. Perfect Squares
 */

public class PerfectSquares {
	/*
	Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...)
	which sum to n.
	For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
	time : O(n * sqrt(n))
	space: O(n)
	* @param n
	* @return

	题意：
		完美平方数
		给一个正整数n，找到最少的完全平方数的和能凑成n（比如，1，4，9，16……）
		举例，n = 12，返回3，因为12 = 4 + 4 + 4;
		n = 13，返回2，因为13 = 4 + 9

	思路：
		1. 一维DP
			Time Complexity : O(n^2)
			Space Complexity : O(n)
	*/

	public int numSquares(int n) {
		int[] res = new int[n + 1];
		Arrays.fill(res, Integer.MAX_VALUE);
		res[0] = 0;
		for (int i = 0; i <= n; i++) {
			for (int j = 1; j * j <= i; j++) {
				res[i] = Math.min(res[i], res[i - j * j] + 1);
			}
		}
		return res[n];
	}
}
