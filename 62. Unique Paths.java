/*
题意：
	特别路径
	一个机器人需要从一个mxn的棋盘的左上角走到右下角
	机器人每次只能向下或者向右走一步
	求有多少种不同的走法/路径

思路：
	1. 二维DP
		Time Complexity : O(n^2)
		Space Complexity : O(n^2)
	2. 更好的二维DP
		Time Complexity : O(n^2)
		Space Complexity : O(n)
	3. 排列组合法
		Time Complexity : O(n)
		Space Complexity : O(1)
*/
class Solution {
	public int uniquePaths(int m, int n) {
		int[][] res = new int[m][n];
		// 第一行和第一列所有都初始化为1
		for (int i = 0; i < m; i++) {
			res[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			res[0][i] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				res[i][j] = res[i - 1][j] + res[i][j - 1];
			}
		}
		return res[m - 1][n - 1];
	}

	public int uniquePaths2(int m, int n) {
		int[] res = new int[n];
		res[0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 1; j < n; j++) {
				res[j] = res[j] + res[j - 1];
			}
		}
		return res[n - 1];
	}

	public int uniquePaths3(int m, int n) {
		int count = m + n - 2;
		int k = m - 1;
		double res = 1;
		for (int i = 1; i <= k; i++) {
			res = res * (count - k + i) / i;
		}
		return (int)res;
	}
}