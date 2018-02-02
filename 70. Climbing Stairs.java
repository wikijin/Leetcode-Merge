/*
题意：
	爬楼梯。你需要爬N步到达梯子顶端。
	每次你只能爬一步或者两步。求有多少种不同的方式爬到梯子顶端。

思路：
	递归（recursion）与动态规划（DP）

Time Complexity : O(n)
Space Complexity : O(n)
*/
class Solution {
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