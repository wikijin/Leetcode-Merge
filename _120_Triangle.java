package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : Triangle
 * Creator : Edward
 * Date : Feb, 2018
 * Description : 120. Triangle
 */

public class Triangle {
	/*
	Given a triangle, find the minimum path sum from top to bottom.
	Each step you may move to adjacent numbers on the row below.
	For example, given the following triangle
		[
		     [2],
		    [3,4],
		   [6,5,7],
		  [4,1,8,3]
		]
	The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

	Note: Bonus point if you are able to do this using only O(n) extra space,
	where n is the total number of rows in the triangle.
	* @param list of list
	* @return int

	题意：
		三角形
		给一个list of list组成的三角形，找到自上而下最小的路径和。每一步移动必须是移动到下一行下标相邻的数字上。
		例子，如下三角形
		[
		     [2],
		    [3,4],
		   [6,5,7],
		  [4,1,8,3]
		]
		自上而下最小的路径和是2 + 3 + 5 + 1 = 11
		需要用O(n)的空间复杂度完成。

	思路：
		1. 自上而下的一维DP
			Time Complexity : O(n^2)
			Space Complexity : O(n)
	*/

	public int minimumTotal(List<List<Integer>> triangle) {
		int[] res = new int[triangle.size() + 1];
		for (int i = triangle.size() - 1; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				res[j] = Math.min(res[j], res[j + 1]) + triangle.get(i).get(j);
			}
		}
		return res[0];
	}
}
