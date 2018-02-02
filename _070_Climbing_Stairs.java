package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ClimbingStairs
 * Creator : Edward
 * Date : Feb, 2018
 * Description : 70. Climbing Stairs
 */
public class ClimbingStairs {
	/*
	* You are climbing a stair case. It takes n steps to reach to the top.
	Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
	Note: Given n will be a positive integer.
	Example 1:
	Input: 2
	Output:  2
	Explanation:  There are two ways to climb to the top.
	1. 1 step + 1 step
	2. 2 steps

	题意：
		爬楼梯。你需要爬N步到达梯子顶端。
		每次你只能爬一步或者两步。求有多少种不同的方式爬到梯子顶端。

	思路：
		递归（recursion）
			Time Complexity : O(n)
			Space Complexity : O(n)
		动态规划（DP）
			Time Complexity : O(n)
			Space Complexity : O(n)
	*/

	public int climbStairs(int n) {
		// corner case
		if (n <= 2) {
			return n;
		} else {
			return climbStairs(n - 1) + climbStairs(n - 2);
		}
	}

	public int climbStairs2(int n) {
		if (n <= 1) {
			return 1;
		}
		int oneStep = 1;
		int twoStep = 1;
		int res = 0;
		for (int i = 2; i <= n; i++) {
			res = oneStep + twoStep;
			twoStep = oneStep;
			oneStep = res;
		}
		return res;
	}
}