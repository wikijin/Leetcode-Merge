package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : UniquePaths
 * Creator : Edward
 * Date : Feb, 2018
 * Description : 63. Unique Paths II
 */

public class UniquePathsII {
	/*
	Follow up for "Unique Paths":
	Now consider if some obstacles are added to the grids. How many unique paths would there be?
	An obstacle and empty space is marked as 1 and 0 respectively in the grid.

	For example, there is one obstacle in the middle of a 3x3 grid as illustrated below.
	[
		[0,0,0],
		[0,1,0],
		[0,0,0]
	]
	The total number of unique paths is 2.
	Note: m and n will be at most 100.

	* @param m, n
	* @return int

	题意：
		特别路径II
		一个机器人需要从一个mxn的棋盘的左上角走到右下角
		棋盘中有障碍物，障碍物用1表示；0代表没有障碍物
		机器人每次只能向下或者向右走一步
		求有多少种不同的走法/路径

		举例，如下3x3的棋盘
		[
			[0,0,0],
			[0,1,0],
			[0,0,0]
		]
		特别路径为2

	思路：
		根据版本I的解法，直接给出的一维DP
			Time Complexity : O(m*n)
			Space Complexity : O(n)
	*/

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int len = obstacleGrid[0].length;
		int[] res = new int[len];
		res[0] = 1;
		for (int i = 0; i < obstacleGrid.length; i++) {
			for (int j = 0; j < obstacleGrid[0].length; j++) {
				if (obstacleGrid[i][j] == 1) {
					res[j] = 0;
				} else if (j > 0) {
					res[j] += res[j - 1];
				}
			}
		}
		return res[len - 1];
	}
}
