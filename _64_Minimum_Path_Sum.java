public class _64_Minimum_Path_Sum {
    /**
     Given a m x n grid filled with non-negative numbers,
     find a path from top left to bottom right which minimizes the sum of all numbers along its path.
     Note: You can only move either down or right at any point in time.
     Example 1:
     [[1,3,1],
     [1,5,1],
     [4,2,1]]
     Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.



     题意：
        有一个m x n的非负矩阵，找一条从左上到右下的路径，使路过的和最小


     思路：
        典型的动态规划，直接在给出的矩阵上修改，如果是第一行只能往下走，如果是第一列只能往右走，其他情况下，每一步可以向右走或者向下走，
        最后选取结果的最小值


     复杂度：
        time : O(m * n)
        space : O(1)
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j != 0) grid[i][j] += grid[i][j - 1];
                if (i != 0 && j == 0) grid[i][j] += grid[i - 1][j];
                if (i != 0 && j != 0) {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
